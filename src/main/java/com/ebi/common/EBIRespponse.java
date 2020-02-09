package com.ebi.common;

import org.springframework.stereotype.Component;

@Component
public class EBIRespponse {

	private int responseCode;
	private String status;
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
