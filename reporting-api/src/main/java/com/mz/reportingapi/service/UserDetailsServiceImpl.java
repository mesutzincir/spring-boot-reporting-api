package com.mz.reportingapi.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.mz.reportingapi.domain.UserInfo;
import com.mz.reportingapi.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static java.util.Collections.emptyList;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<UserInfo> user =userInfoRepository.findById(username);
    	if(!user.isPresent())
    	{
    		throw new RuntimeException("Kullanıcı bilgileri hatalıdır.");
    	}
    	return new User(username, user.get().getPassword(), emptyList());
    }
}