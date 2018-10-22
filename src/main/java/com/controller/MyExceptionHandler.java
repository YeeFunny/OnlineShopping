package com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exception.DatabaseException;


public class MyExceptionHandler {
	
	@ExceptionHandler(DatabaseException.class)
	public String handleDatabaseException(Model model, Exception e) {
		model.addAttribute("errorMessage", e.getMessage());
		return "error";
	}

}
