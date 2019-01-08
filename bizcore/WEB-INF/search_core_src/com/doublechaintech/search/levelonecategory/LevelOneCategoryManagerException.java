
package com.doublechaintech.search.levelonecategory;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class LevelOneCategoryManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public LevelOneCategoryManagerException(String string) {
		super(string);
	}
	public LevelOneCategoryManagerException(Message message) {
		super(message);
	}
	public LevelOneCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


