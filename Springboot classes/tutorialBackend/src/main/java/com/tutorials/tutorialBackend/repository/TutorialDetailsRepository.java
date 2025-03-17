package com.tutorials.tutorialBackend.repository;

import com.tutorials.tutorialBackend.model.TutorialDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialDetailsRepository extends JpaRepository<TutorialDetails, Long> {

    @Transactional
    void deleteById(long id);

    @Transactional
    void deleteByTutorialId(long tutorialId);

}
