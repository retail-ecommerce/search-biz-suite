
package com.doublechaintech.search.brand;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.product.ProductDAO;
import com.doublechaintech.search.productrecommendation.ProductRecommendationDAO;


public interface BrandDAO{

	
	public Brand load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Brand> brandList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Brand present(Brand brand,Map<String,Object> options) throws Exception;
	public Brand clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Brand save(Brand brand,Map<String,Object> options);
	public SmartList<Brand> saveBrandList(SmartList<Brand> brandList,Map<String,Object> options);
	public SmartList<Brand> removeBrandList(SmartList<Brand> brandList,Map<String,Object> options);
	public SmartList<Brand> findBrandWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countBrandWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countBrandWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String brandId, int version) throws Exception;
	public Brand disconnectFromAll(String brandId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductDAO getProductDAO();
		
	public ProductRecommendationDAO getProductRecommendationDAO();
		
	
 	public SmartList<Brand> requestCandidateBrandForProduct(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Brand> requestCandidateBrandForProductRecommendation(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Brand planToRemoveProductList(Brand brand, String productIds[], Map<String,Object> options)throws Exception;


	//disconnect Brand with parent_category in Product
	public Brand planToRemoveProductListWithParentCategory(Brand brand, String parentCategoryId, Map<String,Object> options)throws Exception;
	public int countProductListWithParentCategory(String brandId, String parentCategoryId, Map<String,Object> options)throws Exception;
	
	//disconnect Brand with catalog in Product
	public Brand planToRemoveProductListWithCatalog(Brand brand, String catalogId, Map<String,Object> options)throws Exception;
	public int countProductListWithCatalog(String brandId, String catalogId, Map<String,Object> options)throws Exception;
	
	public Brand planToRemoveProductRecommendationList(Brand brand, String productRecommendationIds[], Map<String,Object> options)throws Exception;


	//disconnect Brand with product in ProductRecommendation
	public Brand planToRemoveProductRecommendationListWithProduct(Brand brand, String productId, Map<String,Object> options)throws Exception;
	public int countProductRecommendationListWithProduct(String brandId, String productId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Brand> queryList(String sql, Object ... parmeters);
}


