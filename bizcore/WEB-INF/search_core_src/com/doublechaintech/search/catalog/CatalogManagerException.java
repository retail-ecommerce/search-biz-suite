
package com.doublechaintech.search.catalog;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class CatalogManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public CatalogManagerException(String string) {
		super(string);
	}
	public CatalogManagerException(Message message) {
		super(message);
	}
	public CatalogManagerException(List<Message> messageList) {
		super(messageList);
	}

}


