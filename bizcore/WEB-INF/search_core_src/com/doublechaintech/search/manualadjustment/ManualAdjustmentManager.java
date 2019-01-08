
package com.doublechaintech.search.manualadjustment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.SearchUserContext;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;

public interface ManualAdjustmentManager{

		

	public ManualAdjustment createManualAdjustment(SearchUserContext userContext, String name, int amount, int threadHold, String type, String userOrderId) throws Exception;	
	public ManualAdjustment updateManualAdjustment(SearchUserContext userContext,String manualAdjustmentId, int manualAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ManualAdjustment loadManualAdjustment(SearchUserContext userContext, String manualAdjustmentId, String [] tokensExpr) throws Exception;
	public ManualAdjustment internalSaveManualAdjustment(SearchUserContext userContext, ManualAdjustment manualAdjustment) throws Exception;
	public ManualAdjustment internalSaveManualAdjustment(SearchUserContext userContext, ManualAdjustment manualAdjustment,Map<String,Object>option) throws Exception;
	
	public ManualAdjustment transferToAnotherUserOrder(SearchUserContext userContext, String manualAdjustmentId, String anotherUserOrderId)  throws Exception;
 

	public void delete(SearchUserContext userContext, String manualAdjustmentId, int version) throws Exception;
	public int deleteAll(SearchUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(SearchUserContext userContext, ManualAdjustment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


