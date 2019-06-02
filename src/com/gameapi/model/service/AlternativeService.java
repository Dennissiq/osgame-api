package com.gameapi.model.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameapi.model.dao.AlternativeDAO;
import com.gameapi.model.entity.AlternativeModel;

@Service
public class AlternativeService {
	private AlternativeDAO dao;
	
	@Autowired
	public AlternativeService(AlternativeDAO adao) {
	dao = adao;	
	}
	
	public List<AlternativeModel> mostrarAlternativas(int id){
		 return dao.mostrarAlternativas(id);
    }
	
	
	public List<AlternativeModel> mostrarResposta(int id){
		 return dao.mostrarResposta(id);
   }
	
	


}
