package com.example.projectmanager.service;

import org.springframework.stereotype.Service;

import com.example.projectmanager.dto.FunctionRequestDto;
import com.example.projectmanager.entity.Screen;
import com.example.projectmanager.entity.ScreenFunction;
import com.example.projectmanager.repository.ScreenFunctionRepository;
import com.example.projectmanager.repository.ScreenRepository;

@Service
public class FunctionServiceImpl implements FunctionService {
	
	private final ScreenRepository screenRepository;
	private final ScreenFunctionRepository functionRepository;
	
	
	public FunctionServiceImpl(ScreenRepository screenRepository,
								ScreenFunctionRepository functionRepository) {
		this.screenRepository = screenRepository;
		this.functionRepository = functionRepository;
	}
	
	@Override
	public Integer addFuncition(FunctionRequestDto dto, Integer screenId) {
		Screen screen = screenRepository.findById(screenId).orElseThrow();
		ScreenFunction function = new ScreenFunction();
		function.setScreen(screen);
		function.setFunctionName(dto.getFunctionName());
		function.setFunctionSummary(dto.getFunctionSummary());
		
		System.out.println(dto.getFunctionSummary());
		
		int maxSortKey = functionRepository.findMaxSortKeyByScreenId(screenId);
		function.setSortKey(maxSortKey + 1);
		
		return functionRepository.save(function).getId();
		
	}
	
}
