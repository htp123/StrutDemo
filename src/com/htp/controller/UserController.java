package com.htp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.htp.bean.User;
import com.htp.serviceImpl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;


	@RequestMapping("/getUsers")
	public List<Map<String,String>> getUsers(){
		/*List<Map<String,String>> rst = new ArrayList<Map<String,String>>();
		rst = userService.getUsers();*/
		//上述使用步骤会存在多占内存问题
		List<Map<String,String>> rst = userService.getUsers();
//		rst = getSqlSession().selectList("getUsers");
		for(int i = 0; i < rst.size(); i++){
			System.out.println("i："+i+" name:"+i+ rst.get(i).get("name"));
		}
		return rst;
	}
	
	@RequestMapping("/getUserById")
	public List<User> getUserById(Integer id){
	 /*   if(Integer.valueOf(id) <= 0){
	    	System.out.println("error...");
	    	return null;
	    }*/
		System.out.println("test>>>>>>");
//		List<Map<String,String>>  rst = userService.getUserById(id);
		List<User>  rst = userService.getUserById(id);
		for(int i = 0; i < rst.size(); i++){
			System.out.println("i："+i+">>>name:"+ rst.get(i).getName());
		}
		return rst;
		
	}
	
}
