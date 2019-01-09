
package com.doublechaintech.search.levelncategory;

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
import com.doublechaintech.search.leveltwocategory.LevelTwoCategory;

import com.doublechaintech.search.leveltwocategory.CandidateLevelTwoCategory;

import com.doublechaintech.search.levelncategory.LevelNCategory;
import com.doublechaintech.search.brand.Brand;
import com.doublechaintech.search.catalog.Catalog;






public class LevelNCategoryManagerImpl extends CustomSearchCheckerManager implements LevelNCategoryManager {
	
	private static final String SERVICE_TYPE = "LevelNCategory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LevelNCategoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LevelNCategoryManagerException(message);

	}
	
	

 	protected LevelNCategory saveLevelNCategory(SearchUserContext userContext, LevelNCategory levelNCategory, String [] tokensExpr) throws Exception{	
 		//return getLevelNCategoryDAO().save(levelNCategory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelNCategory(userContext, levelNCategory, tokens);
 	}
 	
 	protected LevelNCategory saveLevelNCategoryDetail(SearchUserContext userContext, LevelNCategory levelNCategory) throws Exception{	

 		
 		return saveLevelNCategory(userContext, levelNCategory, allTokens());
 	}
 	
 	public LevelNCategory loadLevelNCategory(SearchUserContext userContext, String levelNCategoryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelNCategoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelNCategory levelNCategory = loadLevelNCategory( userContext, levelNCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelNCategory, tokens);
 	}
 	
 	
 	 public LevelNCategory searchLevelNCategory(SearchUserContext userContext, String levelNCategoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelNCategoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelNCategory levelNCategory = loadLevelNCategory( userContext, levelNCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelNCategory, tokens);
 	}
 	
 	

 	protected LevelNCategory present(SearchUserContext userContext, LevelNCategory levelNCategory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelNCategory,tokens);
		
		
		LevelNCategory  levelNCategoryToPresent = userContext.getDAOGroup().getLevelNCategoryDAO().present(levelNCategory, tokens);
		
		List<BaseEntity> entityListToNaming = levelNCategoryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLevelNCategoryDAO().alias(entityListToNaming);
		
		return  levelNCategoryToPresent;
		
		
	}
 
 	
 	
 	public LevelNCategory loadLevelNCategoryDetail(SearchUserContext userContext, String levelNCategoryId) throws Exception{	
 		LevelNCategory levelNCategory = loadLevelNCategory( userContext, levelNCategoryId, allTokens());
 		return present(userContext,levelNCategory, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String levelNCategoryId) throws Exception{	
 		LevelNCategory levelNCategory = loadLevelNCategory( userContext, levelNCategoryId, viewTokens());
 		return present(userContext,levelNCategory, allTokens());
		
 	}
 	protected LevelNCategory saveLevelNCategory(SearchUserContext userContext, LevelNCategory levelNCategory, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLevelNCategoryDAO().save(levelNCategory, tokens);
 	}
 	protected LevelNCategory loadLevelNCategory(SearchUserContext userContext, String levelNCategoryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().throwExceptionIfHasErrors( LevelNCategoryManagerException.class);

 
 		return userContext.getDAOGroup().getLevelNCategoryDAO().load(levelNCategoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, LevelNCategory levelNCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelNCategory, tokens);
		
		addAction(userContext, levelNCategory, tokens,"@create","createLevelNCategory","createLevelNCategory/","main","primary");
		addAction(userContext, levelNCategory, tokens,"@update","updateLevelNCategory","updateLevelNCategory/"+levelNCategory.getId()+"/","main","primary");
		addAction(userContext, levelNCategory, tokens,"@copy","cloneLevelNCategory","cloneLevelNCategory/"+levelNCategory.getId()+"/","main","primary");
		
		addAction(userContext, levelNCategory, tokens,"level_n_category.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+levelNCategory.getId()+"/","main","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.addProduct","addProduct","addProduct/"+levelNCategory.getId()+"/","productList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.removeProduct","removeProduct","removeProduct/"+levelNCategory.getId()+"/","productList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.updateProduct","updateProduct","updateProduct/"+levelNCategory.getId()+"/","productList","primary");
		addAction(userContext, levelNCategory, tokens,"level_n_category.copyProductFrom","copyProductFrom","copyProductFrom/"+levelNCategory.getId()+"/","productList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, LevelNCategory levelNCategory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LevelNCategory createLevelNCategory(SearchUserContext userContext,String parentCategoryId, String name) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfLevelNCategory(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);


		LevelNCategory levelNCategory=createNewLevelNCategory();	

			
		LevelTwoCategory parentCategory = loadLevelTwoCategory(userContext, parentCategoryId,emptyOptions());
		levelNCategory.setParentCategory(parentCategory);
		
		
		levelNCategory.setName(name);

		levelNCategory = saveLevelNCategory(userContext, levelNCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelNCategory);
		return levelNCategory;

		
	}
	protected LevelNCategory createNewLevelNCategory() 
	{
		
		return new LevelNCategory();		
	}
	
	protected void checkParamsForUpdatingLevelNCategory(SearchUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkVersionOfLevelNCategory( levelNCategoryVersion);
		
		

		
		if(LevelNCategory.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfLevelNCategory(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
		
	}
	
	
	
	public LevelNCategory clone(SearchUserContext userContext, String fromLevelNCategoryId) throws Exception{
		
		return userContext.getDAOGroup().getLevelNCategoryDAO().clone(fromLevelNCategoryId, this.allTokens());
	}
	
	public LevelNCategory internalSaveLevelNCategory(SearchUserContext userContext, LevelNCategory levelNCategory) throws Exception 
	{
		return internalSaveLevelNCategory(userContext, levelNCategory, allTokens());

	}
	public LevelNCategory internalSaveLevelNCategory(SearchUserContext userContext, LevelNCategory levelNCategory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLevelNCategory(userContext, levelNCategoryId, levelNCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(levelNCategory){ 
			//will be good when the levelNCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelNCategory.
			
			
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, options);
			return levelNCategory;
			
		}

	}
	
	public LevelNCategory updateLevelNCategory(SearchUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelNCategory(userContext, levelNCategoryId, levelNCategoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		if(levelNCategory.getVersion() != levelNCategoryVersion){
			String message = "The target version("+levelNCategory.getVersion()+") is not equals to version("+levelNCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelNCategory){ 
			//will be good when the levelNCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelNCategory.
			
			levelNCategory.changeProperty(property, newValueExpr);
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			//return saveLevelNCategory(userContext, levelNCategory, tokens().done());
		}

	}
	
	public LevelNCategory updateLevelNCategoryProperty(SearchUserContext userContext,String levelNCategoryId, int levelNCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLevelNCategory(userContext, levelNCategoryId, levelNCategoryVersion, property, newValueExpr, tokensExpr);
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		if(levelNCategory.getVersion() != levelNCategoryVersion){
			String message = "The target version("+levelNCategory.getVersion()+") is not equals to version("+levelNCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelNCategory){ 
			//will be good when the levelNCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelNCategory.
			
			levelNCategory.changeProperty(property, newValueExpr);
			
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			//return saveLevelNCategory(userContext, levelNCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LevelNCategoryTokens tokens(){
		return LevelNCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelNCategoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelNCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(SearchUserContext userContext, String levelNCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
 		userContext.getChecker().checkIdOfLevelTwoCategory(anotherParentCategoryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
 		
 	}
 	public LevelNCategory transferToAnotherParentCategory(SearchUserContext userContext, String levelNCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, levelNCategoryId,anotherParentCategoryId);
 
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());	
		synchronized(levelNCategory){
			//will be good when the levelNCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelTwoCategory parentCategory = loadLevelTwoCategory(userContext, anotherParentCategoryId, emptyOptions());		
			levelNCategory.updateParentCategory(parentCategory);		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, emptyOptions());
			
			return present(userContext,levelNCategory, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateLevelTwoCategory requestCandidateParentCategory(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelTwoCategory result = new CandidateLevelTwoCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("parentCategory");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelTwoCategory> candidateList = userContext.getDAOGroup().getLevelTwoCategoryDAO().requestCandidateLevelTwoCategoryForLevelNCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected LevelTwoCategory loadLevelTwoCategory(SearchUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getLevelTwoCategoryDAO().load(newParentCategoryId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String levelNCategoryId, int levelNCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelNCategoryId, levelNCategoryVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String levelNCategoryId, int levelNCategoryVersion) throws Exception{
			
		userContext.getDAOGroup().getLevelNCategoryDAO().delete(levelNCategoryId, levelNCategoryVersion);
	}
	
	public LevelNCategory forgetByAll(SearchUserContext userContext, String levelNCategoryId, int levelNCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelNCategoryId, levelNCategoryVersion);		
	}
	protected LevelNCategory forgetByAllInternal(SearchUserContext userContext,
			String levelNCategoryId, int levelNCategoryVersion) throws Exception{
			
		return userContext.getDAOGroup().getLevelNCategoryDAO().disconnectFromAll(levelNCategoryId, levelNCategoryVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelNCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLevelNCategoryDAO().deleteAll();
	}


	//disconnect LevelNCategory with brand in Product
	protected LevelNCategory breakWithProductByBrand(SearchUserContext userContext, String levelNCategoryId, String brandId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveProductListWithBrand(levelNCategory, brandId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
				return levelNCategory;
			}
	}
	//disconnect LevelNCategory with catalog in Product
	protected LevelNCategory breakWithProductByCatalog(SearchUserContext userContext, String levelNCategoryId, String catalogId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());

			synchronized(levelNCategory){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveProductListWithCatalog(levelNCategory, catalogId, this.emptyOptions());

				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
				return levelNCategory;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingProduct(SearchUserContext userContext, String levelNCategoryId, String name, String brandId, String origin, String catalogId, String remark, String lastUpdateTime,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);

		
		userContext.getChecker().checkNameOfProduct(name);
		
		userContext.getChecker().checkBrandIdOfProduct(brandId);
		
		userContext.getChecker().checkOriginOfProduct(origin);
		
		userContext.getChecker().checkCatalogIdOfProduct(catalogId);
		
		userContext.getChecker().checkRemarkOfProduct(remark);
		
		userContext.getChecker().checkLastUpdateTimeOfProduct(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);

	
	}
	public  LevelNCategory addProduct(SearchUserContext userContext, String levelNCategoryId, String name, String brandId, String origin, String catalogId, String remark, String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingProduct(userContext,levelNCategoryId,name, brandId, origin, catalogId, remark, lastUpdateTime,tokensExpr);
		
		Product product = createProduct(userContext,name, brandId, origin, catalogId, remark, lastUpdateTime);
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.addProduct( product );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, product);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProductProperties(SearchUserContext userContext, String levelNCategoryId,String id,String name,String origin,String remark,String lastUpdateTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkIdOfProduct(id);
		
		userContext.getChecker().checkNameOfProduct( name);
		userContext.getChecker().checkOriginOfProduct( origin);
		userContext.getChecker().checkRemarkOfProduct( remark);
		userContext.getChecker().checkLastUpdateTimeOfProduct( lastUpdateTime);

		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory updateProductProperties(SearchUserContext userContext, String levelNCategoryId, String id,String name,String origin,String remark,String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingProductProperties(userContext,levelNCategoryId,id,name,origin,remark,lastUpdateTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProductListList()
				.searchProductListWith(Product.ID_PROPERTY, "is", id).done();
		
		LevelNCategory levelNCategoryToUpdate = loadLevelNCategory(userContext, levelNCategoryId, options);
		
		if(levelNCategoryToUpdate.getProductList().isEmpty()){
			throw new LevelNCategoryManagerException("Product is NOT FOUND with id: '"+id+"'");
		}
		
		Product item = levelNCategoryToUpdate.getProductList().first();
		
		item.updateName( name );
		item.updateOrigin( origin );
		item.updateRemark( remark );
		item.updateLastUpdateTime( lastUpdateTime );

		
		//checkParamsForAddingProduct(userContext,levelNCategoryId,name, code, used,tokensExpr);
		LevelNCategory levelNCategory = saveLevelNCategory(userContext, levelNCategoryToUpdate, tokens().withProductList().done());
		synchronized(levelNCategory){ 
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Product createProduct(SearchUserContext userContext, String name, String brandId, String origin, String catalogId, String remark, String lastUpdateTime) throws Exception{

		Product product = new Product();
		
		
		product.setName(name);		
		Brand  brand = new Brand();
		brand.setId(brandId);		
		product.setBrand(brand);		
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
	
	protected void checkParamsForRemovingProductList(SearchUserContext userContext, String levelNCategoryId, 
			String productIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		for(String productId: productIds){
			userContext.getChecker().checkIdOfProduct(productId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
		
	}
	public  LevelNCategory removeProductList(SearchUserContext userContext, String levelNCategoryId, 
			String productIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingProductList(userContext, levelNCategoryId,  productIds, tokensExpr);
			
			
			LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
			synchronized(levelNCategory){ 
				//Will be good when the levelNCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLevelNCategoryDAO().planToRemoveProductList(levelNCategory, productIds, allTokens());
				levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
				deleteRelationListInGraph(userContext, levelNCategory.getProductList());
				return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingProduct(SearchUserContext userContext, String levelNCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory removeProduct(SearchUserContext userContext, String levelNCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingProduct(userContext,levelNCategoryId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelNCategory.removeProduct( product );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
			deleteRelationInGraph(userContext, product);
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingProduct(SearchUserContext userContext, String levelNCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLevelNCategory( levelNCategoryId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	public  LevelNCategory copyProductFrom(SearchUserContext userContext, String levelNCategoryId, 
		String productId, int productVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingProduct(userContext,levelNCategoryId, productId, productVersion,tokensExpr);
		
		Product product = createIndexedProduct(productId, productVersion);
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, allTokens());
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			levelNCategory.copyProductFrom( product );		
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
			
			userContext.getManagerGroup().getProductManager().onNewInstanceCreated(userContext, (Product)levelNCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingProduct(SearchUserContext userContext, String levelNCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLevelNCategory(levelNCategoryId);
		userContext.getChecker().checkIdOfProduct(productId);
		userContext.getChecker().checkVersionOfProduct(productVersion);
		

		if(Product.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProduct(parseString(newValueExpr));
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LevelNCategoryManagerException.class);
	
	}
	
	public  LevelNCategory updateProduct(SearchUserContext userContext, String levelNCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingProduct(userContext, levelNCategoryId, productId, productVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withProductList().searchProductListWith(Product.ID_PROPERTY, "eq", productId).done();
		
		
		
		LevelNCategory levelNCategory = loadLevelNCategory(userContext, levelNCategoryId, loadTokens);
		
		synchronized(levelNCategory){ 
			//Will be good when the levelNCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelNCategory.removeProduct( product );	
			//make changes to AcceleraterAccount.
			Product productIndex = createIndexedProduct(productId, productVersion);
		
			Product product = levelNCategory.findTheProduct(productIndex);
			if(product == null){
				throw new LevelNCategoryManagerException(product+" is NOT FOUND" );
			}
			
			product.changeProperty(property, newValueExpr);
			
			levelNCategory = saveLevelNCategory(userContext, levelNCategory, tokens().withProductList().done());
			return present(userContext,levelNCategory, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(SearchUserContext userContext, LevelNCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


