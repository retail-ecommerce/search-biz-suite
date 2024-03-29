
package com.doublechaintech.search.orderpromotion;

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

import com.doublechaintech.search.userorder.UserOrder;

import com.doublechaintech.search.userorder.CandidateUserOrder;







public class OrderPromotionManagerImpl extends CustomSearchCheckerManager implements OrderPromotionManager {
	
	private static final String SERVICE_TYPE = "OrderPromotion";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws OrderPromotionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new OrderPromotionManagerException(message);

	}
	
	

 	protected OrderPromotion saveOrderPromotion(SearchUserContext userContext, OrderPromotion orderPromotion, String [] tokensExpr) throws Exception{	
 		//return getOrderPromotionDAO().save(orderPromotion, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOrderPromotion(userContext, orderPromotion, tokens);
 	}
 	
 	protected OrderPromotion saveOrderPromotionDetail(SearchUserContext userContext, OrderPromotion orderPromotion) throws Exception{	

 		
 		return saveOrderPromotion(userContext, orderPromotion, allTokens());
 	}
 	
 	public OrderPromotion loadOrderPromotion(SearchUserContext userContext, String orderPromotionId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
		userContext.getChecker().throwExceptionIfHasErrors( OrderPromotionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OrderPromotion orderPromotion = loadOrderPromotion( userContext, orderPromotionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,orderPromotion, tokens);
 	}
 	
 	
 	 public OrderPromotion searchOrderPromotion(SearchUserContext userContext, String orderPromotionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
		userContext.getChecker().throwExceptionIfHasErrors( OrderPromotionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OrderPromotion orderPromotion = loadOrderPromotion( userContext, orderPromotionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,orderPromotion, tokens);
 	}
 	
 	

 	protected OrderPromotion present(SearchUserContext userContext, OrderPromotion orderPromotion, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,orderPromotion,tokens);
		
		
		OrderPromotion  orderPromotionToPresent = userContext.getDAOGroup().getOrderPromotionDAO().present(orderPromotion, tokens);
		
		List<BaseEntity> entityListToNaming = orderPromotionToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getOrderPromotionDAO().alias(entityListToNaming);
		
		return  orderPromotionToPresent;
		
		
	}
 
 	
 	
 	public OrderPromotion loadOrderPromotionDetail(SearchUserContext userContext, String orderPromotionId) throws Exception{	
 		OrderPromotion orderPromotion = loadOrderPromotion( userContext, orderPromotionId, allTokens());
 		return present(userContext,orderPromotion, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String orderPromotionId) throws Exception{	
 		OrderPromotion orderPromotion = loadOrderPromotion( userContext, orderPromotionId, viewTokens());
 		return present(userContext,orderPromotion, allTokens());
		
 	}
 	protected OrderPromotion saveOrderPromotion(SearchUserContext userContext, OrderPromotion orderPromotion, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getOrderPromotionDAO().save(orderPromotion, tokens);
 	}
 	protected OrderPromotion loadOrderPromotion(SearchUserContext userContext, String orderPromotionId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
		userContext.getChecker().throwExceptionIfHasErrors( OrderPromotionManagerException.class);

 
 		return userContext.getDAOGroup().getOrderPromotionDAO().load(orderPromotionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, OrderPromotion orderPromotion, Map<String, Object> tokens){
		super.addActions(userContext, orderPromotion, tokens);
		
		addAction(userContext, orderPromotion, tokens,"@create","createOrderPromotion","createOrderPromotion/","main","primary");
		addAction(userContext, orderPromotion, tokens,"@update","updateOrderPromotion","updateOrderPromotion/"+orderPromotion.getId()+"/","main","primary");
		addAction(userContext, orderPromotion, tokens,"@copy","cloneOrderPromotion","cloneOrderPromotion/"+orderPromotion.getId()+"/","main","primary");
		
		addAction(userContext, orderPromotion, tokens,"order_promotion.transfer_to_user_order","transferToAnotherUserOrder","transferToAnotherUserOrder/"+orderPromotion.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, OrderPromotion orderPromotion, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OrderPromotion createOrderPromotion(SearchUserContext userContext,String name, int amount, int threadHold, String type, String userOrderId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfOrderPromotion(name);
		userContext.getChecker().checkAmountOfOrderPromotion(amount);
		userContext.getChecker().checkThreadHoldOfOrderPromotion(threadHold);
		userContext.getChecker().checkTypeOfOrderPromotion(type);
	
		userContext.getChecker().throwExceptionIfHasErrors(OrderPromotionManagerException.class);


		OrderPromotion orderPromotion=createNewOrderPromotion();	

		orderPromotion.setName(name);
		orderPromotion.setAmount(amount);
		orderPromotion.setThreadHold(threadHold);
		orderPromotion.setType(type);
			
		UserOrder userOrder = loadUserOrder(userContext, userOrderId,emptyOptions());
		orderPromotion.setUserOrder(userOrder);
		
		

		orderPromotion = saveOrderPromotion(userContext, orderPromotion, emptyOptions());
		
		onNewInstanceCreated(userContext, orderPromotion);
		return orderPromotion;

		
	}
	protected OrderPromotion createNewOrderPromotion() 
	{
		
		return new OrderPromotion();		
	}
	
	protected void checkParamsForUpdatingOrderPromotion(SearchUserContext userContext,String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
		userContext.getChecker().checkVersionOfOrderPromotion( orderPromotionVersion);
		

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

		
	
		userContext.getChecker().throwExceptionIfHasErrors(OrderPromotionManagerException.class);
	
		
	}
	
	
	
	public OrderPromotion clone(SearchUserContext userContext, String fromOrderPromotionId) throws Exception{
		
		return userContext.getDAOGroup().getOrderPromotionDAO().clone(fromOrderPromotionId, this.allTokens());
	}
	
	public OrderPromotion internalSaveOrderPromotion(SearchUserContext userContext, OrderPromotion orderPromotion) throws Exception 
	{
		return internalSaveOrderPromotion(userContext, orderPromotion, allTokens());

	}
	public OrderPromotion internalSaveOrderPromotion(SearchUserContext userContext, OrderPromotion orderPromotion, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingOrderPromotion(userContext, orderPromotionId, orderPromotionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(orderPromotion){ 
			//will be good when the orderPromotion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OrderPromotion.
			
			
			orderPromotion = saveOrderPromotion(userContext, orderPromotion, options);
			return orderPromotion;
			
		}

	}
	
	public OrderPromotion updateOrderPromotion(SearchUserContext userContext,String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOrderPromotion(userContext, orderPromotionId, orderPromotionVersion, property, newValueExpr, tokensExpr);
		
		
		
		OrderPromotion orderPromotion = loadOrderPromotion(userContext, orderPromotionId, allTokens());
		if(orderPromotion.getVersion() != orderPromotionVersion){
			String message = "The target version("+orderPromotion.getVersion()+") is not equals to version("+orderPromotionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(orderPromotion){ 
			//will be good when the orderPromotion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OrderPromotion.
			
			orderPromotion.changeProperty(property, newValueExpr);
			orderPromotion = saveOrderPromotion(userContext, orderPromotion, tokens().done());
			return present(userContext,orderPromotion, mergedAllTokens(tokensExpr));
			//return saveOrderPromotion(userContext, orderPromotion, tokens().done());
		}

	}
	
	public OrderPromotion updateOrderPromotionProperty(SearchUserContext userContext,String orderPromotionId, int orderPromotionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOrderPromotion(userContext, orderPromotionId, orderPromotionVersion, property, newValueExpr, tokensExpr);
		
		OrderPromotion orderPromotion = loadOrderPromotion(userContext, orderPromotionId, allTokens());
		if(orderPromotion.getVersion() != orderPromotionVersion){
			String message = "The target version("+orderPromotion.getVersion()+") is not equals to version("+orderPromotionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(orderPromotion){ 
			//will be good when the orderPromotion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OrderPromotion.
			
			orderPromotion.changeProperty(property, newValueExpr);
			
			orderPromotion = saveOrderPromotion(userContext, orderPromotion, tokens().done());
			return present(userContext,orderPromotion, mergedAllTokens(tokensExpr));
			//return saveOrderPromotion(userContext, orderPromotion, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OrderPromotionTokens tokens(){
		return OrderPromotionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OrderPromotionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OrderPromotionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUserOrder(SearchUserContext userContext, String orderPromotionId, String anotherUserOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfOrderPromotion(orderPromotionId);
 		userContext.getChecker().checkIdOfUserOrder(anotherUserOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(OrderPromotionManagerException.class);
 		
 	}
 	public OrderPromotion transferToAnotherUserOrder(SearchUserContext userContext, String orderPromotionId, String anotherUserOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherUserOrder(userContext, orderPromotionId,anotherUserOrderId);
 
		OrderPromotion orderPromotion = loadOrderPromotion(userContext, orderPromotionId, allTokens());	
		synchronized(orderPromotion){
			//will be good when the orderPromotion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserOrder userOrder = loadUserOrder(userContext, anotherUserOrderId, emptyOptions());		
			orderPromotion.updateUserOrder(userOrder);		
			orderPromotion = saveOrderPromotion(userContext, orderPromotion, emptyOptions());
			
			return present(userContext,orderPromotion, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserOrder requestCandidateUserOrder(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserOrder result = new CandidateUserOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserOrder> candidateList = userContext.getDAOGroup().getUserOrderDAO().requestCandidateUserOrderForOrderPromotion(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected UserOrder loadUserOrder(SearchUserContext userContext, String newUserOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getUserOrderDAO().load(newUserOrderId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String orderPromotionId, int orderPromotionVersion) throws Exception {
		//deleteInternal(userContext, orderPromotionId, orderPromotionVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String orderPromotionId, int orderPromotionVersion) throws Exception{
			
		userContext.getDAOGroup().getOrderPromotionDAO().delete(orderPromotionId, orderPromotionVersion);
	}
	
	public OrderPromotion forgetByAll(SearchUserContext userContext, String orderPromotionId, int orderPromotionVersion) throws Exception {
		return forgetByAllInternal(userContext, orderPromotionId, orderPromotionVersion);		
	}
	protected OrderPromotion forgetByAllInternal(SearchUserContext userContext,
			String orderPromotionId, int orderPromotionVersion) throws Exception{
			
		return userContext.getDAOGroup().getOrderPromotionDAO().disconnectFromAll(orderPromotionId, orderPromotionVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OrderPromotionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getOrderPromotionDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(SearchUserContext userContext, OrderPromotion newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


