
package com.doublechaintech.search.catalog;
import com.doublechaintech.search.EntityNotFoundException;

public class CatalogVersionChangedException extends CatalogManagerException {
	private static final long serialVersionUID = 1L;
	public CatalogVersionChangedException(String string) {
		super(string);
	}


}


