package com.ofacms.application.otp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OtpController {

	@Autowired
	private OtpService otpService;

	@PostMapping("/send-otp")
	public String sendOtp(@RequestBody OtpRequest otpRequest) {
		String otp = otpService.generateOtp();
		otpService.sendOtp(otpRequest.getEmail(), otp);

		return otp;
	}
}
