package com.example.projectmanager.dto;

import java.util.List;

public class SortOrderUpdateRequestDTO {
	
	private List<Integer> sortedIds;
	
	public List<Integer> getSortedIds(){
		return sortedIds;
	}
	
	public void setSortedIds(List<Integer> sortedIds) {
		this.sortedIds = sortedIds;
	}

}
