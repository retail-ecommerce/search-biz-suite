
package com.doublechaintech.search.userorder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface UserOrderManager{

		

	public UserOrder createUserOrder(SearchUserContext userContext, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId, String platformId, String lastUpdateTime) throws Exception;	
	public UserOrder updateUserOrder(SearchUserContext userContext,String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserOrder loadUserOrder(SearchUserContext userContext, String userOrderId, String [] tokensExpr) throws Exception;
	public UserOrder internalSaveUserOrder(SearchUserContext userContext, UserOrder userOrder) throws Exception;
	public UserOrder internalSaveUserOrder(SearchUserContext userContext, UserOrder userOrder,Map<String,Object>option) throws Exception;
	
	public UserOrder transferToAnotherUser(SearchUserContext userContext, String userOrderId, String anotherUserId)  throws Exception;
 	public UserOrder transferToAnotherPlatform(SearchUserContext userContext, String userOrderId, String anotherPlatformId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String userOrderId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, UserOrder newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LineItemManager getLineItemManager(SearchUserContext userContext, String userOrderId, String name, int quantity, BigDecimal price, BigDecimal discountPrice ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addLineItem(SearchUserContext userContext, String userOrderId, String name, int quantity, BigDecimal price, BigDecimal discountPrice , String [] tokensExpr)  throws Exception;
	public  UserOrder removeLineItem(SearchUserContext userContext, String userOrderId, String lineItemId, int lineItemVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updateLineItem(SearchUserContext userContext, String userOrderId, String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  OrderPromotionManager getOrderPromotionManager(SearchUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addOrderPromotion(SearchUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type , String [] tokensExpr)  throws Exception;
	public  UserOrder removeOrderPromotion(SearchUserContext userContext, String userOrderId, String orderPromotionId, int orderPromotionVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updateOrderPromotion(SearchUserContext userContext, String userOrderId, String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ManualAdjustmentManager getManualAdjustmentManager(SearchUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addManualAdjustment(SearchUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type , String [] tokensExpr)  throws Exception;
	public  UserOrder removeManualAdjustment(SearchUserContext userContext, String userOrderId, String manualAdjustmentId, int manualAdjustmentVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updateManualAdjustment(SearchUserContext userContext, String userOrderId, String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ShippingGroupManager getShippingGroupManager(SearchUserContext userContext, String userOrderId, String name, String line1, String line2, String city, String state, int zipCode, String country ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addShippingGroup(SearchUserContext userContext, String userOrderId, String name, String line1, String line2, String city, String state, int zipCode, String country , String [] tokensExpr)  throws Exception;
	public  UserOrder removeShippingGroup(SearchUserContext userContext, String userOrderId, String shippingGroupId, int shippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updateShippingGroup(SearchUserContext userContext, String userOrderId, String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PaymentGroupManager getPaymentGroupManager(SearchUserContext userContext, String userOrderId, String name, BigDecimal amount, String status ,String [] tokensExpr)  throws Exception;
	
	public  UserOrder addPaymentGroup(SearchUserContext userContext, String userOrderId, String name, BigDecimal amount, String status , String [] tokensExpr)  throws Exception;
	public  UserOrder removePaymentGroup(SearchUserContext userContext, String userOrderId, String paymentGroupId, int paymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  UserOrder updatePaymentGroup(SearchUserContext userContext, String userOrderId, String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


