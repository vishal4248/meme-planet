package com.worldmeme.worldmeme.repos;

import com.worldmeme.worldmeme.models.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemeRepository extends JpaRepository<Meme,Long> {

    /**
     * paging and sorting should be implemented to make limit 100
     */

    @Query(value = "select * from meme limit 100",nativeQuery = true)
    List<Meme> getLatestMemes();
}
