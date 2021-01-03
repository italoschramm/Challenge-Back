package com.italoschramm.apivotacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.italoschramm.apivotacao.dto.ResultVotesDTO;
import com.italoschramm.apivotacao.dto.ResultVotesTimeDTO;
import com.italoschramm.apivotacao.service.voting.VotingLogService;


@RestController
@RequestMapping("/votinglog")
public class VotingLogController {

	@Autowired
	private VotingLogService votingLogService;
	
	@GetMapping("/getTotalVotes/{idVoting}")
	public ResponseEntity<String> getTotalVotes(@PathVariable Long idVoting){
		long totalVotes = 0;
		try {
			totalVotes = votingLogService.getTotalVotes(idVoting);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error! " + e.getMessage());
		}
			return ResponseEntity.status(HttpStatus.OK).body("Total Votes: " + totalVotes);
	}
	
	@GetMapping("/getTotalVotesByParticipant/{idVoting}")
	public ResponseEntity<String> getTotalVotesByParticipant(@PathVariable Long idVoting){
		ResultVotesDTO result = null;
		try {
			result = votingLogService.getTotalVotesByParticipant(idVoting);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error! " + e.getMessage());
		}
		Gson gson = new Gson();
		return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(result));
	}
	
	@GetMapping("/getTotalVotesByHour/{idVoting}")
	public ResponseEntity<String> getTotalVotesByHour(@PathVariable Long idVoting){
		ResultVotesTimeDTO result = null;
		try {
			result = votingLogService.getTotalVotesByHour(idVoting);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error! " + e.getMessage());
		}
		Gson gson = new Gson();
		return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(result));
	}
	
}
