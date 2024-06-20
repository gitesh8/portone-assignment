package com.portone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.portone.model.PaymentIntentRequest;
import com.portone.service.StripePaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentIntentCollection;
import com.stripe.model.Refund;

@RestController
public class StripePaymentController {

	@Autowired // Injecting StripePayment Service
	private StripePaymentService stripePayments;
	
	@Autowired // Injecting Gson (JSON Library)
	private Gson gson;
	
	
	@PostMapping("/api/v1/create_intent")
	public ResponseEntity<Object> createIntent(@RequestBody PaymentIntentRequest paymentIntentRequest) throws StripeException{
		PaymentIntent response = stripePayments.createPaymentIntent(paymentIntentRequest.getAmount(), paymentIntentRequest.getCurrency(), paymentIntentRequest.getCustomerEmail());
		
		// returning response with converting to object
		return new ResponseEntity<>(gson.fromJson(response.getRawJsonObject(), Object.class),HttpStatus.OK);
	}
	
	@PostMapping("/api/v1/capture_intent/{id}")
	public ResponseEntity<Object> createIntent(@PathVariable("id") String id) throws StripeException{
		PaymentIntent response = stripePayments.capturePaymentIntent(id);
		
		// returning response with converting to object
		return new ResponseEntity<>(gson.fromJson(response.getRawJsonObject(), Object.class),HttpStatus.OK);
	}
	
	@PostMapping("/api/v1/create_refund/{id}")
	public ResponseEntity<Object> createRefund(@PathVariable("id") String id) throws StripeException{
		Refund response = stripePayments.createRefund(id);
		
		// returning response with converting to object
		return new ResponseEntity<>(gson.fromJson(response.getRawJsonObject(), Object.class),HttpStatus.OK);
	}
	
	@GetMapping("/api/v1/get_intents/")
	public ResponseEntity<Object> getIntents() throws StripeException{
		PaymentIntentCollection response = stripePayments.getIntents();
		
		// returning response with converting to object
		return new ResponseEntity<>(gson.fromJson(response.getRawJsonObject(), Object.class),HttpStatus.OK);
	}
}
