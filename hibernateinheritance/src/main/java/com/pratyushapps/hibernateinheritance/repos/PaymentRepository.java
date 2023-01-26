package com.pratyushapps.hibernateinheritance.repos;

import org.springframework.data.repository.CrudRepository;

import com.pratyushapps.hibernateinheritance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
