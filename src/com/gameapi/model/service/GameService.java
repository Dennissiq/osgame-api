package com.gameapi.model.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameapi.model.dao.GameDAO;
import com.gameapi.model.entity.Game;

//import br.usjt.arqsw18.pipoca.model.dao.FilmeDAO;

@Service
public class GameService {
	private GameDAO dao;
	
	@Autowired
	public GameService(GameDAO gdao) {
		dao = gdao;
	}
	
//	public Game buscarFilme(int id) throws IOException{
//		return dao.buscarFilme(id);
//	}
//	
//	@Transactional
//	public Game inserirFilme(Game filme) throws IOException {
//		int id = dao.inserirFilme(filme);
//		filme.setId(id);
//		return filme;
//	}
//	
//	@Transactional
//	public void excluirFilme(Game filme) throws IOException {
//		dao.removerFilme(filme);
//	}
//	
//	@Transactional
//	public void atualizarFilme(Game filme) throws IOException {
//		dao.atualizarFilme(filme);
//	}
//
//	public List<Game> listarFilmes(String chave) throws IOException{
//		return dao.listarFilmes(chave);
//	}
//
//	public List<Game> listarFilmes() throws IOException{
//		return dao.listarFilmes();
//	}

}
