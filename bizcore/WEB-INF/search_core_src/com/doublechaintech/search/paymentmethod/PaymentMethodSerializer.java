package com.doublechaintech.search.paymentmethod;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class PaymentMethodSerializer extends SearchObjectPlainCustomSerializer<PaymentMethod>{

	@Override
	public void serialize(PaymentMethod paymentMethod, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, paymentMethod, provider);
		
	}
}


