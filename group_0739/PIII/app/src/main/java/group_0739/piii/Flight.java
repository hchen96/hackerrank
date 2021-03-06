package group_0739.piii;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author group_0739
 *
 * This class represents a flight from one place to another.
 * It is responsible for creating a new Flight and calculating
 * the total travel time of the flight.
 *
 */
public class Flight implements Serializable, Comparable<Flight> {

    private static final long serialVersionUID = -3726186024893369366L;
    /**
     * The Flight's departure date time as a string.
     */
    private String departureDateTimeAsStr;
    /**
     * The Flight's arrival date time as a string.
     */
    private String arrivalDateTimeAsStr;
    /**
     * The Flight's time and date of departure.
     */
    private GregorianCalendar departureDateTime;
    /**
     * The Flight's time and date of arrival.
     */
    private GregorianCalendar arrivalDateTime;
    /**
     * The Flight's original take off city.
     */
    private String origin;
    /**
     * The Flight's final destination.
     */
    private String destination;
    /**
     * The Flight's id.
     */
    private int flightNumber;
    /**
     * the Flight's airline.
     */
    private String airline;
    /**
     * The Flight's price.
     */
    private Double cost;

    /**
     * The number of seats available on this Flight.
     */
    private int numSeats;
    /**
     * Constructs a new Flight object with a departure date and time,
     * arrival date and time, origin and destination, flight number,
     * airline, and cost.
     *
     * @param flightNumber			The unique identifying number of this
     * 								flight.
     * @param airline				The name of the airline this flight belongs to.
     * @param departureDateTime		The departure date of this flight.
     * 								in the format: "YYYY-MM-DD HH:MM".
     * @param arrivalDateTime		The arrival date of this flight.
     * 								in the format: "YYYY-MM-DD HH:MM".
     * @param origin				The name of the city that this flight
     * 								departs from.
     * @param destination			The name of the city this flight
     * 								is flying to.
     * @param cost					The cost of booking a ticket on this flight.
     * @param numSeats				The number of available seats on the flight.
     *
     */

    public Flight(int flightNumber, String departureDateTime,
                  String arrivalDateTime, String airline, String origin,
                  String destination, Double cost, int numSeats) {

        super();
        try{
            if(departureDateTime.length() == 16){

                if(departureDateTime.charAt(4) == '-'
                        && departureDateTime.charAt(7) == '-'
                        && departureDateTime.charAt(10) == ' '
                        && departureDateTime.charAt(13) == ':'){

                    ///parseInt throws an exception if the string is not numeric
                    Integer departureYear = Integer.parseInt(departureDateTime.substring(0, 4));
                    Integer departureMonth = Integer.parseInt(departureDateTime.substring(5, 7));
                    Integer departureDay = Integer.parseInt(departureDateTime.substring(8, 10));
                    Integer departureHour = Integer.parseInt(departureDateTime.substring(11, 13));
                    Integer departureMinute = Integer.parseInt(departureDateTime.substring(14));

                    if(departureYear >= 0 && departureMonth >= 1
                            && departureMonth <= 12
                            && departureDay >= 1 && departureDay <= 31
                            && departureHour >= 0
                            && departureHour <= 24 && departureMinute >= 0
                            && departureMinute <= 60){

                        //empty if - all input is valid
                    }
                    else{
                        throw new InvalidInputException("Year, Month, Day, " +
                                "Hour or Minute are invalid. Hour is on a 24-hour clock.");
                    }
                }
                else{
                    throw new InvalidInputException("Departure Date and time "
                            + "must be in the format: YYYY-MM-DD HH:MM");
                }
            }
            else{
                throw new InvalidInputException("Departure Date and time must "
                        + "be in the format: YYYY-MM-DD HH:MM");
            }
        } catch(InvalidInputException e){

        }

        try{
            if(arrivalDateTime.length() == 16){

                if(arrivalDateTime.charAt(4) == '-'
                        && arrivalDateTime.charAt(7) == '-'
                        && arrivalDateTime.charAt(10) == ' '
                        && arrivalDateTime.charAt(13) == ':'){

                    ///parseInt throws an exception if the string is not numeric
                    Integer arrivalYear = Integer.parseInt(arrivalDateTime.substring(0, 4));
                    Integer arrivalMonth = Integer.parseInt(arrivalDateTime.substring(5, 7));
                    Integer arrivalDay = Integer.parseInt(arrivalDateTime.substring(8, 10));
                    Integer arrivalHour = Integer.parseInt(arrivalDateTime.substring(11, 13));
                    Integer arrivalMinute = Integer.parseInt(arrivalDateTime.substring(14));

                    if(arrivalYear >= 0 && arrivalMonth >= 1
                            && arrivalMonth <= 12
                            && arrivalDay >= 1 && arrivalDay <= 31
                            && arrivalHour >= 0
                            && arrivalHour <= 24 && arrivalMinute >= 0
                            && arrivalMinute <= 60){
                        //empty if - all input is valid
                    }
                    else{
                        throw new InvalidInputException("Year, Month, Day, Hour or "
                                + "Minute are invalid.  Hour is on a 24-hour clock.");
                    }
                }
                else{
                    throw new InvalidInputException("Departure Date and time "
                            + "must be in the format: YYYY-MM-DD HH:MM");
                }
            }
            else{
                throw new InvalidInputException("Departure Date and time "
                        + "must be in the format: YYYY-MM-DD HH:MM");
            }
        } catch(InvalidInputException e){

        }
        Integer departureYear = Integer.parseInt(departureDateTime.substring(0, 4));
        Integer departureMonth = (Integer.parseInt(departureDateTime.substring(5, 7)))-1 ;
        Integer departureDay = Integer.parseInt(departureDateTime.substring(8, 10));
        Integer departureHour = Integer.parseInt(departureDateTime.substring(11, 13));
        Integer departureMinute = Integer.parseInt(departureDateTime.substring(14));

        Integer arrivalYear = Integer.parseInt(arrivalDateTime.substring(0, 4));
        Integer arrivalMonth = (Integer.parseInt(arrivalDateTime.substring(5, 7)))-1 ;
        Integer arrivalDay = Integer.parseInt(arrivalDateTime.substring(8, 10));
        Integer arrivalHour = Integer.parseInt(arrivalDateTime.substring(11, 13));
        Integer arrivalMinute = Integer.parseInt(arrivalDateTime.substring(14));



        this.departureDateTime = new GregorianCalendar(departureYear,
                departureMonth, departureDay, departureHour, departureMinute);
        this.arrivalDateTime = new GregorianCalendar(arrivalYear, arrivalMonth,
                arrivalDay, arrivalHour, arrivalMinute);
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.cost = cost;
        this.departureDateTimeAsStr =departureDateTime;
        this.arrivalDateTimeAsStr  = arrivalDateTime;
        this.numSeats = numSeats;

    }







    /**
     * Returns the departure date and time of the flight
     *  in the format: "YYYY-MM-DD HH:MM".
     *
     * @return The departure date and time of the flight.
     */
    public GregorianCalendar getDepartureDateTime() {
        return departureDateTime;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((airline == null) ? 0 :
                airline.hashCode());
        result = prime * result + ((arrivalDateTime == null) ? 0 :
                arrivalDateTime.hashCode());
        result = prime * result + ((cost == null) ? 0 :
                cost.hashCode());
        result = prime * result + ((departureDateTime == null) ? 0 :
                departureDateTime.hashCode());
        result = prime * result + ((destination == null) ? 0 :
                destination.hashCode());
        result = prime * result + flightNumber;
        result = prime * result + ((origin == null) ? 0 :
                origin.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Flight other = (Flight) obj;
        if (airline == null) {
            if (other.airline != null)
                return false;
        } else if (!airline.equals(other.airline))
            return false;
        if (arrivalDateTime == null) {
            if (other.arrivalDateTime != null)
                return false;
        } else if (!arrivalDateTime.equals(other.arrivalDateTime))
            return false;
        if (cost == null) {
            if (other.cost != null)
                return false;
        } else if (!cost.equals(other.cost))
            return false;
        if (departureDateTime == null) {
            if (other.departureDateTime != null)
                return false;
        } else if (!departureDateTime.equals(other.departureDateTime))
            return false;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        if (flightNumber != other.flightNumber)
            return false;
        if (origin == null) {
            if (other.origin != null)
                return false;
        } else if (!origin.equals(other.origin))
            return false;
        return true;
    }


    /**
     * Sets the departure date and time of the flight.
     *
     * @param departureDateTime			The departure date and time of the
     * 									flight in the format:"YYYY-MM-DD HH:MM"
     * @throws InvalidInputException	Throws an exception if
     * 									departureDateTime is not in the format:
     * 								 	"YYYY-MM-DD HH:MM".
     */
    public void setDepartureDateTime(String departureDateTime) throws InvalidInputException{
        try{
            if(departureDateTime.length() == 16){

                if(departureDateTime.charAt(4) == '-'
                        && departureDateTime.charAt(7) == '-'
                        && departureDateTime.charAt(10) == ' '
                        && departureDateTime.charAt(13) == ':'){

                    ///parseInt throws an exception if the string is not numeric
                    Integer departureYear = Integer.parseInt(departureDateTime.substring(0, 4));
                    Integer departureMonth = Integer.parseInt(departureDateTime.substring(5, 7));
                    Integer departureDay = Integer.parseInt(departureDateTime.substring(8, 10));
                    Integer departureHour = Integer.parseInt(departureDateTime.substring(11, 13));
                    Integer departureMinute = Integer.parseInt(departureDateTime.substring(14));

                    if(departureYear >= 0 && departureMonth >= 1
                            && departureMonth <= 12
                            && departureDay >= 1 && departureDay <= 31
                            && departureHour >= 0
                            && departureHour <= 24 && departureMinute >= 0
                            && departureMinute <= 60){

                        //empty if - all input is valid
                    }
                    else{
                        throw new InvalidInputException("Year, Month, Day, "
                                + "Hour or Minute are invalid.  "
                                + "Hour is on a 24-hour clock.");
                    }
                }
                else{
                    throw new InvalidInputException("Departure Date and time "
                            + "must be in the format: YYYY-MM-DD HH:MM");
                }
            }
            else{
                throw new InvalidInputException("Departure Date and time "
                        + "must be in the format: YYYY-MM-DD HH:MM");
            }
        } catch(InvalidInputException e){

        }
        Integer departureYear = Integer.parseInt(departureDateTime.substring(0, 4));
        Integer departureMonth = Integer.parseInt(departureDateTime.substring(5, 7))-1;
        Integer departureDay = Integer.parseInt(departureDateTime.substring(8, 10));
        Integer departureHour = Integer.parseInt(departureDateTime.substring(11, 13));
        Integer departureMinute = Integer.parseInt(departureDateTime.substring(14));

        this.departureDateTimeAsStr = departureDateTime;
        this.departureDateTime = new GregorianCalendar(departureYear,
                departureMonth, departureDay, departureHour, departureMinute);
    }

    /**
     * Returns the arrival date and time of the flight in the format:
     * "YYYY-MM-DD HH:MM".
     *
     * @return	The arrival date and time of the flight.
     */
    public GregorianCalendar getArrivalDateTime() {
        return arrivalDateTime;
    }

    /**
     * Sets the arrival date and time of the flight.
     *
     * @param arrivalDateTime			The departure date and time
     * 									of the flight in the format:
     * 									"YYYY-MM-DD HH:MM"
     */
    public void setArrivalDateTime(String arrivalDateTime){
        try{
            if(arrivalDateTime.length() == 16){

                if(arrivalDateTime.charAt(4) == '-'
                        && arrivalDateTime.charAt(7) == '-'
                        && arrivalDateTime.charAt(10) == ' '
                        && arrivalDateTime.charAt(13) == ':'){

                    ///parseInt throws an exception if the string is not numeric

                    Integer arrivalYear = Integer.parseInt(arrivalDateTime.substring(0, 4));
                    Integer arrivalMonth = Integer.parseInt(arrivalDateTime.substring(5, 7));
                    Integer arrivalDay = Integer.parseInt(arrivalDateTime.substring(8, 10));
                    Integer arrivalHour = Integer.parseInt(arrivalDateTime.substring(11, 13));
                    Integer arrivalMinute = Integer.parseInt(arrivalDateTime.substring(14));

                    if(arrivalYear >= 0 && arrivalMonth >= 1
                            && arrivalMonth <= 12
                            && arrivalDay >= 1 && arrivalDay <= 31
                            && arrivalHour >= 0
                            && arrivalHour <= 24 && arrivalMinute >= 0
                            && arrivalMinute <= 60){

                        //empty if - all input is valid
                    }
                    else{
                        throw new InvalidInputException("Year, Month, Day, "
                                + "Hour or Minute are invalid.  "
                                + "Hour is on a 24-hour clock.");
                    }
                }
                else{
                    throw new InvalidInputException("Departure Date and time "
                            + "must be in the format: YYYY-MM-DD HH:MM");
                }
            }
            else{
                throw new InvalidInputException("Departure Date and time "
                        + "must be in the format: YYYY-MM-DD HH:MM");
            }
        } catch(InvalidInputException e){

        }

        Integer arrivalYear = Integer.parseInt(arrivalDateTime.substring(0, 4));
        Integer arrivalMonth = Integer.parseInt(arrivalDateTime.substring(5, 7))-1;
        Integer arrivalDay = Integer.parseInt(arrivalDateTime.substring(8, 10));
        Integer arrivalHour = Integer.parseInt(arrivalDateTime.substring(11, 13));
        Integer arrivalMinute = Integer.parseInt(arrivalDateTime.substring(14));

        this.arrivalDateTimeAsStr = arrivalDateTime;
        this.arrivalDateTime = new GregorianCalendar(arrivalYear,
                arrivalMonth, arrivalDay, arrivalHour, arrivalMinute);
    }


    /**
     * Returns the number of free seats on this Flight.
     * @return	the number of available seats.
     */
    public int getNumSeats() {
        return numSeats;
    }



    /**
     * Sets the number of free seats on this Flight.
     * @param numSeats	the number of available seats on this Flight.
     */
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    /**
     * Returns the departure date time as string format YYYY-MM-DD HH:MM.
     * @return the departureDateTime As String
     */
    public String getDepartureDateTimeAsStr() {
        return departureDateTimeAsStr;
    }


    /**
     * Returns the arrival date time as string format YYYY-MM-DD HH:MM.
     * @return the arrivalDateTime As String
     */
    public String getArrivalDateTimeAsStr() {
        return arrivalDateTimeAsStr;
    }


    /**
     * Returns the city this flight originates from.
     *
     * @return	The city this flight departs from.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the city this flight originates from.
     *
     * @param origin	The city this flight departs from.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Returns the city this flight flies to.
     *
     * @return	The city this flight flies to.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the city this flight flies to.
     *
     * @param destination	The city this flight flies to.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Returns the unique flight number of this flight.
     *
     * @return	the unique flight number of this flight.
     */
    public int getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the unique flight number of this flight.
     *
     * @param flightNumber	the unique flight number of this flight.
     */
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Returns the airline that this flight belongs to.
     *
     * @return	The airline that this flight belongs to.
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Sets the airline that this flight belongs to.
     *
     * @param airline	The airline that this flight belongs to.
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }

    /**
     * Returns the cost of booking a ticket on this flight.
     *
     * @return	The cost of booking a ticket on this flight.
     */
    public Double getCost() {
        return cost;
    }

    /**
     * Sets the cost of booking a ticket on this flight.
     *
     * @param cost	The cost of booking a ticket on this flight.
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * Returns the total time it takes the flight to travel from origin to
     * destination.  Time zones are not factored in to the calculation.
     *
     * @return	The total time of the flight.
     */
    public Integer calculateTravelTime(){
        long diff = this.arrivalDateTime.getTimeInMillis()
                - this.departureDateTime.getTimeInMillis();
        int time = (int) diff/(1000*60);

        return time;
    }

    /**
     * Returns whether this Flight is equal to Flight other.
     * Flights are equal if and only if their airlines,
     * arrival date and time, cost, departure date and time, destination,
     * flight number, and origin are equal.
     *
     * @param other 	The Flight that this Flight is compared to.
     * @return			0 if the two objects are equal, 1 if they are not
     * 					equal.
     */
    @Override
    public int compareTo(Flight other) {
        if(this.getAirline().equals(other.getAirline())
                && this.getArrivalDateTime().equals(other.getArrivalDateTime())
                && this.getCost().equals(other.getCost())
                && this.getDepartureDateTime().equals(other.getDepartureDateTime())
                && this.getDestination().equals(other.getDestination())
                && this.getFlightNumber() == other.getFlightNumber()
                && this.getOrigin().equals(other.getOrigin())){
            return 0;
        }
        return 1;
    }

    /**
     * Returns a String representation of this Flight.
     * @return 		This Flight as a String.
     */
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat(".00");
        return this.getFlightNumber() + "," + this.getDepartureDateTimeAsStr()
                + "," + this.getArrivalDateTimeAsStr()
                + "," +this.getAirline() + "," + this.getOrigin() + ","
                + this.getDestination() + "," + df.format(this.getCost());

    }
}