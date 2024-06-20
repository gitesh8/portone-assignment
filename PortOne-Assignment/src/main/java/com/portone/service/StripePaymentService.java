package com.portone.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentIntentCollection;
import com.stripe.model.Refund;

public interface StripePaymentService {

	public PaymentIntent createPaymentIntent(Long amount, String currency, String customerEmail) throws StripeException;
	public PaymentIntent capturePaymentIntent(String id) throws StripeException;
	public Refund createRefund(String id) throws StripeException;
	public PaymentIntentCollection getIntents() throws StripeException;
}
