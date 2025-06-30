package com.example.projectmanager.service;

import java.util.List;

import com.example.projectmanager.dto.FunctionRequestDTO;
import com.example.projectmanager.dto.FunctionResponseDTO;

public interface FunctionService {
	
	Integer addFuncition(FunctionRequestDTO dto, Integer screenId);
	List<FunctionResponseDTO> getFunctionList(Integer screenId);
	

}
