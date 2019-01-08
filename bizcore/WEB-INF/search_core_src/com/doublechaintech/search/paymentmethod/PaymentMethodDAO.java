
package com.doublechaintech.search.paymentmethod;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.search.BaseEntity;
import com.doublechaintech.search.SmartList;
import com.doublechaintech.search.MultipleAccessKey;
import com.doublechaintech.search.SearchUserContext;


public interface PaymentMethodDAO{

	
	public PaymentMethod load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PaymentMethod> paymentMethodList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PaymentMethod present(PaymentMethod paymentMethod,Map<String,Object> options) throws Exception;
	public PaymentMethod clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PaymentMethod save(PaymentMethod paymentMethod,Map<String,Object> options);
	public SmartList<PaymentMethod> savePaymentMethodList(SmartList<PaymentMethod> paymentMethodList,Map<String,Object> options);
	public SmartList<PaymentMethod> removePaymentMethodList(SmartList<PaymentMethod> paymentMethodList,Map<String,Object> options);
	public SmartList<PaymentMethod> findPaymentMethodWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPaymentMethodWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPaymentMethodWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String paymentMethodId, int version) throws Exception;
	public PaymentMethod disconnectFromAll(String paymentMethodId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<PaymentMethod> queryList(String sql, Object ... parmeters);
}


