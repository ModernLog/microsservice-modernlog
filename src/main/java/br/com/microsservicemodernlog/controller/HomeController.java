package br.com.microsservicemodernlog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/modernlog")
public class HomeController {

	@GetMapping
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("index");

		return modelView;
	}
}
