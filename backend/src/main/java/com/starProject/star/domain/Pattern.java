package com.starProject.star.domain;

public class Pattern {
	private int patternNum;
	private int rowNum;
	
	
	public Pattern(int patternNum, int rowNum) {
		super();
		this.patternNum = patternNum;
		this.rowNum = rowNum;
	}
	
	public int getPatternNum() {
		return patternNum;
	}
	public void setPatternNum(int patternNum) {
		this.patternNum = patternNum;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	
	
}
