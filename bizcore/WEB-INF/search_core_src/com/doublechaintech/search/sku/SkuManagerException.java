
package com.doublechaintech.search.sku;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class SkuManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public SkuManagerException(String string) {
		super(string);
	}
	public SkuManagerException(Message message) {
		super(message);
	}
	public SkuManagerException(List<Message> messageList) {
		super(messageList);
	}

}


