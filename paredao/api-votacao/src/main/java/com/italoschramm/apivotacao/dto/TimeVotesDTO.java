package com.italoschramm.apivotacao.dto;

import java.util.Date;

public class TimeVotesDTO {

	private Long votes = (long) 0;
	
	private Date time;

	public TimeVotesDTO(Long votes, Date time) {
		this.votes = votes;
		this.time = time;
	}
	
	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
