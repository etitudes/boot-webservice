package com.example.bootdemo.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

	Stream<Posts> findAllByOrderByIdDesc();
}
