package com.tutorials.tutorialBackend.repository;

import com.tutorials.tutorialBackend.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
    List<Tutorial> findTutorialsByTagsId(long tagsId);
    Optional<Tutorial> findByTitle(String title);

}
