package group_0739.piii;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author group_0739
 * This class represents an Itinerary, which is a series of flights from an
 * origin to a destination. This class is responsible for creating a new
 * Itinerary, calculating the total wait time between flights,
 * calculating the total travel time, and calculating the total cost.
 *
 */
public class Itinerary implements Serializable{

    private static final long serialVersionUID = -4463359154979386536L;
    //instance variables
    /**
     * The date that the itinerary departs.
     */
    private Calendar departureDate;
    /**
     * The city of origin of the itinerary.
     */
    private String origin;
    /**
     * The final destination of the itinerary.
     */
    private String destination;
    /**
     * The total cost of the itinerary.
     */
    private double totalCost = 0;
    /**
     * The total travel time of the itinerary.
     */
    private Integer totalTravelTime = 0;
    /**
     * The flights that make up this itinerary.
     */
    private ArrayList<Flight> flights;

    /**
     * The layover times between flights.
     */
    private ArrayList<Integer> waitTimes = new ArrayList<Integer>();
    /**
     * A String version of the departure date.
     */
    private String departureDateAsStr;



    /**
     * Constructs a new itinerary object with origin and destination based
     * on flights within it.
     * @param flights    The list of the itineray's flights
     */

    public Itinerary(ArrayList<Flight> flights){
        try{
            //Create new calander for departure date time for easy calculation
            //of time between arrival and departure dates.
            GregorianCalendar temp = flights.get(0).getDepartureDateTime();
            this.departureDate = new GregorianCalendar(temp.get(Calendar.YEAR),
                    temp.get(Calendar.MONTH),temp.get(Calendar.DATE));
            this.origin = flights.get(0).getOrigin();
            this.destination = flights.get(flights.size()-1).getDestination();
            this.flights = flights;
            this.departureDateAsStr
                    = flights.get(0).getDepartureDateTimeAsStr().split(" ")[0];

            // cycle through all flights and get total cots and total
            //travel time without wait time
            for(Flight f : this.flights){
                this.totalCost += f.getCost();
                this.totalTravelTime += f.calculateTravelTime();
            }

            //Calculate wait time between flights as a list of int in minutes.
            this.calculateWaitTime();
        }catch(IndexOutOfBoundsException e){
            System.out.println("Empty list of flights given " + e.getMessage());
        }
    }

    /**
     * Returns the departure date of first flight in the format: "YYYY-MM-DD".
     * @return The departure date of the first flight.
     */
    public Calendar getDepartureDate() {
        return departureDate;
    }

    /**
     * Returns the name of the city that the first flight in the itinerary
     * leaves from.
     * @return The city the first flight left from.
     */
    public String getOrigin() {
        return origin;
    }
    /**
     * Returns the name of the city the last flight of the itinerary arrives at.
     * @return The city of the last flight arrives at.
     */

    public String getDestination() {
        return destination;
    }
    /**
     * Gets the total cost of all the flights in the itinerary.
     * @return The total cost of the flights.
     */

    public double getTotalCost() {
        return totalCost;
    }
    /**
     * Gets the total travel time of the whole itinerary.
     * @return Total travel time.
     */

    public Integer getTotalTraveTime() {
        return totalTravelTime;
    }

    /**
     * Gets the list of flights in the itinerary.
     * @return The list of flights in the itinerary.
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }



    /**
     * Gets the departure date and time of itinerary as a string.
     * @return The departure date and time in String format.
     */
    public String getDepartureDateAsStr() {
        return departureDateAsStr;
    }

    /**
     * Returns a String representation of this Itinerary.
     * @return 		This Itinerary as a String.
     */
    @Override
    public String toString() {
        String str = new String();
        for(Flight f : this.flights){
            str += f.toString().substring(0,f.toString().lastIndexOf(",")) + "\n";
        }
        // Make sure decimal is to 2 decimal place.
        DecimalFormat df = new DecimalFormat(".00");
        str += df.format(this.getTotalCost()) + "\n";
        str += String.format("%02d", this.getTotalTraveTime()/60) + ":"
                + String.format("%02d", this.getTotalTraveTime()%60);
        return str;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((departureDate == null) ? 0
                : departureDate.hashCode());
        result = prime * result + ((destination == null) ? 0
                : destination.hashCode());
        result = prime * result + ((flights == null) ? 0 : flights.hashCode());
        result = prime * result + ((origin == null) ? 0 : origin.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Itinerary)) {
            return false;
        }
        Itinerary other = (Itinerary) obj;
        if (departureDate == null) {
            if (other.departureDate != null) {
                return false;
            }
        } else if (!departureDate.equals(other.departureDate)) {
            return false;
        }
        if (destination == null) {
            if (other.destination != null) {
                return false;
            }
        } else if (!destination.equals(other.destination)) {
            return false;
        }
        if (flights == null) {
            if (other.flights != null) {
                return false;
            }
        } else if (!flights.equals(other.flights)) {
            return false;
        }
        if (origin == null) {
            if (other.origin != null) {
                return false;
            }
        } else if (!origin.equals(other.origin)) {
            return false;
        }
        return true;
    }

    /**
     * Gets a list of all the wait times between flights.
     * @return waitTimes 	A list of wait time between flights.
     */
    public ArrayList<Integer> getWaitTimes() {
        return waitTimes;
    }

    /**
     * Calculates the wait time between all the flights and adds it to the
     * total travel time.
     */
    public void calculateWaitTime(){
        if(this.flights.size() >= 2){
            int i = 0; int j = 1;
            Flight f1 = this.flights.get(i);
            Flight f2 = this.flights.get(j);
            Integer waitTime;
            boolean done = false;

            do{
                Calendar f1Arrive = f1.getArrivalDateTime();
                Calendar f2Depart = f2.getDepartureDateTime();

                //subtract departure and arrival time
                waitTime = (int) ((f2Depart.getTimeInMillis()
                        - f1Arrive.getTimeInMillis())/(1000 * 60));
                //Add waittime to total travel time.
                this.waitTimes.add(waitTime);
                this.totalTravelTime += waitTime;

                //end when we've calculate all waittimes
                if(j == this.flights.size() - 1){
                    done = true;
                }
                else{
                    i++; j++;
                    f1 = this.flights.get(i);
                    f2 = this.flights.get(j);
                }
            }while(!done);


        }
    }

}
