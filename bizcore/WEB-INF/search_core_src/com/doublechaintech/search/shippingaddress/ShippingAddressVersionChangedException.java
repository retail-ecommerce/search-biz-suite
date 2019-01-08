
package com.doublechaintech.search.shippingaddress;
import com.doublechaintech.search.EntityNotFoundException;

public class ShippingAddressVersionChangedException extends ShippingAddressManagerException {
	private static final long serialVersionUID = 1L;
	public ShippingAddressVersionChangedException(String string) {
		super(string);
	}


}


