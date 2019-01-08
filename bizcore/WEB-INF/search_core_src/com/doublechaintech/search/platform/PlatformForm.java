package com.doublechaintech.search.platform;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm introductionField(String parameterName, String initValue){
		FormField field = introductionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionField(String initValue){
		return introductionField("introduction",initValue);
	}
	public PlatformForm introductionField(){
		return introductionField("introduction","");
	}


	public PlatformForm currentVersionField(String parameterName, String initValue){
		FormField field = currentVersionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm currentVersionField(String initValue){
		return currentVersionField("currentVersion",initValue);
	}
	public PlatformForm currentVersionField(){
		return currentVersionField("currentVersion","");
	}

	
	

	



	public PlatformForm siteIdFieldForSite(String parameterName, String initValue){
		FormField field =  idFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm siteIdFieldForSite(String initValue){
		return siteIdFieldForSite("siteId",initValue);
	}
	public PlatformForm siteIdFieldForSite(){
		return siteIdFieldForSite("siteId","");
	}


	public PlatformForm nameFieldForSite(String parameterName, String initValue){
		FormField field =  nameFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForSite(String initValue){
		return nameFieldForSite("name",initValue);
	}
	public PlatformForm nameFieldForSite(){
		return nameFieldForSite("name","");
	}


	public PlatformForm introductionFieldForSite(String parameterName, String initValue){
		FormField field =  introductionFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionFieldForSite(String initValue){
		return introductionFieldForSite("introduction",initValue);
	}
	public PlatformForm introductionFieldForSite(){
		return introductionFieldForSite("introduction","");
	}


	public PlatformForm platformIdFieldForSite(String parameterName, String initValue){
		FormField field =  platformIdFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForSite(String initValue){
		return platformIdFieldForSite("platformId",initValue);
	}
	public PlatformForm platformIdFieldForSite(){
		return platformIdFieldForSite("platformId","");
	}


	public PlatformForm lastUpdateTimeFieldForSite(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSite(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForSite(String initValue){
		return lastUpdateTimeFieldForSite("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForSite(){
		return lastUpdateTimeFieldForSite("lastUpdateTime","");
	}


	public PlatformForm profileIdFieldForProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForProfile(String initValue){
		return profileIdFieldForProfile("profileId",initValue);
	}
	public PlatformForm profileIdFieldForProfile(){
		return profileIdFieldForProfile("profileId","");
	}


	public PlatformForm nameFieldForProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProfile(String initValue){
		return nameFieldForProfile("name",initValue);
	}
	public PlatformForm nameFieldForProfile(){
		return nameFieldForProfile("name","");
	}


	public PlatformForm ageFieldForProfile(String parameterName, String initValue){
		FormField field =  ageFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm ageFieldForProfile(String initValue){
		return ageFieldForProfile("age",initValue);
	}
	public PlatformForm ageFieldForProfile(){
		return ageFieldForProfile("age","");
	}


	public PlatformForm genderFieldForProfile(String parameterName, String initValue){
		FormField field =  genderFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm genderFieldForProfile(String initValue){
		return genderFieldForProfile("gender",initValue);
	}
	public PlatformForm genderFieldForProfile(){
		return genderFieldForProfile("gender","");
	}


	public PlatformForm lastUpdateTimeFieldForProfile(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForProfile(String initValue){
		return lastUpdateTimeFieldForProfile("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForProfile(){
		return lastUpdateTimeFieldForProfile("lastUpdateTime","");
	}


	public PlatformForm platformIdFieldForProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProfile(String initValue){
		return platformIdFieldForProfile("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProfile(){
		return platformIdFieldForProfile("platformId","");
	}


	public PlatformForm userOrderIdFieldForUserOrder(String parameterName, String initValue){
		FormField field =  idFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm userOrderIdFieldForUserOrder(String initValue){
		return userOrderIdFieldForUserOrder("userOrderId",initValue);
	}
	public PlatformForm userOrderIdFieldForUserOrder(){
		return userOrderIdFieldForUserOrder("userOrderId","");
	}


	public PlatformForm titleFieldForUserOrder(String parameterName, String initValue){
		FormField field =  titleFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm titleFieldForUserOrder(String initValue){
		return titleFieldForUserOrder("title",initValue);
	}
	public PlatformForm titleFieldForUserOrder(){
		return titleFieldForUserOrder("title","");
	}


	public PlatformForm totalAdjustmentFieldForUserOrder(String parameterName, String initValue){
		FormField field =  totalAdjustmentFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm totalAdjustmentFieldForUserOrder(String initValue){
		return totalAdjustmentFieldForUserOrder("totalAdjustment",initValue);
	}
	public PlatformForm totalAdjustmentFieldForUserOrder(){
		return totalAdjustmentFieldForUserOrder("totalAdjustment","");
	}


	public PlatformForm totalAmountFieldForUserOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm totalAmountFieldForUserOrder(String initValue){
		return totalAmountFieldForUserOrder("totalAmount",initValue);
	}
	public PlatformForm totalAmountFieldForUserOrder(){
		return totalAmountFieldForUserOrder("totalAmount","");
	}


	public PlatformForm userIdFieldForUserOrder(String parameterName, String initValue){
		FormField field =  userIdFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm userIdFieldForUserOrder(String initValue){
		return userIdFieldForUserOrder("userId",initValue);
	}
	public PlatformForm userIdFieldForUserOrder(){
		return userIdFieldForUserOrder("userId","");
	}


	public PlatformForm platformIdFieldForUserOrder(String parameterName, String initValue){
		FormField field =  platformIdFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForUserOrder(String initValue){
		return platformIdFieldForUserOrder("platformId",initValue);
	}
	public PlatformForm platformIdFieldForUserOrder(){
		return platformIdFieldForUserOrder("platformId","");
	}


	public PlatformForm lastUpdateTimeFieldForUserOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromUserOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateTimeFieldForUserOrder(String initValue){
		return lastUpdateTimeFieldForUserOrder("lastUpdateTime",initValue);
	}
	public PlatformForm lastUpdateTimeFieldForUserOrder(){
		return lastUpdateTimeFieldForUserOrder("lastUpdateTime","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


