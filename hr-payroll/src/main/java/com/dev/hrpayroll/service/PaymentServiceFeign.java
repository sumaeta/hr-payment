package com.dev.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.hrpayroll.cloud.WorkerFeignClient;
import com.dev.hrpayroll.modal.Payment;
import com.dev.hrpayroll.modal.Worker;

@Service
public class PaymentServiceFeign {

	@Autowired
	private WorkerFeignClient feignClient;

	public Payment getPayment(long id, int days) {
		Worker worker = feignClient.findById(id).getBody();
		System.out.println("usando o feign");
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
