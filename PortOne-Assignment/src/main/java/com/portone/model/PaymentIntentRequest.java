package com.portone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentIntentRequest {


	private String customerEmail;
	private long amount;
	private String currency;
	
}
