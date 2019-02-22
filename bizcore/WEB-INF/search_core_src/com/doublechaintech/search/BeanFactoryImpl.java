
package com.doublechaintech.search;
import java.util.Map;

import com.doublechaintech.search.platform.Platform;
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










