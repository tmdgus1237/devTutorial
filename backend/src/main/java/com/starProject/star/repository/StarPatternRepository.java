package com.starProject.star.repository;

import com.starProject.star.domain.Pattern;

public class StarPatternRepository {
	Pattern pattern;
	
	public StarPatternRepository(Pattern pattern) {
		super();
		this.pattern = pattern;
	}
	
	public String[] getStars() {
		int row = pattern.getRowNum();
		int p = pattern.getPatternNum();
		String[] stars = new String[row];
		int startPoint = 0;
		
		switch(p) {
		case 0:
			stars[0] = "*";
			for(int i = 1; i < row; i++) {
				stars[i] = stars[i-1] + "*";
			}
			break;
		case 1:
			stars[row-1] = "*";
			for(int i = 1; i < row; i++) {
				stars[row-1] += "*";
			}
			for(int i = row-2; i >= 0; i--) {
				stars[i] = "\u00a0" + stars[i+1];
			}
			break;
		case 2:
			stars[row-1] = "*";
			for(int i = row-2; i >= 0; i--) {
				stars[i] = "\u00a0" + stars[i+1] + "*";
			}
			break;
		case 3:
			stars[row-1] = "*";
			for(int i = row-2; i >= 0; i--) {
				stars[i] = stars[i+1] + "*";
			}
			break;
		case 4:
			stars[0] = "*";
			if(row == 1) return stars;
			stars[row-1] = stars[0];
			for(int i = 1; i < row / 2; i++) {
				stars[i] = stars[i-1] + "*";
				stars[row-1-i] = stars[i]; 
			}
			stars[row/2] = stars[(row/2)+1] + "*";
			break;
		default:
			return null;
		}
		
		
		return stars;
	}
	
	
}
