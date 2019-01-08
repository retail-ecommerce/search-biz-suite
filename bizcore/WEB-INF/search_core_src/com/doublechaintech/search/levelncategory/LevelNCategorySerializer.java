package com.doublechaintech.search.levelncategory;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class LevelNCategorySerializer extends SearchObjectPlainCustomSerializer<LevelNCategory>{

	@Override
	public void serialize(LevelNCategory levelNCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, levelNCategory, provider);
		
	}
}


