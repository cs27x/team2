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
		assertTrue(sites.size() == 155);  // there should be 155 entries in the historical markers list
		assertTrue(sites.get(0).getDisplayName().equals("HEATON'S STATION")); // first entry should be heaton's station
		//json.printMarkerData();
	}

}
