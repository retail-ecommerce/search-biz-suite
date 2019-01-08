package com.doublechaintech.search.userorder;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class UserOrderSerializer extends SearchObjectPlainCustomSerializer<UserOrder>{

	@Override
	public void serialize(UserOrder userOrder, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userOrder, provider);
		
	}
}


