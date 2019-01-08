package com.doublechaintech.search.shippingaddress;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class ShippingAddressSerializer extends SearchObjectPlainCustomSerializer<ShippingAddress>{

	@Override
	public void serialize(ShippingAddress shippingAddress, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, shippingAddress, provider);
		
	}
}


