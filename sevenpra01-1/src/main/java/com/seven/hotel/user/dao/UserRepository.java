package com.seven.hotel.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seven.hotel.user.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
