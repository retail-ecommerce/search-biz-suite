
package com.doublechaintech.search.levelncategory;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class LevelNCategoryManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public LevelNCategoryManagerException(String string) {
		super(string);
	}
	public LevelNCategoryManagerException(Message message) {
		super(message);
	}
	public LevelNCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


