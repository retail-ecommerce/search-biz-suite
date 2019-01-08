
package com.doublechaintech.search.shippingaddress;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class ShippingAddressManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public ShippingAddressManagerException(String string) {
		super(string);
	}
	public ShippingAddressManagerException(Message message) {
		super(message);
	}
	public ShippingAddressManagerException(List<Message> messageList) {
		super(messageList);
	}

}


