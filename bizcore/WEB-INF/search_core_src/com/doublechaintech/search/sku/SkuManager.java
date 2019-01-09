
package com.doublechaintech.search.sku;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface SkuManager{

		

	public Sku createSku(SearchUserContext userContext, String name, String size, String productId, boolean active, BigDecimal basePrice, String lastUpdateTime) throws Exception;	
	public Sku updateSku(SearchUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Sku loadSku(SearchUserContext userContext, String skuId, String [] tokensExpr) throws Exception;
	public Sku internalSaveSku(SearchUserContext userContext, Sku sku) throws Exception;
	public Sku internalSaveSku(SearchUserContext userContext, Sku sku,Map<String,Object>option) throws Exception;
	
	public Sku transferToAnotherProduct(SearchUserContext userContext, String skuId, String anotherProductId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String skuId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, Sku newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


