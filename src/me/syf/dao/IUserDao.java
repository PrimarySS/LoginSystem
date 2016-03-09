package me.syf.dao;

import me.syf.domain.User;

/**
 * 
 * @author whisssky
 *查询、添加用户接口
 */
public interface IUserDao {

	/**
	 * 根据用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return 查找到的用户
	 */
	User find(String username,String password);
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return 查找到的用户
	 */
	User find(String username);
	
	/**
	 * 添加用户
	 * @param user
	 */
	void add(User user);
}
