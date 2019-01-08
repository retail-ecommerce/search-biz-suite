
package com.doublechaintech.search.paymentmethod;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.search.SearchNamingServiceDAO;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.AccessKey;
import com.doublechaintech.search.DateKey;
import com.doublechaintech.search.StatsInfo;
import com.doublechaintech.search.StatsItem;

import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;






import org.springframework.dao.EmptyResultDataAccessException;

public class PaymentMethodJDBCTemplateDAO extends SearchNamingServiceDAO implements PaymentMethodDAO{


			
		

	
	/*
	protected PaymentMethod load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPaymentMethod(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public PaymentMethod load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPaymentMethod(PaymentMethodTable.withId(id), options);
	}
	
	
	
	public PaymentMethod save(PaymentMethod paymentMethod,Map<String,Object> options){
		
		String methodName="save(PaymentMethod paymentMethod,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(paymentMethod, methodName, "paymentMethod");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPaymentMethod(paymentMethod,options);
	}
	public PaymentMethod clone(String paymentMethodId, Map<String,Object> options) throws Exception{
	
		return clone(PaymentMethodTable.withId(paymentMethodId),options);
	}
	
	protected PaymentMethod clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String paymentMethodId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PaymentMethod newPaymentMethod = loadInternalPaymentMethod(accessKey, options);
		newPaymentMethod.setVersion(0);
		
		

		
		saveInternalPaymentMethod(newPaymentMethod,options);
		
		return newPaymentMethod;
	}
	
	
	
	

	protected void throwIfHasException(String paymentMethodId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PaymentMethodVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PaymentMethodNotFoundException(
					"The " + this.getTableName() + "(" + paymentMethodId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String paymentMethodId, int version) throws Exception{
	
		String methodName="delete(String paymentMethodId, int version)";
		assertMethodArgumentNotNull(paymentMethodId, methodName, "paymentMethodId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{paymentMethodId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(paymentMethodId,version);
		}
		
	
	}
	
	
	
	
	

	public PaymentMethod disconnectFromAll(String paymentMethodId, int version) throws Exception{
	
		
		PaymentMethod paymentMethod = loadInternalPaymentMethod(PaymentMethodTable.withId(paymentMethodId), emptyOptions());
		paymentMethod.clearFromAll();
		this.savePaymentMethod(paymentMethod);
		return paymentMethod;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PaymentMethodTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "payment_method";
	}
	@Override
	protected String getBeanName() {
		
		return "paymentMethod";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PaymentMethodTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected PaymentMethodMapper getPaymentMethodMapper(){
		return new PaymentMethodMapper();
	}

	
	
	protected PaymentMethod extractPaymentMethod(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			PaymentMethod paymentMethod = loadSingleObject(accessKey, getPaymentMethodMapper());
			return paymentMethod;
		}catch(EmptyResultDataAccessException e){
			throw new PaymentMethodNotFoundException("PaymentMethod("+accessKey+") is not found!");
		}

	}

	
	

	protected PaymentMethod loadInternalPaymentMethod(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PaymentMethod paymentMethod = extractPaymentMethod(accessKey, loadOptions);

		
		return paymentMethod;
		
	}

	
		
		
 	
		
		
		

	

	protected PaymentMethod savePaymentMethod(PaymentMethod  paymentMethod){
		
		if(!paymentMethod.isChanged()){
			return paymentMethod;
		}
		
		
		String SQL=this.getSavePaymentMethodSQL(paymentMethod);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePaymentMethodParameters(paymentMethod);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		paymentMethod.incVersion();
		return paymentMethod;
	
	}
	public SmartList<PaymentMethod> savePaymentMethodList(SmartList<PaymentMethod> paymentMethodList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPaymentMethodList(paymentMethodList);
		
		batchPaymentMethodCreate((List<PaymentMethod>)lists[CREATE_LIST_INDEX]);
		
		batchPaymentMethodUpdate((List<PaymentMethod>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PaymentMethod paymentMethod:paymentMethodList){
			if(paymentMethod.isChanged()){
				paymentMethod.incVersion();
			}
			
		
		}
		
		
		return paymentMethodList;
	}

	public SmartList<PaymentMethod> removePaymentMethodList(SmartList<PaymentMethod> paymentMethodList,Map<String,Object> options){
		
		
		super.removeList(paymentMethodList, options);
		
		return paymentMethodList;
		
		
	}
	
	protected List<Object[]> preparePaymentMethodBatchCreateArgs(List<PaymentMethod> paymentMethodList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PaymentMethod paymentMethod:paymentMethodList ){
			Object [] parameters = preparePaymentMethodCreateParameters(paymentMethod);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePaymentMethodBatchUpdateArgs(List<PaymentMethod> paymentMethodList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PaymentMethod paymentMethod:paymentMethodList ){
			if(!paymentMethod.isChanged()){
				continue;
			}
			Object [] parameters = preparePaymentMethodUpdateParameters(paymentMethod);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPaymentMethodCreate(List<PaymentMethod> paymentMethodList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePaymentMethodBatchCreateArgs(paymentMethodList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPaymentMethodUpdate(List<PaymentMethod> paymentMethodList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePaymentMethodBatchUpdateArgs(paymentMethodList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPaymentMethodList(List<PaymentMethod> paymentMethodList){
		
		List<PaymentMethod> paymentMethodCreateList=new ArrayList<PaymentMethod>();
		List<PaymentMethod> paymentMethodUpdateList=new ArrayList<PaymentMethod>();
		
		for(PaymentMethod paymentMethod: paymentMethodList){
			if(isUpdateRequest(paymentMethod)){
				paymentMethodUpdateList.add( paymentMethod);
				continue;
			}
			paymentMethodCreateList.add(paymentMethod);
		}
		
		return new Object[]{paymentMethodCreateList,paymentMethodUpdateList};
	}
	
	protected boolean isUpdateRequest(PaymentMethod paymentMethod){
 		return paymentMethod.getVersion() > 0;
 	}
 	protected String getSavePaymentMethodSQL(PaymentMethod paymentMethod){
 		if(isUpdateRequest(paymentMethod)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePaymentMethodParameters(PaymentMethod paymentMethod){
 		if(isUpdateRequest(paymentMethod) ){
 			return preparePaymentMethodUpdateParameters(paymentMethod);
 		}
 		return preparePaymentMethodCreateParameters(paymentMethod);
 	}
 	protected Object[] preparePaymentMethodUpdateParameters(PaymentMethod paymentMethod){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = paymentMethod.getName();
 		parameters[1] = paymentMethod.getNumber();
 		parameters[2] = paymentMethod.getLine1();
 		parameters[3] = paymentMethod.getLine2();
 		parameters[4] = paymentMethod.getCity();
 		parameters[5] = paymentMethod.getExpireOn();		
 		parameters[6] = paymentMethod.nextVersion();
 		parameters[7] = paymentMethod.getId();
 		parameters[8] = paymentMethod.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePaymentMethodCreateParameters(PaymentMethod paymentMethod){
		Object[] parameters = new Object[7];
		String newPaymentMethodId=getNextId();
		paymentMethod.setId(newPaymentMethodId);
		parameters[0] =  paymentMethod.getId();
 
 		parameters[1] = paymentMethod.getName();
 		parameters[2] = paymentMethod.getNumber();
 		parameters[3] = paymentMethod.getLine1();
 		parameters[4] = paymentMethod.getLine2();
 		parameters[5] = paymentMethod.getCity();
 		parameters[6] = paymentMethod.getExpireOn();		
 				
 		return parameters;
 	}
 	
	protected PaymentMethod saveInternalPaymentMethod(PaymentMethod paymentMethod, Map<String,Object> options){
		
		savePaymentMethod(paymentMethod);

		
		return paymentMethod;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public PaymentMethod present(PaymentMethod paymentMethod,Map<String, Object> options){
	

		return paymentMethod;
	
	}
		

	

	protected String getTableName(){
		return PaymentMethodTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<PaymentMethod> paymentMethodList) {		
		this.enhanceListInternal(paymentMethodList, this.getPaymentMethodMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<PaymentMethod> paymentMethodList = ownerEntity.collectRefsWithType(PaymentMethod.INTERNAL_TYPE);
		this.enhanceList(paymentMethodList);
		
	}
	
	@Override
	public SmartList<PaymentMethod> findPaymentMethodWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPaymentMethodMapper());

	}
	@Override
	public int countPaymentMethodWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPaymentMethodWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<PaymentMethod> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPaymentMethodMapper());
	}
}


