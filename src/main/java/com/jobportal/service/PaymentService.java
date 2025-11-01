package com.jobportal.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.dto.PaymentRequestDTO;
import com.jobportal.dto.PaymentResponseDTO;
import com.jobportal.entity.Payment;
import com.jobportal.enums.PaymentStatus;
import com.jobportal.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    public PaymentResponseDTO processPayment(PaymentRequestDTO dto) {
        Payment pay = new Payment();
        pay.setUserId(dto.getUserId());
        pay.setPlanId(dto.getPlanId());
        pay.setAmount(dto.getAmount());
        pay.setPaymentStatus(PaymentStatus.SUCCESS);
        pay.setTransactionId(UUID.randomUUID().toString());
        pay.setTimeStamp(LocalDateTime.now());

        paymentRepo.save(pay);

        return PaymentResponseDTO.builder()
                .transactionId(pay.getTransactionId())
                .paymentStatus(pay.getPaymentStatus())
                .amount(pay.getAmount())
                .build();
    }
}
