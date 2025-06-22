package com.example.projectmanager.dto;

import com.example.projectmanager.entity.Project;

import lombok.Getter;

@Getter
public class ProjectResponseDTO {
	
	private Integer id;
	private String projectName;
	private String projectSummary;
	
	public ProjectResponseDTO(Project project) {
		this.id = project.getId();
		this.projectName = project.getProjectName();
		this.projectSummary = project.getProjectSummary();
	}

}
