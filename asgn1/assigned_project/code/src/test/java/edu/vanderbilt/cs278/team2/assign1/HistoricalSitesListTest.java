package edu.vanderbilt.cs278.team2.assign1;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.junit.Test;

import edu.vanderbilt.cs278.team2.assign1.HistoricalSite;
import edu.vanderbilt.cs278.team2.assign1.HistoricalSitesList;

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
