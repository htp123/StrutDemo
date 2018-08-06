package com.htp.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.objectweb.asm.commons.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.htp.bean.User;
import com.htp.serviceImpl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

//@Controller
@Component
@Scope("prototype")
public class WelcomeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String password;

	@Autowired
	UserServiceImpl userServiceImpl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// all struts logic here
	public String execute() {

		System.out.println("execute......");
		System.out.println("id[" + id + "]");
		if (id == null || id == "") {
			System.out.println("id²»¿ÉÎª¿Õ");
			return null;
		}

		List<User> rst = userServiceImpl.getUserById(Integer.parseInt(id));

		/*
		 * try { System.out.println("test....reflect"); Class<?> class_a =
		 * Class.forName("com.htp.serviceImpl.UserServiceImpl");
		 * java.lang.reflect.Method method = class_a.getMethod("getUserById",
		 * Integer.class); method.invoke(class_a.newInstance(), id); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		if (rst != null) {
			User user = rst.get(0);
			System.out.println("username[" + user.getName() + "]");
		}

		return "SUCCESS";

	}
}
