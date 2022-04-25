package com.starProject.star.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starProject.star.domain.Pattern;
import com.starProject.star.repository.StarPatternRepository;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class PatternController {

	@GetMapping("/api/star")
	public String[] PatternMvc(@RequestParam("pattern") int pattern, @RequestParam("row") int row) {
		Pattern p = new Pattern(pattern, row);
		StarPatternRepository starPattern = new StarPatternRepository(p);
		
		return starPattern.getStars();
		
	}
}
