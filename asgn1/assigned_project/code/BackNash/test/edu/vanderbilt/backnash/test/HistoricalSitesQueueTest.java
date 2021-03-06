package edu.vanderbilt.backnash.test;

import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

import edu.vanderbilt.backnash.internal.HistoricalSite;
import edu.vanderbilt.backnash.internal.HistoricalSitesQueue;

public class HistoricalSitesQueueTest {
	
	private HistoricalSitesQueue hsq = new HistoricalSitesQueue();

	@Test
	public void testRearrangeHistoricalSiteHistoricalSite() {		
		HistoricalSite hs = new HistoricalSite(new String("Franklin Park"));
		HistoricalSite hs2 = new HistoricalSite(new String("Lewis Ginter Gardens"));
				
		hsq.discardList();
		hsq.add(hs);
		hsq.add(hs2);		
		
		HistoricalSite hs_old, hs2_old, hs_new, hs2_new;
		Iterator<HistoricalSite> iter = hsq.getCurrentList().iterator();
		hs_old = iter.next();
		hs2_old = iter.next();
		
		hsq.rearrange(hs_old, hs2_old);
		
		iter = hsq.getCurrentList().iterator();
		hs_new = iter.next();
		hs2_new = iter.next();
		
		assertFalse(hs_old.equals(hs_new));
		assertFalse(hs2_old.equals(hs2_new));

	}

}
