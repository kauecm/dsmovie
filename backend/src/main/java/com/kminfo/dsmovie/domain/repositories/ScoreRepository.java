package com.kminfo.dsmovie.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kminfo.dsmovie.domain.Score;
import com.kminfo.dsmovie.domain.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {

}
