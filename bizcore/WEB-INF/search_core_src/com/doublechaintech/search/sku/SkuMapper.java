
package com.doublechaintech.search.sku;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.search.BaseRowMapper;
import com.doublechaintech.search.product.Product;

public class SkuMapper extends BaseRowMapper<Sku>{
	
	protected Sku internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Sku sku = getSku();		
		 		
 		setId(sku, rs, rowNumber); 		
 		setDisplayName(sku, rs, rowNumber); 		
 		setSize(sku, rs, rowNumber); 		
 		setProduct(sku, rs, rowNumber); 		
 		setActive(sku, rs, rowNumber); 		
 		setBasePrice(sku, rs, rowNumber); 		
 		setLastUpdateTime(sku, rs, rowNumber); 		
 		setVersion(sku, rs, rowNumber);

		return sku;
	}
	
	protected Sku getSku(){
		return new Sku();
	}		
		
	protected void setId(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SkuTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		sku.setId(id);
	}
		
	protected void setDisplayName(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String displayName = rs.getString(SkuTable.COLUMN_DISPLAY_NAME);
		if(displayName == null){
			//do nothing when nothing found in database
			return;
		}
		
		sku.setDisplayName(displayName);
	}
		
	protected void setSize(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String size = rs.getString(SkuTable.COLUMN_SIZE);
		if(size == null){
			//do nothing when nothing found in database
			return;
		}
		
		sku.setSize(size);
	}
		 		
 	protected void setProduct(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
 		String productId = rs.getString(SkuTable.COLUMN_PRODUCT);
 		if( productId == null){
 			return;
 		}
 		if( productId.isEmpty()){
 			return;
 		}
 		Product product = sku.getProduct();
 		if( product != null ){
 			//if the root object 'sku' already have the property, just set the id for it;
 			product.setId(productId);
 			
 			return;
 		}
 		sku.setProduct(createEmptyProduct(productId));
 	}
 	
	protected void setActive(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Boolean active = rs.getBoolean(SkuTable.COLUMN_ACTIVE);
		if(active == null){
			//do nothing when nothing found in database
			return;
		}
		
		sku.setActive(active);
	}
		
	protected void setBasePrice(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal basePrice = rs.getBigDecimal(SkuTable.COLUMN_BASE_PRICE);
		if(basePrice == null){
			//do nothing when nothing found in database
			return;
		}
		
		sku.setBasePrice(basePrice);
	}
		
	protected void setLastUpdateTime(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String lastUpdateTime = rs.getString(SkuTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		sku.setLastUpdateTime(lastUpdateTime);
	}
		
	protected void setVersion(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SkuTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		sku.setVersion(version);
	}
		
		

 	protected Product  createEmptyProduct(String productId){
 		Product product = new Product();
 		product.setId(productId);
 		product.setVersion(Integer.MAX_VALUE);
 		return product;
 	}
 	
}


