
package com.doublechaintech.search.leveltwocategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface LevelTwoCategoryManager{

		

	public LevelTwoCategory createLevelTwoCategory(SearchUserContext userContext, String parentCategoryId, String name) throws Exception;	
	public LevelTwoCategory updateLevelTwoCategory(SearchUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelTwoCategory loadLevelTwoCategory(SearchUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(SearchUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception;
	public LevelTwoCategory internalSaveLevelTwoCategory(SearchUserContext userContext, LevelTwoCategory levelTwoCategory,Map<String,Object>option) throws Exception;
	
	public LevelTwoCategory transferToAnotherParentCategory(SearchUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, LevelTwoCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LevelNCategoryManager getLevelNCategoryManager(SearchUserContext userContext, String levelTwoCategoryId, String name ,String [] tokensExpr)  throws Exception;
	
	public  LevelTwoCategory addLevelNCategory(SearchUserContext userContext, String levelTwoCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory removeLevelNCategory(SearchUserContext userContext, String levelTwoCategoryId, String levelNCategoryId, int levelNCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory updateLevelNCategory(SearchUserContext userContext, String levelTwoCategoryId, String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


