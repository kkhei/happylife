package com.happy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.happy.pojo.QuartzTask;

@Repository  
public interface IQuartzDao {
	
	public List<QuartzTask> getTask();
}
