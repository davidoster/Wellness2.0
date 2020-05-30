package com.afdemp.wellness.service;

import java.util.List;

import com.afdemp.wellness.entities.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
