
package com.doublechaintech.search.product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface ProductManager{

		

	public Product createProduct(SearchUserContext userContext, String name, String parentCategoryId, String brandId, String origin, String catalogId, String remark, String lastUpdateTime) throws Exception;	
	public Product updateProduct(SearchUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Product loadProduct(SearchUserContext userContext, String productId, String [] tokensExpr) throws Exception;
	public Product internalSaveProduct(SearchUserContext userContext, Product product) throws Exception;
	public Product internalSaveProduct(SearchUserContext userContext, Product product,Map<String,Object>option) throws Exception;
	
	public Product transferToAnotherParentCategory(SearchUserContext userContext, String productId, String anotherParentCategoryId)  throws Exception;
 	public Product transferToAnotherBrand(SearchUserContext userContext, String productId, String anotherBrandId)  throws Exception;
 	public Product transferToAnotherCatalog(SearchUserContext userContext, String productId, String anotherCatalogId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String productId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, Product newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductRecommendationManager getProductRecommendationManager(SearchUserContext userContext, String productId, String name, String brandId, String origin, String remark, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Product addProductRecommendation(SearchUserContext userContext, String productId, String name, String brandId, String origin, String remark, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Product removeProductRecommendation(SearchUserContext userContext, String productId, String productRecommendationId, int productRecommendationVersion,String [] tokensExpr)  throws Exception;
	public  Product updateProductRecommendation(SearchUserContext userContext, String productId, String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SkuManager getSkuManager(SearchUserContext userContext, String productId, String name, String size, boolean active, BigDecimal basePrice, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Product addSku(SearchUserContext userContext, String productId, String name, String size, boolean active, BigDecimal basePrice, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Product removeSku(SearchUserContext userContext, String productId, String skuId, int skuVersion,String [] tokensExpr)  throws Exception;
	public  Product updateSku(SearchUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


