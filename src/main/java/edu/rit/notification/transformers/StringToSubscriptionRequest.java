package edu.rit.notification.transformers;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import edu.rit.notification.model.SubscriptionRequest;

public class StringToSubscriptionRequest extends AbstractTransformer{

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {

         System.out.println("Transformation: " +src);
		
		
		return new SubscriptionRequest("test", "test");
	}

}
