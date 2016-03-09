package me.syf.web.formbean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterFormBean {
	
	private String username;
	private String password;
	private String confirmpsw;
	private String email;
	private String birthday;
	
	private Map<String,String> errors = new HashMap<String,String>();
	public Map<String,String> getErrors(){
		return errors;
	}
	public void setErrors(Map<String,String> errors){
		this.errors = errors;
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
	public String getConfirmpsw() {
		return confirmpsw;
	}
	public void setConfirmpsw(String confirmpsw) {
		this.confirmpsw = confirmpsw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * 验证用户输入信息合法性
	 * @return
	 */
	public boolean validate(){
		boolean is_Ok = true;
		if(birthday == null || birthday.trim().equals(""))
		{
			is_Ok = false;
			errors.put("birthday", "生日不能为空！");
		}
		else{

			if(birthday != null && !birthday.trim().equals(""))
			{
				try {
					DateLocaleConverter converter = new DateLocaleConverter();
					converter.convert(birthday);
				} catch (Exception e) {
					is_Ok = false;
					errors.put("birthday", "生日格式不正确！");
				}
				
			}

		}
		if(username == null || username.trim().equals(""))
		{
			is_Ok = false;
			errors.put("username", "用户名不能为空！");
		}
		else
		{
			if(!username.matches("[a-zA-Z]{3,8}"))
			{
				is_Ok = false;
				errors.put("username", "用户名必须为3-8位的字母！");
			}
		}
		if(password == null || password.trim().equals(""))
		{
			is_Ok = false;
			errors.put("password", "密码不能为空！");
		}
		else
		{
			if(!password.matches("\\d{3,8}"))
			{
				is_Ok = false;
				errors.put("password", "密码必须为3-8位的字母！");
			}
		}
		
		if(!confirmpsw.equals(password))
		{
			is_Ok = false;
			errors.put("confirmpsw", "两次输入的密码不一致！");
		}
		if (this.email != null && !this.email.trim().equals("")) {
            if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
                is_Ok = false;
                errors.put("email", "邮箱不是一个合法邮箱！！");
            }
        }
				
		return is_Ok;
	}

}
