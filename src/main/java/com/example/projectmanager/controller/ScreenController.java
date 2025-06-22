package com.example.projectmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectmanager.dto.ScreenRequestDTO;
import com.example.projectmanager.dto.ScreenResponseDTO;
import com.example.projectmanager.dto.SortOrderUpdateRequestDTO;
import com.example.projectmanager.service.ScreenService;

@RestController
public class ScreenController {
	
	private final ScreenService screenService;
	
	public ScreenController(ScreenService screenService) {
		this.screenService = screenService;
	}
	
	@GetMapping("/api/projects/{project_id}/screens/list")
	public List<ScreenResponseDTO> getScreenList(@PathVariable Integer project_id){
		return screenService.getScreenList(project_id);
	}
	
	@PostMapping("/api/projects/{project_id}/screens")
	public ResponseEntity<Integer> addScreen(@PathVariable Integer project_id,
											@RequestBody ScreenRequestDTO dto){
		Integer screenId = screenService.addScreen(dto, project_id);
		return ResponseEntity.ok(screenId);
	}
	
	@PatchMapping("/api/projects/{project_id}/screens/sort-order")
	public void updateSortOrder(@PathVariable Integer project_id,
								@RequestBody SortOrderUpdateRequestDTO response) {
		screenService.updateSortOrder(project_id, response.getSortedIds());
	}
	
	@GetMapping("/api/projects/{project_id}/screens/{screen_id}")
	public ScreenResponseDTO getScreen(@PathVariable Integer screen_id) {
		return screenService.getScreen(screen_id);
	}

}
