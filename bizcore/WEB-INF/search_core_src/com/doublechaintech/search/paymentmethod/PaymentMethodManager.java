
package com.doublechaintech.search.paymentmethod;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface PaymentMethodManager{

		

	public PaymentMethod createPaymentMethod(SearchUserContext userContext, String name, String number, String line1, String line2, String city, Date expireOn) throws Exception;	
	public PaymentMethod updatePaymentMethod(SearchUserContext userContext,String paymentMethodId, int paymentMethodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PaymentMethod loadPaymentMethod(SearchUserContext userContext, String paymentMethodId, String [] tokensExpr) throws Exception;
	public PaymentMethod internalSavePaymentMethod(SearchUserContext userContext, PaymentMethod paymentMethod) throws Exception;
	public PaymentMethod internalSavePaymentMethod(SearchUserContext userContext, PaymentMethod paymentMethod,Map<String,Object>option) throws Exception;
	


	public void delete(SearchUserContext userContext, String paymentMethodId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, PaymentMethod newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


