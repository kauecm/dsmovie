package com.kminfo.dsmovie.services;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kminfo.dsmovie.domain.Movie;
import com.kminfo.dsmovie.domain.repositories.MovieRepository;
import com.kminfo.dsmovie.dto.MovieDTO;

@Service
public class MovieService {

	
	@Autowired
	private MovieRepository repo;
	
	@Transactional
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> result = repo.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page; 
	}
	
	public MovieDTO findById(Long id) {
		Optional<Movie> movie = repo.findById(id);
		MovieDTO dto = new MovieDTO(movie.get());
		return dto;
	}
	
	

}
