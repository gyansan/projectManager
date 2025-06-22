package com.example.projectmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "project_list")
@Data
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "project_name", nullable = false, length = 30)
	private String projectName;
	
	@Lob
	@Column(name = "project_summary")
	private String projectSummary;
	
	public Project() {}
	
	public Project(String projectName,String projectSummary) {
		this.projectName = projectName;
		this.projectSummary = projectSummary;
	}
	
}