package com.italoschramm.apivotacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.italoschramm.apivotacao.model.Participant;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long>{

	@Query(value = "SELECT * FROM PARTICIPANT WHERE name = :name", nativeQuery = true)
	public Participant findByName(@Param("name") String name);
	
	@Query(value = "SELECT * FROM PARTICIPANT WHERE ACTIVE = TRUE", nativeQuery = true)
	public List<Participant> listParticipantsActive();
	
	@Query(value = "SELECT * FROM PARTICIPANT WHERE ACTIVE = FALSE", nativeQuery = true)
	public List<Participant> listParticipantsInactive();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE PARTICIPANT SET ACTIVE = FALSE WHERE IDPARTICIPANT = :idParticipant", nativeQuery = true)
	public int inactiveParticipant(@Param("idParticipant") Long idParticipant);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE PARTICIPANT SET ACTIVE = TRUE WHERE IDPARTICIPANT = :idParticipant", nativeQuery = true)
	public int activeParticipant(@Param("idParticipant") Long idParticipant);
}
