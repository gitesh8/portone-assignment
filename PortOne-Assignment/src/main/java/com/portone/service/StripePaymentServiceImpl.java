package com.portone.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentIntentCollection;
import com.stripe.model.Refund;
import com.stripe.param.PaymentIntentCaptureParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentIntentListParams;
import com.stripe.param.RefundCreateParams;


import jakarta.annotation.PostConstruct;

@Service
public class StripePaymentServiceImpl implements StripePaymentService {
	
	// retrieving stripe api key from application.properties
	@Value("${stripe.apiSecret}")
	private String stripeApiKey;
	
	// configuring the stripe api key
	@PostConstruct
	public void init() {
		Stripe.apiKey=stripeApiKey;
	}

	@Override
	public PaymentIntent createPaymentIntent(Long amount, String currency, String customerEmail) throws StripeException {
		// TODO Auto-generated method stub
		
		// creating payment intent with parameters amount and currency
		PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
				.setAmount(amount).setCurrency(currency)
				.setReceiptEmail(customerEmail)
				.setCaptureMethod(PaymentIntentCreateParams.CaptureMethod.MANUAL)
				.build();
		
		// creating payment intent object 
		PaymentIntent paymentIntent = PaymentIntent.create(params);
		
		
		// returning payment intent object recieved from stripe
		return paymentIntent;
		
	}

	@Override
	public PaymentIntent capturePaymentIntent(String id) throws StripeException {
		// TODO Auto-generated method stub
		
		// retrieving payment intent object with id
		PaymentIntent paymentIntentDetails= PaymentIntent.retrieve(id);
		
		// creating params 
		PaymentIntentCaptureParams params = PaymentIntentCaptureParams.builder().build();
		
		// returning the updated payment intent object
		return paymentIntentDetails.capture(params);
	}

	@Override
	public Refund createRefund(String id) throws StripeException {
		// TODO Auto-generated method stub

		// creating a refund params with the id parameter
		RefundCreateParams params = RefundCreateParams.builder().setPaymentIntent(id).build();
		
		// passing params to the stripe
		Refund refund = Refund.create(params);
		
		// returning refund object received from stripe
		return refund;
	}

	@Override
	public PaymentIntentCollection getIntents() throws StripeException {
		// TODO Auto-generated method stub
		
		// creating payment intent list params object with the limit 4 (Limit Range between 1 to 100)
		PaymentIntentListParams params = PaymentIntentListParams.builder().setLimit((long) 4).build();
		
		// getting payment intent collection object from stripe and passing params as argument
		PaymentIntentCollection paymentIntent = PaymentIntent.list(params);
		
		// returning the payment intent collection object received from stripe
		return paymentIntent;
		
	}

}
