package com.example.projectmanager.service;

import java.util.List;

import com.example.projectmanager.dto.ScreenRequestDTO;
import com.example.projectmanager.dto.ScreenResponseDTO;

public interface ScreenService {
	
	Integer addScreen(ScreenRequestDTO dto, Integer projectId);
	List<ScreenResponseDTO> getScreenList(Integer projectId);
	void updateSortOrder(Integer projectId, List<Integer> sortedIds);
	ScreenResponseDTO getScreen(Integer screenId);
}
