
package com.doublechaintech.search.shippingaddress;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface ShippingAddressManager{

		

	public ShippingAddress createShippingAddress(SearchUserContext userContext, String name, String line1, String line2, String city, String state, int zipCode) throws Exception;	
	public ShippingAddress updateShippingAddress(SearchUserContext userContext,String shippingAddressId, int shippingAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ShippingAddress loadShippingAddress(SearchUserContext userContext, String shippingAddressId, String [] tokensExpr) throws Exception;
	public ShippingAddress internalSaveShippingAddress(SearchUserContext userContext, ShippingAddress shippingAddress) throws Exception;
	public ShippingAddress internalSaveShippingAddress(SearchUserContext userContext, ShippingAddress shippingAddress,Map<String,Object>option) throws Exception;
	


	public void delete(SearchUserContext userContext, String shippingAddressId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, ShippingAddress newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


