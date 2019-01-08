package com.doublechaintech.search.genericform;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class GenericFormSerializer extends SearchObjectPlainCustomSerializer<GenericForm>{

	@Override
	public void serialize(GenericForm genericForm, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, genericForm, provider);
		
	}
}


