package com.kminfo.dsmovie.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kminfo.dsmovie.domain.Movie;
import com.kminfo.dsmovie.domain.Score;
import com.kminfo.dsmovie.domain.User;
import com.kminfo.dsmovie.domain.repositories.MovieRepository;
import com.kminfo.dsmovie.domain.repositories.ScoreRepository;
import com.kminfo.dsmovie.domain.repositories.UserRepository;
import com.kminfo.dsmovie.dto.MovieDTO;
import com.kminfo.dsmovie.dto.ScoreDTO;

@Service
public class ScoreService {

	
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ScoreRepository repo;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepo.findByEmail(dto.getEmail());
		
		if(user==null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepo.saveAndFlush(user);
		}
		Movie movie = movieRepo.findById(dto.getMovieId()).get();
		Score score = new Score();
		
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		score = repo.saveAndFlush(score);
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepo.save(movie);
		
		return  new MovieDTO(movie);
	}
	
	
}
