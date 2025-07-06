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
	public ResponseEntity<List<ScreenResponseDTO>> getScreenList(@PathVariable("project_id") Integer projectId){
		List<ScreenResponseDTO> list = screenService.getScreenList(projectId);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/api/projects/{project_id}/screens")
	public ResponseEntity<Integer> addScreen(@PathVariable("project_id") Integer projectId,
											@RequestBody ScreenRequestDTO dto){
		Integer screenId = screenService.addScreen(dto, projectId);
		return ResponseEntity.ok(screenId);
	}
	
	@PatchMapping("/api/projects/{project_id}/screens/sort-order")
	public ResponseEntity<Void> updateSortOrder(@PathVariable("project_id") Integer projectId,
								@RequestBody SortOrderUpdateRequestDTO response) {
		screenService.updateSortOrder(projectId, response.getSortedIds());
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/api/projects/screens/{screen_id}")
	public ResponseEntity<ScreenResponseDTO> getScreen(@PathVariable("screen_id") Integer screenId) {                
		ScreenResponseDTO screen = screenService.getScreen(screenId);
		return ResponseEntity.ok(screen);
	}

}
