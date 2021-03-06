package edu.vanderbilt.backnash.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import edu.vanderbilt.backnash.internal.HistoricalSite;
import edu.vanderbilt.backnash.internal.HistoricalSitesList;

public class HistoricalSitesListTest {

	@Test
	public void testListSetterAndGetter() {
		HistoricalSite hs = new HistoricalSite(new String("Franklin Park"));
		HistoricalSite hs2 = new HistoricalSite(new String("Lewis Ginter Gardens"));
		
		HistoricalSitesList hsl = new HistoricalSitesList();
		List<HistoricalSite> sites = new ArrayList<HistoricalSite>(2);
		sites.add(hs);
		sites.add(hs2);
		hsl.setCurrentList(sites);
		
		Iterator<HistoricalSite> iter = hsl.getCurrentList().iterator();
		try {
			assertTrue(hs.equals(iter.next()));
			assertTrue(hs2.equals(iter.next()));
		}
		catch(RuntimeException e) {
			fail("List was of incorrect size");
		}
		
	}
	
	@Test
	public void testAddDoesNotDuplicate() {
		HistoricalSite hs = new HistoricalSite("Franklin Park");
		HistoricalSite hs2 = new HistoricalSite("Franklin Park");
		HistoricalSitesList hsl = new HistoricalSitesList();
		assertTrue(hsl.isEmpty());
		hsl.add(hs);
		assertTrue(hsl.size()==1);
		hsl.add(hs2);
		assertTrue(hsl.size()==1);
	}
	
	@Test
	public void testDeleteRemovesSimilarSites() {
		HistoricalSite hs = new HistoricalSite("Franklin Park");
		HistoricalSite hs2 = new HistoricalSite("Franklin Park");
		HistoricalSitesList hsl = new HistoricalSitesList();
		assertTrue(hsl.isEmpty());
		hsl.add(hs);
		assertTrue(hsl.size()==1);
		hsl.delete(hs2);
		assertTrue(hsl.isEmpty());
	}
	
	@Test
	public void testAdd() {
		HistoricalSite hs = new HistoricalSite("Franklin Park");
		HistoricalSitesList hsl = new HistoricalSitesList();
		assertTrue(hsl.getCurrentList().size()==0);
		hsl.add(hs);
		assertTrue(hsl.getCurrentList().get(0).equals(hs));
		
		
	}
	
	@Test
	public void testDelete() {
		HistoricalSite hs = new HistoricalSite("Franklin Park");
		HistoricalSitesList hsl = new HistoricalSitesList();
		assertTrue(hsl.getCurrentList().isEmpty());
		hsl.add(hs);
		assertFalse(hsl.getCurrentList().isEmpty());
		hsl.delete(hs);
		assertTrue(hsl.getCurrentList().isEmpty());
	}
	
	@Test
	public void testClear() {
		HistoricalSite hs = new HistoricalSite("Franklin Park");
		HistoricalSitesList hsl = new HistoricalSitesList();
		assertTrue(hsl.getCurrentList().isEmpty());
		hsl.add(hs);
		assertFalse(hsl.getCurrentList().isEmpty());
		hsl.discardList();
		assertTrue(hsl.getCurrentList().isEmpty());
	}

}
