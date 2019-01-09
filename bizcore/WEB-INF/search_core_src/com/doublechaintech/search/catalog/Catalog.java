
package com.doublechaintech.search.catalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.search.levelonecategory.LevelOneCategory;
import com.doublechaintech.search.product.Product;
import com.doublechaintech.search.site.Site;

@JsonSerialize(using = CatalogSerializer.class)
public class Catalog extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SELLER_ID_PROPERTY             = "sellerId"          ;
	public static final String SITE_PROPERTY                  = "site"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_ONE_CATEGORY_LIST                  = "levelOneCategoryList";
	public static final String PRODUCT_LIST                             = "productList"       ;

	public static final String INTERNAL_TYPE="Catalog";
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
	protected		String              	mSellerId           ;
	protected		Site                	mSite               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelOneCategory>	mLevelOneCategoryList;
	protected		SmartList<Product>  	mProductList        ;
	
		
	public 	Catalog(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSite( null );

		this.changed = true;
	}
	
	public 	Catalog(String name, String sellerId, Site site)
	{
		setName(name);
		setSellerId(sellerId);
		setSite(site);

		this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();
		this.mProductList = new SmartList<Product>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SELLER_ID_PROPERTY.equals(property)){
			changeSellerIdProperty(newValueExpr);
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
			
			
			
	protected void changeSellerIdProperty(String newValueExpr){
		String oldValue = getSellerId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSellerId(newValue);
		this.onChangeProperty(SELLER_ID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Catalog updateId(String id){
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
	public Catalog updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setSellerId(String sellerId){
		this.mSellerId = trimString(sellerId);;
	}
	public String getSellerId(){
		return this.mSellerId;
	}
	public Catalog updateSellerId(String sellerId){
		this.mSellerId = trimString(sellerId);;
		this.changed = true;
		return this;
	}
	
	
	public void clearSellerId(){
		setSellerId ( null );
		this.changed = true;
	}
	
	public void setSite(Site site){
		this.mSite = site;;
	}
	public Site getSite(){
		return this.mSite;
	}
	public Catalog updateSite(Site site){
		this.mSite = site;;
		this.changed = true;
		return this;
	}
	
	
	public void clearSite(){
		setSite ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Catalog updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<LevelOneCategory> getLevelOneCategoryList(){
		if(this.mLevelOneCategoryList == null){
			this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();
			this.mLevelOneCategoryList.setListInternalName (LEVEL_ONE_CATEGORY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelOneCategoryList;	
	}
	public  void setLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList){
		for( LevelOneCategory levelOneCategory:levelOneCategoryList){
			levelOneCategory.setCatalog(this);
		}

		this.mLevelOneCategoryList = levelOneCategoryList;
		this.mLevelOneCategoryList.setListInternalName (LEVEL_ONE_CATEGORY_LIST );
		
	}
	
	public  void addLevelOneCategory(LevelOneCategory levelOneCategory){
		levelOneCategory.setCatalog(this);
		getLevelOneCategoryList().add(levelOneCategory);
	}
	public  void addLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList){
		for( LevelOneCategory levelOneCategory:levelOneCategoryList){
			levelOneCategory.setCatalog(this);
		}
		getLevelOneCategoryList().addAll(levelOneCategoryList);
	}
	
	public  LevelOneCategory removeLevelOneCategory(LevelOneCategory levelOneCategoryIndex){
		
		int index = getLevelOneCategoryList().indexOf(levelOneCategoryIndex);
        if(index < 0){
        	String message = "LevelOneCategory("+levelOneCategoryIndex.getId()+") with version='"+levelOneCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelOneCategory levelOneCategory = getLevelOneCategoryList().get(index);        
        // levelOneCategory.clearCatalog(); //disconnect with Catalog
        levelOneCategory.clearFromAll(); //disconnect with Catalog
		
		boolean result = getLevelOneCategoryList().planToRemove(levelOneCategory);
        if(!result){
        	String message = "LevelOneCategory("+levelOneCategoryIndex.getId()+") with version='"+levelOneCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelOneCategory;
        
	
	}
	//断舍离
	public  void breakWithLevelOneCategory(LevelOneCategory levelOneCategory){
		
		if(levelOneCategory == null){
			return;
		}
		levelOneCategory.setCatalog(null);
		//getLevelOneCategoryList().remove();
	
	}
	
	public  boolean hasLevelOneCategory(LevelOneCategory levelOneCategory){
	
		return getLevelOneCategoryList().contains(levelOneCategory);
  
	}
	
	public void copyLevelOneCategoryFrom(LevelOneCategory levelOneCategory) {

		LevelOneCategory levelOneCategoryInList = findTheLevelOneCategory(levelOneCategory);
		LevelOneCategory newLevelOneCategory = new LevelOneCategory();
		levelOneCategoryInList.copyTo(newLevelOneCategory);
		newLevelOneCategory.setVersion(0);//will trigger copy
		getLevelOneCategoryList().add(newLevelOneCategory);
		addItemToFlexiableObject(COPIED_CHILD, newLevelOneCategory);
	}
	
	public  LevelOneCategory findTheLevelOneCategory(LevelOneCategory levelOneCategory){
		
		int index =  getLevelOneCategoryList().indexOf(levelOneCategory);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelOneCategory("+levelOneCategory.getId()+") with version='"+levelOneCategory.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelOneCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelOneCategoryList(){
		getLevelOneCategoryList().clear();
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
			product.setCatalog(this);
		}

		this.mProductList = productList;
		this.mProductList.setListInternalName (PRODUCT_LIST );
		
	}
	
	public  void addProduct(Product product){
		product.setCatalog(this);
		getProductList().add(product);
	}
	public  void addProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setCatalog(this);
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
        // product.clearCatalog(); //disconnect with Catalog
        product.clearFromAll(); //disconnect with Catalog
		
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
		product.setCatalog(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getSite(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLevelOneCategoryList(), internalType);
		collectFromList(this, entityList, getProductList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLevelOneCategoryList());
		listOfList.add( getProductList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, SELLER_ID_PROPERTY, getSellerId());
		appendKeyValuePair(result, SITE_PROPERTY, getSite());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEVEL_ONE_CATEGORY_LIST, getLevelOneCategoryList());
		if(!getLevelOneCategoryList().isEmpty()){
			appendKeyValuePair(result, "levelOneCategoryCount", getLevelOneCategoryList().getTotalCount());
			appendKeyValuePair(result, "levelOneCategoryCurrentPageNumber", getLevelOneCategoryList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PRODUCT_LIST, getProductList());
		if(!getProductList().isEmpty()){
			appendKeyValuePair(result, "productCount", getProductList().getTotalCount());
			appendKeyValuePair(result, "productCurrentPageNumber", getProductList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Catalog){
		
		
			Catalog dest =(Catalog)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setSellerId(getSellerId());
			dest.setSite(getSite());
			dest.setVersion(getVersion());
			dest.setLevelOneCategoryList(getLevelOneCategoryList());
			dest.setProductList(getProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Catalog{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tsellerId='"+getSellerId()+"';");
		if(getSite() != null ){
 			stringBuilder.append("\tsite='Site("+getSite().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

