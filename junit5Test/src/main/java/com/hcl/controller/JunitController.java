package com.hcl.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.entity.JunitEntity;
import com.hcl.service.JunitService;

@Controller
@RequestMapping("junit5Test")
public class JunitController {

	@Autowired
	JunitService service;

	Logger logger = LoggerFactory.getLogger(JunitController.class);

	@GetMapping("/")
	String hello() {
		logger.info("Mapping to index");
		return "/index";
	}

	@PostMapping("/find")
	String find(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password,
			Model model) {
		logger.info("post mapping /find");

		Optional<JunitEntity> junit = service.findByUsername(username);
		boolean valid = false;
		valid = check1(username, password);
		if (valid) {
			model.addAttribute("username", junit.get().getUsername());
			model.addAttribute("message", "Welcome to Page!");
			return "/NewFile";
		} else {
			model.addAttribute("message", "User not Found");
			return "/index";
		}
	}

	public boolean check1(String username, String password) {
		if (service.existsByUsernameAndPassword(username, password)) {
			return true;
		} else {
			return false;
		}
	}

	@PostMapping(path = "/update")
	String update(@ModelAttribute("user") JunitEntity user, ModelMap model) {
		logger.info("in /update");
		Optional<JunitEntity> junit1 = service.findByUsername(user.getUsername());
		if (junit1.isPresent()) {
			model.addAttribute("message", "User Already Exists");
			return "/welcome";
		} else {
			String save = saveMethod(user);
			if (save.equalsIgnoreCase("Saved")) {
				model.addAttribute("message", "User Information Updated");
				return "/welcome";
			} else {
				model.addAttribute("message", "Error Occured on Updation");
				return "/index";
			}
		}
	}

	public String saveMethod(JunitEntity user) {
		try {
			service.update(user);
			return "Saved";
		} catch (Exception e) {
			return "Error";
		}
	}
}
