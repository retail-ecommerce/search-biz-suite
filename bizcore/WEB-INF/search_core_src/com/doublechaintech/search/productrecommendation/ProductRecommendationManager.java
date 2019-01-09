
package com.doublechaintech.search.productrecommendation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface ProductRecommendationManager{

		

	public ProductRecommendation createProductRecommendation(SearchUserContext userContext, String name, String brandId, String origin, String productId, String remark, String lastUpdateTime) throws Exception;	
	public ProductRecommendation updateProductRecommendation(SearchUserContext userContext,String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProductRecommendation loadProductRecommendation(SearchUserContext userContext, String productRecommendationId, String [] tokensExpr) throws Exception;
	public ProductRecommendation internalSaveProductRecommendation(SearchUserContext userContext, ProductRecommendation productRecommendation) throws Exception;
	public ProductRecommendation internalSaveProductRecommendation(SearchUserContext userContext, ProductRecommendation productRecommendation,Map<String,Object>option) throws Exception;
	
	public ProductRecommendation transferToAnotherBrand(SearchUserContext userContext, String productRecommendationId, String anotherBrandId)  throws Exception;
 	public ProductRecommendation transferToAnotherProduct(SearchUserContext userContext, String productRecommendationId, String anotherProductId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String productRecommendationId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, ProductRecommendation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


