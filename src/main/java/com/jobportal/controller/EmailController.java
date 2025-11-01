package com.jobportal.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.EmailRequestDTO;
import com.jobportal.entity.Payment;
import com.jobportal.repository.PaymentRepository;
import com.jobportal.service.EmailService;
import com.jobportal.service.InvoiceService;

@RestController
@RequestMapping("/api/notifications")
public class EmailController {

    private final EmailService emailService;
     private final InvoiceService invoiceService;
    private final PaymentRepository paymentRepo;

    // Constructor Injection
    public EmailController(EmailService emailService, InvoiceService invoiceService, PaymentRepository paymentRepo) {
        this.emailService = emailService;
        this.invoiceService = invoiceService;
        this.paymentRepo = paymentRepo;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDTO dto) {
        emailService.sendEmail(dto);
        return ResponseEntity.ok("Email sent successfully to " + dto.getTo());
    }
    @PostMapping("/send-invoice/{paymentId}")
    public ResponseEntity<String> sendInvoiceEmail(
            @PathVariable Long paymentId,
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {

        Optional<Payment> paymentOpt = paymentRepo.findById(paymentId);
        if (paymentOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Payment not found for ID: " + paymentId);
        }

        Payment pay = paymentOpt.get();

        // Generate PDF invoice using InvoiceService
        byte[] pdfBytes = invoiceService.generateInvoice(pay);

        // Send email with the invoice PDF attached
        EmailRequestDTO emailRequest = new EmailRequestDTO(to, subject, body);
        emailService.sendEmail(emailRequest, pdfBytes);

        return ResponseEntity.ok("Invoice email sent successfully to " + to);
    }
}
