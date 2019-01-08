package com.doublechaintech.search.brand;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class BrandForm extends BaseForm {
	
	
	public BrandForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public BrandForm brandIdField(String parameterName, String initValue){
		FormField field = idFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdField(String initValue){
		return brandIdField("brandId",initValue);
	}
	public BrandForm brandIdField(){
		return brandIdField("brandId","");
	}


	public BrandForm brandNameField(String parameterName, String initValue){
		FormField field = brandNameFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandNameField(String initValue){
		return brandNameField("brandName",initValue);
	}
	public BrandForm brandNameField(){
		return brandNameField("brandName","");
	}


	public BrandForm logoField(String parameterName, String initValue){
		FormField field = logoFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm logoField(String initValue){
		return logoField("logo",initValue);
	}
	public BrandForm logoField(){
		return logoField("logo","");
	}


	public BrandForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromBrand(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public BrandForm remarkField(){
		return remarkField("remark","");
	}

	
	

	



	public BrandForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public BrandForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public BrandForm displayNameFieldForProduct(String parameterName, String initValue){
		FormField field =  displayNameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm displayNameFieldForProduct(String initValue){
		return displayNameFieldForProduct("displayName",initValue);
	}
	public BrandForm displayNameFieldForProduct(){
		return displayNameFieldForProduct("displayName","");
	}


	public BrandForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public BrandForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public BrandForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public BrandForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public BrandForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public BrandForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public BrandForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public BrandForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public BrandForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public BrandForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public BrandForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public BrandForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}


	public BrandForm productRecommendationIdFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  idFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productRecommendationIdFieldForProductRecommendation(String initValue){
		return productRecommendationIdFieldForProductRecommendation("productRecommendationId",initValue);
	}
	public BrandForm productRecommendationIdFieldForProductRecommendation(){
		return productRecommendationIdFieldForProductRecommendation("productRecommendationId","");
	}


	public BrandForm displayNameFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  displayNameFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm displayNameFieldForProductRecommendation(String initValue){
		return displayNameFieldForProductRecommendation("displayName",initValue);
	}
	public BrandForm displayNameFieldForProductRecommendation(){
		return displayNameFieldForProductRecommendation("displayName","");
	}


	public BrandForm brandIdFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  brandIdFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm brandIdFieldForProductRecommendation(String initValue){
		return brandIdFieldForProductRecommendation("brandId",initValue);
	}
	public BrandForm brandIdFieldForProductRecommendation(){
		return brandIdFieldForProductRecommendation("brandId","");
	}


	public BrandForm originFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  originFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm originFieldForProductRecommendation(String initValue){
		return originFieldForProductRecommendation("origin",initValue);
	}
	public BrandForm originFieldForProductRecommendation(){
		return originFieldForProductRecommendation("origin","");
	}


	public BrandForm productIdFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  productIdFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm productIdFieldForProductRecommendation(String initValue){
		return productIdFieldForProductRecommendation("productId",initValue);
	}
	public BrandForm productIdFieldForProductRecommendation(){
		return productIdFieldForProductRecommendation("productId","");
	}


	public BrandForm remarkFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  remarkFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm remarkFieldForProductRecommendation(String initValue){
		return remarkFieldForProductRecommendation("remark",initValue);
	}
	public BrandForm remarkFieldForProductRecommendation(){
		return remarkFieldForProductRecommendation("remark","");
	}


	public BrandForm lastUpdateTimeFieldForProductRecommendation(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProductRecommendation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public BrandForm lastUpdateTimeFieldForProductRecommendation(String initValue){
		return lastUpdateTimeFieldForProductRecommendation("lastUpdateTime",initValue);
	}
	public BrandForm lastUpdateTimeFieldForProductRecommendation(){
		return lastUpdateTimeFieldForProductRecommendation("lastUpdateTime","");
	}

	



	public BrandForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


