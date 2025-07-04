package com.example.projectmanager.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projectmanager.dto.EmplementedRequestDTO;
import com.example.projectmanager.dto.FunctionRequestDTO;
import com.example.projectmanager.dto.FunctionResponseDTO;
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
	public Integer addFuncition(FunctionRequestDTO dto, Integer screenId) {
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
	
	@Override
	public List<FunctionResponseDTO> getFunctionList(Integer screenId){
		return functionRepository.findByScreenId(screenId)
				.stream()
				.sorted(Comparator.comparing(ScreenFunction::getSortKey))
				.map(FunctionResponseDTO::new)
				.toList();
	}
	@Override
	public void editEmplemented(Integer functionId, EmplementedRequestDTO dto) {
		ScreenFunction screenFunction = functionRepository.findById(functionId).orElseThrow();
		screenFunction.setImplemented(dto.isEmplemented());
		functionRepository.save(screenFunction);
	}
	
}




