package com.italoschramm.apivotacao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.italoschramm.apivotacao.model.VotingParticipants;

@Repository
public interface VotingParticipantsRepository extends CrudRepository<VotingParticipants, Long>{

	@Query(value = "SELECT * FROM VOTINGPARTICIPANTS WHERE IDVOTING = :idVoting AND IDPARTICIPANT = :idParticipant", nativeQuery = true)
	public VotingParticipants findByIdVotingByIdParticipant(@Param("idVoting") Long idVoting, @Param("idParticipant") Long idParticipant);
}
