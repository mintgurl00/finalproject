package com.spring.hellospring;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = "list.bo")
	public String list(Locale locale, Model model) {
		
		return "list";
		
	}
	
	@RequestMapping(value = "input.bo", method = RequestMethod.POST)
	public String res(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "res";
	}

}
