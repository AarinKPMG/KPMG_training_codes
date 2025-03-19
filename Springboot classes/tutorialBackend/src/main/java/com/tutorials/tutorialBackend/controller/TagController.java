package com.tutorials.tutorialBackend.controller;

import com.tutorials.tutorialBackend.exception.ResourceNotFoundException;
import com.tutorials.tutorialBackend.model.Tag;
import com.tutorials.tutorialBackend.model.Tutorial;
import com.tutorials.tutorialBackend.repository.TagRepository;
import com.tutorials.tutorialBackend.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class TagController {

    @Autowired
    private TutorialRepository tutorialRepository ;

    @Autowired
    private TagRepository tagRepository ;

    @PostMapping("/tutorials/{tutorialId}/tags")
    public ResponseEntity<Tag> addTag(
            @PathVariable("tutorialId") long tutorialId ,
            @RequestBody Tag tagRequest
    ){

        Tag tag = tutorialRepository.findById(tutorialId)
                .map( tutorial -> {
                    tutorial.addTag(tagRequest);
                    return tagRepository.save(tagRequest);
                })
                .orElseThrow(
                        ()->new ResourceNotFoundException("No Tutorial found with ID :" + tutorialId)
                );

        return new ResponseEntity<>(tag , HttpStatus.CREATED);
    }

    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> getAllTags(){

        List<Tag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);

        if(tags.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tags, HttpStatus.OK);

    }

    @GetMapping("/tutorials/{tutorialId}/tags")
    public ResponseEntity<List<Tag>> getAllTagsByTutorialId(
            @PathVariable(value="tutorialId") long tutorialId
    ) throws ResourceNotFoundException {

        if(!tutorialRepository.existsById(tutorialId)){
            throw new ResourceNotFoundException("No Tutorial Found with ID : "+tutorialId);
        }

        List<Tag> tags = tagRepository.findTagsByTutorialsId(tutorialId);
        return new ResponseEntity<>(tags, HttpStatus.OK);

    }

    @PutMapping("/tags/{id}")
    public ResponseEntity<Tag> updateTagById(
            @PathVariable(value="id") long id ,
            @RequestBody Tag tagRequest
    ) throws ResourceNotFoundException {

        Tag tag = tagRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Tag with ID : "+id + " not found ")
                );

        tag.setName(tagRequest.getName());
        return new ResponseEntity<>(tagRepository.save(tag), HttpStatus.OK);

    }

    @DeleteMapping("/tutorials/{tutorialId}/tags/{tagsId}")
    public ResponseEntity<HttpStatus> deleteTagFromTutorial(
            @PathVariable(value = "tutorialId") long tutorialId,
            @PathVariable(value = "tagsId") long tagsId
    ) throws ResourceNotFoundException {

        Tutorial tutorial = tutorialRepository.findById(tutorialId)
                .orElseThrow( ()-> new ResourceNotFoundException("tutorial with id : "+tutorialId + "not found !"));

        tutorial.removeTag(tagsId);
        tutorialRepository.save(tutorial);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/tags/{tagsId}")
    public ResponseEntity<HttpStatus> deleteTag(@PathVariable(value = "tagsId") long tagsId){

        tagRepository.deleteById(tagsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



}
