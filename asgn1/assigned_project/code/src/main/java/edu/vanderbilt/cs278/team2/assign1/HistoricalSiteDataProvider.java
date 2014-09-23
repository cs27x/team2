package edu.vanderbilt.cs278.team2.assign1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HistoricalSiteDataProvider {
	public static final String NASHVILLE_HISTORICAL_SITES_URL = "https://data.nashville.gov/resource/2j6c-58gf.json";

	   private static HistoricalSiteDataProvider instance = null;
	   private List<HistoricalSite> sitesList = null;
	   
	   protected HistoricalSiteDataProvider() {
	      // Exists only to defeat instantiation.
	   }
	   
	   public static HistoricalSiteDataProvider getInstance() {
	      if(instance == null) {
	         instance = new HistoricalSiteDataProvider();
	      }
	      return instance;
	   }
	   
	   public boolean fetchData() throws Exception {
		   URL jsonURL = null;
		   boolean success = true;
		   try {
			   jsonURL = new URL(NASHVILLE_HISTORICAL_SITES_URL);
		   } catch (MalformedURLException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			   success = false;
		   }
		   
		   JSONParser parser = new JSONParser(jsonURL);
		   setSitesList(parser.getMarkerData());
		   
		   return success;
	   }

	   public List<HistoricalSite> getSitesList() {
		   return sitesList;
	   }

	   public void setSitesList(List<HistoricalSite> sitesList) {
			this.sitesList = sitesList;
	   }
}