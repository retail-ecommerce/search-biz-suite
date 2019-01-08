
package com.doublechaintech.search.productrecommendation;
import com.doublechaintech.search.AccessKey;


public class ProductRecommendationTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="product_recommendation_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_DISPLAY_NAME = "display_name";
	static final String COLUMN_BRAND = "brand";
	static final String COLUMN_ORIGIN = "origin";
	static final String COLUMN_PRODUCT = "product";
	static final String COLUMN_REMARK = "remark";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_DISPLAY_NAME, COLUMN_BRAND, COLUMN_ORIGIN, COLUMN_PRODUCT, COLUMN_REMARK, COLUMN_LAST_UPDATE_TIME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_DISPLAY_NAME, COLUMN_BRAND, COLUMN_ORIGIN, COLUMN_PRODUCT, COLUMN_REMARK, COLUMN_LAST_UPDATE_TIME
		};
	
	
}


