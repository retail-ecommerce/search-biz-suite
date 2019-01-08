package com.doublechaintech.search.productrecommendation;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class ProductRecommendationForm extends BaseForm {
	
	
	public ProductRecommendationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProductRecommendationForm productRecommendationIdField(String parameterName, String initValue){
		FormField field = idFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductRecommendationForm productRecommendationIdField(String initValue){
		return productRecommendationIdField("productRecommendationId",initValue);
	}
	public ProductRecommendationForm productRecommendationIdField(){
		return productRecommendationIdField("productRecommendationId","");
	}


	public ProductRecommendationForm displayNameField(String parameterName, String initValue){
		FormField field = displayNameFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductRecommendationForm displayNameField(String initValue){
		return displayNameField("displayName",initValue);
	}
	public ProductRecommendationForm displayNameField(){
		return displayNameField("displayName","");
	}


	public ProductRecommendationForm brandIdField(String parameterName, String initValue){
		FormField field = brandIdFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductRecommendationForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public ProductRecommendationForm brandIdField(){
		return brandIdField("brandId","");
	}


	public ProductRecommendationForm originField(String parameterName, String initValue){
		FormField field = originFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductRecommendationForm originField(String initValue){
		return originField("origin",initValue);
	}
	public ProductRecommendationForm originField(){
		return originField("origin","");
	}


	public ProductRecommendationForm productIdField(String parameterName, String initValue){
		FormField field = productIdFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductRecommendationForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public ProductRecommendationForm productIdField(){
		return productIdField("productId","");
	}


	public ProductRecommendationForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductRecommendationForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public ProductRecommendationForm remarkField(){
		return remarkField("remark","");
	}


	public ProductRecommendationForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductRecommendationForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public ProductRecommendationForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public ProductRecommendationForm brandIdFieldOfBrand(String parameterName, String initValue){
		FormField field =  idFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm brandIdFieldOfBrand(String initValue){
		return brandIdFieldOfBrand("brandId",initValue);
	}
	public ProductRecommendationForm brandIdFieldOfBrand(){
		return brandIdFieldOfBrand("brandId","");
	}


	public ProductRecommendationForm brandNameFieldOfBrand(String parameterName, String initValue){
		FormField field =  brandNameFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm brandNameFieldOfBrand(String initValue){
		return brandNameFieldOfBrand("brandName",initValue);
	}
	public ProductRecommendationForm brandNameFieldOfBrand(){
		return brandNameFieldOfBrand("brandName","");
	}


	public ProductRecommendationForm logoFieldOfBrand(String parameterName, String initValue){
		FormField field =  logoFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm logoFieldOfBrand(String initValue){
		return logoFieldOfBrand("logo",initValue);
	}
	public ProductRecommendationForm logoFieldOfBrand(){
		return logoFieldOfBrand("logo","");
	}


	public ProductRecommendationForm remarkFieldOfBrand(String parameterName, String initValue){
		FormField field =  remarkFromBrand(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm remarkFieldOfBrand(String initValue){
		return remarkFieldOfBrand("remark",initValue);
	}
	public ProductRecommendationForm remarkFieldOfBrand(){
		return remarkFieldOfBrand("remark","");
	}


	public ProductRecommendationForm productIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm productIdFieldOfProduct(String initValue){
		return productIdFieldOfProduct("productId",initValue);
	}
	public ProductRecommendationForm productIdFieldOfProduct(){
		return productIdFieldOfProduct("productId","");
	}


	public ProductRecommendationForm displayNameFieldOfProduct(String parameterName, String initValue){
		FormField field =  displayNameFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm displayNameFieldOfProduct(String initValue){
		return displayNameFieldOfProduct("displayName",initValue);
	}
	public ProductRecommendationForm displayNameFieldOfProduct(){
		return displayNameFieldOfProduct("displayName","");
	}


	public ProductRecommendationForm parentCategoryIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm parentCategoryIdFieldOfProduct(String initValue){
		return parentCategoryIdFieldOfProduct("parentCategoryId",initValue);
	}
	public ProductRecommendationForm parentCategoryIdFieldOfProduct(){
		return parentCategoryIdFieldOfProduct("parentCategoryId","");
	}


	public ProductRecommendationForm brandIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm brandIdFieldOfProduct(String initValue){
		return brandIdFieldOfProduct("brandId",initValue);
	}
	public ProductRecommendationForm brandIdFieldOfProduct(){
		return brandIdFieldOfProduct("brandId","");
	}


	public ProductRecommendationForm originFieldOfProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm originFieldOfProduct(String initValue){
		return originFieldOfProduct("origin",initValue);
	}
	public ProductRecommendationForm originFieldOfProduct(){
		return originFieldOfProduct("origin","");
	}


	public ProductRecommendationForm catalogIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm catalogIdFieldOfProduct(String initValue){
		return catalogIdFieldOfProduct("catalogId",initValue);
	}
	public ProductRecommendationForm catalogIdFieldOfProduct(){
		return catalogIdFieldOfProduct("catalogId","");
	}


	public ProductRecommendationForm remarkFieldOfProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm remarkFieldOfProduct(String initValue){
		return remarkFieldOfProduct("remark",initValue);
	}
	public ProductRecommendationForm remarkFieldOfProduct(){
		return remarkFieldOfProduct("remark","");
	}


	public ProductRecommendationForm lastUpdateTimeFieldOfProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductRecommendationForm lastUpdateTimeFieldOfProduct(String initValue){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime",initValue);
	}
	public ProductRecommendationForm lastUpdateTimeFieldOfProduct(){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime","");
	}

	


	

	
 	public ProductRecommendationForm transferToAnotherBrandAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBrand/productRecommendationId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ProductRecommendationForm transferToAnotherProductAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProduct/productRecommendationId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProductRecommendationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


