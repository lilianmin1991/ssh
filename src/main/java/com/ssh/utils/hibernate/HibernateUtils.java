package com.ssh.utils.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 整合Spring后，sessionFactory交给Spring，相关方法无用
 * @author MSI
 *
 */
public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	static {
		//获取核心配置文件的对象，至少需要有hibernate.cfg.xml
		Configuration cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
		System.out.println("创建Session工厂");
		//监听，用于关闭工厂
		Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					sessionFactory.close();
					System.out.println("关闭Session工厂");
				}
			}
		);
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
