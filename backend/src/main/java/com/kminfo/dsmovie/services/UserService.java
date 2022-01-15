package com.kminfo.dsmovie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kminfo.dsmovie.domain.User;
import com.kminfo.dsmovie.domain.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User findById(Long id) {
		Optional<User> user = repo.findById(id);
		return user.get();
	}

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User insert(User obj) {
		repo.save(obj);
		return obj;
	}
	
//	public User update(User obj) {
//		User newObj = new User();
//		
//	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
