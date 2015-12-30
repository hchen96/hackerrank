package group_0739.piii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchItineraries extends AppCompatActivity {


    private RadioButton radioButton;
    private RadioGroup radioGroup;

    private Button btnClick;


    /**
     * This method sets up the screen for the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itineraries);
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

        //get admin for admin access rights
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");


        //define radio buttons for search filter
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup2);


        //button to keep track of when clicked
        btnClick = (Button) findViewById(R.id.searchItineraries) ;
        btnClick.setOnClickListener(new View.OnClickListener() {

            /**
             * This method searches for itineraries accoring to the search fields
             * given by the admin
             */
            @Override
            public void onClick(View v) {
                //get the search fields from the edit view texts
                EditText enterOrigin= (EditText) findViewById(R.id.origin);
                final String origin = enterOrigin.getText().toString();
                EditText enterDestination = (EditText) findViewById(R.id.destination);
                final String destination = enterDestination.getText().toString();
                EditText enterDate = (EditText) findViewById(R.id.departureDate);
                final String date = enterDate.getText().toString();

                //check for valid inputs
                if(!origin.equals("") && !destination.equals("") && !date.equals("")){

                    //find the itineraries
                    ItineraryGenerator IG = new ItineraryGenerator(newAdmin.getInfoCentre().allFlights(newAdmin.getInfoCentre().getFlights()));
                    ArrayList<Itinerary> results = IG.listAllItineraries(origin, destination, date);

                    //sort according to search filter
                    int radioId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(radioId);
                    ArrayList<Itinerary> sortedresult = newAdmin.displaySortedItineraries(results, (String) radioButton.getText().toString());

                    //go to the DisplayItineraries Activity
                    Intent intent = new Intent(v.getContext(), DisplayItineraries.class);
                    intent.putExtra("UserKey", newAdmin);
                    intent.putExtra("ItineraryKey", sortedresult);
                    intent.putExtra("OriginKey", origin);
                    intent.putExtra("DestinationKey", destination);
                    intent.putExtra("DepartureKey", date);
                    startActivity(intent);
                }
                //for improper input
                else{
                    Toast.makeText(SearchItineraries.this, "Please input all field", Toast.LENGTH_SHORT).show();
                }
            }






        });

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