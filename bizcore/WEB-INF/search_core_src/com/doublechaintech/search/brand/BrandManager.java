
package com.doublechaintech.search.brand;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface BrandManager{

		

	public Brand createBrand(SearchUserContext userContext, String brandName, String logo, String remark) throws Exception;	
	public Brand updateBrand(SearchUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Brand loadBrand(SearchUserContext userContext, String brandId, String [] tokensExpr) throws Exception;
	public Brand internalSaveBrand(SearchUserContext userContext, Brand brand) throws Exception;
	public Brand internalSaveBrand(SearchUserContext userContext, Brand brand,Map<String,Object>option) throws Exception;
	


	public void delete(SearchUserContext userContext, String brandId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, Brand newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProductManager getProductManager(SearchUserContext userContext, String brandId, String displayName, String parentCategoryId, String origin, String catalogId, String remark, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Brand addProduct(SearchUserContext userContext, String brandId, String displayName, String parentCategoryId, String origin, String catalogId, String remark, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Brand removeProduct(SearchUserContext userContext, String brandId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateProduct(SearchUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProductRecommendationManager getProductRecommendationManager(SearchUserContext userContext, String brandId, String displayName, String origin, String productId, String remark, String lastUpdateTime ,String [] tokensExpr)  throws Exception;
	
	public  Brand addProductRecommendation(SearchUserContext userContext, String brandId, String displayName, String origin, String productId, String remark, String lastUpdateTime , String [] tokensExpr)  throws Exception;
	public  Brand removeProductRecommendation(SearchUserContext userContext, String brandId, String productRecommendationId, int productRecommendationVersion,String [] tokensExpr)  throws Exception;
	public  Brand updateProductRecommendation(SearchUserContext userContext, String brandId, String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


