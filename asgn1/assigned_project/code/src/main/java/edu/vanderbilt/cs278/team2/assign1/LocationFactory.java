
import android.location.*;

import android.location.LocationListener;

import com.google.android.gms.location.*;
import com.example.nashpast.myLocation;

import android.app.Service;
import android.content.*;

import java.util.List;
import java.util.Locale;

public class LocationFactory{
	
	
	public myLocation createLocationFromAddress(String address, Context context)
	{
		Geocoder geoCoder = new Geocoder(context, Locale.getDefault());
		    if (address != null && !address.isEmpty()) {
		        try {
		            List<Address> addressList = geoCoder.getFromLocationName(address, 1);
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

	public myLocation getCurrentLocation(Context context)
	{
		LocationTracker myLocTracker = new FallbackLocationTracker(context);
		return new myLocation(myLocTracker.getLocation());
	}
	
	public myLocation getLocationLatLong(double lat, double lng)
	{
		return new myLocation(lat,lng);
	}
	
	
	
}
