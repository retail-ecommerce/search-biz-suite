
package com.doublechaintech.search.shippinggroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface ShippingGroupManager{

		

	public ShippingGroup createShippingGroup(SearchUserContext userContext, String name, String line1, String line2, String city, String state, int zipCode, String country, String userOrderId) throws Exception;	
	public ShippingGroup updateShippingGroup(SearchUserContext userContext,String shippingGroupId, int shippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ShippingGroup loadShippingGroup(SearchUserContext userContext, String shippingGroupId, String [] tokensExpr) throws Exception;
	public ShippingGroup internalSaveShippingGroup(SearchUserContext userContext, ShippingGroup shippingGroup) throws Exception;
	public ShippingGroup internalSaveShippingGroup(SearchUserContext userContext, ShippingGroup shippingGroup,Map<String,Object>option) throws Exception;
	
	public ShippingGroup transferToAnotherUserOrder(SearchUserContext userContext, String shippingGroupId, String anotherUserOrderId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String shippingGroupId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, ShippingGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


