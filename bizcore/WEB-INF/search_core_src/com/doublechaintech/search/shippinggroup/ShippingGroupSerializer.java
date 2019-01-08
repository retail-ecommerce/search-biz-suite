package com.doublechaintech.search.shippinggroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class ShippingGroupSerializer extends SearchObjectPlainCustomSerializer<ShippingGroup>{

	@Override
	public void serialize(ShippingGroup shippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, shippingGroup, provider);
		
	}
}


