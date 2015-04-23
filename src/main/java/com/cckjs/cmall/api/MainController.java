package com.cckjs.cmall.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public Map<String,String> get(@PageableDefault Pageable pageable){
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "徐健");
		return map;
	}
	@RequestMapping(method = RequestMethod.POST)
	public void post(@PageableDefault Pageable pageable){
		
	}
}
