package com.softapi.validator;

import com.softapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import com.softapi.models.User;


/**
 * 
 * @author osvaldoairon
 *
 */
public class ServiceValidator {
	
	
	private UserRepository userRepository;
	
	
	public ServiceValidator(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public boolean checkExistenceUser(String username) {
		User u = this.userRepository.checkIfUserExist(username);
		if(u!=null) {
			return true;
		}
		
		return false;
	}
	

}
