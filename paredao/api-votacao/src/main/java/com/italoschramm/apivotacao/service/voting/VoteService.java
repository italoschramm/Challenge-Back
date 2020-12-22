package com.italoschramm.apivotacao.service.voting;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.model.Voting;

public interface VoteService {

	public boolean saveVote(Voting voting, Participant participant, User user) throws Exception;
}
