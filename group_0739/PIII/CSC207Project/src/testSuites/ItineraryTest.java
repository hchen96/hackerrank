/**
 * 
 */
package testSuites;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pIII.Admin;
import pIII.Client;
import pIII.Flight;
import pIII.Infocentre;
import pIII.Itinerary;

/**
 * @author group_0739
 *
 */
public class ItineraryTest {
	private Itinerary it3;
	private Itinerary it2;
	private Itinerary it1;
	private Flight f4;
	private Flight f5;
	private Flight f6;
	private Flight f1;
	private Flight f2;
	private Flight f3;
	private ArrayList<Flight> test1;
	private ArrayList<Flight> test2;
	private ArrayList<Flight> test3;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
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

	
	/**
	 * @param f4 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		f1 = new Flight(23451, "2015-11-03 01:31", "2015-11-03 03:12", "csc", "here1","there1",1234.56, 0);
		f2 = new Flight(23451, "2015-11-04 01:23", "2015-11-04 04:12","csc","here2","there2",123.55, 0);
		f3 = new Flight(23451, "2015-11-05 02:21", "2015-11-05 06:12","csc","here3","there3",124.56, 0);
		f4 = new Flight(23451, "2015-11-06 02:41", "2015-11-06 08:12","csc","here4","there4", 234.6, 0);
		f5 = new Flight(23451, "2015-11-07 01:31", "2015-11-07 07:45","csc","here5","there5", 134.56, 0);
		f6 = new Flight(23451, "2015-11-10 23:31", "2015-11-11 03:12","csc","here6","there6", 23.5, 0);
		test1 = new ArrayList<Flight>();
		test1.add(f1);
		test1.add(f3);
		test1.add(f6);
		test2 = new ArrayList<Flight>();
		test2.add(f2);
		test2.add(f4);
		test2.add(f6);
		test3 = new ArrayList<Flight>();
		test3.add(f1);
		test3.add(f2);
		test3.add(f3);
		it1 = new Itinerary((ArrayList<Flight>)test1);
		it2 = new Itinerary((ArrayList<Flight>)test2);
		it3 = new Itinerary((ArrayList<Flight>)test3);
		System.setOut(new PrintStream(outContent));
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.setOut(null);
		
	}

	

	/**
	 * constructor generally works if getters of all its instance variables passes all the tests
	 * this test method is to test exceptions and passing variables that might break the constructor 
	 * 
	 * Test method for {@link pII.Itinerary#Itinerary(java.util.ArrayList)}.
	 */
	@Test
	public void testItineraryArrayListOfFlight() {
		/*
		 * test for passing empty list into constructor
		 */
		Itinerary check1 = new Itinerary(new ArrayList<Flight>());
		assertTrue( outContent.toString().contains("Empty list of flights given "));
		
		}
	

	/**
	 * Test method for {@link pII.Itinerary#getDepartureDate()}.
	 */
	@Test
	public void testGetDepartureDateAsStr() {
		/*
		 * test getdeparturedate for basic itinerary
		 */
		assertEquals("2015-11-03",it3.getDepartureDateAsStr());
		

		/* 
		 * testgetdeparturedate for itinerary created using constructor 
		 * that just passes a list of flights
		 */
		assertEquals("2015-11-04", it2.getDepartureDateAsStr());

		
		/* 
		 * testgetdeparturedate for itinerary created using constructor 
		 * that just passes a list of flights
		 */
		assertEquals("2015-11-03", it1.getDepartureDateAsStr());
	}
	
	/**
	 * Test method for {@link pII.Itinerary#getDepartureDate()}.
	 */
	@Test
	public void testGetDepartureDate() {
		/*
		 * test getdeparturedate for basic itinerary
		 */
		
		assertEquals(10, it1.getDepartureDate().get(Calendar.MONTH));
		assertEquals(3, it1.getDepartureDate().get(Calendar.DATE));
		assertEquals(2015, it1.getDepartureDate().get(Calendar.YEAR));
		/*
		 * testgetdeparturedate for itinerary 
		 * 
		 */
	
		assertEquals(10, it2.getDepartureDate().get(Calendar.MONTH));
		assertEquals(4, it2.getDepartureDate().get(Calendar.DATE));
		assertEquals(2015, it2.getDepartureDate().get(Calendar.YEAR));
		
		/*
		 * testgetdeparturedate for itinerary 
		 * 
		 */
	
		assertEquals(10, it3.getDepartureDate().get(Calendar.MONTH));
		assertEquals(3, it3.getDepartureDate().get(Calendar.DATE));
		assertEquals(2015, it3.getDepartureDate().get(Calendar.YEAR));
	}


	/**
	 * Test method for {@link pII.Itinerary#getOrigin()}.
	 */
	@Test
	public void testGetOrigin() {
		/*
		 *test getorigin for itinerary constructed by passing 
		 * just a list of flights 
		 * tests constructor's origin instance assignment as well 
		 * since constructor pulls out destination based on flights
		 */
		assertEquals("here2", it2.getOrigin());
		
		/*
		 * test get origin
		 */
		assertEquals("here1",it1.getOrigin());
		/*
		 * test getdestination on itinerary  
		 */
		assertEquals("here1", it3.getOrigin() );
	}	

	/**
	 * Test method for {@link pII.Itinerary#getDestination()}.
	 */
	@Test
	public void testGetDestination() {
		/*
		 * test getdestination for itinerary constructed by passing 
		 * just a list of flights 
		 * tests constructor's destination instance assignment as well 
		 * since constructor pulls out destination based on flights
		 */
		assertEquals("there6", it2.getDestination());
		
		/*
		 * test getdestination on another itinerary
		 */
		assertEquals("there6", it1.getDestination());
		/*
		 * test getdestination on another itinerary 
		 */
		assertEquals("there3", it3.getDestination() );
	}

	/**
	 * Test method for {@link pII.Itinerary#getTotalCost()}.
	 */
	@Test
	public void testGetTotalCost() {
		/*
		 * test calculation of cost for itinerary constructed by passing 
		 * just the list of flights
		 */
		assertEquals(1382.62, it1.getTotalCost(),0.001);
		/*
		 * test calling on another itinerary
		 */
		assertEquals(381.65,it2.getTotalCost(),0.001);
		/*
		 * test calculation for another itinerary 
		 */
		assertEquals(1482.67, it3.getTotalCost(),0.001);
	}

	/**
	 * Test method for {@link pII.Itinerary#getTotalTraveTime()}.
	 */
	@Test
	public void testGetTotalTraveTime() {
		/*
		 * test calculation of total time with a flight 
		 * that spans 2 days across midnight
		 */
		assertEquals( 11621, (int)it1.getTotalTraveTime());
		
		/*
		 * test basic calculation of total time
		 */
		assertEquals(3161, (int)it3.getTotalTraveTime());
		/*
		 * test calling on another itinerary 
		 */
		assertEquals(10189 ,(int)it2.getTotalTraveTime());
	}

	/**
	 * Test method for {@link pII.Itinerary#getFlights()}.
	 */
	@Test
	public void testGetFlights() {
		/*
		 *test of getflights on an itinerary  
		 *
		 */
		assertEquals(test2, it2.getFlights());
		/*
		 * test getflights on  itinerary
		 */
		assertEquals(test1,it1.getFlights());
		/*
		 * test getflights on another itinerary 
		 */
		assertEquals(test3,it3.getFlights());
	}

	/**
	 * Test method for {@link pII.Itinerary#addFlight(pII.Flight)}.
	 */
	
	/* add flight method has been removed
	@Test
	public void testAddFlight() {
		
		 * basic test for adding to a simple itinerary constructed with all variable passed
		 
		Itinerary temp = it3;
		temp.addFlight(f4);
		assertEquals(temp.getFlights().get(3), f4);
		
		
		 * test for adding to empty itinerary
		 
		Itinerary temp1 = it1;
		temp1.addFlight(f1);
		temp1.addFlight(f3);
		assertEquals(temp1.getFlights().get(0), f1);
		assertEquals(temp1.getFlights().get(1), f3);
		
		
		 * test for itinerary  constructed by passing just a list of flights
		 
		it2.addFlight(f5);
		assertEquals(it2.getFlights().get(3),f5);
	}*/
	
}