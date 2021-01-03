package com.italoschramm.apivotacao.service.voting;

import com.italoschramm.apivotacao.dto.ResultVotesDTO;
import com.italoschramm.apivotacao.dto.ResultVotesTimeDTO;
import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.model.Voting;

public interface VotingLogService {
	
	public boolean registerVoteLog(Voting voting, Participant participant, User user);
	public boolean userLimitVotes(User user, Voting voting);
	public Long getTotalVotes(Long idVoting) throws Exception;
	public ResultVotesDTO getTotalVotesByParticipant(Long idVoting) throws Exception;
	public ResultVotesTimeDTO getTotalVotesByHour(Long idVoting) throws Exception;
}
