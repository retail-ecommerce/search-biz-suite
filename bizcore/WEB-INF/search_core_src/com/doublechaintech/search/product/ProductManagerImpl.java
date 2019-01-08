
package com.doublechaintech.search.product;

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

import com.doublechaintech.search.sku.Sku;
import com.doublechaintech.search.productrecommendation.ProductRecommendation;
import com.doublechaintech.search.levelncategory.LevelNCategory;
import com.doublechaintech.search.brand.Brand;
import com.doublechaintech.search.catalog.Catalog;

import com.doublechaintech.search.levelncategory.CandidateLevelNCategory;
import com.doublechaintech.search.brand.CandidateBrand;
import com.doublechaintech.search.catalog.CandidateCatalog;

import com.doublechaintech.search.product.Product;
import com.doublechaintech.search.brand.Brand;






public class ProductManagerImpl extends CustomSearchCheckerManager implements ProductManager {
	
	private static final String SERVICE_TYPE = "Product";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProductManagerException(message);

	}
	
	

 	protected Product saveProduct(SearchUserContext userContext, Product product, String [] tokensExpr) throws Exception{	
 		//return getProductDAO().save(product, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProduct(userContext, product, tokens);
 	}
 	
 	protected Product saveProductDetail(SearchUserContext userContext, Product product) throws Exception{	

 		
 		return saveProduct(userContext, product, allTokens());
 	}
 	
 	public Product loadProduct(SearchUserContext userContext, String productId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	
 	 public Product searchProduct(SearchUserContext userContext, String productId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Product product = loadProduct( userContext, productId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,product, tokens);
 	}
 	
 	

 	protected Product present(SearchUserContext userContext, Product product, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,product,tokens);
		
		
		Product  productToPresent = userContext.getDAOGroup().getProductDAO().present(product, tokens);
		
		List<BaseEntity> entityListToNaming = productToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProductDAO().alias(entityListToNaming);
		
		return  productToPresent;
		
		
	}
 
 	
 	
 	public Product loadProductDetail(SearchUserContext userContext, String productId) throws Exception{	
 		Product product = loadProduct( userContext, productId, allTokens());
 		return present(userContext,product, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String productId) throws Exception{	
 		Product product = loadProduct( userContext, productId, viewTokens());
 		return present(userContext,product, allTokens());
		
 	}
 	protected Product saveProduct(SearchUserContext userContext, Product product, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProductDAO().save(product, tokens);
 	}
 	protected Product loadProduct(SearchUserContext userContext, String productId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().throwExceptionIfHasErrors( ProductManagerException.class);

 
 		return userContext.getDAOGroup().getProductDAO().load(productId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, Product product, Map<String, Object> tokens){
		super.addActions(userContext, product, tokens);
		
		addAction(userContext, product, tokens,"@create","createProduct","createProduct/","main","primary");
		addAction(userContext, product, tokens,"@update","updateProduct","updateProduct/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"@copy","cloneProduct","cloneProduct/"+product.getId()+"/","main","primary");
		
		addAction(userContext, product, tokens,"product.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.transfer_to_brand","transferToAnotherBrand","transferToAnotherBrand/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.transfer_to_catalog","transferToAnotherCatalog","transferToAnotherCatalog/"+product.getId()+"/","main","primary");
		addAction(userContext, product, tokens,"product.addProductRecommendation","addProductRecommendation","addProductRecommendation/"+product.getId()+"/","productRecommendationList","primary");
		addAction(userContext, product, tokens,"product.removeProductRecommendation","removeProductRecommendation","removeProductRecommendation/"+product.getId()+"/","productRecommendationList","primary");
		addAction(userContext, product, tokens,"product.updateProductRecommendation","updateProductRecommendation","updateProductRecommendation/"+product.getId()+"/","productRecommendationList","primary");
		addAction(userContext, product, tokens,"product.copyProductRecommendationFrom","copyProductRecommendationFrom","copyProductRecommendationFrom/"+product.getId()+"/","productRecommendationList","primary");
		addAction(userContext, product, tokens,"product.addSku","addSku","addSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.removeSku","removeSku","removeSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.updateSku","updateSku","updateSku/"+product.getId()+"/","skuList","primary");
		addAction(userContext, product, tokens,"product.copySkuFrom","copySkuFrom","copySkuFrom/"+product.getId()+"/","skuList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, Product product, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Product createProduct(SearchUserContext userContext,String displayName, String parentCategoryId, String brandId, String origin, String catalogId, String remark, String lastUpdateTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkDisplayNameOfProduct(displayName);
		userContext.getChecker().checkOriginOfProduct(origin);
		userContext.getChecker().checkRemarkOfProduct(remark);
		userContext.getChecker().checkLastUpdateTimeOfProduct(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);


		Product product=createNewProduct();	

		product.setDisplayName(displayName);
			
		LevelNCategory parentCategory = loadLevelNCategory(userContext, parentCategoryId,emptyOptions());
		product.setParentCategory(parentCategory);
		
		
			
		Brand brand = loadBrand(userContext, brandId,emptyOptions());
		product.setBrand(brand);
		
		
		product.setOrigin(origin);
			
		Catalog catalog = loadCatalog(userContext, catalogId,emptyOptions());
		product.setCatalog(catalog);
		
		
		product.setRemark(remark);
		product.setLastUpdateTime(lastUpdateTime);

		product = saveProduct(userContext, product, emptyOptions());
		
		onNewInstanceCreated(userContext, product);
		return product;

		
	}
	protected Product createNewProduct() 
	{
		
		return new Product();		
	}
	
	protected void checkParamsForUpdatingProduct(SearchUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct( productVersion);
		

		if(Product.DISPLAY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkDisplayNameOfProduct(parseString(newValueExpr));
		}		

				

		
		if(Product.ORIGIN_PROPERTY.equals(property)){
			userContext.getChecker().checkOriginOfProduct(parseString(newValueExpr));
		}		

		
		if(Product.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfProduct(parseString(newValueExpr));
		}
		if(Product.LAST_UPDATE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkLastUpdateTimeOfProduct(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
		
	}
	
	
	
	public Product clone(SearchUserContext userContext, String fromProductId) throws Exception{
		
		return userContext.getDAOGroup().getProductDAO().clone(fromProductId, this.allTokens());
	}
	
	public Product internalSaveProduct(SearchUserContext userContext, Product product) throws Exception 
	{
		return internalSaveProduct(userContext, product, allTokens());

	}
	public Product internalSaveProduct(SearchUserContext userContext, Product product, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			
			product = saveProduct(userContext, product, options);
			return product;
			
		}

	}
	
	public Product updateProduct(SearchUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			product.changeProperty(property, newValueExpr);
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	
	public Product updateProductProperty(SearchUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProduct(userContext, productId, productVersion, property, newValueExpr, tokensExpr);
		
		Product product = loadProduct(userContext, productId, allTokens());
		if(product.getVersion() != productVersion){
			String message = "The target version("+product.getVersion()+") is not equals to version("+productVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(product){ 
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Product.
			
			product.changeProperty(property, newValueExpr);
			
			product = saveProduct(userContext, product, tokens().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
			//return saveProduct(userContext, product, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProductTokens tokens(){
		return ProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProductRecommendationListWith("id","desc")
		.sortSkuListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(SearchUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfLevelNCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherParentCategory(SearchUserContext userContext, String productId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, productId,anotherParentCategoryId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelNCategory parentCategory = loadLevelNCategory(userContext, anotherParentCategoryId, emptyOptions());		
			product.updateParentCategory(parentCategory);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelNCategory requestCandidateParentCategory(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelNCategory result = new CandidateLevelNCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("parentCategory");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelNCategory> candidateList = userContext.getDAOGroup().getLevelNCategoryDAO().requestCandidateLevelNCategoryForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBrand(SearchUserContext userContext, String productId, String anotherBrandId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfBrand(anotherBrandId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherBrand(SearchUserContext userContext, String productId, String anotherBrandId) throws Exception
 	{
 		checkParamsForTransferingAnotherBrand(userContext, productId,anotherBrandId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Brand brand = loadBrand(userContext, anotherBrandId, emptyOptions());		
			product.updateBrand(brand);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
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
		SmartList<Brand> candidateList = userContext.getDAOGroup().getBrandDAO().requestCandidateBrandForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCatalog(SearchUserContext userContext, String productId, String anotherCatalogId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProduct(productId);
 		userContext.getChecker().checkIdOfCatalog(anotherCatalogId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
 		
 	}
 	public Product transferToAnotherCatalog(SearchUserContext userContext, String productId, String anotherCatalogId) throws Exception
 	{
 		checkParamsForTransferingAnotherCatalog(userContext, productId,anotherCatalogId);
 
		Product product = loadProduct(userContext, productId, allTokens());	
		synchronized(product){
			//will be good when the product loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Catalog catalog = loadCatalog(userContext, anotherCatalogId, emptyOptions());		
			product.updateCatalog(catalog);		
			product = saveProduct(userContext, product, emptyOptions());
			
			return present(userContext,product, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateCatalog requestCandidateCatalog(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCatalog result = new CandidateCatalog();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("displayName");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Catalog> candidateList = userContext.getDAOGroup().getCatalogDAO().requestCandidateCatalogForProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Catalog loadCatalog(SearchUserContext userContext, String newCatalogId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getCatalogDAO().load(newCatalogId, options);
 	}
 	
 	
 	
	
	 	
 	protected LevelNCategory loadLevelNCategory(SearchUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelNCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	 	
 	protected Brand loadBrand(SearchUserContext userContext, String newBrandId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getBrandDAO().load(newBrandId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String productId, int productVersion) throws Exception {
		//deleteInternal(userContext, productId, productVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String productId, int productVersion) throws Exception{
			
		userContext.getDAOGroup().getProductDAO().delete(productId, productVersion);
	}
	
	public Product forgetByAll(SearchUserContext userContext, String productId, int productVersion) throws Exception {
		return forgetByAllInternal(userContext, productId, productVersion);		
	}
	protected Product forgetByAllInternal(SearchUserContext userContext,
			String productId, int productVersion) throws Exception{
			
		return userContext.getDAOGroup().getProductDAO().disconnectFromAll(productId, productVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProductDAO().deleteAll();
	}


	//disconnect Product with brand in ProductRecommendation
	protected Product breakWithProductRecommendationByBrand(SearchUserContext userContext, String productId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Product product = loadProduct(userContext, productId, allTokens());

			synchronized(product){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProductDAO().planToRemoveProductRecommendationListWithBrand(product, brandId, this.emptyOptions());

				product = saveProduct(userContext, product, tokens().withProductRecommendationList().done());
				return product;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProductRecommendation(SearchUserContext userContext, String productId, String displayName, String brandId, String origin, String remark, String lastUpdateTime,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);

		
		userContext.getChecker().checkDisplayNameOfProductRecommendation(displayName);
		
		userContext.getChecker().checkBrandIdOfProductRecommendation(brandId);
		
		userContext.getChecker().checkOriginOfProductRecommendation(origin);
		
		userContext.getChecker().checkRemarkOfProductRecommendation(remark);
		
		userContext.getChecker().checkLastUpdateTimeOfProductRecommendation(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);

	
	}
	public  Product addProductRecommendation(SearchUserContext userContext, String productId, String displayName, String brandId, String origin, String remark, String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProductRecommendation(userContext,productId,displayName, brandId, origin, remark, lastUpdateTime,tokensExpr);
		
		ProductRecommendation productRecommendation = createProductRecommendation(userContext,displayName, brandId, origin, remark, lastUpdateTime);
		
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addProductRecommendation( productRecommendation );		
			product = saveProduct(userContext, product, tokens().withProductRecommendationList().done());
			
			userContext.getManagerGroup().getProductRecommendationManager().onNewInstanceCreated(userContext, productRecommendation);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductRecommendationProperties(SearchUserContext userContext, String productId,String id,String displayName,String origin,String remark,String lastUpdateTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfProductRecommendation(id);
		
		userContext.getChecker().checkDisplayNameOfProductRecommendation( displayName);
		userContext.getChecker().checkOriginOfProductRecommendation( origin);
		userContext.getChecker().checkRemarkOfProductRecommendation( remark);
		userContext.getChecker().checkLastUpdateTimeOfProductRecommendation( lastUpdateTime);

		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product updateProductRecommendationProperties(SearchUserContext userContext, String productId, String id,String displayName,String origin,String remark,String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductRecommendationProperties(userContext,productId,id,displayName,origin,remark,lastUpdateTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductRecommendationListList()
				.searchProductRecommendationListWith(ProductRecommendation.ID_PROPERTY, "is", id).done();
		
		Product productToUpdate = loadProduct(userContext, productId, options);
		
		if(productToUpdate.getProductRecommendationList().isEmpty()){
			throw new ProductManagerException("ProductRecommendation is NOT FOUND with id: '"+id+"'");
		}
		
		ProductRecommendation item = productToUpdate.getProductRecommendationList().first();
		
		item.updateDisplayName( displayName );
		item.updateOrigin( origin );
		item.updateRemark( remark );
		item.updateLastUpdateTime( lastUpdateTime );

		
		//checkParamsForAddingProductRecommendation(userContext,productId,name, code, used,tokensExpr);
		Product product = saveProduct(userContext, productToUpdate, tokens().withProductRecommendationList().done());
		synchronized(product){ 
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ProductRecommendation createProductRecommendation(SearchUserContext userContext, String displayName, String brandId, String origin, String remark, String lastUpdateTime) throws Exception{

		ProductRecommendation productRecommendation = new ProductRecommendation();
		
		
		productRecommendation.setDisplayName(displayName);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		productRecommendation.setBrand(brand);		
		productRecommendation.setOrigin(origin);		
		productRecommendation.setRemark(remark);		
		productRecommendation.setLastUpdateTime(lastUpdateTime);
	
		
		return productRecommendation;
	
		
	}
	
	protected ProductRecommendation createIndexedProductRecommendation(String id, int version){

		ProductRecommendation productRecommendation = new ProductRecommendation();
		productRecommendation.setId(id);
		productRecommendation.setVersion(version);
		return productRecommendation;			
		
	}
	
	protected void checkParamsForRemovingProductRecommendationList(SearchUserContext userContext, String productId, 
			String productRecommendationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		for(String productRecommendationId: productRecommendationIds){
			userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product removeProductRecommendationList(SearchUserContext userContext, String productId, 
			String productRecommendationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductRecommendationList(userContext, productId,  productRecommendationIds, tokensExpr);
			
			
			Product product = loadProduct(userContext, productId, allTokens());
			synchronized(product){ 
				//Will be good when the product loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProductDAO().planToRemoveProductRecommendationList(product, productRecommendationIds, allTokens());
				product = saveProduct(userContext, product, tokens().withProductRecommendationList().done());
				deleteRelationListInGraph(userContext, product.getProductRecommendationList());
				return present(userContext,product, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProductRecommendation(SearchUserContext userContext, String productId, 
		String productRecommendationId, int productRecommendationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().checkVersionOfProductRecommendation(productRecommendationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product removeProductRecommendation(SearchUserContext userContext, String productId, 
		String productRecommendationId, int productRecommendationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProductRecommendation(userContext,productId, productRecommendationId, productRecommendationVersion,tokensExpr);
		
		ProductRecommendation productRecommendation = createIndexedProductRecommendation(productRecommendationId, productRecommendationVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.removeProductRecommendation( productRecommendation );		
			product = saveProduct(userContext, product, tokens().withProductRecommendationList().done());
			deleteRelationInGraph(userContext, productRecommendation);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProductRecommendation(SearchUserContext userContext, String productId, 
		String productRecommendationId, int productRecommendationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().checkVersionOfProductRecommendation(productRecommendationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product copyProductRecommendationFrom(SearchUserContext userContext, String productId, 
		String productRecommendationId, int productRecommendationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProductRecommendation(userContext,productId, productRecommendationId, productRecommendationVersion,tokensExpr);
		
		ProductRecommendation productRecommendation = createIndexedProductRecommendation(productRecommendationId, productRecommendationVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			product.copyProductRecommendationFrom( productRecommendation );		
			product = saveProduct(userContext, product, tokens().withProductRecommendationList().done());
			
			userContext.getManagerGroup().getProductRecommendationManager().onNewInstanceCreated(userContext, (ProductRecommendation)product.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProductRecommendation(SearchUserContext userContext, String productId, String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().checkVersionOfProductRecommendation(productRecommendationVersion);
		

		if(ProductRecommendation.DISPLAY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkDisplayNameOfProductRecommendation(parseString(newValueExpr));
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	
	public  Product updateProductRecommendation(SearchUserContext userContext, String productId, String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProductRecommendation(userContext, productId, productRecommendationId, productRecommendationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductRecommendationList().searchProductRecommendationListWith(ProductRecommendation.ID_PROPERTY, "eq", productRecommendationId).done();
		
		
		
		Product product = loadProduct(userContext, productId, loadTokens);
		
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeProductRecommendation( productRecommendation );	
			//make changes to AcceleraterAccount.
			ProductRecommendation productRecommendationIndex = createIndexedProductRecommendation(productRecommendationId, productRecommendationVersion);
		
			ProductRecommendation productRecommendation = product.findTheProductRecommendation(productRecommendationIndex);
			if(productRecommendation == null){
				throw new ProductManagerException(productRecommendation+" is NOT FOUND" );
			}
			
			productRecommendation.changeProperty(property, newValueExpr);
			
			product = saveProduct(userContext, product, tokens().withProductRecommendationList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingSku(SearchUserContext userContext, String productId, String displayName, String size, boolean active, BigDecimal basePrice, String lastUpdateTime,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProduct(productId);

		
		userContext.getChecker().checkDisplayNameOfSku(displayName);
		
		userContext.getChecker().checkSizeOfSku(size);
		
		userContext.getChecker().checkActiveOfSku(active);
		
		userContext.getChecker().checkBasePriceOfSku(basePrice);
		
		userContext.getChecker().checkLastUpdateTimeOfSku(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);

	
	}
	public  Product addSku(SearchUserContext userContext, String productId, String displayName, String size, boolean active, BigDecimal basePrice, String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSku(userContext,productId,displayName, size, active, basePrice, lastUpdateTime,tokensExpr);
		
		Sku sku = createSku(userContext,displayName, size, active, basePrice, lastUpdateTime);
		
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.addSku( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			
			userContext.getManagerGroup().getSkuManager().onNewInstanceCreated(userContext, sku);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSkuProperties(SearchUserContext userContext, String productId,String id,String displayName,String size,boolean active,BigDecimal basePrice,String lastUpdateTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfSku(id);
		
		userContext.getChecker().checkDisplayNameOfSku( displayName);
		userContext.getChecker().checkSizeOfSku( size);
		userContext.getChecker().checkActiveOfSku( active);
		userContext.getChecker().checkBasePriceOfSku( basePrice);
		userContext.getChecker().checkLastUpdateTimeOfSku( lastUpdateTime);

		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product updateSkuProperties(SearchUserContext userContext, String productId, String id,String displayName,String size,boolean active,BigDecimal basePrice,String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSkuProperties(userContext,productId,id,displayName,size,active,basePrice,lastUpdateTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSkuListList()
				.searchSkuListWith(Sku.ID_PROPERTY, "is", id).done();
		
		Product productToUpdate = loadProduct(userContext, productId, options);
		
		if(productToUpdate.getSkuList().isEmpty()){
			throw new ProductManagerException("Sku is NOT FOUND with id: '"+id+"'");
		}
		
		Sku item = productToUpdate.getSkuList().first();
		
		item.updateDisplayName( displayName );
		item.updateSize( size );
		item.updateActive( active );
		item.updateBasePrice( basePrice );
		item.updateLastUpdateTime( lastUpdateTime );

		
		//checkParamsForAddingSku(userContext,productId,name, code, used,tokensExpr);
		Product product = saveProduct(userContext, productToUpdate, tokens().withSkuList().done());
		synchronized(product){ 
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Sku createSku(SearchUserContext userContext, String displayName, String size, boolean active, BigDecimal basePrice, String lastUpdateTime) throws Exception{

		Sku sku = new Sku();
		
		
		sku.setDisplayName(displayName);		
		sku.setSize(size);		
		sku.setActive(active);		
		sku.setBasePrice(basePrice);		
		sku.setLastUpdateTime(lastUpdateTime);
	
		
		return sku;
	
		
	}
	
	protected Sku createIndexedSku(String id, int version){

		Sku sku = new Sku();
		sku.setId(id);
		sku.setVersion(version);
		return sku;			
		
	}
	
	protected void checkParamsForRemovingSkuList(SearchUserContext userContext, String productId, 
			String skuIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProduct(productId);
		for(String skuId: skuIds){
			userContext.getChecker().checkIdOfSku(skuId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
		
	}
	public  Product removeSkuList(SearchUserContext userContext, String productId, 
			String skuIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSkuList(userContext, productId,  skuIds, tokensExpr);
			
			
			Product product = loadProduct(userContext, productId, allTokens());
			synchronized(product){ 
				//Will be good when the product loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProductDAO().planToRemoveSkuList(product, skuIds, allTokens());
				product = saveProduct(userContext, product, tokens().withSkuList().done());
				deleteRelationListInGraph(userContext, product.getSkuList());
				return present(userContext,product, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSku(SearchUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product removeSku(SearchUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSku(userContext,productId, skuId, skuVersion,tokensExpr);
		
		Sku sku = createIndexedSku(skuId, skuVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			product.removeSku( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			deleteRelationInGraph(userContext, sku);
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSku(SearchUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProduct( productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	public  Product copySkuFrom(SearchUserContext userContext, String productId, 
		String skuId, int skuVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSku(userContext,productId, skuId, skuVersion,tokensExpr);
		
		Sku sku = createIndexedSku(skuId, skuVersion);
		Product product = loadProduct(userContext, productId, allTokens());
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			product.copySkuFrom( sku );		
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			
			userContext.getManagerGroup().getSkuManager().onNewInstanceCreated(userContext, (Sku)product.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSku(SearchUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkIdOfSku(skuId);
		userContext.getChecker().checkVersionOfSku(skuVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProductManagerException.class);
	
	}
	
	public  Product updateSku(SearchUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSku(userContext, productId, skuId, skuVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSkuList().searchSkuListWith(Sku.ID_PROPERTY, "eq", skuId).done();
		
		
		
		Product product = loadProduct(userContext, productId, loadTokens);
		
		synchronized(product){ 
			//Will be good when the product loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//product.removeSku( sku );	
			//make changes to AcceleraterAccount.
			Sku skuIndex = createIndexedSku(skuId, skuVersion);
		
			Sku sku = product.findTheSku(skuIndex);
			if(sku == null){
				throw new ProductManagerException(sku+" is NOT FOUND" );
			}
			
			sku.changeProperty(property, newValueExpr);
			
			product = saveProduct(userContext, product, tokens().withSkuList().done());
			return present(userContext,product, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(SearchUserContext userContext, Product newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


