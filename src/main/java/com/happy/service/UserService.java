package com.happy.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.dao.IUserDao;
import com.happy.pojo.User;
import com.happy.quartz.AsyncTask;
@Service
public class UserService {
		private static final Logger LOGGER =  LoggerFactory.getLogger(UserService.class);  
		@Autowired
		IUserDao userDao;
		@Autowired
		AsyncTask asyncTask;
		/**
		 * 根据id获取用户
		 * @param id
		 * @return
		 */
		public User Sel(int id){
			User user = userDao.Sel(id);
			if(user!=null) {
				return user;
			}else {
				return null;
			}
		}
		/**
		 * 保存用户
		 * @param user
		 */
		public void saveUser(User user) {
			userDao.saveUser(user);
			
		}
		
}	
