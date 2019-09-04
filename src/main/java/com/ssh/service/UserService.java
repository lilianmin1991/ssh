package com.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.domain.User;

@Transactional
public class UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save(User user) {
		System.out.print("执行UserService的save()方法");
		userDao.save(user);
	}
}
