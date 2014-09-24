package edu.vanderbilt.cs278.team2.assign1;

import java.util.NoSuchElementException;

public class HistoricalSitesQueue extends HistoricalSitesList {
	
	/**
	 * 
	 * @param hs: one of the sites we want to arrange
	 * @param locationInQueue: the 0-based index of the other site we want to rearrange
	 * @throws IndexOutOfBoundsException: if the locationInQueue does not correspond to another site
	 * 
	 * If the two sites are the same site then the function does nothing.
	 * 
	 */
	public void rearrange(HistoricalSite hs, int locationInQueue) throws IndexOutOfBoundsException {
		HistoricalSite otherSite = sites.get(locationInQueue);
		if (hs==otherSite || hs.equals(otherSite)) {
			return;
		}
		rearrange(hs, otherSite);
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
}