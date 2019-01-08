
package com.doublechaintech.search;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("Site"                                  , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Catalog"                               , BaseRelation.TRUST_CHAIN_ALL, "site");
		//replaceGenericRelation("LevelOneCategory"                      , BaseRelation.TRUST_CHAIN_ALL, "catalog");
		//replaceGenericRelation("LevelTwoCategory"                      , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("LevelNCategory"                        , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "brand");
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "catalog");
		//replaceGenericRelation("ProductRecommendation"                 , BaseRelation.TRUST_CHAIN_ALL, "brand");
		//replaceGenericRelation("ProductRecommendation"                 , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("Sku"                                   , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("Profile"                               , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("UserOrder"                             , BaseRelation.TRUST_CHAIN_ALL, "user");
		//replaceGenericRelation("UserOrder"                             , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("LineItem"                              , BaseRelation.TRUST_CHAIN_ALL, "userOrder");
		//replaceGenericRelation("OrderPromotion"                        , BaseRelation.TRUST_CHAIN_ALL, "userOrder");
		//replaceGenericRelation("ManualAdjustment"                      , BaseRelation.TRUST_CHAIN_ALL, "userOrder");
		//replaceGenericRelation("ShippingGroup"                         , BaseRelation.TRUST_CHAIN_ALL, "userOrder");
		//replaceGenericRelation("PaymentGroup"                          , BaseRelation.TRUST_CHAIN_ALL, "userOrder");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] siteRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Site",siteRelatedObjectNames);

		//String [] catalogRelatedObjectNames = {"site:Site"};
		//replaceRelationIndex("Catalog",catalogRelatedObjectNames);

		//String [] levelOneCategoryRelatedObjectNames = {"catalog:Catalog"};
		//replaceRelationIndex("LevelOneCategory",levelOneCategoryRelatedObjectNames);

		//String [] levelTwoCategoryRelatedObjectNames = {"parent_category:LevelOneCategory"};
		//replaceRelationIndex("LevelTwoCategory",levelTwoCategoryRelatedObjectNames);

		//String [] levelNCategoryRelatedObjectNames = {"parent_category:LevelTwoCategory"};
		//replaceRelationIndex("LevelNCategory",levelNCategoryRelatedObjectNames);

		//String [] productRelatedObjectNames = {"parent_category:LevelNCategory","brand:Brand","catalog:Catalog"};
		//replaceRelationIndex("Product",productRelatedObjectNames);

		//String [] productRecommendationRelatedObjectNames = {"brand:Brand","product:Product"};
		//replaceRelationIndex("ProductRecommendation",productRecommendationRelatedObjectNames);

		//String [] skuRelatedObjectNames = {"product:Product"};
		//replaceRelationIndex("Sku",skuRelatedObjectNames);

		//String [] profileRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Profile",profileRelatedObjectNames);

		//String [] userOrderRelatedObjectNames = {"user:Profile","platform:Platform"};
		//replaceRelationIndex("UserOrder",userOrderRelatedObjectNames);

		//String [] lineItemRelatedObjectNames = {"user_order:UserOrder"};
		//replaceRelationIndex("LineItem",lineItemRelatedObjectNames);

		//String [] orderPromotionRelatedObjectNames = {"user_order:UserOrder"};
		//replaceRelationIndex("OrderPromotion",orderPromotionRelatedObjectNames);

		//String [] manualAdjustmentRelatedObjectNames = {"user_order:UserOrder"};
		//replaceRelationIndex("ManualAdjustment",manualAdjustmentRelatedObjectNames);

		//String [] shippingGroupRelatedObjectNames = {"user_order:UserOrder"};
		//replaceRelationIndex("ShippingGroup",shippingGroupRelatedObjectNames);

		//String [] paymentGroupRelatedObjectNames = {"user_order:UserOrder"};
		//replaceRelationIndex("PaymentGroup",paymentGroupRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] formMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormMessage",formMessageRelatedObjectNames);

		//String [] formFieldMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormFieldMessage",formFieldMessageRelatedObjectNames);

		//String [] formFieldRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormField",formFieldRelatedObjectNames);

		//String [] formActionRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormAction",formActionRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}













