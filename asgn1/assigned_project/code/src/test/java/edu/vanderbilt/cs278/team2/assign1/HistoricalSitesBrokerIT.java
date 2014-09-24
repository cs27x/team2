package edu.vanderbilt.cs278.team2.assign1;

/*
 * The idea for this and the TextMenu and TextMenuItem classes are
 * taken from: http://bytes.com/topic/java/insights/870013-text-based-menus
 * Accessed 9/24/2014
 * I do not claim any ownership or copyright.
 */

import com.example.josah.textmenu.*;

/*
 * Integration testing for Historical Sites Broker using a text interface
 */
public class HistoricalSitesBrokerIT {

	private static TextMenuItem item1 = new TextMenuItem("item 1", new Runnable() {
		public void run() {
			System.out.println("running item 1");
		}
	});
	
	private static TextMenuItem item2 = new TextMenuItem("item 2", new Runnable() {
		public void run() {
			System.out.println("running item 2");
		}
	});
	
	private static TextMenuItem item3 = new TextMenuItem("item 2", new Runnable() {
		public void run() {
			System.out.println("running item 3");
		}
	});
	
	private static TextMenu topMenu = new TextMenu("top menu", false, true, item1, item2, item3);
	
	public static void main(String args[]) {
		topMenu.run();
	}
}