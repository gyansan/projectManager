package com.example.projectmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.projectmanager.dto.ProjectNameUpdateDTO;
import com.example.projectmanager.dto.ProjectRequestDTO;
import com.example.projectmanager.dto.ProjectResponseDTO;
import com.example.projectmanager.dto.ProjectSummaryUpdateDTO;
import com.example.projectmanager.entity.Project;
import com.example.projectmanager.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository projectRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	@Override
	public List<ProjectResponseDTO> getProjectList(){
		
		return projectRepository.findAll()
				.stream()
				.map(ProjectResponseDTO::new)
				.toList();
	}
	
	@Override
	public ProjectResponseDTO getProject(Integer id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		
		if (optionalProject.isEmpty()) {
			throw new RuntimeException("プロジェクトが見つかりません");
		}
		
		Project project = optionalProject.get();
		return new ProjectResponseDTO(project);
	}
	
	@Override
	public Integer addProject(ProjectRequestDTO projectRequestDTO) {
		Project project = new Project();
		project.setProjectName(projectRequestDTO.getProjectName());
		
		return projectRepository.save(project).getId();
	}
	
	@Override
	public void deleteProject(Integer id) {
		projectRepository.deleteById(id);
	}
	
	@Override
	public void updateProjectName(Integer id, ProjectNameUpdateDTO dto) {
		Project project = projectRepository.findById(id).orElseThrow();
		project.setProjectName(dto.getProjectName());
		projectRepository.save(project);
	}
	
	@Override
	public void updateProjectSummary(Integer id, ProjectSummaryUpdateDTO dto) {
		Project project = projectRepository.findById(id).orElseThrow();
		project.setProjectSummary(dto.getProjectSummary());
		projectRepository.save(project);
	}

}