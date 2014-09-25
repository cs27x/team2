package edu.vanderbilt.backnash.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.vanderbilt.backnash.data.HistoricalSitesBroker;
import edu.vanderbilt.backnash.internal.HistoricalSite;
import edu.vanderbilt.backnash.internal.HistoricalSitesQueue;
import edu.vanderbilt.backnash.location.Location;

import java.util.Iterator;

public class HistoricalSitesBrokerTest {
	private HistoricalSitesBroker hsb = new HistoricalSitesBroker();
	private static final int NASHVILLE_GOV_HISTORICAL_SITES_MAX_COUNT = 155;

	@Test
	public void testGetUnvisitedList() {
		hsb.getCurrentList().discardList();
		hsb.add(new HistoricalSite("Franklin Park"));
		hsb.add(new HistoricalSite("Lewis Ginter Gardens"));
		assertFalse(hsb.getCurrentList().getCurrentList().isEmpty());
		Iterator<HistoricalSite> iter = hsb.getCurrentList().getCurrentList().iterator();
		HistoricalSite hs = iter.next();
		hs.setVisited();
		HistoricalSitesQueue hsq_unvisited = hsb.getUnvisitedList();
		assertTrue(hsq_unvisited.size()==1);
		assertFalse(hsq_unvisited.getCurrentList().iterator().next().equals(hs));
		
	}
	
	@Test
	public void testReorderListByDistance() {
		HistoricalSite hs1 = new HistoricalSite("Franklin Park");
		HistoricalSite hs2 = new HistoricalSite("Lewis Ginter Gardens");
		HistoricalSite hs3 = new HistoricalSite("Robert E. Lee Statue");
		hs1.setLocation(new Location(36.145426, -86.778297));
		hs2.setLocation(new Location(35.009388, -84.595385));
		hs3.setLocation(new Location(37.516996, -77.448288));
		
		hsb.getCurrentList().discardList();
		hsb.add(hs3);
		hsb.add(hs1);
		hsb.add(hs2);
		
		assertTrue(hsb.getCurrentList().size()==3);
		
		Location ourLocation = new Location(36.142203, -86.802715);
		
		HistoricalSitesQueue reorderedList = hsb.getCurrentList().getListReorderedByDistanceToLocation(ourLocation);
		assertTrue(reorderedList.size()==3);
		Iterator<HistoricalSite> iter = reorderedList.getCurrentList().iterator();
		
		assertTrue(iter.next().equals(hs1));
		assertTrue(iter.next().equals(hs2));
		assertTrue(iter.next().equals(hs3));
	}
	
	@Test
	public void testMaintainsSeparateVisitedAndAllLists() throws Exception {
		assertTrue(hsb.getMasterList().size()== NASHVILLE_GOV_HISTORICAL_SITES_MAX_COUNT);
		
		Iterator<HistoricalSite> iter = hsb.getMasterList().getCurrentList().iterator();
		
		HistoricalSite hs1 = iter.next();
		HistoricalSite hs2 = iter.next();
		
		hsb.add(hs1);
		hsb.add(hs2);
		
		assertTrue(hsb.getCurrentList().size() == 2);
		assertTrue(hsb.getUnvisitedList().size()==2);
		
		hsb.visit(hs1);
		hsb.visit(hs2);
		
		assertTrue(hsb.getCurrentList().size() == 2);
		assertTrue(hsb.getMasterList().size()== NASHVILLE_GOV_HISTORICAL_SITES_MAX_COUNT);
		assertTrue(hsb.getVisitedList().size() == 2);
		
	}

}
