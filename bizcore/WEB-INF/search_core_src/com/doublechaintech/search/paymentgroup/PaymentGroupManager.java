
package com.doublechaintech.search.paymentgroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface PaymentGroupManager{

		

	public PaymentGroup createPaymentGroup(SearchUserContext userContext, String name, BigDecimal amount, String userOrderId, String status) throws Exception;	
	public PaymentGroup updatePaymentGroup(SearchUserContext userContext,String paymentGroupId, int paymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PaymentGroup loadPaymentGroup(SearchUserContext userContext, String paymentGroupId, String [] tokensExpr) throws Exception;
	public PaymentGroup internalSavePaymentGroup(SearchUserContext userContext, PaymentGroup paymentGroup) throws Exception;
	public PaymentGroup internalSavePaymentGroup(SearchUserContext userContext, PaymentGroup paymentGroup,Map<String,Object>option) throws Exception;
	
	public PaymentGroup transferToAnotherUserOrder(SearchUserContext userContext, String paymentGroupId, String anotherUserOrderId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String paymentGroupId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, PaymentGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


