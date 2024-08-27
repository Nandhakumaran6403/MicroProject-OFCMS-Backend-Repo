package com.ofacms.application.otp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

 class OtpServiceTest {

    @Mock
     JavaMailSender mailSender;

    @InjectMocks
    private OtpService otpService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testGenerateOtp() {
        String otp = otpService.generateOtp();
        
        assertNotNull(otp);
        assertTrue(otp.matches("\\d{4}"));
    }

    @Test
     void testSendOtp() {
        String toEmail = "nandha@gmail.com";
        String otp = "1234";
        
        otpService.sendOtp(toEmail, otp);
        
        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(toEmail);
        expectedMessage.setSubject("Your OTP Code");
        expectedMessage.setText("Dear Customer,\n\n"+"You get an Otp from N Mart.\n\n"+"Don't Share the Otp to anyone.\n\n"+"Your OTP code is: " + otp);
        
        verify(mailSender, times(1)).send(expectedMessage);
    }
}
