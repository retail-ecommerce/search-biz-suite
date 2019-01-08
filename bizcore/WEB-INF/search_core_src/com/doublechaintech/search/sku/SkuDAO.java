
package com.doublechaintech.search.sku;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.product.ProductDAO;


public interface SkuDAO{

	
	public Sku load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Sku> skuList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Sku present(Sku sku,Map<String,Object> options) throws Exception;
	public Sku clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Sku save(Sku sku,Map<String,Object> options);
	public SmartList<Sku> saveSkuList(SmartList<Sku> skuList,Map<String,Object> options);
	public SmartList<Sku> removeSkuList(SmartList<Sku> skuList,Map<String,Object> options);
	public SmartList<Sku> findSkuWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSkuWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSkuWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String skuId, int version) throws Exception;
	public Sku disconnectFromAll(String skuId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Sku> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Sku> findSkuByProduct(String productId, Map<String,Object> options);
 	public int countSkuByProduct(String productId, Map<String,Object> options);
 	public Map<String, Integer> countSkuByProductIds(String[] ids, Map<String,Object> options);
 	public SmartList<Sku> findSkuByProduct(String productId, int start, int count, Map<String,Object> options);
 	public void analyzeSkuByProduct(SmartList<Sku> resultList, String productId, Map<String,Object> options);

 
 }


