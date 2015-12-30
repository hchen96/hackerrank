/**
 * 
 */
package testSuites;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pII.Flight;
import pII.InvalidInputException;

/**
 * @author group_0739
 *
 */
public class FlightTest{
  
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	private Flight f1;
	private Flight f2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
	f1 = new Flight(03451,"2015-09-06 12:15", "2015-09-06 12:16", "Air Canada","Toronto","Bangkok",
			666.66);
	f2 = new Flight(03467, "2015-09-06 07:56", "2015-09-05 12:17", "JetBlue", "London", "Detriot",
			69.69);
	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
    
	/**
	 * Test method for {@link pII.Flight#Flight(java.lang.String, java.lang.String, 
	 * java.lang.String, java.lang.String, int, java.lang.String, java.lang.Double)}.
	 */
	@Test
	public void testFlight() {
		
        //How to test the Constructor
		try{
			if(f1.getDepartureDateTimeAsStr().length() > 16 ){
			    throw new InvalidInputException("Year, Month, Day,"
			    		+ " Hour or Minute are invalid.  Hour is on a 24-hour clock.");
			} else if (f1.getDepartureDateTimeAsStr().length() < 16){
				  throw new InvalidInputException("Year, Month, Day, Hour or Minute are invalid. "
						+ " Hour is on a 24-hour clock.");
			} else if (f1.getDepartureDateTimeAsStr().length() == 16){
			      if(f1.getDepartureDateTimeAsStr().charAt(4) == '-' && f1.getDepartureDateTimeAsStr().charAt(7) == '-' 
						&& f1.getDepartureDateTimeAsStr().charAt(10) == ' ' && f1.getDepartureDateTimeAsStr().charAt(13) == ':'){
			    	    
			    	    // Other test cases. 
			    	  	Integer departureYear = Integer.parseInt(f1.getDepartureDateTimeAsStr().substring(0, 4));
			    	  	//Supposes to throw an exception if the string is not numeric. 
						Integer departureMonth = Integer.parseInt(f1.getDepartureDateTimeAsStr().substring(5, 7));
						Integer departureDay = Integer.parseInt(f1.getDepartureDateTimeAsStr().substring(8, 10));
						Integer departureHour = Integer.parseInt(f1.getDepartureDateTimeAsStr().substring(11, 13));
						Integer departureMinute = Integer.parseInt(f1.getDepartureDateTimeAsStr().substring(14));
						
						if(departureYear >= 0 && departureMonth >= 1 && departureMonth <= 12 
								&& departureDay >= 1 && departureDay <= 31 && departureHour >= 0 
								&& departureHour <= 24 && departureMinute >= 0 && departureMinute <= 60){
						}
						else {
							throw new InvalidInputException("Year, Month, Day, Hour or Minute are invalid. "
						+ " Hour is on a 24-hour clock.");
						}
			      }
			      else {
			    	  throw new InvalidInputException("Year, Month, Day, Hour or Minute are invalid. "
								+ " Hour is on a 24-hour clock."); 
			      }
			}
		} catch(InvalidInputException e){
			//insert meaningful message
		}
		
		try{
			if(f1.getArrivalDateTimeAsStr().length() > 16 ){
			    throw new InvalidInputException("Year, Month, Day,"
			    		+ " Hour or Minute are invalid.  Hour is on a 24-hour clock.");
			} else if (f1.getArrivalDateTimeAsStr().length() < 16){
				  throw new InvalidInputException("Year, Month, Day, Hour or Minute are invalid. "
						+ " Hour is on a 24-hour clock.");
			} else if (f1.getArrivalDateTimeAsStr().length() == 16){
			      if(f1.getArrivalDateTimeAsStr().charAt(4) == '-' && f1.getArrivalDateTimeAsStr().charAt(7) == '-' 
						&& f1.getArrivalDateTimeAsStr().charAt(10) == ' ' && f1.getArrivalDateTimeAsStr().charAt(13) == ':'){
			    	    
			    	    // Other test cases. 
			    	  	Integer ArrivalYear = Integer.parseInt(f1.getArrivalDateTimeAsStr().substring(0, 4));
			    	  	//Supposes to throw an exception if the string is not numeric. 
						Integer ArrivalMonth = Integer.parseInt(f1.getArrivalDateTimeAsStr().substring(5, 7));
						Integer ArrivalDay = Integer.parseInt(f1.getArrivalDateTimeAsStr().substring(8, 10));
						Integer ArrivalHour = Integer.parseInt(f1.getArrivalDateTimeAsStr().substring(11, 13));
						Integer ArrivalMinute = Integer.parseInt(f1.getArrivalDateTimeAsStr().substring(14));
						
						if(ArrivalYear >= 0 && ArrivalMonth >= 1 && ArrivalMonth <= 12 
								&& ArrivalDay >= 1 && ArrivalDay <= 31 && ArrivalHour >= 0 
								&& ArrivalHour <= 24 && ArrivalMinute >= 0 && ArrivalMinute <= 60){
						}
						else {
							throw new InvalidInputException("Year, Month, Day, Hour or Minute are invalid. "
						+ " Hour is on a 24-hour clock.");
						}
			      }
			      else {
			    	  throw new InvalidInputException("Year, Month, Day, Hour or Minute are invalid. "
								+ " Hour is on a 24-hour clock."); 
			      }
			}
		} catch(InvalidInputException e){
			//insert meaningful message
		}
        //may test whether each parameter is the specified type.
	}

	/**
	 * Test method for {@link pII.Flight#getDepartureDateTimeAsStr()}.
	 */
	@Test
	public void testGetDepartureDateTime() {
		
		assertEquals("2015-09-06 12:15", f1.getDepartureDateTimeAsStr());
			
	}

	/**
	 * Test method for {@link pII.Flight#setDepartureDateTime(java.lang.String)}.
	 * @throws InvalidInputException 
	 */
	@Test
	public void testSetDepartureDateTime() {
		//f1.setDepartureDateTime("2015-09-06 12:15");
		assertEquals("2015-09-06 12:15", f1.getDepartureDateTimeAsStr());
	}

	/**
	 * Test method for {@link pII.Flight#getArrivalDateTimeAsStr()}.
	 */
	@Test
	public void testGetArrivalDateTime() {
		
		assertEquals("2015-09-06 12:16", f1.getArrivalDateTimeAsStr());
	}

	/**
	 * Test method for {@link pII.Flight#setArrivalDateTime(java.lang.String)}.
	 */
	@Test
	public void testSetArrivalDateTime() {
		
		//f1.setArrivalDateTime("2015-09-06 12:16");
		assertEquals("2015-09-06 12:16", f1.getArrivalDateTimeAsStr());
		
	}

	/**
	 * Test method for {@link pII.Flight#getOrigin()}.
	 */
	@Test
	public void testGetOrigin() {
		
		
		assertEquals("Toronto", f1.getOrigin());
	}

	/**
	 * Test method for {@link pII.Flight#setOrigin(java.lang.String)}.
	 */
	@Test
	public void testSetOrigin() {
	
		f1.setOrigin("Toronto");
		assertEquals("Toronto", f1.getOrigin());
	}

	/**
	 * Test method for {@link pII.Flight#getDestination()}.
	 */
	@Test
	public void testGetDestination() {
		
		
		assertEquals("Bangkok", f1.getDestination());
	}

	/**
	 * Test method for {@link pII.Flight#setDestination(java.lang.String)}.
	 */
	@Test
	public void testSetDestination() {
		f1.setDestination("Bangkok");
		assertEquals("Bangkok", f1.getDestination());
	}

	/**
	 * Test method for {@link pII.Flight#getFlightNumber()}.
	 */
	@Test
	public void testGetFlightNumber() {
		//Have to change this if we decide to change this into an int or string
		
		assertEquals(03451, f1.getFlightNumber());
	}

	/**
	 * Test method for {@link pII.Flight#getAirline()}.
	 */
	@Test
	public void testGetAirline() {
		
		
		assertEquals("Air Canada", f1.getAirline());
	}

	/**
	 * Test method for {@link pII.Flight#setAirline(java.lang.String)}.
	 */
	@Test
	public void testSetAirline() {
		f1.setAirline("AirCanada");
		assertEquals("AirCanada", f1.getAirline());
	}

	/**
	 * Test method for {@link pII.Flight#getCost()}.
	 */
	@Test
	public void testGetCost() {	
		
		assertEquals(666.66, (double)f1.getCost(),0.01);

	}

	/**
	 * Test method for {@link pII.Flight#setCost(java.lang.Double)}.
	 */
	@Test
	public void testSetCost() {
		
		f1.setCost(666.66);
		assertEquals(666.66, (double)f1.getCost(),0.01);

	}

}
