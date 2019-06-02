package com.gameapi.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gameapi.model.entity.AlternativeModel;
import com.gameapi.model.service.QuestionService;
import com.gameapi.model.service.AlternativeService;
import com.google.gson.Gson;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class GameRestController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private AlternativeService alternativeService;
	
	Gson gson = new Gson();

	
	@RequestMapping(method = RequestMethod.GET, value = "rest/game/fcfs")
	public @ResponseBody String gameFcfs() {
		return "FCFS";
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/rest/quiz/ids", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> mostrarIds(){
       List<Integer> listQuestion= null;
        
        try {
            listQuestion = questionService.mostrarIds();
            return new ResponseEntity<List<Integer>>(listQuestion, HttpStatus.OK);
        } catch (Exception e ) {
            e.printStackTrace();
            return new ResponseEntity<List<Integer>>(listQuestion, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/rest/quiz/alternatives/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlternativeModel>> mostrarAlternativas(@PathVariable("id") int id){
        List<AlternativeModel> listQuestion = null;
        
        try {
            listQuestion = alternativeService.mostrarAlternativas(id);
            return new ResponseEntity<List<AlternativeModel>>(listQuestion, HttpStatus.OK);
            
        } catch (Exception e ) {
            e.printStackTrace();
            System.out.println("Não é possível proseeguir. O objeto livro é nulo");            return new ResponseEntity<List <AlternativeModel>>(listQuestion, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/rest/quiz/correct/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlternativeModel>> mostrarResposta(@PathVariable("id") int id){
        List<AlternativeModel> listQuestion = null;
        
        try {
        	listQuestion = alternativeService.mostrarResposta(id);
            return new ResponseEntity<List<AlternativeModel>>(listQuestion, HttpStatus.OK);
            
        } 
        catch (Exception e ) {
            e.printStackTrace();
            return new ResponseEntity<List <AlternativeModel>>(listQuestion, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
