package com.ssh.action;

import com.opensymphony.xwork2.Action;
import com.ssh.service.UserService;

public class UserAction {
	
	private UserService userService;
	
	public String toLogin() {
		System.out.println("excute UseAction toLogin() ");
		return Action.SUCCESS;
	}

}
