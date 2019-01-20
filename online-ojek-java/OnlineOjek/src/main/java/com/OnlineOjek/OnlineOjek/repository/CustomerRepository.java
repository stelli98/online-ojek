package com.OnlineOjek.OnlineOjek.repository;

import com.OnlineOjek.OnlineOjek.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findByBalance(Double balance);
}
