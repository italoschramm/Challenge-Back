package com.italoschramm.apivotacao.service.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.model.VotingParticipants;
import com.italoschramm.apivotacao.repository.VotingParticipantsRepository;

@Service
public class VoteServiceImpl implements VoteService{

	@Autowired
	private VotingLogService votingLogService;
	
	@Autowired
	private VotingParticipantsRepository votingParticipantsRepository;
	
	@Override
	public boolean saveVote(Voting voting, Participant participant, User user) throws Exception {
		VotingParticipants votingParticipants = votingParticipantsRepository.findByIdVotingByIdParticipant(voting.getId(), participant.getId());
		if(votingParticipants == null)
			throw new Exception("Participant not found in the vote!");	
		
		if(votingLogService.userLimitVotes(user, voting))
			throw new Exception("Maximum limit of votes per minute reached!");
		
		votingParticipants.setVotes(votingParticipants.getVotes() + 1);
		try {
			votingParticipantsRepository.save(votingParticipants);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		votingLogService.registerVoteLog(voting, participant, user);
		return true;
	}
}
