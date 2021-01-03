package com.italoschramm.apivotacao.service.voting;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoschramm.apivotacao.dto.ResultParticipantsVotesDTO;
import com.italoschramm.apivotacao.dto.ResultVotesDTO;
import com.italoschramm.apivotacao.dto.ResultVotesTimeDTO;
import com.italoschramm.apivotacao.dto.TimeVotesDTO;
import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.User;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.model.VotingLog;
import com.italoschramm.apivotacao.repository.VotingLogRepository;

@Service
public class VotingLogServiceImpl implements VotingLogService{

	@Autowired
	private VotingLogRepository votingLogRepository;
	
	@Autowired
	private VotingService votingService;
	
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
	
	@Override
	public boolean userLimitVotes(User user, Voting voting){
//		int quantityVotes = votingLogRepository.getQuantityVotesByTimeByUser(voting.getId(), user.getId(),
//				UtilDate.getDateAddMinutes(-1), UtilDate.getCurrentlyDate());
//		if(quantityVotes > 9)
//			return true;
		return false;
	}
	
	@Override
	public Long getTotalVotes(Long idVoting) throws Exception{
		if(!votingService.isVotingValid(idVoting))
			throw new Exception("Voting not found");
		long quantityVotes = votingLogRepository.getQuantityVotes(idVoting);
		return quantityVotes;
	}
	
	@Override
	public ResultVotesDTO getTotalVotesByParticipant(Long idVoting) throws Exception {
		if(!votingService.isVotingValid(idVoting))
			throw new Exception("Voting not found");
		Voting voting = votingService.getVotingById(idVoting);
		List<ResultParticipantsVotesDTO> participantsVotes = votingLogRepository.getTotalVotesByParticipant(voting);
		ResultVotesDTO result = new ResultVotesDTO();
		result.setIdVoting(idVoting);
		for(ResultParticipantsVotesDTO resultParticipants : participantsVotes) {
			result.getParticipants().add(resultParticipants);
			result.setTotalVotes(result.getTotalVotes() + resultParticipants.getVotes());
		}
		return result;
	}
	
	@Override
	public ResultVotesTimeDTO getTotalVotesByHour(Long idVoting) throws Exception {
		if(!votingService.isVotingValid(idVoting))
			throw new Exception("Voting not found");
		List<Object[]> timeVotes = votingLogRepository.getTotalVotesByHour(idVoting);
		ResultVotesTimeDTO result = new ResultVotesTimeDTO();
		result.setIdVoting(idVoting);
		for(Object[] timeVotesResult : timeVotes) {
			BigDecimal votes = (BigDecimal) timeVotesResult[0];
			result.getTimeVotes().add(new TimeVotesDTO(votes.longValue(), (Date) timeVotesResult[1]));
		}
		return result;
	}
}
