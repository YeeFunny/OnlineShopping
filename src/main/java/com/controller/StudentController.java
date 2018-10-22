package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Student;

@Controller
public class StudentController {

	@RequestMapping(path= {"/addStudent"},  method=RequestMethod.GET)
	public ModelAndView navigate(ModelAndView attr) {
		attr.addObject("student", new Student());
		attr.setViewName("addStudent");
		return attr;
	}
}
