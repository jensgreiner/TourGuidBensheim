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
        copyrights.add(new Copyright("By Kuebi = Armin Kübelbeck - own work, made with 8 single pictures stiched to one with the use of Hugin, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=5202148", R.drawable.bensheim_panorama_01_2));
        copyrights.add(new Copyright("By Die Schreiber - Eigenes Werk, Gemeinfrei, https://commons.wikimedia.org/w/index.php?curid=20148435", R.drawable.wappen_bensheim));
        copyrights.add(new Copyright("By Mapmaster - OpenStreetMap, CC BY-SA 2.0, https://de.wikipedia.org/w/index.php?curid=6478098", R.drawable.bensheim_map));
        copyrights.add(new Copyright("By Armin Kübelbeck - Own work, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=1793432", R.drawable.mandelbaumbluete_in_bensheim));
        copyrights.add(new Copyright("By Kuebi = Armin Kübelbeck - Eigenes Werk, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=3897953", R.drawable.alte_gerberei_01));
        copyrights.add(new Copyright("Public Domain, https://commons.wikimedia.org/w/index.php?curid=416183", R.drawable.schloss_auerbach));
        copyrights.add(new Copyright("By Kuebi = Armin Kübelbeck - Eigenes Werk (own picture), CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=1685132", R.drawable.kirchberghaeuschen_bensheim));
        copyrights.add(new Copyright("By Kuebi = Armin Kübelbeck - Eigenes Werk, CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=3935396", R.drawable.rathaus_bensheim_01));
        copyrights.add(new Copyright("By Armin Kübelbeck - eigenes Bild --Kuebi 15:06, 3 February 2007 (UTC), CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=1631867", R.drawable.roter_turm_bensheim2));
        copyrights.add(new Copyright("Public Domain, https://commons.wikimedia.org/w/index.php?curid=498901", R.drawable.wambolter_hof));
        copyrights.add(new Copyright("Gemeinfrei, https://commons.wikimedia.org/w/index.php?curid=498882", R.drawable.st_georg_bensheim_tuerme));
        copyrights.add(new Copyright("Klaus Rommel: http://www.panoramio.com/photo/129676954", R.drawable.blaueraff));
        copyrights.add(new Copyright("By User:Cethegus - Own work, Public Domain, https://commons.wikimedia.org/w/index.php?curid=498891", R.drawable.walderdorffer_hof_bensheim));
        copyrights.add(new Copyright("http://gastrogewerbeauskunft.de/listings/burggraf-braeu/", R.drawable.burggraf_braeu_bensheim_auerbach));
        copyrights.add(new Copyright("http://okinawa-bensheim.de/tischreservierung/", R.drawable.okinawa));
        copyrights.add(new Copyright("https://commons.wikimedia.org/wiki/File:Dorfmuehle_Bachgasse_Bensheim-Auerbach_01.jpg", R.drawable.dorfmuehle_bachgasse_bensheim_auerbach_01));
        copyrights.add(new Copyright("http://www.villa-lacus.de/ueber-uns", R.drawable.villa_lacus));
        copyrights.add(new Copyright("http://www.metropolis-bensheim.de", R.drawable.metropolis));
        copyrights.add(new Copyright("http://blog-wein-knueller.de/rund-um-den-wein/berstraesser-weinfruehling.html", R.drawable.bergstraesser_weinfruehling));
        copyrights.add(new Copyright("http://www.bergstraesser-wein.de/weinlagenwanderung/", R.drawable.weinlagenwanderung));
        copyrights.add(new Copyright("http://www.mymaiway.de/startseite/", R.drawable.maiway));
        copyrights.add(new Copyright("http://www.buergerfest-bensheim.de/cms/bilder-archiv/bilder-2016/bilder-2016-donnerstag", R.drawable.buergerfest));
        copyrights.add(new Copyright("http://fuerstenlager.info", R.drawable.fuerstenlager));
        copyrights.add(new Copyright("https://www.bensheim.de/kultur/feste-maerkte-in-bensheim.html", R.drawable.winzerfest_bensheim));
        copyrights.add(new Copyright("https://de.wikipedia.org/wiki/Marktplatz_(Bensheim)", R.drawable.bensheim_marktplatz_weihnachten_02));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings.
        CopyrightAdapter itemsAdapter = new CopyrightAdapter(this, copyrights);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of attractions.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

    }
}
