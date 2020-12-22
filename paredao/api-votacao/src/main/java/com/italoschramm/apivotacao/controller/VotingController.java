package com.italoschramm.apivotacao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoschramm.apivotacao.client.ParticipantClient;
import com.italoschramm.apivotacao.client.VotingClient;
import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.service.participant.ParticipantService;
import com.italoschramm.apivotacao.service.voting.VotingService;

@RestController
@RequestMapping("/voting")
public class VotingController {

	@Autowired
	private VotingService votingService;
	
	@Autowired
	private ParticipantService participantService;
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody VotingClient voting) {
		
		if (votingService.existsVoting(voting.getDateStart(), voting.getDateEnd()))
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Voting already exists!");
		
		List<Participant> participants =  new ArrayList<Participant>();
		for(ParticipantClient participantClient : voting.getParticipants()) {
			Participant participant = participantService.getParticipantById(participantClient.getId());
			if(participant != null)
				participants.add(participant);
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro! Participant id: " + participantClient.getId() + " not found!");
		}
		
		try {
			if(votingService.registerVoting(voting.getDateStart(), voting.getDateEnd(), participants, voting.getActive()))
				 return ResponseEntity.status(HttpStatus.CREATED).body("Saved successfully.");
			else
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error! " + e.getMessage());
		}
	}
	
	@GetMapping("/listActiveVoting")
    public ResponseEntity<List<Voting>> listAtctive() {
		List<Voting> list = votingService.listVotingActive();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/listInactiveVoting")
    public ResponseEntity<List<Voting>> listInactive() {
		return ResponseEntity.status(HttpStatus.OK).body(votingService.listVotingInactive());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		try {
			 votingService.deleteVoting(id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error! " + e.getMessage());
		}
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted!");
	}
	
	@PutMapping("/inactive/{id}")
	public ResponseEntity<String> inactive(@PathVariable Long id){
		if(votingService.inactiveVoting(id));
			return ResponseEntity.status(HttpStatus.OK).body("Successfully inactved!");
	}
	
	@PutMapping("/active/{id}")
	public ResponseEntity<String> active(@PathVariable Long id){
		if(votingService.activeVoting(id));
			return ResponseEntity.status(HttpStatus.OK).body("Successfully actived!");
	}

}
