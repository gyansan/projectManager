package com.example.projectmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectmanager.dto.EmplementedRequestDTO;
import com.example.projectmanager.dto.FunctionRequestDTO;
import com.example.projectmanager.dto.FunctionResponseDTO;
import com.example.projectmanager.service.FunctionService;

@RestController
public class FunctionController {
	
	private final FunctionService functionService;
	
	public FunctionController(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	@PostMapping("/api/projects/screens/{screen_id}/functions")
	public Integer addFunction(@PathVariable("screen_id") Integer screenId,
							@RequestBody FunctionRequestDTO dto) {
		
		return functionService.addFuncition(dto, screenId);
		 
	}
	
	@GetMapping("/api/projects/screens/{screen_id}/functions/list")
	public List<FunctionResponseDTO> getFunctionList(@PathVariable("screen_id") Integer screenId){
		return functionService.getFunctionList(screenId);
	}

	@PatchMapping("/api/projects/screens/functions/{function_id}/emplement")
	public void updateFunctionEmplemented(@PathVariable("function_id") Integer functionId,
										@RequestBody EmplementedRequestDTO dto){
		functionService.editEmplemented(functionId, dto);
	}
	
}
