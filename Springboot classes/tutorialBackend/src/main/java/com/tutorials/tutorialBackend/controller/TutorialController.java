package com.tutorials.tutorialBackend.controller;

import com.tutorials.tutorialBackend.exception.ResourceNotFoundException;
import com.tutorials.tutorialBackend.model.Tutorial;
import com.tutorials.tutorialBackend.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    private TutorialRepository tutorialRepository;

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        Tutorial _tutorial = tutorialRepository.save(
                new Tutorial(tutorial.getTitle() , tutorial.getDescription() , tutorial.isPublished() )
        );

        return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    }

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(
        @RequestParam(required=false) String title){

            List<Tutorial> tutorials = new ArrayList<>();

            if(title==null){
                tutorialRepository.findAll().forEach(tutorials::add);
            }
            else{
                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
            }

            if(tutorials.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

//    It will only send single json object , where we need to send a array of json of object :

//    @GetMapping("/tutorials/title/{title}")
//    public ResponseEntity<Tutorial> getTutorialByTitle(@PathVariable("title") String title)
//            throws ResourceNotFoundException {
//
//        Tutorial tutorial = tutorialRepository.findByTitle(title)
//                .orElseThrow(() -> new ResourceNotFoundException("No Tutorial Found with title: " + title));
//
//        return new ResponseEntity<>(tutorial, HttpStatus.OK);
//    }

    @GetMapping("/tutorials/title/{title}")
    public ResponseEntity<List<Tutorial>> getTutorialsByTitle(@PathVariable("title") String title) {
        List<Tutorial> tutorials = tutorialRepository.findByTitleContaining(title);

        if (tutorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id )
        throws ResourceNotFoundException {

        Tutorial _tutorial = tutorialRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No Tutorial Found With id : "+id));
        return new ResponseEntity<>(_tutorial , HttpStatus.OK);
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(
            @PathVariable("id") long id , @RequestBody Tutorial tutorial ) throws ResourceNotFoundException {

        Tutorial _tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No Tutorial Found with ID : " + id
                ));
        _tutorial.setTitle(tutorial.getTitle());
        _tutorial.setDescription(tutorial.getDescription());
        _tutorial.setPublished(tutorial.isPublished());

        return new ResponseEntity<>(tutorialRepository.save(_tutorial),
                HttpStatus.OK);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id ){
        if( tutorialRepository.existsById(id) ){
           tutorialRepository.deleteById(id);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished(){
        List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

        if(tutorials.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.NO_CONTENT);
    }

}


