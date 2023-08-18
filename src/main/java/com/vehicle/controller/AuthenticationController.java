package com.vehicle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.model.request.AuthenticationRequest;
import com.vehicle.model.request.RegisterRequest;
import com.vehicle.model.response.AuthenticationResponse;
import com.vehicle.model.response.BaseResponse;
import com.vehicle.model.response.BaseResponse.ResponseBuilder;
import com.vehicle.service.AuthenticationService;
import com.vehicle.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authService;

	private final UserTokenService tokenService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authService.register(request));

	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(authService.authenticate(request));

	}

	@GetMapping("/confirm-user")
	public BaseResponse confirmUser(@RequestParam(value = "token", required = false) String token) {
		return new ResponseBuilder().withData(tokenService.userTokenValidate(token)).build();

	}

}
