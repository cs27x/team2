package edu.vanderbilt.backnash.internal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.vanderbilt.backnash.location.Location;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoricalSite {
	private boolean visited;

	@JsonProperty("title")
	private String displayName;
	@JsonProperty("location")
	private String locationDescription;
	@JsonProperty("latitude")
	private double latitude;
	@JsonProperty("longitude")
	private double longitude;
	private String historyDescription;
	@JsonProperty("marker_text")
	private Location location = new Location();

	public HistoricalSite() {
		super();
	}

	@Override
	public boolean equals(Object o) {

		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}

		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]"
		 * also returns false
		 */
		if (!(o instanceof HistoricalSite)) {
			return false;
		}

		// typecast o to Complex so that we can compare data members
		HistoricalSite c = (HistoricalSite) o;

		// Compare the data members and return accordingly
		return Double.compare(getLongitude(), c.getLocation().getLongitude()) == 0
				&& Double.compare(getLatitude(), c.getLocation().getLatitude()) == 0
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

	@JsonProperty("name")
	public void setDisplayName(String name) {
		displayName = name;
	}

	@JsonProperty("name")
	public String getDisplayName() {
		return displayName;
	}

	@JsonProperty("location")
	public void setLocationDescription(String description) {
		locationDescription = description;
	}

	@JsonProperty("location")
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

	@JsonProperty("marker_text")
	public void setHistoryDescription(String description) {
		historyDescription = description;
	}

	@JsonProperty("marker_text")
	public String getHistoryDescription() {
		return historyDescription;
	}

	@JsonProperty("latitude")
	public double getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public double getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
