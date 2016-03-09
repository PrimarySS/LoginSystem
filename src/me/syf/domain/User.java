package me.syf.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author whisssky
 *用户实体类
 */
public class User implements Serializable {


	private static final long serialVersionUID = -1733495985054795296L;
	//用户id
	private String id;
	//用户名
	private String username;
	//用户密码
	private String password;
	//用户邮箱
	private String email;
	//用户生日
	private Date birthday;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	

}
