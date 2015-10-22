package com.ecoman.rest;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecoman.jpa.Receipt;

@ControllerAdvice(basePackages={"com.ecoman.rest"})
public class ReceiptValidateController implements Validator {
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(this);
	}
	void validateReceipt(@RequestBody Receipt receipt){
		System.out.println("validateReceipt :"+receipt);
	}
	@Override
	public boolean supports(Class<?> clazz) {
		if(clazz.equals(Receipt.class)) return true;
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		Receipt r = (Receipt)target;
		if(r.getPsId() == 0) errors.rejectValue("psId", "validate", "仓库ID不能为空");
	}
}
