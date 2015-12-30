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

public class DisplayAnyClientProfile extends AppCompatActivity {

    private ListView lv;

    /**
     * This method sets up the screen for this activity; it display all of the clients
     * in Infocentre to the Admin.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_any_client_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get the admin for admin rights to Infocentre
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");

        //get all of the clients and put them in a list view format
        lv = (ListView) findViewById(R.id.allClients);
        ArrayList<Client> allClients = newAdmin.getInfoCentre().getClients();
        ArrayAdapter<Client> arrayAdapter = new ArrayAdapter<Client>(this, android.R.layout.simple_list_item_1, allClients);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * This method redirects the Admin to the EditClient Acitivity for the
             * Client they tapped on
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get client info as string
                String client = (String) ((TextView) view).getText();
                String[] clientParts = client.split(",");
                Client clientToChange = null;
                String cEmail = clientParts[2];

                //find the corresponding client in the infocentre according to email
                for (Client c : newAdmin.getInfoCentre().getClients()) {
                    if (c.getEmail().equals(cEmail)) {
                        clientToChange = c;
                    }
                }

                //take the Admin to EditClientInfo Activity for the chosen client
                Intent intent = new Intent(view.getContext(), EditClientInfo.class);
                intent.putExtra("ClientKey", clientToChange);
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
        Intent intent = getIntent();
        final Admin newAdmin = (Admin) intent.getSerializableExtra("UserKey");
        Intent intent2 = new Intent(view.getContext(), AdminHome.class);
        intent2.putExtra("UserKey", newAdmin);
        startActivity(intent2);
    }

}