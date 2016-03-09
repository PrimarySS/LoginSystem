package me.syf.service.Impl;

import me.syf.dao.IUserDao;
import me.syf.dao.impl.UserDaoImpl;
import me.syf.domain.User;
import me.syf.exception.UserExistException;
import me.syf.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao a = new UserDaoImpl();
	@Override
	public void registerUser(User user) throws UserExistException {
		
		if(a.find(user.getUsername())!=null)
		{
			throw new UserExistException("该用户名已存在！");
		}
		a.add(user);
	}

	@Override
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		return a.find(userName, userPwd);
	}

}
