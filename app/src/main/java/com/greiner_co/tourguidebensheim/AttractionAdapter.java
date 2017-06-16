package com.greiner_co.tourguidebensheim;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jens Greiner on 16.06.17.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    /**
     * Creates a new AttractionAdapter as a custom extension of ArrayAdapter class
     *
     * @param context     The current context. Used to inflate the layout file
     * @param attractions The objects to represent in the ListView.
     */
    public AttractionAdapter(@NonNull Context context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        // View could be null when the Activity is called first time
        View listItemView = convertView;
        if (listItemView == null) {
            if (currentAttraction != null && currentAttraction.isEvent()) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.event_list_item, parent, false);
            } else {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.attraction_list_item, parent, false);
            }
        }

        // Find the TextView in the attraction_list_item.xml layout with the ID attraction_text_view_title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.attraction_text_view_title);
        // Get the attraction title from the current Attraction object and
        // set this text on the name TextView
        if (currentAttraction != null) {
            titleTextView.setText(currentAttraction.getmAttractionTitle());
        }

        // Find the TextView in the attraction_list_item.xml named ... and set the text
        TextView detailTextView = (TextView) listItemView.findViewById(R.id.attraction_text_view_detail);
        if (currentAttraction != null) {
            detailTextView.setText(currentAttraction.getmAttractionDetails());
        }

        if (currentAttraction != null && currentAttraction.isEvent()) {
            // Find the TextView in the event_list_item.xml layout to set the day
            TextView dayTextView = (TextView) listItemView.findViewById(R.id.date_text_view_day);
            dayTextView.setText(currentAttraction.getmEventDay());
            TextView monthTextView = (TextView) listItemView.findViewById(R.id.date_text_view_month);
            monthTextView.setText(currentAttraction.getmEventMonth());
        }

        if (currentAttraction != null && !currentAttraction.isEvent()) {
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
            // Check if an image id is provided or not
            if (currentAttraction.hasImage()) {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(currentAttraction.getmImageResourceId());
            } else {
                // No image id given so make image invisible/gone
                imageView.setVisibility(View.GONE);
            }
        }

        return listItemView;
    }
}
