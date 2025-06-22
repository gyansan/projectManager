package com.example.projectmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "screen_function")
@Data
public class ScreenFunction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "screen_id", nullable = false)
	private Screen screen;
	
	@Column(name = "function_name")
	private String functionName;
	
	@Lob
	@Column(name = "function_summary")
	private String functionSummary;
	
	@Column(name = "sort_key")
	private int sortKey;
	
	@Column(name = "is_implemented", nullable = false)
	private boolean isImplemented = false;

}
