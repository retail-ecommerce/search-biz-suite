package com.doublechaintech.search.shippingaddress;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class ShippingAddressForm extends BaseForm {
	
	
	public ShippingAddressForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ShippingAddressForm shippingAddressIdField(String parameterName, String initValue){
		FormField field = idFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm shippingAddressIdField(String initValue){
		return shippingAddressIdField("shippingAddressId",initValue);
	}
	public ShippingAddressForm shippingAddressIdField(){
		return shippingAddressIdField("shippingAddressId","");
	}


	public ShippingAddressForm nameField(String parameterName, String initValue){
		FormField field = nameFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ShippingAddressForm nameField(){
		return nameField("name","");
	}


	public ShippingAddressForm line1Field(String parameterName, String initValue){
		FormField field = line1FromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm line1Field(String initValue){
		return line1Field("line1",initValue);
	}
	public ShippingAddressForm line1Field(){
		return line1Field("line1","");
	}


	public ShippingAddressForm line2Field(String parameterName, String initValue){
		FormField field = line2FromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm line2Field(String initValue){
		return line2Field("line2",initValue);
	}
	public ShippingAddressForm line2Field(){
		return line2Field("line2","");
	}


	public ShippingAddressForm cityField(String parameterName, String initValue){
		FormField field = cityFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm cityField(String initValue){
		return cityField("city",initValue);
	}
	public ShippingAddressForm cityField(){
		return cityField("city","");
	}


	public ShippingAddressForm stateField(String parameterName, String initValue){
		FormField field = stateFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm stateField(String initValue){
		return stateField("state",initValue);
	}
	public ShippingAddressForm stateField(){
		return stateField("state","");
	}


	public ShippingAddressForm zipCodeField(String parameterName, String initValue){
		FormField field = zipCodeFromShippingAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingAddressForm zipCodeField(String initValue){
		return zipCodeField("zipCode",initValue);
	}
	public ShippingAddressForm zipCodeField(){
		return zipCodeField("zipCode","");
	}

	
	

	


	



	public ShippingAddressForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


