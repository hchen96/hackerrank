package group_0739.piii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EditFlight extends AppCompatActivity {


    private ArrayList<Flight> allFlightsToChange = new ArrayList<Flight>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_flight);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        Intent intent = getIntent();
        final Flight f = (Flight) intent.getSerializableExtra("FlightKey");

        EditText fNumberHint = (EditText) findViewById(R.id.flightNumberHint);
        EditText arrivalDateTimeHint = (EditText) findViewById(R.id.arrivalDateTimeHint);
        EditText departureDateTimeHint = (EditText) findViewById(R.id.departureDateTimeHint);
        EditText airlineHint = (EditText) findViewById(R.id.airlineHint);
        EditText originHint = (EditText) findViewById(R.id.originHint);
        EditText destinationHint = (EditText) findViewById(R.id.destinationHint);
        EditText costHint = (EditText) findViewById(R.id.costHint);
        EditText numSeatsHint = (EditText) findViewById(R.id.numSeatsHint);

        String flightNumber =  Integer.toString(f.getFlightNumber());
        fNumberHint.setText(flightNumber);
        arrivalDateTimeHint.setText(f.getArrivalDateTimeAsStr());
        departureDateTimeHint.setText(f.getDepartureDateTimeAsStr());
        airlineHint.setText(f.getAirline());
        originHint.setText(f.getOrigin());
        destinationHint.setText(f.getDestination());
        costHint.setText(String.valueOf(f.getCost()));
        String numSeats =  Integer.toString(f.getNumSeats());
        numSeatsHint.setText(numSeats);

        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
        Flight f1 = (Flight) intent.getSerializableExtra("FlightKey");
        for(Client current : newAdmin.getInfoCentre().getClients()){
            for(Itinerary i : current.getBookedItineraries()){
                for(Flight f2 : i.getFlights()){
                    if(f2.equals(f1)){
                        allFlightsToChange.add(f2);
                    }
                }
            }
        }


    }

    public void editFlightInfo(View view) throws InvalidInputException,IOException{
        Intent intent = getIntent();
        Flight f = (Flight) intent.getSerializableExtra("FlightKey");
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");

        EditText fNumberHint = (EditText) findViewById(R.id.flightNumberHint);
        EditText arrivalDateTimeHint = (EditText) findViewById(R.id.arrivalDateTimeHint);
        EditText departureDateTimeHint = (EditText) findViewById(R.id.departureDateTimeHint);
        EditText airlineHint = (EditText) findViewById(R.id.airlineHint);
        EditText originHint = (EditText) findViewById(R.id.originHint);
        EditText destinationHint = (EditText) findViewById(R.id.destinationHint);
        EditText costHint = (EditText) findViewById(R.id.costHint);
        EditText numSeatsHint = (EditText) findViewById(R.id.numSeatsHint);

        for(Flight flight: newAdmin.getInfoCentre().allFlights(newAdmin.getInfoCentre().getFlights())){
            if(f.equals(flight)){
                flight.setFlightNumber(Integer.parseInt(fNumberHint.getText().toString()));
                flight.setArrivalDateTime(arrivalDateTimeHint.getText().toString());
                flight.setDepartureDateTime(departureDateTimeHint.getText().toString());
                flight.setAirline(airlineHint.getText().toString());
                flight.setOrigin(originHint.getText().toString());
                flight.setDestination(destinationHint.getText().toString());
                flight.setCost(Double.parseDouble(costHint.getText().toString()));
                flight.setNumSeats(Integer.parseInt(numSeatsHint.getText().toString()));
            }
        }

        for(Flight flight : allFlightsToChange){
            flight.setFlightNumber(Integer.parseInt(fNumberHint.getText().toString()));
            flight.setArrivalDateTime(arrivalDateTimeHint.getText().toString());
            flight.setDepartureDateTime(departureDateTimeHint.getText().toString());
            flight.setAirline(airlineHint.getText().toString());
            flight.setOrigin(originHint.getText().toString());
            flight.setDestination(destinationHint.getText().toString());
            flight.setCost(Double.parseDouble(costHint.getText().toString()));
            flight.setNumSeats(Integer.parseInt(numSeatsHint.getText().toString()));
        }
        File appdir = this.getApplicationContext().getFilesDir();

        File savedInfoCentre = new File(appdir, "Infocentre.ser");
        FileOutputStream fos = new FileOutputStream(savedInfoCentre.toString());
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(newAdmin.getInfoCentre());
        os.close();
        fos.close();


        Intent intent2 = new Intent(this, ViewFlights.class);
        intent2.putExtra("UserKey", newAdmin);
        startActivity(intent2);
    }

    public void goBack(View view){
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
        Intent intent2 = new Intent(view.getContext(), AdminHome.class);
        intent2.putExtra("UserKey", newAdmin);
        startActivity(intent2);
    }

}