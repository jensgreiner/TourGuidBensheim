package com.greiner_co.tourguidebensheim;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    // Store the current context
    @SuppressWarnings("WeakerAccess")
    Context currentContext;

    @SuppressWarnings("unused")
    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_attractions, container, false);

        // Get the current context and store it for later use
        currentContext = getActivity().getApplicationContext();

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // attraction_list.xml file.
        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        View headerView = View.inflate(currentContext, R.layout.header_view, null);
        ImageView imageHeader = (ImageView) headerView.findViewById(R.id.fragment_list_view_header);
        imageHeader.setImageResource(R.drawable.bensheim_panorama_01_3);
        String imageContentDescription = getResources().getString(R.string.image_header_sights);
        imageHeader.setContentDescription(imageContentDescription);

        listView.addHeaderView(headerView);

        // Initialize Attraction ArrayList
        final ArrayList<Attraction> attractions = new ArrayList<>();

        // Create a list of attractions
        attractions.add(new Attraction("Blauer Aff", "Kappengasse 2, 64625 Bensheim", R.drawable.blaueraff));
        attractions.add(new Attraction("Walderdorffer Hof", "Obergasse 30, 64625 Bensheim", R.drawable.walderdorffer_hof_bensheim));
        attractions.add(new Attraction("Burggraf Bräu", "Darmstädter Str. 231, 64625 Bensheim", R.drawable.burggraf_braeu_bensheim_auerbach));
        attractions.add(new Attraction("Okinawa Sushi&More", "Berliner Ring 89, 64625 Bensheim", R.drawable.okinawa));
        attractions.add(new Attraction("Alte Dorfmühle", "Bachgasse 71, 64625 Bensheim", R.drawable.dorfmuehle_bachgasse_bensheim_auerbach_01));
        attractions.add(new Attraction("Villa Lacus", "Berliner Ring 108, 64625 Bensheim", R.drawable.villa_lacus));
        attractions.add(new Attraction("Metropolis Bensheim", "Berliner Ring 26, 64625 Bensheim", R.drawable.metropolis));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings.
        AttractionAdapter itemsAdapter = new AttractionAdapter(getActivity(), attractions);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of attractions.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        // Make OnItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Callback method to be invoked when an item in this AdapterView has
             * been clicked.
             * <p>
             * Implementers can call getItemAtPosition(position) if they need
             * to access the data associated with the selected item.
             *
             * @param parent   The AdapterView where the click happened.
             * @param view     The view within the AdapterView that was clicked (this
             *                 will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             * @param id       The row id of the item that was clicked.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // To compensate the header view on position 0 use this
                // @link https://stackoverflow.com/a/28734351/1469260
                position -= listView.getHeaderViewsCount();

                Attraction attraction = attractions.get(position);
                String address = attraction.getmAttractionDetails();
                address = address.replaceAll(" ", "+");
                // @link https://stackoverflow.com/a/7116840/1469260
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.de/maps/place/" + address));
                if (isAppInstalled("com.google.android.apps.maps")) {
                    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                }
                startActivity(intent);
            }
        });

        return rootView;
    }

    // helper function to check if Maps is installed
    // @link https://stackoverflow.com/a/7116840/1469260
    @SuppressWarnings("SameParameterValue")
    private boolean isAppInstalled(String uri) {
        PackageManager pm = currentContext.getPackageManager();
        boolean app_installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }
}
