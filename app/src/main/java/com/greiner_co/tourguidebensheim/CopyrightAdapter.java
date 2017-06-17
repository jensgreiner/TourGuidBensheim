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
 * Custom adapter to be used with copyright objects and list
 * Created by Jens Greiner on 16.06.17.
 */

@SuppressWarnings("WeakerAccess")
public class CopyrightAdapter extends ArrayAdapter<Copyright> {

    private final Context mContext;

    /**
     * Creates a new CopyrightAdapter as a custom extension of ArrayAdapter class
     *
     * @param context    The current context. Used to inflate the layout file
     * @param copyrights The objects to represent in the ListView.
     */
    public CopyrightAdapter(Context context, ArrayList<Copyright> copyrights) {
        super(context, 0, copyrights);
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


        if (convertView == null) {

            // Inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.copyright_list_item, parent, false);

            // Setup viewHolder
            holder = new ViewHolder();
            holder.titleText = (TextView) convertView.findViewById(R.id.copyright_text_view_title);
            holder.image = (ImageView) convertView.findViewById(R.id.copyright_image_view);

            // store the holder with the view
            convertView.setTag(holder);

        } else {
            // we've just avoided calling findViewById() on resource every time
            // just use viewHolder
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the {@link Copyright} object located at this position in the list
        Copyright currentCopyright = getItem(position);

        if (currentCopyright != null) {
            // get TextView from ViewHolder and then set the text

            // Get the copyright title from the current Copyright object and
            // set this text on the holder TextView
            holder.titleText.setText(currentCopyright.getmCopyrightTitle());
            // set the image
            holder.image.setImageResource(currentCopyright.getmCopyrightImage());
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
        ImageView image;
    }
}
