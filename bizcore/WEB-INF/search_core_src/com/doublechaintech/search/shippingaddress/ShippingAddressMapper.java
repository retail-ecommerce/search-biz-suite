
package com.doublechaintech.search.shippingaddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.search.BaseRowMapper;

public class ShippingAddressMapper extends BaseRowMapper<ShippingAddress>{
	
	protected ShippingAddress internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ShippingAddress shippingAddress = getShippingAddress();		
		 		
 		setId(shippingAddress, rs, rowNumber); 		
 		setName(shippingAddress, rs, rowNumber); 		
 		setLine1(shippingAddress, rs, rowNumber); 		
 		setLine2(shippingAddress, rs, rowNumber); 		
 		setCity(shippingAddress, rs, rowNumber); 		
 		setState(shippingAddress, rs, rowNumber); 		
 		setZipCode(shippingAddress, rs, rowNumber); 		
 		setVersion(shippingAddress, rs, rowNumber);

		return shippingAddress;
	}
	
	protected ShippingAddress getShippingAddress(){
		return new ShippingAddress();
	}		
		
	protected void setId(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ShippingAddressTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setId(id);
	}
		
	protected void setName(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ShippingAddressTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setName(name);
	}
		
	protected void setLine1(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String line1 = rs.getString(ShippingAddressTable.COLUMN_LINE1);
		if(line1 == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setLine1(line1);
	}
		
	protected void setLine2(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String line2 = rs.getString(ShippingAddressTable.COLUMN_LINE2);
		if(line2 == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setLine2(line2);
	}
		
	protected void setCity(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String city = rs.getString(ShippingAddressTable.COLUMN_CITY);
		if(city == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setCity(city);
	}
		
	protected void setState(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String state = rs.getString(ShippingAddressTable.COLUMN_STATE);
		if(state == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setState(state);
	}
		
	protected void setZipCode(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer zipCode = rs.getInt(ShippingAddressTable.COLUMN_ZIP_CODE);
		if(zipCode == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setZipCode(zipCode);
	}
		
	protected void setVersion(ShippingAddress shippingAddress, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ShippingAddressTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingAddress.setVersion(version);
	}
		
		

}


