package com.ofacms.application.otp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class OtpService {

	@Autowired
	private JavaMailSender mailSender;

	@SuppressWarnings("unused")
	private static final int OTP_LENGTH = 4;

	public String generateOtp() {
		Random random = new Random();
		int otp = 1000 + random.nextInt(9000);
		return String.valueOf(otp);
	}

	public void sendOtp(String toEmail, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Your OTP Code");
		message.setText("Dear Customer,\n\n"+"You get an Otp from N Mart.\n\n"+"Don't Share the Otp to anyone.\n\n"+"Your OTP code is: " + otp);
		mailSender.send(message);
	}
}
