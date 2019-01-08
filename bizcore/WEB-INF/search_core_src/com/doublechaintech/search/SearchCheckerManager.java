package com.doublechaintech.search;
import java.text.MessageFormat;
import java.util.Date;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class SearchCheckerManager extends BaseManagerImpl {
	/*
	
	
	public static final String  ID_OF_PLATFORM ="platform.id";
	protected void checkIdOfPlatform(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PLATFORM ="platform.name";
	protected void checkNameOfPlatform(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  INTRODUCTION_OF_PLATFORM ="platform.introduction";
	protected void checkIntroductionOfPlatform(SearchUserContext userContext, String introduction, List<Message> messageList)
	{
		
	 	checkStringLengthRange(introduction,19, 288,INTRODUCTION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  CURRENT_VERSION_OF_PLATFORM ="platform.current_version";
	protected void checkCurrentVersionOfPlatform(SearchUserContext userContext, String currentVersion, List<Message> messageList)
	{
		
	 	checkStringLengthRange(currentVersion,2, 16,CURRENT_VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PLATFORM ="platform.version";
	protected void checkVersionOfPlatform(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SITE ="site.id";
	protected void checkIdOfSite(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SITE ="site.name";
	protected void checkNameOfSite(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  INTRODUCTION_OF_SITE ="site.introduction";
	protected void checkIntroductionOfSite(SearchUserContext userContext, String introduction, List<Message> messageList)
	{
		
	 	checkStringLengthRange(introduction,10, 148,INTRODUCTION_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_SITE ="site.platform";
	protected void checkPlatformIdOfSite(SearchUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfSite(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  LAST_UPDATE_TIME_OF_SITE ="site.last_update_time";
	protected void checkLastUpdateTimeOfSite(SearchUserContext userContext, String lastUpdateTime, List<Message> messageList)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SITE ="site.version";
	protected void checkVersionOfSite(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SITE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CATALOG ="catalog.id";
	protected void checkIdOfCatalog(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  DISPLAY_NAME_OF_CATALOG ="catalog.display_name";
	protected void checkDisplayNameOfCatalog(SearchUserContext userContext, String displayName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(displayName,2, 20,DISPLAY_NAME_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  SELLER_ID_OF_CATALOG ="catalog.seller_id";
	protected void checkSellerIdOfCatalog(SearchUserContext userContext, String sellerId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(sellerId,3, 32,SELLER_ID_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  SITE_OF_CATALOG ="catalog.site";
	protected void checkSiteIdOfCatalog(SearchUserContext userContext, String siteId, List<Message> messageList)
	{
		
	 	checkIdOfCatalog(userContext,siteId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CATALOG ="catalog.version";
	protected void checkVersionOfCatalog(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	protected void checkIdOfLevelOneCategory(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	protected void checkCatalogIdOfLevelOneCategory(SearchUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfLevelOneCategory(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  DISPLAY_NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.display_name";
	protected void checkDisplayNameOfLevelOneCategory(SearchUserContext userContext, String displayName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(displayName,4, 52,DISPLAY_NAME_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	protected void checkVersionOfLevelOneCategory(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	protected void checkIdOfLevelTwoCategory(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	protected void checkParentCategoryIdOfLevelTwoCategory(SearchUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfLevelTwoCategory(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  DISPLAY_NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.display_name";
	protected void checkDisplayNameOfLevelTwoCategory(SearchUserContext userContext, String displayName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(displayName,4, 52,DISPLAY_NAME_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	protected void checkVersionOfLevelTwoCategory(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_N_CATEGORY ="level_n_category.id";
	protected void checkIdOfLevelNCategory(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_LEVEL_N_CATEGORY ="level_n_category.parent_category";
	protected void checkParentCategoryIdOfLevelNCategory(SearchUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfLevelNCategory(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  DISPLAY_NAME_OF_LEVEL_N_CATEGORY ="level_n_category.display_name";
	protected void checkDisplayNameOfLevelNCategory(SearchUserContext userContext, String displayName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(displayName,3, 44,DISPLAY_NAME_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_N_CATEGORY ="level_n_category.version";
	protected void checkVersionOfLevelNCategory(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_N_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_BRAND ="brand.id";
	protected void checkIdOfBrand(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  BRAND_NAME_OF_BRAND ="brand.brand_name";
	protected void checkBrandNameOfBrand(SearchUserContext userContext, String brandName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(brandName,3, 40,BRAND_NAME_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  LOGO_OF_BRAND ="brand.logo";
	protected void checkLogoOfBrand(SearchUserContext userContext, String logo, List<Message> messageList)
	{
		
	 	checkImage(logo,0, 512,LOGO_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_BRAND ="brand.remark";
	protected void checkRemarkOfBrand(SearchUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_BRAND ="brand.version";
	protected void checkVersionOfBrand(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BRAND, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PRODUCT ="product.id";
	protected void checkIdOfProduct(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  DISPLAY_NAME_OF_PRODUCT ="product.display_name";
	protected void checkDisplayNameOfProduct(SearchUserContext userContext, String displayName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(displayName,2, 20,DISPLAY_NAME_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	protected void checkParentCategoryIdOfProduct(SearchUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_PRODUCT ="product.brand";
	protected void checkBrandIdOfProduct(SearchUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	protected void checkOriginOfProduct(SearchUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_PRODUCT ="product.catalog";
	protected void checkCatalogIdOfProduct(SearchUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_PRODUCT ="product.remark";
	protected void checkRemarkOfProduct(SearchUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  LAST_UPDATE_TIME_OF_PRODUCT ="product.last_update_time";
	protected void checkLastUpdateTimeOfProduct(SearchUserContext userContext, String lastUpdateTime, List<Message> messageList)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PRODUCT ="product.version";
	protected void checkVersionOfProduct(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PRODUCT_RECOMMENDATION ="product_recommendation.id";
	protected void checkIdOfProductRecommendation(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT_RECOMMENDATION, messageList); 		
		
	}	 			
	
	public static final String  DISPLAY_NAME_OF_PRODUCT_RECOMMENDATION ="product_recommendation.display_name";
	protected void checkDisplayNameOfProductRecommendation(SearchUserContext userContext, String displayName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(displayName,2, 20,DISPLAY_NAME_OF_PRODUCT_RECOMMENDATION, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_PRODUCT_RECOMMENDATION ="product_recommendation.brand";
	protected void checkBrandIdOfProductRecommendation(SearchUserContext userContext, String brandId, List<Message> messageList)
	{
		
	 	checkIdOfProductRecommendation(userContext,brandId, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_PRODUCT_RECOMMENDATION ="product_recommendation.origin";
	protected void checkOriginOfProductRecommendation(SearchUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_PRODUCT_RECOMMENDATION, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_OF_PRODUCT_RECOMMENDATION ="product_recommendation.product";
	protected void checkProductIdOfProductRecommendation(SearchUserContext userContext, String productId, List<Message> messageList)
	{
		
	 	checkIdOfProductRecommendation(userContext,productId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_PRODUCT_RECOMMENDATION ="product_recommendation.remark";
	protected void checkRemarkOfProductRecommendation(SearchUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_PRODUCT_RECOMMENDATION, messageList); 		
		
	}	 			
	
	public static final String  LAST_UPDATE_TIME_OF_PRODUCT_RECOMMENDATION ="product_recommendation.last_update_time";
	protected void checkLastUpdateTimeOfProductRecommendation(SearchUserContext userContext, String lastUpdateTime, List<Message> messageList)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_PRODUCT_RECOMMENDATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PRODUCT_RECOMMENDATION ="product_recommendation.version";
	protected void checkVersionOfProductRecommendation(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT_RECOMMENDATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SKU ="sku.id";
	protected void checkIdOfSku(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  DISPLAY_NAME_OF_SKU ="sku.display_name";
	protected void checkDisplayNameOfSku(SearchUserContext userContext, String displayName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(displayName,4, 52,DISPLAY_NAME_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  SIZE_OF_SKU ="sku.size";
	protected void checkSizeOfSku(SearchUserContext userContext, String size, List<Message> messageList)
	{
		
	 	checkStringLengthRange(size,2, 24,SIZE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_OF_SKU ="sku.product";
	protected void checkProductIdOfSku(SearchUserContext userContext, String productId, List<Message> messageList)
	{
		
	 	checkIdOfSku(userContext,productId, messageList); 		
		
	}	 			
	
	public static final String  ACTIVE_OF_SKU ="sku.active";
	protected void checkActiveOfSku(SearchUserContext userContext, boolean active, List<Message> messageList)
	{
		
	 	checkBooleanRange(active,0, true,ACTIVE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  BASE_PRICE_OF_SKU ="sku.base_price";
	protected void checkBasePriceOfSku(SearchUserContext userContext, BigDecimal basePrice, List<Message> messageList)
	{
		
	 	checkMoneyAmount(basePrice,0.00, 103.21,BASE_PRICE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  LAST_UPDATE_TIME_OF_SKU ="sku.last_update_time";
	protected void checkLastUpdateTimeOfSku(SearchUserContext userContext, String lastUpdateTime, List<Message> messageList)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SKU ="sku.version";
	protected void checkVersionOfSku(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PROFILE ="profile.id";
	protected void checkIdOfProfile(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PROFILE ="profile.name";
	protected void checkNameOfProfile(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  AGE_OF_PROFILE ="profile.age";
	protected void checkAgeOfProfile(SearchUserContext userContext, int age, List<Message> messageList)
	{
		
	 	checkIntegerRange(age,0, 40,AGE_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  GENDER_OF_PROFILE ="profile.gender";
	protected void checkGenderOfProfile(SearchUserContext userContext, String gender, List<Message> messageList)
	{
		
	 	checkGender(gender,2, 24,GENDER_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  LAST_UPDATE_TIME_OF_PROFILE ="profile.last_update_time";
	protected void checkLastUpdateTimeOfProfile(SearchUserContext userContext, String lastUpdateTime, List<Message> messageList)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_PROFILE ="profile.platform";
	protected void checkPlatformIdOfProfile(SearchUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfProfile(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PROFILE ="profile.version";
	protected void checkVersionOfProfile(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFILE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SHIPPING_ADDRESS ="shipping_address.id";
	protected void checkIdOfShippingAddress(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SHIPPING_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SHIPPING_ADDRESS ="shipping_address.name";
	protected void checkNameOfShippingAddress(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_SHIPPING_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  LINE1_OF_SHIPPING_ADDRESS ="shipping_address.line1";
	protected void checkLine1OfShippingAddress(SearchUserContext userContext, String line1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(line1,7, 100,LINE1_OF_SHIPPING_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  LINE2_OF_SHIPPING_ADDRESS ="shipping_address.line2";
	protected void checkLine2OfShippingAddress(SearchUserContext userContext, String line2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(line2,4, 48,LINE2_OF_SHIPPING_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  CITY_OF_SHIPPING_ADDRESS ="shipping_address.city";
	protected void checkCityOfShippingAddress(SearchUserContext userContext, String city, List<Message> messageList)
	{
		
	 	checkStringLengthRange(city,4, 60,CITY_OF_SHIPPING_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  STATE_OF_SHIPPING_ADDRESS ="shipping_address.state";
	protected void checkStateOfShippingAddress(SearchUserContext userContext, String state, List<Message> messageList)
	{
		
	 	checkStringLengthRange(state,1, 8,STATE_OF_SHIPPING_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  ZIP_CODE_OF_SHIPPING_ADDRESS ="shipping_address.zip_code";
	protected void checkZipCodeOfShippingAddress(SearchUserContext userContext, int zipCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(zipCode,0, 980087,ZIP_CODE_OF_SHIPPING_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SHIPPING_ADDRESS ="shipping_address.version";
	protected void checkVersionOfShippingAddress(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PAYMENT_METHOD ="payment_method.id";
	protected void checkIdOfPaymentMethod(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PAYMENT_METHOD, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PAYMENT_METHOD ="payment_method.name";
	protected void checkNameOfPaymentMethod(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 44,NAME_OF_PAYMENT_METHOD, messageList); 		
		
	}	 			
	
	public static final String  NUMBER_OF_PAYMENT_METHOD ="payment_method.number";
	protected void checkNumberOfPaymentMethod(SearchUserContext userContext, String number, List<Message> messageList)
	{
		
	 	checkStringLengthRange(number,6, 52,NUMBER_OF_PAYMENT_METHOD, messageList); 		
		
	}	 			
	
	public static final String  LINE1_OF_PAYMENT_METHOD ="payment_method.line1";
	protected void checkLine1OfPaymentMethod(SearchUserContext userContext, String line1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(line1,6, 88,LINE1_OF_PAYMENT_METHOD, messageList); 		
		
	}	 			
	
	public static final String  LINE2_OF_PAYMENT_METHOD ="payment_method.line2";
	protected void checkLine2OfPaymentMethod(SearchUserContext userContext, String line2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(line2,3, 40,LINE2_OF_PAYMENT_METHOD, messageList); 		
		
	}	 			
	
	public static final String  CITY_OF_PAYMENT_METHOD ="payment_method.city";
	protected void checkCityOfPaymentMethod(SearchUserContext userContext, String city, List<Message> messageList)
	{
		
	 	checkStringLengthRange(city,4, 48,CITY_OF_PAYMENT_METHOD, messageList); 		
		
	}	 			
	
	public static final String  EXPIRE_ON_OF_PAYMENT_METHOD ="payment_method.expire_on";
	protected void checkExpireOnOfPaymentMethod(SearchUserContext userContext, Date expireOn, List<Message> messageList)
	{
		
	 	checkDateRange(expireOn,parseDate("1900-01-01"), parseDate("2019-08-08"),EXPIRE_ON_OF_PAYMENT_METHOD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PAYMENT_METHOD ="payment_method.version";
	protected void checkVersionOfPaymentMethod(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYMENT_METHOD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_ORDER ="user_order.id";
	protected void checkIdOfUserOrder(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_ORDER ="user_order.title";
	protected void checkTitleOfUserOrder(SearchUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,5, 64,TITLE_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_ADJUSTMENT_OF_USER_ORDER ="user_order.total_adjustment";
	protected void checkTotalAdjustmentOfUserOrder(SearchUserContext userContext, BigDecimal totalAdjustment, List<Message> messageList)
	{
		
	 	checkMoneyAmount(totalAdjustment,0.00, 100.12,TOTAL_ADJUSTMENT_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AMOUNT_OF_USER_ORDER ="user_order.total_amount";
	protected void checkTotalAmountOfUserOrder(SearchUserContext userContext, BigDecimal totalAmount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(totalAmount,0.00, 10020.12,TOTAL_AMOUNT_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  USER_OF_USER_ORDER ="user_order.user";
	protected void checkUserIdOfUserOrder(SearchUserContext userContext, String userId, List<Message> messageList)
	{
		
	 	checkIdOfUserOrder(userContext,userId, messageList); 		
		
	}	 			
	
	public static final String  PLATFORM_OF_USER_ORDER ="user_order.platform";
	protected void checkPlatformIdOfUserOrder(SearchUserContext userContext, String platformId, List<Message> messageList)
	{
		
	 	checkIdOfUserOrder(userContext,platformId, messageList); 		
		
	}	 			
	
	public static final String  LAST_UPDATE_TIME_OF_USER_ORDER ="user_order.last_update_time";
	protected void checkLastUpdateTimeOfUserOrder(SearchUserContext userContext, String lastUpdateTime, List<Message> messageList)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_ORDER ="user_order.version";
	protected void checkVersionOfUserOrder(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LINE_ITEM ="line_item.id";
	protected void checkIdOfLineItem(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LINE_ITEM ="line_item.name";
	protected void checkNameOfLineItem(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  QUANTITY_OF_LINE_ITEM ="line_item.quantity";
	protected void checkQuantityOfLineItem(SearchUserContext userContext, int quantity, List<Message> messageList)
	{
		
	 	checkIntegerRange(quantity,0, 12,QUANTITY_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  PRICE_OF_LINE_ITEM ="line_item.price";
	protected void checkPriceOfLineItem(SearchUserContext userContext, BigDecimal price, List<Message> messageList)
	{
		
	 	checkMoneyAmount(price,0.00, 102.99,PRICE_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  DISCOUNT_PRICE_OF_LINE_ITEM ="line_item.discount_price";
	protected void checkDiscountPriceOfLineItem(SearchUserContext userContext, BigDecimal discountPrice, List<Message> messageList)
	{
		
	 	checkMoneyAmount(discountPrice,0.00, 11.03,DISCOUNT_PRICE_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_LINE_ITEM ="line_item.user_order";
	protected void checkUserOrderIdOfLineItem(SearchUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfLineItem(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LINE_ITEM ="line_item.version";
	protected void checkVersionOfLineItem(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ORDER_PROMOTION ="order_promotion.id";
	protected void checkIdOfOrderPromotion(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_ORDER_PROMOTION ="order_promotion.name";
	protected void checkNameOfOrderPromotion(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 60,NAME_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_ORDER_PROMOTION ="order_promotion.amount";
	protected void checkAmountOfOrderPromotion(SearchUserContext userContext, int amount, List<Message> messageList)
	{
		
	 	checkIntegerRange(amount,0, 1231,AMOUNT_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  THREAD_HOLD_OF_ORDER_PROMOTION ="order_promotion.thread_hold";
	protected void checkThreadHoldOfOrderPromotion(SearchUserContext userContext, int threadHold, List<Message> messageList)
	{
		
	 	checkIntegerRange(threadHold,0, 1230,THREAD_HOLD_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_ORDER_PROMOTION ="order_promotion.type";
	protected void checkTypeOfOrderPromotion(SearchUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,4, 44,TYPE_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_ORDER_PROMOTION ="order_promotion.user_order";
	protected void checkUserOrderIdOfOrderPromotion(SearchUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfOrderPromotion(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ORDER_PROMOTION ="order_promotion.version";
	protected void checkVersionOfOrderPromotion(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORDER_PROMOTION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MANUAL_ADJUSTMENT ="manual_adjustment.id";
	protected void checkIdOfManualAdjustment(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MANUAL_ADJUSTMENT ="manual_adjustment.name";
	protected void checkNameOfManualAdjustment(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 60,NAME_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_MANUAL_ADJUSTMENT ="manual_adjustment.amount";
	protected void checkAmountOfManualAdjustment(SearchUserContext userContext, int amount, List<Message> messageList)
	{
		
	 	checkIntegerRange(amount,0, 1231,AMOUNT_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  THREAD_HOLD_OF_MANUAL_ADJUSTMENT ="manual_adjustment.thread_hold";
	protected void checkThreadHoldOfManualAdjustment(SearchUserContext userContext, int threadHold, List<Message> messageList)
	{
		
	 	checkIntegerRange(threadHold,0, 1230,THREAD_HOLD_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_MANUAL_ADJUSTMENT ="manual_adjustment.type";
	protected void checkTypeOfManualAdjustment(SearchUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_MANUAL_ADJUSTMENT ="manual_adjustment.user_order";
	protected void checkUserOrderIdOfManualAdjustment(SearchUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfManualAdjustment(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MANUAL_ADJUSTMENT ="manual_adjustment.version";
	protected void checkVersionOfManualAdjustment(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MANUAL_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SHIPPING_GROUP ="shipping_group.id";
	protected void checkIdOfShippingGroup(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SHIPPING_GROUP ="shipping_group.name";
	protected void checkNameOfShippingGroup(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 48,NAME_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  LINE1_OF_SHIPPING_GROUP ="shipping_group.line1";
	protected void checkLine1OfShippingGroup(SearchUserContext userContext, String line1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(line1,7, 100,LINE1_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  LINE2_OF_SHIPPING_GROUP ="shipping_group.line2";
	protected void checkLine2OfShippingGroup(SearchUserContext userContext, String line2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(line2,4, 48,LINE2_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  CITY_OF_SHIPPING_GROUP ="shipping_group.city";
	protected void checkCityOfShippingGroup(SearchUserContext userContext, String city, List<Message> messageList)
	{
		
	 	checkStringLengthRange(city,4, 60,CITY_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  STATE_OF_SHIPPING_GROUP ="shipping_group.state";
	protected void checkStateOfShippingGroup(SearchUserContext userContext, String state, List<Message> messageList)
	{
		
	 	checkStringLengthRange(state,1, 8,STATE_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ZIP_CODE_OF_SHIPPING_GROUP ="shipping_group.zip_code";
	protected void checkZipCodeOfShippingGroup(SearchUserContext userContext, int zipCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(zipCode,0, 980087,ZIP_CODE_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  COUNTRY_OF_SHIPPING_GROUP ="shipping_group.country";
	protected void checkCountryOfShippingGroup(SearchUserContext userContext, String country, List<Message> messageList)
	{
		
	 	checkCountryCode(country,1, 8,COUNTRY_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_SHIPPING_GROUP ="shipping_group.user_order";
	protected void checkUserOrderIdOfShippingGroup(SearchUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfShippingGroup(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SHIPPING_GROUP ="shipping_group.version";
	protected void checkVersionOfShippingGroup(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PAYMENT_GROUP ="payment_group.id";
	protected void checkIdOfPaymentGroup(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PAYMENT_GROUP ="payment_group.name";
	protected void checkNameOfPaymentGroup(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_PAYMENT_GROUP ="payment_group.amount";
	protected void checkAmountOfPaymentGroup(SearchUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 123.00,AMOUNT_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  USER_ORDER_OF_PAYMENT_GROUP ="payment_group.user_order";
	protected void checkUserOrderIdOfPaymentGroup(SearchUserContext userContext, String userOrderId, List<Message> messageList)
	{
		
	 	checkIdOfPaymentGroup(userContext,userOrderId, messageList); 		
		
	}	 			
	
	public static final String  STATUS_OF_PAYMENT_GROUP ="payment_group.status";
	protected void checkStatusOfPaymentGroup(SearchUserContext userContext, String status, List<Message> messageList)
	{
		
	 	checkStringLengthRange(status,2, 28,STATUS_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PAYMENT_GROUP ="payment_group.version";
	protected void checkVersionOfPaymentGroup(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	protected void checkIdOfUserDomain(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	protected void checkNameOfUserDomain(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	protected void checkVersionOfUserDomain(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	protected void checkIdOfUserWhiteList(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	protected void checkUserIdentityOfUserWhiteList(SearchUserContext userContext, String userIdentity, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	protected void checkUserSpecialFunctionsOfUserWhiteList(SearchUserContext userContext, String userSpecialFunctions, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	protected void checkDomainIdOfUserWhiteList(SearchUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfUserWhiteList(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	protected void checkVersionOfUserWhiteList(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	protected void checkIdOfSecUser(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	protected void checkLoginOfSecUser(SearchUserContext userContext, String login, List<Message> messageList)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	protected void checkMobileOfSecUser(SearchUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	protected void checkEmailOfSecUser(SearchUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	protected void checkPwdOfSecUser(SearchUserContext userContext, String pwd, List<Message> messageList)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	protected void checkVerificationCodeOfSecUser(SearchUserContext userContext, int verificationCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	protected void checkVerificationCodeExpireOfSecUser(SearchUserContext userContext, DateTime verificationCodeExpire, List<Message> messageList)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	protected void checkLastLoginTimeOfSecUser(SearchUserContext userContext, DateTime lastLoginTime, List<Message> messageList)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	protected void checkDomainIdOfSecUser(SearchUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfSecUser(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	protected void checkVersionOfSecUser(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	protected void checkIdOfSecUserBlocking(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	protected void checkWhoOfSecUserBlocking(SearchUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	protected void checkCommentsOfSecUserBlocking(SearchUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	protected void checkVersionOfSecUserBlocking(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_APP ="user_app.id";
	protected void checkIdOfUserApp(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	protected void checkTitleOfUserApp(SearchUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	protected void checkSecUserIdOfUserApp(SearchUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfUserApp(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	protected void checkAppIconOfUserApp(SearchUserContext userContext, String appIcon, List<Message> messageList)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	protected void checkFullAccessOfUserApp(SearchUserContext userContext, boolean fullAccess, List<Message> messageList)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	protected void checkPermissionOfUserApp(SearchUserContext userContext, String permission, List<Message> messageList)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	protected void checkObjectTypeOfUserApp(SearchUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	protected void checkObjectIdOfUserApp(SearchUserContext userContext, String objectId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	protected void checkLocationOfUserApp(SearchUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	protected void checkVersionOfUserApp(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	protected void checkIdOfListAccess(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	protected void checkNameOfListAccess(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	protected void checkInternalNameOfListAccess(SearchUserContext userContext, String internalName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	protected void checkReadPermissionOfListAccess(SearchUserContext userContext, boolean readPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	protected void checkCreatePermissionOfListAccess(SearchUserContext userContext, boolean createPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	protected void checkDeletePermissionOfListAccess(SearchUserContext userContext, boolean deletePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	protected void checkUpdatePermissionOfListAccess(SearchUserContext userContext, boolean updatePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	protected void checkExecutionPermissionOfListAccess(SearchUserContext userContext, boolean executionPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	protected void checkAppIdOfListAccess(SearchUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfListAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	protected void checkVersionOfListAccess(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	protected void checkIdOfObjectAccess(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	protected void checkNameOfObjectAccess(SearchUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	protected void checkObjectTypeOfObjectAccess(SearchUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	protected void checkList1OfObjectAccess(SearchUserContext userContext, String list1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	protected void checkList2OfObjectAccess(SearchUserContext userContext, String list2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	protected void checkList3OfObjectAccess(SearchUserContext userContext, String list3, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	protected void checkList4OfObjectAccess(SearchUserContext userContext, String list4, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	protected void checkList5OfObjectAccess(SearchUserContext userContext, String list5, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	protected void checkList6OfObjectAccess(SearchUserContext userContext, String list6, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	protected void checkList7OfObjectAccess(SearchUserContext userContext, String list7, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	protected void checkList8OfObjectAccess(SearchUserContext userContext, String list8, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	protected void checkList9OfObjectAccess(SearchUserContext userContext, String list9, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	protected void checkAppIdOfObjectAccess(SearchUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfObjectAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	protected void checkVersionOfObjectAccess(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	protected void checkIdOfLoginHistory(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	protected void checkFromIpOfLoginHistory(SearchUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	protected void checkDescriptionOfLoginHistory(SearchUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	protected void checkSecUserIdOfLoginHistory(SearchUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfLoginHistory(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	protected void checkVersionOfLoginHistory(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	protected void checkIdOfGenericForm(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	protected void checkTitleOfGenericForm(SearchUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	protected void checkDescriptionOfGenericForm(SearchUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	protected void checkVersionOfGenericForm(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	protected void checkIdOfFormMessage(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	protected void checkTitleOfFormMessage(SearchUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	protected void checkFormIdOfFormMessage(SearchUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	protected void checkLevelOfFormMessage(SearchUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	protected void checkVersionOfFormMessage(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	protected void checkIdOfFormFieldMessage(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	protected void checkTitleOfFormFieldMessage(SearchUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	protected void checkParameterNameOfFormFieldMessage(SearchUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	protected void checkFormIdOfFormFieldMessage(SearchUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormFieldMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	protected void checkLevelOfFormFieldMessage(SearchUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	protected void checkVersionOfFormFieldMessage(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	protected void checkIdOfFormField(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	protected void checkLabelOfFormField(SearchUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	protected void checkLocaleKeyOfFormField(SearchUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	protected void checkParameterNameOfFormField(SearchUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	protected void checkTypeOfFormField(SearchUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	protected void checkFormIdOfFormField(SearchUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormField(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	protected void checkPlaceholderOfFormField(SearchUserContext userContext, String placeholder, List<Message> messageList)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	protected void checkDefaultValueOfFormField(SearchUserContext userContext, String defaultValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	protected void checkDescriptionOfFormField(SearchUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	protected void checkFieldGroupOfFormField(SearchUserContext userContext, String fieldGroup, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	protected void checkMinimumValueOfFormField(SearchUserContext userContext, String minimumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	protected void checkMaximumValueOfFormField(SearchUserContext userContext, String maximumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	protected void checkRequiredOfFormField(SearchUserContext userContext, boolean required, List<Message> messageList)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	protected void checkDisabledOfFormField(SearchUserContext userContext, boolean disabled, List<Message> messageList)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	protected void checkCustomRenderingOfFormField(SearchUserContext userContext, boolean customRendering, List<Message> messageList)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	protected void checkCandidateValuesOfFormField(SearchUserContext userContext, String candidateValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	protected void checkSuggestValuesOfFormField(SearchUserContext userContext, String suggestValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	protected void checkVersionOfFormField(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	protected void checkIdOfFormAction(SearchUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	protected void checkLabelOfFormAction(SearchUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	protected void checkLocaleKeyOfFormAction(SearchUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	protected void checkActionKeyOfFormAction(SearchUserContext userContext, String actionKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	protected void checkLevelOfFormAction(SearchUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	protected void checkUrlOfFormAction(SearchUserContext userContext, String url, List<Message> messageList)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	protected void checkFormIdOfFormAction(SearchUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormAction(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	protected void checkVersionOfFormAction(SearchUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION, messageList); 		
		
	}	 			public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof SearchUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return accessOK();
		}
		SearchUserContext userContext = (SearchUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return accessOK();
		}
		return super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(SearchUserContext userContext, List<Message> messageList, Class<? extends SearchException> exceptionClazz) throws Exception{
		//translate messages;
		if(messageList.isEmpty()){
			return;
		}
		
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

	}
	*/

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, SearchException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}











