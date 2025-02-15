package com.company.PaymentService.service;

import com.company.PaymentService.entity.TransactionDetails;
import com.company.PaymentService.model.PaymentRequest;
import com.company.PaymentService.repository.TransactionDetailsRepository;
import java.time.Instant;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

  @Autowired
  private TransactionDetailsRepository transactionDetailsRepository;
  @Override
  public Long doPayment(PaymentRequest paymentRequest) {
    log.info("Recording Payment Details: {}", paymentRequest);

    TransactionDetails transactionDetails
        = TransactionDetails.builder()
        .paymentDate(Instant.now())
        .paymentMode(paymentRequest.getPaymentMode().name())
        .paymentStatus("SUCCESS")
        .orderId(paymentRequest.getOrderId())
        .referenceNumber(paymentRequest.getReferenceNumber())
        .amount(paymentRequest.getAmount())
        .build();

    transactionDetailsRepository.save(transactionDetails);

    log.info("Transaction Completed with Id: {}", transactionDetails);
    return transactionDetails.getId();
  }
}
