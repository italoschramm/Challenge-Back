package com.italoschramm.apivotacao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.italoschramm.apivotacao.model.VotingLog;

@Repository
public interface VotingLogRepository extends CrudRepository<VotingLog, Long>{

}
