package com.mcf.manage.web.controller.common;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.mcf.base.common.converter.DateEditor;
import com.mcf.base.common.utils.MessageUtils;

/**
 * 基本控制层
 * 
 * @author sunaiqiang
 * @version 2.0 2016-04-08
 */
public class BaseController implements WebBindingInitializer {

	protected static Validator validator;

	public BaseController() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		setValidator(validatorFactory.getValidator());
	}

	public static Validator getValidator() {
		return validator;
	}

	public static void setValidator(Validator validator) {
		BaseController.validator = validator;
	}

	protected <T> Map<String, Object> getMessage(T t) {
		Map<String, Object> errors = new HashMap<String, Object>();
		Set<ConstraintViolation<T>> violations = validator.validate(t);
		for (ConstraintViolation<T> violation : violations) {
			String key = violation.getMessageTemplate();
			errors.put(violation.getPropertyPath().toString(),
					MessageUtils.getMessage(key.substring(1, key.length() - 1)));
		}
		return errors;
	}

	protected String getMessage(BindingResult br) {
		// 输出错误消息
		List<ObjectError> errorList = br.getAllErrors();
		for (ObjectError error : errorList) {
			return error.getDefaultMessage();
		}
		return null;
	}

	@Override
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

}