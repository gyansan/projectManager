package com.example.projectmanager.service;

import java.util.List;

import com.example.projectmanager.dto.ProjectNameUpdateDTO;
import com.example.projectmanager.dto.ProjectRequestDTO;
import com.example.projectmanager.dto.ProjectResponseDTO;
import com.example.projectmanager.dto.ProjectSummaryUpdateDTO;

public interface ProjectService {
    List<ProjectResponseDTO> getProjectList();
    ProjectResponseDTO getProject(Integer id);
    Integer addProject(ProjectRequestDTO profectRequestDTO);
    void deleteProject(Integer id);
    void updateProjectName(Integer id,ProjectNameUpdateDTO dto);
    void updateProjectSummary(Integer id,ProjectSummaryUpdateDTO dto);
}