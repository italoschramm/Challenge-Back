package com.italoschramm.apivotacao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="VOTING")
public class Voting {

	@Id
	@Column(name = "IDVOTING")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE_VOTING")
	@SequenceGenerator(name="SEQUENCE_VOTING", sequenceName="SEQ_VOTING", allocationSize=1)
	private long id;
	
	@Column(name="DATECREATION")
	private Date dateCreation;
	
	@Column(name="DATESTART")
	private Date dateStart;
	
	@Column(name="DATEEND")
	private Date dateEnd;
	
	@Column(name="ACTIVE")
	private Boolean active;
	
	@JsonManagedReference 
//	@OneToMany(cascade = CascadeType.ALL,
//			fetch = FetchType.EAGER,
//            mappedBy = "voting")
	@OneToMany(cascade = CascadeType.ALL,
		 	   mappedBy = "voting")
    private List<VotingParticipants> votingParticipants;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

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

	public List<VotingParticipants> getVotingParticipants() {
		return votingParticipants;
	}

	public void setVotingParticipants(List<VotingParticipants> votingParticipants) {
		this.votingParticipants = votingParticipants;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
