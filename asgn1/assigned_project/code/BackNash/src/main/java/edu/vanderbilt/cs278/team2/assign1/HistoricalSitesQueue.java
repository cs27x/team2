package main.java.edu.vanderbilt.cs278.team2.assign1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class HistoricalSitesQueue extends HistoricalSitesList {
	
	protected class DistanceComparator implements Comparator<HistoricalSite> {		
		protected Location l;		
		public DistanceComparator(Location l) {
			this.l = l;
		}		
		public int compare(HistoricalSite lhs, HistoricalSite rhs) {
			return (int)(l.getDistanceTo(lhs.getLocation()) - l.getDistanceTo(rhs.getLocation()));			
		}
	}
	
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
	
	public void rearrange(HistoricalSite lhs, HistoricalSite rhs) throws NoSuchElementException {
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

	public HistoricalSitesQueue getListReorderedByDistanceToLocation(Location l) {
		List<HistoricalSite> reorderedList = new ArrayList<HistoricalSite>(sites);
		Collections.sort(reorderedList, new DistanceComparator(l));
		
		HistoricalSitesQueue hsq = new HistoricalSitesQueue();
		hsq.setCurrentList(reorderedList);
		return hsq;
	}
	
	public HistoricalSitesQueue getListReorderedByDistanceToLocation(double latitude, double longitude) {
		return getListReorderedByDistanceToLocation(new Location(latitude, longitude));
	}
}