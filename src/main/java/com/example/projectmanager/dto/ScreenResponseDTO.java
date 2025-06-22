package com.example.projectmanager.dto;

import com.example.projectmanager.entity.Screen;

import lombok.Getter;

@Getter
public class ScreenResponseDTO {
	
	private Integer id;
	private String screenName;
	private String screenSummary;
	
	public ScreenResponseDTO(Screen screen) {
		this.id = screen.getId();
		this.screenName = screen.getScreenName();
		this.screenSummary = screen.getScreenSummary();
	}

}
