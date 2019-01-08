
package com.doublechaintech.search.userorder;
import com.doublechaintech.search.EntityNotFoundException;

public class UserOrderVersionChangedException extends UserOrderManagerException {
	private static final long serialVersionUID = 1L;
	public UserOrderVersionChangedException(String string) {
		super(string);
	}


}


