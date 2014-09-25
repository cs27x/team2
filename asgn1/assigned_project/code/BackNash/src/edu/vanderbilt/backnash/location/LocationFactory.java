package edu.vanderbilt.backnash.location;

import java.util.List;
import java.util.Locale;



//import com.google.android.gms.location.*;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;

public class LocationFactory{
	
	/**
	 * @author Neutrino with changes by Michael Schoenfield
	 * takes in an address and context, return a UserLocation object containing
	 * the desired latitude and longitude
	 * Uses Geocoder
	 */
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public UserLocation createLocationFromAddress(String address, Context context)
	{
		Geocoder mGeoCoder = new Geocoder(context, Locale.getDefault());
		    if (address != null && !address.isEmpty()) {
		        try {
		            List<Address> addressList = mGeoCoder.getFromLocationName(address, 1);
		            if (addressList != null && addressList.size() > 0) {
		                double lat = addressList.get(0).getLatitude();
		                double lng = addressList.get(0).getLongitude();
		                UserLocation myLoc = new UserLocation(lat,lng);
		                return myLoc;
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } // end catch
		    } // end if
			return null;
	}
	/**
	 * Relies on the interface Location Tracker in order to create a location object
	 * with the current address.
	 */
	public UserLocation getCurrentLocation(Context context)
	{
		LocationTracker myLocTracker = new FallbackLocationTracker(context);
		return new UserLocation(myLocTracker.getLocation());
	}
	/**
	 * Takes in Lat and Longitude in the form of doubles, and returns a mylocation
	 */
	public UserLocation getLocationLatLong(double lat, double lng)
	{
		return new UserLocation(lat,lng);
	}
	
	
	
}
