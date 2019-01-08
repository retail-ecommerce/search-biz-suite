
package com.doublechaintech.search.product;
import com.doublechaintech.search.EntityNotFoundException;
public class ProductNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(String string) {
		super(string);
	}

}

