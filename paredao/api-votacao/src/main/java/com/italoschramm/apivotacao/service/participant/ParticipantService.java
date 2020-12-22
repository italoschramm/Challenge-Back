package com.italoschramm.apivotacao.service.participant;

import java.util.List;

import com.italoschramm.apivotacao.model.Participant;

public interface ParticipantService {

	public boolean registerParticipant(String name, int age, String state, boolean active) ;
	public boolean existsParticipant(String name);
	public List<Participant> listParticipantsActive();
	public List<Participant> listParticipantsInactive();
	public boolean deleteParticipant(Long idParticipant);
	public boolean inactiveParticipant(Long idParticipant);
	public boolean activeParticipant(Long idParticipant);
	public boolean updateParticipant(Participant Participant);
	public Participant getParticipantById(long id);
}
