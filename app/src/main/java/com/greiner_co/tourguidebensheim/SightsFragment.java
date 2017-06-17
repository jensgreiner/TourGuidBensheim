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
public class SightsFragment extends Fragment {

    // Store the current context
    @SuppressWarnings("WeakerAccess")
    Context currentContext;

    @SuppressWarnings("unused")
    public SightsFragment() {
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
        imageHeader.setImageResource(R.drawable.bensheim_panorama_01_2);
        String imageContentDescription = getResources().getString(R.string.image_header_sights);
        imageHeader.setContentDescription(imageContentDescription);

        listView.addHeaderView(headerView);

        // Initialize Attraction ArrayList
        final ArrayList<Attraction> attractions = new ArrayList<>();

        // Create a list of attractions
        attractions.add(new Attraction(getString(R.string.title_alte_gerberei_01), getString(R.string.detail_alte_gerberei_01), R.drawable.alte_gerberei_01));
        attractions.add(new Attraction(getString(R.string.title_schloss_auerbach), getString(R.string.detail_schloss_auerbach), R.drawable.schloss_auerbach));
        attractions.add(new Attraction(getString(R.string.title_kirchberghaeuschen_bensheim), getString(R.string.detail_kirchberghaeuschen_bensheim), R.drawable.kirchberghaeuschen_bensheim));
        attractions.add(new Attraction(getString(R.string.title_rathaus_bensheim_01), getString(R.string.detail_rathaus_bensheim_01), R.drawable.rathaus_bensheim_01));
        attractions.add(new Attraction(getString(R.string.title_roter_turm_bensheim2), getString(R.string.detail_roter_turm_bensheim2), R.drawable.roter_turm_bensheim2));
        attractions.add(new Attraction(getString(R.string.title_wambolter_hof), getString(R.string.detail_wambolter_hof), R.drawable.wambolter_hof));
        attractions.add(new Attraction(getString(R.string.title_st_georg_bensheim_tuerme), getString(R.string.detail_st_georg_bensheim_tuerme), R.drawable.st_georg_bensheim_tuerme));

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
