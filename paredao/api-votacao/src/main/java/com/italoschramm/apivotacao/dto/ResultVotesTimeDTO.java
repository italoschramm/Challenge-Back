package com.italoschramm.apivotacao.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultVotesTimeDTO {

	private Long idVoting;
	
	private List<TimeVotesDTO> timeVotes = new ArrayList<TimeVotesDTO>();

	public Long getIdVoting() {
		return idVoting;
	}

	public void setIdVoting(Long idVoting) {
		this.idVoting = idVoting;
	}

	public List<TimeVotesDTO> getTimeVotes() {
		return timeVotes;
	}

	public void setTimeVotes(List<TimeVotesDTO> timeVotes) {
		this.timeVotes = timeVotes;
	}
	
}
