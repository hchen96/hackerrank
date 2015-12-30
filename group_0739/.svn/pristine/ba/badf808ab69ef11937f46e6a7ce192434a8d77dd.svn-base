package group_0739.piii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayItineraries extends AppCompatActivity {

    private ListView lv;

    /**
     * This method sets up the screen for this activity; it displays all of the itineraries
     * searched by the admin.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_itineraries);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //get the admin, the search results and the search filters
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
        final ArrayList<Itinerary> sortedResults = (ArrayList<Itinerary>) intent.getSerializableExtra("ItineraryKey");
        final String origin = (String) intent.getSerializableExtra("OriginKey");
        final String destination = (String) intent.getSerializableExtra("DestinationKey");
        final String date = (String) intent.getSerializableExtra("DepartureKey");

        //put the search results in a list view format
        lv = (ListView) findViewById(R.id.sortedItineraries);
        ArrayAdapter<Itinerary> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sortedResults);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            /**
             * This method chooses the itinerary the admin wishes to book for an admin
             * and takes them to the next activity where the admin will choose the client
             * they wish to book it for
             */
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the itinerary that was tapped
                String itinerary = (String) ((TextView) view).getText();

                //get all possible itineraries
                Itinerary itinerarytobebooked = null;
                ItineraryGenerator IG = new ItineraryGenerator(newAdmin.getInfoCentre().allFlights(newAdmin.getInfoCentre().getFlights()));
                ArrayList<Itinerary> results = IG.listAllItineraries(origin, destination, date);

                //find the itinerary that was chosen
                for(Itinerary i: results){
                    if(itinerary.equals(i.toString())){
                        itinerarytobebooked = i;
                    }
                }

                Intent intent = new Intent(view.getContext(), BookItineraryAdmin.class);
                intent.putExtra("UserKey", newAdmin);
                //if the itinerary exists, it is to be booked in the next activity
                if(!(itinerarytobebooked == null)){
                    intent.putExtra("ItineraryKey", itinerarytobebooked);
                }
                else{
                    Toast.makeText(DisplayItineraries.this, "This Itinerary is not in the Infocentre!", Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);

            }
        });
    }

    /**
     * This method takes the admin back to the AdminHome
     * @param View view the view for this method
     */
    public void goBack(View view){
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
        Intent intent2 = new Intent(view.getContext(), AdminHome.class);
        intent2.putExtra("UserKey", newAdmin);
        startActivity(intent2);
    }

}