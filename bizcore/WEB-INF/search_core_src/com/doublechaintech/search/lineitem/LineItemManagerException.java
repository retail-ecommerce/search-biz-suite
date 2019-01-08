
package com.doublechaintech.search.lineitem;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class LineItemManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public LineItemManagerException(String string) {
		super(string);
	}
	public LineItemManagerException(Message message) {
		super(message);
	}
	public LineItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}


