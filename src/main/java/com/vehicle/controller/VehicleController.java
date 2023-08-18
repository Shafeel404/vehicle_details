package com.vehicle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.model.response.BaseResponse;
import com.vehicle.model.response.BaseResponse.ResponseBuilder;

@RestController
public class VehicleController {

	@GetMapping("/")
	public BaseResponse getDoorClosedReport() {

		return new ResponseBuilder().withData("QSD").build();
	}

}
