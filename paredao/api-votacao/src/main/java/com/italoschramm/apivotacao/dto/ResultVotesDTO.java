package com.italoschramm.apivotacao.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultVotesDTO {

	private Long idVoting;
	
	private Long totalVotes = (long) 0;
	
	private List<ResultParticipantsVotesDTO> participants = new ArrayList<ResultParticipantsVotesDTO>();

	public Long getIdVoting() {
		return idVoting;
	}

	public void setIdVoting(Long idVoting) {
		this.idVoting = idVoting;
	}

	public Long getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(Long totalVotes) {
		this.totalVotes = totalVotes;
	}

	public List<ResultParticipantsVotesDTO> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ResultParticipantsVotesDTO> participants) {
		this.participants = participants;
	}
	
}
