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

public class AdminHome extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
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

        Intent intent = getIntent();
        final Admin newAdmin = (Admin)
                intent.getSerializableExtra("UserKey");

        lv = (ListView) findViewById(R.id.allAdminOptions);

        final ArrayList<String> allAdminOptions = new ArrayList<>();
        allAdminOptions.add("DisplayAnyClientProfile");
        allAdminOptions.add("ClientBookedItineraries");
        allAdminOptions.add("SearchItineraries");
        allAdminOptions.add("EditFlight");
        allAdminOptions.add("Upload Flights");
        allAdminOptions.add("SearchFlights");
        allAdminOptions.add("Upload Clients");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allAdminOptions);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option = (String) ((TextView) view).getText();
                //pseudo code for each client option
                if (option.equals("DisplayAnyClientProfile")) {
                    Intent intent1 = new Intent(view.getContext(), DisplayAnyClientProfile.class);
                    intent1.putExtra("UserKey", newAdmin);
                    startActivity(intent1);
                } else if (option.equals("ClientBookedItineraries")) {
                    Intent intent2 = new Intent(view.getContext(),
                            ViewClient.class);
                    intent2.putExtra("UserKey", newAdmin);
                    startActivity(intent2);
                }else if (option.equals("SearchItineraries")) {
                    Intent intent3 = new Intent(view.getContext(),
                            SearchItineraries.class);
                    intent3.putExtra("UserKey", newAdmin);
                    startActivity(intent3);
                }else if (option.equals("EditFlight")) {
                    Intent intent4 = new Intent(view.getContext(),
                            ViewFlights.class);
                    intent4.putExtra("UserKey", newAdmin);
                    startActivity(intent4);
                } else if (option.equals("Upload Flights")){
                    Intent intent5 = new Intent(view.getContext(),
                            UploadFlights.class);
                    intent5.putExtra("UserKey", newAdmin);
                    startActivity(intent5);
                }else if(option.equals("SearchFlights")){
                    Intent intent6 = new Intent(view.getContext(),
                            SearchFlights.class);
                    intent6.putExtra("UserKey", newAdmin);
                    intent6.putExtra("TypeKey", "admin");
                    startActivity(intent6);
                }
                else if (option.equals("Upload Clients")){
                    Intent intent7 = new Intent(view.getContext(),
                            UploadClients.class);
                    intent7.putExtra("UserKey", newAdmin);
                    startActivity(intent7);
                }

            }
        });



    }

}