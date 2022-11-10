package com.fibabootcamplesson01.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Standard controller example

@Controller
public class TestController {

	@GetMapping("/message") // pathway from the local host
	@ResponseBody
	public String getMessage() { // a basic method that will be called when the specified address is accessed
		return "İleti"; // this string will be displayed on the browser since it is the return of the
						// method
	}

	// Rest example will be shown in the ResourceController Class

}