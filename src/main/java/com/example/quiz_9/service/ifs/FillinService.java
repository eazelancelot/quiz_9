package com.example.quiz_9.service.ifs;

import com.example.quiz_9.vo.BasicRes;
import com.example.quiz_9.vo.FeedbackReq;
import com.example.quiz_9.vo.FeedbackRes;
import com.example.quiz_9.vo.FillinReq;
import com.example.quiz_9.vo.StatisticsRes;

public interface FillinService {

	public BasicRes fillin(FillinReq req);

	public FeedbackRes feedback(FeedbackReq req);
	
	public StatisticsRes statistics(FeedbackReq req);

}
