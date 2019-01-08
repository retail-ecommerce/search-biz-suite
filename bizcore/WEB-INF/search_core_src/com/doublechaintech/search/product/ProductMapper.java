
package com.doublechaintech.search.product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.search.BaseRowMapper;
import com.doublechaintech.search.levelncategory.LevelNCategory;
import com.doublechaintech.search.brand.Brand;
import com.doublechaintech.search.catalog.Catalog;

public class ProductMapper extends BaseRowMapper<Product>{
	
	protected Product internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Product product = getProduct();		
		 		
 		setId(product, rs, rowNumber); 		
 		setDisplayName(product, rs, rowNumber); 		
 		setParentCategory(product, rs, rowNumber); 		
 		setBrand(product, rs, rowNumber); 		
 		setOrigin(product, rs, rowNumber); 		
 		setCatalog(product, rs, rowNumber); 		
 		setRemark(product, rs, rowNumber); 		
 		setLastUpdateTime(product, rs, rowNumber); 		
 		setVersion(product, rs, rowNumber);

		return product;
	}
	
	protected Product getProduct(){
		return new Product();
	}		
		
	protected void setId(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ProductTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setId(id);
	}
		
	protected void setDisplayName(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String displayName = rs.getString(ProductTable.COLUMN_DISPLAY_NAME);
		if(displayName == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setDisplayName(displayName);
	}
		 		
 	protected void setParentCategory(Product product, ResultSet rs, int rowNumber) throws SQLException{
 		String levelNCategoryId = rs.getString(ProductTable.COLUMN_PARENT_CATEGORY);
 		if( levelNCategoryId == null){
 			return;
 		}
 		if( levelNCategoryId.isEmpty()){
 			return;
 		}
 		LevelNCategory levelNCategory = product.getParentCategory();
 		if( levelNCategory != null ){
 			//if the root object 'product' already have the property, just set the id for it;
 			levelNCategory.setId(levelNCategoryId);
 			
 			return;
 		}
 		product.setParentCategory(createEmptyParentCategory(levelNCategoryId));
 	}
 	 		
 	protected void setBrand(Product product, ResultSet rs, int rowNumber) throws SQLException{
 		String brandId = rs.getString(ProductTable.COLUMN_BRAND);
 		if( brandId == null){
 			return;
 		}
 		if( brandId.isEmpty()){
 			return;
 		}
 		Brand brand = product.getBrand();
 		if( brand != null ){
 			//if the root object 'product' already have the property, just set the id for it;
 			brand.setId(brandId);
 			
 			return;
 		}
 		product.setBrand(createEmptyBrand(brandId));
 	}
 	
	protected void setOrigin(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String origin = rs.getString(ProductTable.COLUMN_ORIGIN);
		if(origin == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setOrigin(origin);
	}
		 		
 	protected void setCatalog(Product product, ResultSet rs, int rowNumber) throws SQLException{
 		String catalogId = rs.getString(ProductTable.COLUMN_CATALOG);
 		if( catalogId == null){
 			return;
 		}
 		if( catalogId.isEmpty()){
 			return;
 		}
 		Catalog catalog = product.getCatalog();
 		if( catalog != null ){
 			//if the root object 'product' already have the property, just set the id for it;
 			catalog.setId(catalogId);
 			
 			return;
 		}
 		product.setCatalog(createEmptyCatalog(catalogId));
 	}
 	
	protected void setRemark(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(ProductTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setRemark(remark);
	}
		
	protected void setLastUpdateTime(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String lastUpdateTime = rs.getString(ProductTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setLastUpdateTime(lastUpdateTime);
	}
		
	protected void setVersion(Product product, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ProductTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		product.setVersion(version);
	}
		
		

 	protected LevelNCategory  createEmptyParentCategory(String levelNCategoryId){
 		LevelNCategory levelNCategory = new LevelNCategory();
 		levelNCategory.setId(levelNCategoryId);
 		levelNCategory.setVersion(Integer.MAX_VALUE);
 		return levelNCategory;
 	}
 	
 	protected Brand  createEmptyBrand(String brandId){
 		Brand brand = new Brand();
 		brand.setId(brandId);
 		brand.setVersion(Integer.MAX_VALUE);
 		return brand;
 	}
 	
 	protected Catalog  createEmptyCatalog(String catalogId){
 		Catalog catalog = new Catalog();
 		catalog.setId(catalogId);
 		catalog.setVersion(Integer.MAX_VALUE);
 		return catalog;
 	}
 	
}


