package com.doublechaintech.search.product;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class ProductForm extends BaseForm {
	
	
	public ProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProductForm productIdField(String parameterName, String initValue){
		FormField field = idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public ProductForm productIdField(){
		return productIdField("productId","");
	}


	public ProductForm nameField(String parameterName, String initValue){
		FormField field = nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProductForm nameField(){
		return nameField("name","");
	}


	public ProductForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public ProductForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public ProductForm brandIdField(String parameterName, String initValue){
		FormField field = brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public ProductForm brandIdField(){
		return brandIdField("brandId","");
	}


	public ProductForm originField(String parameterName, String initValue){
		FormField field = originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm originField(String initValue){
		return originField("origin",initValue);
	}
	public ProductForm originField(){
		return originField("origin","");
	}


	public ProductForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public ProductForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public ProductForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public ProductForm remarkField(){
		return remarkField("remark","");
	}


	public ProductForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public ProductForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public ProductForm levelNCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  idFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm levelNCategoryIdFieldOfLevelNCategory(String initValue){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId",initValue);
	}
	public ProductForm levelNCategoryIdFieldOfLevelNCategory(){
		return levelNCategoryIdFieldOfLevelNCategory("levelNCategoryId","");
	}


	public ProductForm parentCategoryIdFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm parentCategoryIdFieldOfLevelNCategory(String initValue){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId",initValue);
	}
	public ProductForm parentCategoryIdFieldOfLevelNCategory(){
		return parentCategoryIdFieldOfLevelNCategory("parentCategoryId","");
	}


	public ProductForm nameFieldOfLevelNCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelNCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm nameFieldOfLevelNCategory(String initValue){
		return nameFieldOfLevelNCategory("name",initValue);
	}
	public ProductForm nameFieldOfLevelNCategory(){
		return nameFieldOfLevelNCategory("name","");
	}


	public ProductForm brandIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm brandIdFieldOfBrand(String initValue){
		return brandIdFieldOfBrand("brandId",initValue);
	}
	public ProductForm brandIdFieldOfBrand(){
		return brandIdFieldOfBrand("brandId","");
	}


	public ProductForm brandNameFieldOfBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm brandNameFieldOfBrand(String initValue){
		return brandNameFieldOfBrand("brandName",initValue);
	}
	public ProductForm brandNameFieldOfBrand(){
		return brandNameFieldOfBrand("brandName","");
	}


	public ProductForm logoFieldOfBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm logoFieldOfBrand(String initValue){
		return logoFieldOfBrand("logo",initValue);
	}
	public ProductForm logoFieldOfBrand(){
		return logoFieldOfBrand("logo","");
	}


	public ProductForm remarkFieldOfBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm remarkFieldOfBrand(String initValue){
		return remarkFieldOfBrand("remark",initValue);
	}
	public ProductForm remarkFieldOfBrand(){
		return remarkFieldOfBrand("remark","");
	}


	public ProductForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public ProductForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public ProductForm nameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm nameFieldOfCatalog(String initValue){
		return nameFieldOfCatalog("name",initValue);
	}
	public ProductForm nameFieldOfCatalog(){
		return nameFieldOfCatalog("name","");
	}


	public ProductForm sellerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm sellerIdFieldOfCatalog(String initValue){
		return sellerIdFieldOfCatalog("sellerId",initValue);
	}
	public ProductForm sellerIdFieldOfCatalog(){
		return sellerIdFieldOfCatalog("sellerId","");
	}


	public ProductForm siteIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm siteIdFieldOfCatalog(String initValue){
		return siteIdFieldOfCatalog("siteId",initValue);
	}
	public ProductForm siteIdFieldOfCatalog(){
		return siteIdFieldOfCatalog("siteId","");
	}

	



	public ProductForm productRecommendationIdFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  idFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productRecommendationIdFieldForProductRecommendation(String initValue){
		return productRecommendationIdFieldForProductRecommendation("productRecommendationId",initValue);
	}
	public ProductForm productRecommendationIdFieldForProductRecommendation(){
		return productRecommendationIdFieldForProductRecommendation("productRecommendationId","");
	}


	public ProductForm nameFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  nameFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm nameFieldForProductRecommendation(String initValue){
		return nameFieldForProductRecommendation("name",initValue);
	}
	public ProductForm nameFieldForProductRecommendation(){
		return nameFieldForProductRecommendation("name","");
	}


	public ProductForm brandIdFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  brandIdFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm brandIdFieldForProductRecommendation(String initValue){
		return brandIdFieldForProductRecommendation("brandId",initValue);
	}
	public ProductForm brandIdFieldForProductRecommendation(){
		return brandIdFieldForProductRecommendation("brandId","");
	}


	public ProductForm originFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  originFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm originFieldForProductRecommendation(String initValue){
		return originFieldForProductRecommendation("origin",initValue);
	}
	public ProductForm originFieldForProductRecommendation(){
		return originFieldForProductRecommendation("origin","");
	}


	public ProductForm productIdFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  productIdFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdFieldForProductRecommendation(String initValue){
		return productIdFieldForProductRecommendation("productId",initValue);
	}
	public ProductForm productIdFieldForProductRecommendation(){
		return productIdFieldForProductRecommendation("productId","");
	}


	public ProductForm remarkFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  remarkFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm remarkFieldForProductRecommendation(String initValue){
		return remarkFieldForProductRecommendation("remark",initValue);
	}
	public ProductForm remarkFieldForProductRecommendation(){
		return remarkFieldForProductRecommendation("remark","");
	}


	public ProductForm lastUpdateTimeFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm lastUpdateTimeFieldForProductRecommendation(String initValue){
		return lastUpdateTimeFieldForProductRecommendation("lastUpdateTime",initValue);
	}
	public ProductForm lastUpdateTimeFieldForProductRecommendation(){
		return lastUpdateTimeFieldForProductRecommendation("lastUpdateTime","");
	}


	public ProductForm skuIdFieldForSku(String parameterName, String initValue){
		FormField field =  idFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm skuIdFieldForSku(String initValue){
		return skuIdFieldForSku("skuId",initValue);
	}
	public ProductForm skuIdFieldForSku(){
		return skuIdFieldForSku("skuId","");
	}


	public ProductForm nameFieldForSku(String parameterName, String initValue){
		FormField field =  nameFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm nameFieldForSku(String initValue){
		return nameFieldForSku("name",initValue);
	}
	public ProductForm nameFieldForSku(){
		return nameFieldForSku("name","");
	}


	public ProductForm sizeFieldForSku(String parameterName, String initValue){
		FormField field =  sizeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm sizeFieldForSku(String initValue){
		return sizeFieldForSku("size",initValue);
	}
	public ProductForm sizeFieldForSku(){
		return sizeFieldForSku("size","");
	}


	public ProductForm productIdFieldForSku(String parameterName, String initValue){
		FormField field =  productIdFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdFieldForSku(String initValue){
		return productIdFieldForSku("productId",initValue);
	}
	public ProductForm productIdFieldForSku(){
		return productIdFieldForSku("productId","");
	}


	public ProductForm activeFieldForSku(String parameterName, String initValue){
		FormField field =  activeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm activeFieldForSku(String initValue){
		return activeFieldForSku("active",initValue);
	}
	public ProductForm activeFieldForSku(){
		return activeFieldForSku("active","");
	}


	public ProductForm basePriceFieldForSku(String parameterName, String initValue){
		FormField field =  basePriceFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm basePriceFieldForSku(String initValue){
		return basePriceFieldForSku("basePrice",initValue);
	}
	public ProductForm basePriceFieldForSku(){
		return basePriceFieldForSku("basePrice","");
	}


	public ProductForm lastUpdateTimeFieldForSku(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm lastUpdateTimeFieldForSku(String initValue){
		return lastUpdateTimeFieldForSku("lastUpdateTime",initValue);
	}
	public ProductForm lastUpdateTimeFieldForSku(){
		return lastUpdateTimeFieldForSku("lastUpdateTime","");
	}

	

	
 	public ProductForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/productId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ProductForm transferToAnotherBrandAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBrand/productId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ProductForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/productId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


