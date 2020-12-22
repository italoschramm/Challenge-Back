package com.italoschramm.apivotacao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.italoschramm.apivotacao.model.Voting;

@Repository
public interface VotingRepository extends CrudRepository<Voting, Long>{

	@Query(value = "SELECT * FROM VOTING WHERE (DATESTART = :dateStart and DATEEND = :dateEnd)", nativeQuery = true)
	public Voting findByDates(@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);
	
	@Query(value = "SELECT * FROM VOTING WHERE ACTIVE = TRUE", nativeQuery = true)
	public List<Voting> listVotingActive();
	
	@Query(value = "SELECT * FROM VOTING WHERE ACTIVE = FALSE", nativeQuery = true)
	public List<Voting> listVotingInactive();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE VOTING SET ACTIVE = FALSE WHERE IDVOTING = :idVoting", nativeQuery = true)
	public int inactiveVoting(@Param("idVoting") Long idVoting);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE VOTING SET ACTIVE = TRUE WHERE IDVOTING = :idVoting", nativeQuery = true)
	public int activeVoting(@Param("idVoting") Long idVoting);
	
	@Query(value = "SELECT VP.VOTES FROM VOTING V "
			+ " INNER JOIN VOTINGPARTICIPANTS VP ON "
			+ " V.IDVOTING = VP.IDVOTING " 
			+ " WHERE V.ACTIVE = TRUE "
			+ " AND V.IDVOTING = :idVoting "
			+ " GROUP BY VP.VOTES", nativeQuery = true)
	public int getQuantityVotesByIdVoting(@Param("idVoting") Long idVoting);
}
