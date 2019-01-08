
package com.doublechaintech.search.profile;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.search.BaseEntity;


import com.doublechaintech.search.Message;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;

import com.doublechaintech.search.SearchUserContext;
//import com.doublechaintech.search.BaseManagerImpl;
import com.doublechaintech.search.SearchCheckerManager;
import com.doublechaintech.search.CustomSearchCheckerManager;

import com.doublechaintech.search.platform.Platform;
import com.doublechaintech.search.userorder.UserOrder;

import com.doublechaintech.search.platform.CandidatePlatform;

import com.doublechaintech.search.profile.Profile;
import com.doublechaintech.search.platform.Platform;






public class ProfileManagerImpl extends CustomSearchCheckerManager implements ProfileManager {
	
	private static final String SERVICE_TYPE = "Profile";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProfileManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProfileManagerException(message);

	}
	
	

 	protected Profile saveProfile(SearchUserContext userContext, Profile profile, String [] tokensExpr) throws Exception{	
 		//return getProfileDAO().save(profile, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfile(userContext, profile, tokens);
 	}
 	
 	protected Profile saveProfileDetail(SearchUserContext userContext, Profile profile) throws Exception{	

 		
 		return saveProfile(userContext, profile, allTokens());
 	}
 	
 	public Profile loadProfile(SearchUserContext userContext, String profileId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	
 	 public Profile searchProfile(SearchUserContext userContext, String profileId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	

 	protected Profile present(SearchUserContext userContext, Profile profile, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,profile,tokens);
		
		
		Profile  profileToPresent = userContext.getDAOGroup().getProfileDAO().present(profile, tokens);
		
		List<BaseEntity> entityListToNaming = profileToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProfileDAO().alias(entityListToNaming);
		
		return  profileToPresent;
		
		
	}
 
 	
 	
 	public Profile loadProfileDetail(SearchUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, allTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	
 	public Object view(SearchUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, viewTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	protected Profile saveProfile(SearchUserContext userContext, Profile profile, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProfileDAO().save(profile, tokens);
 	}
 	protected Profile loadProfile(SearchUserContext userContext, String profileId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 
 		return userContext.getDAOGroup().getProfileDAO().load(profileId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(SearchUserContext userContext, Profile profile, Map<String, Object> tokens){
		super.addActions(userContext, profile, tokens);
		
		addAction(userContext, profile, tokens,"@create","createProfile","createProfile/","main","primary");
		addAction(userContext, profile, tokens,"@update","updateProfile","updateProfile/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"@copy","cloneProfile","cloneProfile/"+profile.getId()+"/","main","primary");
		
		addAction(userContext, profile, tokens,"profile.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"profile.addUserOrder","addUserOrder","addUserOrder/"+profile.getId()+"/","userOrderList","primary");
		addAction(userContext, profile, tokens,"profile.removeUserOrder","removeUserOrder","removeUserOrder/"+profile.getId()+"/","userOrderList","primary");
		addAction(userContext, profile, tokens,"profile.updateUserOrder","updateUserOrder","updateUserOrder/"+profile.getId()+"/","userOrderList","primary");
		addAction(userContext, profile, tokens,"profile.copyUserOrderFrom","copyUserOrderFrom","copyUserOrderFrom/"+profile.getId()+"/","userOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(SearchUserContext userContext, Profile profile, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Profile createProfile(SearchUserContext userContext,String name, int age, String gender, String lastUpdateTime, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProfile(name);
		userContext.getChecker().checkAgeOfProfile(age);
		userContext.getChecker().checkGenderOfProfile(gender);
		userContext.getChecker().checkLastUpdateTimeOfProfile(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);


		Profile profile=createNewProfile();	

		profile.setName(name);
		profile.setAge(age);
		profile.setGender(gender);
		profile.setLastUpdateTime(lastUpdateTime);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		profile.setPlatform(platform);
		
		

		profile = saveProfile(userContext, profile, emptyOptions());
		
		onNewInstanceCreated(userContext, profile);
		return profile;

		
	}
	protected Profile createNewProfile() 
	{
		
		return new Profile();		
	}
	
	protected void checkParamsForUpdatingProfile(SearchUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile( profileVersion);
		

		if(Profile.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProfile(parseString(newValueExpr));
		}
		if(Profile.AGE_PROPERTY.equals(property)){
			userContext.getChecker().checkAgeOfProfile(parseInt(newValueExpr));
		}
		if(Profile.GENDER_PROPERTY.equals(property)){
			userContext.getChecker().checkGenderOfProfile(parseString(newValueExpr));
		}
		if(Profile.LAST_UPDATE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkLastUpdateTimeOfProfile(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
		
	}
	
	
	
	public Profile clone(SearchUserContext userContext, String fromProfileId) throws Exception{
		
		return userContext.getDAOGroup().getProfileDAO().clone(fromProfileId, this.allTokens());
	}
	
	public Profile internalSaveProfile(SearchUserContext userContext, Profile profile) throws Exception 
	{
		return internalSaveProfile(userContext, profile, allTokens());

	}
	public Profile internalSaveProfile(SearchUserContext userContext, Profile profile, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			
			profile = saveProfile(userContext, profile, options);
			return profile;
			
		}

	}
	
	public Profile updateProfile(SearchUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	
	public Profile updateProfileProperty(SearchUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProfileTokens tokens(){
		return ProfileTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfileTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortUserOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfileTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(SearchUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProfile(profileId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
 		
 	}
 	public Profile transferToAnotherPlatform(SearchUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, profileId,anotherPlatformId);
 
		Profile profile = loadProfile(userContext, profileId, allTokens());	
		synchronized(profile){
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			profile.updatePlatform(platform);		
			profile = saveProfile(userContext, profile, emptyOptions());
			
			return present(userContext,profile, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(SearchUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForProfile(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(SearchUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(SearchUserContext userContext, String profileId, int profileVersion) throws Exception {
		//deleteInternal(userContext, profileId, profileVersion);		
	}
	protected void deleteInternal(SearchUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		userContext.getDAOGroup().getProfileDAO().delete(profileId, profileVersion);
	}
	
	public Profile forgetByAll(SearchUserContext userContext, String profileId, int profileVersion) throws Exception {
		return forgetByAllInternal(userContext, profileId, profileVersion);		
	}
	protected Profile forgetByAllInternal(SearchUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		return userContext.getDAOGroup().getProfileDAO().disconnectFromAll(profileId, profileVersion);
	}
	

	
	public int deleteAll(SearchUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfileManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(SearchUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProfileDAO().deleteAll();
	}


	//disconnect Profile with platform in UserOrder
	protected Profile breakWithUserOrderByPlatform(SearchUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveUserOrderListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withUserOrderList().done());
				return profile;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingUserOrder(SearchUserContext userContext, String profileId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String platformId, String lastUpdateTime,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkTitleOfUserOrder(title);
		
		userContext.getChecker().checkTotalAdjustmentOfUserOrder(totalAdjustment);
		
		userContext.getChecker().checkTotalAmountOfUserOrder(totalAmount);
		
		userContext.getChecker().checkPlatformIdOfUserOrder(platformId);
		
		userContext.getChecker().checkLastUpdateTimeOfUserOrder(lastUpdateTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addUserOrder(SearchUserContext userContext, String profileId, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String platformId, String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserOrder(userContext,profileId,title, totalAdjustment, totalAmount, platformId, lastUpdateTime,tokensExpr);
		
		UserOrder userOrder = createUserOrder(userContext,title, totalAdjustment, totalAmount, platformId, lastUpdateTime);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addUserOrder( userOrder );		
			profile = saveProfile(userContext, profile, tokens().withUserOrderList().done());
			
			userContext.getManagerGroup().getUserOrderManager().onNewInstanceCreated(userContext, userOrder);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserOrderProperties(SearchUserContext userContext, String profileId,String id,String title,BigDecimal totalAdjustment,BigDecimal totalAmount,String lastUpdateTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfUserOrder(id);
		
		userContext.getChecker().checkTitleOfUserOrder( title);
		userContext.getChecker().checkTotalAdjustmentOfUserOrder( totalAdjustment);
		userContext.getChecker().checkTotalAmountOfUserOrder( totalAmount);
		userContext.getChecker().checkLastUpdateTimeOfUserOrder( lastUpdateTime);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateUserOrderProperties(SearchUserContext userContext, String profileId, String id,String title,BigDecimal totalAdjustment,BigDecimal totalAmount,String lastUpdateTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingUserOrderProperties(userContext,profileId,id,title,totalAdjustment,totalAmount,lastUpdateTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserOrderListList()
				.searchUserOrderListWith(UserOrder.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getUserOrderList().isEmpty()){
			throw new ProfileManagerException("UserOrder is NOT FOUND with id: '"+id+"'");
		}
		
		UserOrder item = profileToUpdate.getUserOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAdjustment( totalAdjustment );
		item.updateTotalAmount( totalAmount );
		item.updateLastUpdateTime( lastUpdateTime );

		
		//checkParamsForAddingUserOrder(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withUserOrderList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected UserOrder createUserOrder(SearchUserContext userContext, String title, BigDecimal totalAdjustment, BigDecimal totalAmount, String platformId, String lastUpdateTime) throws Exception{

		UserOrder userOrder = new UserOrder();
		
		
		userOrder.setTitle(title);		
		userOrder.setTotalAdjustment(totalAdjustment);		
		userOrder.setTotalAmount(totalAmount);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		userOrder.setPlatform(platform);		
		userOrder.setLastUpdateTime(lastUpdateTime);
	
		
		return userOrder;
	
		
	}
	
	protected UserOrder createIndexedUserOrder(String id, int version){

		UserOrder userOrder = new UserOrder();
		userOrder.setId(id);
		userOrder.setVersion(version);
		return userOrder;			
		
	}
	
	protected void checkParamsForRemovingUserOrderList(SearchUserContext userContext, String profileId, 
			String userOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String userOrderId: userOrderIds){
			userContext.getChecker().checkIdOfUserOrder(userOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeUserOrderList(SearchUserContext userContext, String profileId, 
			String userOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingUserOrderList(userContext, profileId,  userOrderIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveUserOrderList(profile, userOrderIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withUserOrderList().done());
				deleteRelationListInGraph(userContext, profile.getUserOrderList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingUserOrder(SearchUserContext userContext, String profileId, 
		String userOrderId, int userOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkVersionOfUserOrder(userOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeUserOrder(SearchUserContext userContext, String profileId, 
		String userOrderId, int userOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserOrder(userContext,profileId, userOrderId, userOrderVersion,tokensExpr);
		
		UserOrder userOrder = createIndexedUserOrder(userOrderId, userOrderVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeUserOrder( userOrder );		
			profile = saveProfile(userContext, profile, tokens().withUserOrderList().done());
			deleteRelationInGraph(userContext, userOrder);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingUserOrder(SearchUserContext userContext, String profileId, 
		String userOrderId, int userOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkVersionOfUserOrder(userOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyUserOrderFrom(SearchUserContext userContext, String profileId, 
		String userOrderId, int userOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserOrder(userContext,profileId, userOrderId, userOrderVersion,tokensExpr);
		
		UserOrder userOrder = createIndexedUserOrder(userOrderId, userOrderVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			profile.copyUserOrderFrom( userOrder );		
			profile = saveProfile(userContext, profile, tokens().withUserOrderList().done());
			
			userContext.getManagerGroup().getUserOrderManager().onNewInstanceCreated(userContext, (UserOrder)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingUserOrder(SearchUserContext userContext, String profileId, String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfUserOrder(userOrderId);
		userContext.getChecker().checkVersionOfUserOrder(userOrderVersion);
		

		if(UserOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfUserOrder(parseString(newValueExpr));
		}
		
		if(UserOrder.TOTAL_ADJUSTMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAdjustmentOfUserOrder(parseBigDecimal(newValueExpr));
		}
		
		if(UserOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfUserOrder(parseBigDecimal(newValueExpr));
		}
		
		if(UserOrder.LAST_UPDATE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkLastUpdateTimeOfUserOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateUserOrder(SearchUserContext userContext, String profileId, String userOrderId, int userOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserOrder(userContext, profileId, userOrderId, userOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withUserOrderList().searchUserOrderListWith(UserOrder.ID_PROPERTY, "eq", userOrderId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeUserOrder( userOrder );	
			//make changes to AcceleraterAccount.
			UserOrder userOrderIndex = createIndexedUserOrder(userOrderId, userOrderVersion);
		
			UserOrder userOrder = profile.findTheUserOrder(userOrderIndex);
			if(userOrder == null){
				throw new ProfileManagerException(userOrder+" is NOT FOUND" );
			}
			
			userOrder.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().withUserOrderList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(SearchUserContext userContext, Profile newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


