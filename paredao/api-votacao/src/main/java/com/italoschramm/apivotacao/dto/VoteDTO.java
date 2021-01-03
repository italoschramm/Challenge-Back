package com.italoschramm.apivotacao.dto;

public class VoteDTO {

	private Long idVoting;
	
	private Long idParticipant;
	
	private Long idUser;

	public Long getIdVoting() {
		return idVoting;
	}

	public void setIdVoting(Long idVoting) {
		this.idVoting = idVoting;
	}

	public Long getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(Long idParticipant) {
		this.idParticipant = idParticipant;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
}
