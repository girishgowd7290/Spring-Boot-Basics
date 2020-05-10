package com.codemads.springboot.basics;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codemads.springboot.basics.jpa.service.UserService;

/**
 * 
 * Controller class of the spring application
 * 
 * Annotate with @RestController to make this Java class as Controller class
 * @author girishgowda
 *
 */
@RestController
public class SpringBootController {
	
	/*
	 * @Autowired is used to inject a Bean 
	 */
	@Autowired
	private UserService userSerivce;
	
	@Autowired
	private MessageSource messageSource;
	
	/*
	 * There are different ways of initializing a Get method
	 */
	
	//@GetMapping(path = "/greeting")
	@GetMapping("/greeting")
	public String greeting() {
		return "Hello Sumana";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/greeting1")
	public String gretting1() {
		return "Hello Shubiksha";
	}
	
	
	@GetMapping(path = "/bean")
	public HelloWorldBean returnBean() {
		return new HelloWorldBean("Hello Sumu");
	}
	
	
	@GetMapping(path = "/bean/{name}")
	public HelloWorldBean pathvariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s", name));
	}

	/*
	 * Post type Mapping
	 */
	@PostMapping("/jpa/user")
	private void persistUserJPA(@Valid @RequestBody com.codemads.springboot.basics.jpa.entity.User user){
		userSerivce.persistInfo(user);
	}

	/**
	 * Internationalisation related example - To print good morning based on geo location
	 * 
	 * @param locale
	 * @return
	 */
	@GetMapping("/greeting/intl")
	public String greetingIntl(@RequestHeader(name="Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
}
