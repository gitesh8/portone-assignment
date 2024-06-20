package com.portone.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomException {

	private String message;
	private String path;
	private LocalDateTime timestamp;
	
	public CustomException(String message, String path) {
		
		this.message = message;
		this.path = path;
		this.timestamp = LocalDateTime.now();
	}
	
	
	
}
