
package com.doublechaintech.search.sku;

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

import com.doublechaintech.search.product.Product;

import com.doublechaintech.search.product.CandidateProduct;







public class SkuManagerImpl extends CustomSearchCheckerManager implements SkuManager {
	
	private static final String SERVICE_TYPE = "Sku";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SkuManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SkuManagerException(message);

	}
	
	

 	protected Sku saveSku(SearchUserContext userContext, Sku sku, String [] tokensExpr) throws Exception{	
 		//return getSkuDAO().save(sku, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSku(userContext, sku, tokens);
 	}
 	
 	protected Sku saveSkuDetail(SearchUserContext userContext, Sku sku) throws Exception{	

 		
 		return saveSku(userContext, sku, allTokens());
 	}
 	
 	public Sku loadSku(SearchUserContext userContext, String skuId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	
 	 public Sku searchSku(SearchUserContext userContext, String skuId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Sku sku = loadSku( userContext, skuId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,sku, tokens);
 	}
 	
 	

 	protected Sku present(SearchUserContext userContext, Sku sku, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,sku,tokens);
		
		
		Sku  skuToPresent = userContext.getDAOGroup().getSkuDAO().present(sku, tokens);
		
		List<BaseEntity> entityListToNaming = skuToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSkuDAO().alias(entityListToNaming);
		
		return  skuToPresent;
		
		
	}
 
 	
 	
 	public Sku loadSkuDetail(SearchUserContext userContext, String skuId) throws Exception{	
 		Sku sku = loadSku( userContext, skuId, allTokens());
 		return present(userContext,sku, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String skuId) throws Exception{	
 		Sku sku = loadSku( userContext, skuId, viewTokens());
 		return present(userContext,sku, allTokens());
		
 	}
 	protected Sku saveSku(SearchUserContext userContext, Sku sku, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSkuDAO().save(sku, tokens);
 	}
 	protected Sku loadSku(SearchUserContext userContext, String skuId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().throwExceptionIfHasErrors( SkuManagerException.class);

 
 		return userContext.getDAOGroup().getSkuDAO().load(skuId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, Sku sku, Map<String, Object> tokens){
		super.addActions(userContext, sku, tokens);
		
		addAction(userContext, sku, tokens,"@create","createSku","createSku/","main","primary");
		addAction(userContext, sku, tokens,"@update","updateSku","updateSku/"+sku.getId()+"/","main","primary");
		addAction(userContext, sku, tokens,"@copy","cloneSku","cloneSku/"+sku.getId()+"/","main","primary");
		
		addAction(userContext, sku, tokens,"sku.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+sku.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, Sku sku, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Sku createSku(SearchUserContext userContext,String displayName, String size, String productId, boolean active, BigDecimal basePrice, String lastUpdateTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkDisplayNameOfSku(displayName);
		userContext.getChecker().checkSizeOfSku(size);
		userContext.getChecker().checkActiveOfSku(active);
		userContext.getChecker().checkBasePriceOfSku(basePrice);
		userContext.getChecker().checkLastUpdateTimeOfSku(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);


		Sku sku=createNewSku();	

		sku.setDisplayName(displayName);
		sku.setSize(size);
			
		Product product = loadProduct(userContext, productId,emptyOptions());
		sku.setProduct(product);
		
		
		sku.setActive(active);
		sku.setBasePrice(basePrice);
		sku.setLastUpdateTime(lastUpdateTime);

		sku = saveSku(userContext, sku, emptyOptions());
		
		onNewInstanceCreated(userContext, sku);
		return sku;

		
	}
	protected Sku createNewSku() 
	{
		
		return new Sku();		
	}
	
	protected void checkParamsForUpdatingSku(SearchUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku( skuVersion);
		

		if(Sku.DISPLAY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkDisplayNameOfSku(parseString(newValueExpr));
		}
		if(Sku.SIZE_PROPERTY.equals(property)){
			userContext.getChecker().checkSizeOfSku(parseString(newValueExpr));
		}		

		
		if(Sku.ACTIVE_PROPERTY.equals(property)){
			userContext.getChecker().checkActiveOfSku(parseBoolean(newValueExpr));
		}
		if(Sku.BASE_PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkBasePriceOfSku(parseBigDecimal(newValueExpr));
		}
		if(Sku.LAST_UPDATE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkLastUpdateTimeOfSku(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
	
		
	}
	
	
	
	public Sku clone(SearchUserContext userContext, String fromSkuId) throws Exception{
		
		return userContext.getDAOGroup().getSkuDAO().clone(fromSkuId, this.allTokens());
	}
	
	public Sku internalSaveSku(SearchUserContext userContext, Sku sku) throws Exception 
	{
		return internalSaveSku(userContext, sku, allTokens());

	}
	public Sku internalSaveSku(SearchUserContext userContext, Sku sku, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			
			sku = saveSku(userContext, sku, options);
			return sku;
			
		}

	}
	
	public Sku updateSku(SearchUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			sku.changeProperty(property, newValueExpr);
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}
	
	public Sku updateSkuProperty(SearchUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSku(userContext, skuId, skuVersion, property, newValueExpr, tokensExpr);
		
		Sku sku = loadSku(userContext, skuId, allTokens());
		if(sku.getVersion() != skuVersion){
			String message = "The target version("+sku.getVersion()+") is not equals to version("+skuVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(sku){ 
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Sku.
			
			sku.changeProperty(property, newValueExpr);
			
			sku = saveSku(userContext, sku, tokens().done());
			return present(userContext,sku, mergedAllTokens(tokensExpr));
			//return saveSku(userContext, sku, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SkuTokens tokens(){
		return SkuTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SkuTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkuTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProduct(SearchUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSku(skuId);
 		userContext.getChecker().checkIdOfProduct(anotherProductId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SkuManagerException.class);
 		
 	}
 	public Sku transferToAnotherProduct(SearchUserContext userContext, String skuId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, skuId,anotherProductId);
 
		Sku sku = loadSku(userContext, skuId, allTokens());	
		synchronized(sku){
			//will be good when the sku loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(userContext, anotherProductId, emptyOptions());		
			sku.updateProduct(product);		
			sku = saveSku(userContext, sku, emptyOptions());
			
			return present(userContext,sku, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProduct requestCandidateProduct(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProduct result = new CandidateProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("displayName");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Product> candidateList = userContext.getDAOGroup().getProductDAO().requestCandidateProductForSku(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Product loadProduct(SearchUserContext userContext, String newProductId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProductDAO().load(newProductId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String skuId, int skuVersion) throws Exception {
		//deleteInternal(userContext, skuId, skuVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String skuId, int skuVersion) throws Exception{
			
		userContext.getDAOGroup().getSkuDAO().delete(skuId, skuVersion);
	}
	
	public Sku forgetByAll(SearchUserContext userContext, String skuId, int skuVersion) throws Exception {
		return forgetByAllInternal(userContext, skuId, skuVersion);		
	}
	protected Sku forgetByAllInternal(SearchUserContext userContext,
			String skuId, int skuVersion) throws Exception{
			
		return userContext.getDAOGroup().getSkuDAO().disconnectFromAll(skuId, skuVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SkuManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSkuDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(SearchUserContext userContext, Sku newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


