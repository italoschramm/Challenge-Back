package com.italoschramm.apivotacao.client;

import java.util.Date;
import java.util.List;

public class VotingClient {
	
	private Date dateStart;
	
	private Date dateEnd;
	
	private Boolean active;

	private List<ParticipantClient> participants;

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

	public List<ParticipantClient> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantClient> participants) {
		this.participants = participants;
	}
	
}
