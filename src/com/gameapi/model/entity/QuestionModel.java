package com.gameapi.model.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



import com.sun.istack.internal.NotNull;

@Entity
@Table(name="questions")
public class QuestionModel  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull 
    @GeneratedValue
	@Column(name="id")
	private int id;
	
	@NotNull 
    @GeneratedValue
	@Column(name="question")
	private String question;

	public QuestionModel(int id, String question) {
		
		this.id = id;
		this.question = question;
	}
	
	public QuestionModel() {}
	
	
	public QuestionModel(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
}
