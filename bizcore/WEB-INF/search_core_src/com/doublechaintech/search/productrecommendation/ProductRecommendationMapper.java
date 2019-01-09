
package com.doublechaintech.search.productrecommendation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.search.BaseRowMapper;
import com.doublechaintech.search.product.Product;
import com.doublechaintech.search.brand.Brand;

public class ProductRecommendationMapper extends BaseRowMapper<ProductRecommendation>{
	
	protected ProductRecommendation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ProductRecommendation productRecommendation = getProductRecommendation();		
		 		
 		setId(productRecommendation, rs, rowNumber); 		
 		setName(productRecommendation, rs, rowNumber); 		
 		setBrand(productRecommendation, rs, rowNumber); 		
 		setOrigin(productRecommendation, rs, rowNumber); 		
 		setProduct(productRecommendation, rs, rowNumber); 		
 		setRemark(productRecommendation, rs, rowNumber); 		
 		setLastUpdateTime(productRecommendation, rs, rowNumber); 		
 		setVersion(productRecommendation, rs, rowNumber);

		return productRecommendation;
	}
	
	protected ProductRecommendation getProductRecommendation(){
		return new ProductRecommendation();
	}		
		
	protected void setId(ProductRecommendation productRecommendation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ProductRecommendationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		productRecommendation.setId(id);
	}
		
	protected void setName(ProductRecommendation productRecommendation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ProductRecommendationTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		productRecommendation.setName(name);
	}
		 		
 	protected void setBrand(ProductRecommendation productRecommendation, ResultSet rs, int rowNumber) throws SQLException{
 		String brandId = rs.getString(ProductRecommendationTable.COLUMN_BRAND);
 		if( brandId == null){
 			return;
 		}
 		if( brandId.isEmpty()){
 			return;
 		}
 		Brand brand = productRecommendation.getBrand();
 		if( brand != null ){
 			//if the root object 'productRecommendation' already have the property, just set the id for it;
 			brand.setId(brandId);
 			
 			return;
 		}
 		productRecommendation.setBrand(createEmptyBrand(brandId));
 	}
 	
	protected void setOrigin(ProductRecommendation productRecommendation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String origin = rs.getString(ProductRecommendationTable.COLUMN_ORIGIN);
		if(origin == null){
			//do nothing when nothing found in database
			return;
		}
		
		productRecommendation.setOrigin(origin);
	}
		 		
 	protected void setProduct(ProductRecommendation productRecommendation, ResultSet rs, int rowNumber) throws SQLException{
 		String productId = rs.getString(ProductRecommendationTable.COLUMN_PRODUCT);
 		if( productId == null){
 			return;
 		}
 		if( productId.isEmpty()){
 			return;
 		}
 		Product product = productRecommendation.getProduct();
 		if( product != null ){
 			//if the root object 'productRecommendation' already have the property, just set the id for it;
 			product.setId(productId);
 			
 			return;
 		}
 		productRecommendation.setProduct(createEmptyProduct(productId));
 	}
 	
	protected void setRemark(ProductRecommendation productRecommendation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(ProductRecommendationTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		productRecommendation.setRemark(remark);
	}
		
	protected void setLastUpdateTime(ProductRecommendation productRecommendation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String lastUpdateTime = rs.getString(ProductRecommendationTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		productRecommendation.setLastUpdateTime(lastUpdateTime);
	}
		
	protected void setVersion(ProductRecommendation productRecommendation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ProductRecommendationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		productRecommendation.setVersion(version);
	}
		
		

 	protected Brand  createEmptyBrand(String brandId){
 		Brand brand = new Brand();
 		brand.setId(brandId);
 		brand.setVersion(Integer.MAX_VALUE);
 		return brand;
 	}
 	
 	protected Product  createEmptyProduct(String productId){
 		Product product = new Product();
 		product.setId(productId);
 		product.setVersion(Integer.MAX_VALUE);
 		return product;
 	}
 	
}


