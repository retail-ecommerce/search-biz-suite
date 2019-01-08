
package com.doublechaintech.search.lineitem;
import com.doublechaintech.search.EntityNotFoundException;
public class LineItemNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public LineItemNotFoundException(String string) {
		super(string);
	}

}

