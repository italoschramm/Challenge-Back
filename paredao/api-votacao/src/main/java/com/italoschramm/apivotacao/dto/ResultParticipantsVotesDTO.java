package com.italoschramm.apivotacao.dto;

public class ResultParticipantsVotesDTO {

	private Long idParticipant;
	
	private Long votes;
	
	public ResultParticipantsVotesDTO(Long votes, Long idParticipant) {
		this.idParticipant = idParticipant;
		this.votes = votes;
	}

	public Long getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(Long idParticipant) {
		this.idParticipant = idParticipant;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}
	
}
