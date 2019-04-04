package com.mz.reportingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.reportingapi.domain.Acquirer;

@Repository
public interface AcquirerRepository extends JpaRepository<Acquirer, Integer> {

}
