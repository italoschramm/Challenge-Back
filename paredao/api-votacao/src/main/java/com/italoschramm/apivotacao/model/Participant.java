package com.italoschramm.apivotacao.model;

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
@Table(name="PARTICIPANT")
public class Participant {
	
	@Id
	@Column(name = "IDPARTICIPANT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE_PARTICIPANT")
	@SequenceGenerator(name="SEQUENCE_PARTICIPANT", sequenceName="SEQ_PARTICIPANT", allocationSize=1)
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="STATE", length = 2)
	private String state;
	
	@Column(name="ACTIVE")
	private Boolean active;
	
//    @OneToMany
//    @JoinColumn(name = "IDPARTICIPANT")
//	@JsonManagedReference
	
	@JsonManagedReference 
	@OneToMany(cascade = CascadeType.ALL,
            mappedBy = "participant")
    private List<VotingParticipants> votingParticipants;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<VotingParticipants> getVotingParticipants() {
		return votingParticipants;
	}

	public void setVotingParticipants(List<VotingParticipants> votingParticipants) {
		this.votingParticipants = votingParticipants;
	}
}
