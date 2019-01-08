
package com.doublechaintech.search.paymentmethod;

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









public class PaymentMethodManagerImpl extends CustomSearchCheckerManager implements PaymentMethodManager {
	
	private static final String SERVICE_TYPE = "PaymentMethod";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PaymentMethodManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PaymentMethodManagerException(message);

	}
	
	

 	protected PaymentMethod savePaymentMethod(SearchUserContext userContext, PaymentMethod paymentMethod, String [] tokensExpr) throws Exception{	
 		//return getPaymentMethodDAO().save(paymentMethod, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePaymentMethod(userContext, paymentMethod, tokens);
 	}
 	
 	protected PaymentMethod savePaymentMethodDetail(SearchUserContext userContext, PaymentMethod paymentMethod) throws Exception{	

 		
 		return savePaymentMethod(userContext, paymentMethod, allTokens());
 	}
 	
 	public PaymentMethod loadPaymentMethod(SearchUserContext userContext, String paymentMethodId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPaymentMethod(paymentMethodId);
		userContext.getChecker().throwExceptionIfHasErrors( PaymentMethodManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PaymentMethod paymentMethod = loadPaymentMethod( userContext, paymentMethodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,paymentMethod, tokens);
 	}
 	
 	
 	 public PaymentMethod searchPaymentMethod(SearchUserContext userContext, String paymentMethodId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPaymentMethod(paymentMethodId);
		userContext.getChecker().throwExceptionIfHasErrors( PaymentMethodManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PaymentMethod paymentMethod = loadPaymentMethod( userContext, paymentMethodId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,paymentMethod, tokens);
 	}
 	
 	

 	protected PaymentMethod present(SearchUserContext userContext, PaymentMethod paymentMethod, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,paymentMethod,tokens);
		
		
		PaymentMethod  paymentMethodToPresent = userContext.getDAOGroup().getPaymentMethodDAO().present(paymentMethod, tokens);
		
		List<BaseEntity> entityListToNaming = paymentMethodToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPaymentMethodDAO().alias(entityListToNaming);
		
		return  paymentMethodToPresent;
		
		
	}
 
 	
 	
 	public PaymentMethod loadPaymentMethodDetail(SearchUserContext userContext, String paymentMethodId) throws Exception{	
 		PaymentMethod paymentMethod = loadPaymentMethod( userContext, paymentMethodId, allTokens());
 		return present(userContext,paymentMethod, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String paymentMethodId) throws Exception{	
 		PaymentMethod paymentMethod = loadPaymentMethod( userContext, paymentMethodId, viewTokens());
 		return present(userContext,paymentMethod, allTokens());
		
 	}
 	protected PaymentMethod savePaymentMethod(SearchUserContext userContext, PaymentMethod paymentMethod, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPaymentMethodDAO().save(paymentMethod, tokens);
 	}
 	protected PaymentMethod loadPaymentMethod(SearchUserContext userContext, String paymentMethodId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPaymentMethod(paymentMethodId);
		userContext.getChecker().throwExceptionIfHasErrors( PaymentMethodManagerException.class);

 
 		return userContext.getDAOGroup().getPaymentMethodDAO().load(paymentMethodId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, PaymentMethod paymentMethod, Map<String, Object> tokens){
		super.addActions(userContext, paymentMethod, tokens);
		
		addAction(userContext, paymentMethod, tokens,"@create","createPaymentMethod","createPaymentMethod/","main","primary");
		addAction(userContext, paymentMethod, tokens,"@update","updatePaymentMethod","updatePaymentMethod/"+paymentMethod.getId()+"/","main","primary");
		addAction(userContext, paymentMethod, tokens,"@copy","clonePaymentMethod","clonePaymentMethod/"+paymentMethod.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, PaymentMethod paymentMethod, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PaymentMethod createPaymentMethod(SearchUserContext userContext,String name, String number, String line1, String line2, String city, Date expireOn) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPaymentMethod(name);
		userContext.getChecker().checkNumberOfPaymentMethod(number);
		userContext.getChecker().checkLine1OfPaymentMethod(line1);
		userContext.getChecker().checkLine2OfPaymentMethod(line2);
		userContext.getChecker().checkCityOfPaymentMethod(city);
		userContext.getChecker().checkExpireOnOfPaymentMethod(expireOn);
	
		userContext.getChecker().throwExceptionIfHasErrors(PaymentMethodManagerException.class);


		PaymentMethod paymentMethod=createNewPaymentMethod();	

		paymentMethod.setName(name);
		paymentMethod.setNumber(number);
		paymentMethod.setLine1(line1);
		paymentMethod.setLine2(line2);
		paymentMethod.setCity(city);
		paymentMethod.setExpireOn(expireOn);

		paymentMethod = savePaymentMethod(userContext, paymentMethod, emptyOptions());
		
		onNewInstanceCreated(userContext, paymentMethod);
		return paymentMethod;

		
	}
	protected PaymentMethod createNewPaymentMethod() 
	{
		
		return new PaymentMethod();		
	}
	
	protected void checkParamsForUpdatingPaymentMethod(SearchUserContext userContext,String paymentMethodId, int paymentMethodVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPaymentMethod(paymentMethodId);
		userContext.getChecker().checkVersionOfPaymentMethod( paymentMethodVersion);
		

		if(PaymentMethod.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPaymentMethod(parseString(newValueExpr));
		}
		if(PaymentMethod.NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkNumberOfPaymentMethod(parseString(newValueExpr));
		}
		if(PaymentMethod.LINE1_PROPERTY.equals(property)){
			userContext.getChecker().checkLine1OfPaymentMethod(parseString(newValueExpr));
		}
		if(PaymentMethod.LINE2_PROPERTY.equals(property)){
			userContext.getChecker().checkLine2OfPaymentMethod(parseString(newValueExpr));
		}
		if(PaymentMethod.CITY_PROPERTY.equals(property)){
			userContext.getChecker().checkCityOfPaymentMethod(parseString(newValueExpr));
		}
		if(PaymentMethod.EXPIRE_ON_PROPERTY.equals(property)){
			userContext.getChecker().checkExpireOnOfPaymentMethod(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PaymentMethodManagerException.class);
	
		
	}
	
	
	
	public PaymentMethod clone(SearchUserContext userContext, String fromPaymentMethodId) throws Exception{
		
		return userContext.getDAOGroup().getPaymentMethodDAO().clone(fromPaymentMethodId, this.allTokens());
	}
	
	public PaymentMethod internalSavePaymentMethod(SearchUserContext userContext, PaymentMethod paymentMethod) throws Exception 
	{
		return internalSavePaymentMethod(userContext, paymentMethod, allTokens());

	}
	public PaymentMethod internalSavePaymentMethod(SearchUserContext userContext, PaymentMethod paymentMethod, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPaymentMethod(userContext, paymentMethodId, paymentMethodVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(paymentMethod){ 
			//will be good when the paymentMethod loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PaymentMethod.
			
			
			paymentMethod = savePaymentMethod(userContext, paymentMethod, options);
			return paymentMethod;
			
		}

	}
	
	public PaymentMethod updatePaymentMethod(SearchUserContext userContext,String paymentMethodId, int paymentMethodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPaymentMethod(userContext, paymentMethodId, paymentMethodVersion, property, newValueExpr, tokensExpr);
		
		
		
		PaymentMethod paymentMethod = loadPaymentMethod(userContext, paymentMethodId, allTokens());
		if(paymentMethod.getVersion() != paymentMethodVersion){
			String message = "The target version("+paymentMethod.getVersion()+") is not equals to version("+paymentMethodVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(paymentMethod){ 
			//will be good when the paymentMethod loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PaymentMethod.
			
			paymentMethod.changeProperty(property, newValueExpr);
			paymentMethod = savePaymentMethod(userContext, paymentMethod, tokens().done());
			return present(userContext,paymentMethod, mergedAllTokens(tokensExpr));
			//return savePaymentMethod(userContext, paymentMethod, tokens().done());
		}

	}
	
	public PaymentMethod updatePaymentMethodProperty(SearchUserContext userContext,String paymentMethodId, int paymentMethodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPaymentMethod(userContext, paymentMethodId, paymentMethodVersion, property, newValueExpr, tokensExpr);
		
		PaymentMethod paymentMethod = loadPaymentMethod(userContext, paymentMethodId, allTokens());
		if(paymentMethod.getVersion() != paymentMethodVersion){
			String message = "The target version("+paymentMethod.getVersion()+") is not equals to version("+paymentMethodVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(paymentMethod){ 
			//will be good when the paymentMethod loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PaymentMethod.
			
			paymentMethod.changeProperty(property, newValueExpr);
			
			paymentMethod = savePaymentMethod(userContext, paymentMethod, tokens().done());
			return present(userContext,paymentMethod, mergedAllTokens(tokensExpr));
			//return savePaymentMethod(userContext, paymentMethod, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PaymentMethodTokens tokens(){
		return PaymentMethodTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PaymentMethodTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PaymentMethodTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String paymentMethodId, int paymentMethodVersion) throws Exception {
		//deleteInternal(userContext, paymentMethodId, paymentMethodVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String paymentMethodId, int paymentMethodVersion) throws Exception{
			
		userContext.getDAOGroup().getPaymentMethodDAO().delete(paymentMethodId, paymentMethodVersion);
	}
	
	public PaymentMethod forgetByAll(SearchUserContext userContext, String paymentMethodId, int paymentMethodVersion) throws Exception {
		return forgetByAllInternal(userContext, paymentMethodId, paymentMethodVersion);		
	}
	protected PaymentMethod forgetByAllInternal(SearchUserContext userContext,
			String paymentMethodId, int paymentMethodVersion) throws Exception{
			
		return userContext.getDAOGroup().getPaymentMethodDAO().disconnectFromAll(paymentMethodId, paymentMethodVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PaymentMethodManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPaymentMethodDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(SearchUserContext userContext, PaymentMethod newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


