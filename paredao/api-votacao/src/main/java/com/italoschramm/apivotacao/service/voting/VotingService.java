package com.italoschramm.apivotacao.service.voting;

import java.util.Date;
import java.util.List;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.model.Voting;

public interface VotingService {

	public Voting getVotingById(long idVoting);
	public boolean registerVoting(Date dateStart, Date dateEnd, List<Participant> participants, boolean active) throws Exception;
	public boolean existsVoting(Date dateStart, Date dateEnd);
	public List<Voting> listVotingActive();
	public List<Voting> listVotingInactive();
	public boolean deleteVoting(Long idVoting) throws Exception;
	public boolean inactiveVoting(Long idVoting);
	public boolean activeVoting(Long idVoting);
	public boolean updateVoting(Voting voting);
	public boolean isVotingValid(Long idVoting) throws Exception;
}
