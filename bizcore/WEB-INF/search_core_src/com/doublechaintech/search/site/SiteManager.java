
package com.doublechaintech.search.site;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface SiteManager{

		

	public Site createSite(SearchUserContext userContext, String name, String introduction, String platformId, String lastUpdateTime) throws Exception;	
	public Site updateSite(SearchUserContext userContext,String siteId, int siteVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Site loadSite(SearchUserContext userContext, String siteId, String [] tokensExpr) throws Exception;
	public Site internalSaveSite(SearchUserContext userContext, Site site) throws Exception;
	public Site internalSaveSite(SearchUserContext userContext, Site site,Map<String,Object>option) throws Exception;
	
	public Site transferToAnotherPlatform(SearchUserContext userContext, String siteId, String anotherPlatformId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String siteId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, Site newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  CatalogManager getCatalogManager(SearchUserContext userContext, String siteId, String displayName, String sellerId ,String [] tokensExpr)  throws Exception;
	
	public  Site addCatalog(SearchUserContext userContext, String siteId, String displayName, String sellerId , String [] tokensExpr)  throws Exception;
	public  Site removeCatalog(SearchUserContext userContext, String siteId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  Site updateCatalog(SearchUserContext userContext, String siteId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


