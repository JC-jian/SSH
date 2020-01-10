package jc.ssh.shop.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * 用户的Action
 * @author v-Jc
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	
	//注入UserService
	private UserService userService;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//接收验证码
	private String checkcode;
	

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public User getModel() {
		return user;
	}
	
	//跳转到注册页面
	public String registPage(){
		return "registPageSuccess";
	}
	
	//跳转到登陆页面
	public String loginPage(){
		return "loginPageSuccess";
	}
	
	
	//前台:注册
	@InputConfig(resultName="registInput")
	public String regist(){
		//从Session中获取存的验证码
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		System.out.println(checkcode1);
		System.out.println(checkcode);
		if(checkcode == null || !checkcode.equalsIgnoreCase(checkcode1)){
			this.clearMessages();
			this.addActionMessage("验证码有误");
			return "registInput";
		}
		userService.regist(user);
		this.clearMessages();
		this.addActionMessage("注册成功，请去激活。");
		return "registSuccess";
	}
	
	
	//前台：登陆
	@InputConfig(resultName="loginInput")
		public String login(){
			User existUser = userService.login(user);
			if(existUser == null){
				//登陆失败
				this.addActionError("用户名或密码错误或未激活");
				return "loginInput";
			}else{
				System.out.println(existUser);
				//登陆成功，存入session
				ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
				return "loginSuccess";
			}
		}
	
	//ajax验证账号名
	public String checkUserName() throws IOException{
		User existUser = userService.findByUserName(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("__________________________________1111______________");
		if(existUser == null){
			response.getWriter().print("<font color='green'>用户名可以使用</font>");
		}else{
			response.getWriter().print("<font color='red'>用户名已经存在</font>");
		}		
		return NONE;
	}
	
	//邮件验证码验证active
	public String active(){
		User existUser = userService.getUserByCode(user.getCode());
		if(existUser != null){
			existUser.setState(1);
			userService.update(existUser);
			// 添加信息:
			this.clearMessages();
			this.addActionMessage("激活成功!请去登录!");
			return "activeSuccess";
		}else{
			this.clearMessages();
			this.addActionMessage("激活失败!");
			return "activeSuccess";
		}		
	}
	
	
	

}
