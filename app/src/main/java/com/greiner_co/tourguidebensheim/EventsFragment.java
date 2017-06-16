package com.greiner_co.tourguidebensheim;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    // Store the current context
    @SuppressWarnings("WeakerAccess")
    Context currentContext;

    @SuppressWarnings("unused")
    public EventsFragment() {
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
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        View headerView = View.inflate(currentContext, R.layout.header_view, null);
        ImageView imageHeader = (ImageView) headerView.findViewById(R.id.fragment_list_view_header);
        imageHeader.setImageResource(R.drawable.bensheim_panorama_01_4);
        String imageContentDescription = getResources().getString(R.string.image_header_sights);
        imageHeader.setContentDescription(imageContentDescription);

        listView.addHeaderView(headerView);

        // Initialize Attraction ArrayList
        final ArrayList<Attraction> attractions = new ArrayList<>();

        // Create a list of attractions
        attractions.add(new Attraction("Bergsträßer Weinfrühling", "Explore over 180 wines and sparkling wines from the region in the heart of Bensheim", "22", "Apr", R.drawable.bergstraesser_weinfruehling));
        attractions.add(new Attraction("Weinlagenwanderung", "Numerous hikers and wine lovers take part in this walk through the vineyards between Heppenheim and Zwingenberg", "01", "May", R.drawable.weinlagenwanderung));
        attractions.add(new Attraction("Maiway", "Music Festival in Bensheim with more than 40 bands on 28 stages – all locations are connected with a red line throughout the city", "24", "May", R.drawable.maiway));
        attractions.add(new Attraction("Bensheimer Bürgerfest", "The City of Bensheim turns into festival zone with culinary and art", "08", "Jun", R.drawable.buergerfest));
        attractions.add(new Attraction("Opern Air Fürstenlager", "Enjoy music from Mozart to Verdi during a picnic in the state park Fürstenlager", "24", "Jun", R.drawable.fuerstenlager));
        attractions.add(new Attraction("Bergsträßer Winzerfest", "Winemakers from the region present their wines in a village Downtown Bensheim", "02", "Sep", R.drawable.winzerfest_bensheim));
        attractions.add(new Attraction("Weihnachtsmarkt", "Traditional Christmas Market in the heart of the city", "30", "Nov", R.drawable.bensheim_marktplatz_weihnachten_02));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings.
        AttractionAdapter itemsAdapter = new AttractionAdapter(getActivity(), attractions);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of attractions.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

}
