package com.OnlineOjek.OnlineOjek.service;

import com.OnlineOjek.OnlineOjek.model.Customer;
import com.OnlineOjek.OnlineOjek.model.PaymentMethod;
import com.OnlineOjek.OnlineOjek.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService {
    @Autowired
    PaymentMethodRepository paymentMethodRepo;

    public List<PaymentMethod> getAllPaymentMethods(){
        return paymentMethodRepo.findAll();
    }

    public PaymentMethod addPaymentMethod(PaymentMethod paymentMethod){
        return paymentMethodRepo.save(paymentMethod);
    }

    public PaymentMethod findPaymentMethodById(Long id){
        return paymentMethodRepo.findById(id).get();
    }


}
