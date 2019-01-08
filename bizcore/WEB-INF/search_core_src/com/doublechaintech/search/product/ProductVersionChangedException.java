
package com.doublechaintech.search.product;
import com.doublechaintech.search.EntityNotFoundException;

public class ProductVersionChangedException extends ProductManagerException {
	private static final long serialVersionUID = 1L;
	public ProductVersionChangedException(String string) {
		super(string);
	}


}


