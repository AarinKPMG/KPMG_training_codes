package com.tutorials.tutorialBackend.controller;

import com.tutorials.tutorialBackend.exception.ResourceNotFoundException;
import com.tutorials.tutorialBackend.model.Comment;
import com.tutorials.tutorialBackend.repository.CommentRepository;
import com.tutorials.tutorialBackend.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private TutorialRepository tutorialRepository ;

    @Autowired
    private CommentRepository commentRepository ;

    @PostMapping("/tutorials/{tutorialId}/comments")
    public ResponseEntity<Comment> createComment(
            @PathVariable(value="tutorialId") long tutorialId ,
            @RequestBody Comment commentRequest
    ) throws ResourceNotFoundException {

        Comment comment = tutorialRepository.findById(tutorialId)
                .map(tutorial -> {
                    commentRequest.setTutorial(tutorial);
                    return commentRepository.save(commentRequest);
                }).orElseThrow(()->
                        new ResourceAccessException("No tutorial found with ID : "+tutorialId));

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/tutorials/{tutorialId}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(
            @PathVariable(value="tutorialId")  long tutorialId
    ) throws ResourceNotFoundException{

        if(!tutorialRepository.existsById(tutorialId)){
            throw new ResourceNotFoundException("No tutorial found with ID : "+tutorialId );
        }

        List<Comment> comments = commentRepository.findByTutorialId(tutorialId);
        return new ResponseEntity<>(comments, HttpStatus.OK);

    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentsByTutorialId(
            @PathVariable(value="id") long id
    ) throws ResourceNotFoundException{

        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No comment found with id : "+id));

        return new ResponseEntity<>(comment, HttpStatus.OK);

    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(
            @PathVariable(value="id") long id ,
            @RequestBody Comment commentRequest
    ) throws ResourceNotFoundException {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("No Comment Found with ID : "+id)
                );

        comment.setContent(commentRequest.getContent());
        return new ResponseEntity<>(commentRepository.save(comment) , HttpStatus.OK );

    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("id") long id ){
        commentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/tutorials/{tutorialId}/comments")
    public ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(
            @PathVariable("tutorialId") long tutorialId
    ) throws ResourceNotFoundException{

        if(!tutorialRepository.existsById(tutorialId)){
            throw new ResourceNotFoundException("No tutorial Found with ID : "+tutorialId);
        }

        commentRepository.deleteByTutorialId(tutorialId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
