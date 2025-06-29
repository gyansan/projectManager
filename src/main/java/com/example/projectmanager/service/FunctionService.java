package com.example.projectmanager.service;

import com.example.projectmanager.dto.FunctionRequestDto;

public interface FunctionService {
	
	Integer addFuncition(FunctionRequestDto dto, Integer screenId);
	

}
