package com.ecoman.springboot;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecoman.exception.CustomException;

@ControllerAdvice
public class ErrorController {
	@ExceptionHandler({DataIntegrityViolationException.class})
	@ResponseBody 
	public String dataAccessException(DataIntegrityViolationException e,HttpServletResponse response) {
		//response.setContentType("text/plain; charset=UTF-8");
		String msg = "{ \"error\":\"数据完整性（唯一性）检查错误！\"}";
		response.setStatus(HttpServletResponse.SC_CONFLICT);
		return msg;
	}
	
	@ExceptionHandler({CustomException.class})
	@ResponseBody
	public CustomException customException(CustomException e,HttpServletResponse response){
		return e;
	}
}