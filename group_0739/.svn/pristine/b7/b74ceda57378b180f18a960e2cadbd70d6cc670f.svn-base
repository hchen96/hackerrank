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

public class ViewBookedItineraries extends AppCompatActivity {

    private ListView lv;

    /**
     * This method creates the screen for this activity; it displays the booked
     * itineraries for a client.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booked_itineraries);
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

        //get the client's info
        Intent intent = getIntent();
        Client newClient = (Client) intent.getSerializableExtra("UserKey");

        //format the booked itineraries of the client into a listview
        ArrayList<Itinerary> bookedItineraries = newClient.getBookedItineraries();
        lv = (ListView) findViewById(R.id.bookedItineraries);
        ArrayAdapter<Itinerary> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookedItineraries);
        lv.setAdapter(arrayAdapter);
    }

    /**
     * This method sends the client back to ClientHome
     * @param View view the view for this method
     */
    public void goBack(View view){
        Intent intent = getIntent();
        final Client newClient = (Client) intent.getSerializableExtra("UserKey");
        Intent intent2 = new Intent(view.getContext(), ClientHome.class);
        intent2.putExtra("UserKey", newClient);
        startActivity(intent2);
    }

}