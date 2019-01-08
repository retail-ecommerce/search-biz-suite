
package com.doublechaintech.search.orderpromotion;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class OrderPromotionManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public OrderPromotionManagerException(String string) {
		super(string);
	}
	public OrderPromotionManagerException(Message message) {
		super(message);
	}
	public OrderPromotionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


