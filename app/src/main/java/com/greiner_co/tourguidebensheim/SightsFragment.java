package com.greiner_co.tourguidebensheim;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SightsFragment extends Fragment {

    // Store the current context
    Context currentContext;


    public SightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_attractions, container, false);

        // Get the current context and store it for later use
        currentContext = getActivity().getApplicationContext();

        ImageView imageHeader = new ImageView(currentContext);
        imageHeader.setImageResource(R.drawable.bensheim_panorama_01_2);
        String imageContentDescription = getResources().getString(R.string.image_header_sights);
        imageHeader.setContentDescription(imageContentDescription);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);


        listView.addHeaderView(imageHeader);


        return rootView;
    }

}
