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

import java.util.ArrayList;

public class ViewFlights extends AppCompatActivity {

    private ListView lv;

    /**
     * This method sets up the screen for this activity; it displays all
     * of the flights in the Infocentre.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flights);
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

        setTitle("Click on a flight to edit");

        //get the admin for admin access rights for the Infocentre
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");

        //get all the flights from the infocentre and format them into a list view
        lv = (ListView) findViewById(R.id.allFlights);
        ArrayList<Flight> allFlights = newAdmin.getInfoCentre().allFlights(newAdmin.getInfoCentre().getFlights());
        ArrayAdapter<Flight> arrayAdapter = new ArrayAdapter<Flight>(this, android.R.layout.simple_list_item_1, allFlights);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * This method takes the admin to the EditFlight Activity for the flight
             * that they tap on.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the flight's info in string format
                String flight = (String)((TextView) view).getText();
                String[] flightParts = flight.split(",");

                Flight flightToChange = null;
                //find the flight with the corresponding flight number from the text info
                int fNumber = Integer.parseInt(flightParts[0]);
                for (Flight f: newAdmin.getInfoCentre().allFlights(newAdmin.getInfoCentre().getFlights())){
                    if(f.getFlightNumber() == fNumber){
                        flightToChange = f;
                    }
                }

                //go to the EditFlight Activity for the flight that was chosen
                Intent intent = new Intent(view.getContext(),EditFlight.class);
                intent.putExtra("FlightKey", flightToChange);
                intent.putExtra("UserKey", newAdmin);
                startActivity(intent);
            }
        });


    }

    /**
     * This method returns the admin back to the AdminHome
     * @param View view the view for this method
     */
    public void goBack(View view){
        //go back to the AdminHome Activity
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
        Intent intent2 = new Intent(view.getContext(), AdminHome.class);
        intent2.putExtra("UserKey", newAdmin);
        startActivity(intent2);
    }



}