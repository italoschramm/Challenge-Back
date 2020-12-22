package com.italoschramm.apivotacao.service.voting;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.model.VotingLog;
import com.italoschramm.apivotacao.repository.VotingLogRepository;

@Service
public class VotingLogServiceImpl implements VotingLogService{

	@Autowired
	private VotingLogRepository votingLogRepository;
	
	@Override
	public boolean registerVoteLog(Voting voting, Participant participant, User user) {
		VotingLog votingLog = new VotingLog();
		Date now = new Date();
		votingLog.setVoting(voting);
		votingLog.setParticipant(participant);
		votingLog.setUser(user);
		votingLog.setVote(1);
		votingLog.setDate(now);
		try {
			votingLogRepository.save(votingLog);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	} 
}
