package com.ssh.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.User;
import com.ssh.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//模型驱动使用的类
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//Struts2与Spring整合过程中按名称自动注入的业务层类
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String save() {
		System.out.println("执行UseAction的save() ");
		userService.save(user);
		return Action.SUCCESS;
	}

}
