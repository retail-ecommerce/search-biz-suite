
package com.doublechaintech.search.catalog;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.search.product.ProductDAO;
import com.doublechaintech.search.site.SiteDAO;


public interface CatalogDAO{

	
	public Catalog load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Catalog> catalogList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Catalog present(Catalog catalog,Map<String,Object> options) throws Exception;
	public Catalog clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Catalog save(Catalog catalog,Map<String,Object> options);
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> findCatalogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCatalogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCatalogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String catalogId, int version) throws Exception;
	public Catalog disconnectFromAll(String catalogId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LevelOneCategoryDAO getLevelOneCategoryDAO();
		
	public ProductDAO getProductDAO();
		
	
 	public SmartList<Catalog> requestCandidateCatalogForLevelOneCategory(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Catalog> requestCandidateCatalogForProduct(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Catalog planToRemoveLevelOneCategoryList(Catalog catalog, String levelOneCategoryIds[], Map<String,Object> options)throws Exception;


	public Catalog planToRemoveProductList(Catalog catalog, String productIds[], Map<String,Object> options)throws Exception;


	//disconnect Catalog with parent_category in Product
	public Catalog planToRemoveProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Catalog with brand in Product
	public Catalog planToRemoveProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception;
	public int countProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Catalog> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Catalog> findCatalogBySite(String siteId, Map<String,Object> options);
 	public int countCatalogBySite(String siteId, Map<String,Object> options);
 	public Map<String, Integer> countCatalogBySiteIds(String[] ids, Map<String,Object> options);
 	public SmartList<Catalog> findCatalogBySite(String siteId, int start, int count, Map<String,Object> options);
 	public void analyzeCatalogBySite(SmartList<Catalog> resultList, String siteId, Map<String,Object> options);

 
 }


