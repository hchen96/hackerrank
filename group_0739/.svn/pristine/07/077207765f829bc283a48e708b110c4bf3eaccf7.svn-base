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
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookItineraryAdmin extends AppCompatActivity {

    private ListView lv;

    /**
     * This method sets up the screen for this activity; it displays a list of clients
     * so that the admin can choose who to book the previously selected itinerary for.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_itinerary_admin);
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

        //get the admin for their admin access rights and the itinerary that was selected in the previous itinerary
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
        final Itinerary itineraryToBeBooked = (Itinerary) intent.getSerializableExtra("ItineraryKey");

        //put all the clients in a list view format and check what is being tapped
        lv = (ListView) findViewById(R.id.clients);
        ArrayAdapter<Client> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, newAdmin.getInfoCentre().getClients());
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * This method books the itinerary for the client that was tapped.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get string info of who was tapped
                String client = (String) ((TextView) view).getText();
                String[] clientParts = client.split(",");
                Client clientToChange = null;
                String cEmail = clientParts[2];

                //find the client in the infocentre according to email
                for (Client c : newAdmin.getInfoCentre().getClients()) {
                    if (c.getEmail().equals(cEmail)) {
                        clientToChange = c;
                    }
                }

                //book the itinerary for them
                clientToChange.bookItinerary(itineraryToBeBooked);

                //save the state of the infocentre
                try{
                    File appdir = view.getContext().getFilesDir();

                    File savedInfoCentre = new File(appdir, "Infocentre.ser");
                    FileOutputStream fos = new FileOutputStream(savedInfoCentre.toString());
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(newAdmin.getInfoCentre());
                    os.close();
                    fos.close();
                } catch(FileNotFoundException e){

                }catch(IOException e2){

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