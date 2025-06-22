package com.example.projectmanager.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.projectmanager.dto.ScreenRequestDTO;
import com.example.projectmanager.dto.ScreenResponseDTO;
import com.example.projectmanager.entity.Project;
import com.example.projectmanager.entity.Screen;
import com.example.projectmanager.repository.ProjectRepository;
import com.example.projectmanager.repository.ScreenRepository;

@Service
public class ScreenServiceImpl implements ScreenService {
	
	private final ProjectRepository projectRepository;
	private final ScreenRepository screenRepository;
	
	public ScreenServiceImpl(ProjectRepository projectRepository,
							ScreenRepository screenRepository) {
		this.projectRepository = projectRepository;
		this.screenRepository = screenRepository;
	}
	
	@Override
	public Integer addScreen(ScreenRequestDTO dto, Integer projectId) {
		Project project = projectRepository.findById(projectId).orElseThrow();
		Screen screen = new Screen();
		screen.setProject(project);
		screen.setScreenName(dto.getScreenName());
		screen.setScreenSummary(dto.getScreenSummary());
		int maxSortKey = screenRepository.findMaxSortKeyByProjectId(projectId);
		screen.setSortKey(maxSortKey + 1);
		
		return screenRepository.save(screen).getId();
	}
	
	@Override
	public List<ScreenResponseDTO> getScreenList(Integer projectId) {
		return screenRepository.findByProjectId(projectId)
				.stream()
				.sorted(Comparator.comparing(Screen::getSortKey))
				.map(ScreenResponseDTO::new)
				.toList();
	}
	
	@Override
	public void updateSortOrder(Integer projectId, List<Integer> sortedIds) {
		//スクリーンリスト取得
		List<Screen> screenList = screenRepository.findByProjectId(projectId);
		
		for(int i=0; i < sortedIds.size(); i++) {
			Integer id = sortedIds.get(i);
			for(Screen screen : screenList) {
				if(screen.getId().equals(id)) {
					screen.setSortKey(i + 1);
					break;
				}
			}
		}
		
		screenRepository.saveAll(screenList);
		
	}
	
	@Override
	public ScreenResponseDTO getScreen(Integer screenId) {
		Optional<Screen> optionalScreen = screenRepository.findById(screenId);
		
		if (optionalScreen.isEmpty()) {
			throw new RuntimeException("プロジェクトが見つかりません");
		}
		Screen screen = optionalScreen.get();
		return new ScreenResponseDTO(screen);
		
	}

}
