package com.example.bootdemo.service;

import com.example.bootdemo.domain.posts.PostsRepository;
import com.example.bootdemo.web.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsService {
	private PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}

	@Transactional(readOnly = true)
	public List<PostMainResponseDto> findAllDesc() {
		return postsRepository.findAllByOrderByIdDesc()
			.map(PostMainResponseDto::new)
			.collect(Collectors.toList());
	}

}
