package com.samsung.card.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/defaultPageCall", method={RequestMethod.GET,RequestMethod.POST})
	public String defaultPageCall(@RequestParam Map<String,Object> param, Model model) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> listPrdInfo = new ArrayList<Map<String,Object>>();
		Map<String,Object> prd01 = new HashMap<String,Object>();
		Map<String,Object> prd02 = new HashMap<String,Object>();

		prd01.put("imgUrl","http://static2.e-himart.co.kr/contents/goods/00/14/49/00/30/0014490030__DJI-AIR2S-COMBO__M_300_300.jpg");
		prd01.put("prdName","DJI *엘포인트 10만점 * DJI 에어2S 플라이모어 콤보 [DJI-AIR2S-COMBO] 스마트드론");
		prd01.put("price01","11203000");
		prd01.put("price02","11202000");

		prd02.put("imgUrl","http://static2.e-himart.co.kr/contents/goods/00/14/49/00/30/0014490030__DJI-AIR2S-COMBO__M_300_300.jpg");
		prd02.put("prdName","DJI *엘포인트 10만점 * DJI 에어2S 플라이모어 콤보 [DJI-AIR2S-COMBO] 스마트드론");
		prd02.put("price01","11203000");
		prd02.put("price02","1121000");

		listPrdInfo.add(prd01);
		listPrdInfo.add(prd02);
		map.put("prdInfo",listPrdInfo);

		model.addAttribute("attr",map);
		return "test/fragmentTestPage";
	}

	@RequestMapping(value="/changePartOfDomTest", method={RequestMethod.GET,RequestMethod.POST})
	public String changePartOfDom(@RequestParam Map<String,Object> param, Model model) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> listPrdInfo = new ArrayList<Map<String,Object>>();
		Map<String,Object> prd01 = new HashMap<String,Object>();
		Map<String,Object> prd02 = new HashMap<String,Object>();

		prd01.put("imgUrl","http://static1.e-himart.co.kr/contents/goods/00/14/70/15/24/0014701524__NA__M_300_300.jpg");
		prd01.put("prdName","여름기저귀 에어차차 썸머팬티 기저귀 4~7 단계 3팩 택1");
		prd01.put("price01","99,000");
		prd01.put("price02","80,150");

		prd02.put("imgUrl","http://static1.e-himart.co.kr/contents/goods/00/14/58/44/27/0014584427__TR13BK.AKOR__M_300_300.jpg");
		prd02.put("prdName","LG전자 일반 세탁기 TR13BK (13kg, 10년무상보증, 펀지물살, 위생세탁, 스마트인버터, 미들프리실버)");
		prd02.put("price01","386,000");
		prd02.put("price02","317,400");

		listPrdInfo.add(prd01);
		listPrdInfo.add(prd02);
		map.put("prdInfo",listPrdInfo);

		model.addAttribute("attr",map);
		return "test/fragmentTestPage :: #product-slice-two01";
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
