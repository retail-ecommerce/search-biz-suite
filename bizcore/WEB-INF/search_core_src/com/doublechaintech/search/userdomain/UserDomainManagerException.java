
package com.doublechaintech.search.userdomain;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class UserDomainManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public UserDomainManagerException(String string) {
		super(string);
	}
	public UserDomainManagerException(Message message) {
		super(message);
	}
	public UserDomainManagerException(List<Message> messageList) {
		super(messageList);
	}

}


