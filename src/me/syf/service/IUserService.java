package me.syf.service;

import me.syf.domain.User;
import me.syf.exception.UserExistException;

public interface IUserService {
	
	/**
	 * 提供注册服务
	 * @param user
	 * @throws UserExistException
	 */
	void registerUser(User user) throws UserExistException;
	
	/**
	 * 提供登陆服务
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	User loginUser(String userName, String userPwd);
	
}
