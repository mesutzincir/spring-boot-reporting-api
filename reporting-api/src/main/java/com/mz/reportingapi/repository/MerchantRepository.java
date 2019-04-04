package com.mz.reportingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.reportingapi.domain.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

}
