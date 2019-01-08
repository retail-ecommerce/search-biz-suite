
package com.doublechaintech.search.loginhistory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface LoginHistoryManager{

		

	public LoginHistory createLoginHistory(SearchUserContext userContext, String fromIp, String description, String secUserId) throws Exception;	
	public LoginHistory updateLoginHistory(SearchUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(SearchUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public LoginHistory internalSaveLoginHistory(SearchUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(SearchUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;
	
	public LoginHistory transferToAnotherSecUser(SearchUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String loginHistoryId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, LoginHistory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


