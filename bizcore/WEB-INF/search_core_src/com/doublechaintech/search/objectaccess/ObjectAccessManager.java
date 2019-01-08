
package com.doublechaintech.search.objectaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface ObjectAccessManager{

		

	public ObjectAccess createObjectAccess(SearchUserContext userContext, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId) throws Exception;	
	public ObjectAccess updateObjectAccess(SearchUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ObjectAccess loadObjectAccess(SearchUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception;
	public ObjectAccess internalSaveObjectAccess(SearchUserContext userContext, ObjectAccess objectAccess) throws Exception;
	public ObjectAccess internalSaveObjectAccess(SearchUserContext userContext, ObjectAccess objectAccess,Map<String,Object>option) throws Exception;
	
	public ObjectAccess transferToAnotherApp(SearchUserContext userContext, String objectAccessId, String anotherAppId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String objectAccessId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, ObjectAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


