package edu.vanderbilt.cs278.team2.assign1;

import java.util.NoSuchElementException;

public class HistoricalSitesQueue extends HistoricalSitesList {
	
	public void rearrange(HistoricalSite hs, int locationInQueue) {
		
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