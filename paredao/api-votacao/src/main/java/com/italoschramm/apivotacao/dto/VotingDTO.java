package com.italoschramm.apivotacao.dto;

import java.util.Date;
import java.util.List;

public class VotingDTO {
	
	private Date dateStart;
	
	private Date dateEnd;
	
	private Boolean active;

	private List<ParticipantDTO> participants;

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<ParticipantDTO> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantDTO> participants) {
		this.participants = participants;
	}
	
}
