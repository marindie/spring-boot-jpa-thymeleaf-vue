package com.samsung.card.service;

import java.util.Optional;

import com.samsung.card.entity.UserEntity;
import com.samsung.card.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserEntity getUser(String userId){
		Optional<UserEntity> userEntity = userRepository.findById(userId);
		return userEntity.isPresent() ? userEntity.get() : null;
	}
}
