package edu.vanderbilt.cs278.team2.assign1;

public class HistoricalSite {
	private boolean visited;
	
	private String displayName;
	private String locationDescription;
	private double latitude;
	private double longitude;
	private String historyDescription;
	private Location location = new Location();
	
	 @Override
	public boolean equals(Object o) {
	 
	        // If the object is compared with itself then return true  
	        if (o == this) {
	            return true;
	        }
	 
	        /* Check if o is an instance of Complex or not
	          "null instanceof [type]" also returns false */
	        if (!(o instanceof HistoricalSite)) {
	            return false;
	        }
	         
	        // typecast o to Complex so that we can compare data members 
	        HistoricalSite c = (HistoricalSite) o;
	         
	        // Compare the data members and return accordingly 
	        return Double.compare(longitude, c.getLocation().getLongitude()) == 0
	                && Double.compare(latitude, c.getLocation().getLatitude()) == 0
	                && historyDescription == c.getHistoryDescription()
	                && displayName == c.getDisplayName()
	        		&& locationDescription == c.getLocationDescription();
	}
	public boolean isVisited() {
		return visited;		
	}
	
	public HistoricalSite(String siteName) {
		this.displayName = siteName;
	}
	
	public void setVisited() {
		visited = true;
	}
	
	public void setUnvisited() {
		visited = false;
	}
	
	public void setDisplayName(String name) {
		displayName = name;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setLocationDescription(String description) {
		locationDescription = description;
	}
	
	public String getLocationDescription() {
		return locationDescription;
	}
	
	public void setLocation(Location l) {
		if (l == null)
				throw new IllegalArgumentException("Location cannot be null.");
		this.location = l;
	}
	
	public Location getLocation() {
		return location;
	}	
	
	public void setHistoryDescription(String description) {
		historyDescription = description;
	}
	
	public String getHistoryDescription() {
		return historyDescription;
	}
}