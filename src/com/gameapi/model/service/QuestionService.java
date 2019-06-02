package com.gameapi.model.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameapi.model.dao.QuestionDAO;

import com.gameapi.model.entity.QuestionModel;

@Service

public class QuestionService {
private QuestionDAO dao;
    
    @Autowired 
    public QuestionService(QuestionDAO adao) {
        dao = adao;
    }
    
    public  List<QuestionModel> selecionar() {
        return dao.selecionar();
    }
    
    public  List<Integer> mostrarIds() {
        return dao.mostrarIds();
    }

	
}
