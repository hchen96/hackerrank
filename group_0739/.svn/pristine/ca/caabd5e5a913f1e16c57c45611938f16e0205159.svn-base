package group_0739.piii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EditPersonalInfo extends AppCompatActivity {

    /**
     * This method sets up the screen for this activity; it puts the current client info
     * into the appropriate edit text views for the client to make changes to.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_info);
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

        //get the client to access their info
        Intent intent = getIntent();
        final Client newClient = (Client) intent.getSerializableExtra("UserKey");

        //get the edit text views used in this acitivity
        EditText editFirstName = (EditText) findViewById(R.id.editFirstName);
        EditText editLastName = (EditText) findViewById(R.id.editLastName);
        EditText editEmail = (EditText) findViewById(R.id.editEmail);
        EditText editAddress = (EditText) findViewById(R.id.editAddress);
        EditText editCreditCardNumber = (EditText) findViewById(R.id.editCreditCardNumber);
        EditText editExpiryDate = (EditText) findViewById(R.id.editExpiryDate);


        //put all of the client's info into the respective edit text views in the activity
        editFirstName.setText(newClient.getFirstName());
        editLastName.setText(newClient.getLastName());
        editEmail.setText(newClient.getEmail());
        editAddress.setText(newClient.getAddress());
        String creditCardNumber = Long.toString(newClient.getCreditCardNumber());
        editCreditCardNumber.setText(creditCardNumber);
        editExpiryDate.setText(newClient.getExpiryDate());

    }

    /**
     * This method changes the client's info to the new desired values as inputted
     * by the client.
     *
     * @param View view the view for this method
     */
    public void editClientInfo(View view) throws InvalidInputException,IOException {
        //get the client whose info is being changed
        Intent intent = getIntent();
        final Client newClient= (Client) intent.getSerializableExtra("UserKey");

        //get the edit text views in this activity
        EditText editFirstName = (EditText) findViewById(R.id.editFirstName);
        EditText editLastName = (EditText) findViewById(R.id.editLastName);
        EditText editEmail = (EditText) findViewById(R.id.editEmail);
        EditText editAddress = (EditText) findViewById(R.id.editAddress);
        EditText editCreditCardNumber = (EditText) findViewById(R.id.editCreditCardNumber);
        EditText editExpiryDate = (EditText) findViewById(R.id.editExpiryDate);

        //change the client's info to what is in edit text fields
        newClient.setFirstName(editFirstName.getText().toString());
        newClient.setLastName(editLastName.getText().toString());
        newClient.setEmail(editEmail.getText().toString());
        newClient.setAddress(editAddress.getText().toString());
        newClient.setCreditCardNumber(Long.parseLong(editCreditCardNumber.getText().toString()));
        newClient.setExpiryDate(editExpiryDate.getText().toString());

        //save the state of the Infocentre after the changes are made
        File appdir = this.getApplicationContext().getFilesDir();
        File savedInfoCentre = new File(appdir, "Infocentre.ser");
        FileOutputStream fos = new FileOutputStream(savedInfoCentre.toString());
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(newClient.getInfoCentre());
        os.close();
        fos.close();

        //return to the ClientHome
        Intent intent2 = new Intent(this, ClientHome.class);
        intent2.putExtra("UserKey", newClient);
        startActivity(intent2);

    }

    /**
     * This method returns the client back to their client home
     */
    public void goBack(View view){
        //go to the ClientHome Activity
        Intent intent = getIntent();
        final Client newClient = (Client) intent.getSerializableExtra("UserKey");
        Intent intent2 = new Intent(view.getContext(), ClientHome.class);
        intent2.putExtra("UserKey", newClient);
        startActivity(intent2);
    }

}