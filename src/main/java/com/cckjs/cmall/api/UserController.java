package com.cckjs.cmall.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cckjs.cmall.model.user.UserModel;
import com.cckjs.cmall.service.user.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userSerivce;
	@ApiOperation(value = "获取用户信息", httpMethod = "get", notes = "根据用户Id来获取用户信息")
	@ApiParam(required = true, name = "id", value = "用户Id")
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public UserModel get(@PathVariable Integer id,@PageableDefault Pageable pageable){
		UserModel model = userSerivce.getUser(id);
		return model;
	}
	@RequestMapping(method = RequestMethod.POST)
	public void post(@PageableDefault Pageable pageable){
		
	}
}
