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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class ClientHome extends AppCompatActivity {

    private ListView lv;

    /**
     * This method sets up the screen for this activity; it displays all of the things
     * tha the Client can do and redirects them to the approriate screen when they are tapped.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home);
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

        //get the client
        Intent intent = getIntent();
        final Client newClient = (Client)
                intent.getSerializableExtra("UserKey");

        //put all of the activities available to the client in a list view
        lv = (ListView) findViewById(R.id.allAdminOptions);

        final ArrayList<String> allOptionsA = new ArrayList<>();
        allOptionsA.add("SearchItineraries");
        allOptionsA.add("ViewBookedItineraries");
        allOptionsA.add("SearchFlights");
        allOptionsA.add("EditPersonalInfo");

        //check for what gets clicked in the list view
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allOptionsA);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * This method redirects the client to a specified acitivity according to
             * what they tapped on.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //check what they tapped on
                String option = (String) ((TextView) view).getText();

                //go to an appropriate Activity depending on what they tapped on
                if (option.equals("SearchItineraries")) {
                    Intent intent1 = new Intent(view.getContext(), SearchItinerariesClient.class);
                    intent1.putExtra("UserKey", newClient);
                    startActivity(intent1);
                } else if (option.equals("ViewBookedItineraries")) {
                    Intent intent2 = new Intent(view.getContext(),
                            ViewBookedItineraries.class);
                    intent2.putExtra("UserKey", newClient);
                    startActivity(intent2);
                }else if (option.equals("SearchFlights")) {
                    Intent intent3 = new Intent(view.getContext(),
                            SearchFlights.class);
                    intent3.putExtra("UserKey", newClient);
                    intent3.putExtra("TypeKey", "client");
                    startActivity(intent3);
                }else if (option.equals("EditPersonalInfo")) {
                    Intent intent4 = new Intent(view.getContext(),
                            EditPersonalInfo.class);
                    intent4.putExtra("UserKey", newClient);
                    startActivity(intent4);
                }
            }
        });


    }

}