package com.vehicle.service.impl;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vehicle.common.exception.UserAlreadyExistsException;
import com.vehicle.common.exception.UserNotEnabledException;
import com.vehicle.common.exception.UserNotExistException;
import com.vehicle.jwt.EmailValidator;
import com.vehicle.jwt.JwtService;
import com.vehicle.model.entity.User;
import com.vehicle.model.entity.UserToken;
import com.vehicle.model.enums.Roles;
import com.vehicle.model.request.AuthenticationRequest;
import com.vehicle.model.request.RegisterRequest;
import com.vehicle.model.response.AuthenticationResponse;
import com.vehicle.repository.UserRespository;
import com.vehicle.repository.UserTokenRepository;
import com.vehicle.service.AuthenticationService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	private final UserRespository repository;

	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

	private final AuthenticationManager authenticationManager;

	private final EmailValidator emailValidator;

	private final UserTokenRepository userTokenARepository;

	@Override
	@Transactional
	public AuthenticationResponse register(RegisterRequest request) {
		Boolean isExistEmail = repository.existsByEmail(request.getEmail());
		if (!isExistEmail) {
			Boolean isValidEmail = emailValidator.test(request.getEmail());
			if (isValidEmail) {
				var user = User.builder().name(request.getName()).email(request.getEmail())
						.password(passwordEncoder.encode(request.getPassword())).role(Roles.USER).enabled(false)
						.nonLocked(true).build();
				repository.save(user);
				var jwtToken = jwtService.generateToken(user);
				UserToken userToken = new UserToken();
				userToken.setToken(jwtToken);
				userToken.setUsername(request.getEmail());
				userTokenARepository.save(userToken);
				return AuthenticationResponse.builder()
						.response("User Created. Please confirm email and token is " + jwtToken).build();
			}
			throw new IllegalStateException("Email not valid");

		}
		throw new UserAlreadyExistsException("User Exist");

	}

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {

		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		} catch (AuthenticationException e) {

			System.out.println("some error occured");
		}

		Optional<User> user = repository.findByEmail(request.getEmail());
		if (user.isEmpty()) {
			throw new UserNotExistException("User Not Exist");
		}
		if (user.get().getEnabled() == false) {
			throw new UserNotEnabledException("User Not Enabled");
		}
		var jwtToken = jwtService.generateToken(user.get());
		return AuthenticationResponse.builder().token(jwtToken).build();

	}

}
