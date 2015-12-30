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

public class ViewClient extends AppCompatActivity {

    private ListView lv;

    /**
     * This method sets up the screen for this activity; it displays
     * all of the clients in the Infocentre to the user. 
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_client);
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

        //get the admin in order to get admin access rights into the InfoCentre
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");

        //get all of the existing clients and then format them into a list view
        lv = (ListView) findViewById(R.id.allClients);
        ArrayList<Client> allClients = newAdmin.getInfoCentre().getClients();
        ArrayAdapter<Client> arrayAdapter = new ArrayAdapter<Client>(this, android.R.layout.simple_list_item_1, allClients);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * This method allows the admin to choose which client they wish to see the booked
             * itineraries of.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the client's info in String
                String client = (String) ((TextView) view).getText();
                String[] clientParts = client.split(",");

                Client clientToView = null;

                //find the client that was chosen according to their email
                String cEmail = clientParts[2];
                for (Client c : newAdmin.getInfoCentre().getClients()) {
                    if (c.getEmail().equals(cEmail)) {
                        clientToView = c;
                    }
                }

                //go the BookedItinerary Activity for the chosen client
                Intent intent = new Intent(view.getContext(), BookedItineraries.class);
                intent.putExtra("ClientKey", clientToView);
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