package me.syf.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.sun.org.apache.xml.internal.security.utils.XMLUtils;

import jdk.jfr.events.FileWriteEvent;
import me.syf.dao.IUserDao;
import me.syf.domain.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public User find(String username, String password) {
		User user = new User();
		SAXReader reader = new SAXReader();
		Document document;
		try {
			URL url = UserDaoImpl.class.getClassLoader().getResource("DB.xml");
			String realpath = url.getPath();
			document = reader.read(realpath);
			Element node = (Element) document
					.selectSingleNode("//user[@userName='" + username + "' and @userPwd='" + password + "']");
			if (node == null)
				return null;

			user.setId(node.attributeValue("id"));
			user.setEmail(node.attributeValue("email"));
			user.setPassword(node.attributeValue("userPwd"));
			user.setUsername(node.attributeValue("userName"));
			String birth = node.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				user.setBirthday(sdf.parse(birth));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("日期转换错误");
				e.printStackTrace();
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public User find(String username) {
		User user = new User();
		SAXReader reader = new SAXReader();
		Document document;
		try {
			URL url = UserDaoImpl.class.getClassLoader().getResource("DB.xml");
			String realpath = url.getPath();
			document = reader.read(realpath);
			Element root = document.getRootElement();
			Element node = (Element) root.selectSingleNode("//user[@userName='" + username + "']");
			if (node == null)
				return null;

			user.setId(node.attributeValue("id"));
			user.setEmail(node.attributeValue("email"));
			user.setPassword(node.attributeValue("userPwd"));
			user.setUsername(node.attributeValue("userName"));
			String birth = node.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				user.setBirthday(sdf.parse(birth));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("日期转换错误");
				e.printStackTrace();
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("未找到DB.xml!");
			e.printStackTrace();
		}
		return user;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void add(User user) {

		SAXReader reader = new SAXReader();
		try {
			URL url = UserDaoImpl.class.getClassLoader().getResource("DB.xml");
			String realpath = url.getPath();
			Document document = reader.read(realpath);
			Element root = document.getRootElement();
			Element user_node = root.addElement("user");
			user_node.setAttributeValue("id", user.getId());
			user_node.setAttributeValue("userName", user.getUsername());
			user_node.setAttributeValue("userPwd", user.getPassword());
			user_node.setAttributeValue("email", user.getEmail());
			if (user.getBirthday() != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				user_node.setAttributeValue("birthday", sdf.format(user.getBirthday()));
			}

			try {
				OutputFormat format = OutputFormat.createPrettyPrint();
				XMLWriter output = new XMLWriter(new FileWriter(realpath), format);
				output.write(document);
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("写入xml失败！");
				e.printStackTrace();
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("DB.xml打开失败");
			e.printStackTrace();
		}
	}

}
