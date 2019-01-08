package com.doublechaintech.search.productrecommendation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.search.SearchObjectPlainCustomSerializer;
public class ProductRecommendationSerializer extends SearchObjectPlainCustomSerializer<ProductRecommendation>{

	@Override
	public void serialize(ProductRecommendation productRecommendation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, productRecommendation, provider);
		
	}
}


