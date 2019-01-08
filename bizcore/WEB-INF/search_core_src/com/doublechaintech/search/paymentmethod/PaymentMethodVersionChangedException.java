
package com.doublechaintech.search.paymentmethod;
import com.doublechaintech.search.EntityNotFoundException;

public class PaymentMethodVersionChangedException extends PaymentMethodManagerException {
	private static final long serialVersionUID = 1L;
	public PaymentMethodVersionChangedException(String string) {
		super(string);
	}


}


