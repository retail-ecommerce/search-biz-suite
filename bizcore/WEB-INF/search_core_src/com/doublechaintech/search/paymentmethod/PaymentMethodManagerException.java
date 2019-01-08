
package com.doublechaintech.search.paymentmethod;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class PaymentMethodManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public PaymentMethodManagerException(String string) {
		super(string);
	}
	public PaymentMethodManagerException(Message message) {
		super(message);
	}
	public PaymentMethodManagerException(List<Message> messageList) {
		super(messageList);
	}

}


