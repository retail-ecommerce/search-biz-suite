
package com.doublechaintech.search.levelncategory;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.search.SearchNamingServiceDAO;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.AccessKey;
import com.doublechaintech.search.DateKey;
import com.doublechaintech.search.StatsInfo;
import com.doublechaintech.search.StatsItem;

import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;


import com.doublechaintech.search.product.Product;
import com.doublechaintech.search.leveltwocategory.LevelTwoCategory;

import com.doublechaintech.search.product.ProductDAO;
import com.doublechaintech.search.leveltwocategory.LevelTwoCategoryDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class LevelNCategoryJDBCTemplateDAO extends SearchNamingServiceDAO implements LevelNCategoryDAO{
 
 	
 	private  LevelTwoCategoryDAO  levelTwoCategoryDAO;
 	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO levelTwoCategoryDAO){
	 	this.levelTwoCategoryDAO = levelTwoCategoryDAO;
 	}
 	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
	 	return this.levelTwoCategoryDAO;
 	}


			
		
	
  	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO pProductDAO){
 	
 		if(pProductDAO == null){
 			throw new IllegalStateException("Do not try to set productDAO to null.");
 		}
	 	this.productDAO = pProductDAO;
 	}
 	public ProductDAO getProductDAO(){
 		if(this.productDAO == null){
 			throw new IllegalStateException("The productDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productDAO;
 	}	
 	
			
		

	
	/*
	protected LevelNCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelNCategory(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LevelNCategory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelNCategory(LevelNCategoryTable.withId(id), options);
	}
	
	
	
	public LevelNCategory save(LevelNCategory levelNCategory,Map<String,Object> options){
		
		String methodName="save(LevelNCategory levelNCategory,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelNCategory, methodName, "levelNCategory");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelNCategory(levelNCategory,options);
	}
	public LevelNCategory clone(String levelNCategoryId, Map<String,Object> options) throws Exception{
	
		return clone(LevelNCategoryTable.withId(levelNCategoryId),options);
	}
	
	protected LevelNCategory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelNCategoryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelNCategory newLevelNCategory = loadInternalLevelNCategory(accessKey, options);
		newLevelNCategory.setVersion(0);
		
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newLevelNCategory.getProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelNCategory(newLevelNCategory,options);
		
		return newLevelNCategory;
	}
	
	
	
	

	protected void throwIfHasException(String levelNCategoryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LevelNCategoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelNCategoryNotFoundException(
					"The " + this.getTableName() + "(" + levelNCategoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String levelNCategoryId, int version) throws Exception{
	
		String methodName="delete(String levelNCategoryId, int version)";
		assertMethodArgumentNotNull(levelNCategoryId, methodName, "levelNCategoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelNCategoryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelNCategoryId,version);
		}
		
	
	}
	
	
	
	
	

	public LevelNCategory disconnectFromAll(String levelNCategoryId, int version) throws Exception{
	
		
		LevelNCategory levelNCategory = loadInternalLevelNCategory(LevelNCategoryTable.withId(levelNCategoryId), emptyOptions());
		levelNCategory.clearFromAll();
		this.saveLevelNCategory(levelNCategory);
		return levelNCategory;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LevelNCategoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_n_category";
	}
	@Override
	protected String getBeanName() {
		
		return "levelNCategory";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelNCategoryTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelNCategoryTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelNCategoryTokens.PARENTCATEGORY);
 	}
 	

 	
 
		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelNCategoryTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,LevelNCategoryTokens.PRODUCT_LIST+".analyze");
 	}
	
	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelNCategoryTokens.PRODUCT_LIST);
		
 	}
 	
		

	

	protected LevelNCategoryMapper getLevelNCategoryMapper(){
		return new LevelNCategoryMapper();
	}

	
	
	protected LevelNCategory extractLevelNCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LevelNCategory levelNCategory = loadSingleObject(accessKey, getLevelNCategoryMapper());
			return levelNCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelNCategoryNotFoundException("LevelNCategory("+accessKey+") is not found!");
		}

	}

	
	

	protected LevelNCategory loadInternalLevelNCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelNCategory levelNCategory = extractLevelNCategory(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(levelNCategory, loadOptions);
 		}
 
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(levelNCategory, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		analyzeProductList(levelNCategory, loadOptions);
 		}
 		
		
		return levelNCategory;
		
	}

	 

 	protected LevelNCategory extractParentCategory(LevelNCategory levelNCategory, Map<String,Object> options) throws Exception{

		if(levelNCategory.getParentCategory() == null){
			return levelNCategory;
		}
		String parentCategoryId = levelNCategory.getParentCategory().getId();
		if( parentCategoryId == null){
			return levelNCategory;
		}
		LevelTwoCategory parentCategory = getLevelTwoCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			levelNCategory.setParentCategory(parentCategory);
		}
		
 		
 		return levelNCategory;
 	}
 		
 
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelNCategory extractProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByParentCategory(levelNCategory.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			levelNCategory.setProductList(productList);
		}
		
		return levelNCategory;
	
	}	
	
	protected LevelNCategory analyzeProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		if(levelNCategory == null){
			return null;
		}
		if(levelNCategory.getId() == null){
			return levelNCategory;
		}

		
		
		SmartList<Product> productList = levelNCategory.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByParentCategory(productList, levelNCategory.getId(), options);
			
		}
		
		return levelNCategory;
	
	}	
	
		
		
  	
 	public SmartList<LevelNCategory> findLevelNCategoryByParentCategory(String levelTwoCategoryId,Map<String,Object> options){
 	
  		SmartList<LevelNCategory> resultList = queryWith(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, levelTwoCategoryId, options, getLevelNCategoryMapper());
		// analyzeLevelNCategoryByParentCategory(resultList, levelTwoCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LevelNCategory> findLevelNCategoryByParentCategory(String levelTwoCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LevelNCategory> resultList =  queryWithRange(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, levelTwoCategoryId, options, getLevelNCategoryMapper(), start, count);
 		//analyzeLevelNCategoryByParentCategory(resultList, levelTwoCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeLevelNCategoryByParentCategory(SmartList<LevelNCategory> resultList, String levelTwoCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLevelNCategoryByParentCategory(String levelTwoCategoryId,Map<String,Object> options){

 		return countWith(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, levelTwoCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countLevelNCategoryByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
 	
		
		
		

	

	protected LevelNCategory saveLevelNCategory(LevelNCategory  levelNCategory){
		
		if(!levelNCategory.isChanged()){
			return levelNCategory;
		}
		
		
		String SQL=this.getSaveLevelNCategorySQL(levelNCategory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelNCategoryParameters(levelNCategory);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelNCategory.incVersion();
		return levelNCategory;
	
	}
	public SmartList<LevelNCategory> saveLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelNCategoryList(levelNCategoryList);
		
		batchLevelNCategoryCreate((List<LevelNCategory>)lists[CREATE_LIST_INDEX]);
		
		batchLevelNCategoryUpdate((List<LevelNCategory>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelNCategory levelNCategory:levelNCategoryList){
			if(levelNCategory.isChanged()){
				levelNCategory.incVersion();
			}
			
		
		}
		
		
		return levelNCategoryList;
	}

	public SmartList<LevelNCategory> removeLevelNCategoryList(SmartList<LevelNCategory> levelNCategoryList,Map<String,Object> options){
		
		
		super.removeList(levelNCategoryList, options);
		
		return levelNCategoryList;
		
		
	}
	
	protected List<Object[]> prepareLevelNCategoryBatchCreateArgs(List<LevelNCategory> levelNCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelNCategory levelNCategory:levelNCategoryList ){
			Object [] parameters = prepareLevelNCategoryCreateParameters(levelNCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelNCategoryBatchUpdateArgs(List<LevelNCategory> levelNCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelNCategory levelNCategory:levelNCategoryList ){
			if(!levelNCategory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelNCategoryUpdateParameters(levelNCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelNCategoryCreate(List<LevelNCategory> levelNCategoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelNCategoryBatchCreateArgs(levelNCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelNCategoryUpdate(List<LevelNCategory> levelNCategoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelNCategoryBatchUpdateArgs(levelNCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelNCategoryList(List<LevelNCategory> levelNCategoryList){
		
		List<LevelNCategory> levelNCategoryCreateList=new ArrayList<LevelNCategory>();
		List<LevelNCategory> levelNCategoryUpdateList=new ArrayList<LevelNCategory>();
		
		for(LevelNCategory levelNCategory: levelNCategoryList){
			if(isUpdateRequest(levelNCategory)){
				levelNCategoryUpdateList.add( levelNCategory);
				continue;
			}
			levelNCategoryCreateList.add(levelNCategory);
		}
		
		return new Object[]{levelNCategoryCreateList,levelNCategoryUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelNCategory levelNCategory){
 		return levelNCategory.getVersion() > 0;
 	}
 	protected String getSaveLevelNCategorySQL(LevelNCategory levelNCategory){
 		if(isUpdateRequest(levelNCategory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelNCategoryParameters(LevelNCategory levelNCategory){
 		if(isUpdateRequest(levelNCategory) ){
 			return prepareLevelNCategoryUpdateParameters(levelNCategory);
 		}
 		return prepareLevelNCategoryCreateParameters(levelNCategory);
 	}
 	protected Object[] prepareLevelNCategoryUpdateParameters(LevelNCategory levelNCategory){
 		Object[] parameters = new Object[5];
  	
 		if(levelNCategory.getParentCategory() != null){
 			parameters[0] = levelNCategory.getParentCategory().getId();
 		}
 
 		parameters[1] = levelNCategory.getName();		
 		parameters[2] = levelNCategory.nextVersion();
 		parameters[3] = levelNCategory.getId();
 		parameters[4] = levelNCategory.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelNCategoryCreateParameters(LevelNCategory levelNCategory){
		Object[] parameters = new Object[3];
		String newLevelNCategoryId=getNextId();
		levelNCategory.setId(newLevelNCategoryId);
		parameters[0] =  levelNCategory.getId();
  	
 		if(levelNCategory.getParentCategory() != null){
 			parameters[1] = levelNCategory.getParentCategory().getId();
 		
 		}
 		
 		parameters[2] = levelNCategory.getName();		
 				
 		return parameters;
 	}
 	
	protected LevelNCategory saveInternalLevelNCategory(LevelNCategory levelNCategory, Map<String,Object> options){
		
		saveLevelNCategory(levelNCategory);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(levelNCategory, options);
 		}
 
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(levelNCategory, options);
	 		//removeProductList(levelNCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		return levelNCategory;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelNCategory saveParentCategory(LevelNCategory levelNCategory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelNCategory.getParentCategory() == null){
 			return levelNCategory;//do nothing when it is null
 		}
 		
 		getLevelTwoCategoryDAO().save(levelNCategory.getParentCategory(),options);
 		return levelNCategory;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public LevelNCategory planToRemoveProductList(LevelNCategory levelNCategory, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return levelNCategory;
		}
		if(externalProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = levelNCategory.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return levelNCategory;	
	
	}


	//disconnect LevelNCategory with brand in Product
	public LevelNCategory planToRemoveProductListWithBrand(LevelNCategory levelNCategory, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(Product.BRAND_PROPERTY, brandId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return levelNCategory;
		}
		if(externalProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(Product product: externalProductList){
			product.clearBrand();
			product.clearParentCategory();
			
		}
		
		
		SmartList<Product> productList = levelNCategory.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return levelNCategory;
	}
	
	public int countProductListWithBrand(String levelNCategoryId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(Product.BRAND_PROPERTY, brandId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect LevelNCategory with catalog in Product
	public LevelNCategory planToRemoveProductListWithCatalog(LevelNCategory levelNCategory, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategory.getId());
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return levelNCategory;
		}
		if(externalProductList.isEmpty()){
			return levelNCategory;
		}
		
		for(Product product: externalProductList){
			product.clearCatalog();
			product.clearParentCategory();
			
		}
		
		
		SmartList<Product> productList = levelNCategory.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return levelNCategory;
	}
	
	public int countProductListWithCatalog(String levelNCategoryId, String catalogId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.PARENT_CATEGORY_PROPERTY, levelNCategoryId);
		key.put(Product.CATALOG_PROPERTY, catalogId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	

		
	protected LevelNCategory saveProductList(LevelNCategory levelNCategory, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = levelNCategory.getProductList();
		if(productList == null){
			//null list means nothing
			return levelNCategory;
		}
		SmartList<Product> mergedUpdateProductList = new SmartList<Product>();
		
		
		mergedUpdateProductList.addAll(productList); 
		if(productList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProductList.addAll(productList.getToRemoveList());
			productList.removeAll(productList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProductDAO().saveProductList(mergedUpdateProductList,options);
		
		if(productList.getToRemoveList() != null){
			productList.removeAll(productList.getToRemoveList());
		}
		
		
		return levelNCategory;
	
	}
	
	protected LevelNCategory removeProductList(LevelNCategory levelNCategory, Map<String,Object> options){
	
	
		SmartList<Product> productList = levelNCategory.getProductList();
		if(productList == null){
			return levelNCategory;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return levelNCategory;
		}
		if(toRemoveProductList.isEmpty()){
			return levelNCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return levelNCategory;
	
	}
	
	

 	
 	
	
	
	
		

	public LevelNCategory present(LevelNCategory levelNCategory,Map<String, Object> options){
	
		presentProductList(levelNCategory,options);

		return levelNCategory;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LevelNCategory presentProductList(
			LevelNCategory levelNCategory,
			Map<String, Object> options) {

		SmartList<Product> productList = levelNCategory.getProductList();		
				SmartList<Product> newList= presentSubList(levelNCategory.getId(),
				productList,
				options,
				getProductDAO()::countProductByParentCategory,
				getProductDAO()::findProductByParentCategory
				);

		
		levelNCategory.setProductList(newList);
		

		return levelNCategory;
	}			
		

	
    public SmartList<LevelNCategory> requestCandidateLevelNCategoryForProduct(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelNCategoryTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getLevelNCategoryMapper());
    }
		

	protected String getTableName(){
		return LevelNCategoryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LevelNCategory> levelNCategoryList) {		
		this.enhanceListInternal(levelNCategoryList, this.getLevelNCategoryMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LevelNCategory> levelNCategoryList = ownerEntity.collectRefsWithType(LevelNCategory.INTERNAL_TYPE);
		this.enhanceList(levelNCategoryList);
		
	}
	
	@Override
	public SmartList<LevelNCategory> findLevelNCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLevelNCategoryMapper());

	}
	@Override
	public int countLevelNCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLevelNCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LevelNCategory> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLevelNCategoryMapper());
	}
}


