
package com.doublechaintech.search.profile;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class ProfileManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public ProfileManagerException(String string) {
		super(string);
	}
	public ProfileManagerException(Message message) {
		super(message);
	}
	public ProfileManagerException(List<Message> messageList) {
		super(messageList);
	}

}


