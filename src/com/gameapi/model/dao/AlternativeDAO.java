package com.gameapi.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gameapi.model.entity.AlternativeModel;

@Repository
public class AlternativeDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public  List<AlternativeModel> mostrarAlternativas(int id) {
		TypedQuery<AlternativeModel> 
	    query = manager.createQuery(
	    		"select "
	    		+ "new AlternativeModel(id, text, question_id ) "
	    		+ "from AlternativeModel v "
	    		+ "where v.question_id = " + id
	    		, AlternativeModel.class);
               
	    return query.getResultList();
	  }
	
	public  List<AlternativeModel> mostrarResposta(int id) {
		TypedQuery<AlternativeModel> 
	    query = manager.createQuery(
	    		"select"
	    		+ " v "
	    		+ " from AlternativeModel v "
	    		+ "where v.question_id = " + id
	    		, AlternativeModel.class);
		
		return query.getResultList();
	  }
	


}
