package com.samsung.card.controller.user;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.samsung.card.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/", method={RequestMethod.GET,RequestMethod.POST})
	public String userView(@RequestParam Map<String,Object> param, Model model) {
		String name = "";

		model.addAttribute("name",name);
		return "userView";
	}

	@RequestMapping(value="/getUserNameJson", method={RequestMethod.POST}, produces = "application/json")
	public @ResponseBody String getUserNameJson(@RequestBody Map<String,Object> param, Model model) {
		Gson gson = new Gson();
		log.debug("====== param : "+param);
		log.debug("====== param json : "+gson.toJson(param));
		String userId = "";
		if(param != null){
			userId = param.get("id").toString();
		}

		Map<String,Object> retMap = new HashMap<String,Object>();
		retMap.put("data",userService.getUser(userId));
		
		return gson.toJson(retMap);
	}

	@RequestMapping(value="/getUserName", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getUserName(@RequestParam Map<String,Object> param, Model model) {
		Gson gson = new Gson();
		log.debug("====== param : "+param);
		log.debug("====== param json : "+gson.toJson(param));
		String userId = "";
		if(param != null){
			userId = param.get("id").toString();
		}

		Map<String,Object> retMap = new HashMap<String,Object>();
		retMap.put("data",userService.getUser(userId));
		
		return gson.toJson(retMap);
	}	
}
