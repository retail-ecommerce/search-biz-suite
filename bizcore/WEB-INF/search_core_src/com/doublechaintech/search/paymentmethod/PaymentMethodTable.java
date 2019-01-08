
package com.doublechaintech.search.paymentmethod;
import com.doublechaintech.search.AccessKey;


public class PaymentMethodTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="payment_method_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_NUMBER = "number";
	static final String COLUMN_LINE1 = "line1";
	static final String COLUMN_LINE2 = "line2";
	static final String COLUMN_CITY = "city";
	static final String COLUMN_EXPIRE_ON = "expire_on";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_NUMBER, COLUMN_LINE1, COLUMN_LINE2, COLUMN_CITY, COLUMN_EXPIRE_ON, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_NUMBER, COLUMN_LINE1, COLUMN_LINE2, COLUMN_CITY, COLUMN_EXPIRE_ON
		};
	
	
}


