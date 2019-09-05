package com.ssh.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.domain.User;

public class UserDao extends HibernateDaoSupport{
	public void save(User user) {
		System.out.println("执行UserDao的save()方法");
		this.getHibernateTemplate().save(user);
	}
}
