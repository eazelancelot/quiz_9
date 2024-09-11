package com.example.quiz_9.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOrUpdateReq {
	
	private int id;

	@NotBlank(message = "Param quiz name error!!")
	private String name;

	@NotBlank(message = "Param description error!!")
	private String description;

	@NotNull(message = "Param start date error!!")
	@FutureOrPresent(message = "Param start date error!!")
	@JsonProperty("start_date")
	private LocalDate startDate;

	@NotNull(message = "Param end date error!!")
	@JsonProperty("end_date")
	private LocalDate endDate;

	@Valid
	@NotEmpty(message = "Param question list not found!!")
	@JsonProperty("question_list")
	private List<Question> questionList;

	@JsonProperty("is_published")
	private boolean published;

	public CreateOrUpdateReq() {
		super();
	}

	public CreateOrUpdateReq(String name, String description, LocalDate startDate, LocalDate endDate,
			List<Question> questionList, boolean published) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionList = questionList;
		this.published = published;
	}

	public CreateOrUpdateReq(int id, String name, String description, LocalDate startDate, LocalDate endDate,
			List<Question> questionList, boolean published) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionList = questionList;
		this.published = published;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public boolean isPublished() {
		return published;
	}

	public int getId() {
		return id;
	}

}
