package com.doublechaintech.search.sku;
import com.doublechaintech.search.BaseForm;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;



public class SkuForm extends BaseForm {
	
	
	public SkuForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SkuForm skuIdField(String parameterName, String initValue){
		FormField field = idFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm skuIdField(String initValue){
		return skuIdField("skuId",initValue);
	}
	public SkuForm skuIdField(){
		return skuIdField("skuId","");
	}


	public SkuForm nameField(String parameterName, String initValue){
		FormField field = nameFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public SkuForm nameField(){
		return nameField("name","");
	}


	public SkuForm sizeField(String parameterName, String initValue){
		FormField field = sizeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm sizeField(String initValue){
		return sizeField("size",initValue);
	}
	public SkuForm sizeField(){
		return sizeField("size","");
	}


	public SkuForm productIdField(String parameterName, String initValue){
		FormField field = productIdFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public SkuForm productIdField(){
		return productIdField("productId","");
	}


	public SkuForm activeField(String parameterName, String initValue){
		FormField field = activeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm activeField(String initValue){
		return activeField("active",initValue);
	}
	public SkuForm activeField(){
		return activeField("active","");
	}


	public SkuForm basePriceField(String parameterName, String initValue){
		FormField field = basePriceFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm basePriceField(String initValue){
		return basePriceField("basePrice",initValue);
	}
	public SkuForm basePriceField(){
		return basePriceField("basePrice","");
	}


	public SkuForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public SkuForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public SkuForm productIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm productIdFieldOfProduct(String initValue){
		return productIdFieldOfProduct("productId",initValue);
	}
	public SkuForm productIdFieldOfProduct(){
		return productIdFieldOfProduct("productId","");
	}


	public SkuForm nameFieldOfProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm nameFieldOfProduct(String initValue){
		return nameFieldOfProduct("name",initValue);
	}
	public SkuForm nameFieldOfProduct(){
		return nameFieldOfProduct("name","");
	}


	public SkuForm parentCategoryIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm parentCategoryIdFieldOfProduct(String initValue){
		return parentCategoryIdFieldOfProduct("parentCategoryId",initValue);
	}
	public SkuForm parentCategoryIdFieldOfProduct(){
		return parentCategoryIdFieldOfProduct("parentCategoryId","");
	}


	public SkuForm brandIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm brandIdFieldOfProduct(String initValue){
		return brandIdFieldOfProduct("brandId",initValue);
	}
	public SkuForm brandIdFieldOfProduct(){
		return brandIdFieldOfProduct("brandId","");
	}


	public SkuForm originFieldOfProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm originFieldOfProduct(String initValue){
		return originFieldOfProduct("origin",initValue);
	}
	public SkuForm originFieldOfProduct(){
		return originFieldOfProduct("origin","");
	}


	public SkuForm catalogIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm catalogIdFieldOfProduct(String initValue){
		return catalogIdFieldOfProduct("catalogId",initValue);
	}
	public SkuForm catalogIdFieldOfProduct(){
		return catalogIdFieldOfProduct("catalogId","");
	}


	public SkuForm remarkFieldOfProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm remarkFieldOfProduct(String initValue){
		return remarkFieldOfProduct("remark",initValue);
	}
	public SkuForm remarkFieldOfProduct(){
		return remarkFieldOfProduct("remark","");
	}


	public SkuForm lastUpdateTimeFieldOfProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm lastUpdateTimeFieldOfProduct(String initValue){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime",initValue);
	}
	public SkuForm lastUpdateTimeFieldOfProduct(){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime","");
	}

	


	

	
 	public SkuForm transferToAnotherProductAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProduct/skuId/");
		this.addFormAction(action);
		return this;
	}

 

	public SkuForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


