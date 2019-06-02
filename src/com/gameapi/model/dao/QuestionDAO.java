package com.gameapi.model.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import com.gameapi.model.entity.QuestionModel;



@Repository
public class QuestionDAO {
	@PersistenceContext
	EntityManager manager;
//	select prod from Produto prod join prod.categorias c where c.idCategoria = 1 
	
	public List<QuestionModel> selecionar() {
		 TypedQuery<QuestionModel> 
		    query = manager.createQuery("select"
		    		+ " new AlternativeModel(v.id"
		    		+ "from QuestionModel v "
		    		
		    		, QuestionModel.class);
		 List<QuestionModel> result = query.getResultList();
		    
		    return result;
		  }
	
	public List<Integer>  mostrarIds() {
		TypedQuery<Integer>
		query = manager.createQuery("select id From QuestionModel", Integer.class);
		 List<Integer> result = query.getResultList();
		    
		    return result;
		
		
	}
	
		
		
				
	}


