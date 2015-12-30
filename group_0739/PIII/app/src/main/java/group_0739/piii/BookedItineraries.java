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

public class BookedItineraries extends AppCompatActivity {

    private ListView lv;

    /**
     * This method sets up the screen for this activity; it displays the booked
     * itineraries of the client to the admin.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_itineraries);
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

        //get the admin for admin access rights and the client for their itineraries
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
        Client clientToView = (Client) intent.getSerializableExtra("ClientKey");

        //put all the client's booked itineraries into a listview format
        ArrayList<Itinerary> bookedItineraries = clientToView.getBookedItineraries();
        lv = (ListView) findViewById(R.id.bookedItineraries);
        ArrayAdapter<Itinerary> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookedItineraries);
        lv.setAdapter(arrayAdapter);
    }

    /**
     * This method returns the admin back to the AdminHome
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