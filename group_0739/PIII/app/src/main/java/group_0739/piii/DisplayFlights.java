package group_0739.piii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayFlights extends AppCompatActivity {

    private ListView lv;

    /**
     * This method sets up the screen for this activity; it displays all the flights
     * to the user.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_flights);
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

        //get all the flights in the infocentre
        Intent intent = getIntent();
        ArrayList<Flight> flights = (ArrayList<Flight>) intent.getSerializableExtra("FlightKey");

        //put all the flights into a list view format
        lv = (ListView) findViewById(R.id.flights);
        ArrayAdapter<Flight> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, flights);
        lv.setAdapter(arrayAdapter);
    }

    /**
     * This method takes the user back to their home
     * @param View view
     */
    public void goBack(View view) {
        Intent intent = getIntent();
        final String type = (String) intent.getSerializableExtra("TypeKey");

        //if user is admin go to AdminHome
        if (type.equals("admin")) {
            final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
            Intent intent2 = new Intent(view.getContext(), AdminHome.class);
            intent2.putExtra("UserKey", newAdmin);
            startActivity(intent2);
        }

        //otherwise go to ClientHome
        else {
            final Client newClient = (Client) intent.getSerializableExtra("UserKey");
            Intent intent2 = new Intent(view.getContext(), ClientHome.class);
            intent2.putExtra("UserKey", newClient);
            startActivity(intent2);
        }
    }

}