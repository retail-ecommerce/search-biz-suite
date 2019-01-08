
package com.doublechaintech.search.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(SearchUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(SearchUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(SearchUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(SearchUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(SearchUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(SearchUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


