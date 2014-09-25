package test.java.edu.vanderbilt.cs278.team2.assign1;

/*
 * The idea for this and the TextMenu and TextMenuItem classes are
 * taken from: http://bytes.com/topic/java/insights/870013-text-based-menus
 * Accessed 9/24/2014
 * I do not claim any ownership or copyright.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Ignore;

import com.example.josah.textmenu.*;

/*
 * Integration testing for Historical Sites Broker using a text interface
 */
@Ignore("This is an integration test that needs to be run as a Java app")
public class HistoricalSitesBrokerIT {
	
	protected static HistoricalSitesBroker hsb = new HistoricalSitesBroker();
    
	public static  int getChoiceNumber(String commandPrompt) throws Exception {    	
        if (hsb == null) {
        	throw new RuntimeException("Do not have a HistoricalSitesBroker");
        }
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));        
        while (true) {
        	if (commandPrompt != null) {
        		System.out.print("Select item number to add: ");
        		System.out.flush();
        	}
            String line = br.readLine();
            try {
                int option= Integer.parseInt(line);
                if (option >= 1 && option <= hsb.getMasterList().size())
                    return option;
            }
            catch (NumberFormatException e) { }
            System.out.println("not a valid menu option: "+line);
        } 
    }
		
	private static TextMenuItem item1 = new TextMenuItem("Show All Sites", new Runnable() {
		public void run() {
			try {
				HistoricalSitesList hsl = hsb.getMasterList();
				int counter = 1;
				for (HistoricalSite hs: hsl.getCurrentList()) {
					System.out.println("" + counter++ + ": " + hs.getDisplayName());
				}
			}
			catch (Exception e) { 
				e.printStackTrace();
			}
		}
	});	
	private static TextMenuItem allListSubItem1 = new TextMenuItem("Add Location To Queue by Number", new Runnable() {
		public void run() {
			try {
				int locationNo = HistoricalSitesBrokerIT.getChoiceNumber("Select item number to add: ");
				hsb.add(hsb.getMasterList().getCurrentList().get(locationNo-1));
			}
			catch (Exception e) {e.printStackTrace();};
		}
	});
	private static TextMenuItem allListSubItem2 = new TextMenuItem("Visit Location From Master List by Number", new Runnable() {
		public void run() {
			try {
				int locationNo = HistoricalSitesBrokerIT.getChoiceNumber("Select item number to visit: ");
				hsb.visit(hsb.getMasterList().getCurrentList().get(locationNo-1));
			}
			catch (Exception e) {e.printStackTrace();};
		}
	});
	
	private static TextMenuItem item2 = new TextMenuItem("See Visited List", new Runnable() {
		public void run() {			
			if (hsb.getVisitedList().isEmpty())
				System.out.println("VISITED LIST IS EMPTY");
			else {
				System.out.println("PRINTING VISITED SITES");			
				int counter = 1;
				for (HistoricalSite hs: hsb.getVisitedList().getCurrentList()) 
					System.out.println("" + counter++ + ": " + hs.getDisplayName());
			}
		}
	});
	
	private static TextMenuItem item3 = new TextMenuItem("See Unvisited List", new Runnable() {
		public void run() {							
			if (hsb.getUnvisitedList().isEmpty())
				System.out.println("UNVISITED LIST IS EMPTY");
			else {
				System.out.println("PRINTING UNVISITED SITES");
				int counter = 1;
				for (HistoricalSite hs: hsb.getUnvisitedList().getCurrentList()) 
					System.out.println("" + counter++ + ": " + hs.getDisplayName());
			}
		}
	});
	private static TextMenu nestedMasterListMenu = new TextMenu("Master List", true, false, item1, allListSubItem1, allListSubItem2);
	private static TextMenu topMenu = new TextMenu("top menu", false, true, nestedMasterListMenu, item2, item3);
	
	public static void main(String args[]) {
		topMenu.run();
	}
}