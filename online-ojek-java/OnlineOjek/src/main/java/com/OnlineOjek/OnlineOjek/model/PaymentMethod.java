package com.OnlineOjek.OnlineOjek.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="payment_id")
    private Long id;
    private String name;
    private String type;
}
