
package com.doublechaintech.search.levelonecategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface LevelOneCategoryManager{

		

	public LevelOneCategory createLevelOneCategory(SearchUserContext userContext, String catalogId, String displayName) throws Exception;	
	public LevelOneCategory updateLevelOneCategory(SearchUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelOneCategory loadLevelOneCategory(SearchUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(SearchUserContext userContext, LevelOneCategory levelOneCategory) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(SearchUserContext userContext, LevelOneCategory levelOneCategory,Map<String,Object>option) throws Exception;
	
	public LevelOneCategory transferToAnotherCatalog(SearchUserContext userContext, String levelOneCategoryId, String anotherCatalogId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String levelOneCategoryId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, LevelOneCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelTwoCategoryManager getLevelTwoCategoryManager(SearchUserContext userContext, String levelOneCategoryId, String displayName ,String [] tokensExpr)  throws Exception;
	
	public  LevelOneCategory addLevelTwoCategory(SearchUserContext userContext, String levelOneCategoryId, String displayName , String [] tokensExpr)  throws Exception;
	public  LevelOneCategory removeLevelTwoCategory(SearchUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneCategory updateLevelTwoCategory(SearchUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


