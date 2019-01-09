
package com.doublechaintech.search.productrecommendation;

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
import com.doublechaintech.search.brand.Brand;

import com.doublechaintech.search.product.CandidateProduct;
import com.doublechaintech.search.brand.CandidateBrand;







public class ProductRecommendationManagerImpl extends CustomSearchCheckerManager implements ProductRecommendationManager {
	
	private static final String SERVICE_TYPE = "ProductRecommendation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProductRecommendationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProductRecommendationManagerException(message);

	}
	
	

 	protected ProductRecommendation saveProductRecommendation(SearchUserContext userContext, ProductRecommendation productRecommendation, String [] tokensExpr) throws Exception{	
 		//return getProductRecommendationDAO().save(productRecommendation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProductRecommendation(userContext, productRecommendation, tokens);
 	}
 	
 	protected ProductRecommendation saveProductRecommendationDetail(SearchUserContext userContext, ProductRecommendation productRecommendation) throws Exception{	

 		
 		return saveProductRecommendation(userContext, productRecommendation, allTokens());
 	}
 	
 	public ProductRecommendation loadProductRecommendation(SearchUserContext userContext, String productRecommendationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductRecommendationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProductRecommendation productRecommendation = loadProductRecommendation( userContext, productRecommendationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,productRecommendation, tokens);
 	}
 	
 	
 	 public ProductRecommendation searchProductRecommendation(SearchUserContext userContext, String productRecommendationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductRecommendationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ProductRecommendation productRecommendation = loadProductRecommendation( userContext, productRecommendationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,productRecommendation, tokens);
 	}
 	
 	

 	protected ProductRecommendation present(SearchUserContext userContext, ProductRecommendation productRecommendation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,productRecommendation,tokens);
		
		
		ProductRecommendation  productRecommendationToPresent = userContext.getDAOGroup().getProductRecommendationDAO().present(productRecommendation, tokens);
		
		List<BaseEntity> entityListToNaming = productRecommendationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProductRecommendationDAO().alias(entityListToNaming);
		
		return  productRecommendationToPresent;
		
		
	}
 
 	
 	
 	public ProductRecommendation loadProductRecommendationDetail(SearchUserContext userContext, String productRecommendationId) throws Exception{	
 		ProductRecommendation productRecommendation = loadProductRecommendation( userContext, productRecommendationId, allTokens());
 		return present(userContext,productRecommendation, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String productRecommendationId) throws Exception{	
 		ProductRecommendation productRecommendation = loadProductRecommendation( userContext, productRecommendationId, viewTokens());
 		return present(userContext,productRecommendation, allTokens());
		
 	}
 	protected ProductRecommendation saveProductRecommendation(SearchUserContext userContext, ProductRecommendation productRecommendation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProductRecommendationDAO().save(productRecommendation, tokens);
 	}
 	protected ProductRecommendation loadProductRecommendation(SearchUserContext userContext, String productRecommendationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductRecommendationManagerException.class);

 
 		return userContext.getDAOGroup().getProductRecommendationDAO().load(productRecommendationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, ProductRecommendation productRecommendation, Map<String, Object> tokens){
		super.addActions(userContext, productRecommendation, tokens);
		
		addAction(userContext, productRecommendation, tokens,"@create","createProductRecommendation","createProductRecommendation/","main","primary");
		addAction(userContext, productRecommendation, tokens,"@update","updateProductRecommendation","updateProductRecommendation/"+productRecommendation.getId()+"/","main","primary");
		addAction(userContext, productRecommendation, tokens,"@copy","cloneProductRecommendation","cloneProductRecommendation/"+productRecommendation.getId()+"/","main","primary");
		
		addAction(userContext, productRecommendation, tokens,"product_recommendation.transfer_to_brand","transferToAnotherBrand","transferToAnotherBrand/"+productRecommendation.getId()+"/","main","primary");
		addAction(userContext, productRecommendation, tokens,"product_recommendation.transfer_to_product","transferToAnotherProduct","transferToAnotherProduct/"+productRecommendation.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, ProductRecommendation productRecommendation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ProductRecommendation createProductRecommendation(SearchUserContext userContext,String name, String brandId, String origin, String productId, String remark, String lastUpdateTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProductRecommendation(name);
		userContext.getChecker().checkOriginOfProductRecommendation(origin);
		userContext.getChecker().checkRemarkOfProductRecommendation(remark);
		userContext.getChecker().checkLastUpdateTimeOfProductRecommendation(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductRecommendationManagerException.class);


		ProductRecommendation productRecommendation=createNewProductRecommendation();	

		productRecommendation.setName(name);
			
		Brand brand = loadBrand(userContext, brandId,emptyOptions());
		productRecommendation.setBrand(brand);
		
		
		productRecommendation.setOrigin(origin);
			
		Product product = loadProduct(userContext, productId,emptyOptions());
		productRecommendation.setProduct(product);
		
		
		productRecommendation.setRemark(remark);
		productRecommendation.setLastUpdateTime(lastUpdateTime);

		productRecommendation = saveProductRecommendation(userContext, productRecommendation, emptyOptions());
		
		onNewInstanceCreated(userContext, productRecommendation);
		return productRecommendation;

		
	}
	protected ProductRecommendation createNewProductRecommendation() 
	{
		
		return new ProductRecommendation();		
	}
	
	protected void checkParamsForUpdatingProductRecommendation(SearchUserContext userContext,String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().checkVersionOfProductRecommendation( productRecommendationVersion);
		

		if(ProductRecommendation.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProductRecommendation(parseString(newValueExpr));
		}		

		
		if(ProductRecommendation.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfProductRecommendation(parseString(newValueExpr));
		}		

		
		if(ProductRecommendation.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfProductRecommendation(parseString(newValueExpr));
		}
		if(ProductRecommendation.LAST_UPDATE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkLastUpdateTimeOfProductRecommendation(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductRecommendationManagerException.class);
	
		
	}
	
	
	
	public ProductRecommendation clone(SearchUserContext userContext, String fromProductRecommendationId) throws Exception{
		
		return userContext.getDAOGroup().getProductRecommendationDAO().clone(fromProductRecommendationId, this.allTokens());
	}
	
	public ProductRecommendation internalSaveProductRecommendation(SearchUserContext userContext, ProductRecommendation productRecommendation) throws Exception 
	{
		return internalSaveProductRecommendation(userContext, productRecommendation, allTokens());

	}
	public ProductRecommendation internalSaveProductRecommendation(SearchUserContext userContext, ProductRecommendation productRecommendation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProductRecommendation(userContext, productRecommendationId, productRecommendationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(productRecommendation){ 
			//will be good when the productRecommendation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductRecommendation.
			
			
			productRecommendation = saveProductRecommendation(userContext, productRecommendation, options);
			return productRecommendation;
			
		}

	}
	
	public ProductRecommendation updateProductRecommendation(SearchUserContext userContext,String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProductRecommendation(userContext, productRecommendationId, productRecommendationVersion, property, newValueExpr, tokensExpr);
		
		
		
		ProductRecommendation productRecommendation = loadProductRecommendation(userContext, productRecommendationId, allTokens());
		if(productRecommendation.getVersion() != productRecommendationVersion){
			String message = "The target version("+productRecommendation.getVersion()+") is not equals to version("+productRecommendationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(productRecommendation){ 
			//will be good when the productRecommendation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductRecommendation.
			
			productRecommendation.changeProperty(property, newValueExpr);
			productRecommendation = saveProductRecommendation(userContext, productRecommendation, tokens().done());
			return present(userContext,productRecommendation, mergedAllTokens(tokensExpr));
			//return saveProductRecommendation(userContext, productRecommendation, tokens().done());
		}

	}
	
	public ProductRecommendation updateProductRecommendationProperty(SearchUserContext userContext,String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProductRecommendation(userContext, productRecommendationId, productRecommendationVersion, property, newValueExpr, tokensExpr);
		
		ProductRecommendation productRecommendation = loadProductRecommendation(userContext, productRecommendationId, allTokens());
		if(productRecommendation.getVersion() != productRecommendationVersion){
			String message = "The target version("+productRecommendation.getVersion()+") is not equals to version("+productRecommendationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(productRecommendation){ 
			//will be good when the productRecommendation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProductRecommendation.
			
			productRecommendation.changeProperty(property, newValueExpr);
			
			productRecommendation = saveProductRecommendation(userContext, productRecommendation, tokens().done());
			return present(userContext,productRecommendation, mergedAllTokens(tokensExpr));
			//return saveProductRecommendation(userContext, productRecommendation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProductRecommendationTokens tokens(){
		return ProductRecommendationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductRecommendationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductRecommendationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBrand(SearchUserContext userContext, String productRecommendationId, String anotherBrandId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
 		userContext.getChecker().checkIdOfBrand(anotherBrandId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductRecommendationManagerException.class);
 		
 	}
 	public ProductRecommendation transferToAnotherBrand(SearchUserContext userContext, String productRecommendationId, String anotherBrandId) throws Exception
 	{
 		checkParamsForTransferingAnotherBrand(userContext, productRecommendationId,anotherBrandId);
 
		ProductRecommendation productRecommendation = loadProductRecommendation(userContext, productRecommendationId, allTokens());	
		synchronized(productRecommendation){
			//will be good when the productRecommendation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Brand brand = loadBrand(userContext, anotherBrandId, emptyOptions());		
			productRecommendation.updateBrand(brand);		
			productRecommendation = saveProductRecommendation(userContext, productRecommendation, emptyOptions());
			
			return present(userContext,productRecommendation, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateBrand requestCandidateBrand(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateBrand result = new CandidateBrand();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("brandName");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Brand> candidateList = userContext.getDAOGroup().getBrandDAO().requestCandidateBrandForProductRecommendation(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherProduct(SearchUserContext userContext, String productRecommendationId, String anotherProductId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
 		userContext.getChecker().checkIdOfProduct(anotherProductId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductRecommendationManagerException.class);
 		
 	}
 	public ProductRecommendation transferToAnotherProduct(SearchUserContext userContext, String productRecommendationId, String anotherProductId) throws Exception
 	{
 		checkParamsForTransferingAnotherProduct(userContext, productRecommendationId,anotherProductId);
 
		ProductRecommendation productRecommendation = loadProductRecommendation(userContext, productRecommendationId, allTokens());	
		synchronized(productRecommendation){
			//will be good when the productRecommendation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Product product = loadProduct(userContext, anotherProductId, emptyOptions());		
			productRecommendation.updateProduct(product);		
			productRecommendation = saveProductRecommendation(userContext, productRecommendation, emptyOptions());
			
			return present(userContext,productRecommendation, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProduct requestCandidateProduct(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProduct result = new CandidateProduct();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Product> candidateList = userContext.getDAOGroup().getProductDAO().requestCandidateProductForProductRecommendation(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	 	
 	protected Brand loadBrand(SearchUserContext userContext, String newBrandId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getBrandDAO().load(newBrandId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String productRecommendationId, int productRecommendationVersion) throws Exception {
		//deleteInternal(userContext, productRecommendationId, productRecommendationVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String productRecommendationId, int productRecommendationVersion) throws Exception{
			
		userContext.getDAOGroup().getProductRecommendationDAO().delete(productRecommendationId, productRecommendationVersion);
	}
	
	public ProductRecommendation forgetByAll(SearchUserContext userContext, String productRecommendationId, int productRecommendationVersion) throws Exception {
		return forgetByAllInternal(userContext, productRecommendationId, productRecommendationVersion);		
	}
	protected ProductRecommendation forgetByAllInternal(SearchUserContext userContext,
			String productRecommendationId, int productRecommendationVersion) throws Exception{
			
		return userContext.getDAOGroup().getProductRecommendationDAO().disconnectFromAll(productRecommendationId, productRecommendationVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductRecommendationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProductRecommendationDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(SearchUserContext userContext, ProductRecommendation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


