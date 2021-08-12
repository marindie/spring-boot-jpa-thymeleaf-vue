package com.samsung.card.controller.main;

import java.util.HashMap;
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
		model.addAttribute("name",name);
		return "index";
	}

	@RequestMapping(value="/login", method={RequestMethod.GET,RequestMethod.POST})
	public String login(){
		return "login/login";
	}	

	@RequestMapping(value="/getName", method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getName(@RequestParam Map<String,Object> param, Model model) {
		
		Map<String,Object> retMap = new HashMap<String,Object>();
		Gson gson = new Gson();
		return gson.toJson(retMap);
	}
}
