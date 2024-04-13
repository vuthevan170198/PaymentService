package com.company.PaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "ORDER_ID")
  private long orderId;

  @Column(name = "MODE" )
  private String paymentMode;

  @Column(name = "REFERENCE_NUMBER")
  private String referenceNumber;

  @Column(name = "PAYMENT_DATE")
  private Instant paymentDate;

  @Column(name = "STATUS")
  private String paymentStatus;

  @Column(name = "AMOUNT")
  private long amount;

}
