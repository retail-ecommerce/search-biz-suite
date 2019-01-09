
package com.doublechaintech.search.catalog;
import com.doublechaintech.search.CommonTokens;
import java.util.Map;
public class CatalogTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="catalog";
	
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
	protected CatalogTokens(){
		//ensure not initialized outside the class
	}
	
	public CatalogTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static CatalogTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected CatalogTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static CatalogTokens start(){
		return new CatalogTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static CatalogTokens allTokens(){
		
		return start()
			.withSite()
			.withLevelOneCategoryList()
			.withProductList();
	
	}
	public static CatalogTokens withoutListsTokens(){
		
		return start()
			.withSite();
	
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

	protected static final String SITE = "site";
	public String getSite(){
		return SITE;
	}
	public CatalogTokens withSite(){		
		addSimpleOptions(SITE);
		return this;
	}
	
	
	protected static final String LEVEL_ONE_CATEGORY_LIST = "levelOneCategoryList";
	public String getLevelOneCategoryList(){
		return LEVEL_ONE_CATEGORY_LIST;
	}
	public CatalogTokens withLevelOneCategoryList(){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST);
		return this;
	}
	public CatalogTokens analyzeLevelOneCategoryList(){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLevelOneCategoryListEnabled(){		
		
		return checkOptions(this.options(), LEVEL_ONE_CATEGORY_LIST+".anaylze");
	}
	public CatalogTokens extractMoreFromLevelOneCategoryList(String idsSeperatedWithComma){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int levelOneCategoryListSortCounter = 0;
	public CatalogTokens sortLevelOneCategoryListWith(String field, String descOrAsc){		
		addSortMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSortCounter++, field, descOrAsc);
		return this;
	}
	private int levelOneCategoryListSearchCounter = 0;
	public CatalogTokens searchLevelOneCategoryListWith(String field, String verb, String value){		
		addSearchMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CatalogTokens searchAllTextOfLevelOneCategoryList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(LEVEL_ONE_CATEGORY_LIST,levelOneCategoryListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CatalogTokens rowsPerPageOfLevelOneCategoryList(int rowsPerPage){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfLevelOneCategoryList(int currentPageNumber){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfLevelOneCategoryList(String[] columns){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfLevelOneCategoryList(String[] columns){		
		addSimpleOptions(LEVEL_ONE_CATEGORY_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PRODUCT_LIST = "productList";
	public String getProductList(){
		return PRODUCT_LIST;
	}
	public CatalogTokens withProductList(){		
		addSimpleOptions(PRODUCT_LIST);
		return this;
	}
	public CatalogTokens analyzeProductList(){		
		addSimpleOptions(PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProductListEnabled(){		
		
		return checkOptions(this.options(), PRODUCT_LIST+".anaylze");
	}
	public CatalogTokens extractMoreFromProductList(String idsSeperatedWithComma){		
		addSimpleOptions(PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int productListSortCounter = 0;
	public CatalogTokens sortProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(PRODUCT_LIST,productListSortCounter++, field, descOrAsc);
		return this;
	}
	private int productListSearchCounter = 0;
	public CatalogTokens searchProductListWith(String field, String verb, String value){		
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CatalogTokens searchAllTextOfProductList(String verb, String value){	
		String field = "id|name|origin|remark|lastUpdateTime";
		addSearchMoreOptions(PRODUCT_LIST,productListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CatalogTokens rowsPerPageOfProductList(int rowsPerPage){		
		addSimpleOptions(PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CatalogTokens currentPageNumberOfProductList(int currentPageNumber){		
		addSimpleOptions(PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CatalogTokens retainColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public CatalogTokens excludeColumnsOfProductList(String[] columns){		
		addSimpleOptions(PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  CatalogTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfLevelOneCategoryList(verb, value);	
		searchAllTextOfProductList(verb, value);	
		return this;
	}
}

