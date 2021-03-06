package group_0739.piii;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    public static final String APPDATA = "appdata";
    public static final String FILENAME = "Infocentre.ser"; //filename for file that Infocentre is serialized
    Infocentre infoCentre; //the Infocentre of the app

    /**
     * This method sets up the log in screen and uploads data from the apps previous run.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        //get the file that the infocentre is saved in
        File appdir = this.getApplicationContext().getFilesDir();
        File savedInfoCentre = new File(appdir, FILENAME);
        System.out.println(savedInfoCentre.toString());

        //check if the file exists
        if(!savedInfoCentre.exists()){
            //when the file does not exist, create a new Infocentre and create the file and then save the InfoCentre
            try {
                infoCentre = new Infocentre();
                //savedInfoCentre = this.getApplicationContext().getDir(appdir.toString()+"/Info_Centre.ser", Context.MODE_PRIVATE);
                FileOutputStream fos = new FileOutputStream(savedInfoCentre.toString());
                ObjectOutputStream os = new ObjectOutputStream(fos);
                os.writeObject(infoCentre);
                os.close();
                fos.close();
            }catch(FileNotFoundException e){

            }
            catch(IOException e2){
            }

        }

        //when the file exists
        else{
            try {
                //open the file and write it's contents to the Infocentre
                FileInputStream fis =new FileInputStream(savedInfoCentre.toString());
                ObjectInputStream ois = new ObjectInputStream(fis);
                infoCentre = (Infocentre) ois.readObject();

                fis.close();
                ois.close();
            }catch(FileNotFoundException e){

            }
            catch(IOException e2) {
            }
            catch(ClassNotFoundException e3){

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This method takes the inputted username(email) and password
     * and redirects them to either AdminHome or ClientHome depending 
     * on what type of user they are.
     *
     * @param View view the view for this method
     */
    public void login(View view) throws IOException{
        //get the valid passwords from passwords.txt
        File appdir = this.getApplicationContext().getFilesDir();
        File passwords = new File(appdir,"passwords.txt");

        Scanner sc = new Scanner(passwords);

        List<String> validAdminPasswords = new ArrayList<String>();
        List<String> validClientPasswords = new ArrayList<String>();

        //go through passwords.txt and determine the valid admin and client passwords
        while(sc.hasNext()){
            String newLine = sc.nextLine();
            String[] typePlusPassword = newLine.split(",");
            //determine what user type the password belongs to and add it to the correct list of valid passwords
            if(typePlusPassword[0].equals("Admin") && !validAdminPasswords.contains(typePlusPassword[1])){
                validAdminPasswords.add(typePlusPassword[1]);
            }
            else if(typePlusPassword[0].equals("Client")&& !validClientPasswords.contains(typePlusPassword[1])){
                validClientPasswords.add(typePlusPassword[1]);
            }
        }

        sc.close();

        //get the inputted user name
        EditText enterUsername = (EditText) findViewById(R.id.enterUsername);
        String username = enterUsername.getText().toString();

        //get the inputted password
        EditText enterPassword = (EditText) findViewById(R.id.enterPassword);
        String password = enterPassword.getText().toString();

        //check if the password is an admin password
        for(String p: validAdminPasswords){
            //when the password is an admins, check if the admin exists
            if(password.equals(p)){

                Admin newAdmin = null;

                //check if the admin exists, if they do reference them
                for(Admin admin: infoCentre.getAdmins()){
                    if(admin.getEmail().equals(username)){
                        newAdmin = admin;
                    }


                }
                //if the client does not exist, create a new one
                if(newAdmin == null) {
                    newAdmin = new Admin("", "", infoCentre, username);

                    //save the state of the Infocentre when after a new admin is created
                    File savedInfoCentre = new File(appdir, "Infocentre.ser");
                    FileOutputStream fos = new FileOutputStream(savedInfoCentre.toString());
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(newAdmin.getInfoCentre());
                    os.close();
                    fos.close();
                }

                //take the admin to their AdminHome Activity
                Intent intent = new Intent(this, AdminHome.class);
                intent.putExtra("UserKey", newAdmin);
                startActivity(intent);

            }
        }

        //check if the password is a client's password
        for(String p: validClientPasswords){
            //when the password is valid, check if the client exists or not
            if(password.equals(p)){
                Client newClient = null;

                //check of client; if they exist reference them
                for (Client client : infoCentre.getClients()) {
                    if (client.getEmail().equals(username)) {
                        newClient = client;
                    }
                }

                //when client does not exist
                if(newClient == null){
                    //create a new client
                    newClient = new Client("","",infoCentre,username,"",0,"");

                    //save the state of the Infocentre when after a new client is created
                    File savedInfoCentre = new File(appdir, "Infocentre.ser");
                    FileOutputStream fos = new FileOutputStream(savedInfoCentre.toString());
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(newClient.getInfoCentre());
                    os.close();
                    fos.close();
                }

                //take the client to thei ClientHome Activity
                Intent intent = new Intent(this, ClientHome.class);
                intent.putExtra("UserKey", newClient);
                startActivity(intent);

            }
        }


    }


}