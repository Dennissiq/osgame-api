package com.gameapi.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "alternativa")
public class AlternativeModel implements Serializable {
	
	
	@Id
	@NotNull 
	@Column (name = "alternativa_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int alternative_id;
	
	@NotNull
	@Column (name = "dificuldade_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dificult_id;
	
	
	@NotNull
	@Column (name = "enunciado_text")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String question_text;
	
	@NotNull
	@Column (name = "alternativa_text")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String alternative_text;
	
	@NotNull
	@Column (name = "resultado")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private boolean result;
	
	public AlternativeModel(int question_id, String question_text, int dificult_id, int alternative_id, String alternative_text, boolean result) {
		setQuestion_text 		(question_text		);
		setDificult_id			(dificult_id		);
		setAlternative_id		(alternative_id		);
		setAlternative_text		(alternative_text	);
		setResult				(result				);		
	}
	
	public AlternativeModel() {
		this.alternative_id = -1;
	}
	
	public AlternativeModel(AlternativeModel qm) {
		setQuestion_text 		(qm.getQuestion_text()		);
		setDificult_id			(qm.getDificult_id()			);
		setAlternative_id		(qm.getAlternative_id()		);
		setAlternative_text		(qm.getAlternative_text()	);
		setResult				(qm.isResult()				);		
	}


	public int getAlternative_id() {
		return alternative_id;
	}

	public void setAlternative_id(int alternative_id) {
		this.alternative_id = alternative_id;
	}

	public int getDificult_id() {
		return dificult_id;
	}

	public void setDificult_id(int dificult_id) {
		this.dificult_id = dificult_id;
	}



	public String getQuestion_text() {
		return question_text;
	}

	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}

	public String getAlternative_text() {
		return alternative_text;
	}

	public void setAlternative_text(String alternative_text) {
		this.alternative_text = alternative_text;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alternative_id;
		result = prime * result + ((alternative_text == null) ? 0 : alternative_text.hashCode());
		result = prime * result + dificult_id;
		result = prime * result + ((question_text == null) ? 0 : question_text.hashCode());
		result = prime * result + (this.result ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlternativeModel other = (AlternativeModel) obj;
		if (alternative_id != other.alternative_id)
			return false;
		if (alternative_text == null) {
			if (other.alternative_text != null)
				return false;
		} else if (!alternative_text.equals(other.alternative_text))
			return false;
		if (dificult_id != other.dificult_id)
			return false;
		if (question_text == null) {
			if (other.question_text != null)
				return false;
		} else if (!question_text.equals(other.question_text))
			return false;
		if (result != other.result)
			return false;
		return true;
	}


	
}
