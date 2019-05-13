package com.gameapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

import com.gameapi.model.entity.QuestionModel;
import com.gameapi.model.service.GameService;
import com.gameapi.model.service.QuestionService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class GameRestController {

	@Autowired
	GameService gameService;
	
	@Autowired 
	QuestionService questionService;
	
	Gson gson = new Gson();

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
	
//	@RequestMapping(method = RequestMethod.GET, value = "rest/game/fcfs", produces = MediaType.APPLICATION_JSON_VALUE)
//	ResponseEntity<String> gameFcfs() {
////	String fcfs = "FCFS";
//	
////	return "FCFS";
//	String jsonFCFS = "{'name': 'FCFS'}";
//	
//	return ResponseEntity.ok(gson.toJson(jsonFCFS));
//	
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/fcfs")
	public @ResponseBody String gameFcfs() {
//	String fcfs = "FCFS";
	
	return "FCFS";
	
//	return new ResponseEntity(fcfs, HttpStatus.OK);
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/sjf")
	public @ResponseBody String gameSjf() {
		
	return "SJF";
	
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/priority")
	public @ResponseBody String gamePriority() {
		
	return "por Prioridade";
	
	}
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/lottery")
	public @ResponseBody String gameLottery() {
		
	return "por Loteria";
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/roundrobin/preemptive")
	public @ResponseBody String gameRrp() {
		
	return "Round Robin 1 Quantum P";
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/roundrobin/nonpreemptive")
	public @ResponseBody String gameRrnp() {
		
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
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/random/2")
	public @ResponseBody String randomGameLimited() {
		
		double randomDouble = Math.random();
		randomDouble = randomDouble * 2;
		int randomInt = (int) randomDouble;
		String gameMode;
				
		if (randomInt == 0) {
			gameMode = "FCFS";
		} else{
			gameMode = "SJF";
		}

		
		System.out.println("Type: " + randomInt + " - Scheduler: " + gameMode);	
		
	return gameMode;
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "rest/game/firstFit")
	public @ResponseBody String gameFirstFit() {
		
	return "First Fit";
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/nextFit")
	public @ResponseBody String gameNextFit() {
		
	return "Next Fit";
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/bestFit")
	public @ResponseBody String gameBestFit() {
		
	return "Best Fit";
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/worstFit")
	public @ResponseBody String gameWorstFit() {
		
	return "Worst Fit";
	
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "rest/game/memory/random")
	public @ResponseBody String randomMemoryGame() {
		
		double randomDouble = Math.random();
		randomDouble = randomDouble * 5;
		int randomInt = (int) randomDouble;
		String gameMode;
				
		if (randomInt == 0) {
			gameMode = "firstFit.html";
		} else if(randomInt == 1){
			gameMode = "nextFit.html";
		}
		else if (randomInt == 2){
			gameMode = "bestFit.html";
		} 
		else  {
			gameMode = "worstFit.html";
		}
		System.out.println("Type: " + randomInt + " - memoryUrl: " + gameMode);	
		
		return gameMode;
	}
	
	
	
	

	@RequestMapping(method = RequestMethod.GET, value = "/rest/quiz/questions", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<QuestionModel>> loadQuestions(){
		List<QuestionModel> listQuestion= null;
		
		try {
//			the parameters 0 and 1 are fixed, use the @PathVariable to set this parameters and in the path value use {type}
			listQuestion = questionService.loadQuestions(0, 1);
			return new ResponseEntity<List<QuestionModel>>(listQuestion, HttpStatus.OK);
			
		} 
		catch (Exception e ) {
			e.printStackTrace();
			return new ResponseEntity <List<QuestionModel>>(listQuestion, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
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
