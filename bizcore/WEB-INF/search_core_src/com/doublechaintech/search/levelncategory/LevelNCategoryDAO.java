
package com.doublechaintech.search.levelncategory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.product.ProductDAO;
import com.doublechaintech.search.leveltwocategory.LevelTwoCategoryDAO;


public interface LevelNCategoryDAO{

	
	public LevelNCategory load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelNCategory> levelNCategoryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LevelNCategory present(LevelNCategory levelNCategory,Map<String,Object> options) throws Exception;
	public LevelNCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelNCategory save(LevelNCategory levelNCategory,Map<String,Object> options);
	public SmartList<LevelNCategory> saveLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options);
	public SmartList<LevelNCategory> removeLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options);
	public SmartList<LevelNCategory> findLevelNCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelNCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelNCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelNCategoryId, int version) throws Exception;
	public LevelNCategory disconnectFromAll(String levelNCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductDAO getProductDAO();
		
	
 	public SmartList<LevelNCategory> requestCandidateLevelNCategoryForProduct(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelNCategory planToRemoveProductList(LevelNCategory levelNCategory, String productIds[], Map<String,Object> options)throws Exception;


	//disconnect LevelNCategory with brand in Product
	public LevelNCategory planToRemoveProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception;
	public int countProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelNCategory with catalog in Product
	public LevelNCategory planToRemoveProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception;
	public int countProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<LevelNCategory> queryList(String sql, Object ... parmeters);
 
 	public SmartList<LevelNCategory> findLevelNCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public int countLevelNCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countLevelNCategoryByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelNCategory> findLevelNCategoryByParentCategory(String levelTwoCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelNCategoryByParentCategory(SmartList<LevelNCategory> resultList, String levelTwoCategoryId, Map<String,Object> options);

 
 }


