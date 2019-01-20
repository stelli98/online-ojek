package com.OnlineOjek.OnlineOjek.controller;

import com.OnlineOjek.OnlineOjek.model.PaymentMethod;
import com.OnlineOjek.OnlineOjek.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentMethodController {
    @Autowired
    PaymentMethodService paymentMethodService;

    @CrossOrigin @GetMapping("api/payment-method")
    public List<PaymentMethod> getAllPaymentMethod(){
        return paymentMethodService.getAllPaymentMethods();
    }

    @CrossOrigin @PostMapping("api/payment-method")
    public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod paymentMethod){
        return paymentMethodService.addPaymentMethod(paymentMethod);
    }
}
