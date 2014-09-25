package main.java.edu.vanderbilt.cs278.team2.assign1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Comparator;

class DistanceComparator implements Comparator<HistoricalSite> {
	
	protected Location l;
	
	public DistanceComparator(Location l) {
		this.l = l;
	}
	
	public int compare(HistoricalSite lhs, HistoricalSite rhs) {
		return (int)(l.getDistanceTo(lhs.getLocation()) - l.getDistanceTo(rhs.getLocation()));
		
	}
}
public class HistoricalSitesBroker {
	
	HistoricalSitesQueue curList = new HistoricalSitesQueue();
	

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
	
	public HistoricalSitesQueue getListOrderedByDistanceFrom(Location l) {
		List<HistoricalSite> reorderedList = new ArrayList<HistoricalSite>(curList.getCurrentList());
		Collections.sort(reorderedList, new DistanceComparator(l));
		
		HistoricalSitesQueue hsq = new HistoricalSitesQueue();
		hsq.setCurrentList(reorderedList);
		return hsq;
	}
	
	public HistoricalSitesQueue getCurrentList() {
		return curList;
	}
	
	public void visit(HistoricalSite hs) {
		curList.visit(hs);
	}
	
	protected void add(HistoricalSite hs) {
		curList.add(hs);
	}
}