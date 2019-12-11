package com.happy.dao;

import org.springframework.stereotype.Repository;

import com.happy.pojo.User;

@Repository
public interface IUserDao {
	
	User Sel(int id);
}
