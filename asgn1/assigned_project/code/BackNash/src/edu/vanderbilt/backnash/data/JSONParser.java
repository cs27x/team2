package edu.vanderbilt.backnash.data;

import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
	
	private URL markerData;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JavaType markerListType = objectMapper.getTypeFactory()
            .constructCollectionType(List.class, HistoricalSite.class);
	
	public JSONParser(URL url) {
		this.markerData = url;
	}
	
	public List<HistoricalSite> getMarkerData() throws Exception {
        return objectMapper.readValue(markerData, markerListType);
		
	}
	
	@SuppressWarnings("deprecation")
	public void printMarkerData() throws Exception {
		JsonFactory f = new JsonFactory();
		JsonParser jp = f.createJsonParser(markerData);
		jp.nextToken();
		while (jp.nextToken() != JsonToken.END_ARRAY) {
			System.out.println(jp.getCurrentName());
			jp.nextToken();
			System.out.println(jp.getText());
		}
	}
}