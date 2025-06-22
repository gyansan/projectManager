package com.example.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projectmanager.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
	
	@Query("SELECT COALESCE(MAX(s.sortKey),0) FROM Screen s WHERE s.project.id = :projectId")
	int findMaxSortKeyByProjectId(@Param("projectId") Integer projectId);
	
	List<Screen> findByProjectId(Integer projectId);
}
