
package com.doublechaintech.search.sku;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.search.product.Product;

@JsonSerialize(using = SkuSerializer.class)
public class Sku extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SIZE_PROPERTY                  = "size"              ;
	public static final String PRODUCT_PROPERTY               = "product"           ;
	public static final String ACTIVE_PROPERTY                = "active"            ;
	public static final String BASE_PRICE_PROPERTY            = "basePrice"         ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Sku";
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
	protected		String              	mSize               ;
	protected		Product             	mProduct            ;
	protected		boolean             	mActive             ;
	protected		BigDecimal          	mBasePrice          ;
	protected		String              	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Sku(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProduct( null );

		this.changed = true;
	}
	
	public 	Sku(String name, String size, Product product, boolean active, BigDecimal basePrice, String lastUpdateTime)
	{
		setName(name);
		setSize(size);
		setProduct(product);
		setActive(active);
		setBasePrice(basePrice);
		setLastUpdateTime(lastUpdateTime);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SIZE_PROPERTY.equals(property)){
			changeSizeProperty(newValueExpr);
		}
		if(ACTIVE_PROPERTY.equals(property)){
			changeActiveProperty(newValueExpr);
		}
		if(BASE_PRICE_PROPERTY.equals(property)){
			changeBasePriceProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeSizeProperty(String newValueExpr){
		String oldValue = getSize();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSize(newValue);
		this.onChangeProperty(SIZE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeActiveProperty(String newValueExpr){
		boolean oldValue = getActive();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateActive(newValue);
		this.onChangeProperty(ACTIVE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeBasePriceProperty(String newValueExpr){
		BigDecimal oldValue = getBasePrice();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBasePrice(newValue);
		this.onChangeProperty(BASE_PRICE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
		String oldValue = getLastUpdateTime();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Sku updateId(String id){
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
	public Sku updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setSize(String size){
		this.mSize = trimString(size);;
	}
	public String getSize(){
		return this.mSize;
	}
	public Sku updateSize(String size){
		this.mSize = trimString(size);;
		this.changed = true;
		return this;
	}
	
	
	public void setProduct(Product product){
		this.mProduct = product;;
	}
	public Product getProduct(){
		return this.mProduct;
	}
	public Sku updateProduct(Product product){
		this.mProduct = product;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProduct(){
		setProduct ( null );
		this.changed = true;
	}
	
	public void setActive(boolean active){
		this.mActive = active;;
	}
	public boolean getActive(){
		return this.mActive;
	}
	public Sku updateActive(boolean active){
		this.mActive = active;;
		this.changed = true;
		return this;
	}
	
	
	public void setBasePrice(BigDecimal basePrice){
		this.mBasePrice = basePrice;;
	}
	public BigDecimal getBasePrice(){
		return this.mBasePrice;
	}
	public Sku updateBasePrice(BigDecimal basePrice){
		this.mBasePrice = basePrice;;
		this.changed = true;
		return this;
	}
	
	
	public void setLastUpdateTime(String lastUpdateTime){
		this.mLastUpdateTime = trimString(lastUpdateTime);;
	}
	public String getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public Sku updateLastUpdateTime(String lastUpdateTime){
		this.mLastUpdateTime = trimString(lastUpdateTime);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Sku updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProduct(), internalType);

		
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
		appendKeyValuePair(result, SIZE_PROPERTY, getSize());
		appendKeyValuePair(result, PRODUCT_PROPERTY, getProduct());
		appendKeyValuePair(result, ACTIVE_PROPERTY, getActive());
		appendKeyValuePair(result, BASE_PRICE_PROPERTY, getBasePrice());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Sku){
		
		
			Sku dest =(Sku)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setSize(getSize());
			dest.setProduct(getProduct());
			dest.setActive(getActive());
			dest.setBasePrice(getBasePrice());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Sku{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tsize='"+getSize()+"';");
		if(getProduct() != null ){
 			stringBuilder.append("\tproduct='Product("+getProduct().getId()+")';");
 		}
		stringBuilder.append("\tactive='"+getActive()+"';");
		stringBuilder.append("\tbasePrice='"+getBasePrice()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

