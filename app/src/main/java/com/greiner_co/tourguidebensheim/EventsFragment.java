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
    Context currentContext;

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

        View headerView = LayoutInflater.from(currentContext).inflate(R.layout.header_view, null);
        ImageView imageHeader = (ImageView) headerView.findViewById(R.id.fragment_list_view_header);
        imageHeader.setImageResource(R.drawable.bensheim_panorama_01_4);
        String imageContentDescription = getResources().getString(R.string.image_header_sights);
        imageHeader.setContentDescription(imageContentDescription);

        listView.addHeaderView(headerView);

        // Initialize Attraction ArrayList
        final ArrayList<Attraction> attractions = new ArrayList<>();

        // Create a list of attractions
        attractions.add(new Attraction("Das ist der erste Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der zweite Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der dritte Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der vierte Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der erste Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der zweite Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der dritte Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der vierte Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der erste Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der zweite Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der dritte Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));
        attractions.add(new Attraction("Das ist der vierte Titel", "Jede Menge Details, die man gern noch später nachschauen mag. Oder einfach direkt bei Wikipedia nachschlägt.", R.drawable.bensheim_map));

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
