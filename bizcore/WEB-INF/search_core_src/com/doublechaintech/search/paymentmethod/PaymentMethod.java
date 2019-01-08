
package com.doublechaintech.search.paymentmethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = PaymentMethodSerializer.class)
public class PaymentMethod extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String LINE1_PROPERTY                 = "line1"             ;
	public static final String LINE2_PROPERTY                 = "line2"             ;
	public static final String CITY_PROPERTY                  = "city"              ;
	public static final String EXPIRE_ON_PROPERTY             = "expireOn"          ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="PaymentMethod";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mNumber             ;
	protected		String              	mLine1              ;
	protected		String              	mLine2              ;
	protected		String              	mCity               ;
	protected		Date                	mExpireOn           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	PaymentMethod(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	PaymentMethod(String name, String number, String line1, String line2, String city, Date expireOn)
	{
		setName(name);
		setNumber(number);
		setLine1(line1);
		setLine2(line2);
		setCity(city);
		setExpireOn(expireOn);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(NUMBER_PROPERTY.equals(property)){
			changeNumberProperty(newValueExpr);
		}
		if(LINE1_PROPERTY.equals(property)){
			changeLine1Property(newValueExpr);
		}
		if(LINE2_PROPERTY.equals(property)){
			changeLine2Property(newValueExpr);
		}
		if(CITY_PROPERTY.equals(property)){
			changeCityProperty(newValueExpr);
		}
		if(EXPIRE_ON_PROPERTY.equals(property)){
			changeExpireOnProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeNumberProperty(String newValueExpr){
		String oldValue = getNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateNumber(newValue);
		this.onChangeProperty(NUMBER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLine1Property(String newValueExpr){
		String oldValue = getLine1();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLine1(newValue);
		this.onChangeProperty(LINE1_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLine2Property(String newValueExpr){
		String oldValue = getLine2();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLine2(newValue);
		this.onChangeProperty(LINE2_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCityProperty(String newValueExpr){
		String oldValue = getCity();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCity(newValue);
		this.onChangeProperty(CITY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeExpireOnProperty(String newValueExpr){
		Date oldValue = getExpireOn();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateExpireOn(newValue);
		this.onChangeProperty(EXPIRE_ON_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public PaymentMethod updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public PaymentMethod updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setNumber(String number){
		this.mNumber = trimString(number);;
	}
	public String getNumber(){
		return this.mNumber;
	}
	public PaymentMethod updateNumber(String number){
		this.mNumber = trimString(number);;
		this.changed = true;
		return this;
	}
	
	
	public void setLine1(String line1){
		this.mLine1 = trimString(line1);;
	}
	public String getLine1(){
		return this.mLine1;
	}
	public PaymentMethod updateLine1(String line1){
		this.mLine1 = trimString(line1);;
		this.changed = true;
		return this;
	}
	
	
	public void setLine2(String line2){
		this.mLine2 = trimString(line2);;
	}
	public String getLine2(){
		return this.mLine2;
	}
	public PaymentMethod updateLine2(String line2){
		this.mLine2 = trimString(line2);;
		this.changed = true;
		return this;
	}
	
	
	public void setCity(String city){
		this.mCity = trimString(city);;
	}
	public String getCity(){
		return this.mCity;
	}
	public PaymentMethod updateCity(String city){
		this.mCity = trimString(city);;
		this.changed = true;
		return this;
	}
	
	
	public void setExpireOn(Date expireOn){
		this.mExpireOn = expireOn;;
	}
	public Date getExpireOn(){
		return this.mExpireOn;
	}
	public PaymentMethod updateExpireOn(Date expireOn){
		this.mExpireOn = expireOn;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public PaymentMethod updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, NUMBER_PROPERTY, getNumber());
		appendKeyValuePair(result, LINE1_PROPERTY, getLine1());
		appendKeyValuePair(result, LINE2_PROPERTY, getLine2());
		appendKeyValuePair(result, CITY_PROPERTY, getCity());
		appendKeyValuePair(result, EXPIRE_ON_PROPERTY, getExpireOn());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PaymentMethod){
		
		
			PaymentMethod dest =(PaymentMethod)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setNumber(getNumber());
			dest.setLine1(getLine1());
			dest.setLine2(getLine2());
			dest.setCity(getCity());
			dest.setExpireOn(getExpireOn());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PaymentMethod{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tline1='"+getLine1()+"';");
		stringBuilder.append("\tline2='"+getLine2()+"';");
		stringBuilder.append("\tcity='"+getCity()+"';");
		stringBuilder.append("\texpireOn='"+getExpireOn()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

