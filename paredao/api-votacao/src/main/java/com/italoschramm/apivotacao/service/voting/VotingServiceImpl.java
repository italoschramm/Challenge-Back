package com.italoschramm.apivotacao.service.voting;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.repository.VotingRepository;

@Service
public class VotingServiceImpl implements VotingService{

	@Autowired
	private VotingRepository votingRepository;
	
	@Autowired
	private VotingParticipantsService votingParticipantsService;
	
	@Override
	public Voting getVotingById(long idVoting) {
		Voting voting = votingRepository.findById(idVoting).orElse(null); 
		return voting;
	}
	
	@Override
	public boolean registerVoting(Date dateStart, Date dateEnd, List<Participant> participants, boolean active) throws Exception {
		Voting voting = new Voting();
		Date now = new Date();
		voting.setDateCreation(now);
		voting.setDateStart(dateStart);
		voting.setDateEnd(dateEnd);
		voting.setActive(active);
		Voting votingSaved = null;
		try {
			votingSaved = votingRepository.save(voting);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		for(Participant participant : participants) {
			if(!votingParticipantsService.registerParticipant(votingSaved, participant))
				throw new Exception("Error saving poll participant!");	
		}
		return true;
	}
	
	@Override
	public boolean existsVoting(Date dateStart, Date dateEnd) {
		Voting votingResult = votingRepository.findByDates(dateStart, dateEnd);
		if(votingResult != null)
			return true;
		else
			return false;
	}
	
	@Override
	public List<Voting> listVotingActive(){
		List<Voting> voting = votingRepository.listVotingActive(); 
		return voting;
	}
	
	@Override
	public List<Voting> listVotingInactive(){
		List<Voting> voting = votingRepository.listVotingInactive(); 
		return voting;
	}
	
	@Override
	public boolean deleteVoting(Long idVoting) throws Exception {
		if(getQuantityVotesByIdVoting(idVoting) < 1) {
			throw new Exception("It's not allowed to exclude voting in progress!");
		}
			
		Voting voting = getVotingById(idVoting);
		if(voting != null) {
			try {
				votingRepository.delete(voting);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}else
			return false;
	}
	
	private int getQuantityVotesByIdVoting(Long idVoting) {
		return getQuantityVotesByIdVoting(idVoting);
	}
	
	@Override
	public boolean inactiveVoting(Long idVoting) {
		Voting voting = getVotingById(idVoting);
		if(voting != null) {
			try {
				if(votingRepository.inactiveVoting(idVoting) > 0)
					return true;;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return false;
		}else
			return false;
	}
	
	@Override
	public boolean activeVoting(Long idVoting) {
		Voting voting = getVotingById(idVoting);
		if(voting != null) {
			try {
				if(votingRepository.activeVoting(idVoting) > 0)
					return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return false;
		}else
			return false;
	}
	
	@Override
	public boolean updateVoting(Voting voting) {
		try {
			Voting votingReturn = votingRepository.save(voting);
			if(votingReturn != null)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	@Override
	public boolean isVotingValid(Long idVoting) {
		Voting voting = getVotingById(idVoting);
		if(voting == null)
			return false;
		else
			return true;
	}
}
