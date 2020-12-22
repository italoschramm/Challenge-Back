package com.italoschramm.apivotacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoschramm.apivotacao.client.VoteClient;
import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.service.participant.ParticipantService;
import com.italoschramm.apivotacao.service.user.UserService;
import com.italoschramm.apivotacao.service.voting.VoteService;
import com.italoschramm.apivotacao.service.voting.VotingService;

@RestController
@RequestMapping("/vote")
public class VoteController {

	@Autowired
	private VoteService voteService;
	
	@Autowired
	private VotingService votingService;
	
	@Autowired
	private ParticipantService participantService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody VoteClient vote) {
		
		Voting voting = votingService.getVotingById(vote.getIdVoting());
		if(voting == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro! Voting id: " + vote.getIdVoting() + " not found!");
		
		Participant participant = participantService.getParticipantById(vote.getIdParticipant());
		if(participant == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro! Participant id: " + vote.getIdVoting() + " not found!");
		
		User user = userService.getUserById(vote.getIdUser());
		if(user == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro! User id: " + vote.getIdVoting() + " not found!");
	
		try {
			if(voteService.saveVote(voting, participant, user))
				 return ResponseEntity.status(HttpStatus.CREATED).body("Saved successfully.");
			else
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error! " + e.getMessage());
		}
	}
}
