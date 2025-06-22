package com.example.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectmanager.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    
}
