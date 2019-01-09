
package com.doublechaintech.search.levelncategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface LevelNCategoryManager{

		

	public LevelNCategory createLevelNCategory(SearchUserContext userContext, String parentCategoryId, String name) throws Exception;	
	public LevelNCategory updateLevelNCategory(SearchUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelNCategory loadLevelNCategory(SearchUserContext userContext, String levelNCategoryId, String [] tokensExpr) throws Exception;
	public LevelNCategory internalSaveLevelNCategory(SearchUserContext userContext, LevelNCategory levelNCategory) throws Exception;
	public LevelNCategory internalSaveLevelNCategory(SearchUserContext userContext, LevelNCategory levelNCategory,Map<String,Object>option) throws Exception;
	
	public LevelNCategory transferToAnotherParentCategory(SearchUserContext userContext, String levelNCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String levelNCategoryId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, LevelNCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductManager getProductManager(SearchUserContext userContext, String levelNCategoryId, String name, String brandId, String origin, String catalogId, String remark, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  LevelNCategory addProduct(SearchUserContext userContext, String levelNCategoryId, String name, String brandId, String origin, String catalogId, String remark, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  LevelNCategory removeProduct(SearchUserContext userContext, String levelNCategoryId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  LevelNCategory updateProduct(SearchUserContext userContext, String levelNCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


