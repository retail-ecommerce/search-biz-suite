
package com.doublechaintech.search.catalog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface CatalogManager{

		

	public Catalog createCatalog(SearchUserContext userContext, String displayName, String sellerId, String siteId) throws Exception;	
	public Catalog updateCatalog(SearchUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Catalog loadCatalog(SearchUserContext userContext, String catalogId, String [] tokensExpr) throws Exception;
	public Catalog internalSaveCatalog(SearchUserContext userContext, Catalog catalog) throws Exception;
	public Catalog internalSaveCatalog(SearchUserContext userContext, Catalog catalog,Map<String,Object>option) throws Exception;
	
	public Catalog transferToAnotherSite(SearchUserContext userContext, String catalogId, String anotherSiteId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String catalogId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, Catalog newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelOneCategoryManager getLevelOneCategoryManager(SearchUserContext userContext, String catalogId, String displayName ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addLevelOneCategory(SearchUserContext userContext, String catalogId, String displayName , String [] tokensExpr)  throws Exception;
	public  Catalog removeLevelOneCategory(SearchUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateLevelOneCategory(SearchUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProductManager getProductManager(SearchUserContext userContext, String catalogId, String displayName, String parentCategoryId, String brandId, String origin, String remark, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Catalog addProduct(SearchUserContext userContext, String catalogId, String displayName, String parentCategoryId, String brandId, String origin, String remark, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Catalog removeProduct(SearchUserContext userContext, String catalogId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateProduct(SearchUserContext userContext, String catalogId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


