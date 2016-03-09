package me.syf.dao.impl;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.syf.dao.IUserDao;
import me.syf.domain.User;

public class Userdaotest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		User usr = new User();
		usr.setUsername("沈云飞");
		usr.setPassword("123456");
		usr.setId("123");
		usr.setEmail("418626916@qq.com");
		Date bir = new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		bir = df.parse("1992-7-21");
		usr.setBirthday(bir);
		IUserDao a = new UserDaoImpl();
		a.add(usr);
		usr = a.find("沈xiao飞","123456");
		System.out.println(usr.getUsername()+" "+usr.getPassword()+" "+usr.getEmail()+" "+df.format(usr.getBirthday()));
		

	}

}
