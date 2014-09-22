
package edu.vanderbilt.cs278.team2.assign1;

import android.location.Location;
public class myLocation {
	private Location myLoc;
	public myLocation(double latitude, double longitude)
	{
		myLoc.setLatitude(latitude);
		myLoc.setLongitude(longitude);
	}
	
	
	/***
	 * 
	 * @param l a Location Object
	 * creates a myLocation Object out of location
	 */
	public myLocation(Location l)
	{
		myLoc = new Location(l);
	}
	
	public Location getLocation()
	{
		return myLoc;
	}
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
	public double distanceTo(myLocation second)
	{
		return myLoc.distanceTo(second.getLocation());
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		
		return myLoc.equals(o);
	}
}
