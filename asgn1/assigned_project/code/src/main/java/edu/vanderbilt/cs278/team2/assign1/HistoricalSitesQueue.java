package edu.vanderbilt.cs278.team2.assign1;

import java.util.NoSuchElementException;

public class HistoricalSitesQueue extends HistoricalSitesList {
	
	public void rearrange(HistoricalSite hs, int locationInQueue) {
		
	}
	
	public void rearrange(HistoricalSite lhs, HistoricalSite rhs) {
		// first check if they're both in the queue
		if (!sites.contains(lhs))
			throw new NoSuchElementException(lhs.getDisplayName() + " is not in the List.");
		if (!sites.contains(rhs))
			throw new NoSuchElementException(rhs.getDisplayName() + " is not in the List.");
		
		int index_lhs, index_rhs;
		index_lhs = sites.indexOf(lhs);
		index_rhs = sites.indexOf(rhs);
		sites.set(index_lhs,  rhs);
		sites.set(index_rhs, lhs);
	}
	
	public void visit(HistoricalSite hs) {
		for (HistoricalSite element: sites)
			if (element.equals(hs)) {
				element.setVisited();
				return;
			}
		throw new NoSuchElementException(hs.getDisplayName() + " is not in the List.");
	}
	
}