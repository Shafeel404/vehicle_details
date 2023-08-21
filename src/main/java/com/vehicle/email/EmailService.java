package com.vehicle.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

	public final JavaMailSender javaMailSender;

	@Override
	@Async
	public void sendEmail(String to, String email) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
			helper.setText(email, true);
			helper.setTo(to);
			helper.setSubject("Confirm your email for vehicle details");
			helper.setFrom("redvirus423@gmail.com");
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			System.out.println("email couldnt send");
			throw new IllegalStateException("Failed to send email");
		}

	}

}
