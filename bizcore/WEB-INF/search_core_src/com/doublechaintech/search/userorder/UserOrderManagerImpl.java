
package com.doublechaintech.search.userorder;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.BaseEntity;


import com.doublechaintech.search.Message;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;

import com.doublechaintech.search.SearchUserContext;
//import com.doublechaintech.search.BaseManagerImpl;
import com.doublechaintech.search.SearchCheckerManager;
import com.doublechaintech.search.CustomSearchCheckerManager;

import com.doublechaintech.search.orderpromotion.OrderPromotion;
import com.doublechaintech.search.profile.Profile;
import com.doublechaintech.search.platform.Platform;
import com.doublechaintech.search.paymentgroup.PaymentGroup;
import com.doublechaintech.search.manualadjustment.ManualAdjustment;
import com.doublechaintech.search.shippinggroup.ShippingGroup;
import com.doublechaintech.search.lineitem.LineItem;

import com.doublechaintech.search.profile.CandidateProfile;
import com.doublechaintech.search.platform.CandidatePlatform;

import com.doublechaintech.search.userorder.UserOrder;






public class UserOrderManagerImpl extends CustomSearchCheckerManager implements UserOrderManager {
	
	private static final String SERVICE_TYPE = "UserOrder";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws UserOrderManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new UserOrderManagerException(message);

	}
	
	

 	protected UserOrder saveUserOrder(SearchUserContext userContext, UserOrder userOrder, String [] tokensExpr) throws Exception{	
 		//return getUserOrderDAO().save(userOrder, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserOrder(userContext, userOrder, tokens);
 	}
 	
 	protected UserOrder saveUserOrderDetail(SearchUserContext userContext, UserOrder userOrder) throws Exception{	

 		
 		return saveUserOrder(userContext, userOrder, allTokens());
 	}
 	
 	public UserOrder loadUserOrder(SearchUserContext userContext, String userOrderId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( UserOrderManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserOrder userOrder = loadUserOrder( userContext, userOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userOrder, tokens);
 	}
 	
 	
 	 public UserOrder searchUserOrder(SearchUserContext userContext, String userOrderId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( UserOrderManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		UserOrder userOrder = loadUserOrder( userContext, userOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userOrder, tokens);
 	}
 	
 	

 	protected UserOrder present(SearchUserContext userContext, UserOrder userOrder, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userOrder,tokens);
		
		
		UserOrder  userOrderToPresent = userContext.getDAOGroup().getUserOrderDAO().present(userOrder, tokens);
		
		List<BaseEntity> entityListToNaming = userOrderToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getUserOrderDAO().alias(entityListToNaming);
		
		return  userOrderToPresent;
		
		
	}
 
 	
 	
 	public UserOrder loadUserOrderDetail(SearchUserContext userContext, String userOrderId) throws Exception{	
 		UserOrder userOrder = loadUserOrder( userContext, userOrderId, allTokens());
 		return present(userContext,userOrder, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String userOrderId) throws Exception{	
 		UserOrder userOrder = loadUserOrder( userContext, userOrderId, viewTokens());
 		return present(userContext,userOrder, allTokens());
		
 	}
 	protected UserOrder saveUserOrder(SearchUserContext userContext, UserOrder userOrder, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getUserOrderDAO().save(userOrder, tokens);
 	}
 	protected UserOrder loadUserOrder(SearchUserContext userContext, String userOrderId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( UserOrderManagerException.class);

 
 		return userContext.getDAOGroup().getUserOrderDAO().load(userOrderId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, UserOrder userOrder, Map<String, Object> tokens){
		super.addActions(userContext, userOrder, tokens);
		
		addAction(userContext, userOrder, tokens,"@create","createUserOrder","createUserOrder/","main","primary");
		addAction(userContext, userOrder, tokens,"@update","updateUserOrder","updateUserOrder/"+userOrder.getId()+"/","main","primary");
		addAction(userContext, userOrder, tokens,"@copy","cloneUserOrder","cloneUserOrder/"+userOrder.getId()+"/","main","primary");
		
		addAction(userContext, userOrder, tokens,"user_order.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+userOrder.getId()+"/","main","primary");
		addAction(userContext, userOrder, tokens,"user_order.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+userOrder.getId()+"/","main","primary");
		addAction(userContext, userOrder, tokens,"user_order.addLineItem","addLineItem","addLineItem/"+userOrder.getId()+"/","lineItemList","primary");
		addAction(userContext, userOrder, tokens,"user_order.removeLineItem","removeLineItem","removeLineItem/"+userOrder.getId()+"/","lineItemList","primary");
		addAction(userContext, userOrder, tokens,"user_order.updateLineItem","updateLineItem","updateLineItem/"+userOrder.getId()+"/","lineItemList","primary");
		addAction(userContext, userOrder, tokens,"user_order.copyLineItemFrom","copyLineItemFrom","copyLineItemFrom/"+userOrder.getId()+"/","lineItemList","primary");
		addAction(userContext, userOrder, tokens,"user_order.addOrderPromotion","addOrderPromotion","addOrderPromotion/"+userOrder.getId()+"/","orderPromotionList","primary");
		addAction(userContext, userOrder, tokens,"user_order.removeOrderPromotion","removeOrderPromotion","removeOrderPromotion/"+userOrder.getId()+"/","orderPromotionList","primary");
		addAction(userContext, userOrder, tokens,"user_order.updateOrderPromotion","updateOrderPromotion","updateOrderPromotion/"+userOrder.getId()+"/","orderPromotionList","primary");
		addAction(userContext, userOrder, tokens,"user_order.copyOrderPromotionFrom","copyOrderPromotionFrom","copyOrderPromotionFrom/"+userOrder.getId()+"/","orderPromotionList","primary");
		addAction(userContext, userOrder, tokens,"user_order.addManualAdjustment","addManualAdjustment","addManualAdjustment/"+userOrder.getId()+"/","manualAdjustmentList","primary");
		addAction(userContext, userOrder, tokens,"user_order.removeManualAdjustment","removeManualAdjustment","removeManualAdjustment/"+userOrder.getId()+"/","manualAdjustmentList","primary");
		addAction(userContext, userOrder, tokens,"user_order.updateManualAdjustment","updateManualAdjustment","updateManualAdjustment/"+userOrder.getId()+"/","manualAdjustmentList","primary");
		addAction(userContext, userOrder, tokens,"user_order.copyManualAdjustmentFrom","copyManualAdjustmentFrom","copyManualAdjustmentFrom/"+userOrder.getId()+"/","manualAdjustmentList","primary");
		addAction(userContext, userOrder, tokens,"user_order.addShippingGroup","addShippingGroup","addShippingGroup/"+userOrder.getId()+"/","shippingGroupList","primary");
		addAction(userContext, userOrder, tokens,"user_order.removeShippingGroup","removeShippingGroup","removeShippingGroup/"+userOrder.getId()+"/","shippingGroupList","primary");
		addAction(userContext, userOrder, tokens,"user_order.updateShippingGroup","updateShippingGroup","updateShippingGroup/"+userOrder.getId()+"/","shippingGroupList","primary");
		addAction(userContext, userOrder, tokens,"user_order.copyShippingGroupFrom","copyShippingGroupFrom","copyShippingGroupFrom/"+userOrder.getId()+"/","shippingGroupList","primary");
		addAction(userContext, userOrder, tokens,"user_order.addPaymentGroup","addPaymentGroup","addPaymentGroup/"+userOrder.getId()+"/","paymentGroupList","primary");
		addAction(userContext, userOrder, tokens,"user_order.removePaymentGroup","removePaymentGroup","removePaymentGroup/"+userOrder.getId()+"/","paymentGroupList","primary");
		addAction(userContext, userOrder, tokens,"user_order.updatePaymentGroup","updatePaymentGroup","updatePaymentGroup/"+userOrder.getId()+"/","paymentGroupList","primary");
		addAction(userContext, userOrder, tokens,"user_order.copyPaymentGroupFrom","copyPaymentGroupFrom","copyPaymentGroupFrom/"+userOrder.getId()+"/","paymentGroupList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, UserOrder userOrder, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public UserOrder createUserOrder(SearchUserContext userContext,String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String userId, String platformId, String lastUpdateTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfUserOrder(title);
		userContext.getChecker().checkTotalAdjustmentOfUserOrder(totalAdjustment);
		userContext.getChecker().checkTotalAmountOfUserOrder(totalAmount);
		userContext.getChecker().checkLastUpdateTimeOfUserOrder(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);


		UserOrder userOrder=createNewUserOrder();	

		userOrder.setTitle(title);
		userOrder.setTotalAdjustment(totalAdjustment);
		userOrder.setTotalAmount(totalAmount);
			
		Profile user = loadProfile(userContext, userId,emptyOptions());
		userOrder.setUser(user);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		userOrder.setPlatform(platform);
		
		
		userOrder.setLastUpdateTime(lastUpdateTime);

		userOrder = saveUserOrder(userContext, userOrder, emptyOptions());
		
		onNewInstanceCreated(userContext, userOrder);
		return userOrder;

		
	}
	protected UserOrder createNewUserOrder() 
	{
		
		return new UserOrder();		
	}
	
	protected void checkParamsForUpdatingUserOrder(SearchUserContext userContext,String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkVersionOfUserOrder( userOrderVersion);
		

		if(UserOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfUserOrder(parseString(newValueExpr));
		}
		if(UserOrder.TOTAL_ADJUSTMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAdjustmentOfUserOrder(parseBigDecimal(newValueExpr));
		}
		if(UserOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfUserOrder(parseBigDecimal(newValueExpr));
		}		

				

		
		if(UserOrder.LAST_UPDATE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkLastUpdateTimeOfUserOrder(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
		
	}
	
	
	
	public UserOrder clone(SearchUserContext userContext, String fromUserOrderId) throws Exception{
		
		return userContext.getDAOGroup().getUserOrderDAO().clone(fromUserOrderId, this.allTokens());
	}
	
	public UserOrder internalSaveUserOrder(SearchUserContext userContext, UserOrder userOrder) throws Exception 
	{
		return internalSaveUserOrder(userContext, userOrder, allTokens());

	}
	public UserOrder internalSaveUserOrder(SearchUserContext userContext, UserOrder userOrder, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingUserOrder(userContext, userOrderId, userOrderVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(userOrder){ 
			//will be good when the userOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserOrder.
			
			
			userOrder = saveUserOrder(userContext, userOrder, options);
			return userOrder;
			
		}

	}
	
	public UserOrder updateUserOrder(SearchUserContext userContext,String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserOrder(userContext, userOrderId, userOrderVersion, property, newValueExpr, tokensExpr);
		
		
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		if(userOrder.getVersion() != userOrderVersion){
			String message = "The target version("+userOrder.getVersion()+") is not equals to version("+userOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userOrder){ 
			//will be good when the userOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserOrder.
			
			userOrder.changeProperty(property, newValueExpr);
			userOrder = saveUserOrder(userContext, userOrder, tokens().done());
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
			//return saveUserOrder(userContext, userOrder, tokens().done());
		}

	}
	
	public UserOrder updateUserOrderProperty(SearchUserContext userContext,String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserOrder(userContext, userOrderId, userOrderVersion, property, newValueExpr, tokensExpr);
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		if(userOrder.getVersion() != userOrderVersion){
			String message = "The target version("+userOrder.getVersion()+") is not equals to version("+userOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userOrder){ 
			//will be good when the userOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserOrder.
			
			userOrder.changeProperty(property, newValueExpr);
			
			userOrder = saveUserOrder(userContext, userOrder, tokens().done());
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
			//return saveUserOrder(userContext, userOrder, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected UserOrderTokens tokens(){
		return UserOrderTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserOrderTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLineItemListWith("id","desc")
		.sortOrderPromotionListWith("id","desc")
		.sortManualAdjustmentListWith("id","desc")
		.sortShippingGroupListWith("id","desc")
		.sortPaymentGroupListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserOrderTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUser(SearchUserContext userContext, String userOrderId, String anotherUserId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfUserOrder(userOrderId);
 		userContext.getChecker().checkIdOfProfile(anotherUserId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
 		
 	}
 	public UserOrder transferToAnotherUser(SearchUserContext userContext, String userOrderId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, userOrderId,anotherUserId);
 
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());	
		synchronized(userOrder){
			//will be good when the userOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile user = loadProfile(userContext, anotherUserId, emptyOptions());		
			userOrder.updateUser(user);		
			userOrder = saveUserOrder(userContext, userOrder, emptyOptions());
			
			return present(userContext,userOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidateUser(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfile result = new CandidateProfile();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForUserOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(SearchUserContext userContext, String userOrderId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfUserOrder(userOrderId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
 		
 	}
 	public UserOrder transferToAnotherPlatform(SearchUserContext userContext, String userOrderId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, userOrderId,anotherPlatformId);
 
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());	
		synchronized(userOrder){
			//will be good when the userOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			userOrder.updatePlatform(platform);		
			userOrder = saveUserOrder(userContext, userOrder, emptyOptions());
			
			return present(userContext,userOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForUserOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Profile loadProfile(SearchUserContext userContext, String newUserId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newUserId, options);
 	}
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(SearchUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String userOrderId, int userOrderVersion) throws Exception {
		//deleteInternal(userContext, userOrderId, userOrderVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String userOrderId, int userOrderVersion) throws Exception{
			
		userContext.getDAOGroup().getUserOrderDAO().delete(userOrderId, userOrderVersion);
	}
	
	public UserOrder forgetByAll(SearchUserContext userContext, String userOrderId, int userOrderVersion) throws Exception {
		return forgetByAllInternal(userContext, userOrderId, userOrderVersion);		
	}
	protected UserOrder forgetByAllInternal(SearchUserContext userContext,
			String userOrderId, int userOrderVersion) throws Exception{
			
		return userContext.getDAOGroup().getUserOrderDAO().disconnectFromAll(userOrderId, userOrderVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserOrderManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getUserOrderDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingLineItem(SearchUserContext userContext, String userOrderId, String name, int quantity, BigDecimal price, BigDecimal discountPrice,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);

		
		userContext.getChecker().checkNameOfLineItem(name);
		
		userContext.getChecker().checkQuantityOfLineItem(quantity);
		
		userContext.getChecker().checkPriceOfLineItem(price);
		
		userContext.getChecker().checkDiscountPriceOfLineItem(discountPrice);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);

	
	}
	public  UserOrder addLineItem(SearchUserContext userContext, String userOrderId, String name, int quantity, BigDecimal price, BigDecimal discountPrice, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLineItem(userContext,userOrderId,name, quantity, price, discountPrice,tokensExpr);
		
		LineItem lineItem = createLineItem(userContext,name, quantity, price, discountPrice);
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.addLineItem( lineItem );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withLineItemList().done());
			
			userContext.getManagerGroup().getLineItemManager().onNewInstanceCreated(userContext, lineItem);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLineItemProperties(SearchUserContext userContext, String userOrderId,String id,String name,int quantity,BigDecimal price,BigDecimal discountPrice,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfLineItem(id);
		
		userContext.getChecker().checkNameOfLineItem( name);
		userContext.getChecker().checkQuantityOfLineItem( quantity);
		userContext.getChecker().checkPriceOfLineItem( price);
		userContext.getChecker().checkDiscountPriceOfLineItem( discountPrice);

		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder updateLineItemProperties(SearchUserContext userContext, String userOrderId, String id,String name,int quantity,BigDecimal price,BigDecimal discountPrice, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLineItemProperties(userContext,userOrderId,id,name,quantity,price,discountPrice,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLineItemListList()
				.searchLineItemListWith(LineItem.ID_PROPERTY, "is", id).done();
		
		UserOrder userOrderToUpdate = loadUserOrder(userContext, userOrderId, options);
		
		if(userOrderToUpdate.getLineItemList().isEmpty()){
			throw new UserOrderManagerException("LineItem is NOT FOUND with id: '"+id+"'");
		}
		
		LineItem item = userOrderToUpdate.getLineItemList().first();
		
		item.updateName( name );
		item.updateQuantity( quantity );
		item.updatePrice( price );
		item.updateDiscountPrice( discountPrice );

		
		//checkParamsForAddingLineItem(userContext,userOrderId,name, code, used,tokensExpr);
		UserOrder userOrder = saveUserOrder(userContext, userOrderToUpdate, tokens().withLineItemList().done());
		synchronized(userOrder){ 
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LineItem createLineItem(SearchUserContext userContext, String name, int quantity, BigDecimal price, BigDecimal discountPrice) throws Exception{

		LineItem lineItem = new LineItem();
		
		
		lineItem.setName(name);		
		lineItem.setQuantity(quantity);		
		lineItem.setPrice(price);		
		lineItem.setDiscountPrice(discountPrice);
	
		
		return lineItem;
	
		
	}
	
	protected LineItem createIndexedLineItem(String id, int version){

		LineItem lineItem = new LineItem();
		lineItem.setId(id);
		lineItem.setVersion(version);
		return lineItem;			
		
	}
	
	protected void checkParamsForRemovingLineItemList(SearchUserContext userContext, String userOrderId, 
			String lineItemIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		for(String lineItemId: lineItemIds){
			userContext.getChecker().checkIdOfLineItem(lineItemId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder removeLineItemList(SearchUserContext userContext, String userOrderId, 
			String lineItemIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLineItemList(userContext, userOrderId,  lineItemIds, tokensExpr);
			
			
			UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
			synchronized(userOrder){ 
				//Will be good when the userOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getUserOrderDAO().planToRemoveLineItemList(userOrder, lineItemIds, allTokens());
				userOrder = saveUserOrder(userContext, userOrder, tokens().withLineItemList().done());
				deleteRelationListInGraph(userContext, userOrder.getLineItemList());
				return present(userContext,userOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLineItem(SearchUserContext userContext, String userOrderId, 
		String lineItemId, int lineItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfLineItem(lineItemId);
		userContext.getChecker().checkVersionOfLineItem(lineItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder removeLineItem(SearchUserContext userContext, String userOrderId, 
		String lineItemId, int lineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLineItem(userContext,userOrderId, lineItemId, lineItemVersion,tokensExpr);
		
		LineItem lineItem = createIndexedLineItem(lineItemId, lineItemVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.removeLineItem( lineItem );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withLineItemList().done());
			deleteRelationInGraph(userContext, lineItem);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLineItem(SearchUserContext userContext, String userOrderId, 
		String lineItemId, int lineItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfLineItem(lineItemId);
		userContext.getChecker().checkVersionOfLineItem(lineItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder copyLineItemFrom(SearchUserContext userContext, String userOrderId, 
		String lineItemId, int lineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLineItem(userContext,userOrderId, lineItemId, lineItemVersion,tokensExpr);
		
		LineItem lineItem = createIndexedLineItem(lineItemId, lineItemVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			userOrder.copyLineItemFrom( lineItem );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withLineItemList().done());
			
			userContext.getManagerGroup().getLineItemManager().onNewInstanceCreated(userContext, (LineItem)userOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLineItem(SearchUserContext userContext, String userOrderId, String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfLineItem(lineItemId);
		userContext.getChecker().checkVersionOfLineItem(lineItemVersion);
		

		if(LineItem.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLineItem(parseString(newValueExpr));
		}
		
		if(LineItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfLineItem(parseInt(newValueExpr));
		}
		
		if(LineItem.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfLineItem(parseBigDecimal(newValueExpr));
		}
		
		if(LineItem.DISCOUNT_PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkDiscountPriceOfLineItem(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	
	public  UserOrder updateLineItem(SearchUserContext userContext, String userOrderId, String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLineItem(userContext, userOrderId, lineItemId, lineItemVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLineItemList().searchLineItemListWith(LineItem.ID_PROPERTY, "eq", lineItemId).done();
		
		
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, loadTokens);
		
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userOrder.removeLineItem( lineItem );	
			//make changes to AcceleraterAccount.
			LineItem lineItemIndex = createIndexedLineItem(lineItemId, lineItemVersion);
		
			LineItem lineItem = userOrder.findTheLineItem(lineItemIndex);
			if(lineItem == null){
				throw new UserOrderManagerException(lineItem+" is NOT FOUND" );
			}
			
			lineItem.changeProperty(property, newValueExpr);
			
			userOrder = saveUserOrder(userContext, userOrder, tokens().withLineItemList().done());
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingOrderPromotion(SearchUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);

		
		userContext.getChecker().checkNameOfOrderPromotion(name);
		
		userContext.getChecker().checkAmountOfOrderPromotion(amount);
		
		userContext.getChecker().checkThreadHoldOfOrderPromotion(threadHold);
		
		userContext.getChecker().checkTypeOfOrderPromotion(type);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);

	
	}
	public  UserOrder addOrderPromotion(SearchUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOrderPromotion(userContext,userOrderId,name, amount, threadHold, type,tokensExpr);
		
		OrderPromotion orderPromotion = createOrderPromotion(userContext,name, amount, threadHold, type);
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.addOrderPromotion( orderPromotion );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withOrderPromotionList().done());
			
			userContext.getManagerGroup().getOrderPromotionManager().onNewInstanceCreated(userContext, orderPromotion);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOrderPromotionProperties(SearchUserContext userContext, String userOrderId,String id,String name,int amount,int threadHold,String type,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfOrderPromotion(id);
		
		userContext.getChecker().checkNameOfOrderPromotion( name);
		userContext.getChecker().checkAmountOfOrderPromotion( amount);
		userContext.getChecker().checkThreadHoldOfOrderPromotion( threadHold);
		userContext.getChecker().checkTypeOfOrderPromotion( type);

		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder updateOrderPromotionProperties(SearchUserContext userContext, String userOrderId, String id,String name,int amount,int threadHold,String type, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingOrderPromotionProperties(userContext,userOrderId,id,name,amount,threadHold,type,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOrderPromotionListList()
				.searchOrderPromotionListWith(OrderPromotion.ID_PROPERTY, "is", id).done();
		
		UserOrder userOrderToUpdate = loadUserOrder(userContext, userOrderId, options);
		
		if(userOrderToUpdate.getOrderPromotionList().isEmpty()){
			throw new UserOrderManagerException("OrderPromotion is NOT FOUND with id: '"+id+"'");
		}
		
		OrderPromotion item = userOrderToUpdate.getOrderPromotionList().first();
		
		item.updateName( name );
		item.updateAmount( amount );
		item.updateThreadHold( threadHold );
		item.updateType( type );

		
		//checkParamsForAddingOrderPromotion(userContext,userOrderId,name, code, used,tokensExpr);
		UserOrder userOrder = saveUserOrder(userContext, userOrderToUpdate, tokens().withOrderPromotionList().done());
		synchronized(userOrder){ 
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected OrderPromotion createOrderPromotion(SearchUserContext userContext, String name, int amount, int threadHold, String type) throws Exception{

		OrderPromotion orderPromotion = new OrderPromotion();
		
		
		orderPromotion.setName(name);		
		orderPromotion.setAmount(amount);		
		orderPromotion.setThreadHold(threadHold);		
		orderPromotion.setType(type);
	
		
		return orderPromotion;
	
		
	}
	
	protected OrderPromotion createIndexedOrderPromotion(String id, int version){

		OrderPromotion orderPromotion = new OrderPromotion();
		orderPromotion.setId(id);
		orderPromotion.setVersion(version);
		return orderPromotion;			
		
	}
	
	protected void checkParamsForRemovingOrderPromotionList(SearchUserContext userContext, String userOrderId, 
			String orderPromotionIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		for(String orderPromotionId: orderPromotionIds){
			userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder removeOrderPromotionList(SearchUserContext userContext, String userOrderId, 
			String orderPromotionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingOrderPromotionList(userContext, userOrderId,  orderPromotionIds, tokensExpr);
			
			
			UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
			synchronized(userOrder){ 
				//Will be good when the userOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getUserOrderDAO().planToRemoveOrderPromotionList(userOrder, orderPromotionIds, allTokens());
				userOrder = saveUserOrder(userContext, userOrder, tokens().withOrderPromotionList().done());
				deleteRelationListInGraph(userContext, userOrder.getOrderPromotionList());
				return present(userContext,userOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingOrderPromotion(SearchUserContext userContext, String userOrderId, 
		String orderPromotionId, int orderPromotionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
		userContext.getChecker().checkVersionOfOrderPromotion(orderPromotionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder removeOrderPromotion(SearchUserContext userContext, String userOrderId, 
		String orderPromotionId, int orderPromotionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOrderPromotion(userContext,userOrderId, orderPromotionId, orderPromotionVersion,tokensExpr);
		
		OrderPromotion orderPromotion = createIndexedOrderPromotion(orderPromotionId, orderPromotionVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.removeOrderPromotion( orderPromotion );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withOrderPromotionList().done());
			deleteRelationInGraph(userContext, orderPromotion);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingOrderPromotion(SearchUserContext userContext, String userOrderId, 
		String orderPromotionId, int orderPromotionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
		userContext.getChecker().checkVersionOfOrderPromotion(orderPromotionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder copyOrderPromotionFrom(SearchUserContext userContext, String userOrderId, 
		String orderPromotionId, int orderPromotionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOrderPromotion(userContext,userOrderId, orderPromotionId, orderPromotionVersion,tokensExpr);
		
		OrderPromotion orderPromotion = createIndexedOrderPromotion(orderPromotionId, orderPromotionVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			userOrder.copyOrderPromotionFrom( orderPromotion );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withOrderPromotionList().done());
			
			userContext.getManagerGroup().getOrderPromotionManager().onNewInstanceCreated(userContext, (OrderPromotion)userOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingOrderPromotion(SearchUserContext userContext, String userOrderId, String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
		userContext.getChecker().checkVersionOfOrderPromotion(orderPromotionVersion);
		

		if(OrderPromotion.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfOrderPromotion(parseString(newValueExpr));
		}
		
		if(OrderPromotion.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfOrderPromotion(parseInt(newValueExpr));
		}
		
		if(OrderPromotion.THREAD_HOLD_PROPERTY.equals(property)){
			userContext.getChecker().checkThreadHoldOfOrderPromotion(parseInt(newValueExpr));
		}
		
		if(OrderPromotion.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfOrderPromotion(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	
	public  UserOrder updateOrderPromotion(SearchUserContext userContext, String userOrderId, String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOrderPromotion(userContext, userOrderId, orderPromotionId, orderPromotionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withOrderPromotionList().searchOrderPromotionListWith(OrderPromotion.ID_PROPERTY, "eq", orderPromotionId).done();
		
		
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, loadTokens);
		
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userOrder.removeOrderPromotion( orderPromotion );	
			//make changes to AcceleraterAccount.
			OrderPromotion orderPromotionIndex = createIndexedOrderPromotion(orderPromotionId, orderPromotionVersion);
		
			OrderPromotion orderPromotion = userOrder.findTheOrderPromotion(orderPromotionIndex);
			if(orderPromotion == null){
				throw new UserOrderManagerException(orderPromotion+" is NOT FOUND" );
			}
			
			orderPromotion.changeProperty(property, newValueExpr);
			
			userOrder = saveUserOrder(userContext, userOrder, tokens().withOrderPromotionList().done());
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingManualAdjustment(SearchUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);

		
		userContext.getChecker().checkNameOfManualAdjustment(name);
		
		userContext.getChecker().checkAmountOfManualAdjustment(amount);
		
		userContext.getChecker().checkThreadHoldOfManualAdjustment(threadHold);
		
		userContext.getChecker().checkTypeOfManualAdjustment(type);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);

	
	}
	public  UserOrder addManualAdjustment(SearchUserContext userContext, String userOrderId, String name, int amount, int threadHold, String type, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingManualAdjustment(userContext,userOrderId,name, amount, threadHold, type,tokensExpr);
		
		ManualAdjustment manualAdjustment = createManualAdjustment(userContext,name, amount, threadHold, type);
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.addManualAdjustment( manualAdjustment );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withManualAdjustmentList().done());
			
			userContext.getManagerGroup().getManualAdjustmentManager().onNewInstanceCreated(userContext, manualAdjustment);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingManualAdjustmentProperties(SearchUserContext userContext, String userOrderId,String id,String name,int amount,int threadHold,String type,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfManualAdjustment(id);
		
		userContext.getChecker().checkNameOfManualAdjustment( name);
		userContext.getChecker().checkAmountOfManualAdjustment( amount);
		userContext.getChecker().checkThreadHoldOfManualAdjustment( threadHold);
		userContext.getChecker().checkTypeOfManualAdjustment( type);

		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder updateManualAdjustmentProperties(SearchUserContext userContext, String userOrderId, String id,String name,int amount,int threadHold,String type, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingManualAdjustmentProperties(userContext,userOrderId,id,name,amount,threadHold,type,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withManualAdjustmentListList()
				.searchManualAdjustmentListWith(ManualAdjustment.ID_PROPERTY, "is", id).done();
		
		UserOrder userOrderToUpdate = loadUserOrder(userContext, userOrderId, options);
		
		if(userOrderToUpdate.getManualAdjustmentList().isEmpty()){
			throw new UserOrderManagerException("ManualAdjustment is NOT FOUND with id: '"+id+"'");
		}
		
		ManualAdjustment item = userOrderToUpdate.getManualAdjustmentList().first();
		
		item.updateName( name );
		item.updateAmount( amount );
		item.updateThreadHold( threadHold );
		item.updateType( type );

		
		//checkParamsForAddingManualAdjustment(userContext,userOrderId,name, code, used,tokensExpr);
		UserOrder userOrder = saveUserOrder(userContext, userOrderToUpdate, tokens().withManualAdjustmentList().done());
		synchronized(userOrder){ 
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ManualAdjustment createManualAdjustment(SearchUserContext userContext, String name, int amount, int threadHold, String type) throws Exception{

		ManualAdjustment manualAdjustment = new ManualAdjustment();
		
		
		manualAdjustment.setName(name);		
		manualAdjustment.setAmount(amount);		
		manualAdjustment.setThreadHold(threadHold);		
		manualAdjustment.setType(type);
	
		
		return manualAdjustment;
	
		
	}
	
	protected ManualAdjustment createIndexedManualAdjustment(String id, int version){

		ManualAdjustment manualAdjustment = new ManualAdjustment();
		manualAdjustment.setId(id);
		manualAdjustment.setVersion(version);
		return manualAdjustment;			
		
	}
	
	protected void checkParamsForRemovingManualAdjustmentList(SearchUserContext userContext, String userOrderId, 
			String manualAdjustmentIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		for(String manualAdjustmentId: manualAdjustmentIds){
			userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder removeManualAdjustmentList(SearchUserContext userContext, String userOrderId, 
			String manualAdjustmentIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingManualAdjustmentList(userContext, userOrderId,  manualAdjustmentIds, tokensExpr);
			
			
			UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
			synchronized(userOrder){ 
				//Will be good when the userOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getUserOrderDAO().planToRemoveManualAdjustmentList(userOrder, manualAdjustmentIds, allTokens());
				userOrder = saveUserOrder(userContext, userOrder, tokens().withManualAdjustmentList().done());
				deleteRelationListInGraph(userContext, userOrder.getManualAdjustmentList());
				return present(userContext,userOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingManualAdjustment(SearchUserContext userContext, String userOrderId, 
		String manualAdjustmentId, int manualAdjustmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
		userContext.getChecker().checkVersionOfManualAdjustment(manualAdjustmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder removeManualAdjustment(SearchUserContext userContext, String userOrderId, 
		String manualAdjustmentId, int manualAdjustmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingManualAdjustment(userContext,userOrderId, manualAdjustmentId, manualAdjustmentVersion,tokensExpr);
		
		ManualAdjustment manualAdjustment = createIndexedManualAdjustment(manualAdjustmentId, manualAdjustmentVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.removeManualAdjustment( manualAdjustment );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withManualAdjustmentList().done());
			deleteRelationInGraph(userContext, manualAdjustment);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingManualAdjustment(SearchUserContext userContext, String userOrderId, 
		String manualAdjustmentId, int manualAdjustmentVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
		userContext.getChecker().checkVersionOfManualAdjustment(manualAdjustmentVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder copyManualAdjustmentFrom(SearchUserContext userContext, String userOrderId, 
		String manualAdjustmentId, int manualAdjustmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingManualAdjustment(userContext,userOrderId, manualAdjustmentId, manualAdjustmentVersion,tokensExpr);
		
		ManualAdjustment manualAdjustment = createIndexedManualAdjustment(manualAdjustmentId, manualAdjustmentVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			userOrder.copyManualAdjustmentFrom( manualAdjustment );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withManualAdjustmentList().done());
			
			userContext.getManagerGroup().getManualAdjustmentManager().onNewInstanceCreated(userContext, (ManualAdjustment)userOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingManualAdjustment(SearchUserContext userContext, String userOrderId, String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfManualAdjustment(manualAdjustmentId);
		userContext.getChecker().checkVersionOfManualAdjustment(manualAdjustmentVersion);
		

		if(ManualAdjustment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfManualAdjustment(parseString(newValueExpr));
		}
		
		if(ManualAdjustment.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfManualAdjustment(parseInt(newValueExpr));
		}
		
		if(ManualAdjustment.THREAD_HOLD_PROPERTY.equals(property)){
			userContext.getChecker().checkThreadHoldOfManualAdjustment(parseInt(newValueExpr));
		}
		
		if(ManualAdjustment.TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkTypeOfManualAdjustment(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	
	public  UserOrder updateManualAdjustment(SearchUserContext userContext, String userOrderId, String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingManualAdjustment(userContext, userOrderId, manualAdjustmentId, manualAdjustmentVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withManualAdjustmentList().searchManualAdjustmentListWith(ManualAdjustment.ID_PROPERTY, "eq", manualAdjustmentId).done();
		
		
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, loadTokens);
		
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userOrder.removeManualAdjustment( manualAdjustment );	
			//make changes to AcceleraterAccount.
			ManualAdjustment manualAdjustmentIndex = createIndexedManualAdjustment(manualAdjustmentId, manualAdjustmentVersion);
		
			ManualAdjustment manualAdjustment = userOrder.findTheManualAdjustment(manualAdjustmentIndex);
			if(manualAdjustment == null){
				throw new UserOrderManagerException(manualAdjustment+" is NOT FOUND" );
			}
			
			manualAdjustment.changeProperty(property, newValueExpr);
			
			userOrder = saveUserOrder(userContext, userOrder, tokens().withManualAdjustmentList().done());
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingShippingGroup(SearchUserContext userContext, String userOrderId, String name, String line1, String line2, String city, String state, int zipCode, String country,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);

		
		userContext.getChecker().checkNameOfShippingGroup(name);
		
		userContext.getChecker().checkLine1OfShippingGroup(line1);
		
		userContext.getChecker().checkLine2OfShippingGroup(line2);
		
		userContext.getChecker().checkCityOfShippingGroup(city);
		
		userContext.getChecker().checkStateOfShippingGroup(state);
		
		userContext.getChecker().checkZipCodeOfShippingGroup(zipCode);
		
		userContext.getChecker().checkCountryOfShippingGroup(country);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);

	
	}
	public  UserOrder addShippingGroup(SearchUserContext userContext, String userOrderId, String name, String line1, String line2, String city, String state, int zipCode, String country, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingShippingGroup(userContext,userOrderId,name, line1, line2, city, state, zipCode, country,tokensExpr);
		
		ShippingGroup shippingGroup = createShippingGroup(userContext,name, line1, line2, city, state, zipCode, country);
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.addShippingGroup( shippingGroup );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withShippingGroupList().done());
			
			userContext.getManagerGroup().getShippingGroupManager().onNewInstanceCreated(userContext, shippingGroup);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingShippingGroupProperties(SearchUserContext userContext, String userOrderId,String id,String name,String line1,String line2,String city,String state,int zipCode,String country,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfShippingGroup(id);
		
		userContext.getChecker().checkNameOfShippingGroup( name);
		userContext.getChecker().checkLine1OfShippingGroup( line1);
		userContext.getChecker().checkLine2OfShippingGroup( line2);
		userContext.getChecker().checkCityOfShippingGroup( city);
		userContext.getChecker().checkStateOfShippingGroup( state);
		userContext.getChecker().checkZipCodeOfShippingGroup( zipCode);
		userContext.getChecker().checkCountryOfShippingGroup( country);

		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder updateShippingGroupProperties(SearchUserContext userContext, String userOrderId, String id,String name,String line1,String line2,String city,String state,int zipCode,String country, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingShippingGroupProperties(userContext,userOrderId,id,name,line1,line2,city,state,zipCode,country,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withShippingGroupListList()
				.searchShippingGroupListWith(ShippingGroup.ID_PROPERTY, "is", id).done();
		
		UserOrder userOrderToUpdate = loadUserOrder(userContext, userOrderId, options);
		
		if(userOrderToUpdate.getShippingGroupList().isEmpty()){
			throw new UserOrderManagerException("ShippingGroup is NOT FOUND with id: '"+id+"'");
		}
		
		ShippingGroup item = userOrderToUpdate.getShippingGroupList().first();
		
		item.updateName( name );
		item.updateLine1( line1 );
		item.updateLine2( line2 );
		item.updateCity( city );
		item.updateState( state );
		item.updateZipCode( zipCode );
		item.updateCountry( country );

		
		//checkParamsForAddingShippingGroup(userContext,userOrderId,name, code, used,tokensExpr);
		UserOrder userOrder = saveUserOrder(userContext, userOrderToUpdate, tokens().withShippingGroupList().done());
		synchronized(userOrder){ 
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ShippingGroup createShippingGroup(SearchUserContext userContext, String name, String line1, String line2, String city, String state, int zipCode, String country) throws Exception{

		ShippingGroup shippingGroup = new ShippingGroup();
		
		
		shippingGroup.setName(name);		
		shippingGroup.setLine1(line1);		
		shippingGroup.setLine2(line2);		
		shippingGroup.setCity(city);		
		shippingGroup.setState(state);		
		shippingGroup.setZipCode(zipCode);		
		shippingGroup.setCountry(country);
	
		
		return shippingGroup;
	
		
	}
	
	protected ShippingGroup createIndexedShippingGroup(String id, int version){

		ShippingGroup shippingGroup = new ShippingGroup();
		shippingGroup.setId(id);
		shippingGroup.setVersion(version);
		return shippingGroup;			
		
	}
	
	protected void checkParamsForRemovingShippingGroupList(SearchUserContext userContext, String userOrderId, 
			String shippingGroupIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		for(String shippingGroupId: shippingGroupIds){
			userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder removeShippingGroupList(SearchUserContext userContext, String userOrderId, 
			String shippingGroupIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingShippingGroupList(userContext, userOrderId,  shippingGroupIds, tokensExpr);
			
			
			UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
			synchronized(userOrder){ 
				//Will be good when the userOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getUserOrderDAO().planToRemoveShippingGroupList(userOrder, shippingGroupIds, allTokens());
				userOrder = saveUserOrder(userContext, userOrder, tokens().withShippingGroupList().done());
				deleteRelationListInGraph(userContext, userOrder.getShippingGroupList());
				return present(userContext,userOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingShippingGroup(SearchUserContext userContext, String userOrderId, 
		String shippingGroupId, int shippingGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
		userContext.getChecker().checkVersionOfShippingGroup(shippingGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder removeShippingGroup(SearchUserContext userContext, String userOrderId, 
		String shippingGroupId, int shippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingShippingGroup(userContext,userOrderId, shippingGroupId, shippingGroupVersion,tokensExpr);
		
		ShippingGroup shippingGroup = createIndexedShippingGroup(shippingGroupId, shippingGroupVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.removeShippingGroup( shippingGroup );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withShippingGroupList().done());
			deleteRelationInGraph(userContext, shippingGroup);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingShippingGroup(SearchUserContext userContext, String userOrderId, 
		String shippingGroupId, int shippingGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
		userContext.getChecker().checkVersionOfShippingGroup(shippingGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder copyShippingGroupFrom(SearchUserContext userContext, String userOrderId, 
		String shippingGroupId, int shippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingShippingGroup(userContext,userOrderId, shippingGroupId, shippingGroupVersion,tokensExpr);
		
		ShippingGroup shippingGroup = createIndexedShippingGroup(shippingGroupId, shippingGroupVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			userOrder.copyShippingGroupFrom( shippingGroup );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withShippingGroupList().done());
			
			userContext.getManagerGroup().getShippingGroupManager().onNewInstanceCreated(userContext, (ShippingGroup)userOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingShippingGroup(SearchUserContext userContext, String userOrderId, String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfShippingGroup(shippingGroupId);
		userContext.getChecker().checkVersionOfShippingGroup(shippingGroupVersion);
		

		if(ShippingGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfShippingGroup(parseString(newValueExpr));
		}
		
		if(ShippingGroup.LINE1_PROPERTY.equals(property)){
			userContext.getChecker().checkLine1OfShippingGroup(parseString(newValueExpr));
		}
		
		if(ShippingGroup.LINE2_PROPERTY.equals(property)){
			userContext.getChecker().checkLine2OfShippingGroup(parseString(newValueExpr));
		}
		
		if(ShippingGroup.CITY_PROPERTY.equals(property)){
			userContext.getChecker().checkCityOfShippingGroup(parseString(newValueExpr));
		}
		
		if(ShippingGroup.STATE_PROPERTY.equals(property)){
			userContext.getChecker().checkStateOfShippingGroup(parseString(newValueExpr));
		}
		
		if(ShippingGroup.ZIP_CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkZipCodeOfShippingGroup(parseInt(newValueExpr));
		}
		
		if(ShippingGroup.COUNTRY_PROPERTY.equals(property)){
			userContext.getChecker().checkCountryOfShippingGroup(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	
	public  UserOrder updateShippingGroup(SearchUserContext userContext, String userOrderId, String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingShippingGroup(userContext, userOrderId, shippingGroupId, shippingGroupVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withShippingGroupList().searchShippingGroupListWith(ShippingGroup.ID_PROPERTY, "eq", shippingGroupId).done();
		
		
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, loadTokens);
		
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userOrder.removeShippingGroup( shippingGroup );	
			//make changes to AcceleraterAccount.
			ShippingGroup shippingGroupIndex = createIndexedShippingGroup(shippingGroupId, shippingGroupVersion);
		
			ShippingGroup shippingGroup = userOrder.findTheShippingGroup(shippingGroupIndex);
			if(shippingGroup == null){
				throw new UserOrderManagerException(shippingGroup+" is NOT FOUND" );
			}
			
			shippingGroup.changeProperty(property, newValueExpr);
			
			userOrder = saveUserOrder(userContext, userOrder, tokens().withShippingGroupList().done());
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingPaymentGroup(SearchUserContext userContext, String userOrderId, String name, BigDecimal amount, String status,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);

		
		userContext.getChecker().checkNameOfPaymentGroup(name);
		
		userContext.getChecker().checkAmountOfPaymentGroup(amount);
		
		userContext.getChecker().checkStatusOfPaymentGroup(status);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);

	
	}
	public  UserOrder addPaymentGroup(SearchUserContext userContext, String userOrderId, String name, BigDecimal amount, String status, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPaymentGroup(userContext,userOrderId,name, amount, status,tokensExpr);
		
		PaymentGroup paymentGroup = createPaymentGroup(userContext,name, amount, status);
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.addPaymentGroup( paymentGroup );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withPaymentGroupList().done());
			
			userContext.getManagerGroup().getPaymentGroupManager().onNewInstanceCreated(userContext, paymentGroup);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPaymentGroupProperties(SearchUserContext userContext, String userOrderId,String id,String name,BigDecimal amount,String status,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfPaymentGroup(id);
		
		userContext.getChecker().checkNameOfPaymentGroup( name);
		userContext.getChecker().checkAmountOfPaymentGroup( amount);
		userContext.getChecker().checkStatusOfPaymentGroup( status);

		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder updatePaymentGroupProperties(SearchUserContext userContext, String userOrderId, String id,String name,BigDecimal amount,String status, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingPaymentGroupProperties(userContext,userOrderId,id,name,amount,status,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPaymentGroupListList()
				.searchPaymentGroupListWith(PaymentGroup.ID_PROPERTY, "is", id).done();
		
		UserOrder userOrderToUpdate = loadUserOrder(userContext, userOrderId, options);
		
		if(userOrderToUpdate.getPaymentGroupList().isEmpty()){
			throw new UserOrderManagerException("PaymentGroup is NOT FOUND with id: '"+id+"'");
		}
		
		PaymentGroup item = userOrderToUpdate.getPaymentGroupList().first();
		
		item.updateName( name );
		item.updateAmount( amount );
		item.updateStatus( status );

		
		//checkParamsForAddingPaymentGroup(userContext,userOrderId,name, code, used,tokensExpr);
		UserOrder userOrder = saveUserOrder(userContext, userOrderToUpdate, tokens().withPaymentGroupList().done());
		synchronized(userOrder){ 
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected PaymentGroup createPaymentGroup(SearchUserContext userContext, String name, BigDecimal amount, String status) throws Exception{

		PaymentGroup paymentGroup = new PaymentGroup();
		
		
		paymentGroup.setName(name);		
		paymentGroup.setAmount(amount);		
		paymentGroup.setStatus(status);
	
		
		return paymentGroup;
	
		
	}
	
	protected PaymentGroup createIndexedPaymentGroup(String id, int version){

		PaymentGroup paymentGroup = new PaymentGroup();
		paymentGroup.setId(id);
		paymentGroup.setVersion(version);
		return paymentGroup;			
		
	}
	
	protected void checkParamsForRemovingPaymentGroupList(SearchUserContext userContext, String userOrderId, 
			String paymentGroupIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		for(String paymentGroupId: paymentGroupIds){
			userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
		
	}
	public  UserOrder removePaymentGroupList(SearchUserContext userContext, String userOrderId, 
			String paymentGroupIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingPaymentGroupList(userContext, userOrderId,  paymentGroupIds, tokensExpr);
			
			
			UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
			synchronized(userOrder){ 
				//Will be good when the userOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getUserOrderDAO().planToRemovePaymentGroupList(userOrder, paymentGroupIds, allTokens());
				userOrder = saveUserOrder(userContext, userOrder, tokens().withPaymentGroupList().done());
				deleteRelationListInGraph(userContext, userOrder.getPaymentGroupList());
				return present(userContext,userOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingPaymentGroup(SearchUserContext userContext, String userOrderId, 
		String paymentGroupId, int paymentGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
		userContext.getChecker().checkVersionOfPaymentGroup(paymentGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder removePaymentGroup(SearchUserContext userContext, String userOrderId, 
		String paymentGroupId, int paymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPaymentGroup(userContext,userOrderId, paymentGroupId, paymentGroupVersion,tokensExpr);
		
		PaymentGroup paymentGroup = createIndexedPaymentGroup(paymentGroupId, paymentGroupVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			userOrder.removePaymentGroup( paymentGroup );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withPaymentGroupList().done());
			deleteRelationInGraph(userContext, paymentGroup);
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingPaymentGroup(SearchUserContext userContext, String userOrderId, 
		String paymentGroupId, int paymentGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfUserOrder( userOrderId);
		userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
		userContext.getChecker().checkVersionOfPaymentGroup(paymentGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	public  UserOrder copyPaymentGroupFrom(SearchUserContext userContext, String userOrderId, 
		String paymentGroupId, int paymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPaymentGroup(userContext,userOrderId, paymentGroupId, paymentGroupVersion,tokensExpr);
		
		PaymentGroup paymentGroup = createIndexedPaymentGroup(paymentGroupId, paymentGroupVersion);
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, allTokens());
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			userOrder.copyPaymentGroupFrom( paymentGroup );		
			userOrder = saveUserOrder(userContext, userOrder, tokens().withPaymentGroupList().done());
			
			userContext.getManagerGroup().getPaymentGroupManager().onNewInstanceCreated(userContext, (PaymentGroup)userOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingPaymentGroup(SearchUserContext userContext, String userOrderId, String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkIdOfPaymentGroup(paymentGroupId);
		userContext.getChecker().checkVersionOfPaymentGroup(paymentGroupVersion);
		

		if(PaymentGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPaymentGroup(parseString(newValueExpr));
		}
		
		if(PaymentGroup.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfPaymentGroup(parseBigDecimal(newValueExpr));
		}
		
		if(PaymentGroup.STATUS_PROPERTY.equals(property)){
			userContext.getChecker().checkStatusOfPaymentGroup(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserOrderManagerException.class);
	
	}
	
	public  UserOrder updatePaymentGroup(SearchUserContext userContext, String userOrderId, String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPaymentGroup(userContext, userOrderId, paymentGroupId, paymentGroupVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withPaymentGroupList().searchPaymentGroupListWith(PaymentGroup.ID_PROPERTY, "eq", paymentGroupId).done();
		
		
		
		UserOrder userOrder = loadUserOrder(userContext, userOrderId, loadTokens);
		
		synchronized(userOrder){ 
			//Will be good when the userOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//userOrder.removePaymentGroup( paymentGroup );	
			//make changes to AcceleraterAccount.
			PaymentGroup paymentGroupIndex = createIndexedPaymentGroup(paymentGroupId, paymentGroupVersion);
		
			PaymentGroup paymentGroup = userOrder.findThePaymentGroup(paymentGroupIndex);
			if(paymentGroup == null){
				throw new UserOrderManagerException(paymentGroup+" is NOT FOUND" );
			}
			
			paymentGroup.changeProperty(property, newValueExpr);
			
			userOrder = saveUserOrder(userContext, userOrder, tokens().withPaymentGroupList().done());
			return present(userContext,userOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(SearchUserContext userContext, UserOrder newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


