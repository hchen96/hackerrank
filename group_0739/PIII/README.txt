ReadMe:
Preface:
  Before logging in, user should push "passwords.txt" into the data/data/group_0739.piii/files/ directory in the device monitor of Android studio, if it is not already there.
  On further note, the format for any new "passwords.txt" should be: "UserType(Admin or Client),password" for every line. Also please use the formats for the activities outlined
  in this README when using the app.

Main Activity (Login Screen):
  1. Tap on the user edit text view and type in the account"s email(make sure to type in proper format of *******@*****.com)
  2. Tap on the password edit text view and type in a valid password that is in either clients.txt or admins.txt
  3. Tap on the log in button to access the account; the action will result in one of three possible actions:
    a. If password exists in admins.txt then one of two things will exist:
      i. If the account exists, the app will continue on to the AdminHome Activity
      ii. If the account does not exist, the app will create a new admin account and then move on to the AdminHome activity
    b. If password exists in clients.txt then one of two things will exist:
      i. If the account exists, the app will continue on to the ClientHome Activity
      ii. If the account does not exist, the app will create a new client account that will need to have its personal info added a later time in the EditClient Activity and then move on to the ClientHome activity
    c. If the password is not in admins.txt or clients.txt, the app will remain on the Main Activity
AdminHome Activity (Admin Access Only):
  1. Tap on "DisplayAnyClientProfile" in the list view to go to the DisplayAnyClientProfile Activity which shows the info of every client in a list view
  2. Tap on "ClientBookedItineraries" in the list view to go to the ViewClient Activity which shows all of the clients in the list view
  3. Tap on "SearchItineraries" in the list view to go to the SearchItineraries Activity in which it will ask the user for departure date, travel origin and destination , and search filter as input for the next Activity
  4. Tap on "EditFlight" in the list view to go to the ViewFlights Activity which shows all the flights and their information in a list view
  5. Tap on "Upload Clients" to go to the UploadClients Activity.
  6. Tap on "Upload Flights" to go to the UploadFlights Activity.
  7. Tap on "SearchFlights" to go to the SearchFlights Activity in which it will ask the user for departure date, travel origin and destination as input for the next Activity

DisplayAnyClientProfile Activity (Admin Access Only):
  1. Tap on any of the clients in the list view to go to the EditClientInfo Activity, for that client, which shows the current client information in edit text views
     EditClientInfo/EditPersonalInfo Activity (Admin and Client Access):
  1. Tap on the "first name" edit text view to type in new desired first name (No Format)
  2. Tap on the "last name" edit text view to type in new desired last name (No Format)
  3. Tap on the "email" edit text view to type in new desired email (Format: *****@*****.com)
  4. Tap on the "credit card number" edit text view to type in new desired credit card number  (Format: numbers only)
  5. Tap on "expiry date" edit text view to type in new desired expiry date(Format: YYYY-MM-DD)
  6. Tap on the "address" edit text view to type in new desired address (No Format)
  7. Tap on the "Apply Changes" button to save any changes made to the client"s info; app will then be redirected to the previous activity

ViewClient Activity (Admin Access Only):
  1. Tap on one of the clients in the list view to go to the BookedItineraries Activity for that client.

BookedItineraries Activity (Admin Access Only):
  * No action takes place in this activity; only meant to show the itineraries of the client.

SearchItineraries Activity (Admin and Client Access):
  1. Tap on the "Departure Date" edit text view to type in desired departure date for itineraries (Format: YYYY-MM-DD)
  2. Tap on the "Origin" edit text view to type in desired travel origin (No Format)
  3. Tap on the "Destination" edit text view to type in desired travel destination (No Format)
  4. Tap on either one of the two radio buttons, "Cost" or "Travel Time", to set the desired search filter
  5. Tap on the "Search" button to proceed to the DisplayItineraries Activity if user is admin, or the DisplayItinerariesClient Activity if user is a client, which will show all of the possible itineraries sorted
     according to the search filter in a list view; only do this when all of the previous fields have valid input

DisplayItineraries Activity (Admin):
  1. Tap on any of the itineraries in the list view to go to the BookItineraryAdmin Activity, for that itinerary, which shows all of the clients in a list view (i.e. flights, cost, time etc.)

BookItineraryAdmin Activity (Admin):
  1. Tap on one of the clients to book the itinerary for them. Tap on the "Go Back" button to leave the activity

ViewFlights Activity (Admin and Client Access):
  1. Tapping on any of the flights will have one of two possible results:
          a. If user is an admin, the app will go to the EditFlight Activity for that flight which will show the flights information in edit text views
          b. If user is a client, nothing will happen

EditFlight Activity (Admin Access Only):
  1. Tap on the "Flight Number" edit text field to type in the new desired flight number (Format: Numbers Only)
  2. Tap on the "Departure Date Time" edit text field to type in the new desired departure date time (Format: YYYY-MM-DD HH:MM)
  3. Tap on the "Arrival Date Time" edit text field to type in the new arrival departure date time (Format: YYYY-MM-DD HH:MM)
  4. Tap on the "Airline" edit text field to type in the new Airline (No Format)
  5. Tap on the "Origin" edit text field to type in the new desired travel origin (No Format)
  6. Tap on the "Destination" edit text field to type in the new desired travel destination (No Format)
  7. Tap on the "Price" edit text field to type in the new desired travel price (Format: Numbers Only)
  8. Tap on the "Number of Seats" edit text field to type in the new number of available seats (Format: Numbers Only)
  9. Tap on the "Apply Changes" button to save any changes made to the flight"s info; app will then be redirected to the previous ViewFlights Activity

Upload Flights Activity (Admin Access Only):
  1. Type in the file path to the desired file to upload; you may only choose a file containing flight information. (Format: proper file path. Default is file path
     to app data: "/data/user/0/group_0739.piii/files".)
  2. Tap on the "Upload" button to upload the file and return to the AdminHome Activity.
  SearchFlights Activity (Admin and Client Access):
  1. Tap on the "Departure Date" edit text view to type in desired departure date for the flights (Format: YYYY-MM-DD)
  2. Tap on the "Origin" edit text view to type in desired travel origin (No Format)
  3. Tap on the "Destination" edit text view to type in desired travel destination (No Format)
  4. Tap on the "Search" button to go to the DisplayFlights Activity which shows all the flights that match the given departure date, arrival date, origin and destination

DisplayFlights Activity (Admin and Client Access):
* No actions do anything in this activity, only meant to display the flights the client was looking for

Upload Flights Activity (Admin Access Only):
  1. Type in the file path to the desired file to upload; you may only choose a file containing admin information. (Format: proper file path. Default is file path to app data: "/data/user/0/group_0739.piii/files".)
  2. Tap on the "Upload" button to upload the file and return to the AdminHome Activity.

ClientHome Activity (Client Access Only):
  1. Tap on "SearchItineraries" in the list view to go to the SearchItineraries Activity in which will ask the user for departure date, travel origin and destination , and search filter as input for the next Activity
  2. Tap on "ViewBookedItineraries" in the list view to go the ViewBookedItineraries Activity which shows all the booked itineraries of the user in a list view.
  3. Tap on "SearchFlights" in the list view to go to the SearchFlights Activity in which it will ask the user for departure date, travel origin and destination as input for the next Activity
  4. Tap on "EditPersonalInfo" in the list view to go to the EditClientInfo Activity, for the user themselves, which shows the current client information in edit text views

DisplayItinerariesClient Activity (Client Access Only):
  1. Tap on one of the itineraries to book it for the client.
  2. Tap on the "Go Back" Button to return to the ClientHome Activity

ViewBookedItineraries Activity (Client Access Only):
  * No actions occur in this activity; only meant to show the itineraries of the client.

EditClientInfo Activity (Client Access Only):
  1. Tap on the "First Name" edit text view to type in the new desired first name (No Format).
  2. Tap on the "Last Name" edit text view to type in the new desired last name (No Format).
  3. Tap on the "Email Address" edit text view to type in the new desired email address. (Format: *****@*****.com)
  4. Tap on the "Physical Address" edit text view to type in the new desired home address. (No Format)
  5. Tap on the "Credit Card Number" edit text view to type in the new desired credit card number. (Format: Numbers Only)
  6. Tap on the "Expiry Date" edit text view to type in the new desired expiry date.                   (Format: YYYY-MM-DD)
  7. Tap on the "Apply Changes" button to save all the changes you"ve made and the app will go back the ClientHome Activity.
