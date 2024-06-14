package com.example.quiz_9.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz_9.entity.Response;

@Repository
public interface ResponseDao extends JpaRepository<Response, Integer>{
	
	public boolean existsByQuizIdAndPhone(int quizId, String phone);
	
	public List<Response> findByQuizId(int quizId);

}
