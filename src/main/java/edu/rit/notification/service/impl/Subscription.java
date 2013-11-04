package edu.rit.notification.service.impl;

import javax.jws.WebService;

import edu.rit.notification.model.SubscriptionRequest;
import edu.rit.notification.model.SubscriptionResponse;

@WebService
public interface Subscription {
	public SubscriptionResponse subscribe(SubscriptionRequest request);
}
