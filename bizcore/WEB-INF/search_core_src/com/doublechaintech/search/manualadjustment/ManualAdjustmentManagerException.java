
package com.doublechaintech.search.manualadjustment;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class ManualAdjustmentManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public ManualAdjustmentManagerException(String string) {
		super(string);
	}
	public ManualAdjustmentManagerException(Message message) {
		super(message);
	}
	public ManualAdjustmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


