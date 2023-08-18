package com.vehicle.service;

import com.vehicle.model.request.AuthenticationRequest;
import com.vehicle.model.request.RegisterRequest;
import com.vehicle.model.response.AuthenticationResponse;

public interface AuthenticationService {

	public AuthenticationResponse register(RegisterRequest request);

	public AuthenticationResponse authenticate(AuthenticationRequest request);

}
