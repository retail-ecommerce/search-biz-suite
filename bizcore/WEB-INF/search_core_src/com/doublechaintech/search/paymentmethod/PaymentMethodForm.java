package com.doublechaintech.search.paymentmethod;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class PaymentMethodForm extends BaseForm {
	
	
	public PaymentMethodForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PaymentMethodForm paymentMethodIdField(String parameterName, String initValue){
		FormField field = idFromPaymentMethod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentMethodForm paymentMethodIdField(String initValue){
		return paymentMethodIdField("paymentMethodId",initValue);
	}
	public PaymentMethodForm paymentMethodIdField(){
		return paymentMethodIdField("paymentMethodId","");
	}


	public PaymentMethodForm nameField(String parameterName, String initValue){
		FormField field = nameFromPaymentMethod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentMethodForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PaymentMethodForm nameField(){
		return nameField("name","");
	}


	public PaymentMethodForm numberField(String parameterName, String initValue){
		FormField field = numberFromPaymentMethod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentMethodForm numberField(String initValue){
		return numberField("number",initValue);
	}
	public PaymentMethodForm numberField(){
		return numberField("number","");
	}


	public PaymentMethodForm line1Field(String parameterName, String initValue){
		FormField field = line1FromPaymentMethod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentMethodForm line1Field(String initValue){
		return line1Field("line1",initValue);
	}
	public PaymentMethodForm line1Field(){
		return line1Field("line1","");
	}


	public PaymentMethodForm line2Field(String parameterName, String initValue){
		FormField field = line2FromPaymentMethod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentMethodForm line2Field(String initValue){
		return line2Field("line2",initValue);
	}
	public PaymentMethodForm line2Field(){
		return line2Field("line2","");
	}


	public PaymentMethodForm cityField(String parameterName, String initValue){
		FormField field = cityFromPaymentMethod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentMethodForm cityField(String initValue){
		return cityField("city",initValue);
	}
	public PaymentMethodForm cityField(){
		return cityField("city","");
	}


	public PaymentMethodForm expireOnField(String parameterName, String initValue){
		FormField field = expireOnFromPaymentMethod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PaymentMethodForm expireOnField(String initValue){
		return expireOnField("expireOn",initValue);
	}
	public PaymentMethodForm expireOnField(){
		return expireOnField("expireOn","");
	}

	
	

	


	



	public PaymentMethodForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


