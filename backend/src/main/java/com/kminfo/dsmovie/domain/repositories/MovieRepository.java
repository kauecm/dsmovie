package com.kminfo.dsmovie.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kminfo.dsmovie.domain.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
