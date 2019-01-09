
package com.doublechaintech.search.productrecommendation;

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
import com.doublechaintech.search.brand.Brand;

import com.doublechaintech.search.brand.BrandDAO;
import com.doublechaintech.search.product.ProductDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ProductRecommendationJDBCTemplateDAO extends SearchNamingServiceDAO implements ProductRecommendationDAO{
 
 	
 	private  ProductDAO  productDAO;
 	public void setProductDAO(ProductDAO productDAO){
	 	this.productDAO = productDAO;
 	}
 	public ProductDAO getProductDAO(){
	 	return this.productDAO;
 	}
 
 	
 	private  BrandDAO  brandDAO;
 	public void setBrandDAO(BrandDAO brandDAO){
	 	this.brandDAO = brandDAO;
 	}
 	public BrandDAO getBrandDAO(){
	 	return this.brandDAO;
 	}


			
		

	
	/*
	protected ProductRecommendation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProductRecommendation(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ProductRecommendation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProductRecommendation(ProductRecommendationTable.withId(id), options);
	}
	
	
	
	public ProductRecommendation save(ProductRecommendation productRecommendation,Map<String,Object> options){
		
		String methodName="save(ProductRecommendation productRecommendation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(productRecommendation, methodName, "productRecommendation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProductRecommendation(productRecommendation,options);
	}
	public ProductRecommendation clone(String productRecommendationId, Map<String,Object> options) throws Exception{
	
		return clone(ProductRecommendationTable.withId(productRecommendationId),options);
	}
	
	protected ProductRecommendation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String productRecommendationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ProductRecommendation newProductRecommendation = loadInternalProductRecommendation(accessKey, options);
		newProductRecommendation.setVersion(0);
		
		

		
		saveInternalProductRecommendation(newProductRecommendation,options);
		
		return newProductRecommendation;
	}
	
	
	
	

	protected void throwIfHasException(String productRecommendationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProductRecommendationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProductRecommendationNotFoundException(
					"The " + this.getTableName() + "(" + productRecommendationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String productRecommendationId, int version) throws Exception{
	
		String methodName="delete(String productRecommendationId, int version)";
		assertMethodArgumentNotNull(productRecommendationId, methodName, "productRecommendationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{productRecommendationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(productRecommendationId,version);
		}
		
	
	}
	
	
	
	
	

	public ProductRecommendation disconnectFromAll(String productRecommendationId, int version) throws Exception{
	
		
		ProductRecommendation productRecommendation = loadInternalProductRecommendation(ProductRecommendationTable.withId(productRecommendationId), emptyOptions());
		productRecommendation.clearFromAll();
		this.saveProductRecommendation(productRecommendation);
		return productRecommendation;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ProductRecommendationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "product_recommendation";
	}
	@Override
	protected String getBeanName() {
		
		return "productRecommendation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProductRecommendationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBrandEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProductRecommendationTokens.BRAND);
 	}

 	protected boolean isSaveBrandEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProductRecommendationTokens.BRAND);
 	}
 	

 	
  

 	protected boolean isExtractProductEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProductRecommendationTokens.PRODUCT);
 	}

 	protected boolean isSaveProductEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProductRecommendationTokens.PRODUCT);
 	}
 	

 	
 
		

	

	protected ProductRecommendationMapper getProductRecommendationMapper(){
		return new ProductRecommendationMapper();
	}

	
	
	protected ProductRecommendation extractProductRecommendation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ProductRecommendation productRecommendation = loadSingleObject(accessKey, getProductRecommendationMapper());
			return productRecommendation;
		}catch(EmptyResultDataAccessException e){
			throw new ProductRecommendationNotFoundException("ProductRecommendation("+accessKey+") is not found!");
		}

	}

	
	

	protected ProductRecommendation loadInternalProductRecommendation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ProductRecommendation productRecommendation = extractProductRecommendation(accessKey, loadOptions);
 	
 		if(isExtractBrandEnabled(loadOptions)){
	 		extractBrand(productRecommendation, loadOptions);
 		}
  	
 		if(isExtractProductEnabled(loadOptions)){
	 		extractProduct(productRecommendation, loadOptions);
 		}
 
		
		return productRecommendation;
		
	}

	 

 	protected ProductRecommendation extractBrand(ProductRecommendation productRecommendation, Map<String,Object> options) throws Exception{

		if(productRecommendation.getBrand() == null){
			return productRecommendation;
		}
		String brandId = productRecommendation.getBrand().getId();
		if( brandId == null){
			return productRecommendation;
		}
		Brand brand = getBrandDAO().load(brandId,options);
		if(brand != null){
			productRecommendation.setBrand(brand);
		}
		
 		
 		return productRecommendation;
 	}
 		
  

 	protected ProductRecommendation extractProduct(ProductRecommendation productRecommendation, Map<String,Object> options) throws Exception{

		if(productRecommendation.getProduct() == null){
			return productRecommendation;
		}
		String productId = productRecommendation.getProduct().getId();
		if( productId == null){
			return productRecommendation;
		}
		Product product = getProductDAO().load(productId,options);
		if(product != null){
			productRecommendation.setProduct(product);
		}
		
 		
 		return productRecommendation;
 	}
 		
 
		
		
  	
 	public SmartList<ProductRecommendation> findProductRecommendationByBrand(String brandId,Map<String,Object> options){
 	
  		SmartList<ProductRecommendation> resultList = queryWith(ProductRecommendationTable.COLUMN_BRAND, brandId, options, getProductRecommendationMapper());
		// analyzeProductRecommendationByBrand(resultList, brandId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ProductRecommendation> findProductRecommendationByBrand(String brandId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ProductRecommendation> resultList =  queryWithRange(ProductRecommendationTable.COLUMN_BRAND, brandId, options, getProductRecommendationMapper(), start, count);
 		//analyzeProductRecommendationByBrand(resultList, brandId, options);
 		return resultList;
 		
 	}
 	public void analyzeProductRecommendationByBrand(SmartList<ProductRecommendation> resultList, String brandId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ProductRecommendation.BRAND_PROPERTY, brandId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countProductRecommendationByBrand(String brandId,Map<String,Object> options){

 		return countWith(ProductRecommendationTable.COLUMN_BRAND, brandId, options);
 	}
 	@Override
	public Map<String, Integer> countProductRecommendationByBrandIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProductRecommendationTable.COLUMN_BRAND, ids, options);
	}
 	
  	
 	public SmartList<ProductRecommendation> findProductRecommendationByProduct(String productId,Map<String,Object> options){
 	
  		SmartList<ProductRecommendation> resultList = queryWith(ProductRecommendationTable.COLUMN_PRODUCT, productId, options, getProductRecommendationMapper());
		// analyzeProductRecommendationByProduct(resultList, productId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ProductRecommendation> findProductRecommendationByProduct(String productId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ProductRecommendation> resultList =  queryWithRange(ProductRecommendationTable.COLUMN_PRODUCT, productId, options, getProductRecommendationMapper(), start, count);
 		//analyzeProductRecommendationByProduct(resultList, productId, options);
 		return resultList;
 		
 	}
 	public void analyzeProductRecommendationByProduct(SmartList<ProductRecommendation> resultList, String productId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ProductRecommendation.PRODUCT_PROPERTY, productId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countProductRecommendationByProduct(String productId,Map<String,Object> options){

 		return countWith(ProductRecommendationTable.COLUMN_PRODUCT, productId, options);
 	}
 	@Override
	public Map<String, Integer> countProductRecommendationByProductIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProductRecommendationTable.COLUMN_PRODUCT, ids, options);
	}
 	
 	
		
		
		

	

	protected ProductRecommendation saveProductRecommendation(ProductRecommendation  productRecommendation){
		
		if(!productRecommendation.isChanged()){
			return productRecommendation;
		}
		
		
		String SQL=this.getSaveProductRecommendationSQL(productRecommendation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProductRecommendationParameters(productRecommendation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		productRecommendation.incVersion();
		return productRecommendation;
	
	}
	public SmartList<ProductRecommendation> saveProductRecommendationList(SmartList<ProductRecommendation> productRecommendationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProductRecommendationList(productRecommendationList);
		
		batchProductRecommendationCreate((List<ProductRecommendation>)lists[CREATE_LIST_INDEX]);
		
		batchProductRecommendationUpdate((List<ProductRecommendation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ProductRecommendation productRecommendation:productRecommendationList){
			if(productRecommendation.isChanged()){
				productRecommendation.incVersion();
			}
			
		
		}
		
		
		return productRecommendationList;
	}

	public SmartList<ProductRecommendation> removeProductRecommendationList(SmartList<ProductRecommendation> productRecommendationList,Map<String,Object> options){
		
		
		super.removeList(productRecommendationList, options);
		
		return productRecommendationList;
		
		
	}
	
	protected List<Object[]> prepareProductRecommendationBatchCreateArgs(List<ProductRecommendation> productRecommendationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProductRecommendation productRecommendation:productRecommendationList ){
			Object [] parameters = prepareProductRecommendationCreateParameters(productRecommendation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProductRecommendationBatchUpdateArgs(List<ProductRecommendation> productRecommendationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProductRecommendation productRecommendation:productRecommendationList ){
			if(!productRecommendation.isChanged()){
				continue;
			}
			Object [] parameters = prepareProductRecommendationUpdateParameters(productRecommendation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProductRecommendationCreate(List<ProductRecommendation> productRecommendationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProductRecommendationBatchCreateArgs(productRecommendationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProductRecommendationUpdate(List<ProductRecommendation> productRecommendationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProductRecommendationBatchUpdateArgs(productRecommendationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProductRecommendationList(List<ProductRecommendation> productRecommendationList){
		
		List<ProductRecommendation> productRecommendationCreateList=new ArrayList<ProductRecommendation>();
		List<ProductRecommendation> productRecommendationUpdateList=new ArrayList<ProductRecommendation>();
		
		for(ProductRecommendation productRecommendation: productRecommendationList){
			if(isUpdateRequest(productRecommendation)){
				productRecommendationUpdateList.add( productRecommendation);
				continue;
			}
			productRecommendationCreateList.add(productRecommendation);
		}
		
		return new Object[]{productRecommendationCreateList,productRecommendationUpdateList};
	}
	
	protected boolean isUpdateRequest(ProductRecommendation productRecommendation){
 		return productRecommendation.getVersion() > 0;
 	}
 	protected String getSaveProductRecommendationSQL(ProductRecommendation productRecommendation){
 		if(isUpdateRequest(productRecommendation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProductRecommendationParameters(ProductRecommendation productRecommendation){
 		if(isUpdateRequest(productRecommendation) ){
 			return prepareProductRecommendationUpdateParameters(productRecommendation);
 		}
 		return prepareProductRecommendationCreateParameters(productRecommendation);
 	}
 	protected Object[] prepareProductRecommendationUpdateParameters(ProductRecommendation productRecommendation){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = productRecommendation.getName(); 	
 		if(productRecommendation.getBrand() != null){
 			parameters[1] = productRecommendation.getBrand().getId();
 		}
 
 		parameters[2] = productRecommendation.getOrigin(); 	
 		if(productRecommendation.getProduct() != null){
 			parameters[3] = productRecommendation.getProduct().getId();
 		}
 
 		parameters[4] = productRecommendation.getRemark();
 		parameters[5] = productRecommendation.getLastUpdateTime();		
 		parameters[6] = productRecommendation.nextVersion();
 		parameters[7] = productRecommendation.getId();
 		parameters[8] = productRecommendation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProductRecommendationCreateParameters(ProductRecommendation productRecommendation){
		Object[] parameters = new Object[7];
		String newProductRecommendationId=getNextId();
		productRecommendation.setId(newProductRecommendationId);
		parameters[0] =  productRecommendation.getId();
 
 		parameters[1] = productRecommendation.getName(); 	
 		if(productRecommendation.getBrand() != null){
 			parameters[2] = productRecommendation.getBrand().getId();
 		
 		}
 		
 		parameters[3] = productRecommendation.getOrigin(); 	
 		if(productRecommendation.getProduct() != null){
 			parameters[4] = productRecommendation.getProduct().getId();
 		
 		}
 		
 		parameters[5] = productRecommendation.getRemark();
 		parameters[6] = productRecommendation.getLastUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected ProductRecommendation saveInternalProductRecommendation(ProductRecommendation productRecommendation, Map<String,Object> options){
		
		saveProductRecommendation(productRecommendation);
 	
 		if(isSaveBrandEnabled(options)){
	 		saveBrand(productRecommendation, options);
 		}
  	
 		if(isSaveProductEnabled(options)){
	 		saveProduct(productRecommendation, options);
 		}
 
		
		return productRecommendation;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ProductRecommendation saveBrand(ProductRecommendation productRecommendation, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(productRecommendation.getBrand() == null){
 			return productRecommendation;//do nothing when it is null
 		}
 		
 		getBrandDAO().save(productRecommendation.getBrand(),options);
 		return productRecommendation;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ProductRecommendation saveProduct(ProductRecommendation productRecommendation, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(productRecommendation.getProduct() == null){
 			return productRecommendation;//do nothing when it is null
 		}
 		
 		getProductDAO().save(productRecommendation.getProduct(),options);
 		return productRecommendation;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ProductRecommendation present(ProductRecommendation productRecommendation,Map<String, Object> options){
	

		return productRecommendation;
	
	}
		

	

	protected String getTableName(){
		return ProductRecommendationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ProductRecommendation> productRecommendationList) {		
		this.enhanceListInternal(productRecommendationList, this.getProductRecommendationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ProductRecommendation> productRecommendationList = ownerEntity.collectRefsWithType(ProductRecommendation.INTERNAL_TYPE);
		this.enhanceList(productRecommendationList);
		
	}
	
	@Override
	public SmartList<ProductRecommendation> findProductRecommendationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getProductRecommendationMapper());

	}
	@Override
	public int countProductRecommendationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countProductRecommendationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ProductRecommendation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProductRecommendationMapper());
	}
}


