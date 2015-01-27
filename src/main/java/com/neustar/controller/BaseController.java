package com.neustar.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neustar.util.MathUtil;
import com.neustar.util.Util;

@Controller
public class BaseController {

	private static int counter = 0;
	private static int randomNumber = 0;
	private static int chances = 5;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("counter", counter);
		model.addAttribute("chances", chances);
		logger.debug("current counter : {}", counter);
		logger.debug("total chances : {}", chances);
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/resetCounter", method = RequestMethod.GET)
	public String reset(ModelMap model) {
		counter = 0;
		model.addAttribute("counter", counter);
		model.addAttribute("chances", chances);
		logger.debug("[resetting] counter : {}", counter);
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/guess", method = RequestMethod.GET)
	public String guess(
			@RequestParam(value = "guessNo", required = true) Integer guessNo,
			@RequestParam(value = "min", defaultValue = "1", required = false) Integer min,
			@RequestParam(value = "max", defaultValue = "20", required = false) Integer max,
			ModelMap model) {

		if (null == guessNo) {
			return VIEW_INDEX;
		}

		// Generate random number only once.
		if (++counter == 1)
			randomNumber = MathUtil.randInt(min, max);
		
		model.addAttribute("message", Util.compareGuessToRandom(guessNo, randomNumber));
		model.addAttribute("counter", counter);
		model.addAttribute("randomNumber", randomNumber);
		model.addAttribute("guessNo", guessNo);
		model.addAttribute("chances", chances);
		
		
		
		logger.debug("counter : {}", counter);
		logger.debug("guessNo : {}", guessNo);
		logger.debug("randomNumber : {}", randomNumber);		
		return VIEW_INDEX;
	}

}