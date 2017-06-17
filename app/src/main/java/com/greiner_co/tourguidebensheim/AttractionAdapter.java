package com.greiner_co.tourguidebensheim;

import android.app.Activity;
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
 * Custom adapter to handle attraction objects and list
 * Created by Jens Greiner on 16.06.17.
 */

@SuppressWarnings("WeakerAccess")
public class AttractionAdapter extends ArrayAdapter<Attraction> {

    private final Context mContext;

    /**
     * Creates a new AttractionAdapter as a custom extension of ArrayAdapter class
     *
     * @param context     The current context. Used to inflate the layout file
     * @param attractions The objects to represent in the ListView.
     */
    public AttractionAdapter(@NonNull Context context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
        mContext = context;
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
        // ViewHolder Pattern: To reference the child views for later actions
        ViewHolder holder;

        // Get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        if (convertView == null) {
            // Inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();

            // Check whether currentAttraction is an event or not
            if ((currentAttraction != null) && currentAttraction.isEvent()) {
                convertView = inflater.inflate(R.layout.event_list_item, parent, false);
            } else {
                convertView = inflater.inflate(R.layout.attraction_list_item, parent, false);
            }
            // Setup viewHolder
            holder = new ViewHolder();
            holder.titleText = (TextView) convertView.findViewById(R.id.attraction_text_view_title);
            holder.detailText = (TextView) convertView.findViewById(R.id.attraction_text_view_detail);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            // Check if attraction is event
            if ((currentAttraction != null) && currentAttraction.isEvent()) {
                holder.dayText = (TextView) convertView.findViewById(R.id.date_text_view_day);
                holder.monthText = (TextView) convertView.findViewById(R.id.date_text_view_month);
            }

            // store the holder with the view
            convertView.setTag(holder);

        } else {
            // we've just avoided calling findViewById() on resource every time
            // just use viewHolder
            holder = (ViewHolder) convertView.getTag();
        }

        if (currentAttraction != null) {
            // Get the attraction title from the current Attraction object and
            // set this text on the holder TextView
            holder.titleText.setText(currentAttraction.getmAttractionTitle());
            holder.detailText.setText(currentAttraction.getmAttractionDetails());
            // for events set day and month
            if (currentAttraction.isEvent()) {
                holder.dayText.setText(currentAttraction.getmEventDay());
                holder.monthText.setText(currentAttraction.getmEventMonth());
            }

            // Events don't show an image yet so this part is not needed for events
            if (!currentAttraction.isEvent()) {
                // Check whether an image was provided or not
                if (currentAttraction.hasImage()) {
                    // set the image
                    holder.image.setImageResource(currentAttraction.getmImageResourceId());
                    // make view visible
                    holder.image.setVisibility(View.VISIBLE);
                } else {
                    // No image - make view invisible/gone
                    holder.image.setVisibility(View.GONE);
                }
            }
        }
        return convertView;
    }

    /**
     * ViewHolder pattern: findViewById method is expensive to use frequently.
     * Having a static class ViewHolder to store the content and retrieve it in an ArrayAdapter
     * is less expensive. (see also code parts above)
     * Suggested by Udacity code reviewer for this project
     *
     * @link https://stackoverflow.com/a/3832467
     */
    static class ViewHolder {
        TextView titleText;
        TextView detailText;
        TextView dayText;
        TextView monthText;
        ImageView image;
    }
}
