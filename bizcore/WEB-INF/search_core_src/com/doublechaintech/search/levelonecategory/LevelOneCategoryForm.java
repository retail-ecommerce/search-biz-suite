package com.doublechaintech.search.levelonecategory;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class LevelOneCategoryForm extends BaseForm {
	
	
	public LevelOneCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelOneCategoryForm levelOneCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm levelOneCategoryIdField(String initValue){
		return levelOneCategoryIdField("levelOneCategoryId",initValue);
	}
	public LevelOneCategoryForm levelOneCategoryIdField(){
		return levelOneCategoryIdField("levelOneCategoryId","");
	}


	public LevelOneCategoryForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public LevelOneCategoryForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public LevelOneCategoryForm displayNameField(String parameterName, String initValue){
		FormField field = displayNameFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm displayNameField(String initValue){
		return displayNameField("displayName",initValue);
	}
	public LevelOneCategoryForm displayNameField(){
		return displayNameField("displayName","");
	}

	
	


	public LevelOneCategoryForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public LevelOneCategoryForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public LevelOneCategoryForm displayNameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  displayNameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm displayNameFieldOfCatalog(String initValue){
		return displayNameFieldOfCatalog("displayName",initValue);
	}
	public LevelOneCategoryForm displayNameFieldOfCatalog(){
		return displayNameFieldOfCatalog("displayName","");
	}


	public LevelOneCategoryForm sellerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  sellerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm sellerIdFieldOfCatalog(String initValue){
		return sellerIdFieldOfCatalog("sellerId",initValue);
	}
	public LevelOneCategoryForm sellerIdFieldOfCatalog(){
		return sellerIdFieldOfCatalog("sellerId","");
	}


	public LevelOneCategoryForm siteIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  siteIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm siteIdFieldOfCatalog(String initValue){
		return siteIdFieldOfCatalog("siteId",initValue);
	}
	public LevelOneCategoryForm siteIdFieldOfCatalog(){
		return siteIdFieldOfCatalog("siteId","");
	}

	



	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  idFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(String initValue){
		return levelTwoCategoryIdFieldForLevelTwoCategory("levelTwoCategoryId",initValue);
	}
	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(){
		return levelTwoCategoryIdFieldForLevelTwoCategory("levelTwoCategoryId","");
	}


	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(String initValue){
		return parentCategoryIdFieldForLevelTwoCategory("parentCategoryId",initValue);
	}
	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(){
		return parentCategoryIdFieldForLevelTwoCategory("parentCategoryId","");
	}


	public LevelOneCategoryForm displayNameFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  displayNameFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm displayNameFieldForLevelTwoCategory(String initValue){
		return displayNameFieldForLevelTwoCategory("displayName",initValue);
	}
	public LevelOneCategoryForm displayNameFieldForLevelTwoCategory(){
		return displayNameFieldForLevelTwoCategory("displayName","");
	}

	

	
 	public LevelOneCategoryForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/levelOneCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelOneCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


