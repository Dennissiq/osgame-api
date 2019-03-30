package com.gameapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gameapi.model.entity.Game;
import com.gameapi.model.service.GameService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class GameRestController {

	@Autowired
	GameService gameService;

//	@RequestMapping(method = RequestMethod.GET, value = "rest/filmes")
//	public @ResponseBody List<Game> listarFilmes() {
//		System.out.println("rest/filmes");
//		try {
//			return gameService.listarFilmes();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//			return new ArrayList<Game>();
//		}
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/")
	public @ResponseBody String gameName() {
		
	return "Round Robin 1 Quantum NP";
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/random")
	public @ResponseBody String randomGame() {
		
		double randomDouble = Math.random();
		randomDouble = randomDouble * 5;
		int randomInt = (int) randomDouble;
		String gameMode;
				
		if (randomInt == 0) {
			gameMode = "FCFS";
		} else if(randomInt == 1){
			gameMode = "SJF";
		}
		else if (randomInt == 2){
			gameMode = "por Prioridade";
		} 
		else if (randomInt == 3 ) {
			gameMode = "Round Robin 1 Quantum NP";
		} else {
			gameMode = "Round Robin 1 Quantum P";
		}
//		else {
//			gameMode = "Round Robin 2 Quantums NP";
//		}
		
		
		System.out.println("Type: " + randomInt + " - Scheduler: " + gameMode);	
		
	return gameMode;
	}

//	@RequestMapping(method = RequestMethod.POST, value = "rest/filmes")
//	public ResponseEntity<Game> criarFilme(@RequestBody Game filme) {
//		try {
//			filmeService.inserirFilme(filme);
//			return new ResponseEntity<Game>(filme, HttpStatus.OK);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return new ResponseEntity<Game>(filme, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	
//	@RequestMapping(method = RequestMethod.DELETE, value = "rest/filmes")
//	public ResponseEntity<Game> excluirFilme(@RequestBody Game filme) {
//		try {
//			filmeService.excluirFilme(filme);
//			return new ResponseEntity<Game>(filme, HttpStatus.OK);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return new ResponseEntity<Game>(filme, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, value = "rest/filmes")
//	public ResponseEntity<Game> atualizarFilme(@RequestBody Game filme) {
//		try {
//			filmeService.atualizarFilme(filme);
//			return new ResponseEntity<Game>(filme, HttpStatus.OK);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return new ResponseEntity<Game>(filme, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value = "rest/filmes/filtro/{chave}")
//	public ResponseEntity<List<Game>> listarFilme(@PathVariable("chave") String chave) {
//		List<Game> lista = null;
//	
//		try {
//			lista = filmeService.listarFilmes(chave);			
//			return new ResponseEntity<List<Game>>(lista, HttpStatus.OK);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return new ResponseEntity<List<Game>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
}
