package com.mz.reportingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mz.reportingapi.domain.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

}
