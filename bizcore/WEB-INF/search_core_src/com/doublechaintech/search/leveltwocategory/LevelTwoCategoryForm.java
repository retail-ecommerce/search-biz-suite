package com.doublechaintech.search.leveltwocategory;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class LevelTwoCategoryForm extends BaseForm {
	
	
	public LevelTwoCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelTwoCategoryForm levelTwoCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm levelTwoCategoryIdField(String initValue){
		return levelTwoCategoryIdField("levelTwoCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelTwoCategoryIdField(){
		return levelTwoCategoryIdField("levelTwoCategoryId","");
	}


	public LevelTwoCategoryForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public LevelTwoCategoryForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public LevelTwoCategoryForm displayNameField(String parameterName, String initValue){
		FormField field = displayNameFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm displayNameField(String initValue){
		return displayNameField("displayName",initValue);
	}
	public LevelTwoCategoryForm displayNameField(){
		return displayNameField("displayName","");
	}

	
	


	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  idFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(String initValue){
		return levelOneCategoryIdFieldOfLevelOneCategory("levelOneCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(){
		return levelOneCategoryIdFieldOfLevelOneCategory("levelOneCategoryId","");
	}


	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  catalogIdFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(String initValue){
		return catalogIdFieldOfLevelOneCategory("catalogId",initValue);
	}
	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(){
		return catalogIdFieldOfLevelOneCategory("catalogId","");
	}


	public LevelTwoCategoryForm displayNameFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  displayNameFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm displayNameFieldOfLevelOneCategory(String initValue){
		return displayNameFieldOfLevelOneCategory("displayName",initValue);
	}
	public LevelTwoCategoryForm displayNameFieldOfLevelOneCategory(){
		return displayNameFieldOfLevelOneCategory("displayName","");
	}

	



	public LevelTwoCategoryForm levelNCategoryIdFieldForLevelNCategory(String parameterName, String initValue){
		FormField field =  idFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm levelNCategoryIdFieldForLevelNCategory(String initValue){
		return levelNCategoryIdFieldForLevelNCategory("levelNCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelNCategoryIdFieldForLevelNCategory(){
		return levelNCategoryIdFieldForLevelNCategory("levelNCategoryId","");
	}


	public LevelTwoCategoryForm parentCategoryIdFieldForLevelNCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm parentCategoryIdFieldForLevelNCategory(String initValue){
		return parentCategoryIdFieldForLevelNCategory("parentCategoryId",initValue);
	}
	public LevelTwoCategoryForm parentCategoryIdFieldForLevelNCategory(){
		return parentCategoryIdFieldForLevelNCategory("parentCategoryId","");
	}


	public LevelTwoCategoryForm displayNameFieldForLevelNCategory(String parameterName, String initValue){
		FormField field =  displayNameFromLevelNCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm displayNameFieldForLevelNCategory(String initValue){
		return displayNameFieldForLevelNCategory("displayName",initValue);
	}
	public LevelTwoCategoryForm displayNameFieldForLevelNCategory(){
		return displayNameFieldForLevelNCategory("displayName","");
	}

	

	
 	public LevelTwoCategoryForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/levelTwoCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelTwoCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


