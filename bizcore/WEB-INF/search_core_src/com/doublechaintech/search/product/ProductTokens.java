
package com.doublechaintech.search.product;
import com.doublechaintech.search.CommonTokens;
import java.util.Map;
public class ProductTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="product";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected ProductTokens(){
		//ensure not initialized outside the class
	}
	
	public ProductTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProductTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProductTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProductTokens start(){
		return new ProductTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProductTokens allTokens(){
		
		return start()
			.withParentCategory()
			.withBrand()
			.withCatalog()
			.withProductRecommendationList()
			.withSkuList();
	
	}
	public static ProductTokens withoutListsTokens(){
		
		return start()
			.withParentCategory()
			.withBrand()
			.withCatalog();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String PARENTCATEGORY = "parentCategory";
	public String getParentCategory(){
		return PARENTCATEGORY;
	}
	public ProductTokens withParentCategory(){		
		addSimpleOptions(PARENTCATEGORY);
		return this;
	}
	
	
	protected static final String BRAND = "brand";
	public String getBrand(){
		return BRAND;
	}
	public ProductTokens withBrand(){		
		addSimpleOptions(BRAND);
		return this;
	}
	
	
	protected static final String CATALOG = "catalog";
	public String getCatalog(){
		return CATALOG;
	}
	public ProductTokens withCatalog(){		
		addSimpleOptions(CATALOG);
		return this;
	}
	
	
	protected static final String PRODUCT_RECOMMENDATION_LIST = "productRecommendationList";
	public String getProductRecommendationList(){
		return PRODUCT_RECOMMENDATION_LIST;
	}
	public ProductTokens withProductRecommendationList(){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST);
		return this;
	}
	public ProductTokens analyzeProductRecommendationList(){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductRecommendationListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_RECOMMENDATION_LIST+".anaylze");
	}
	public ProductTokens extractMoreFromProductRecommendationList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productRecommendationListSortCounter = 0;
	public ProductTokens sortProductRecommendationListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_RECOMMENDATION_LIST,productRecommendationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productRecommendationListSearchCounter = 0;
	public ProductTokens searchProductRecommendationListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_RECOMMENDATION_LIST,productRecommendationListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProductTokens searchAllTextOfProductRecommendationList(String verb, String value){	
		String field = "id|displayName|origin|remark|lastUpdateTime";
		addSearchMoreOptions(PRODUCT_RECOMMENDATION_LIST,productRecommendationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProductTokens rowsPerPageOfProductRecommendationList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProductTokens currentPageNumberOfProductRecommendationList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProductTokens retainColumnsOfProductRecommendationList(String[] columns){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+"RetainColumns",columns);
		return this;
	}
	public ProductTokens excludeColumnsOfProductRecommendationList(String[] columns){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String SKU_LIST = "skuList";
	public String getSkuList(){
		return SKU_LIST;
	}
	public ProductTokens withSkuList(){		
		addSimpleOptions(SKU_LIST);
		return this;
	}
	public ProductTokens analyzeSkuList(){		
		addSimpleOptions(SKU_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSkuListEnabled(){		
		
		return checkOptions(this.options(), SKU_LIST+".anaylze");
	}
	public ProductTokens extractMoreFromSkuList(String idsSeperatedWithComma){		
		addSimpleOptions(SKU_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int skuListSortCounter = 0;
	public ProductTokens sortSkuListWith(String field, String descOrAsc){		
		addSortMoreOptions(SKU_LIST,skuListSortCounter++, field, descOrAsc);
		return this;
	}
	private int skuListSearchCounter = 0;
	public ProductTokens searchSkuListWith(String field, String verb, String value){		
		addSearchMoreOptions(SKU_LIST,skuListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProductTokens searchAllTextOfSkuList(String verb, String value){	
		String field = "id|displayName|size|lastUpdateTime";
		addSearchMoreOptions(SKU_LIST,skuListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProductTokens rowsPerPageOfSkuList(int rowsPerPage){		
		addSimpleOptions(SKU_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProductTokens currentPageNumberOfSkuList(int currentPageNumber){		
		addSimpleOptions(SKU_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProductTokens retainColumnsOfSkuList(String[] columns){		
		addSimpleOptions(SKU_LIST+"RetainColumns",columns);
		return this;
	}
	public ProductTokens excludeColumnsOfSkuList(String[] columns){		
		addSimpleOptions(SKU_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ProductTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfProductRecommendationList(verb, value);	
		searchAllTextOfSkuList(verb, value);	
		return this;
	}
}

