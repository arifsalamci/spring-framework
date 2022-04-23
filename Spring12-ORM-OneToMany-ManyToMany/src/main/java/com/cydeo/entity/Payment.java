package com.cydeo.entity;


import com.cydeo.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @Column(columnDefinition = "DATE")
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;

    @ManyToOne
    private Merchant merchant;

    public Payment(BigDecimal amount, LocalDate createDate, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.createDate = createDate;
        this.paymentStatus = paymentStatus;
    }
}
