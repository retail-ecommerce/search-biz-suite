package com.doublechaintech.search.secuserblocking;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class SecUserBlockingSerializer extends SearchObjectPlainCustomSerializer<SecUserBlocking>{

	@Override
	public void serialize(SecUserBlocking secUserBlocking, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, secUserBlocking, provider);
		
	}
}


