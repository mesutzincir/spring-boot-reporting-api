package com.mz.reportingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.reportingapi.domain.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer>{

}
