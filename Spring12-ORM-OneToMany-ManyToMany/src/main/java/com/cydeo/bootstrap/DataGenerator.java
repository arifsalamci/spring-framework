package com.cydeo.bootstrap;

import com.cydeo.entity.Merchant;
import com.cydeo.entity.Payment;
import com.cydeo.entity.PaymentDetail;
import com.cydeo.enums.PaymentStatus;
import com.cydeo.repository.MerchantRepository;
import com.cydeo.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    PaymentRepository paymentRepository;
    MerchantRepository merchantRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Payment> listOfPayments = new ArrayList<>();

        Payment payment1 = new Payment(new BigDecimal("150000"), LocalDate.of(2022,4,19), PaymentStatus.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"),LocalDate.of(2022,4,24));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(new BigDecimal("100000"), LocalDate.of(2022,4,25), PaymentStatus.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        Merchant merchant1 = new Merchant("AmazonSubMerchant","M123",new BigDecimal("0.25"),new BigDecimal("3.25"),5);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);

        merchantRepository.save(merchant1);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

//        Customer customer1 = new Customer("msmith","mike","smith","mike@cydeo.com","VA");
//        payment1.setCustomer(customer1);
//        payment2.setCustomer(customer1);

    }
}
