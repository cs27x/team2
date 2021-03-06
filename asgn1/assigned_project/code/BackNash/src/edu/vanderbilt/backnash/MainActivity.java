package edu.vanderbilt.backnash;

import java.util.ArrayList;
import java.util.Arrays;

import edu.vanderbilt.backnash.data.HistoricalSitesBroker;
import edu.vanderbilt.backnash.internal.HistoricalSitesList;

import team2.backnash.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.app.AlertDialog.*;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;

//An activity is essentially the code for a given screen of the app while it runs.
//You create a new class that extends Activity for every screen, and then
//give it it's functionality starting with the onCreate() function.
//Implements OnItemClickListener is added because this Activity has a OnItemClickListener
public class MainActivity extends Activity implements OnItemClickListener {

    class RetrieveJSONTask extends AsyncTask<HistoricalSitesBroker, Void, HistoricalSitesList> {

        private Exception exception = null;
        private Activity mainActivity;

        @Override
        protected HistoricalSitesList doInBackground(HistoricalSitesBroker ... broker) {
            // jdk edit: getMasterList from HistoricalSitesBroker and get display names
            try {
                return broker[0].getMasterList();
            }
            catch (Exception e) {
//                new AlertDialog.Builder(this)
//                        .setTitle("JSON Fetch Error")
//                        .setMessage(e.toString())
//                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                // continue with delete
//                            }
//                        })
//                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                // do nothing
//                            }
//                        })
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .show();
                e.printStackTrace();
                this.exception = e;
            }
            return null;
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        @Override
        protected void onPostExecute(HistoricalSitesList feed) {
            // TODO: check this.exception
            // TODO: do something with the feed
            if (feed == null && exception != null)
                return;

            ArrayAdapter<String> adapter = null;
            try {
                adapter = (ArrayAdapter<String>) m_mainListView.getAdapter();
                adapter.clear();
                adapter.addAll(feed.getDisplayNames());
                adapter.notifyDataSetChanged();
            } catch (ClassCastException|NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

	// String that we will use as the tag name for all log messages in this
	// activity.
	private final String LOG_TAG = "MainActivity";
	// Example of message logging: (put it in a function)
	// Log.v(LOG_TAG, "Test Message: Team2 rocks");

	// <------ view variables ------>

	// m_mainListView holds the reference to the ListView view. Each view
	// requires
	// an variable to refer to it of the appropriate type.
	// Hover over the variable type and eclipse should help you import it as an
	// option.
	private ListView m_mainListView;

	// <------ Private variables ------>

	// The adapter is used for populating the LiveView (in this case
	// m_mainListvView)
	// with several instances of another given view (in this case
	// R.layout.simplerow)
	private ListAdapter m_listAdapter;
    private HistoricalSitesBroker broker;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Find the ListView resource that we are working with.
		// Each that you want to work with on multiple levels (which is usually
		// most
		// interactive views) should include the line
		// android:id="@+id/mainListView" in
		// the activity xml. We use findViewbyId here to find that view again.
		m_mainListView = (ListView) findViewById(R.id.mainListView);
		m_mainListView.setOnItemClickListener(this);

		// FileOutputStream fileOut = openFileOutput("user_queue",
		// Context.MODE_PRIVATE);

		// Create a dummy list of historical sites.
		String[] locations = new String[] { "Vanderbilt", "Rand",
				"Feathering Gill", "Stevenson", "Site A", "Site B", "Site C",
				"Site D", "Site E", "Site F", "Site G", "Site H" };
		ArrayList<String> tempLocationList = new ArrayList<String>();
		
		// The reason why we convert an a String[] into a ArrayList here is for
		// convenience later on.
		tempLocationList.addAll(Arrays.asList(locations));


		// Create ArrayAdapter using the tempLocationList.
		// An ArrayAdapter is a android class used to convert things individual
		// things for use in a View.
		// In this case, we're converting the contents of an ArrayList into a
		// ListView.
		// WARNING: If you pass a String[] into ArrayAdapter instead of a
		// List<String> (like planetList is)
		// You can not add more items into the ArrayAdapter later on.
		// ArrayAdapter takes a view as a template for it's second parameter.
		// R.layout.simplerow is stored in
		// res/layout/simplerow.xml
		m_listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow,
				tempLocationList);

		// Add more locations. Only possible if List<String> was used in
		// m_listAdapter's creation.
//		m_listAdapter.add("Commons");
//		m_listAdapter.add("Kissam");

		// Set the ArrayAdapter as the ListView's adapter. Android voodoo magic.
		m_mainListView.setAdapter(m_listAdapter);
        broker = new HistoricalSitesBroker();
        new RetrieveJSONTask().execute(broker);

	}

	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
		Log.v(LOG_TAG, "Test Message: You clicked item #" + position);
		showDialog(v);
	}

	@SuppressLint("NewApi")
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void showDialog(View view) {

		FragmentManager manager = getFragmentManager();

		DialogFragmentLocationOptions dialog = new DialogFragmentLocationOptions();
		dialog.show(manager, "dialog");

	}
}