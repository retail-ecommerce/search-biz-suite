
package com.doublechaintech.search.brand;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class BrandManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public BrandManagerException(String string) {
		super(string);
	}
	public BrandManagerException(Message message) {
		super(message);
	}
	public BrandManagerException(List<Message> messageList) {
		super(messageList);
	}

}


