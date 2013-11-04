package edu.rit.notification.poller;

import org.mule.api.MuleContext;
import org.mule.api.MuleEventContext;
import org.mule.api.annotations.expressions.Lookup;
import org.mule.api.lifecycle.Callable;

import edu.rit.notification.binding.PollingLoopback;

public class MyCallable implements Callable {

	@Lookup
	private MuleContext muleContext;
	
	private PollingLoopback loopback;
	
	public MuleContext getMuleContext() {
		return muleContext;
	}


	public void setMuleContext(MuleContext muleContext) {
		this.muleContext = muleContext;
	}


	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public PollingLoopback getLoopback() {
		return loopback;
	}


	public void setLoopback(PollingLoopback loopback) {
		this.loopback = loopback;
	}
	
	

}
