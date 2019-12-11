package com.happy.pojo;

import java.util.Date;

public class QuartzTask {  
      private int guid;  
      private String module;  
      private String task_name;  
      private String task_address;  
      private int task_type;  
      private String create_userid;  
      private Date create_time;  
      private String remark;  
      private int delete_flag;  
      private String crontab;  
      private int task_status;
	public int getGuid() {
		return guid;
	}
	public void setGuid(int guid) {
		this.guid = guid;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getTask_address() {
		return task_address;
	}
	public void setTask_address(String task_address) {
		this.task_address = task_address;
	}
	public int getTask_type() {
		return task_type;
	}
	public void setTask_type(int task_type) {
		this.task_type = task_type;
	}
	public String getCreate_userid() {
		return create_userid;
	}
	public void setCreate_userid(String create_userid) {
		this.create_userid = create_userid;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}
	public String getCrontab() {
		return crontab;
	}
	public void setCrontab(String crontab) {
		this.crontab = crontab;
	}
	public int getTask_status() {
		return task_status;
	}
	public void setTask_status(int task_status) {
		this.task_status = task_status;
	}  
  
	
	
}