
package com.doublechaintech.search.productrecommendation;
//import com.doublechaintech.search.EntityNotFoundException;
import com.doublechaintech.search.SearchException;
import com.doublechaintech.search.Message;
import java.util.List;

public class ProductRecommendationManagerException extends SearchException {
	private static final long serialVersionUID = 1L;
	public ProductRecommendationManagerException(String string) {
		super(string);
	}
	public ProductRecommendationManagerException(Message message) {
		super(message);
	}
	public ProductRecommendationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


