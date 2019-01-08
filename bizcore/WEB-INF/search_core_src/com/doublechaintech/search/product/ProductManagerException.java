
package com.doublechaintech.search.product;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class ProductManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public ProductManagerException(String string) {
		super(string);
	}
	public ProductManagerException(Message message) {
		super(message);
	}
	public ProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


