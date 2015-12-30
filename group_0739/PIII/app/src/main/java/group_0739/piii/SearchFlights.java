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
import android.widget.Toast;

import java.util.ArrayList;

public class SearchFlights extends AppCompatActivity {

    private Button btnClick;

    /**
     * This method sets up the screen for the activity; it chooses the button
     * to keep track of for onClick().
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flights);
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

        //get the user
        Intent intent = getIntent();
        final User newUser = (User) intent.getSerializableExtra("UserKey");

        //keep track of the button being clicked
        btnClick = (Button) findViewById(R.id.searchItineraries) ;
        btnClick.setOnClickListener(new View.OnClickListener() {

            /**
             * This method searches for the flights given search parameters by
             * user when button is clicked.
             */
            @Override
            public void onClick(View v) {
                //get the type of user
                Intent intent = getIntent();
                final String type = (String) intent.getSerializableExtra("TypeKey");

                //get the search parameters from the edit text views
                EditText enterOrigin= (EditText) findViewById(R.id.origin);
                final String origin = enterOrigin.getText().toString();
                EditText enterDestination = (EditText) findViewById(R.id.destination);
                final String destination = enterDestination.getText().toString();
                EditText enterDate = (EditText) findViewById(R.id.departureDate);
                final String date = enterDate.getText().toString();

                //check for valid input
                if(!origin.equals("") && !destination.equals("") && !date.equals("")){
                    //search for corresponding flights
                    ArrayList<Flight> results = newUser.searchFlights(date, origin, destination);

                    //for both types of users go to DisplayFlights activity(but keep track of what type of accoun the user is)
                    if(type.equals("admin")){
                        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
                        Intent intent2 = new Intent(v.getContext(), DisplayFlights.class);
                        intent2.putExtra("UserKey", newAdmin);
                        intent2.putExtra("FlightKey", results);
                        intent2.putExtra("TypeKey", type);
                        startActivity(intent2);
                    }
                    else{
                        final Client newClient = (Client) intent.getSerializableExtra("UserKey");
                        Intent intent2 = new Intent(v.getContext(), DisplayFlights.class);
                        intent2.putExtra("UserKey", newClient);
                        intent2.putExtra("FlightKey", results);
                        intent2.putExtra("TypeKey", type);
                        startActivity(intent2);
                    }


                }
                //invalid input
                else{
                    Toast.makeText(SearchFlights.this, "Please input all field", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    /**
     * This method returns the user back to their home
     * @param View view the view for this method
     */
    public void goBack(View view){
        //check type of user
        Intent intent = getIntent();
        final String type = (String) intent.getSerializableExtra("TypeKey");

        //if admin go to admin home
        if(type.equals("admin")){
            final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
            Intent intent2 = new Intent(view.getContext(), AdminHome.class);
            intent2.putExtra("UserKey", newAdmin);
            startActivity(intent2);
        }

        //otherwise go to ClientHome
        else{
            final Client newClient = (Client) intent.getSerializableExtra("UserKey");
            Intent intent2 = new Intent(view.getContext(), ClientHome.class);
            intent2.putExtra("UserKey", newClient);
            startActivity(intent2);
        }


    }

}