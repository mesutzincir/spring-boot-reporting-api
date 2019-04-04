package com.mz.reportingapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.reportingapi.domain.UserInfo;
import com.mz.reportingapi.repository.UserInfoRepository;
import com.mz.reportingapi.security.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(MapApiEndPoint.baseUrl+"/merchant/user")
public class UserController {
@Autowired
UserInfoRepository userRep;

	@PostMapping("login")
	public Map<String, String> login(@RequestBody LoginParam pParam) {
		Optional<UserInfo> user= userRep.findById(pParam.getEmail());
		if(user.get()==null)
		{
			throw new RuntimeException("Kullanıcı bilgileri hatalıdır.");
		}
		String token = Jwts.builder().setSubject(pParam.getEmail())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET.getBytes()).compact();
		Map<String, String> params = new HashMap<>();
        params.put("token", token);
        params.put("status", "APPROVED");
        return params;
		//return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.ACCEPTED);
	}
}
