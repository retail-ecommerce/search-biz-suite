
package com.doublechaintech.search.brand;
import com.doublechaintech.search.CommonTokens;
import java.util.Map;
public class BrandTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="brand";
	
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
	protected BrandTokens(){
		//ensure not initialized outside the class
	}
	
	public BrandTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static BrandTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected BrandTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static BrandTokens start(){
		return new BrandTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static BrandTokens allTokens(){
		
		return start()
			.withProductList()
			.withProductRecommendationList();
	
	}
	public static BrandTokens withoutListsTokens(){
		
		return start();
	
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

	protected static final String PRODUCT_LIST = "productList";
	public String getProductList(){
		return PRODUCT_LIST;
	}
	public BrandTokens withProductList(){		
		addSimpleOptions(PRODUCT_LIST);
		return this;
	}
	public BrandTokens analyzeProductList(){		
		addSimpleOptions(PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_LIST+".anaylze");
	}
	public BrandTokens extractMoreFromProductList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productListSortCounter = 0;
	public BrandTokens sortProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_LIST,productListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productListSearchCounter = 0;
	public BrandTokens searchProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	public BrandTokens searchAllTextOfProductList(String verb, String value){	
		String field = "id|name|origin|remark|lastUpdateTime";
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public BrandTokens rowsPerPageOfProductList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public BrandTokens currentPageNumberOfProductList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public BrandTokens retainColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public BrandTokens excludeColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PRODUCT_RECOMMENDATION_LIST = "productRecommendationList";
	public String getProductRecommendationList(){
		return PRODUCT_RECOMMENDATION_LIST;
	}
	public BrandTokens withProductRecommendationList(){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST);
		return this;
	}
	public BrandTokens analyzeProductRecommendationList(){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductRecommendationListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_RECOMMENDATION_LIST+".anaylze");
	}
	public BrandTokens extractMoreFromProductRecommendationList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productRecommendationListSortCounter = 0;
	public BrandTokens sortProductRecommendationListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_RECOMMENDATION_LIST,productRecommendationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productRecommendationListSearchCounter = 0;
	public BrandTokens searchProductRecommendationListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_RECOMMENDATION_LIST,productRecommendationListSearchCounter++, field, verb, value);
		return this;
	}
	
	public BrandTokens searchAllTextOfProductRecommendationList(String verb, String value){	
		String field = "id|name|origin|remark|lastUpdateTime";
		addSearchMoreOptions(PRODUCT_RECOMMENDATION_LIST,productRecommendationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public BrandTokens rowsPerPageOfProductRecommendationList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public BrandTokens currentPageNumberOfProductRecommendationList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public BrandTokens retainColumnsOfProductRecommendationList(String[] columns){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+"RetainColumns",columns);
		return this;
	}
	public BrandTokens excludeColumnsOfProductRecommendationList(String[] columns){		
		addSimpleOptions(PRODUCT_RECOMMENDATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  BrandTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfProductList(verb, value);	
		searchAllTextOfProductRecommendationList(verb, value);	
		return this;
	}
}

