package com.citiustech.prp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.citiustech.prp.dao.RoleRepository;
import com.citiustech.prp.dao.UserRepository;
import com.citiustech.prp.model.Role;
import com.citiustech.prp.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	private PasswordEncoder passwordEncoder = null;
	
	 public User registerUser(User user, String roleName) {
	        Role role = roleRepository.findByName(roleName);
	        if (role != null) {
	        	user.setRole(role);
	        }
	        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
	        return userRepository.save(user);
	    }
	    
	    
}
