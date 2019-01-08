
package com.doublechaintech.search.profile;
import com.doublechaintech.search.EntityNotFoundException;

public class ProfileVersionChangedException extends ProfileManagerException {
	private static final long serialVersionUID = 1L;
	public ProfileVersionChangedException(String string) {
		super(string);
	}


}


