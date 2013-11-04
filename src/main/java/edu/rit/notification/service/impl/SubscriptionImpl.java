package edu.rit.notification.service.impl;

import edu.rit.notification.model.SubscriptionRequest;
import edu.rit.notification.model.SubscriptionResponse;



public class SubscriptionImpl  implements Subscription{

	@Override
	public SubscriptionResponse subscribe(SubscriptionRequest request) {
		
		//update subscription table
		
		System.out.println("Request accepted. UID: "+request.getStudentId()+ " Classnumber: " + request.getClassNumber() );
		
		SubscriptionResponse response = new SubscriptionResponse();
		response.setResponse("Your subscription will be processed shortly");
		
		return response;
	}

}
