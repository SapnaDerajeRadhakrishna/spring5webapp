package org.maxwell.springframework.controller;

import org.maxwell.springframework.respository.AuthorRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

	private AuthorRespository authorRespository;

	public AuthorController(AuthorRespository authorRespository) {
		this.authorRespository = authorRespository;
	}

	@RequestMapping("/authors")
	public String getBooks(Model model) {
		model.addAttribute("authors", authorRespository.findAll());
		return "authors";
	}

}
