package com.example.quiz_9.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

	//@Min(value = 1): 表示 id 的數字要大於等於 1
	@Min(value = 1, message = "Param question id error!!")
	private int id;

	@NotBlank(message = "Param title error!!")
	private String title;

	private String options;

	@NotBlank(message = "Param type error!!")
	private String type;

	@JsonProperty("is_necessary")
	private boolean necessary;

	public Question() {
		super();
	}

	public Question(int id, String title, String options, String type, boolean necessary) {
		super();
		this.id = id;
		this.title = title;
		this.options = options;
		this.type = type;
		this.necessary = necessary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isNecessary() {
		return necessary;
	}

	public void setNecessary(boolean necessary) {
		this.necessary = necessary;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

}
