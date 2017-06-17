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
        attractions.add(new Attraction(getString(R.string.title_bergstraesser_weinfruehling), getString(R.string.detail_bergstraesser_weinfruehling), getString(R.string.day_bergstraesser_weinfruehling), getString(R.string.month_bergstraesser_weinfruehling), R.drawable.bergstraesser_weinfruehling));
        attractions.add(new Attraction(getString(R.string.title_weinlagenwanderung), getString(R.string.detail_weinlagenwanderung), getString(R.string.day_weinlagenwanderung), getString(R.string.month_weinlagenwanderung), R.drawable.weinlagenwanderung));
        attractions.add(new Attraction(getString(R.string.title_maiway), getString(R.string.detail_maiway), getString(R.string.day_maiway), getString(R.string.month_maiway), R.drawable.maiway));
        attractions.add(new Attraction(getString(R.string.title_buergerfest), getString(R.string.detail_buergerfest), getString(R.string.day_buergerfest), getString(R.string.month_buergerfest), R.drawable.buergerfest));
        attractions.add(new Attraction(getString(R.string.title_fuerstenlager), getString(R.string.detail_fuerstenlager), getString(R.string.day_fuerstenlager), getString(R.string.month_fuerstenlager), R.drawable.fuerstenlager));
        attractions.add(new Attraction(getString(R.string.title_winzerfest_bensheim), getString(R.string.detail_winzerfest_bensheim), getString(R.string.day_winzerfest_bensheim), getString(R.string.month_winzerfest_bensheim), R.drawable.winzerfest_bensheim));
        attractions.add(new Attraction(getString(R.string.title_bensheim_marktplatz_weihnachten_02), getString(R.string.detail_bensheim_marktplatz_weihnachten_02), getString(R.string.day_bensheim_marktplatz_weihnachten_02), getString(R.string.month_bensheim_marktplatz_weihnachten_02), R.drawable.bensheim_marktplatz_weihnachten_02));

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
