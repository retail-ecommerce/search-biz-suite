
package com.doublechaintech.search.catalog;

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


import com.doublechaintech.search.levelonecategory.LevelOneCategory;
import com.doublechaintech.search.product.Product;
import com.doublechaintech.search.site.Site;

import com.doublechaintech.search.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.search.product.ProductDAO;
import com.doublechaintech.search.site.SiteDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class CatalogJDBCTemplateDAO extends SearchNamingServiceDAO implements CatalogDAO{
 
 	
 	private  SiteDAO  siteDAO;
 	public void setSiteDAO(SiteDAO siteDAO){
	 	this.siteDAO = siteDAO;
 	}
 	public SiteDAO getSiteDAO(){
	 	return this.siteDAO;
 	}


			
		
	
  	private  LevelOneCategoryDAO  levelOneCategoryDAO;
 	public void setLevelOneCategoryDAO(LevelOneCategoryDAO pLevelOneCategoryDAO){
 	
 		if(pLevelOneCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneCategoryDAO to null.");
 		}
	 	this.levelOneCategoryDAO = pLevelOneCategoryDAO;
 	}
 	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
 		if(this.levelOneCategoryDAO == null){
 			throw new IllegalStateException("The levelOneCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelOneCategoryDAO;
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
	protected Catalog load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCatalog(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Catalog load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCatalog(CatalogTable.withId(id), options);
	}
	
	
	
	public Catalog save(Catalog catalog,Map<String,Object> options){
		
		String methodName="save(Catalog catalog,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(catalog, methodName, "catalog");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCatalog(catalog,options);
	}
	public Catalog clone(String catalogId, Map<String,Object> options) throws Exception{
	
		return clone(CatalogTable.withId(catalogId),options);
	}
	
	protected Catalog clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String catalogId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Catalog newCatalog = loadInternalCatalog(accessKey, options);
		newCatalog.setVersion(0);
		
		
 		
 		if(isSaveLevelOneCategoryListEnabled(options)){
 			for(LevelOneCategory item: newCatalog.getLevelOneCategoryList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProductListEnabled(options)){
 			for(Product item: newCatalog.getProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCatalog(newCatalog,options);
		
		return newCatalog;
	}
	
	
	
	

	protected void throwIfHasException(String catalogId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CatalogVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CatalogNotFoundException(
					"The " + this.getTableName() + "(" + catalogId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String catalogId, int version) throws Exception{
	
		String methodName="delete(String catalogId, int version)";
		assertMethodArgumentNotNull(catalogId, methodName, "catalogId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{catalogId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(catalogId,version);
		}
		
	
	}
	
	
	
	
	

	public Catalog disconnectFromAll(String catalogId, int version) throws Exception{
	
		
		Catalog catalog = loadInternalCatalog(CatalogTable.withId(catalogId), emptyOptions());
		catalog.clearFromAll();
		this.saveCatalog(catalog);
		return catalog;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return CatalogTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "catalog";
	}
	@Override
	protected String getBeanName() {
		
		return "catalog";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CatalogTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSiteEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CatalogTokens.SITE);
 	}

 	protected boolean isSaveSiteEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CatalogTokens.SITE);
 	}
 	

 	
 
		
	
	protected boolean isExtractLevelOneCategoryListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.LEVEL_ONE_CATEGORY_LIST);
 	}
 	protected boolean isAnalyzeLevelOneCategoryListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.LEVEL_ONE_CATEGORY_LIST+".analyze");
 	}

	protected boolean isSaveLevelOneCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.LEVEL_ONE_CATEGORY_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.PRODUCT_LIST);
 	}
 	protected boolean isAnalyzeProductListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.PRODUCT_LIST+".analyze");
 	}

	protected boolean isSaveProductListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.PRODUCT_LIST);
		
 	}
 	
		

	

	protected CatalogMapper getCatalogMapper(){
		return new CatalogMapper();
	}

	
	
	protected Catalog extractCatalog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Catalog catalog = loadSingleObject(accessKey, getCatalogMapper());
			return catalog;
		}catch(EmptyResultDataAccessException e){
			throw new CatalogNotFoundException("Catalog("+accessKey+") is not found!");
		}

	}

	
	

	protected Catalog loadInternalCatalog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Catalog catalog = extractCatalog(accessKey, loadOptions);
 	
 		if(isExtractSiteEnabled(loadOptions)){
	 		extractSite(catalog, loadOptions);
 		}
 
		
		if(isExtractLevelOneCategoryListEnabled(loadOptions)){
	 		extractLevelOneCategoryList(catalog, loadOptions);
 		}	
 		if(isAnalyzeLevelOneCategoryListEnabled(loadOptions)){
	 		// analyzeLevelOneCategoryList(catalog, loadOptions);
 		}
 		
		
		if(isExtractProductListEnabled(loadOptions)){
	 		extractProductList(catalog, loadOptions);
 		}	
 		if(isAnalyzeProductListEnabled(loadOptions)){
	 		// analyzeProductList(catalog, loadOptions);
 		}
 		
		
		return catalog;
		
	}

	 

 	protected Catalog extractSite(Catalog catalog, Map<String,Object> options) throws Exception{

		if(catalog.getSite() == null){
			return catalog;
		}
		String siteId = catalog.getSite().getId();
		if( siteId == null){
			return catalog;
		}
		Site site = getSiteDAO().load(siteId,options);
		if(site != null){
			catalog.setSite(site);
		}
		
 		
 		return catalog;
 	}
 		
 
		
	protected void enhanceLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<LevelOneCategory> levelOneCategoryList = getLevelOneCategoryDAO().findLevelOneCategoryByCatalog(catalog.getId(),options);
		if(levelOneCategoryList != null){
			enhanceLevelOneCategoryList(levelOneCategoryList,options);
			catalog.setLevelOneCategoryList(levelOneCategoryList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList != null){
			getLevelOneCategoryDAO().analyzeLevelOneCategoryByCatalog(levelOneCategoryList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
	protected void enhanceProductList(SmartList<Product> productList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<Product> productList = getProductDAO().findProductByCatalog(catalog.getId(),options);
		if(productList != null){
			enhanceProductList(productList,options);
			catalog.setProductList(productList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeProductList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<Product> productList = catalog.getProductList();
		if(productList != null){
			getProductDAO().analyzeProductByCatalog(productList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
		
  	
 	public SmartList<Catalog> findCatalogBySite(String siteId,Map<String,Object> options){
 	
  		SmartList<Catalog> resultList = queryWith(CatalogTable.COLUMN_SITE, siteId, options, getCatalogMapper());
		// analyzeCatalogBySite(resultList, siteId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Catalog> findCatalogBySite(String siteId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Catalog> resultList =  queryWithRange(CatalogTable.COLUMN_SITE, siteId, options, getCatalogMapper(), start, count);
 		//analyzeCatalogBySite(resultList, siteId, options);
 		return resultList;
 		
 	}
 	public void analyzeCatalogBySite(SmartList<Catalog> resultList, String siteId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countCatalogBySite(String siteId,Map<String,Object> options){

 		return countWith(CatalogTable.COLUMN_SITE, siteId, options);
 	}
 	@Override
	public Map<String, Integer> countCatalogBySiteIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CatalogTable.COLUMN_SITE, ids, options);
	}
 	
 	
		
		
		

	

	protected Catalog saveCatalog(Catalog  catalog){
		
		if(!catalog.isChanged()){
			return catalog;
		}
		
		
		String SQL=this.getSaveCatalogSQL(catalog);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCatalogParameters(catalog);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		catalog.incVersion();
		return catalog;
	
	}
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCatalogList(catalogList);
		
		batchCatalogCreate((List<Catalog>)lists[CREATE_LIST_INDEX]);
		
		batchCatalogUpdate((List<Catalog>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Catalog catalog:catalogList){
			if(catalog.isChanged()){
				catalog.incVersion();
			}
			
		
		}
		
		
		return catalogList;
	}

	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		
		
		super.removeList(catalogList, options);
		
		return catalogList;
		
		
	}
	
	protected List<Object[]> prepareCatalogBatchCreateArgs(List<Catalog> catalogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Catalog catalog:catalogList ){
			Object [] parameters = prepareCatalogCreateParameters(catalog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCatalogBatchUpdateArgs(List<Catalog> catalogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Catalog catalog:catalogList ){
			if(!catalog.isChanged()){
				continue;
			}
			Object [] parameters = prepareCatalogUpdateParameters(catalog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCatalogCreate(List<Catalog> catalogList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCatalogBatchCreateArgs(catalogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCatalogUpdate(List<Catalog> catalogList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCatalogBatchUpdateArgs(catalogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCatalogList(List<Catalog> catalogList){
		
		List<Catalog> catalogCreateList=new ArrayList<Catalog>();
		List<Catalog> catalogUpdateList=new ArrayList<Catalog>();
		
		for(Catalog catalog: catalogList){
			if(isUpdateRequest(catalog)){
				catalogUpdateList.add( catalog);
				continue;
			}
			catalogCreateList.add(catalog);
		}
		
		return new Object[]{catalogCreateList,catalogUpdateList};
	}
	
	protected boolean isUpdateRequest(Catalog catalog){
 		return catalog.getVersion() > 0;
 	}
 	protected String getSaveCatalogSQL(Catalog catalog){
 		if(isUpdateRequest(catalog)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCatalogParameters(Catalog catalog){
 		if(isUpdateRequest(catalog) ){
 			return prepareCatalogUpdateParameters(catalog);
 		}
 		return prepareCatalogCreateParameters(catalog);
 	}
 	protected Object[] prepareCatalogUpdateParameters(Catalog catalog){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = catalog.getName();
 		parameters[1] = catalog.getSellerId(); 	
 		if(catalog.getSite() != null){
 			parameters[2] = catalog.getSite().getId();
 		}
 		
 		parameters[3] = catalog.nextVersion();
 		parameters[4] = catalog.getId();
 		parameters[5] = catalog.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCatalogCreateParameters(Catalog catalog){
		Object[] parameters = new Object[4];
		String newCatalogId=getNextId();
		catalog.setId(newCatalogId);
		parameters[0] =  catalog.getId();
 
 		parameters[1] = catalog.getName();
 		parameters[2] = catalog.getSellerId(); 	
 		if(catalog.getSite() != null){
 			parameters[3] = catalog.getSite().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Catalog saveInternalCatalog(Catalog catalog, Map<String,Object> options){
		
		saveCatalog(catalog);
 	
 		if(isSaveSiteEnabled(options)){
	 		saveSite(catalog, options);
 		}
 
		
		if(isSaveLevelOneCategoryListEnabled(options)){
	 		saveLevelOneCategoryList(catalog, options);
	 		//removeLevelOneCategoryList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProductListEnabled(options)){
	 		saveProductList(catalog, options);
	 		//removeProductList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		return catalog;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Catalog saveSite(Catalog catalog, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(catalog.getSite() == null){
 			return catalog;//do nothing when it is null
 		}
 		
 		getSiteDAO().save(catalog.getSite(),options);
 		return catalog;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Catalog planToRemoveLevelOneCategoryList(Catalog catalog, String levelOneCategoryIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelOneCategory.CATALOG_PROPERTY, catalog.getId());
		key.put(LevelOneCategory.ID_PROPERTY, levelOneCategoryIds);
		
		SmartList<LevelOneCategory> externalLevelOneCategoryList = getLevelOneCategoryDAO().
				findLevelOneCategoryWithKey(key, options);
		if(externalLevelOneCategoryList == null){
			return catalog;
		}
		if(externalLevelOneCategoryList.isEmpty()){
			return catalog;
		}
		
		for(LevelOneCategory levelOneCategory: externalLevelOneCategoryList){

			levelOneCategory.clearFromAll();
		}
		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();		
		levelOneCategoryList.addAllToRemoveList(externalLevelOneCategoryList);
		return catalog;	
	
	}


	public Catalog planToRemoveProductList(Catalog catalog, String productIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalog.getId());
		key.put(Product.ID_PROPERTY, productIds);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return catalog;
		}
		if(externalProductList.isEmpty()){
			return catalog;
		}
		
		for(Product product: externalProductList){

			product.clearFromAll();
		}
		
		
		SmartList<Product> productList = catalog.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return catalog;	
	
	}


	//disconnect Catalog with parent_category in Product
	public Catalog planToRemoveProductListWithParentCategory(Catalog catalog, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalog.getId());
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return catalog;
		}
		if(externalProductList.isEmpty()){
			return catalog;
		}
		
		for(Product product: externalProductList){
			product.clearParentCategory();
			product.clearCatalog();
			
		}
		
		
		SmartList<Product> productList = catalog.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return catalog;
	}
	
	public int countProductListWithParentCategory(String catalogId, String parentCategoryId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalogId);
		key.put(Product.PARENT_CATEGORY_PROPERTY, parentCategoryId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	
	//disconnect Catalog with brand in Product
	public Catalog planToRemoveProductListWithBrand(Catalog catalog, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalog.getId());
		key.put(Product.BRAND_PROPERTY, brandId);
		
		SmartList<Product> externalProductList = getProductDAO().
				findProductWithKey(key, options);
		if(externalProductList == null){
			return catalog;
		}
		if(externalProductList.isEmpty()){
			return catalog;
		}
		
		for(Product product: externalProductList){
			product.clearBrand();
			product.clearCatalog();
			
		}
		
		
		SmartList<Product> productList = catalog.getProductList();		
		productList.addAllToRemoveList(externalProductList);
		return catalog;
	}
	
	public int countProductListWithBrand(String catalogId, String brandId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Product.CATALOG_PROPERTY, catalogId);
		key.put(Product.BRAND_PROPERTY, brandId);
		
		int count = getProductDAO().countProductWithKey(key, options);
		return count;
	}
	

		
	protected Catalog saveLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList == null){
			//null list means nothing
			return catalog;
		}
		SmartList<LevelOneCategory> mergedUpdateLevelOneCategoryList = new SmartList<LevelOneCategory>();
		
		
		mergedUpdateLevelOneCategoryList.addAll(levelOneCategoryList); 
		if(levelOneCategoryList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelOneCategoryList.addAll(levelOneCategoryList.getToRemoveList());
			levelOneCategoryList.removeAll(levelOneCategoryList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLevelOneCategoryDAO().saveLevelOneCategoryList(mergedUpdateLevelOneCategoryList,options);
		
		if(levelOneCategoryList.getToRemoveList() != null){
			levelOneCategoryList.removeAll(levelOneCategoryList.getToRemoveList());
		}
		
		
		return catalog;
	
	}
	
	protected Catalog removeLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList == null){
			return catalog;
		}	
	
		SmartList<LevelOneCategory> toRemoveLevelOneCategoryList = levelOneCategoryList.getToRemoveList();
		
		if(toRemoveLevelOneCategoryList == null){
			return catalog;
		}
		if(toRemoveLevelOneCategoryList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelOneCategoryDAO().removeLevelOneCategoryList(toRemoveLevelOneCategoryList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		
	protected Catalog saveProductList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<Product> productList = catalog.getProductList();
		if(productList == null){
			//null list means nothing
			return catalog;
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
		
		
		return catalog;
	
	}
	
	protected Catalog removeProductList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<Product> productList = catalog.getProductList();
		if(productList == null){
			return catalog;
		}	
	
		SmartList<Product> toRemoveProductList = productList.getToRemoveList();
		
		if(toRemoveProductList == null){
			return catalog;
		}
		if(toRemoveProductList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductDAO().removeProductList(toRemoveProductList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		

	public Catalog present(Catalog catalog,Map<String, Object> options){
	
		presentLevelOneCategoryList(catalog,options);
		presentProductList(catalog,options);

		return catalog;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentLevelOneCategoryList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();		
				SmartList<LevelOneCategory> newList= presentSubList(catalog.getId(),
				levelOneCategoryList,
				options,
				getLevelOneCategoryDAO()::countLevelOneCategoryByCatalog,
				getLevelOneCategoryDAO()::findLevelOneCategoryByCatalog
				);

		
		catalog.setLevelOneCategoryList(newList);
		

		return catalog;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentProductList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<Product> productList = catalog.getProductList();		
				SmartList<Product> newList= presentSubList(catalog.getId(),
				productList,
				options,
				getProductDAO()::countProductByCatalog,
				getProductDAO()::findProductByCatalog
				);

		
		catalog.setProductList(newList);
		

		return catalog;
	}			
		

	
    public SmartList<Catalog> requestCandidateCatalogForLevelOneCategory(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		
    public SmartList<Catalog> requestCandidateCatalogForProduct(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		

	protected String getTableName(){
		return CatalogTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Catalog> catalogList) {		
		this.enhanceListInternal(catalogList, this.getCatalogMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Catalog> catalogList = ownerEntity.collectRefsWithType(Catalog.INTERNAL_TYPE);
		this.enhanceList(catalogList);
		
	}
	
	@Override
	public SmartList<Catalog> findCatalogWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getCatalogMapper());

	}
	@Override
	public int countCatalogWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countCatalogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Catalog> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCatalogMapper());
	}
}


