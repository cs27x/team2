package edu.vanderbilt.backnash.location;

import android.location.Location;

/**
 * 
 * @author Gabe Sechan
 *  http://stackoverflow.com/questions/1513485/how-do-i-get-the-current-gps-location-programmatically-in-android/10917500#10917500
 *     
 */
	public interface LocationTracker
	{
	    public interface LocationUpdateListener
	    {
	        public void onUpdate(Location oldLoc, long oldTime, Location newLoc, long newTime);
	    }

	    public void start();
	    public void start(LocationUpdateListener update);

	    public void stop();

	    public boolean hasLocation();

	    public boolean hasPossiblyStaleLocation();

	    public Location getLocation();

	    public Location getPossiblyStaleLocation();

	}
