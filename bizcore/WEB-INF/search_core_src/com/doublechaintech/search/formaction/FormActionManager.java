
package com.doublechaintech.search.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface FormActionManager{

		

	public FormAction createFormAction(SearchUserContext userContext, String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception;	
	public FormAction updateFormAction(SearchUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(SearchUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(SearchUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(SearchUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;
	
	public FormAction transferToAnotherForm(SearchUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}














