
package com.doublechaintech.search.paymentgroup;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class PaymentGroupManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public PaymentGroupManagerException(String string) {
		super(string);
	}
	public PaymentGroupManagerException(Message message) {
		super(message);
	}
	public PaymentGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


