package com.example.projectmanager.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectmanager.dto.FunctionRequestDto;
import com.example.projectmanager.service.FunctionService;

@RestController
public class FunctionController {
	
	private final FunctionService functionService;
	
	public FunctionController(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	@PostMapping("/api/projects/{project_id}/screens/{screen_id}/functions")
	public Integer addFunction(@PathVariable("project_id") Integer projectId,
							@PathVariable("screen_id") Integer screenId,
							@RequestBody FunctionRequestDto dto) {
		
		return functionService.addFuncition(dto, screenId);
		 
	}

}
