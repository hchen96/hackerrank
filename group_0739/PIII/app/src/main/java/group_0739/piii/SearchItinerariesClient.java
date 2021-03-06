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

public class SearchItinerariesClient extends AppCompatActivity {

    private RadioButton radioButton;
    private Button btnClick;
    private RadioGroup radioGroup;

    /**
     * This function sets up the screen for the actvity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itineraries_client);
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
        final Client newClient = (Client) intent.getSerializableExtra("UserKey");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup2);



        btnClick = (Button) findViewById(R.id.searchItineraries) ;
        btnClick.setOnClickListener(new View.OnClickListener() {

            /**
             * This function searches for possible itineraries according to the users
             * desired origin, destination, departure date and search filter
             *
             * @param View v the view for this method
             */
            @Override
            public void onClick(View v) {
                //origin of itirenary
                EditText enterOrigin= (EditText) findViewById(R.id.origin);
                final String origin = enterOrigin.getText().toString();

                //destination for itinerary
                EditText enterDestination = (EditText) findViewById(R.id.destination);
                final String destination = enterDestination.getText().toString();

                //departure date for itinerary
                EditText enterDate = (EditText) findViewById(R.id.departureDate);
                final String date = enterDate.getText().toString();

                //when valid input is given let the itinerary generator create all possible itineraries and then go to the next activity
                if(!origin.equals("") && !destination.equals("") && !date.equals("")){
                    //create all possible itineraries
                    ItineraryGenerator IG = new ItineraryGenerator(newClient.getInfoCentre().allFlights(newClient.getInfoCentre().getFlights()));
                    ArrayList<Itinerary> results = IG.listAllItineraries(origin, destination, date);

                    //get search filter and sort the itineraries
                    int radioId = radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(radioId);
                    ArrayList<Itinerary> sortedresult = newClient.displaySortedItineraries(results, radioButton.getText().toString());
                    
                    /*go to the next activity with the sorted itineraries as well as the user typre, origin
                     * destination and departure date
                     */
                    Intent intent = new Intent(v.getContext(), DisplayItinerariesClient.class);
                    intent.putExtra("UserKey", newClient);
                    intent.putExtra("ItineraryKey", sortedresult);
                    intent.putExtra("OriginKey", origin);
                    intent.putExtra("DestinationKey", destination);
                    intent.putExtra("DepartureKey", date);
                    startActivity(intent);
                }
                //notify user if wrong input is given
                else{
                    Toast.makeText(SearchItinerariesClient.this, "Please input all field", Toast.LENGTH_SHORT).show();
                }
            }






        });

    }

    /**
     * This method sends the client back to ClientHome
     * @param View view the view for this method
     */
    public void goBack(View view){
        //go back to the ClientHome Activity
        Intent intent = getIntent();
        final Client newClient = (Client) intent.getSerializableExtra("UserKey");
        Intent intent2 = new Intent(view.getContext(), ClientHome.class);
        intent2.putExtra("UserKey", newClient);
        startActivity(intent2);
    }

}