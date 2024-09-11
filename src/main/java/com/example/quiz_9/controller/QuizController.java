package com.example.quiz_9.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz_9.service.ifs.FillinService;
import com.example.quiz_9.service.ifs.QuizService;
import com.example.quiz_9.vo.BasicRes;
import com.example.quiz_9.vo.CreateOrUpdateReq;
import com.example.quiz_9.vo.DeleteReq;
import com.example.quiz_9.vo.FeedbackReq;
import com.example.quiz_9.vo.FeedbackRes;
import com.example.quiz_9.vo.FillinReq;
import com.example.quiz_9.vo.SearchReq;
import com.example.quiz_9.vo.SearchRes;
import com.example.quiz_9.vo.StatisticsRes;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private FillinService fillinService;
	
	@PostMapping(value = "quiz/create_update")
	public BasicRes create(@Valid @RequestBody CreateOrUpdateReq req) {
		return quizService.createOrUpdate(req);
	}
	
	@PostMapping(value = "quiz/search")
	public SearchRes search(@RequestBody SearchReq req) {
		return quizService.search(req);
	}
	
	@PostMapping(value = "quiz/search1")
	public SearchRes search1(@RequestBody SearchReq req) {
//		String name = req.getName();
//		LocalDate startDate = req.getStartDate();
//		LocalDate endDate = req.getEndDate();
//		if(!StringUtils.hasText(name)) {
//			name = "";
//		}
//		if(startDate == null) {
//			startDate = LocalDate.of(1970, 1, 1);
//		}
//		if(endDate == null) {
//			endDate = LocalDate.of(2999, 12, 31);
//		}
		// 三元表達式
		String name = !StringUtils.hasText(req.getName()) ? "" : req.getName();
		LocalDate startDate = req.getStartDate() == null ? LocalDate.of(1970, 1, 1) : req.getStartDate();
		LocalDate endDate = req.getEndDate() == null ? LocalDate.of(2999, 12, 31) : req.getEndDate();
		return quizService.search(name, startDate, endDate);
	}
	
	@Hidden
	@PostMapping(value = "quiz/delete")
	public BasicRes delete(@RequestBody DeleteReq req) {
		return quizService.delete(req);
	}
	
	@PostMapping(value = "quiz/fillin")
	public BasicRes fillin(@RequestBody FillinReq req) {
		return fillinService.fillin(req);
	}
	
	@PostMapping(value = "quiz/feedback")
	public FeedbackRes feedback(@RequestBody FeedbackReq req) {
		return fillinService.feedback(req);
	}
	
	@PostMapping(value = "quiz/statistics")
	public StatisticsRes statistics(@RequestBody FeedbackReq req) {
		return fillinService.statistics(req);
	}

}
