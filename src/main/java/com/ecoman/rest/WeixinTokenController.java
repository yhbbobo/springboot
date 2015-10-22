package com.ecoman.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeixinTokenController {
	
	//演示自定义异常处理函数，见ErrorController.java
	@RequestMapping(value="/token",produces="application/json; charset=UTF-8")
	@ResponseBody
	String token(){
		return "true";
	}
}
