package edu.vanderbilt.cs278.team2.assign1;

import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class HistoricalSitesList {
	List<HistoricalSite> sites;
	
	public HistoricalSitesList() {
		sites = new ArrayList<HistoricalSite>();
	}
	
	protected List<HistoricalSite> getCurrentList() {
		return sites;
	}
	
	protected void setCurrentList(List<HistoricalSite> newList) {
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