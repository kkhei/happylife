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
import com.happy.service.UserService;
@Controller
@RequestMapping("/testBoot")
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	private static final Gson gson = new Gson();
	@Autowired
    private UserService userService;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		LOG.info("login success");
		return mav;
	}
	@RequestMapping("/hello")
    public String hello(Model model) {
    	System.err.println("hello");
    	LOG.info("login info");
    	LOG.error("login error");
    	LOG.debug("login debug");
    	model.addAttribute("msg","你好");
        return "success";
    }
	
 
    @RequestMapping("getUser/{id}")
    @ResponseBody
    public String getUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }
   


    @ResponseBody
    @GetMapping("/query")
    public List<Map<String, Object>> map(){
    	jdbcTemplate.execute("insert into department values('2','被射组')");
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM department");
        return list;
    }
}
