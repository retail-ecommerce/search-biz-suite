
package com.doublechaintech.search.brand;

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

import com.doublechaintech.search.productrecommendation.ProductRecommendation;
import com.doublechaintech.search.product.Product;


import com.doublechaintech.search.product.Product;
import com.doublechaintech.search.levelncategory.LevelNCategory;
import com.doublechaintech.search.brand.Brand;
import com.doublechaintech.search.catalog.Catalog;






public class BrandManagerImpl extends CustomSearchCheckerManager implements BrandManager {
	
	private static final String SERVICE_TYPE = "Brand";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws BrandManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new BrandManagerException(message);

	}
	
	

 	protected Brand saveBrand(SearchUserContext userContext, Brand brand, String [] tokensExpr) throws Exception{	
 		//return getBrandDAO().save(brand, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveBrand(userContext, brand, tokens);
 	}
 	
 	protected Brand saveBrandDetail(SearchUserContext userContext, Brand brand) throws Exception{	

 		
 		return saveBrand(userContext, brand, allTokens());
 	}
 	
 	public Brand loadBrand(SearchUserContext userContext, String brandId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Brand brand = loadBrand( userContext, brandId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brand, tokens);
 	}
 	
 	
 	 public Brand searchBrand(SearchUserContext userContext, String brandId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Brand brand = loadBrand( userContext, brandId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,brand, tokens);
 	}
 	
 	

 	protected Brand present(SearchUserContext userContext, Brand brand, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,brand,tokens);
		
		
		Brand  brandToPresent = userContext.getDAOGroup().getBrandDAO().present(brand, tokens);
		
		List<BaseEntity> entityListToNaming = brandToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getBrandDAO().alias(entityListToNaming);
		
		return  brandToPresent;
		
		
	}
 
 	
 	
 	public Brand loadBrandDetail(SearchUserContext userContext, String brandId) throws Exception{	
 		Brand brand = loadBrand( userContext, brandId, allTokens());
 		return present(userContext,brand, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String brandId) throws Exception{	
 		Brand brand = loadBrand( userContext, brandId, viewTokens());
 		return present(userContext,brand, allTokens());
		
 	}
 	protected Brand saveBrand(SearchUserContext userContext, Brand brand, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getBrandDAO().save(brand, tokens);
 	}
 	protected Brand loadBrand(SearchUserContext userContext, String brandId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().throwExceptionIfHasErrors( BrandManagerException.class);

 
 		return userContext.getDAOGroup().getBrandDAO().load(brandId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, Brand brand, Map<String, Object> tokens){
		super.addActions(userContext, brand, tokens);
		
		addAction(userContext, brand, tokens,"@create","createBrand","createBrand/","main","primary");
		addAction(userContext, brand, tokens,"@update","updateBrand","updateBrand/"+brand.getId()+"/","main","primary");
		addAction(userContext, brand, tokens,"@copy","cloneBrand","cloneBrand/"+brand.getId()+"/","main","primary");
		
		addAction(userContext, brand, tokens,"brand.addProduct","addProduct","addProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.removeProduct","removeProduct","removeProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.updateProduct","updateProduct","updateProduct/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.copyProductFrom","copyProductFrom","copyProductFrom/"+brand.getId()+"/","productList","primary");
		addAction(userContext, brand, tokens,"brand.addProductRecommendation","addProductRecommendation","addProductRecommendation/"+brand.getId()+"/","productRecommendationList","primary");
		addAction(userContext, brand, tokens,"brand.removeProductRecommendation","removeProductRecommendation","removeProductRecommendation/"+brand.getId()+"/","productRecommendationList","primary");
		addAction(userContext, brand, tokens,"brand.updateProductRecommendation","updateProductRecommendation","updateProductRecommendation/"+brand.getId()+"/","productRecommendationList","primary");
		addAction(userContext, brand, tokens,"brand.copyProductRecommendationFrom","copyProductRecommendationFrom","copyProductRecommendationFrom/"+brand.getId()+"/","productRecommendationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, Brand brand, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Brand createBrand(SearchUserContext userContext,String brandName, String logo, String remark) throws Exception
	{
		
		

		

		userContext.getChecker().checkBrandNameOfBrand(brandName);
		userContext.getChecker().checkLogoOfBrand(logo);
		userContext.getChecker().checkRemarkOfBrand(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);


		Brand brand=createNewBrand();	

		brand.setBrandName(brandName);
		brand.setLogo(logo);
		brand.setRemark(remark);

		brand = saveBrand(userContext, brand, emptyOptions());
		
		onNewInstanceCreated(userContext, brand);
		return brand;

		
	}
	protected Brand createNewBrand() 
	{
		
		return new Brand();		
	}
	
	protected void checkParamsForUpdatingBrand(SearchUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkVersionOfBrand( brandVersion);
		

		if(Brand.BRAND_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkBrandNameOfBrand(parseString(newValueExpr));
		}
		if(Brand.LOGO_PROPERTY.equals(property)){
			userContext.getChecker().checkLogoOfBrand(parseString(newValueExpr));
		}
		if(Brand.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfBrand(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
		
	}
	
	
	
	public Brand clone(SearchUserContext userContext, String fromBrandId) throws Exception{
		
		return userContext.getDAOGroup().getBrandDAO().clone(fromBrandId, this.allTokens());
	}
	
	public Brand internalSaveBrand(SearchUserContext userContext, Brand brand) throws Exception 
	{
		return internalSaveBrand(userContext, brand, allTokens());

	}
	public Brand internalSaveBrand(SearchUserContext userContext, Brand brand, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			
			brand = saveBrand(userContext, brand, options);
			return brand;
			
		}

	}
	
	public Brand updateBrand(SearchUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		if(brand.getVersion() != brandVersion){
			String message = "The target version("+brand.getVersion()+") is not equals to version("+brandVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			brand.changeProperty(property, newValueExpr);
			brand = saveBrand(userContext, brand, tokens().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
			//return saveBrand(userContext, brand, tokens().done());
		}

	}
	
	public Brand updateBrandProperty(SearchUserContext userContext,String brandId, int brandVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingBrand(userContext, brandId, brandVersion, property, newValueExpr, tokensExpr);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		if(brand.getVersion() != brandVersion){
			String message = "The target version("+brand.getVersion()+") is not equals to version("+brandVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(brand){ 
			//will be good when the brand loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Brand.
			
			brand.changeProperty(property, newValueExpr);
			
			brand = saveBrand(userContext, brand, tokens().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
			//return saveBrand(userContext, brand, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected BrandTokens tokens(){
		return BrandTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return BrandTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProductListWith("id","desc")
		.sortProductRecommendationListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return BrandTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String brandId, int brandVersion) throws Exception {
		//deleteInternal(userContext, brandId, brandVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String brandId, int brandVersion) throws Exception{
			
		userContext.getDAOGroup().getBrandDAO().delete(brandId, brandVersion);
	}
	
	public Brand forgetByAll(SearchUserContext userContext, String brandId, int brandVersion) throws Exception {
		return forgetByAllInternal(userContext, brandId, brandVersion);		
	}
	protected Brand forgetByAllInternal(SearchUserContext userContext,
			String brandId, int brandVersion) throws Exception{
			
		return userContext.getDAOGroup().getBrandDAO().disconnectFromAll(brandId, brandVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new BrandManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getBrandDAO().deleteAll();
	}


	//disconnect Brand with parent_category in Product
	protected Brand breakWithProductByParentCategory(SearchUserContext userContext, String brandId, String parentCategoryId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductListWithParentCategory(brand, parentCategoryId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				return brand;
			}
	}
	//disconnect Brand with catalog in Product
	protected Brand breakWithProductByCatalog(SearchUserContext userContext, String brandId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductListWithCatalog(brand, catalogId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				return brand;
			}
	}
	//disconnect Brand with product in ProductRecommendation
	protected Brand breakWithProductRecommendationByProduct(SearchUserContext userContext, String brandId, String productId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Brand brand = loadBrand(userContext, brandId, allTokens());

			synchronized(brand){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductRecommendationListWithProduct(brand, productId, this.emptyOptions());

				brand = saveBrand(userContext, brand, tokens().withProductRecommendationList().done());
				return brand;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProduct(SearchUserContext userContext, String brandId, String displayName, String parentCategoryId, String origin, String catalogId, String remark, String lastUpdateTime,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);

		
		userContext.getChecker().checkDisplayNameOfProduct(displayName);
		
		userContext.getChecker().checkParentCategoryIdOfProduct(parentCategoryId);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
		
		userContext.getChecker().checkLastUpdateTimeOfProduct(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);

	
	}
	public  Brand addProduct(SearchUserContext userContext, String brandId, String displayName, String parentCategoryId, String origin, String catalogId, String remark, String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,brandId,displayName, parentCategoryId, origin, catalogId, remark, lastUpdateTime,tokensExpr);
		
		Product product = createProduct(userContext,displayName, parentCategoryId, origin, catalogId, remark, lastUpdateTime);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.addProduct( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(SearchUserContext userContext, String brandId,String id,String displayName,String origin,String remark,String lastUpdateTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkDisplayNameOfProduct( displayName);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);
		userContext.getChecker().checkLastUpdateTimeOfProduct( lastUpdateTime);

		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand updateProductProperties(SearchUserContext userContext, String brandId, String id,String displayName,String origin,String remark,String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,brandId,id,displayName,origin,remark,lastUpdateTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		Brand brandToUpdate = loadBrand(userContext, brandId, options);
		
		if(brandToUpdate.getProductList().isEmpty()){
			throw new BrandManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = brandToUpdate.getProductList().first();
		
		item.updateDisplayName( displayName );
		item.updateOrigin( origin );
		item.updateRemark( remark );
		item.updateLastUpdateTime( lastUpdateTime );

		
		//checkParamsForAddingProduct(userContext,brandId,name, code, used,tokensExpr);
		Brand brand = saveBrand(userContext, brandToUpdate, tokens().withProductList().done());
		synchronized(brand){ 
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(SearchUserContext userContext, String displayName, String parentCategoryId, String origin, String catalogId, String remark, String lastUpdateTime) throws Exception{

		Product product = new Product();
		
		
		product.setDisplayName(displayName);		
		LevelNCategory  parentCategory = new LevelNCategory();
		parentCategory.setId(parentCategoryId);		
		product.setParentCategory(parentCategory);		
		product.setOrigin(origin);		
		Catalog  catalog = new Catalog();
		catalog.setId(catalogId);		
		product.setCatalog(catalog);		
		product.setRemark(remark);		
		product.setLastUpdateTime(lastUpdateTime);
	
		
		return product;
	
		
	}
	
	protected Product createIndexedProduct(String id, int version){

		Product product = new Product();
		product.setId(id);
		product.setVersion(version);
		return product;			
		
	}
	
	protected void checkParamsForRemovingProductList(SearchUserContext userContext, String brandId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand removeProductList(SearchUserContext userContext, String brandId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, brandId,  productIds, tokensExpr);
			
			
			Brand brand = loadBrand(userContext, brandId, allTokens());
			synchronized(brand){ 
				//Will be good when the brand loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductList(brand, productIds, allTokens());
				brand = saveBrand(userContext, brand, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, brand.getProductList());
				return present(userContext,brand, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(SearchUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand removeProduct(SearchUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,brandId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.removeProduct( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(SearchUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand copyProductFrom(SearchUserContext userContext, String brandId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,brandId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			brand.copyProductFrom( product );		
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)brand.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(SearchUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	
	public  Brand updateProduct(SearchUserContext userContext, String brandId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, brandId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		Brand brand = loadBrand(userContext, brandId, loadTokens);
		
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//brand.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = brand.findTheProduct(productIndex);
			if(product == null){
				throw new BrandManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			
			brand = saveBrand(userContext, brand, tokens().withProductList().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingProductRecommendation(SearchUserContext userContext, String brandId, String displayName, String origin, String productId, String remark, String lastUpdateTime,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfBrand(brandId);

		
		userContext.getChecker().checkDisplayNameOfProductRecommendation(displayName);
		
		userContext.getChecker().checkOriginOfProductRecommendation(origin);
		
		userContext.getChecker().checkProductIdOfProductRecommendation(productId);
		
		userContext.getChecker().checkRemarkOfProductRecommendation(remark);
		
		userContext.getChecker().checkLastUpdateTimeOfProductRecommendation(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);

	
	}
	public  Brand addProductRecommendation(SearchUserContext userContext, String brandId, String displayName, String origin, String productId, String remark, String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProductRecommendation(userContext,brandId,displayName, origin, productId, remark, lastUpdateTime,tokensExpr);
		
		ProductRecommendation productRecommendation = createProductRecommendation(userContext,displayName, origin, productId, remark, lastUpdateTime);
		
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.addProductRecommendation( productRecommendation );		
			brand = saveBrand(userContext, brand, tokens().withProductRecommendationList().done());
			
			userContext.getManagerGroup().getProductRecommendationManager().onNewInstanceCreated(userContext, productRecommendation);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductRecommendationProperties(SearchUserContext userContext, String brandId,String id,String displayName,String origin,String remark,String lastUpdateTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		userContext.getChecker().checkIdOfProductRecommendation(id);
		
		userContext.getChecker().checkDisplayNameOfProductRecommendation( displayName);
		userContext.getChecker().checkOriginOfProductRecommendation( origin);
		userContext.getChecker().checkRemarkOfProductRecommendation( remark);
		userContext.getChecker().checkLastUpdateTimeOfProductRecommendation( lastUpdateTime);

		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand updateProductRecommendationProperties(SearchUserContext userContext, String brandId, String id,String displayName,String origin,String remark,String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductRecommendationProperties(userContext,brandId,id,displayName,origin,remark,lastUpdateTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductRecommendationListList()
				.searchProductRecommendationListWith(ProductRecommendation.ID_PROPERTY, "is", id).done();
		
		Brand brandToUpdate = loadBrand(userContext, brandId, options);
		
		if(brandToUpdate.getProductRecommendationList().isEmpty()){
			throw new BrandManagerException("ProductRecommendation is NOT FOUND with id: '"+id+"'");
		}
		
		ProductRecommendation item = brandToUpdate.getProductRecommendationList().first();
		
		item.updateDisplayName( displayName );
		item.updateOrigin( origin );
		item.updateRemark( remark );
		item.updateLastUpdateTime( lastUpdateTime );

		
		//checkParamsForAddingProductRecommendation(userContext,brandId,name, code, used,tokensExpr);
		Brand brand = saveBrand(userContext, brandToUpdate, tokens().withProductRecommendationList().done());
		synchronized(brand){ 
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ProductRecommendation createProductRecommendation(SearchUserContext userContext, String displayName, String origin, String productId, String remark, String lastUpdateTime) throws Exception{

		ProductRecommendation productRecommendation = new ProductRecommendation();
		
		
		productRecommendation.setDisplayName(displayName);		
		productRecommendation.setOrigin(origin);		
		Product  product = new Product();
		product.setId(productId);		
		productRecommendation.setProduct(product);		
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
	
	protected void checkParamsForRemovingProductRecommendationList(SearchUserContext userContext, String brandId, 
			String productRecommendationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfBrand(brandId);
		for(String productRecommendationId: productRecommendationIds){
			userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
		
	}
	public  Brand removeProductRecommendationList(SearchUserContext userContext, String brandId, 
			String productRecommendationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductRecommendationList(userContext, brandId,  productRecommendationIds, tokensExpr);
			
			
			Brand brand = loadBrand(userContext, brandId, allTokens());
			synchronized(brand){ 
				//Will be good when the brand loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getBrandDAO().planToRemoveProductRecommendationList(brand, productRecommendationIds, allTokens());
				brand = saveBrand(userContext, brand, tokens().withProductRecommendationList().done());
				deleteRelationListInGraph(userContext, brand.getProductRecommendationList());
				return present(userContext,brand, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProductRecommendation(SearchUserContext userContext, String brandId, 
		String productRecommendationId, int productRecommendationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().checkVersionOfProductRecommendation(productRecommendationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand removeProductRecommendation(SearchUserContext userContext, String brandId, 
		String productRecommendationId, int productRecommendationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProductRecommendation(userContext,brandId, productRecommendationId, productRecommendationVersion,tokensExpr);
		
		ProductRecommendation productRecommendation = createIndexedProductRecommendation(productRecommendationId, productRecommendationVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			brand.removeProductRecommendation( productRecommendation );		
			brand = saveBrand(userContext, brand, tokens().withProductRecommendationList().done());
			deleteRelationInGraph(userContext, productRecommendation);
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProductRecommendation(SearchUserContext userContext, String brandId, 
		String productRecommendationId, int productRecommendationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfBrand( brandId);
		userContext.getChecker().checkIdOfProductRecommendation(productRecommendationId);
		userContext.getChecker().checkVersionOfProductRecommendation(productRecommendationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	public  Brand copyProductRecommendationFrom(SearchUserContext userContext, String brandId, 
		String productRecommendationId, int productRecommendationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProductRecommendation(userContext,brandId, productRecommendationId, productRecommendationVersion,tokensExpr);
		
		ProductRecommendation productRecommendation = createIndexedProductRecommendation(productRecommendationId, productRecommendationVersion);
		Brand brand = loadBrand(userContext, brandId, allTokens());
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			brand.copyProductRecommendationFrom( productRecommendation );		
			brand = saveBrand(userContext, brand, tokens().withProductRecommendationList().done());
			
			userContext.getManagerGroup().getProductRecommendationManager().onNewInstanceCreated(userContext, (ProductRecommendation)brand.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProductRecommendation(SearchUserContext userContext, String brandId, String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfBrand(brandId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(BrandManagerException.class);
	
	}
	
	public  Brand updateProductRecommendation(SearchUserContext userContext, String brandId, String productRecommendationId, int productRecommendationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProductRecommendation(userContext, brandId, productRecommendationId, productRecommendationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductRecommendationList().searchProductRecommendationListWith(ProductRecommendation.ID_PROPERTY, "eq", productRecommendationId).done();
		
		
		
		Brand brand = loadBrand(userContext, brandId, loadTokens);
		
		synchronized(brand){ 
			//Will be good when the brand loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//brand.removeProductRecommendation( productRecommendation );	
			//make changes to AcceleraterAccount.
			ProductRecommendation productRecommendationIndex = createIndexedProductRecommendation(productRecommendationId, productRecommendationVersion);
		
			ProductRecommendation productRecommendation = brand.findTheProductRecommendation(productRecommendationIndex);
			if(productRecommendation == null){
				throw new BrandManagerException(productRecommendation+" is NOT FOUND" );
			}
			
			productRecommendation.changeProperty(property, newValueExpr);
			
			brand = saveBrand(userContext, brand, tokens().withProductRecommendationList().done());
			return present(userContext,brand, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(SearchUserContext userContext, Brand newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


