
package com.doublechaintech.search.userorder;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class UserOrderManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public UserOrderManagerException(String string) {
		super(string);
	}
	public UserOrderManagerException(Message message) {
		super(message);
	}
	public UserOrderManagerException(List<Message> messageList) {
		super(messageList);
	}

}


