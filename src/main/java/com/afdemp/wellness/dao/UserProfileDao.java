package com.afdemp.wellness.dao;

import java.util.List;

import com.afdemp.wellness.entities.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
