package com.example.projectmanager.dto;

import com.example.projectmanager.entity.ScreenFunction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FunctionResponseDTO {
	
	private int id;
	private String functionName;
	private String functionSummary;
	private boolean isEmplemented;
	
	public FunctionResponseDTO(ScreenFunction screenFunction) {
		this.id = screenFunction.getId();
		this.functionName = screenFunction.getFunctionName();
		this.functionSummary = screenFunction.getFunctionSummary();
		this.isEmplemented = screenFunction.isImplemented();
	}

}
