package com.example.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectmanager.entity.ScreenFunction;

@Repository
public interface ScreenFunctionRepository extends JpaRepository<ScreenFunction, Integer> {
	
	

}
