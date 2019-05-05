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
@Table(name = "enunciado")
public class QuestionModel implements Serializable {
	
	@Id
	@NotNull 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enunciado_id")
	private int question_id;
	
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
	@Column (name = "capitulo_tema")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cap_theme;
	
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
	
	public QuestionModel(int question_id, String question_text, int dificult_id, int cap_theme, int alternative_id, String alternative_text, boolean result) {
		setQuestion_id			(question_id		);
		setQuestion_text 		(question_text		);
		setDificult_id			(dificult_id		);
		setCap_theme			(cap_theme			);
		setAlternative_id		(alternative_id		);
		setAlternative_text		(alternative_text	);
		setResult				(result				);		
	}
	
	public QuestionModel() {
		this.question_id = -1;
	}
	
	public QuestionModel(QuestionModel qm) {
		setQuestion_id			(qm.getQuestion_id()		);
		setQuestion_text 		(qm.getQuestion_text()		);
		setDificult_id			(qm.getDificult_id()			);
		setCap_theme			(qm.getCap_theme()			);
		setAlternative_id		(qm.getAlternative_id()		);
		setAlternative_text		(qm.getAlternative_text()	);
		setResult				(qm.isResult()				);		
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
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

	public int getCap_theme() {
		return cap_theme;
	}

	public void setCap_theme(int cap_theme) {
		this.cap_theme = cap_theme;
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
		result = prime * result + cap_theme;
		result = prime * result + dificult_id;
		result = prime * result + question_id;
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
		QuestionModel other = (QuestionModel) obj;
		if (alternative_id != other.alternative_id)
			return false;
		if (alternative_text == null) {
			if (other.alternative_text != null)
				return false;
		} else if (!alternative_text.equals(other.alternative_text))
			return false;
		if (cap_theme != other.cap_theme)
			return false;
		if (dificult_id != other.dificult_id)
			return false;
		if (question_id != other.question_id)
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
