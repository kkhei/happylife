package com.happy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.dao.IUserDao;
import com.happy.pojo.User;
@Service
public class UserService {
		@Autowired
		IUserDao userDao;
		public User Sel(int id){
		    return userDao.Sel(id);
		}
}	
