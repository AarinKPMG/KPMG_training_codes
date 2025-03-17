package com.tutorials.tutorialBackend.repository;

import com.tutorials.tutorialBackend.model.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTutorialId(long commentId);

    @Transactional
    void deleteBytutorialId(long tutorialId);


}
