package com.palindrom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.palindrom.model.Palindrom;
import com.palindrom.service.PalindromService;

@RestController
public class PalindromController {
	@Autowired
	private PalindromService palindromService;
	
	@PostMapping("/storeLongestPalindrom")
	public Palindrom storeLongestPalindrom(@RequestBody String input) throws Exception {
		if(input ==null || input.length()>1000) {
			throw new Exception("Invalid input string. please try with valid input");
		}
		return palindromService.storeLongestPalindrom(input);
	}
	
	@GetMapping("/retrieveLongestPalindrom/{input}")
	public String retrieveLongestPalindrom(@PathVariable("input") String input) {
		return palindromService.retrieveLongestPalindrom(input);
	}

}
