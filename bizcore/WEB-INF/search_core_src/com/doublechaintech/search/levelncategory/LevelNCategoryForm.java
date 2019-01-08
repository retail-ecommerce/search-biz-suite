package com.doublechaintech.search.levelncategory;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class LevelNCategoryForm extends BaseForm {
	
	
	public LevelNCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelNCategoryForm levelNCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm levelNCategoryIdField(String initValue){
		return levelNCategoryIdField("levelNCategoryId",initValue);
	}
	public LevelNCategoryForm levelNCategoryIdField(){
		return levelNCategoryIdField("levelNCategoryId","");
	}


	public LevelNCategoryForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public LevelNCategoryForm displayNameField(String parameterName, String initValue){
		FormField field = displayNameFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm displayNameField(String initValue){
		return displayNameField("displayName",initValue);
	}
	public LevelNCategoryForm displayNameField(){
		return displayNameField("displayName","");
	}

	
	


	public LevelNCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  idFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelNCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(String initValue){
		return levelTwoCategoryIdFieldOfLevelTwoCategory("levelTwoCategoryId",initValue);
	}
	public LevelNCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(){
		return levelTwoCategoryIdFieldOfLevelTwoCategory("levelTwoCategoryId","");
	}


	public LevelNCategoryForm parentCategoryIdFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdFieldOfLevelTwoCategory(String initValue){
		return parentCategoryIdFieldOfLevelTwoCategory("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdFieldOfLevelTwoCategory(){
		return parentCategoryIdFieldOfLevelTwoCategory("parentCategoryId","");
	}


	public LevelNCategoryForm displayNameFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  displayNameFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelNCategoryForm displayNameFieldOfLevelTwoCategory(String initValue){
		return displayNameFieldOfLevelTwoCategory("displayName",initValue);
	}
	public LevelNCategoryForm displayNameFieldOfLevelTwoCategory(){
		return displayNameFieldOfLevelTwoCategory("displayName","");
	}

	



	public LevelNCategoryForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public LevelNCategoryForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public LevelNCategoryForm displayNameFieldForProduct(String parameterName, String initValue){
		FormField field =  displayNameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm displayNameFieldForProduct(String initValue){
		return displayNameFieldForProduct("displayName",initValue);
	}
	public LevelNCategoryForm displayNameFieldForProduct(){
		return displayNameFieldForProduct("displayName","");
	}


	public LevelNCategoryForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public LevelNCategoryForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public LevelNCategoryForm brandIdFieldForProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm brandIdFieldForProduct(String initValue){
		return brandIdFieldForProduct("brandId",initValue);
	}
	public LevelNCategoryForm brandIdFieldForProduct(){
		return brandIdFieldForProduct("brandId","");
	}


	public LevelNCategoryForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public LevelNCategoryForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public LevelNCategoryForm catalogIdFieldForProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm catalogIdFieldForProduct(String initValue){
		return catalogIdFieldForProduct("catalogId",initValue);
	}
	public LevelNCategoryForm catalogIdFieldForProduct(){
		return catalogIdFieldForProduct("catalogId","");
	}


	public LevelNCategoryForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public LevelNCategoryForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public LevelNCategoryForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelNCategoryForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public LevelNCategoryForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}

	

	
 	public LevelNCategoryForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/levelNCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelNCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


