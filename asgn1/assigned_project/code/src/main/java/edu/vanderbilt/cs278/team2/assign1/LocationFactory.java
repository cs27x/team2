
import android.location.*;

import android.location.LocationListener;

import com.google.android.gms.location.*;
import com.example.nashpast.myLocation;

import android.app.Service;
import android.content.*;

import java.util.List;
import java.util.Locale;

public class LocationFactory{
	
	/**
	 * @author Neutrino with changes by Michael Schoenfield
	 * takes in an address and context, return a myLocation object containing
	 * the desired latitude and longitude
	 * Uses Geocoder
	 */
	public myLocation createLocationFromAddress(String address, Context context)
	{
		Geocoder mGeoCoder = new Geocoder(context, Locale.getDefault());
		    if (address != null && !address.isEmpty()) {
		        try {
		            List<Address> addressList = mGeoCoder.getFromLocationName(address, 1);
		            if (addressList != null && addressList.size() > 0) {
		                double lat = addressList.get(0).getLatitude();
		                double lng = addressList.get(0).getLongitude();
		                myLocation myLoc = new myLocation(lat,lng);
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
	public myLocation getCurrentLocation(Context context)
	{
		LocationTracker myLocTracker = new FallbackLocationTracker(context);
		return new myLocation(myLocTracker.getLocation());
	}
	/**
	 * Takes in Lat and Longitude in the form of doubles, and returns a mylocation
	 */
	public myLocation getLocationLatLong(double lat, double lng)
	{
		return new myLocation(lat,lng);
	}
	
	
	
}
