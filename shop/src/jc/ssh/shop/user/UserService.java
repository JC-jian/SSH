package jc.ssh.shop.user;

import java.util.UUID;

import jc.ssh.shop.utils.MailUtils;
import jc.ssh.shop.utils.UUIDUtils;

public class UserService {
	//注入userDao
	private UserDao userDao;
	
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	public void regist(User user) {
		//保存用户
		user.setState(0);  //0未激活，1已经激活
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID(); //生成验证码
		user.setCode(code);
		try {
			MailUtils.sendMail(user.getEmail(), code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userDao.save(user);
		
	}



	public User getUserByCode(String code) {
		// TODO Auto-generated method stub
		return userDao.findByCode(code);
	}



	public void update(User existUser) {
		userDao.update(existUser);
	}



	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}



	public User findByUserName(User user) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(user);
	}

}
