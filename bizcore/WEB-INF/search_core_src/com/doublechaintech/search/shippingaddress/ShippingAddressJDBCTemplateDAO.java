
package com.doublechaintech.search.shippingaddress;

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

public class ShippingAddressJDBCTemplateDAO extends SearchNamingServiceDAO implements ShippingAddressDAO{


			
		

	
	/*
	protected ShippingAddress load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalShippingAddress(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ShippingAddress load(String id,Map<String,Object> options) throws Exception{
		return loadInternalShippingAddress(ShippingAddressTable.withId(id), options);
	}
	
	
	
	public ShippingAddress save(ShippingAddress shippingAddress,Map<String,Object> options){
		
		String methodName="save(ShippingAddress shippingAddress,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(shippingAddress, methodName, "shippingAddress");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalShippingAddress(shippingAddress,options);
	}
	public ShippingAddress clone(String shippingAddressId, Map<String,Object> options) throws Exception{
	
		return clone(ShippingAddressTable.withId(shippingAddressId),options);
	}
	
	protected ShippingAddress clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String shippingAddressId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ShippingAddress newShippingAddress = loadInternalShippingAddress(accessKey, options);
		newShippingAddress.setVersion(0);
		
		

		
		saveInternalShippingAddress(newShippingAddress,options);
		
		return newShippingAddress;
	}
	
	
	
	

	protected void throwIfHasException(String shippingAddressId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ShippingAddressVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ShippingAddressNotFoundException(
					"The " + this.getTableName() + "(" + shippingAddressId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String shippingAddressId, int version) throws Exception{
	
		String methodName="delete(String shippingAddressId, int version)";
		assertMethodArgumentNotNull(shippingAddressId, methodName, "shippingAddressId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{shippingAddressId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(shippingAddressId,version);
		}
		
	
	}
	
	
	
	
	

	public ShippingAddress disconnectFromAll(String shippingAddressId, int version) throws Exception{
	
		
		ShippingAddress shippingAddress = loadInternalShippingAddress(ShippingAddressTable.withId(shippingAddressId), emptyOptions());
		shippingAddress.clearFromAll();
		this.saveShippingAddress(shippingAddress);
		return shippingAddress;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ShippingAddressTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "shipping_address";
	}
	@Override
	protected String getBeanName() {
		
		return "shippingAddress";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ShippingAddressTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ShippingAddressMapper getShippingAddressMapper(){
		return new ShippingAddressMapper();
	}

	
	
	protected ShippingAddress extractShippingAddress(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ShippingAddress shippingAddress = loadSingleObject(accessKey, getShippingAddressMapper());
			return shippingAddress;
		}catch(EmptyResultDataAccessException e){
			throw new ShippingAddressNotFoundException("ShippingAddress("+accessKey+") is not found!");
		}

	}

	
	

	protected ShippingAddress loadInternalShippingAddress(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ShippingAddress shippingAddress = extractShippingAddress(accessKey, loadOptions);

		
		return shippingAddress;
		
	}

	
		
		
 	
		
		
		

	

	protected ShippingAddress saveShippingAddress(ShippingAddress  shippingAddress){
		
		if(!shippingAddress.isChanged()){
			return shippingAddress;
		}
		
		
		String SQL=this.getSaveShippingAddressSQL(shippingAddress);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveShippingAddressParameters(shippingAddress);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		shippingAddress.incVersion();
		return shippingAddress;
	
	}
	public SmartList<ShippingAddress> saveShippingAddressList(SmartList<ShippingAddress> shippingAddressList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitShippingAddressList(shippingAddressList);
		
		batchShippingAddressCreate((List<ShippingAddress>)lists[CREATE_LIST_INDEX]);
		
		batchShippingAddressUpdate((List<ShippingAddress>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ShippingAddress shippingAddress:shippingAddressList){
			if(shippingAddress.isChanged()){
				shippingAddress.incVersion();
			}
			
		
		}
		
		
		return shippingAddressList;
	}

	public SmartList<ShippingAddress> removeShippingAddressList(SmartList<ShippingAddress> shippingAddressList,Map<String,Object> options){
		
		
		super.removeList(shippingAddressList, options);
		
		return shippingAddressList;
		
		
	}
	
	protected List<Object[]> prepareShippingAddressBatchCreateArgs(List<ShippingAddress> shippingAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingAddress shippingAddress:shippingAddressList ){
			Object [] parameters = prepareShippingAddressCreateParameters(shippingAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareShippingAddressBatchUpdateArgs(List<ShippingAddress> shippingAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingAddress shippingAddress:shippingAddressList ){
			if(!shippingAddress.isChanged()){
				continue;
			}
			Object [] parameters = prepareShippingAddressUpdateParameters(shippingAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchShippingAddressCreate(List<ShippingAddress> shippingAddressList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareShippingAddressBatchCreateArgs(shippingAddressList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchShippingAddressUpdate(List<ShippingAddress> shippingAddressList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareShippingAddressBatchUpdateArgs(shippingAddressList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitShippingAddressList(List<ShippingAddress> shippingAddressList){
		
		List<ShippingAddress> shippingAddressCreateList=new ArrayList<ShippingAddress>();
		List<ShippingAddress> shippingAddressUpdateList=new ArrayList<ShippingAddress>();
		
		for(ShippingAddress shippingAddress: shippingAddressList){
			if(isUpdateRequest(shippingAddress)){
				shippingAddressUpdateList.add( shippingAddress);
				continue;
			}
			shippingAddressCreateList.add(shippingAddress);
		}
		
		return new Object[]{shippingAddressCreateList,shippingAddressUpdateList};
	}
	
	protected boolean isUpdateRequest(ShippingAddress shippingAddress){
 		return shippingAddress.getVersion() > 0;
 	}
 	protected String getSaveShippingAddressSQL(ShippingAddress shippingAddress){
 		if(isUpdateRequest(shippingAddress)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveShippingAddressParameters(ShippingAddress shippingAddress){
 		if(isUpdateRequest(shippingAddress) ){
 			return prepareShippingAddressUpdateParameters(shippingAddress);
 		}
 		return prepareShippingAddressCreateParameters(shippingAddress);
 	}
 	protected Object[] prepareShippingAddressUpdateParameters(ShippingAddress shippingAddress){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = shippingAddress.getName();
 		parameters[1] = shippingAddress.getLine1();
 		parameters[2] = shippingAddress.getLine2();
 		parameters[3] = shippingAddress.getCity();
 		parameters[4] = shippingAddress.getState();
 		parameters[5] = shippingAddress.getZipCode();		
 		parameters[6] = shippingAddress.nextVersion();
 		parameters[7] = shippingAddress.getId();
 		parameters[8] = shippingAddress.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareShippingAddressCreateParameters(ShippingAddress shippingAddress){
		Object[] parameters = new Object[7];
		String newShippingAddressId=getNextId();
		shippingAddress.setId(newShippingAddressId);
		parameters[0] =  shippingAddress.getId();
 
 		parameters[1] = shippingAddress.getName();
 		parameters[2] = shippingAddress.getLine1();
 		parameters[3] = shippingAddress.getLine2();
 		parameters[4] = shippingAddress.getCity();
 		parameters[5] = shippingAddress.getState();
 		parameters[6] = shippingAddress.getZipCode();		
 				
 		return parameters;
 	}
 	
	protected ShippingAddress saveInternalShippingAddress(ShippingAddress shippingAddress, Map<String,Object> options){
		
		saveShippingAddress(shippingAddress);

		
		return shippingAddress;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public ShippingAddress present(ShippingAddress shippingAddress,Map<String, Object> options){
	

		return shippingAddress;
	
	}
		

	

	protected String getTableName(){
		return ShippingAddressTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ShippingAddress> shippingAddressList) {		
		this.enhanceListInternal(shippingAddressList, this.getShippingAddressMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ShippingAddress> shippingAddressList = ownerEntity.collectRefsWithType(ShippingAddress.INTERNAL_TYPE);
		this.enhanceList(shippingAddressList);
		
	}
	
	@Override
	public SmartList<ShippingAddress> findShippingAddressWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getShippingAddressMapper());

	}
	@Override
	public int countShippingAddressWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countShippingAddressWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ShippingAddress> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getShippingAddressMapper());
	}
}


