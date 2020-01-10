package jc.ssh.shop.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDao extends HibernateDaoSupport  {

	public void save(User user) {
		System.out.println(user.toString());
		// 保存注册用户
		this.getHibernateTemplate().save(user);

	}

	public User findByCode(String code) {
		// TODO Auto-generated method stub
		List<User> list = this.getHibernateTemplate().find("from User where code = ?",code);
		if(list.size()!=0){
			return list.get(0);
		}
		return null;

	}

	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
		
	}

	public User login(User user) {
		List<User> list = this.getHibernateTemplate().find("from User where username = ? and password = ? and state = ?",user.getUsername(),user.getPassword(),1);
		if(list.size()!=0){
			return list.get(0);
		}
		
		return null;
	}

	public User findByUserName(User user) {
		List<User> list = this.getHibernateTemplate().find("from User where username = ? ",user.getUsername());
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}

	

}
