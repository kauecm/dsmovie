package com.kminfo.dsmovie.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kminfo.dsmovie.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Transactional(readOnly = true)
	User findByEmail(String email);
}
