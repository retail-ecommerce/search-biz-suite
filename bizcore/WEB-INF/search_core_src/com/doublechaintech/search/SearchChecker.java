package com.doublechaintech.search;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class SearchChecker extends BaseChecker{
	
	
	protected SearchUserContext userContext;
	public SearchUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(SearchUserContext userContext) {
		this.userContext = userContext;
	}
	
	public SearchChecker() {
		this.messageList = new ArrayList<Message>();
	}

	

	public static final String  ID_OF_PLATFORM ="platform.id";
	public SearchChecker checkIdOfPlatform(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PLATFORM ="platform.name";
	public SearchChecker checkNameOfPlatform(String name)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  INTRODUCTION_OF_PLATFORM ="platform.introduction";
	public SearchChecker checkIntroductionOfPlatform(String introduction)
	{
		
	 	checkStringLengthRange(introduction,19, 288,INTRODUCTION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  CURRENT_VERSION_OF_PLATFORM ="platform.current_version";
	public SearchChecker checkCurrentVersionOfPlatform(String currentVersion)
	{
		
	 	checkStringLengthRange(currentVersion,2, 16,CURRENT_VERSION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PLATFORM ="platform.version";
	public SearchChecker checkVersionOfPlatform(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SITE ="site.id";
	public SearchChecker checkIdOfSite(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SITE ="site.name";
	public SearchChecker checkNameOfSite(String name)
	{
		
	 	checkStringLengthRange(name,6, 92,NAME_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  INTRODUCTION_OF_SITE ="site.introduction";
	public SearchChecker checkIntroductionOfSite(String introduction)
	{
		
	 	checkStringLengthRange(introduction,10, 148,INTRODUCTION_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_SITE ="site.platform";
	public SearchChecker checkPlatformIdOfSite(String platformId)
	{
		
	 	checkIdOfSite(platformId ); 		
		
		return this;
	}	 			

	public static final String  LAST_UPDATE_TIME_OF_SITE ="site.last_update_time";
	public SearchChecker checkLastUpdateTimeOfSite(String lastUpdateTime)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SITE ="site.version";
	public SearchChecker checkVersionOfSite(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SITE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CATALOG ="catalog.id";
	public SearchChecker checkIdOfCatalog(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  DISPLAY_NAME_OF_CATALOG ="catalog.display_name";
	public SearchChecker checkDisplayNameOfCatalog(String displayName)
	{
		
	 	checkStringLengthRange(displayName,2, 20,DISPLAY_NAME_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  SELLER_ID_OF_CATALOG ="catalog.seller_id";
	public SearchChecker checkSellerIdOfCatalog(String sellerId)
	{
		
	 	checkStringLengthRange(sellerId,3, 32,SELLER_ID_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  SITE_OF_CATALOG ="catalog.site";
	public SearchChecker checkSiteIdOfCatalog(String siteId)
	{
		
	 	checkIdOfCatalog(siteId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CATALOG ="catalog.version";
	public SearchChecker checkVersionOfCatalog(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	public SearchChecker checkIdOfLevelOneCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	public SearchChecker checkCatalogIdOfLevelOneCategory(String catalogId)
	{
		
	 	checkIdOfLevelOneCategory(catalogId ); 		
		
		return this;
	}	 			

	public static final String  DISPLAY_NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.display_name";
	public SearchChecker checkDisplayNameOfLevelOneCategory(String displayName)
	{
		
	 	checkStringLengthRange(displayName,4, 52,DISPLAY_NAME_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	public SearchChecker checkVersionOfLevelOneCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	public SearchChecker checkIdOfLevelTwoCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	public SearchChecker checkParentCategoryIdOfLevelTwoCategory(String parentCategoryId)
	{
		
	 	checkIdOfLevelTwoCategory(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  DISPLAY_NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.display_name";
	public SearchChecker checkDisplayNameOfLevelTwoCategory(String displayName)
	{
		
	 	checkStringLengthRange(displayName,4, 52,DISPLAY_NAME_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	public SearchChecker checkVersionOfLevelTwoCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_N_CATEGORY ="level_n_category.id";
	public SearchChecker checkIdOfLevelNCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_N_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_LEVEL_N_CATEGORY ="level_n_category.parent_category";
	public SearchChecker checkParentCategoryIdOfLevelNCategory(String parentCategoryId)
	{
		
	 	checkIdOfLevelNCategory(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  DISPLAY_NAME_OF_LEVEL_N_CATEGORY ="level_n_category.display_name";
	public SearchChecker checkDisplayNameOfLevelNCategory(String displayName)
	{
		
	 	checkStringLengthRange(displayName,3, 44,DISPLAY_NAME_OF_LEVEL_N_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_N_CATEGORY ="level_n_category.version";
	public SearchChecker checkVersionOfLevelNCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_N_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_BRAND ="brand.id";
	public SearchChecker checkIdOfBrand(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  BRAND_NAME_OF_BRAND ="brand.brand_name";
	public SearchChecker checkBrandNameOfBrand(String brandName)
	{
		
	 	checkStringLengthRange(brandName,3, 40,BRAND_NAME_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  LOGO_OF_BRAND ="brand.logo";
	public SearchChecker checkLogoOfBrand(String logo)
	{
		
	 	checkImage(logo,0, 512,LOGO_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_BRAND ="brand.remark";
	public SearchChecker checkRemarkOfBrand(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_BRAND ="brand.version";
	public SearchChecker checkVersionOfBrand(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_BRAND ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PRODUCT ="product.id";
	public SearchChecker checkIdOfProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  DISPLAY_NAME_OF_PRODUCT ="product.display_name";
	public SearchChecker checkDisplayNameOfProduct(String displayName)
	{
		
	 	checkStringLengthRange(displayName,2, 20,DISPLAY_NAME_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	public SearchChecker checkParentCategoryIdOfProduct(String parentCategoryId)
	{
		
	 	checkIdOfProduct(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  BRAND_OF_PRODUCT ="product.brand";
	public SearchChecker checkBrandIdOfProduct(String brandId)
	{
		
	 	checkIdOfProduct(brandId ); 		
		
		return this;
	}	 			

	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	public SearchChecker checkOriginOfProduct(String origin)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_PRODUCT ="product.catalog";
	public SearchChecker checkCatalogIdOfProduct(String catalogId)
	{
		
	 	checkIdOfProduct(catalogId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_PRODUCT ="product.remark";
	public SearchChecker checkRemarkOfProduct(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  LAST_UPDATE_TIME_OF_PRODUCT ="product.last_update_time";
	public SearchChecker checkLastUpdateTimeOfProduct(String lastUpdateTime)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PRODUCT ="product.version";
	public SearchChecker checkVersionOfProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PRODUCT_RECOMMENDATION ="product_recommendation.id";
	public SearchChecker checkIdOfProductRecommendation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT_RECOMMENDATION ); 		
		
		return this;
	}	 			

	public static final String  DISPLAY_NAME_OF_PRODUCT_RECOMMENDATION ="product_recommendation.display_name";
	public SearchChecker checkDisplayNameOfProductRecommendation(String displayName)
	{
		
	 	checkStringLengthRange(displayName,2, 20,DISPLAY_NAME_OF_PRODUCT_RECOMMENDATION ); 		
		
		return this;
	}	 			

	public static final String  BRAND_OF_PRODUCT_RECOMMENDATION ="product_recommendation.brand";
	public SearchChecker checkBrandIdOfProductRecommendation(String brandId)
	{
		
	 	checkIdOfProductRecommendation(brandId ); 		
		
		return this;
	}	 			

	public static final String  ORIGIN_OF_PRODUCT_RECOMMENDATION ="product_recommendation.origin";
	public SearchChecker checkOriginOfProductRecommendation(String origin)
	{
		
	 	checkStringLengthRange(origin,1, 24,ORIGIN_OF_PRODUCT_RECOMMENDATION ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_OF_PRODUCT_RECOMMENDATION ="product_recommendation.product";
	public SearchChecker checkProductIdOfProductRecommendation(String productId)
	{
		
	 	checkIdOfProductRecommendation(productId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_PRODUCT_RECOMMENDATION ="product_recommendation.remark";
	public SearchChecker checkRemarkOfProductRecommendation(String remark)
	{
		
	 	checkStringLengthRange(remark,22, 336,REMARK_OF_PRODUCT_RECOMMENDATION ); 		
		
		return this;
	}	 			

	public static final String  LAST_UPDATE_TIME_OF_PRODUCT_RECOMMENDATION ="product_recommendation.last_update_time";
	public SearchChecker checkLastUpdateTimeOfProductRecommendation(String lastUpdateTime)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_PRODUCT_RECOMMENDATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PRODUCT_RECOMMENDATION ="product_recommendation.version";
	public SearchChecker checkVersionOfProductRecommendation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT_RECOMMENDATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SKU ="sku.id";
	public SearchChecker checkIdOfSku(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  DISPLAY_NAME_OF_SKU ="sku.display_name";
	public SearchChecker checkDisplayNameOfSku(String displayName)
	{
		
	 	checkStringLengthRange(displayName,4, 52,DISPLAY_NAME_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  SIZE_OF_SKU ="sku.size";
	public SearchChecker checkSizeOfSku(String size)
	{
		
	 	checkStringLengthRange(size,2, 24,SIZE_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_OF_SKU ="sku.product";
	public SearchChecker checkProductIdOfSku(String productId)
	{
		
	 	checkIdOfSku(productId ); 		
		
		return this;
	}	 			

	public static final String  ACTIVE_OF_SKU ="sku.active";
	public SearchChecker checkActiveOfSku(boolean active)
	{
		
	 	checkBooleanRange(active,0, true,ACTIVE_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  BASE_PRICE_OF_SKU ="sku.base_price";
	public SearchChecker checkBasePriceOfSku(BigDecimal basePrice)
	{
		
	 	checkMoneyAmount(basePrice,0.00, 103.21,BASE_PRICE_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  LAST_UPDATE_TIME_OF_SKU ="sku.last_update_time";
	public SearchChecker checkLastUpdateTimeOfSku(String lastUpdateTime)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SKU ="sku.version";
	public SearchChecker checkVersionOfSku(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PROFILE ="profile.id";
	public SearchChecker checkIdOfProfile(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PROFILE ="profile.name";
	public SearchChecker checkNameOfProfile(String name)
	{
		
	 	checkStringLengthRange(name,6, 72,NAME_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  AGE_OF_PROFILE ="profile.age";
	public SearchChecker checkAgeOfProfile(int age)
	{
		
	 	checkIntegerRange(age,0, 40,AGE_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  GENDER_OF_PROFILE ="profile.gender";
	public SearchChecker checkGenderOfProfile(String gender)
	{
		
	 	checkGender(gender,2, 24,GENDER_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  LAST_UPDATE_TIME_OF_PROFILE ="profile.last_update_time";
	public SearchChecker checkLastUpdateTimeOfProfile(String lastUpdateTime)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_PROFILE ="profile.platform";
	public SearchChecker checkPlatformIdOfProfile(String platformId)
	{
		
	 	checkIdOfProfile(platformId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PROFILE ="profile.version";
	public SearchChecker checkVersionOfProfile(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFILE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SHIPPING_ADDRESS ="shipping_address.id";
	public SearchChecker checkIdOfShippingAddress(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SHIPPING_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SHIPPING_ADDRESS ="shipping_address.name";
	public SearchChecker checkNameOfShippingAddress(String name)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_SHIPPING_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  LINE1_OF_SHIPPING_ADDRESS ="shipping_address.line1";
	public SearchChecker checkLine1OfShippingAddress(String line1)
	{
		
	 	checkStringLengthRange(line1,7, 100,LINE1_OF_SHIPPING_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  LINE2_OF_SHIPPING_ADDRESS ="shipping_address.line2";
	public SearchChecker checkLine2OfShippingAddress(String line2)
	{
		
	 	checkStringLengthRange(line2,4, 48,LINE2_OF_SHIPPING_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  CITY_OF_SHIPPING_ADDRESS ="shipping_address.city";
	public SearchChecker checkCityOfShippingAddress(String city)
	{
		
	 	checkStringLengthRange(city,4, 60,CITY_OF_SHIPPING_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  STATE_OF_SHIPPING_ADDRESS ="shipping_address.state";
	public SearchChecker checkStateOfShippingAddress(String state)
	{
		
	 	checkStringLengthRange(state,1, 8,STATE_OF_SHIPPING_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  ZIP_CODE_OF_SHIPPING_ADDRESS ="shipping_address.zip_code";
	public SearchChecker checkZipCodeOfShippingAddress(int zipCode)
	{
		
	 	checkIntegerRange(zipCode,0, 980087,ZIP_CODE_OF_SHIPPING_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SHIPPING_ADDRESS ="shipping_address.version";
	public SearchChecker checkVersionOfShippingAddress(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PAYMENT_METHOD ="payment_method.id";
	public SearchChecker checkIdOfPaymentMethod(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PAYMENT_METHOD ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PAYMENT_METHOD ="payment_method.name";
	public SearchChecker checkNameOfPaymentMethod(String name)
	{
		
	 	checkStringLengthRange(name,4, 44,NAME_OF_PAYMENT_METHOD ); 		
		
		return this;
	}	 			

	public static final String  NUMBER_OF_PAYMENT_METHOD ="payment_method.number";
	public SearchChecker checkNumberOfPaymentMethod(String number)
	{
		
	 	checkStringLengthRange(number,6, 52,NUMBER_OF_PAYMENT_METHOD ); 		
		
		return this;
	}	 			

	public static final String  LINE1_OF_PAYMENT_METHOD ="payment_method.line1";
	public SearchChecker checkLine1OfPaymentMethod(String line1)
	{
		
	 	checkStringLengthRange(line1,6, 88,LINE1_OF_PAYMENT_METHOD ); 		
		
		return this;
	}	 			

	public static final String  LINE2_OF_PAYMENT_METHOD ="payment_method.line2";
	public SearchChecker checkLine2OfPaymentMethod(String line2)
	{
		
	 	checkStringLengthRange(line2,3, 40,LINE2_OF_PAYMENT_METHOD ); 		
		
		return this;
	}	 			

	public static final String  CITY_OF_PAYMENT_METHOD ="payment_method.city";
	public SearchChecker checkCityOfPaymentMethod(String city)
	{
		
	 	checkStringLengthRange(city,4, 48,CITY_OF_PAYMENT_METHOD ); 		
		
		return this;
	}	 			

	public static final String  EXPIRE_ON_OF_PAYMENT_METHOD ="payment_method.expire_on";
	public SearchChecker checkExpireOnOfPaymentMethod(Date expireOn)
	{
		
	 	checkDateRange(expireOn,parseDate("1900-01-01"), parseDate("2019-08-08"),EXPIRE_ON_OF_PAYMENT_METHOD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PAYMENT_METHOD ="payment_method.version";
	public SearchChecker checkVersionOfPaymentMethod(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYMENT_METHOD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_ORDER ="user_order.id";
	public SearchChecker checkIdOfUserOrder(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_USER_ORDER ="user_order.title";
	public SearchChecker checkTitleOfUserOrder(String title)
	{
		
	 	checkStringLengthRange(title,5, 64,TITLE_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_ADJUSTMENT_OF_USER_ORDER ="user_order.total_adjustment";
	public SearchChecker checkTotalAdjustmentOfUserOrder(BigDecimal totalAdjustment)
	{
		
	 	checkMoneyAmount(totalAdjustment,0.00, 100.12,TOTAL_ADJUSTMENT_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AMOUNT_OF_USER_ORDER ="user_order.total_amount";
	public SearchChecker checkTotalAmountOfUserOrder(BigDecimal totalAmount)
	{
		
	 	checkMoneyAmount(totalAmount,0.00, 10020.12,TOTAL_AMOUNT_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  USER_OF_USER_ORDER ="user_order.user";
	public SearchChecker checkUserIdOfUserOrder(String userId)
	{
		
	 	checkIdOfUserOrder(userId ); 		
		
		return this;
	}	 			

	public static final String  PLATFORM_OF_USER_ORDER ="user_order.platform";
	public SearchChecker checkPlatformIdOfUserOrder(String platformId)
	{
		
	 	checkIdOfUserOrder(platformId ); 		
		
		return this;
	}	 			

	public static final String  LAST_UPDATE_TIME_OF_USER_ORDER ="user_order.last_update_time";
	public SearchChecker checkLastUpdateTimeOfUserOrder(String lastUpdateTime)
	{
		
	 	checkStringLengthRange(lastUpdateTime,5, 64,LAST_UPDATE_TIME_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_ORDER ="user_order.version";
	public SearchChecker checkVersionOfUserOrder(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LINE_ITEM ="line_item.id";
	public SearchChecker checkIdOfLineItem(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LINE_ITEM ="line_item.name";
	public SearchChecker checkNameOfLineItem(String name)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  QUANTITY_OF_LINE_ITEM ="line_item.quantity";
	public SearchChecker checkQuantityOfLineItem(int quantity)
	{
		
	 	checkIntegerRange(quantity,0, 12,QUANTITY_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  PRICE_OF_LINE_ITEM ="line_item.price";
	public SearchChecker checkPriceOfLineItem(BigDecimal price)
	{
		
	 	checkMoneyAmount(price,0.00, 102.99,PRICE_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  DISCOUNT_PRICE_OF_LINE_ITEM ="line_item.discount_price";
	public SearchChecker checkDiscountPriceOfLineItem(BigDecimal discountPrice)
	{
		
	 	checkMoneyAmount(discountPrice,0.00, 11.03,DISCOUNT_PRICE_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_LINE_ITEM ="line_item.user_order";
	public SearchChecker checkUserOrderIdOfLineItem(String userOrderId)
	{
		
	 	checkIdOfLineItem(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LINE_ITEM ="line_item.version";
	public SearchChecker checkVersionOfLineItem(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ORDER_PROMOTION ="order_promotion.id";
	public SearchChecker checkIdOfOrderPromotion(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_ORDER_PROMOTION ="order_promotion.name";
	public SearchChecker checkNameOfOrderPromotion(String name)
	{
		
	 	checkStringLengthRange(name,4, 60,NAME_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_ORDER_PROMOTION ="order_promotion.amount";
	public SearchChecker checkAmountOfOrderPromotion(int amount)
	{
		
	 	checkIntegerRange(amount,0, 1231,AMOUNT_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  THREAD_HOLD_OF_ORDER_PROMOTION ="order_promotion.thread_hold";
	public SearchChecker checkThreadHoldOfOrderPromotion(int threadHold)
	{
		
	 	checkIntegerRange(threadHold,0, 1230,THREAD_HOLD_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_ORDER_PROMOTION ="order_promotion.type";
	public SearchChecker checkTypeOfOrderPromotion(String type)
	{
		
	 	checkStringLengthRange(type,4, 44,TYPE_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_ORDER_PROMOTION ="order_promotion.user_order";
	public SearchChecker checkUserOrderIdOfOrderPromotion(String userOrderId)
	{
		
	 	checkIdOfOrderPromotion(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ORDER_PROMOTION ="order_promotion.version";
	public SearchChecker checkVersionOfOrderPromotion(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORDER_PROMOTION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MANUAL_ADJUSTMENT ="manual_adjustment.id";
	public SearchChecker checkIdOfManualAdjustment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MANUAL_ADJUSTMENT ="manual_adjustment.name";
	public SearchChecker checkNameOfManualAdjustment(String name)
	{
		
	 	checkStringLengthRange(name,4, 60,NAME_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_MANUAL_ADJUSTMENT ="manual_adjustment.amount";
	public SearchChecker checkAmountOfManualAdjustment(int amount)
	{
		
	 	checkIntegerRange(amount,0, 1231,AMOUNT_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  THREAD_HOLD_OF_MANUAL_ADJUSTMENT ="manual_adjustment.thread_hold";
	public SearchChecker checkThreadHoldOfManualAdjustment(int threadHold)
	{
		
	 	checkIntegerRange(threadHold,0, 1230,THREAD_HOLD_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_MANUAL_ADJUSTMENT ="manual_adjustment.type";
	public SearchChecker checkTypeOfManualAdjustment(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_MANUAL_ADJUSTMENT ="manual_adjustment.user_order";
	public SearchChecker checkUserOrderIdOfManualAdjustment(String userOrderId)
	{
		
	 	checkIdOfManualAdjustment(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MANUAL_ADJUSTMENT ="manual_adjustment.version";
	public SearchChecker checkVersionOfManualAdjustment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MANUAL_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SHIPPING_GROUP ="shipping_group.id";
	public SearchChecker checkIdOfShippingGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SHIPPING_GROUP ="shipping_group.name";
	public SearchChecker checkNameOfShippingGroup(String name)
	{
		
	 	checkStringLengthRange(name,4, 48,NAME_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  LINE1_OF_SHIPPING_GROUP ="shipping_group.line1";
	public SearchChecker checkLine1OfShippingGroup(String line1)
	{
		
	 	checkStringLengthRange(line1,7, 100,LINE1_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  LINE2_OF_SHIPPING_GROUP ="shipping_group.line2";
	public SearchChecker checkLine2OfShippingGroup(String line2)
	{
		
	 	checkStringLengthRange(line2,4, 48,LINE2_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  CITY_OF_SHIPPING_GROUP ="shipping_group.city";
	public SearchChecker checkCityOfShippingGroup(String city)
	{
		
	 	checkStringLengthRange(city,4, 60,CITY_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  STATE_OF_SHIPPING_GROUP ="shipping_group.state";
	public SearchChecker checkStateOfShippingGroup(String state)
	{
		
	 	checkStringLengthRange(state,1, 8,STATE_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ZIP_CODE_OF_SHIPPING_GROUP ="shipping_group.zip_code";
	public SearchChecker checkZipCodeOfShippingGroup(int zipCode)
	{
		
	 	checkIntegerRange(zipCode,0, 980087,ZIP_CODE_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  COUNTRY_OF_SHIPPING_GROUP ="shipping_group.country";
	public SearchChecker checkCountryOfShippingGroup(String country)
	{
		
	 	checkCountryCode(country,1, 8,COUNTRY_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_SHIPPING_GROUP ="shipping_group.user_order";
	public SearchChecker checkUserOrderIdOfShippingGroup(String userOrderId)
	{
		
	 	checkIdOfShippingGroup(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SHIPPING_GROUP ="shipping_group.version";
	public SearchChecker checkVersionOfShippingGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PAYMENT_GROUP ="payment_group.id";
	public SearchChecker checkIdOfPaymentGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PAYMENT_GROUP ="payment_group.name";
	public SearchChecker checkNameOfPaymentGroup(String name)
	{
		
	 	checkStringLengthRange(name,4, 52,NAME_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_PAYMENT_GROUP ="payment_group.amount";
	public SearchChecker checkAmountOfPaymentGroup(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 123.00,AMOUNT_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  USER_ORDER_OF_PAYMENT_GROUP ="payment_group.user_order";
	public SearchChecker checkUserOrderIdOfPaymentGroup(String userOrderId)
	{
		
	 	checkIdOfPaymentGroup(userOrderId ); 		
		
		return this;
	}	 			

	public static final String  STATUS_OF_PAYMENT_GROUP ="payment_group.status";
	public SearchChecker checkStatusOfPaymentGroup(String status)
	{
		
	 	checkStringLengthRange(status,2, 28,STATUS_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PAYMENT_GROUP ="payment_group.version";
	public SearchChecker checkVersionOfPaymentGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public SearchChecker checkIdOfUserDomain(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public SearchChecker checkNameOfUserDomain(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public SearchChecker checkVersionOfUserDomain(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public SearchChecker checkIdOfUserWhiteList(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public SearchChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public SearchChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public SearchChecker checkDomainIdOfUserWhiteList(String domainId)
	{
		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public SearchChecker checkVersionOfUserWhiteList(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public SearchChecker checkIdOfSecUser(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public SearchChecker checkLoginOfSecUser(String login)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public SearchChecker checkMobileOfSecUser(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public SearchChecker checkEmailOfSecUser(String email)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public SearchChecker checkPwdOfSecUser(String pwd)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public SearchChecker checkVerificationCodeOfSecUser(int verificationCode)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public SearchChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public SearchChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public SearchChecker checkDomainIdOfSecUser(String domainId)
	{
		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public SearchChecker checkVersionOfSecUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	public SearchChecker checkIdOfSecUserBlocking(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	public SearchChecker checkWhoOfSecUserBlocking(String who)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	public SearchChecker checkCommentsOfSecUserBlocking(String comments)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	public SearchChecker checkVersionOfSecUserBlocking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_APP ="user_app.id";
	public SearchChecker checkIdOfUserApp(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public SearchChecker checkTitleOfUserApp(String title)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public SearchChecker checkSecUserIdOfUserApp(String secUserId)
	{
		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	 			

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public SearchChecker checkAppIconOfUserApp(String appIcon)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public SearchChecker checkFullAccessOfUserApp(boolean fullAccess)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public SearchChecker checkPermissionOfUserApp(String permission)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public SearchChecker checkObjectTypeOfUserApp(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public SearchChecker checkObjectIdOfUserApp(String objectId)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public SearchChecker checkLocationOfUserApp(String location)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public SearchChecker checkVersionOfUserApp(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public SearchChecker checkIdOfListAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public SearchChecker checkNameOfListAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public SearchChecker checkInternalNameOfListAccess(String internalName)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public SearchChecker checkReadPermissionOfListAccess(boolean readPermission)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public SearchChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public SearchChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public SearchChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public SearchChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public SearchChecker checkAppIdOfListAccess(String appId)
	{
		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public SearchChecker checkVersionOfListAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public SearchChecker checkIdOfObjectAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public SearchChecker checkNameOfObjectAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public SearchChecker checkObjectTypeOfObjectAccess(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public SearchChecker checkList1OfObjectAccess(String list1)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public SearchChecker checkList2OfObjectAccess(String list2)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public SearchChecker checkList3OfObjectAccess(String list3)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public SearchChecker checkList4OfObjectAccess(String list4)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public SearchChecker checkList5OfObjectAccess(String list5)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public SearchChecker checkList6OfObjectAccess(String list6)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public SearchChecker checkList7OfObjectAccess(String list7)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public SearchChecker checkList8OfObjectAccess(String list8)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public SearchChecker checkList9OfObjectAccess(String list9)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public SearchChecker checkAppIdOfObjectAccess(String appId)
	{
		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public SearchChecker checkVersionOfObjectAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public SearchChecker checkIdOfLoginHistory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public SearchChecker checkFromIpOfLoginHistory(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public SearchChecker checkDescriptionOfLoginHistory(String description)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public SearchChecker checkSecUserIdOfLoginHistory(String secUserId)
	{
		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public SearchChecker checkVersionOfLoginHistory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public SearchChecker checkIdOfGenericForm(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public SearchChecker checkTitleOfGenericForm(String title)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public SearchChecker checkDescriptionOfGenericForm(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public SearchChecker checkVersionOfGenericForm(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public SearchChecker checkIdOfFormMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public SearchChecker checkTitleOfFormMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public SearchChecker checkFormIdOfFormMessage(String formId)
	{
		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public SearchChecker checkLevelOfFormMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public SearchChecker checkVersionOfFormMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public SearchChecker checkIdOfFormFieldMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public SearchChecker checkTitleOfFormFieldMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public SearchChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public SearchChecker checkFormIdOfFormFieldMessage(String formId)
	{
		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public SearchChecker checkLevelOfFormFieldMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public SearchChecker checkVersionOfFormFieldMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public SearchChecker checkIdOfFormField(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public SearchChecker checkLabelOfFormField(String label)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public SearchChecker checkLocaleKeyOfFormField(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public SearchChecker checkParameterNameOfFormField(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public SearchChecker checkTypeOfFormField(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public SearchChecker checkFormIdOfFormField(String formId)
	{
		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	 			

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public SearchChecker checkPlaceholderOfFormField(String placeholder)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public SearchChecker checkDefaultValueOfFormField(String defaultValue)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public SearchChecker checkDescriptionOfFormField(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public SearchChecker checkFieldGroupOfFormField(String fieldGroup)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public SearchChecker checkMinimumValueOfFormField(String minimumValue)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public SearchChecker checkMaximumValueOfFormField(String maximumValue)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public SearchChecker checkRequiredOfFormField(boolean required)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public SearchChecker checkDisabledOfFormField(boolean disabled)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public SearchChecker checkCustomRenderingOfFormField(boolean customRendering)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public SearchChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public SearchChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public SearchChecker checkVersionOfFormField(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public SearchChecker checkIdOfFormAction(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public SearchChecker checkLabelOfFormAction(String label)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public SearchChecker checkLocaleKeyOfFormAction(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public SearchChecker checkActionKeyOfFormAction(String actionKey)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public SearchChecker checkLevelOfFormAction(String level)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public SearchChecker checkUrlOfFormAction(String url)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public SearchChecker checkFormIdOfFormAction(String formId)
	{
		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public SearchChecker checkVersionOfFormAction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	 			
	public void throwExceptionIfHasErrors(Class<? extends Exception> exceptionClazz) throws Exception {
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

    
}












