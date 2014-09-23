package edu.vanderbilt.cs278.team2.assign1;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;

import org.junit.Test;

public class JSONParserTest {
	private static final String NASHVILLE_HISTORICAL_SITES_URL = "https://data.nashville.gov/resource/2j6c-58gf.json";

	@Test
	public void testGetMarkerData() throws Exception {
		JSONParser json = new JSONParser(new URL(NASHVILLE_HISTORICAL_SITES_URL));
		List<HistoricalSite> sites = json.getMarkerData();
		for (HistoricalSite hs: sites) {
			System.out.println(hs.getDisplayName());
		}
		//json.printMarkerData();
	}

}
