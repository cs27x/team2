package edu.vanderbilt.cs278.team2.assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HistoricalSitesBroker {
	
	HistoricalSitesQueue curList;
	
	public List<HistoricalSite> getVisitedList() {
		List<HistoricalSite> visitedSites = new ArrayList<HistoricalSite>();
		for (HistoricalSite hs : curList.getCurrentList()) {
			if (hs.isVisited())
				visitedSites.add(hs);
		}
		return visitedSites;
	}
	
	public List<HistoricalSite> getUnvisitedList() {
		List<HistoricalSite> visitedSites = new ArrayList<HistoricalSite>();
		for (HistoricalSite hs : curList.getCurrentList()) {
			if (!hs.isVisited())
				visitedSites.add(hs);
		}
		return visitedSites;
	}
	
	public List<HistoricalSite> getListOrderedByDistanceFrom(Location l) {
		List<HistoricalSite> reorderedList = new ArrayList<HistoricalSite>();
		return reorderedList;
	}
	
	public List<HistoricalSite> getCurrentList() {
		return curList.getCurrentList();
	}
	
	public void visit(HistoricalSite hs) {
		for (HistoricalSite element: curList.getCurrentList())
			if (element.equals(hs)) {
				element.setVisited();
				return;
			}
		throw new NoSuchElementException(hs.getDisplayName() + " is not in the List.");
	}
}