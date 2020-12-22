package com.italoschramm.apivotacao.service.voting;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.model.VotingParticipants;

public interface VotingParticipantsService {
	
	public VotingParticipants getVotingParticipantsById(Long idVotingParticipants);
	public boolean registerParticipant(Voting voting, Participant participant);

}
