package group_0739.piii;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author group_0739
 *
 *This class represents a user of the system who can view, book, and sort
 *through Itineraries flights.  It is responsible for creating a new
 *client of the program, adding and editing their personal and billing
 *information, keeping track of and updating the itineraries they
 *have booked, and searching for and sorting itineraries.
 */
public class Client extends User implements Serializable {


    private static final long serialVersionUID = -5781197274947316680L;
    /**
     * The client's email.
     */
    private String email;
    /**
     * The client's street address.
     */
    private String address;
    /**
     * The client's credit card number.
     */
    private long creditCardNumber;
    /**
     * The expiry date of the client's credit card number.
     */
    private String expiryDate;
    /**
     * The client's booked itineraries based on his/her preferences.
     */
    private ArrayList<Itinerary> bookedItineraries = new ArrayList<Itinerary>();
    /**
     * The client's characteristic that determines which flights he wants.
     */
    private String filter = "cost";

    /**
     * Constructs a new Client with a first and last name, info centre
     * they belong to, email address and physical address,
     * credit card number and credit card number expiry date.
     *
     * @param first						The Client's first name.
     * @param last						The Client's last name
     * @param infoCentre				The info centre the Client belongs to.
     * @param email						The email address of the Client.
     * @param address					The physical address of the Client.
     * @param creditCardNumber			The credit card number of the Client.
     * @param expiryDate				The date the Client's credit card
     * 									expires in format: YYYY-MM-DD.
     */
    public Client(String first, String last, Infocentre infoCentre,
                  String email, String address, long creditCardNumber,
                  String expiryDate) {
        super(first, last, infoCentre);
        this.getInfoCentre().AddClient(this);

        try{
            if(expiryDate.length() == 10){

                if(expiryDate.charAt(4) == '-' && expiryDate.charAt(7) == '-'){

                    ///parseInt throws an exception if the string is not numeric
                    Integer expiryYear = Integer.parseInt(expiryDate.substring(0, 4));
                    Integer expiryMonth = Integer.parseInt(expiryDate.substring(5, 7));
                    Integer expiryDay = Integer.parseInt(expiryDate.substring(8, 10));


                    if(expiryYear >= 0 && expiryMonth >= 1 && expiryMonth <= 12
                            && expiryDay >= 1 && expiryDay <= 31){

                        //empty if - all input is valid
                    }
                    else{
                        throw new InvalidInputException("Year, "
                                + "Month or Dayare invalid.");
                    }
                }
                else{
                    throw new InvalidInputException("Expiry Date must be in the"
                            + " format: YYYY-MM-DD");
                }
            }
            else{
                throw new InvalidInputException("Expiry Date must be in the"
                        + " format: YYYY-MM-DD");
            }
        } catch(InvalidInputException e){


        }

        this.email = email;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((bookedItineraries == null) ? 0 :
                bookedItineraries.hashCode());
        result = prime * result + (int) (creditCardNumber ^
                (creditCardNumber >>> 32));
        result = prime * result + ((email == null) ? 0 :
                email.hashCode());
        result = prime * result + ((expiryDate == null) ? 0 :
                expiryDate.hashCode());
        result = prime * result + ((filter == null) ? 0 :
                filter.hashCode());
        return result;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (bookedItineraries == null) {
            if (other.bookedItineraries != null)
                return false;
        } else if (!bookedItineraries.equals(other.bookedItineraries))
            return false;
        if (creditCardNumber != other.creditCardNumber)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (expiryDate == null) {
            if (other.expiryDate != null)
                return false;
        } else if (!expiryDate.equals(other.expiryDate))
            return false;
        if (filter == null) {
            if (other.filter != null)
                return false;
        } else if (!filter.equals(other.filter))
            return false;
        return true;
    }


    /**
     * Returns the email of the Client
     *
     * @return	The email address of the Client.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the client.
     *
     * @param email		The Client's new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the physical address of the Client
     *
     * @return		The Client's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the physical address of the Client
     *
     * @param address	The Client's new address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the Client's credit card number.
     *
     * @return	The Client's credit card number.
     */
    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Sets the Client's credit card number.
     *
     * @param creditCardNumber	The Client's new credit card number.
     */
    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }


    /**
     * Returns the filter that the itineraries will be sorted by.
     *
     * @return	The sorting filter of the Client's itineraries.
     */
    public String getFilter() {
        return filter;
    }

    /**
     * Sets the sorting filter that the itineraries will be sorted by.
     *
     * @param filter					The sorting filter of the Client's
     * 									itineraries.
     */
    public void setFilter(String filter) {
        try{
            if(filter.equals("cost") || filter.equals("travel time")){
                //do nothing
            }
            else {
                throw new InvalidInputException("Filter must be either "
                        + "cost or travel time.");
            }
        }
        catch(InvalidInputException e){

        }
        this.filter = filter;
    }

    /**
     * Returns the expiry date of the Client's credit card.
     *
     * @return		The expiry date of the Client's credit card in the format:
     * 				YYYY-MM-DD.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the new expiry date of the Client's credit card.
     *
     * @param expiryDate				The new expiry date of the
     * 									Client's credit card in the format:
     * 									YYYY-MM-DD.
     */
    public void setExpiryDate(String expiryDate) {
        try{
            if(expiryDate.length() == 10){

                if(expiryDate.charAt(4) == '-' && expiryDate.charAt(7) == '-'){

                    ///parseInt throws an exception if the string is not numeric
                    Integer expiryYear = Integer.parseInt(expiryDate.substring(0, 4));
                    Integer expiryMonth = Integer.parseInt(expiryDate.substring(5, 7));
                    Integer expiryDay = Integer.parseInt(expiryDate.substring(8, 10));


                    if(expiryYear >= 0 && expiryMonth >= 1 && expiryMonth <= 12
                            && expiryDay >= 1 && expiryDay <= 31){

                        //empty if - all input is valid
                    }
                    else{
                        throw new InvalidInputException("Year, Month "
                                + "or Day are invalid.");
                    }
                }
                else{
                    throw new InvalidInputException("Expiry Date must "
                            + "be in the format: YYYY-MM-DD");
                }
            }
            else{
                throw new InvalidInputException("Expiry Date must "
                        + "be in the format: YYYY-MM-DD");
            }
        } catch(InvalidInputException e){

        }

        this.expiryDate = expiryDate;
    }

    /**
     * Adds a new itinerary to the Client's list of booked itineraries.
     *
     * @param i		The itinerary to be booked.
     */
    public void bookItinerary(Itinerary i){
        if(!this.bookedItineraries.contains(i)) {
            this.bookedItineraries.add(i);

            for(Flight current : i.getFlights()){
                current.setNumSeats(current.getNumSeats() - 1);
            }
        }


    }

    /**
     * Returns an ArrayList of the Client's booked itineraries.
     *
     * @return	The Client's booked itineraries.
     */
    public ArrayList<Itinerary> getBookedItineraries() {
        return bookedItineraries;
    }

    @Override
    /**
     * Returns a String representation of this Client's information.
     *
     * @return	A String representing the Client's personal and
     * 			billing information.
     */
    public String toString(){
        return this.getLastName() + "," + this.getFirstName() + ","
                + this.getEmail() + "," + this.getAddress() + ","
                + this.getCreditCardNumber() + ","
                + this.getExpiryDate();
    }

}