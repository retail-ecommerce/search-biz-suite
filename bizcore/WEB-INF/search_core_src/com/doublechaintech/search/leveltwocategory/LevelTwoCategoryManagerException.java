
package com.doublechaintech.search.leveltwocategory;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class LevelTwoCategoryManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public LevelTwoCategoryManagerException(String string) {
		super(string);
	}
	public LevelTwoCategoryManagerException(Message message) {
		super(message);
	}
	public LevelTwoCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


