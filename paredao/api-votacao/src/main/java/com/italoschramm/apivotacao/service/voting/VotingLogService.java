package com.italoschramm.apivotacao.service.voting;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.model.Voting;

public interface VotingLogService {
	
	public boolean registerVoteLog(Voting voting, Participant participant, User user);
}
