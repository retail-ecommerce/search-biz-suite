
package com.doublechaintech.search.leveltwocategory;
import com.doublechaintech.search.AccessKey;


public class LevelTwoCategoryTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="level_two_category_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_PARENT_CATEGORY = "parent_category";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_PARENT_CATEGORY, COLUMN_NAME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_PARENT_CATEGORY, COLUMN_NAME
		};
	
	
}


