package com.vehicle.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.model.entity.User;
import com.vehicle.model.entity.UserToken;
import com.vehicle.repository.UserRespository;
import com.vehicle.repository.UserTokenRepository;
import com.vehicle.service.UserTokenService;

@Service
public class UserTokenServiceImpl implements UserTokenService {

	@Autowired
	UserTokenRepository userTokenRepository;

	@Autowired
	UserRespository userRespository;

	@Override
	public Boolean userTokenValidate(String token) {
		Optional<UserToken> userToken = userTokenRepository.findByToken(token);
		if (userToken.get().getToken() != null) {
			Optional<User> user = userRespository.findByEmail(userToken.get().getUsername());
			user.get().setEnabled(true);
			userRespository.save(user.get());
		}
		return true;
	}

}
