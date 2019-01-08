
package com.doublechaintech.search.profile;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface ProfileManager{

		

	public Profile createProfile(SearchUserContext userContext, String name, int age, String gender, String lastUpdateTime, String platformId) throws Exception;	
	public Profile updateProfile(SearchUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Profile loadProfile(SearchUserContext userContext, String profileId, String [] tokensExpr) throws Exception;
	public Profile internalSaveProfile(SearchUserContext userContext, Profile profile) throws Exception;
	public Profile internalSaveProfile(SearchUserContext userContext, Profile profile,Map<String,Object>option) throws Exception;
	
	public Profile transferToAnotherPlatform(SearchUserContext userContext, String profileId, String anotherPlatformId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String profileId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, Profile newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserOrderManager getUserOrderManager(SearchUserContext userContext, String profileId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String platformId, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Profile addUserOrder(SearchUserContext userContext, String profileId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String platformId, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Profile removeUserOrder(SearchUserContext userContext, String profileId, String userOrderId, int userOrderVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateUserOrder(SearchUserContext userContext, String profileId, String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


