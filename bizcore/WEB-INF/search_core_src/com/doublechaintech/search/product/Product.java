
package com.doublechaintech.search.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.search.sku.Sku;
import com.doublechaintech.search.productrecommendation.ProductRecommendation;
import com.doublechaintech.search.levelncategory.LevelNCategory;
import com.doublechaintech.search.brand.Brand;
import com.doublechaintech.search.catalog.Catalog;

@JsonSerialize(using = ProductSerializer.class)
public class Product extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String BRAND_PROPERTY                 = "brand"             ;
	public static final String ORIGIN_PROPERTY                = "origin"            ;
	public static final String CATALOG_PROPERTY               = "catalog"           ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PRODUCT_RECOMMENDATION_LIST              = "productRecommendationList";
	public static final String SKU_LIST                                 = "skuList"           ;

	public static final String INTERNAL_TYPE="Product";
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
	protected		LevelNCategory      	mParentCategory     ;
	protected		Brand               	mBrand              ;
	protected		String              	mOrigin             ;
	protected		Catalog             	mCatalog            ;
	protected		String              	mRemark             ;
	protected		String              	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ProductRecommendation>	mProductRecommendationList;
	protected		SmartList<Sku>      	mSkuList            ;
	
		
	public 	Product(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setParentCategory( null );
		setBrand( null );
		setCatalog( null );

		this.changed = true;
	}
	
	public 	Product(String displayName, LevelNCategory parentCategory, Brand brand, String origin, Catalog catalog, String remark, String lastUpdateTime)
	{
		setDisplayName(displayName);
		setParentCategory(parentCategory);
		setBrand(brand);
		setOrigin(origin);
		setCatalog(catalog);
		setRemark(remark);
		setLastUpdateTime(lastUpdateTime);

		this.mProductRecommendationList = new SmartList<ProductRecommendation>();
		this.mSkuList = new SmartList<Sku>();	
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
	public Product updateId(String id){
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
	public Product updateDisplayName(String displayName){
		this.mDisplayName = trimString(displayName);;
		this.changed = true;
		return this;
	}
	
	
	public void setParentCategory(LevelNCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelNCategory getParentCategory(){
		return this.mParentCategory;
	}
	public Product updateParentCategory(LevelNCategory parentCategory){
		this.mParentCategory = parentCategory;;
		this.changed = true;
		return this;
	}
	
	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
	}
	
	public void setBrand(Brand brand){
		this.mBrand = brand;;
	}
	public Brand getBrand(){
		return this.mBrand;
	}
	public Product updateBrand(Brand brand){
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
	public Product updateOrigin(String origin){
		this.mOrigin = trimString(origin);;
		this.changed = true;
		return this;
	}
	
	
	public void setCatalog(Catalog catalog){
		this.mCatalog = catalog;;
	}
	public Catalog getCatalog(){
		return this.mCatalog;
	}
	public Product updateCatalog(Catalog catalog){
		this.mCatalog = catalog;;
		this.changed = true;
		return this;
	}
	
	
	public void clearCatalog(){
		setCatalog ( null );
		this.changed = true;
	}
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public Product updateRemark(String remark){
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
	public Product updateLastUpdateTime(String lastUpdateTime){
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
	public Product updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<ProductRecommendation> getProductRecommendationList(){
		if(this.mProductRecommendationList == null){
			this.mProductRecommendationList = new SmartList<ProductRecommendation>();
			this.mProductRecommendationList.setListInternalName (PRODUCT_RECOMMENDATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProductRecommendationList;	
	}
	public  void setProductRecommendationList(SmartList<ProductRecommendation> productRecommendationList){
		for( ProductRecommendation productRecommendation:productRecommendationList){
			productRecommendation.setProduct(this);
		}

		this.mProductRecommendationList = productRecommendationList;
		this.mProductRecommendationList.setListInternalName (PRODUCT_RECOMMENDATION_LIST );
		
	}
	
	public  void addProductRecommendation(ProductRecommendation productRecommendation){
		productRecommendation.setProduct(this);
		getProductRecommendationList().add(productRecommendation);
	}
	public  void addProductRecommendationList(SmartList<ProductRecommendation> productRecommendationList){
		for( ProductRecommendation productRecommendation:productRecommendationList){
			productRecommendation.setProduct(this);
		}
		getProductRecommendationList().addAll(productRecommendationList);
	}
	
	public  ProductRecommendation removeProductRecommendation(ProductRecommendation productRecommendationIndex){
		
		int index = getProductRecommendationList().indexOf(productRecommendationIndex);
        if(index < 0){
        	String message = "ProductRecommendation("+productRecommendationIndex.getId()+") with version='"+productRecommendationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ProductRecommendation productRecommendation = getProductRecommendationList().get(index);        
        // productRecommendation.clearProduct(); //disconnect with Product
        productRecommendation.clearFromAll(); //disconnect with Product
		
		boolean result = getProductRecommendationList().planToRemove(productRecommendation);
        if(!result){
        	String message = "ProductRecommendation("+productRecommendationIndex.getId()+") with version='"+productRecommendationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return productRecommendation;
        
	
	}
	//断舍离
	public  void breakWithProductRecommendation(ProductRecommendation productRecommendation){
		
		if(productRecommendation == null){
			return;
		}
		productRecommendation.setProduct(null);
		//getProductRecommendationList().remove();
	
	}
	
	public  boolean hasProductRecommendation(ProductRecommendation productRecommendation){
	
		return getProductRecommendationList().contains(productRecommendation);
  
	}
	
	public void copyProductRecommendationFrom(ProductRecommendation productRecommendation) {

		ProductRecommendation productRecommendationInList = findTheProductRecommendation(productRecommendation);
		ProductRecommendation newProductRecommendation = new ProductRecommendation();
		productRecommendationInList.copyTo(newProductRecommendation);
		newProductRecommendation.setVersion(0);//will trigger copy
		getProductRecommendationList().add(newProductRecommendation);
		addItemToFlexiableObject(COPIED_CHILD, newProductRecommendation);
	}
	
	public  ProductRecommendation findTheProductRecommendation(ProductRecommendation productRecommendation){
		
		int index =  getProductRecommendationList().indexOf(productRecommendation);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ProductRecommendation("+productRecommendation.getId()+") with version='"+productRecommendation.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProductRecommendationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProductRecommendationList(){
		getProductRecommendationList().clear();
	}
	
	
	


	public  SmartList<Sku> getSkuList(){
		if(this.mSkuList == null){
			this.mSkuList = new SmartList<Sku>();
			this.mSkuList.setListInternalName (SKU_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSkuList;	
	}
	public  void setSkuList(SmartList<Sku> skuList){
		for( Sku sku:skuList){
			sku.setProduct(this);
		}

		this.mSkuList = skuList;
		this.mSkuList.setListInternalName (SKU_LIST );
		
	}
	
	public  void addSku(Sku sku){
		sku.setProduct(this);
		getSkuList().add(sku);
	}
	public  void addSkuList(SmartList<Sku> skuList){
		for( Sku sku:skuList){
			sku.setProduct(this);
		}
		getSkuList().addAll(skuList);
	}
	
	public  Sku removeSku(Sku skuIndex){
		
		int index = getSkuList().indexOf(skuIndex);
        if(index < 0){
        	String message = "Sku("+skuIndex.getId()+") with version='"+skuIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Sku sku = getSkuList().get(index);        
        // sku.clearProduct(); //disconnect with Product
        sku.clearFromAll(); //disconnect with Product
		
		boolean result = getSkuList().planToRemove(sku);
        if(!result){
        	String message = "Sku("+skuIndex.getId()+") with version='"+skuIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return sku;
        
	
	}
	//断舍离
	public  void breakWithSku(Sku sku){
		
		if(sku == null){
			return;
		}
		sku.setProduct(null);
		//getSkuList().remove();
	
	}
	
	public  boolean hasSku(Sku sku){
	
		return getSkuList().contains(sku);
  
	}
	
	public void copySkuFrom(Sku sku) {

		Sku skuInList = findTheSku(sku);
		Sku newSku = new Sku();
		skuInList.copyTo(newSku);
		newSku.setVersion(0);//will trigger copy
		getSkuList().add(newSku);
		addItemToFlexiableObject(COPIED_CHILD, newSku);
	}
	
	public  Sku findTheSku(Sku sku){
		
		int index =  getSkuList().indexOf(sku);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Sku("+sku.getId()+") with version='"+sku.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSkuList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSkuList(){
		getSkuList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getParentCategory(), internalType);
		addToEntityList(this, entityList, getBrand(), internalType);
		addToEntityList(this, entityList, getCatalog(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProductRecommendationList(), internalType);
		collectFromList(this, entityList, getSkuList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getProductRecommendationList());
		listOfList.add( getSkuList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, DISPLAY_NAME_PROPERTY, getDisplayName());
		appendKeyValuePair(result, PARENT_CATEGORY_PROPERTY, getParentCategory());
		appendKeyValuePair(result, BRAND_PROPERTY, getBrand());
		appendKeyValuePair(result, ORIGIN_PROPERTY, getOrigin());
		appendKeyValuePair(result, CATALOG_PROPERTY, getCatalog());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PRODUCT_RECOMMENDATION_LIST, getProductRecommendationList());
		if(!getProductRecommendationList().isEmpty()){
			appendKeyValuePair(result, "productRecommendationCount", getProductRecommendationList().getTotalCount());
			appendKeyValuePair(result, "productRecommendationCurrentPageNumber", getProductRecommendationList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SKU_LIST, getSkuList());
		if(!getSkuList().isEmpty()){
			appendKeyValuePair(result, "skuCount", getSkuList().getTotalCount());
			appendKeyValuePair(result, "skuCurrentPageNumber", getSkuList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Product){
		
		
			Product dest =(Product)baseDest;
		
			dest.setId(getId());
			dest.setDisplayName(getDisplayName());
			dest.setParentCategory(getParentCategory());
			dest.setBrand(getBrand());
			dest.setOrigin(getOrigin());
			dest.setCatalog(getCatalog());
			dest.setRemark(getRemark());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setProductRecommendationList(getProductRecommendationList());
			dest.setSkuList(getSkuList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Product{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tdisplayName='"+getDisplayName()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparentCategory='LevelNCategory("+getParentCategory().getId()+")';");
 		}
		if(getBrand() != null ){
 			stringBuilder.append("\tbrand='Brand("+getBrand().getId()+")';");
 		}
		stringBuilder.append("\torigin='"+getOrigin()+"';");
		if(getCatalog() != null ){
 			stringBuilder.append("\tcatalog='Catalog("+getCatalog().getId()+")';");
 		}
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

