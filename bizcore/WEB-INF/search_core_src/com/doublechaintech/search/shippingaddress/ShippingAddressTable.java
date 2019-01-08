
package com.doublechaintech.search.shippingaddress;
import com.doublechaintech.search.AccessKey;


public class ShippingAddressTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="shipping_address_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_LINE1 = "line1";
	static final String COLUMN_LINE2 = "line2";
	static final String COLUMN_CITY = "city";
	static final String COLUMN_STATE = "state";
	static final String COLUMN_ZIP_CODE = "zip_code";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_LINE1, COLUMN_LINE2, COLUMN_CITY, COLUMN_STATE, COLUMN_ZIP_CODE, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_LINE1, COLUMN_LINE2, COLUMN_CITY, COLUMN_STATE, COLUMN_ZIP_CODE
		};
	
	
}


