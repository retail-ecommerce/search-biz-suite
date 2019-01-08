
package com.doublechaintech.search.lineitem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface LineItemManager{

		

	public LineItem createLineItem(SearchUserContext userContext, String name, int quantity, BigDecimal price, BigDecimal discountPrice, String userOrderId) throws Exception;	
	public LineItem updateLineItem(SearchUserContext userContext,String lineItemId, int lineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LineItem loadLineItem(SearchUserContext userContext, String lineItemId, String [] tokensExpr) throws Exception;
	public LineItem internalSaveLineItem(SearchUserContext userContext, LineItem lineItem) throws Exception;
	public LineItem internalSaveLineItem(SearchUserContext userContext, LineItem lineItem,Map<String,Object>option) throws Exception;
	
	public LineItem transferToAnotherUserOrder(SearchUserContext userContext, String lineItemId, String anotherUserOrderId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String lineItemId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, LineItem newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


