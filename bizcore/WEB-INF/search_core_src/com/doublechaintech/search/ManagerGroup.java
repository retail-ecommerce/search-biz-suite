package com.doublechaintech.search;


import com.doublechaintech.search.platform.PlatformManager;

import com.doublechaintech.search.site.SiteManager;

import com.doublechaintech.search.catalog.CatalogManager;

import com.doublechaintech.search.levelonecategory.LevelOneCategoryManager;

import com.doublechaintech.search.leveltwocategory.LevelTwoCategoryManager;

import com.doublechaintech.search.levelncategory.LevelNCategoryManager;

import com.doublechaintech.search.brand.BrandManager;

import com.doublechaintech.search.product.ProductManager;

import com.doublechaintech.search.productrecommendation.ProductRecommendationManager;

import com.doublechaintech.search.sku.SkuManager;

import com.doublechaintech.search.profile.ProfileManager;

import com.doublechaintech.search.shippingaddress.ShippingAddressManager;

import com.doublechaintech.search.paymentmethod.PaymentMethodManager;

import com.doublechaintech.search.userorder.UserOrderManager;

import com.doublechaintech.search.lineitem.LineItemManager;

import com.doublechaintech.search.orderpromotion.OrderPromotionManager;

import com.doublechaintech.search.manualadjustment.ManualAdjustmentManager;

import com.doublechaintech.search.shippinggroup.ShippingGroupManager;

import com.doublechaintech.search.paymentgroup.PaymentGroupManager;

import com.doublechaintech.search.userdomain.UserDomainManager;

import com.doublechaintech.search.userwhitelist.UserWhiteListManager;

import com.doublechaintech.search.secuser.SecUserManager;

import com.doublechaintech.search.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.search.userapp.UserAppManager;

import com.doublechaintech.search.listaccess.ListAccessManager;

import com.doublechaintech.search.objectaccess.ObjectAccessManager;

import com.doublechaintech.search.loginhistory.LoginHistoryManager;

import com.doublechaintech.search.genericform.GenericFormManager;

import com.doublechaintech.search.formmessage.FormMessageManager;

import com.doublechaintech.search.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.search.formfield.FormFieldManager;

import com.doublechaintech.search.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected SiteManager siteManager;

	protected CatalogManager catalogManager;

	protected LevelOneCategoryManager levelOneCategoryManager;

	protected LevelTwoCategoryManager levelTwoCategoryManager;

	protected LevelNCategoryManager levelNCategoryManager;

	protected BrandManager brandManager;

	protected ProductManager productManager;

	protected ProductRecommendationManager productRecommendationManager;

	protected SkuManager skuManager;

	protected ProfileManager profileManager;

	protected ShippingAddressManager shippingAddressManager;

	protected PaymentMethodManager paymentMethodManager;

	protected UserOrderManager userOrderManager;

	protected LineItemManager lineItemManager;

	protected OrderPromotionManager orderPromotionManager;

	protected ManualAdjustmentManager manualAdjustmentManager;

	protected ShippingGroupManager shippingGroupManager;

	protected PaymentGroupManager paymentGroupManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public SiteManager getSiteManager(){
		return this.siteManager;
	}
	public void setSiteManager(SiteManager manager){
		this.siteManager = manager;
	}


	public CatalogManager getCatalogManager(){
		return this.catalogManager;
	}
	public void setCatalogManager(CatalogManager manager){
		this.catalogManager = manager;
	}


	public LevelOneCategoryManager getLevelOneCategoryManager(){
		return this.levelOneCategoryManager;
	}
	public void setLevelOneCategoryManager(LevelOneCategoryManager manager){
		this.levelOneCategoryManager = manager;
	}


	public LevelTwoCategoryManager getLevelTwoCategoryManager(){
		return this.levelTwoCategoryManager;
	}
	public void setLevelTwoCategoryManager(LevelTwoCategoryManager manager){
		this.levelTwoCategoryManager = manager;
	}


	public LevelNCategoryManager getLevelNCategoryManager(){
		return this.levelNCategoryManager;
	}
	public void setLevelNCategoryManager(LevelNCategoryManager manager){
		this.levelNCategoryManager = manager;
	}


	public BrandManager getBrandManager(){
		return this.brandManager;
	}
	public void setBrandManager(BrandManager manager){
		this.brandManager = manager;
	}


	public ProductManager getProductManager(){
		return this.productManager;
	}
	public void setProductManager(ProductManager manager){
		this.productManager = manager;
	}


	public ProductRecommendationManager getProductRecommendationManager(){
		return this.productRecommendationManager;
	}
	public void setProductRecommendationManager(ProductRecommendationManager manager){
		this.productRecommendationManager = manager;
	}


	public SkuManager getSkuManager(){
		return this.skuManager;
	}
	public void setSkuManager(SkuManager manager){
		this.skuManager = manager;
	}


	public ProfileManager getProfileManager(){
		return this.profileManager;
	}
	public void setProfileManager(ProfileManager manager){
		this.profileManager = manager;
	}


	public ShippingAddressManager getShippingAddressManager(){
		return this.shippingAddressManager;
	}
	public void setShippingAddressManager(ShippingAddressManager manager){
		this.shippingAddressManager = manager;
	}


	public PaymentMethodManager getPaymentMethodManager(){
		return this.paymentMethodManager;
	}
	public void setPaymentMethodManager(PaymentMethodManager manager){
		this.paymentMethodManager = manager;
	}


	public UserOrderManager getUserOrderManager(){
		return this.userOrderManager;
	}
	public void setUserOrderManager(UserOrderManager manager){
		this.userOrderManager = manager;
	}


	public LineItemManager getLineItemManager(){
		return this.lineItemManager;
	}
	public void setLineItemManager(LineItemManager manager){
		this.lineItemManager = manager;
	}


	public OrderPromotionManager getOrderPromotionManager(){
		return this.orderPromotionManager;
	}
	public void setOrderPromotionManager(OrderPromotionManager manager){
		this.orderPromotionManager = manager;
	}


	public ManualAdjustmentManager getManualAdjustmentManager(){
		return this.manualAdjustmentManager;
	}
	public void setManualAdjustmentManager(ManualAdjustmentManager manager){
		this.manualAdjustmentManager = manager;
	}


	public ShippingGroupManager getShippingGroupManager(){
		return this.shippingGroupManager;
	}
	public void setShippingGroupManager(ShippingGroupManager manager){
		this.shippingGroupManager = manager;
	}


	public PaymentGroupManager getPaymentGroupManager(){
		return this.paymentGroupManager;
	}
	public void setPaymentGroupManager(PaymentGroupManager manager){
		this.paymentGroupManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









