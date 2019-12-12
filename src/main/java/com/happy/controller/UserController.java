package com.happy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.happy.pojo.User;
import com.happy.quartz.AsyncTask;
import com.happy.service.UserService;
@Controller
@RequestMapping("/testBoot")
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	private static final Gson gson = new Gson();
	@Autowired
    private UserService userService;
	@Autowired
	AsyncTask asyncTask;
	@Autowired
	JdbcTemplate jdbcTemplate;
	/**
	 * 返回页面不能加@ResponseBody
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		LOG.info("login success");
		return mav;
	}
	@RequestMapping("/saveAsync")
	@ResponseBody
    public String hello() throws InterruptedException {
		long currentTimeMillis = System.currentTimeMillis();  
        Thread.sleep(1000);  
		
		asyncTask.saveAuthor1();
		asyncTask.saveAuthor2();
		asyncTask.saveAuthor3();
		long currentTimeMillis1 = System.currentTimeMillis();  
		LOG.info("task任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms"); 
		//userService.saveUser(user);
        return "task任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";
    }
	
 
    @RequestMapping("getUser/{id}")
    @ResponseBody
    public String getUser(@PathVariable int id){
    	User sel = userService.Sel(id);
    	if(sel !=null ) {
    		return sel.toString();
    	}
    	return "not found data";
    }
   


    @ResponseBody
    @GetMapping("/query")
    public List<Map<String, Object>> map(){
    	jdbcTemplate.execute("insert into department values('2','被射组')");
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM department");
        return list;
    }
}
