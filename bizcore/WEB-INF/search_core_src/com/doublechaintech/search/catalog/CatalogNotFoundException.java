
package com.doublechaintech.search.catalog;
import com.doublechaintech.search.EntityNotFoundException;
public class CatalogNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public CatalogNotFoundException(String string) {
		super(string);
	}

}

