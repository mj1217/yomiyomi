package com.yedam.app.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.user.UserService;
import com.yedam.app.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO dao;

	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
		
	}

	@Override
	public void updateUser(UserVO vo) {
		dao.updateUser(vo);
		
	}

	@Override
	public void deleteUser(UserVO vo) {
		dao.deleteUser(vo);
		
	}

	@Override
	public UserVO getUser(UserVO vo) {
	
		return dao.getUser(vo);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public boolean login(UserVO vo) {
		//id조회
		UserVO userVO = dao.getUser(vo);
		//입력 패스워드 db패스워드 비교
		if(userVO != null && vo.getPassword().equals(userVO.getPassword()) )
		{
			return true;
		} 
		return false;
	}
	
	
	

}
