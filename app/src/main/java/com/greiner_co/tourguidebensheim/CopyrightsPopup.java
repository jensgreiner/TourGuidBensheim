package com.greiner_co.tourguidebensheim;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jens Greiner on 16.06.17.
 *
 * @link Inspired by https://youtu.be/fn5OlqQuOCk
 */

@SuppressWarnings("unused")
public class CopyrightsPopup extends AppCompatActivity {
    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.copyright_list);

        // Make the activity smaller than the devices screen
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .85));

        Toolbar myToolbar = (Toolbar) findViewById(R.id.copyright_toolbar);
        String toolbarTitle = getResources().getString(R.string.copyright_toolbar_title);
        myToolbar.setTitle(toolbarTitle);
        setSupportActionBar(myToolbar);

        // Check for possible NullPointerException
        // @link https://stackoverflow.com/a/35719588/1469260
        if (getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_close_light);
        }

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // attraction_list.xml file.
        ListView listView = (ListView) findViewById(R.id.copyright_list);

        // Initialize Attraction ArrayList
        final ArrayList<Copyright> copyrights = new ArrayList<>();

        // Create a list of attractions
        copyrights.add(new Copyright(getString(R.string.copyright_bensheim_panorama_01_2), R.drawable.bensheim_panorama_01_2));
        copyrights.add(new Copyright(getString(R.string.copyright_wappen_bensheim), R.drawable.wappen_bensheim));
        copyrights.add(new Copyright(getString(R.string.copyright_bensheim_map), R.drawable.bensheim_map));
        copyrights.add(new Copyright(getString(R.string.copyright_mandelbaumbluete_in_bensheim), R.drawable.mandelbaumbluete_in_bensheim));
        copyrights.add(new Copyright(getString(R.string.copyright_alte_gerberei_01), R.drawable.alte_gerberei_01));
        copyrights.add(new Copyright(getString(R.string.copyright_schloss_auerbach), R.drawable.schloss_auerbach));
        copyrights.add(new Copyright(getString(R.string.copyright_kirchberghaeuschen_bensheim), R.drawable.kirchberghaeuschen_bensheim));
        copyrights.add(new Copyright(getString(R.string.copyright_rathaus_bensheim_01), R.drawable.rathaus_bensheim_01));
        copyrights.add(new Copyright(getString(R.string.copyright_roter_turm_bensheim2), R.drawable.roter_turm_bensheim2));
        copyrights.add(new Copyright(getString(R.string.copyright_wambolter_hof), R.drawable.wambolter_hof));
        copyrights.add(new Copyright(getString(R.string.copyright_st_georg_bensheim_tuerme), R.drawable.st_georg_bensheim_tuerme));
        copyrights.add(new Copyright(getString(R.string.copyright_blaueraff), R.drawable.blaueraff));
        copyrights.add(new Copyright(getString(R.string.copyright_walderdorffer_hof_bensheim), R.drawable.walderdorffer_hof_bensheim));
        copyrights.add(new Copyright(getString(R.string.copyright_burggraf_braeu_bensheim_auerbach), R.drawable.burggraf_braeu_bensheim_auerbach));
        copyrights.add(new Copyright(getString(R.string.copyright_okinawa), R.drawable.okinawa));
        copyrights.add(new Copyright(getString(R.string.copyright_dorfmuehle_bachgasse_bensheim_auerbach_01), R.drawable.dorfmuehle_bachgasse_bensheim_auerbach_01));
        copyrights.add(new Copyright(getString(R.string.copyright_villa_lacus), R.drawable.villa_lacus));
        copyrights.add(new Copyright(getString(R.string.copyright_metropolis), R.drawable.metropolis));
        copyrights.add(new Copyright(getString(R.string.copyright_bergstraesser_weinfruehling), R.drawable.bergstraesser_weinfruehling));
        copyrights.add(new Copyright(getString(R.string.copyright_weinlagenwanderung), R.drawable.weinlagenwanderung));
        copyrights.add(new Copyright(getString(R.string.copyright_maiway), R.drawable.maiway));
        copyrights.add(new Copyright(getString(R.string.copyright_buergerfest), R.drawable.buergerfest));
        copyrights.add(new Copyright(getString(R.string.copyright_fuerstenlager), R.drawable.fuerstenlager));
        copyrights.add(new Copyright(getString(R.string.copyright_winzerfest_bensheim), R.drawable.winzerfest_bensheim));
        copyrights.add(new Copyright(getString(R.string.copyright_bensheim_marktplatz_weihnachten_02), R.drawable.bensheim_marktplatz_weihnachten_02));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings.
        CopyrightAdapter itemsAdapter = new CopyrightAdapter(this, copyrights);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of attractions.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

    }
}
