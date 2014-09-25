package edu.vanderbilt.backnash.internal;

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
		for (HistoricalSite hs: sites)
			if (hs.equals(newSite))
				return;
		sites.add(newSite);
	}
	
	public void delete(HistoricalSite oldSite) {
		Iterator<HistoricalSite> iter = sites.iterator();
		HistoricalSite hs;
		while (iter.hasNext())
			if (iter.next().equals(oldSite))
				iter.remove();
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