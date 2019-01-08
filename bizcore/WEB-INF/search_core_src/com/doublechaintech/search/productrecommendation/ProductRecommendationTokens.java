
package com.doublechaintech.search.productrecommendation;
import com.doublechaintech.search.CommonTokens;
import java.util.Map;
public class ProductRecommendationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="productRecommendation";
	
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
	protected ProductRecommendationTokens(){
		//ensure not initialized outside the class
	}
	
	public ProductRecommendationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProductRecommendationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProductRecommendationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProductRecommendationTokens start(){
		return new ProductRecommendationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProductRecommendationTokens allTokens(){
		
		return start()
			.withBrand()
			.withProduct();
	
	}
	public static ProductRecommendationTokens withoutListsTokens(){
		
		return start()
			.withBrand()
			.withProduct();
	
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

	protected static final String BRAND = "brand";
	public String getBrand(){
		return BRAND;
	}
	public ProductRecommendationTokens withBrand(){		
		addSimpleOptions(BRAND);
		return this;
	}
	
	
	protected static final String PRODUCT = "product";
	public String getProduct(){
		return PRODUCT;
	}
	public ProductRecommendationTokens withProduct(){		
		addSimpleOptions(PRODUCT);
		return this;
	}
	
	
	
	public  ProductRecommendationTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

