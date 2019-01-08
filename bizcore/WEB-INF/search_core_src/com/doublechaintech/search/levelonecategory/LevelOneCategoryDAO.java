
package com.doublechaintech.search.levelonecategory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.catalog.CatalogDAO;
import com.doublechaintech.search.leveltwocategory.LevelTwoCategoryDAO;


public interface LevelOneCategoryDAO{

	
	public LevelOneCategory load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelOneCategory> levelOneCategoryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LevelOneCategory present(LevelOneCategory levelOneCategory,Map<String,Object> options) throws Exception;
	public LevelOneCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelOneCategory save(LevelOneCategory levelOneCategory,Map<String,Object> options);
	public SmartList<LevelOneCategory> saveLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options);
	public SmartList<LevelOneCategory> removeLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options);
	public SmartList<LevelOneCategory> findLevelOneCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelOneCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelOneCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelOneCategoryId, int version) throws Exception;
	public LevelOneCategory disconnectFromAll(String levelOneCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LevelTwoCategoryDAO getLevelTwoCategoryDAO();
		
	
 	public SmartList<LevelOneCategory> requestCandidateLevelOneCategoryForLevelTwoCategory(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelOneCategory planToRemoveLevelTwoCategoryList(LevelOneCategory levelOneCategory, String levelTwoCategoryIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<LevelOneCategory> queryList(String sql, Object ... parmeters);
 
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId, Map<String,Object> options);
 	public int countLevelOneCategoryByCatalog(String catalogId, Map<String,Object> options);
 	public Map<String, Integer> countLevelOneCategoryByCatalogIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelOneCategoryByCatalog(SmartList<LevelOneCategory> resultList, String catalogId, Map<String,Object> options);

 
 }


