package edu.rit.notification.model;

import java.io.Serializable;

public class SubscriptionResponse extends Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4401238801091784059L;
	
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	

}
