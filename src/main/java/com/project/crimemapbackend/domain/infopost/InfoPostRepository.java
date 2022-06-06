package com.project.crimemapbackend.domain.infopost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InfoPostRepository extends JpaRepository<InfoPost, Integer> {
    /*@Query("SELECT p FROM InfoPost p ORDER BY p.post_num ASC")
    List<InfoPost> findAll();*/
}
