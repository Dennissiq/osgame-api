package com.gameapi.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;
@Entity
@Table(name="alternative")
public class AlternativeModel  implements Serializable{
	
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
	@Column(name="text")
	private String text;
	
	@NotNull
	@Column(name="answer")
	private int answer;
	
	
	@NotNull
	@JoinColumn(name="question_id")
	@ManyToOne
	
	private QuestionModel question_id;
	
	public AlternativeModel() {}
	
	public AlternativeModel(int id, String text, QuestionModel question_id) {
		this.id = id;
		this.text = text;
		this.question_id = question_id;
		
	}
	
	public AlternativeModel(int id, String text, QuestionModel question_id, int answer) {
		this.id = id;
		this.text = text;
		this.question_id = question_id;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public QuestionModel getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(QuestionModel question_id) {
		this.question_id = question_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	



	
	
	
	

}
