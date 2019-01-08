
package com.doublechaintech.search.sku;
import com.doublechaintech.search.EntityNotFoundException;
public class SkuNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public SkuNotFoundException(String string) {
		super(string);
	}

}

