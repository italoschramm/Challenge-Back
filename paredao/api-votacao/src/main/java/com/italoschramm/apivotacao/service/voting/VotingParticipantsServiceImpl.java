package com.italoschramm.apivotacao.service.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.model.VotingParticipants;
import com.italoschramm.apivotacao.repository.VotingParticipantsRepository;

@Service
public class VotingParticipantsServiceImpl implements VotingParticipantsService{
	
	@Autowired
	public VotingParticipantsRepository votingParticipantsRepository;
	
	@Override
	public VotingParticipants getVotingParticipantsById(Long idVotingParticipants) {
		VotingParticipants votingParticipants = votingParticipantsRepository.findById(idVotingParticipants).orElse(null); 
		return votingParticipants;
	}
	
	@Override
	public boolean registerParticipant(Voting voting, Participant participant) {
		VotingParticipants votingParticipant = new VotingParticipants();
		votingParticipant.setVoting(voting);
		votingParticipant.setParticipant(participant);
		votingParticipant.setVotes(0);
		try {
			votingParticipantsRepository.save(votingParticipant);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
//	public boolean deleteVotingParticipantsByList(List<VotingParticipants> listParticipants) {
//		
//	}

}
