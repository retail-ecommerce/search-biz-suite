
package com.doublechaintech.search.paymentmethod;
import com.doublechaintech.search.EntityNotFoundException;
public class PaymentMethodNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public PaymentMethodNotFoundException(String string) {
		super(string);
	}

}

