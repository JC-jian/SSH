package jc.ssh.shop.user;

public class User {
			//	uid int primary key auto_increment
			//	username varchar(20) ,
			//	password varchar(20) ,
			//	name varchar(20),
			//	email varchar(30),
			//	phone varchar(20),
			//	addr varchar(50),
			//	sex varchar(10),
			//	state int,
			//	code varchar(64)
	
	private Integer uid;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String addr;
	private String sex;
	private Integer state;
	private String code;
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", addr=" + addr + ", sex=" + sex + ", state="
				+ state + ", code=" + code + "]";
	}


}
