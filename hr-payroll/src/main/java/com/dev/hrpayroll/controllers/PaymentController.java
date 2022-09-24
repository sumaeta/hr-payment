package com.dev.hrpayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.hrpayroll.modal.Payment;
import com.dev.hrpayroll.service.PaymentServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentServiceFeign service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{id}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable long id, @PathVariable Integer days){
		Payment obj = service.getPayment(id, days);
		return ResponseEntity.ok(obj);
	}
	//getPaymentAlternative
	
	public ResponseEntity<Payment> getPaymentAlternative(long id, Integer days){
		Payment obj = new Payment("Bran", 400.0, days);
		return ResponseEntity.ok(obj);
	}
}
