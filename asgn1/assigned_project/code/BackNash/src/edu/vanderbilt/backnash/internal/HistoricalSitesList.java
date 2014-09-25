package edu.vanderbilt.backnash.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HistoricalSitesList {
	List<HistoricalSite> sites;
	
	public HistoricalSitesList() {
		sites = new ArrayList<HistoricalSite>();
	}
	
	public List<HistoricalSite> getCurrentList() {
		return sites;
	}
	
	public void setCurrentList(List<HistoricalSite> newList) {
		this.sites = newList;
	}
	
	public void add(HistoricalSite newSite) {		
		if (sites.contains(newSite))
			return;
		sites.add(newSite);
	}
	
	public void delete(HistoricalSite oldSite) {
		sites.remove(oldSite);
	}
	
	public void visit(HistoricalSite hs) {
		for (HistoricalSite element: sites)
			if (element.equals(hs)) {
				element.setVisited();
				return;
			}
		throw new NoSuchElementException(hs.getDisplayName() + " is not in the List.");
	}
	
	public void discardList() {
		sites.clear();
	}
	
	public boolean isEmpty() {
		return sites.isEmpty();
	}
	
	public int size() {
		return sites.size();
	}
}