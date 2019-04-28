package com.gameapi.model.entity;

import java.io.Serializable;
import java.util.ArrayList;





public class QuestionModelArray implements Serializable {
	private ArrayList<QuestionModel> array = new ArrayList<QuestionModel>();
	
	public ArrayList<QuestionModel> getArray() {
		return array;
	}
	
	public void setArray(ArrayList<QuestionModel> array) {
		this.array = array;
	}
	
	public QuestionModel getAlternative(int position) {
		if(position > -1 && position < array.size())
			return array.get(position);
		
		QuestionModel p = new QuestionModel();
		return p;
	}
	
	
//	Correct
	public QuestionModel getCorrectAlternative() {
		for(QuestionModel a: array) {
			if(a.isResult())
				return a;
		}
		
		QuestionModel p = new QuestionModel();
		return p;
	}
	
	
}
