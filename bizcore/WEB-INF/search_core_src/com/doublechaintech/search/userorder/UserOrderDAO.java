
package com.doublechaintech.search.userorder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.shippinggroup.ShippingGroupDAO;
import com.doublechaintech.search.manualadjustment.ManualAdjustmentDAO;
import com.doublechaintech.search.platform.PlatformDAO;
import com.doublechaintech.search.profile.ProfileDAO;
import com.doublechaintech.search.orderpromotion.OrderPromotionDAO;
import com.doublechaintech.search.lineitem.LineItemDAO;
import com.doublechaintech.search.paymentgroup.PaymentGroupDAO;


public interface UserOrderDAO{

	
	public UserOrder load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserOrder> userOrderList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserOrder present(UserOrder userOrder,Map<String,Object> options) throws Exception;
	public UserOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserOrder save(UserOrder userOrder,Map<String,Object> options);
	public SmartList<UserOrder> saveUserOrderList(SmartList<UserOrder> userOrderList,Map<String,Object> options);
	public SmartList<UserOrder> removeUserOrderList(SmartList<UserOrder> userOrderList,Map<String,Object> options);
	public SmartList<UserOrder> findUserOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userOrderId, int version) throws Exception;
	public UserOrder disconnectFromAll(String userOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LineItemDAO getLineItemDAO();
		
	public OrderPromotionDAO getOrderPromotionDAO();
		
	public ManualAdjustmentDAO getManualAdjustmentDAO();
		
	public ShippingGroupDAO getShippingGroupDAO();
		
	public PaymentGroupDAO getPaymentGroupDAO();
		
	
 	public SmartList<UserOrder> requestCandidateUserOrderForLineItem(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserOrder> requestCandidateUserOrderForOrderPromotion(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserOrder> requestCandidateUserOrderForManualAdjustment(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserOrder> requestCandidateUserOrderForShippingGroup(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserOrder> requestCandidateUserOrderForPaymentGroup(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public UserOrder planToRemoveLineItemList(UserOrder userOrder, String lineItemIds[], Map<String,Object> options)throws Exception;


	public UserOrder planToRemoveOrderPromotionList(UserOrder userOrder, String orderPromotionIds[], Map<String,Object> options)throws Exception;


	public UserOrder planToRemoveManualAdjustmentList(UserOrder userOrder, String manualAdjustmentIds[], Map<String,Object> options)throws Exception;


	public UserOrder planToRemoveShippingGroupList(UserOrder userOrder, String shippingGroupIds[], Map<String,Object> options)throws Exception;


	public UserOrder planToRemovePaymentGroupList(UserOrder userOrder, String paymentGroupIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<UserOrder> queryList(String sql, Object ... parmeters);
 
 	public SmartList<UserOrder> findUserOrderByUser(String profileId, Map<String,Object> options);
 	public int countUserOrderByUser(String profileId, Map<String,Object> options);
 	public Map<String, Integer> countUserOrderByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserOrder> findUserOrderByUser(String profileId, int start, int count, Map<String,Object> options);
 	public void analyzeUserOrderByUser(SmartList<UserOrder> resultList, String profileId, Map<String,Object> options);

 
  
 	public SmartList<UserOrder> findUserOrderByPlatform(String platformId, Map<String,Object> options);
 	public int countUserOrderByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countUserOrderByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserOrder> findUserOrderByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeUserOrderByPlatform(SmartList<UserOrder> resultList, String platformId, Map<String,Object> options);

 
 }


