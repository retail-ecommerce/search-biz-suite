
package com.doublechaintech.search;
import java.util.Map;

import com.doublechaintech.search.platform.Platform;
import com.doublechaintech.search.site.Site;
import com.doublechaintech.search.catalog.Catalog;
import com.doublechaintech.search.levelonecategory.LevelOneCategory;
import com.doublechaintech.search.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.search.levelncategory.LevelNCategory;
import com.doublechaintech.search.brand.Brand;
import com.doublechaintech.search.product.Product;
import com.doublechaintech.search.productrecommendation.ProductRecommendation;
import com.doublechaintech.search.sku.Sku;
import com.doublechaintech.search.profile.Profile;
import com.doublechaintech.search.shippingaddress.ShippingAddress;
import com.doublechaintech.search.paymentmethod.PaymentMethod;
import com.doublechaintech.search.userorder.UserOrder;
import com.doublechaintech.search.lineitem.LineItem;
import com.doublechaintech.search.orderpromotion.OrderPromotion;
import com.doublechaintech.search.manualadjustment.ManualAdjustment;
import com.doublechaintech.search.shippinggroup.ShippingGroup;
import com.doublechaintech.search.paymentgroup.PaymentGroup;
import com.doublechaintech.search.userdomain.UserDomain;
import com.doublechaintech.search.userwhitelist.UserWhiteList;
import com.doublechaintech.search.secuser.SecUser;
import com.doublechaintech.search.secuserblocking.SecUserBlocking;
import com.doublechaintech.search.userapp.UserApp;
import com.doublechaintech.search.listaccess.ListAccess;
import com.doublechaintech.search.objectaccess.ObjectAccess;
import com.doublechaintech.search.loginhistory.LoginHistory;
import com.doublechaintech.search.genericform.GenericForm;
import com.doublechaintech.search.formmessage.FormMessage;
import com.doublechaintech.search.formfieldmessage.FormFieldMessage;
import com.doublechaintech.search.formfield.FormField;
import com.doublechaintech.search.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public Site createSite(Map<String,Object> options){
		return new Site();
	}


	public Catalog createCatalog(Map<String,Object> options){
		return new Catalog();
	}


	public LevelOneCategory createLevelOneCategory(Map<String,Object> options){
		return new LevelOneCategory();
	}


	public LevelTwoCategory createLevelTwoCategory(Map<String,Object> options){
		return new LevelTwoCategory();
	}


	public LevelNCategory createLevelNCategory(Map<String,Object> options){
		return new LevelNCategory();
	}


	public Brand createBrand(Map<String,Object> options){
		return new Brand();
	}


	public Product createProduct(Map<String,Object> options){
		return new Product();
	}


	public ProductRecommendation createProductRecommendation(Map<String,Object> options){
		return new ProductRecommendation();
	}


	public Sku createSku(Map<String,Object> options){
		return new Sku();
	}


	public Profile createProfile(Map<String,Object> options){
		return new Profile();
	}


	public ShippingAddress createShippingAddress(Map<String,Object> options){
		return new ShippingAddress();
	}


	public PaymentMethod createPaymentMethod(Map<String,Object> options){
		return new PaymentMethod();
	}


	public UserOrder createUserOrder(Map<String,Object> options){
		return new UserOrder();
	}


	public LineItem createLineItem(Map<String,Object> options){
		return new LineItem();
	}


	public OrderPromotion createOrderPromotion(Map<String,Object> options){
		return new OrderPromotion();
	}


	public ManualAdjustment createManualAdjustment(Map<String,Object> options){
		return new ManualAdjustment();
	}


	public ShippingGroup createShippingGroup(Map<String,Object> options){
		return new ShippingGroup();
	}


	public PaymentGroup createPaymentGroup(Map<String,Object> options){
		return new PaymentGroup();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










