package com.example.quiz_9.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz_9.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
	
	public List<Quiz> findByNameContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String name,
			LocalDate start, LocalDate end);

}
