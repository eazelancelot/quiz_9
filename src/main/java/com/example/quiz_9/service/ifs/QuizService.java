package com.example.quiz_9.service.ifs;

import java.time.LocalDate;

import com.example.quiz_9.vo.BasicRes;
import com.example.quiz_9.vo.CreateOrUpdateReq;
import com.example.quiz_9.vo.DeleteReq;
import com.example.quiz_9.vo.SearchReq;
import com.example.quiz_9.vo.SearchRes;

public interface QuizService {
	
	public BasicRes createOrUpdate(CreateOrUpdateReq req);
	
	public SearchRes search(SearchReq req);
	
	public SearchRes search(String name, LocalDate startDate, LocalDate endDate);
	
	public BasicRes delete(DeleteReq req);

}
