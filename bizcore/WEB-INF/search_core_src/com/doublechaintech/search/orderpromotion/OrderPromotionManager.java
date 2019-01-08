
package com.doublechaintech.search.orderpromotion;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface OrderPromotionManager{

		

	public OrderPromotion createOrderPromotion(SearchUserContext userContext, String name, int amount, int threadHold, String type, String userOrderId) throws Exception;	
	public OrderPromotion updateOrderPromotion(SearchUserContext userContext,String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OrderPromotion loadOrderPromotion(SearchUserContext userContext, String orderPromotionId, String [] tokensExpr) throws Exception;
	public OrderPromotion internalSaveOrderPromotion(SearchUserContext userContext, OrderPromotion orderPromotion) throws Exception;
	public OrderPromotion internalSaveOrderPromotion(SearchUserContext userContext, OrderPromotion orderPromotion,Map<String,Object>option) throws Exception;
	
	public OrderPromotion transferToAnotherUserOrder(SearchUserContext userContext, String orderPromotionId, String anotherUserOrderId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String orderPromotionId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, OrderPromotion newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


