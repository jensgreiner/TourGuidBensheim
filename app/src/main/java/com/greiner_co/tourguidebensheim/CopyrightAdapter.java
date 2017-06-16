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

public class CopyrightAdapter extends ArrayAdapter<Copyright> {
    /**
     * Creates a new CopyrightAdapter as a custom extension of ArrayAdapter class
     *
     * @param context    The current context. Used to inflate the layout file
     * @param copyrights The objects to represent in the ListView.
     */
    public CopyrightAdapter(Context context, ArrayList<Copyright> copyrights) {
        super(context, 0, copyrights);
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
        // Check if the existing view is being reused, otherwise inflate the view
        // View could be null when the Activity is called first time
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.copyright_list_item, parent, false);
        }

        // Get the {@link Copyright} object located at this position in the list
        Copyright currentCopyright = getItem(position);

        if (currentCopyright != null) {
            // Find the TextView in the copyright_list_item.xml layout with the ID copyright_text_view_title
            TextView titleTextView = (TextView) listItemView.findViewById(R.id.copyright_text_view_title);
            // Get the copyright title from the current Copyright object and
            // set this text on the name TextView
            titleTextView.setText(currentCopyright.getmCopyrightTitle());
        }

        if (currentCopyright != null) {
            // Find the ImageView in the copyright_list_item.xml named ... and set the image
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.copyright_image_view);
            imageView.setImageResource(currentCopyright.getmCopyrightImage());
        }

        return listItemView;
    }
}
