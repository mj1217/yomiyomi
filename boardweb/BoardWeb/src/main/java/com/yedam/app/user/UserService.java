package com.yedam.app.user;

import java.util.List;

public interface UserService {

	 public void insertUser(UserVO vo);
	 public void updateUser(UserVO vo);
	 public void deleteUser(UserVO vo);
	 public UserVO getUser(UserVO vo);
	 public List<UserVO> getUserList();
	 public boolean login(UserVO vo);
	 
}
