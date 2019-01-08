
package com.doublechaintech.search.productrecommendation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.brand.BrandDAO;
import com.doublechaintech.search.product.ProductDAO;


public interface ProductRecommendationDAO{

	
	public ProductRecommendation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ProductRecommendation> productRecommendationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ProductRecommendation present(ProductRecommendation productRecommendation,Map<String,Object> options) throws Exception;
	public ProductRecommendation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProductRecommendation save(ProductRecommendation productRecommendation,Map<String,Object> options);
	public SmartList<ProductRecommendation> saveProductRecommendationList(SmartList<ProductRecommendation> productRecommendationList,Map<String,Object> options);
	public SmartList<ProductRecommendation> removeProductRecommendationList(SmartList<ProductRecommendation> productRecommendationList,Map<String,Object> options);
	public SmartList<ProductRecommendation> findProductRecommendationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProductRecommendationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProductRecommendationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String productRecommendationId, int version) throws Exception;
	public ProductRecommendation disconnectFromAll(String productRecommendationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ProductRecommendation> queryList(String sql, Object ... parmeters);
 
 	public SmartList<ProductRecommendation> findProductRecommendationByBrand(String brandId, Map<String,Object> options);
 	public int countProductRecommendationByBrand(String brandId, Map<String,Object> options);
 	public Map<String, Integer> countProductRecommendationByBrandIds(String[] ids, Map<String,Object> options);
 	public SmartList<ProductRecommendation> findProductRecommendationByBrand(String brandId, int start, int count, Map<String,Object> options);
 	public void analyzeProductRecommendationByBrand(SmartList<ProductRecommendation> resultList, String brandId, Map<String,Object> options);

 
  
 	public SmartList<ProductRecommendation> findProductRecommendationByProduct(String productId, Map<String,Object> options);
 	public int countProductRecommendationByProduct(String productId, Map<String,Object> options);
 	public Map<String, Integer> countProductRecommendationByProductIds(String[] ids, Map<String,Object> options);
 	public SmartList<ProductRecommendation> findProductRecommendationByProduct(String productId, int start, int count, Map<String,Object> options);
 	public void analyzeProductRecommendationByProduct(SmartList<ProductRecommendation> resultList, String productId, Map<String,Object> options);

 
 }


