package edu.vanderbilt.cs278.team2.assign1;

public class HistoricalSite {
	private boolean visited;
	private String displayName;
	private String locationDescription;
	private Location location;
	private String historyDescription;
	
	public HistoricalSite(String name) {
		this.displayName = name;
	}
	public boolean isVisited() {
		return visited;		
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
		location = l;
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