
package com.doublechaintech.search.paymentgroup;
import com.doublechaintech.search.EntityNotFoundException;

public class PaymentGroupVersionChangedException extends PaymentGroupManagerException {
	private static final long serialVersionUID = 1L;
	public PaymentGroupVersionChangedException(String string) {
		super(string);
	}


}


