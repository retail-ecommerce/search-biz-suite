
package com.doublechaintech.search.productrecommendation;

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
import com.doublechaintech.search.brand.Brand;

@JsonSerialize(using = ProductRecommendationSerializer.class)
public class ProductRecommendation extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String BRAND_PROPERTY                 = "brand"             ;
	public static final String ORIGIN_PROPERTY                = "origin"            ;
	public static final String PRODUCT_PROPERTY               = "product"           ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ProductRecommendation";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getDisplayName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mDisplayName        ;
	protected		Brand               	mBrand              ;
	protected		String              	mOrigin             ;
	protected		Product             	mProduct            ;
	protected		String              	mRemark             ;
	protected		String              	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ProductRecommendation(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBrand( null );
		setProduct( null );

		this.changed = true;
	}
	
	public 	ProductRecommendation(String displayName, Brand brand, String origin, Product product, String remark, String lastUpdateTime)
	{
		setDisplayName(displayName);
		setBrand(brand);
		setOrigin(origin);
		setProduct(product);
		setRemark(remark);
		setLastUpdateTime(lastUpdateTime);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(DISPLAY_NAME_PROPERTY.equals(property)){
			changeDisplayNameProperty(newValueExpr);
		}
		if(ORIGIN_PROPERTY.equals(property)){
			changeOriginProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeDisplayNameProperty(String newValueExpr){
		String oldValue = getDisplayName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDisplayName(newValue);
		this.onChangeProperty(DISPLAY_NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOriginProperty(String newValueExpr){
		String oldValue = getOrigin();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOrigin(newValue);
		this.onChangeProperty(ORIGIN_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeRemarkProperty(String newValueExpr){
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemark(newValue);
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
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
	public ProductRecommendation updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setDisplayName(String displayName){
		this.mDisplayName = trimString(displayName);;
	}
	public String getDisplayName(){
		return this.mDisplayName;
	}
	public ProductRecommendation updateDisplayName(String displayName){
		this.mDisplayName = trimString(displayName);;
		this.changed = true;
		return this;
	}
	
	
	public void setBrand(Brand brand){
		this.mBrand = brand;;
	}
	public Brand getBrand(){
		return this.mBrand;
	}
	public ProductRecommendation updateBrand(Brand brand){
		this.mBrand = brand;;
		this.changed = true;
		return this;
	}
	
	
	public void clearBrand(){
		setBrand ( null );
		this.changed = true;
	}
	
	public void setOrigin(String origin){
		this.mOrigin = trimString(origin);;
	}
	public String getOrigin(){
		return this.mOrigin;
	}
	public ProductRecommendation updateOrigin(String origin){
		this.mOrigin = trimString(origin);;
		this.changed = true;
		return this;
	}
	
	
	public void setProduct(Product product){
		this.mProduct = product;;
	}
	public Product getProduct(){
		return this.mProduct;
	}
	public ProductRecommendation updateProduct(Product product){
		this.mProduct = product;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProduct(){
		setProduct ( null );
		this.changed = true;
	}
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public ProductRecommendation updateRemark(String remark){
		this.mRemark = trimString(remark);;
		this.changed = true;
		return this;
	}
	
	
	public void setLastUpdateTime(String lastUpdateTime){
		this.mLastUpdateTime = trimString(lastUpdateTime);;
	}
	public String getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public ProductRecommendation updateLastUpdateTime(String lastUpdateTime){
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
	public ProductRecommendation updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBrand(), internalType);
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
		appendKeyValuePair(result, DISPLAY_NAME_PROPERTY, getDisplayName());
		appendKeyValuePair(result, BRAND_PROPERTY, getBrand());
		appendKeyValuePair(result, ORIGIN_PROPERTY, getOrigin());
		appendKeyValuePair(result, PRODUCT_PROPERTY, getProduct());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ProductRecommendation){
		
		
			ProductRecommendation dest =(ProductRecommendation)baseDest;
		
			dest.setId(getId());
			dest.setDisplayName(getDisplayName());
			dest.setBrand(getBrand());
			dest.setOrigin(getOrigin());
			dest.setProduct(getProduct());
			dest.setRemark(getRemark());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ProductRecommendation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tdisplayName='"+getDisplayName()+"';");
		if(getBrand() != null ){
 			stringBuilder.append("\tbrand='Brand("+getBrand().getId()+")';");
 		}
		stringBuilder.append("\torigin='"+getOrigin()+"';");
		if(getProduct() != null ){
 			stringBuilder.append("\tproduct='Product("+getProduct().getId()+")';");
 		}
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

