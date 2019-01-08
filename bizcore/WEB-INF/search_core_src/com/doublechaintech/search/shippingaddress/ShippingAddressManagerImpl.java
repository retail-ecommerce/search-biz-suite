
package com.doublechaintech.search.shippingaddress;

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









public class ShippingAddressManagerImpl extends CustomSearchCheckerManager implements ShippingAddressManager {
	
	private static final String SERVICE_TYPE = "ShippingAddress";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ShippingAddressManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ShippingAddressManagerException(message);

	}
	
	

 	protected ShippingAddress saveShippingAddress(SearchUserContext userContext, ShippingAddress shippingAddress, String [] tokensExpr) throws Exception{	
 		//return getShippingAddressDAO().save(shippingAddress, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveShippingAddress(userContext, shippingAddress, tokens);
 	}
 	
 	protected ShippingAddress saveShippingAddressDetail(SearchUserContext userContext, ShippingAddress shippingAddress) throws Exception{	

 		
 		return saveShippingAddress(userContext, shippingAddress, allTokens());
 	}
 	
 	public ShippingAddress loadShippingAddress(SearchUserContext userContext, String shippingAddressId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingAddressManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ShippingAddress shippingAddress = loadShippingAddress( userContext, shippingAddressId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingAddress, tokens);
 	}
 	
 	
 	 public ShippingAddress searchShippingAddress(SearchUserContext userContext, String shippingAddressId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingAddressManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ShippingAddress shippingAddress = loadShippingAddress( userContext, shippingAddressId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,shippingAddress, tokens);
 	}
 	
 	

 	protected ShippingAddress present(SearchUserContext userContext, ShippingAddress shippingAddress, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,shippingAddress,tokens);
		
		
		ShippingAddress  shippingAddressToPresent = userContext.getDAOGroup().getShippingAddressDAO().present(shippingAddress, tokens);
		
		List<BaseEntity> entityListToNaming = shippingAddressToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getShippingAddressDAO().alias(entityListToNaming);
		
		return  shippingAddressToPresent;
		
		
	}
 
 	
 	
 	public ShippingAddress loadShippingAddressDetail(SearchUserContext userContext, String shippingAddressId) throws Exception{	
 		ShippingAddress shippingAddress = loadShippingAddress( userContext, shippingAddressId, allTokens());
 		return present(userContext,shippingAddress, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String shippingAddressId) throws Exception{	
 		ShippingAddress shippingAddress = loadShippingAddress( userContext, shippingAddressId, viewTokens());
 		return present(userContext,shippingAddress, allTokens());
		
 	}
 	protected ShippingAddress saveShippingAddress(SearchUserContext userContext, ShippingAddress shippingAddress, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getShippingAddressDAO().save(shippingAddress, tokens);
 	}
 	protected ShippingAddress loadShippingAddress(SearchUserContext userContext, String shippingAddressId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().throwExceptionIfHasErrors( ShippingAddressManagerException.class);

 
 		return userContext.getDAOGroup().getShippingAddressDAO().load(shippingAddressId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, ShippingAddress shippingAddress, Map<String, Object> tokens){
		super.addActions(userContext, shippingAddress, tokens);
		
		addAction(userContext, shippingAddress, tokens,"@create","createShippingAddress","createShippingAddress/","main","primary");
		addAction(userContext, shippingAddress, tokens,"@update","updateShippingAddress","updateShippingAddress/"+shippingAddress.getId()+"/","main","primary");
		addAction(userContext, shippingAddress, tokens,"@copy","cloneShippingAddress","cloneShippingAddress/"+shippingAddress.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, ShippingAddress shippingAddress, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ShippingAddress createShippingAddress(SearchUserContext userContext,String name, String line1, String line2, String city, String state, int zipCode) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfShippingAddress(name);
		userContext.getChecker().checkLine1OfShippingAddress(line1);
		userContext.getChecker().checkLine2OfShippingAddress(line2);
		userContext.getChecker().checkCityOfShippingAddress(city);
		userContext.getChecker().checkStateOfShippingAddress(state);
		userContext.getChecker().checkZipCodeOfShippingAddress(zipCode);
	
		userContext.getChecker().throwExceptionIfHasErrors(ShippingAddressManagerException.class);


		ShippingAddress shippingAddress=createNewShippingAddress();	

		shippingAddress.setName(name);
		shippingAddress.setLine1(line1);
		shippingAddress.setLine2(line2);
		shippingAddress.setCity(city);
		shippingAddress.setState(state);
		shippingAddress.setZipCode(zipCode);

		shippingAddress = saveShippingAddress(userContext, shippingAddress, emptyOptions());
		
		onNewInstanceCreated(userContext, shippingAddress);
		return shippingAddress;

		
	}
	protected ShippingAddress createNewShippingAddress() 
	{
		
		return new ShippingAddress();		
	}
	
	protected void checkParamsForUpdatingShippingAddress(SearchUserContext userContext,String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfShippingAddress(shippingAddressId);
		userContext.getChecker().checkVersionOfShippingAddress( shippingAddressVersion);
		

		if(ShippingAddress.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.LINE1_PROPERTY.equals(property)){
			userContext.getChecker().checkLine1OfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.LINE2_PROPERTY.equals(property)){
			userContext.getChecker().checkLine2OfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.CITY_PROPERTY.equals(property)){
			userContext.getChecker().checkCityOfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.STATE_PROPERTY.equals(property)){
			userContext.getChecker().checkStateOfShippingAddress(parseString(newValueExpr));
		}
		if(ShippingAddress.ZIP_CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkZipCodeOfShippingAddress(parseInt(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ShippingAddressManagerException.class);
	
		
	}
	
	
	
	public ShippingAddress clone(SearchUserContext userContext, String fromShippingAddressId) throws Exception{
		
		return userContext.getDAOGroup().getShippingAddressDAO().clone(fromShippingAddressId, this.allTokens());
	}
	
	public ShippingAddress internalSaveShippingAddress(SearchUserContext userContext, ShippingAddress shippingAddress) throws Exception 
	{
		return internalSaveShippingAddress(userContext, shippingAddress, allTokens());

	}
	public ShippingAddress internalSaveShippingAddress(SearchUserContext userContext, ShippingAddress shippingAddress, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingShippingAddress(userContext, shippingAddressId, shippingAddressVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(shippingAddress){ 
			//will be good when the shippingAddress loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingAddress.
			
			
			shippingAddress = saveShippingAddress(userContext, shippingAddress, options);
			return shippingAddress;
			
		}

	}
	
	public ShippingAddress updateShippingAddress(SearchUserContext userContext,String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingShippingAddress(userContext, shippingAddressId, shippingAddressVersion, property, newValueExpr, tokensExpr);
		
		
		
		ShippingAddress shippingAddress = loadShippingAddress(userContext, shippingAddressId, allTokens());
		if(shippingAddress.getVersion() != shippingAddressVersion){
			String message = "The target version("+shippingAddress.getVersion()+") is not equals to version("+shippingAddressVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(shippingAddress){ 
			//will be good when the shippingAddress loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingAddress.
			
			shippingAddress.changeProperty(property, newValueExpr);
			shippingAddress = saveShippingAddress(userContext, shippingAddress, tokens().done());
			return present(userContext,shippingAddress, mergedAllTokens(tokensExpr));
			//return saveShippingAddress(userContext, shippingAddress, tokens().done());
		}

	}
	
	public ShippingAddress updateShippingAddressProperty(SearchUserContext userContext,String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingShippingAddress(userContext, shippingAddressId, shippingAddressVersion, property, newValueExpr, tokensExpr);
		
		ShippingAddress shippingAddress = loadShippingAddress(userContext, shippingAddressId, allTokens());
		if(shippingAddress.getVersion() != shippingAddressVersion){
			String message = "The target version("+shippingAddress.getVersion()+") is not equals to version("+shippingAddressVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(shippingAddress){ 
			//will be good when the shippingAddress loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ShippingAddress.
			
			shippingAddress.changeProperty(property, newValueExpr);
			
			shippingAddress = saveShippingAddress(userContext, shippingAddress, tokens().done());
			return present(userContext,shippingAddress, mergedAllTokens(tokensExpr));
			//return saveShippingAddress(userContext, shippingAddress, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ShippingAddressTokens tokens(){
		return ShippingAddressTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ShippingAddressTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ShippingAddressTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String shippingAddressId, int shippingAddressVersion) throws Exception {
		//deleteInternal(userContext, shippingAddressId, shippingAddressVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String shippingAddressId, int shippingAddressVersion) throws Exception{
			
		userContext.getDAOGroup().getShippingAddressDAO().delete(shippingAddressId, shippingAddressVersion);
	}
	
	public ShippingAddress forgetByAll(SearchUserContext userContext, String shippingAddressId, int shippingAddressVersion) throws Exception {
		return forgetByAllInternal(userContext, shippingAddressId, shippingAddressVersion);		
	}
	protected ShippingAddress forgetByAllInternal(SearchUserContext userContext,
			String shippingAddressId, int shippingAddressVersion) throws Exception{
			
		return userContext.getDAOGroup().getShippingAddressDAO().disconnectFromAll(shippingAddressId, shippingAddressVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ShippingAddressManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getShippingAddressDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(SearchUserContext userContext, ShippingAddress newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


