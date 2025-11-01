package com.jobportal.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jobportal.dto.EmailRequestDTO;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    // Constructor Injection
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailRequestDTO dto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(dto.getTo());
            message.setSubject(dto.getSubject());
            message.setText(dto.getBody());

            mailSender.send(message);
            System.out.println("✅ Email sent successfully to " + dto.getTo());
        } catch (Exception e) {
            System.err.println("❌ Failed to send email: " + e.getMessage());
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendEmail(EmailRequestDTO emailRequest, byte[] pdfBytes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendEmail'");
    }
}
