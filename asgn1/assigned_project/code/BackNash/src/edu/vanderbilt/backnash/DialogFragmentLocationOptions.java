package edu.vanderbilt.backnash;

import team2.backnash.R;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DialogFragmentLocationOptions extends DialogFragment implements
		OnItemClickListener {

	String[] listitems = { "Add to Queue", "Mark as Visited",
			"Mark as Unvisited", "Cancel" };

	ListView mylist;

	//creates the fragment view using the layout R.layout.location_dialog_fragment
	//This is called when a view containing this activity is created
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.location_dialog_fragment, null, false);
		mylist = (ListView) view.findViewById(R.id.listOfLocationOptions);

		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		return view;
	}

	//This is called when the dialogFragmentLocationOptions object is created
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, listitems);

		mylist.setAdapter(adapter);

		mylist.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// do something when dialog option is clicked
		dismiss();
	}

}