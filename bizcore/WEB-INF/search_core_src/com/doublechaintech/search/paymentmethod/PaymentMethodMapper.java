
package com.doublechaintech.search.paymentmethod;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.search.BaseRowMapper;

public class PaymentMethodMapper extends BaseRowMapper<PaymentMethod>{
	
	protected PaymentMethod internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PaymentMethod paymentMethod = getPaymentMethod();		
		 		
 		setId(paymentMethod, rs, rowNumber); 		
 		setName(paymentMethod, rs, rowNumber); 		
 		setNumber(paymentMethod, rs, rowNumber); 		
 		setLine1(paymentMethod, rs, rowNumber); 		
 		setLine2(paymentMethod, rs, rowNumber); 		
 		setCity(paymentMethod, rs, rowNumber); 		
 		setExpireOn(paymentMethod, rs, rowNumber); 		
 		setVersion(paymentMethod, rs, rowNumber);

		return paymentMethod;
	}
	
	protected PaymentMethod getPaymentMethod(){
		return new PaymentMethod();
	}		
		
	protected void setId(PaymentMethod paymentMethod, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(PaymentMethodTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentMethod.setId(id);
	}
		
	protected void setName(PaymentMethod paymentMethod, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(PaymentMethodTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentMethod.setName(name);
	}
		
	protected void setNumber(PaymentMethod paymentMethod, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String number = rs.getString(PaymentMethodTable.COLUMN_NUMBER);
		if(number == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentMethod.setNumber(number);
	}
		
	protected void setLine1(PaymentMethod paymentMethod, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String line1 = rs.getString(PaymentMethodTable.COLUMN_LINE1);
		if(line1 == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentMethod.setLine1(line1);
	}
		
	protected void setLine2(PaymentMethod paymentMethod, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String line2 = rs.getString(PaymentMethodTable.COLUMN_LINE2);
		if(line2 == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentMethod.setLine2(line2);
	}
		
	protected void setCity(PaymentMethod paymentMethod, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String city = rs.getString(PaymentMethodTable.COLUMN_CITY);
		if(city == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentMethod.setCity(city);
	}
		
	protected void setExpireOn(PaymentMethod paymentMethod, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date expireOn = rs.getDate(PaymentMethodTable.COLUMN_EXPIRE_ON);
		if(expireOn == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentMethod.setExpireOn(expireOn);
	}
		
	protected void setVersion(PaymentMethod paymentMethod, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(PaymentMethodTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		paymentMethod.setVersion(version);
	}
		
		

}


