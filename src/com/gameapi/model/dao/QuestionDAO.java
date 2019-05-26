package com.gameapi.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gameapi.model.entity.QuestionModel;
import com.gameapi.model.entity.QuestionModelArray;
import com.gameapi.model.entity.AlternativeModel;

//@Repository
//public class QuestionDAO {
//	@PersistenceContext
//	EntityManager manager;
//	
//	public QuestionModelArray[] loadQuestions(int arg1, int arg2) {
//		QuestionModelArray[] 		modelArray;
//		String					jpqlSelect, type;
//		
//		modelArray = new QuestionModelArray[0];
//		type = (arg1 == 0 ? "capitulo" : (arg1 == 1 ? "dificuldade_id" : ""));
//		jpqlSelect = "SELECT enunciado_id FROM enunciado WHERE :type = ? ORDER BY RAND() LIMIT 10";
//		
//		Query query = manager.createQuery(jpqlSelect);
//		query.setParameter("type", "%"+type+"%");
//		
//		QuestionModelArray[] result = query.getResultList();
//		
//		return result;
//				
////				select f from Filme f where f.titulo like :chave
//	}
//
//}

@Repository
public class QuestionDAO {
	@PersistenceContext
	EntityManager manager;
	
//	Load questions
	public List<QuestionModel> loadQuestions(int arg1, int arg2) {
		QuestionModelArray[] 		modelArray;
		String					jpqlSelect, type;
		
		modelArray = new QuestionModelArray[0];
		type = (arg1 == 0 ? "cap_theme" : (arg1 == 1 ? "dificult" : ""));
//		jpqlSelect = "SELECT enunciado_id FROM enunciado WHERE :type = ? ORDER BY RAND() LIMIT 10";
		
//		Perguntas
		jpqlSelect = "SELECT question_id as id, question_text as question FROM QuestionModel WHERE dificult_id = 1 ORDER BY RAND()";
		
		
//		Alternativas
//		jpqlSelect = "SELECT question_text, alternative_text, result FROM QuestionModel INNER JOIN AlternativeModel Where question_id = 2 ORDER BY Rand()";
//		jpqlSelect = "SELECT question_text as question, alternative_text as alternative, result FROM AlternativeModel ORDER BY Rand()";
		Query query = manager.createQuery(jpqlSelect);
//		query.setParameter("type", "%"+type+"%");
		
		List<QuestionModel> result = query.getResultList();
		
		return result;
	}
//	Load alternatives
	public List<QuestionModel> loadAlternatives(int id){
		QuestionModelArray List;
		QuestionModel qm;
		String jpqlSelect;
		
		jpqlSelect = "SELECT e.enunciado_text, e.dificuldade_id, e.capitulo_tema, "
				+ "a.alternativa_id, a.alternativa_text, a.resultado "
				+ "FROM enunciado e INNER JOIN alternativa a "
				+ "ON e.enunciado_id = a.enunciado_id WHERE e.enunciado_id = ? "
				+ "ORDER BY Rand()";
		
		Query query = manager.createQuery(jpqlSelect);
		
		qm = new QuestionModel();
		
		qm.setQuestion_id		(id);
		qm.setQuestion_text		(query.getParameterValue("e.enunciado_text").toString());
		qm.setDificult_id		((int) query.getParameterValue("e.dificuldade_id"));
		qm.setCap_theme			((int) query.getParameterValue("e.capitulo_tema"));
		qm.setAlternative_id	((int) query.getParameterValue("a.alternativa_id"));
//		qm.setAlternative_text	(query.getParameterValue("a.alternativa_text").toString());
		qm.setResult			((boolean) query.getParameterValue("a.resultado"));
		
		List<QuestionModel> result = query.getResultList();
		
		return result;
	}
	
	

}
