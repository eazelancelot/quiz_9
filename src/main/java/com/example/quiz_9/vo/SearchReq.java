package com.example.quiz_9.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchReq {

	private String name = "";

	@JsonProperty("start_date")
	private LocalDate startDate = LocalDate.of(1970, 1, 1);

	@JsonProperty("end_date")
	private LocalDate endDate = LocalDate.of(2999, 12, 31);
	
	public SearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchReq(String name, LocalDate startDate, LocalDate endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

}
