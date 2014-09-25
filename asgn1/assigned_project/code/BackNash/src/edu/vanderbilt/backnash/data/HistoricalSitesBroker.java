package edu.vanderbilt.backnash.data;

import java.util.ArrayList;
import java.util.List;

import edu.vanderbilt.backnash.internal.HistoricalSite;
import edu.vanderbilt.backnash.internal.HistoricalSiteDataProvider;
import edu.vanderbilt.backnash.internal.HistoricalSitesList;
import edu.vanderbilt.backnash.internal.HistoricalSitesQueue;

public class HistoricalSitesBroker {
	
	private HistoricalSitesQueue curList = new HistoricalSitesQueue();
	private HistoricalSitesList masterList;

	public HistoricalSitesQueue getVisitedList() {
		List<HistoricalSite> visitedSites = new ArrayList<HistoricalSite>();
		for (HistoricalSite hs : curList.getCurrentList()) {
			if (hs.isVisited())
				visitedSites.add(hs);
		}
		HistoricalSitesQueue visitedList = new HistoricalSitesQueue();
		visitedList.setCurrentList(visitedSites);
		return visitedList;
	}
	
	public HistoricalSitesQueue getUnvisitedList() {
		List<HistoricalSite> unVisitedSites = new ArrayList<HistoricalSite>();
		for (HistoricalSite hs : curList.getCurrentList()) {
			if (!hs.isVisited())
				unVisitedSites.add(hs);
		}
		HistoricalSitesQueue unvisitedList = new HistoricalSitesQueue();
		unvisitedList.setCurrentList(unVisitedSites);
		return unvisitedList;
	}
	
	public HistoricalSitesQueue getCurrentList() {
		return curList;
	}
	
	public void visit(HistoricalSite hs) {
		curList.visit(hs);
	}
	
	public void delete(HistoricalSite hs) {
		curList.delete(hs);
	}
	
	public void add(HistoricalSite hs) {
		curList.add(hs);
	}

	public HistoricalSitesList getMasterList() throws Exception {
		if (masterList == null) {
			masterList = new HistoricalSitesList();
			HistoricalSiteDataProvider hsdp = HistoricalSiteDataProvider.getInstance();
			if (!hsdp.fetchData()) {
				throw new RuntimeException("Could not download data from https://data.nashville.gov");
			}
			masterList.setCurrentList(hsdp.getSitesList());
			return masterList;
		}
		else
			return masterList;
	}
}