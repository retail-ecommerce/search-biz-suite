package com.doublechaintech.search.orderpromotion;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class OrderPromotionSerializer extends SearchObjectPlainCustomSerializer<OrderPromotion>{

	@Override
	public void serialize(OrderPromotion orderPromotion, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, orderPromotion, provider);
		
	}
}


