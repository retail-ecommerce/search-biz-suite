
package com.doublechaintech.search.brand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.search.BaseRowMapper;

public class BrandMapper extends BaseRowMapper<Brand>{
	
	protected Brand internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Brand brand = getBrand();		
		 		
 		setId(brand, rs, rowNumber); 		
 		setBrandName(brand, rs, rowNumber); 		
 		setLogo(brand, rs, rowNumber); 		
 		setRemark(brand, rs, rowNumber); 		
 		setVersion(brand, rs, rowNumber);

		return brand;
	}
	
	protected Brand getBrand(){
		return new Brand();
	}		
		
	protected void setId(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(BrandTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setId(id);
	}
		
	protected void setBrandName(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String brandName = rs.getString(BrandTable.COLUMN_BRAND_NAME);
		if(brandName == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setBrandName(brandName);
	}
		
	protected void setLogo(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String logo = rs.getString(BrandTable.COLUMN_LOGO);
		if(logo == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setLogo(logo);
	}
		
	protected void setRemark(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remark = rs.getString(BrandTable.COLUMN_REMARK);
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setRemark(remark);
	}
		
	protected void setVersion(Brand brand, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(BrandTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		brand.setVersion(version);
	}
		
		

}


