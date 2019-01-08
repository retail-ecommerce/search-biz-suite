
package com.doublechaintech.search.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(SearchUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(SearchUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(SearchUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(SearchUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(SearchUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(SearchUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SiteManager getSiteManager(SearchUserContext userContext, String platformId, String name, String introduction, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Platform addSite(SearchUserContext userContext, String platformId, String name, String introduction, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Platform removeSite(SearchUserContext userContext, String platformId, String siteId, int siteVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateSite(SearchUserContext userContext, String platformId, String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProfileManager getProfileManager(SearchUserContext userContext, String platformId, String name, int age, String gender, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProfile(SearchUserContext userContext, String platformId, String name, int age, String gender, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Platform removeProfile(SearchUserContext userContext, String platformId, String profileId, int profileVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProfile(SearchUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UserOrderManager getUserOrderManager(SearchUserContext userContext, String platformId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Platform addUserOrder(SearchUserContext userContext, String platformId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Platform removeUserOrder(SearchUserContext userContext, String platformId, String userOrderId, int userOrderVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateUserOrder(SearchUserContext userContext, String platformId, String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


