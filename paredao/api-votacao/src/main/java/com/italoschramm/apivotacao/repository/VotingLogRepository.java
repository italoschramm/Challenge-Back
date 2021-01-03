package com.italoschramm.apivotacao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.italoschramm.apivotacao.dto.ResultParticipantsVotesDTO;
import com.italoschramm.apivotacao.model.Voting;
import com.italoschramm.apivotacao.model.VotingLog;

@Repository
public interface VotingLogRepository extends CrudRepository<VotingLog, Long>{
	
	@Query(value = "SELECT COUNT(VOTE) AS QUANTITY FROM VOTINGLOG WHERE IDVOTING = :idVoting AND IDUSER = :idUser " + 
			" and DATE >= :dateInitial and DATE <= :dateEnd", nativeQuery = true)
	public int getQuantityVotesByTimeByUser(@Param("idVoting") Long idVoting, @Param("idUser") Long idUser, 
			@Param("dateInitial") Date dateInitial, @Param("dateEnd") Date dateEnd);

	@Query(value = "SELECT COUNT(VOTE) AS VOTES FROM VOTINGLOG WHERE IDVOTING = :idVoting", nativeQuery = true)
	public int getQuantityVotes(@Param("idVoting") Long idVoting);
	
	@Query(value = "SELECT new com.italoschramm.apivotacao.dto.ResultParticipantsVotesDTO(SUM(v.vote) AS votes, p.id) FROM VotingLog v " +
			" INNER JOIN v.participant p WHERE v.voting = :idVoting GROUP BY v.participant", nativeQuery = false)
	public List<ResultParticipantsVotesDTO> getTotalVotesByParticipant(@Param("idVoting") Voting idVoting);
	
	@Query(value = "SELECT SUM(v.vote) as votes, date_trunc('hour', v.date) as time FROM VotingLog v " + 
			" WHERE v.idVoting = :idVoting " + 
			" GROUP BY time", nativeQuery = true)
	public List<Object[]> getTotalVotesByHour(@Param("idVoting") Long idVoting);
	
	
	
}
