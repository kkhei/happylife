package com.happy.config;

import java.util.List;

import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.happy.dao.IQuartzDao;
import com.happy.pojo.QuartzTask;
import com.happy.quartz.ScheduleTask;

  
@Configuration  
public class QuartzConfigration {  
	
	@Autowired  
    private IQuartzDao quartzDao; 
    /** 
     * attention: 
     * Details：配置定时任务 
     */  
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask task) {// ScheduleTask为需要执行的任务  
    	String searchCron="";
    	List<QuartzTask> listTask = quartzDao.getTask();// 从数据库查询出来的  
        if(listTask!=null && listTask.size()>0) {
        	for(int i=0;i<listTask.size();i++) {
        		searchCron = listTask.get(i).getCrontab();
        	}
        }
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();  
        /* 
         *  是否并发执行 
         *  例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了， 
         *  如果此处为true，则下一个任务会执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行 
         */  
        jobDetail.setConcurrent(false);  
          
        jobDetail.setName("srd-chhliu");// 设置任务的名字  
        jobDetail.setGroup("srd");// 设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用  
          
        /* 
         * 为需要执行的实体类对应的对象 
         */  
        jobDetail.setTargetObject(task);  
          
        /* 
         * sayHello为需要执行的方法 
         * 通过这几个配置，告诉JobDetailFactoryBean我们需要执行定时执行ScheduleTask类中的sayHello方法 
         */  
        jobDetail.setTargetMethod("sayHello");  
        return jobDetail;  
    }  
      
}  