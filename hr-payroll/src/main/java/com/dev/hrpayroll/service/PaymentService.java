//package com.dev.hrpayroll.service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.dev.hrpayroll.modal.Payment;
//import com.dev.hrpayroll.modal.Worker;
//
//@Service
//public class PaymentService {
//
//	@Value("${hr-worker.host}")
//	private String host;
//	
//	@Autowired
//	private RestTemplate template;
//	
//	public Payment getPayment(long id, int days) {
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("id", String.valueOf(id));
//		
//		Worker worker = template.getForObject(host + "/workers/{id}", Worker.class, uriVariables);
//		return new Payment(worker.getName(), worker.getDailyIncome(), days);
//	}
//}
