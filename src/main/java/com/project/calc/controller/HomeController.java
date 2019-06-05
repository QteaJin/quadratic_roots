package com.project.calc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.calc.entity.Data;
import com.project.calc.service.DataService;

@Controller
@RequestMapping("/")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		logger.debug("Open Home page");
		return new ModelAndView("home", "data", new Data());
	}

	@RequestMapping(value = "/getResult", method = RequestMethod.POST)
	public ModelAndView getResult(@ModelAttribute("incomeData") Data data, ModelAndView model) {
		logger.info(data.getParamA() + " " + data.getParamB() + " " + data.getParamC());
		if (data == null || data.getParamA() == 0) { // check income data
			return new ModelAndView("error");
		}
		Data result = dataService.calculateResult(data);
		if (result.getX1() == null) { // check data after calculation
			return new ModelAndView("error");
		}
		model.addObject("data", data);
		model.setViewName("result");
		return model;

	}

}
