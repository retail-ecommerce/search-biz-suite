
package com.doublechaintech.search.lineitem;
import com.doublechaintech.search.EntityNotFoundException;

public class LineItemVersionChangedException extends LineItemManagerException {
	private static final long serialVersionUID = 1L;
	public LineItemVersionChangedException(String string) {
		super(string);
	}


}


