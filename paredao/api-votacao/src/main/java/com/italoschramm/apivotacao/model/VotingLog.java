package com.italoschramm.apivotacao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VOTINGLOG")
public class VotingLog {

	@Id
	@Column(name = "IDVOTINGLOG")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE_IDVOTINGLOG")
	@SequenceGenerator(name="SEQUENCE_VOTINGLOG", sequenceName="SEQ_IDVOTINGLOG", allocationSize=1)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "IDVOTING", updatable = false)
    private Voting voting;
	
	@ManyToOne
    @JoinColumn(name = "IDPARTICIPANT", updatable = false)
    private Participant participant;
	
	@ManyToOne
    @JoinColumn(name = "IDUSER", updatable = false)
    private User user;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "VOTE")
	private long vote;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Voting getVoting() {
		return voting;
	}

	public void setVoting(Voting voting) {
		this.voting = voting;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getVote() {
		return vote;
	}

	public void setVote(long vote) {
		this.vote = vote;
	}
	
}
