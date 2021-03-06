package edu.vanderbilt.backnash.location;

import android.location.Location;
public class UserLocation {
	private Location myLoc;

	/**
	 * Constructor using two doubles
	 */
	public UserLocation(double latitude, double longitude)
	{
		myLoc = new Location("");
		myLoc.setLatitude(latitude);
		myLoc.setLongitude(longitude);
	}
	
	
	/***
	 * 
	 * @param l a Location Object
	 * creates a UserLocation Object out of location
	 */
	public UserLocation(Location l)
	{
		myLoc = new Location(l);
	}
	/**
	 * Returns a Location object 
	 */
	public Location getLocation()
	{
		return myLoc;
	}
	/**
	 * Returns the latitude associated with myLoc
	 */
	public double getLatitude()
	{
		return myLoc.getLatitude();
	}
	/***
	 * Returns the locations Longitude
	 */
	public double getLongitude ()
	{
		return myLoc.getLongitude();
	}
	/***
	 * Sets Latitude
	 */
	public void setLatitude(double latitude)
	{
		myLoc.setLatitude(latitude);
	}
	/***
	 * Sets Longitude
	 */
	public void setLongitude(double longitude)
	{
		myLoc.setLongitude(longitude);
	}
	/***
	 * Calculates the distance between two Locations
	 * using the formula and code from geodatasource.com/developers/java.
	 */
	public double distanceTo(UserLocation second)
	{
		return myLoc.distanceTo(second.getLocation());
	}
	/**
	 * Relies on the equals method of the Location object. 
	 */
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		
		return myLoc.equals(o);
	}
}
