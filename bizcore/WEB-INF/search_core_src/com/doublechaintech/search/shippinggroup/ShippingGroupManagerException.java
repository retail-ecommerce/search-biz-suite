
package com.doublechaintech.search.shippinggroup;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class ShippingGroupManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public ShippingGroupManagerException(String string) {
		super(string);
	}
	public ShippingGroupManagerException(Message message) {
		super(message);
	}
	public ShippingGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


