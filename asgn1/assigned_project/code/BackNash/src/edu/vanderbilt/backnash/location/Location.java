package edu.vanderbilt.backnash.location;

public class Location {
	private double latitude, longitude;
	
	public Location (double la, double lo) {
		this.latitude = la;
		this.longitude = lo;
	}
	
	public Location() {
		this.latitude = 0.0;
		this.longitude = 0.0;
	}
	
	public double getLongitude() {
		return 0.0;
	}
	
	public double getLatitude() {
		return 0.0;
	}
	
	public double getDistanceTo(Location rhs) {
		double retVal = Math.pow(this.latitude - rhs.latitude, 2);
		retVal += Math.pow(this.longitude - rhs.longitude, 2);
		return Math.sqrt(retVal);
	}
}