package com.italoschramm.apivotacao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="VOTINGPARTICIPANTS")
public class VotingParticipants {
	
	@Id
	@Column(name = "IDVOTINGPARTICIPANTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE_IDVOTINGPARTICIPANTS")
	@SequenceGenerator(name="SEQUENCE_IDVOTINGPARTICIPANTS", sequenceName="SEQ_IDVOTINGPARTICIPANTS", allocationSize=1)
	private long id;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "IDVOTING", nullable = false)
    private Voting voting;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "IDPARTICIPANT", insertable = false, updatable = false)
//	@JsonBackReference
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "IDPARTICIPANT", nullable = false)
    private Participant participant;
	
	@Column(name = "VOTES")
	private long votes;
	
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

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}
	
}
