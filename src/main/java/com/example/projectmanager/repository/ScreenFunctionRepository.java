package com.example.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projectmanager.entity.ScreenFunction;

@Repository
public interface ScreenFunctionRepository extends JpaRepository<ScreenFunction, Integer> {
	
	@Query("SELECT COALESCE(MAX(f.sortKey), 0) FROM ScreenFunction f WHERE f.screen.id = :screenId")
	int findMaxSortKeyByScreenId(@Param("screenId") Integer screenId);

}
