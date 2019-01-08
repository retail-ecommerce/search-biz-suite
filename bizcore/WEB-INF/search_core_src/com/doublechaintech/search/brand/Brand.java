
package com.doublechaintech.search.brand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.search.productrecommendation.ProductRecommendation;
import com.doublechaintech.search.product.Product;

@JsonSerialize(using = BrandSerializer.class)
public class Brand extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BRAND_NAME_PROPERTY            = "brandName"         ;
	public static final String LOGO_PROPERTY                  = "logo"              ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PRODUCT_LIST                             = "productList"       ;
	public static final String PRODUCT_RECOMMENDATION_LIST              = "productRecommendationList";

	public static final String INTERNAL_TYPE="Brand";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getBrandName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mBrandName          ;
	protected		String              	mLogo               ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Product>  	mProductList        ;
	protected		SmartList<ProductRecommendation>	mProductRecommendationList;
	
		
	public 	Brand(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Brand(String brandName, String logo, String remark)
	{
		setBrandName(brandName);
		setLogo(logo);
		setRemark(remark);

		this.mProductList = new SmartList<Product>();
		this.mProductRecommendationList = new SmartList<ProductRecommendation>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(BRAND_NAME_PROPERTY.equals(property)){
			changeBrandNameProperty(newValueExpr);
		}
		if(LOGO_PROPERTY.equals(property)){
			changeLogoProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeBrandNameProperty(String newValueExpr){
		String oldValue = getBrandName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBrandName(newValue);
		this.onChangeProperty(BRAND_NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLogoProperty(String newValueExpr){
		String oldValue = getLogo();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLogo(newValue);
		this.onChangeProperty(LOGO_PROPERTY, oldValue, newValue);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Brand updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setBrandName(String brandName){
		this.mBrandName = trimString(brandName);;
	}
	public String getBrandName(){
		return this.mBrandName;
	}
	public Brand updateBrandName(String brandName){
		this.mBrandName = trimString(brandName);;
		this.changed = true;
		return this;
	}
	
	
	public void setLogo(String logo){
		this.mLogo = trimString(encodeUrl(logo));;
	}
	public String getLogo(){
		return this.mLogo;
	}
	public Brand updateLogo(String logo){
		this.mLogo = trimString(encodeUrl(logo));;
		this.changed = true;
		return this;
	}
	
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public Brand updateRemark(String remark){
		this.mRemark = trimString(remark);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Brand updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<Product> getProductList(){
		if(this.mProductList == null){
			this.mProductList = new SmartList<Product>();
			this.mProductList.setListInternalName (PRODUCT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProductList;	
	}
	public  void setProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setBrand(this);
		}

		this.mProductList = productList;
		this.mProductList.setListInternalName (PRODUCT_LIST );
		
	}
	
	public  void addProduct(Product product){
		product.setBrand(this);
		getProductList().add(product);
	}
	public  void addProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setBrand(this);
		}
		getProductList().addAll(productList);
	}
	
	public  Product removeProduct(Product productIndex){
		
		int index = getProductList().indexOf(productIndex);
        if(index < 0){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Product product = getProductList().get(index);        
        // product.clearBrand(); //disconnect with Brand
        product.clearFromAll(); //disconnect with Brand
		
		boolean result = getProductList().planToRemove(product);
        if(!result){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return product;
        
	
	}
	//断舍离
	public  void breakWithProduct(Product product){
		
		if(product == null){
			return;
		}
		product.setBrand(null);
		//getProductList().remove();
	
	}
	
	public  boolean hasProduct(Product product){
	
		return getProductList().contains(product);
  
	}
	
	public void copyProductFrom(Product product) {

		Product productInList = findTheProduct(product);
		Product newProduct = new Product();
		productInList.copyTo(newProduct);
		newProduct.setVersion(0);//will trigger copy
		getProductList().add(newProduct);
		addItemToFlexiableObject(COPIED_CHILD, newProduct);
	}
	
	public  Product findTheProduct(Product product){
		
		int index =  getProductList().indexOf(product);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Product("+product.getId()+") with version='"+product.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProductList(){
		getProductList().clear();
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
			productRecommendation.setBrand(this);
		}

		this.mProductRecommendationList = productRecommendationList;
		this.mProductRecommendationList.setListInternalName (PRODUCT_RECOMMENDATION_LIST );
		
	}
	
	public  void addProductRecommendation(ProductRecommendation productRecommendation){
		productRecommendation.setBrand(this);
		getProductRecommendationList().add(productRecommendation);
	}
	public  void addProductRecommendationList(SmartList<ProductRecommendation> productRecommendationList){
		for( ProductRecommendation productRecommendation:productRecommendationList){
			productRecommendation.setBrand(this);
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
        // productRecommendation.clearBrand(); //disconnect with Brand
        productRecommendation.clearFromAll(); //disconnect with Brand
		
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
		productRecommendation.setBrand(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProductList(), internalType);
		collectFromList(this, entityList, getProductRecommendationList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getProductList());
		listOfList.add( getProductRecommendationList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, BRAND_NAME_PROPERTY, getBrandName());
		appendKeyValuePair(result, LOGO_PROPERTY, getLogo());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PRODUCT_LIST, getProductList());
		if(!getProductList().isEmpty()){
			appendKeyValuePair(result, "productCount", getProductList().getTotalCount());
			appendKeyValuePair(result, "productCurrentPageNumber", getProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PRODUCT_RECOMMENDATION_LIST, getProductRecommendationList());
		if(!getProductRecommendationList().isEmpty()){
			appendKeyValuePair(result, "productRecommendationCount", getProductRecommendationList().getTotalCount());
			appendKeyValuePair(result, "productRecommendationCurrentPageNumber", getProductRecommendationList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Brand){
		
		
			Brand dest =(Brand)baseDest;
		
			dest.setId(getId());
			dest.setBrandName(getBrandName());
			dest.setLogo(getLogo());
			dest.setRemark(getRemark());
			dest.setVersion(getVersion());
			dest.setProductList(getProductList());
			dest.setProductRecommendationList(getProductRecommendationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Brand{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tbrandName='"+getBrandName()+"';");
		stringBuilder.append("\tlogo='"+getLogo()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

