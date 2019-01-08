
package com.doublechaintech.search.site;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class SiteManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public SiteManagerException(String string) {
		super(string);
	}
	public SiteManagerException(Message message) {
		super(message);
	}
	public SiteManagerException(List<Message> messageList) {
		super(messageList);
	}

}


