package com.yedam.app.user.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.user.UserService;
import com.yedam.app.user.UserVO;

@Controller
public class RESTfulUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("getUserListJSON")
	public String getUserListJSON() {
		return "user/getUserList_json";
	}
	
	//목록조회
	@RequestMapping(value="users", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> userList() {
		List<UserVO> userList = userService.getUserList();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		result.put("data", userList);
		return result;	
	}
	
	//단건조회(get, pathVariable)
	@RequestMapping(value="users/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUser(@PathVariable String id) {
	
		UserVO vo = new UserVO();
		vo.setId(id);
		UserVO user = userService.getUser(vo);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		result.put("data", user);
		return result;	
	}		
	
	//수정
	@RequestMapping(value="/users",
					method=RequestMethod.PUT
					,headers = {"Content-type=application/json"})
	@ResponseBody
	public Map<String, Object> updateUser(@RequestBody UserVO vo) {
		userService.updateUser(vo);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
		
	}
	
	//등록
	@RequestMapping(value="/users",
			method=RequestMethod.POST
			,headers = {"Content-type=application/json"})
	@ResponseBody
	public Map<String, Object> insertUser(@RequestBody UserVO vo) {
		if (vo != null)
			userService.insertUser(vo);	
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}
}
