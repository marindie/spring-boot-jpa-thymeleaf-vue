package com.samsung.card.controller.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/")
@Slf4j
public class MainController {

	@RequestMapping(value="/", method={RequestMethod.GET,RequestMethod.POST})
	public String mainView(@RequestParam Map<String,Object> param, Model model) {
		String name = "";
		log.debug("========= WONY ===========");

		//List<Map<String,Object>> taskList = new ArrayList<Map<String,Object>>();
		List<String> taskList = new ArrayList<String>();
		for (int i = 0 ; i < 10 ; i++) {
			//Map<String,Object> task = new HashMap<String,Object>();	
			//task.put("task","wony"+i);
			taskList.add("wony"+i);
		}

		model.addAttribute("tasks",taskList);
		model.addAttribute("name",name);
		model.addAttribute("message","wony");
		
		return "index";
	}

	@RequestMapping(value="/login", method={RequestMethod.GET,RequestMethod.POST})
	public String login(){
		return "login/login";
	}

	@RequestMapping(value="/home")
	public String home(@RequestParam Map<String,Object> param, Model model) {
		String home = "안녕하세요 home 입니다.";
		String welcome = "안녕하세요 welcome 입니다.";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("welcome",home);
		model.addAttribute("home",map);
		model.addAttribute("welcome",welcome);
		return "home";
	}

	@RequestMapping(value="/getName", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getName(@RequestParam Map<String,Object> param, Model model) {
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		Gson gson = new Gson();
		return gson.toJson(retMap);
	}
}
