package com.example.projectmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectmanager.dto.ProjectNameUpdateDTO;
import com.example.projectmanager.dto.ProjectRequestDTO;
import com.example.projectmanager.dto.ProjectResponseDTO;
import com.example.projectmanager.dto.ProjectSummaryUpdateDTO;
import com.example.projectmanager.service.ProjectService;

@RestController
public class ProjectController {
	
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("/api/projects")
	public List<ProjectResponseDTO> getProjectList(){
		return projectService.getProjectList();
	}
	
	@GetMapping("/api/projects/{id}")
	public ProjectResponseDTO getProject(@PathVariable Integer id) {
		return projectService.getProject(id);
	}
	
	@PostMapping("/api/projects")
	public ResponseEntity<Integer> addProject(@RequestBody ProjectRequestDTO projectRequestDTO) {
		Integer id = projectService.addProject(projectRequestDTO);
		return ResponseEntity.ok(id);
	}
	
	@DeleteMapping("/api/projects/{id}")
	public void deleteProject(@PathVariable Integer id) {
		projectService.deleteProject(id);
	}
	
	@PatchMapping("/api/projects/{id}/name")
	public void updateProjectName(@PathVariable Integer id,
								  @RequestBody ProjectNameUpdateDTO dto) {
		projectService.updateProjectName(id, dto);
	}
	
	@PatchMapping("/api/projects/{id}/summary")
	public void updateProjectSummary(@PathVariable Integer id,
									 @RequestBody ProjectSummaryUpdateDTO dto) {
		projectService.updateProjectSummary(id, dto);
	}

}