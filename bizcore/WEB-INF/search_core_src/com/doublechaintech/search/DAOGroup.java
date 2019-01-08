package com.doublechaintech.search;

import java.util.HashMap;
import java.util.Map;

import com.doublechaintech.search.platform.Platform;
import com.doublechaintech.search.platform.PlatformDAO;
import com.doublechaintech.search.platform.PlatformTokens;
import com.doublechaintech.search.site.Site;
import com.doublechaintech.search.site.SiteDAO;
import com.doublechaintech.search.site.SiteTokens;
import com.doublechaintech.search.catalog.Catalog;
import com.doublechaintech.search.catalog.CatalogDAO;
import com.doublechaintech.search.catalog.CatalogTokens;
import com.doublechaintech.search.levelonecategory.LevelOneCategory;
import com.doublechaintech.search.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.search.levelonecategory.LevelOneCategoryTokens;
import com.doublechaintech.search.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.search.leveltwocategory.LevelTwoCategoryDAO;
import com.doublechaintech.search.leveltwocategory.LevelTwoCategoryTokens;
import com.doublechaintech.search.levelncategory.LevelNCategory;
import com.doublechaintech.search.levelncategory.LevelNCategoryDAO;
import com.doublechaintech.search.levelncategory.LevelNCategoryTokens;
import com.doublechaintech.search.brand.Brand;
import com.doublechaintech.search.brand.BrandDAO;
import com.doublechaintech.search.brand.BrandTokens;
import com.doublechaintech.search.product.Product;
import com.doublechaintech.search.product.ProductDAO;
import com.doublechaintech.search.product.ProductTokens;
import com.doublechaintech.search.productrecommendation.ProductRecommendation;
import com.doublechaintech.search.productrecommendation.ProductRecommendationDAO;
import com.doublechaintech.search.productrecommendation.ProductRecommendationTokens;
import com.doublechaintech.search.sku.Sku;
import com.doublechaintech.search.sku.SkuDAO;
import com.doublechaintech.search.sku.SkuTokens;
import com.doublechaintech.search.profile.Profile;
import com.doublechaintech.search.profile.ProfileDAO;
import com.doublechaintech.search.profile.ProfileTokens;
import com.doublechaintech.search.shippingaddress.ShippingAddress;
import com.doublechaintech.search.shippingaddress.ShippingAddressDAO;
import com.doublechaintech.search.shippingaddress.ShippingAddressTokens;
import com.doublechaintech.search.paymentmethod.PaymentMethod;
import com.doublechaintech.search.paymentmethod.PaymentMethodDAO;
import com.doublechaintech.search.paymentmethod.PaymentMethodTokens;
import com.doublechaintech.search.userorder.UserOrder;
import com.doublechaintech.search.userorder.UserOrderDAO;
import com.doublechaintech.search.userorder.UserOrderTokens;
import com.doublechaintech.search.lineitem.LineItem;
import com.doublechaintech.search.lineitem.LineItemDAO;
import com.doublechaintech.search.lineitem.LineItemTokens;
import com.doublechaintech.search.orderpromotion.OrderPromotion;
import com.doublechaintech.search.orderpromotion.OrderPromotionDAO;
import com.doublechaintech.search.orderpromotion.OrderPromotionTokens;
import com.doublechaintech.search.manualadjustment.ManualAdjustment;
import com.doublechaintech.search.manualadjustment.ManualAdjustmentDAO;
import com.doublechaintech.search.manualadjustment.ManualAdjustmentTokens;
import com.doublechaintech.search.shippinggroup.ShippingGroup;
import com.doublechaintech.search.shippinggroup.ShippingGroupDAO;
import com.doublechaintech.search.shippinggroup.ShippingGroupTokens;
import com.doublechaintech.search.paymentgroup.PaymentGroup;
import com.doublechaintech.search.paymentgroup.PaymentGroupDAO;
import com.doublechaintech.search.paymentgroup.PaymentGroupTokens;
import com.doublechaintech.search.userdomain.UserDomain;
import com.doublechaintech.search.userdomain.UserDomainDAO;
import com.doublechaintech.search.userdomain.UserDomainTokens;
import com.doublechaintech.search.userwhitelist.UserWhiteList;
import com.doublechaintech.search.userwhitelist.UserWhiteListDAO;
import com.doublechaintech.search.userwhitelist.UserWhiteListTokens;
import com.doublechaintech.search.secuser.SecUser;
import com.doublechaintech.search.secuser.SecUserDAO;
import com.doublechaintech.search.secuser.SecUserTokens;
import com.doublechaintech.search.secuserblocking.SecUserBlocking;
import com.doublechaintech.search.secuserblocking.SecUserBlockingDAO;
import com.doublechaintech.search.secuserblocking.SecUserBlockingTokens;
import com.doublechaintech.search.userapp.UserApp;
import com.doublechaintech.search.userapp.UserAppDAO;
import com.doublechaintech.search.userapp.UserAppTokens;
import com.doublechaintech.search.listaccess.ListAccess;
import com.doublechaintech.search.listaccess.ListAccessDAO;
import com.doublechaintech.search.listaccess.ListAccessTokens;
import com.doublechaintech.search.objectaccess.ObjectAccess;
import com.doublechaintech.search.objectaccess.ObjectAccessDAO;
import com.doublechaintech.search.objectaccess.ObjectAccessTokens;
import com.doublechaintech.search.loginhistory.LoginHistory;
import com.doublechaintech.search.loginhistory.LoginHistoryDAO;
import com.doublechaintech.search.loginhistory.LoginHistoryTokens;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.genericform.GenericFormDAO;
import com.doublechaintech.search.genericform.GenericFormTokens;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formmessage.FormMessageDAO;
import com.doublechaintech.search.formmessage.FormMessageTokens;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessageDAO;
import com.doublechaintech.search.formfieldmessage.FormFieldMessageTokens;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formfield.FormFieldDAO;
import com.doublechaintech.search.formfield.FormFieldTokens;
import com.doublechaintech.search.formaction.FormAction;
import com.doublechaintech.search.formaction.FormActionDAO;
import com.doublechaintech.search.formaction.FormActionTokens;

public class DAOGroup {

	protected PlatformDAO platformDAO;

	protected SiteDAO siteDAO;

	protected CatalogDAO catalogDAO;

	protected LevelOneCategoryDAO levelOneCategoryDAO;

	protected LevelTwoCategoryDAO levelTwoCategoryDAO;

	protected LevelNCategoryDAO levelNCategoryDAO;

	protected BrandDAO brandDAO;

	protected ProductDAO productDAO;

	protected ProductRecommendationDAO productRecommendationDAO;

	protected SkuDAO skuDAO;

	protected ProfileDAO profileDAO;

	protected ShippingAddressDAO shippingAddressDAO;

	protected PaymentMethodDAO paymentMethodDAO;

	protected UserOrderDAO userOrderDAO;

	protected LineItemDAO lineItemDAO;

	protected OrderPromotionDAO orderPromotionDAO;

	protected ManualAdjustmentDAO manualAdjustmentDAO;

	protected ShippingGroupDAO shippingGroupDAO;

	protected PaymentGroupDAO paymentGroupDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected SecUserBlockingDAO secUserBlockingDAO;

	protected UserAppDAO userAppDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	

	public PlatformDAO getPlatformDAO(){
		return this.platformDAO;
	}
	public void setPlatformDAO(PlatformDAO dao){
		this.platformDAO = dao;
	}


	public SiteDAO getSiteDAO(){
		return this.siteDAO;
	}
	public void setSiteDAO(SiteDAO dao){
		this.siteDAO = dao;
	}


	public CatalogDAO getCatalogDAO(){
		return this.catalogDAO;
	}
	public void setCatalogDAO(CatalogDAO dao){
		this.catalogDAO = dao;
	}


	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
		return this.levelOneCategoryDAO;
	}
	public void setLevelOneCategoryDAO(LevelOneCategoryDAO dao){
		this.levelOneCategoryDAO = dao;
	}


	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
		return this.levelTwoCategoryDAO;
	}
	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO dao){
		this.levelTwoCategoryDAO = dao;
	}


	public LevelNCategoryDAO getLevelNCategoryDAO(){
		return this.levelNCategoryDAO;
	}
	public void setLevelNCategoryDAO(LevelNCategoryDAO dao){
		this.levelNCategoryDAO = dao;
	}


	public BrandDAO getBrandDAO(){
		return this.brandDAO;
	}
	public void setBrandDAO(BrandDAO dao){
		this.brandDAO = dao;
	}


	public ProductDAO getProductDAO(){
		return this.productDAO;
	}
	public void setProductDAO(ProductDAO dao){
		this.productDAO = dao;
	}


	public ProductRecommendationDAO getProductRecommendationDAO(){
		return this.productRecommendationDAO;
	}
	public void setProductRecommendationDAO(ProductRecommendationDAO dao){
		this.productRecommendationDAO = dao;
	}


	public SkuDAO getSkuDAO(){
		return this.skuDAO;
	}
	public void setSkuDAO(SkuDAO dao){
		this.skuDAO = dao;
	}


	public ProfileDAO getProfileDAO(){
		return this.profileDAO;
	}
	public void setProfileDAO(ProfileDAO dao){
		this.profileDAO = dao;
	}


	public ShippingAddressDAO getShippingAddressDAO(){
		return this.shippingAddressDAO;
	}
	public void setShippingAddressDAO(ShippingAddressDAO dao){
		this.shippingAddressDAO = dao;
	}


	public PaymentMethodDAO getPaymentMethodDAO(){
		return this.paymentMethodDAO;
	}
	public void setPaymentMethodDAO(PaymentMethodDAO dao){
		this.paymentMethodDAO = dao;
	}


	public UserOrderDAO getUserOrderDAO(){
		return this.userOrderDAO;
	}
	public void setUserOrderDAO(UserOrderDAO dao){
		this.userOrderDAO = dao;
	}


	public LineItemDAO getLineItemDAO(){
		return this.lineItemDAO;
	}
	public void setLineItemDAO(LineItemDAO dao){
		this.lineItemDAO = dao;
	}


	public OrderPromotionDAO getOrderPromotionDAO(){
		return this.orderPromotionDAO;
	}
	public void setOrderPromotionDAO(OrderPromotionDAO dao){
		this.orderPromotionDAO = dao;
	}


	public ManualAdjustmentDAO getManualAdjustmentDAO(){
		return this.manualAdjustmentDAO;
	}
	public void setManualAdjustmentDAO(ManualAdjustmentDAO dao){
		this.manualAdjustmentDAO = dao;
	}


	public ShippingGroupDAO getShippingGroupDAO(){
		return this.shippingGroupDAO;
	}
	public void setShippingGroupDAO(ShippingGroupDAO dao){
		this.shippingGroupDAO = dao;
	}


	public PaymentGroupDAO getPaymentGroupDAO(){
		return this.paymentGroupDAO;
	}
	public void setPaymentGroupDAO(PaymentGroupDAO dao){
		this.paymentGroupDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public SecUserBlockingDAO getSecUserBlockingDAO(){
		return this.secUserBlockingDAO;
	}
	public void setSecUserBlockingDAO(SecUserBlockingDAO dao){
		this.secUserBlockingDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public ObjectAccessDAO getObjectAccessDAO(){
		return this.objectAccessDAO;
	}
	public void setObjectAccessDAO(ObjectAccessDAO dao){
		this.objectAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public GenericFormDAO getGenericFormDAO(){
		return this.genericFormDAO;
	}
	public void setGenericFormDAO(GenericFormDAO dao){
		this.genericFormDAO = dao;
	}


	public FormMessageDAO getFormMessageDAO(){
		return this.formMessageDAO;
	}
	public void setFormMessageDAO(FormMessageDAO dao){
		this.formMessageDAO = dao;
	}


	public FormFieldMessageDAO getFormFieldMessageDAO(){
		return this.formFieldMessageDAO;
	}
	public void setFormFieldMessageDAO(FormFieldMessageDAO dao){
		this.formFieldMessageDAO = dao;
	}


	public FormFieldDAO getFormFieldDAO(){
		return this.formFieldDAO;
	}
	public void setFormFieldDAO(FormFieldDAO dao){
		this.formFieldDAO = dao;
	}


	public FormActionDAO getFormActionDAO(){
		return this.formActionDAO;
	}
	public void setFormActionDAO(FormActionDAO dao){
		this.formActionDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("Platform", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPlatformDAO().load(id, PlatformTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().present((Platform)data, tokens);
			}
		});

		internalLoaderMap.put("Site", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSiteDAO().load(id, SiteTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSiteDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSiteDAO().present((Site)data, tokens);
			}
		});

		internalLoaderMap.put("Catalog", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCatalogDAO().load(id, CatalogTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCatalogDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCatalogDAO().present((Catalog)data, tokens);
			}
		});

		internalLoaderMap.put("LevelOneCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().load(id, LevelOneCategoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().present((LevelOneCategory)data, tokens);
			}
		});

		internalLoaderMap.put("LevelTwoCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().load(id, LevelTwoCategoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().present((LevelTwoCategory)data, tokens);
			}
		});

		internalLoaderMap.put("LevelNCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelNCategoryDAO().load(id, LevelNCategoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelNCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelNCategoryDAO().present((LevelNCategory)data, tokens);
			}
		});

		internalLoaderMap.put("Brand", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getBrandDAO().load(id, BrandTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBrandDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getBrandDAO().present((Brand)data, tokens);
			}
		});

		internalLoaderMap.put("Product", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProductDAO().load(id, ProductTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductDAO().present((Product)data, tokens);
			}
		});

		internalLoaderMap.put("ProductRecommendation", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProductRecommendationDAO().load(id, ProductRecommendationTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductRecommendationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductRecommendationDAO().present((ProductRecommendation)data, tokens);
			}
		});

		internalLoaderMap.put("Sku", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSkuDAO().load(id, SkuTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSkuDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSkuDAO().present((Sku)data, tokens);
			}
		});

		internalLoaderMap.put("Profile", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProfileDAO().load(id, ProfileTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProfileDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProfileDAO().present((Profile)data, tokens);
			}
		});

		internalLoaderMap.put("ShippingAddress", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getShippingAddressDAO().load(id, ShippingAddressTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getShippingAddressDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getShippingAddressDAO().present((ShippingAddress)data, tokens);
			}
		});

		internalLoaderMap.put("PaymentMethod", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPaymentMethodDAO().load(id, PaymentMethodTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPaymentMethodDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPaymentMethodDAO().present((PaymentMethod)data, tokens);
			}
		});

		internalLoaderMap.put("UserOrder", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserOrderDAO().load(id, UserOrderTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserOrderDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserOrderDAO().present((UserOrder)data, tokens);
			}
		});

		internalLoaderMap.put("LineItem", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLineItemDAO().load(id, LineItemTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLineItemDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLineItemDAO().present((LineItem)data, tokens);
			}
		});

		internalLoaderMap.put("OrderPromotion", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getOrderPromotionDAO().load(id, OrderPromotionTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOrderPromotionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOrderPromotionDAO().present((OrderPromotion)data, tokens);
			}
		});

		internalLoaderMap.put("ManualAdjustment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getManualAdjustmentDAO().load(id, ManualAdjustmentTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getManualAdjustmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getManualAdjustmentDAO().present((ManualAdjustment)data, tokens);
			}
		});

		internalLoaderMap.put("ShippingGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getShippingGroupDAO().load(id, ShippingGroupTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getShippingGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getShippingGroupDAO().present((ShippingGroup)data, tokens);
			}
		});

		internalLoaderMap.put("PaymentGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPaymentGroupDAO().load(id, PaymentGroupTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPaymentGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPaymentGroupDAO().present((PaymentGroup)data, tokens);
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
		});

		internalLoaderMap.put("SecUserBlocking", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, SecUserBlockingTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().present((SecUserBlocking)data, tokens);
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}

