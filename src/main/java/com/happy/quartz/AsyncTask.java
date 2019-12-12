package com.happy.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.happy.dao.IUserDao;
import com.happy.pojo.User;
import com.happy.utils.CommonsUtil;

@Component
public class AsyncTask {
	//这里注入的是dubbo的服务，和异步请求没有多大关系
	@Autowired
    private IUserDao userDao;

      /**
             *      获取作者信息
     *
     * @param authorId 作者ID
     * @return 作者信息
            *   在调用Async方法的方法上标注@Transactional是管理调用方法的事务的
		在Async方法上标注@Transactional是管理异步方法的事务,事务因线程隔离
     */
    //@Transactional
    @Async
    public void saveAuthor1(){
        try {
            System.out.println("执行线程的名字1："+Thread.currentThread().getName());
            User user = new User();
    		user.setPassWord("123456");
    		user.setRealName("xiaohong");
    		user.setUserName("小红");
            user.setId(new CommonsUtil().getUuid());
            userDao.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Async
    public void saveAuthor2(){
        try {
            System.out.println("执行线程的名字2："+Thread.currentThread().getName());
            User user = new User();
    		user.setPassWord("123456");
    		user.setRealName("xiaohong");
    		user.setUserName("小红");
    		user.setId(new CommonsUtil().getUuid());
            userDao.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Async
    public void saveAuthor3(){
    	try {
    		System.out.println("执行线程的名字3："+Thread.currentThread().getName());
    		User user = new User();
    		user.setPassWord("123456");
    		user.setRealName("xiaohong");
    		user.setUserName("小红");
    		user.setId(new CommonsUtil().getUuid());
    		userDao.saveUser(user);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
