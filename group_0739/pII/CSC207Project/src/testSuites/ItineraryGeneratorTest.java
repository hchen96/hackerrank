/**
 * 
 */
package testSuites;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pII.Admin;
import pII.Client;
import pII.Flight;
import pII.Infocentre;
import pII.Itinerary;
import pII.ItineraryGenerator;


/**
 * @author group_0739
 *
 */
public class ItineraryGeneratorTest {
	private Client c1;
	private Client c2; 
	private Infocentre infocentre = new Infocentre();
	private Client c3;
	private Client c4;
	private Client c5;
	private Admin a1;
	private Admin a2;
	private Admin a3;
	private Admin a4;
	private Admin a5;
	private Flight f1;
	private Flight f2;
	private Flight f3;
	private Flight f4;
	private Flight f5;
	private Flight f6;
	private Flight f7;
	private Flight f8;
	private Flight f9;
	private Flight f10;
	private Flight f11;
	private Flight f12;
	private ItineraryGenerator gen;
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
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new Client("Smith", "J", infocentre, "jsmithj@somewhere.com", "77 Huron St",new Long("1234122412341234"), "2018-09-07");
		c2 = new Client("Jones", "D", infocentre, "jonesd@somewhere.com", "123 Elm St", new Long("5427633254325432"), "2019-11-23");
		c3 = new Client("Sam", "J", infocentre, "samj@somewhere.com", "23 Gerrad St", new Long("6432543258263832"), "2020-12-03");
		c4 = new Client("Diane", "H", infocentre, "dianeh@somewhere.com", "1101 Bay St", new Long("3432543209183632"), "2019-01-30");
		c5 = new Client("Jonathan", "B", infocentre, "jonb@somewhere.com", " 187 Wilcock St", new Long("543253825325432"), "2021-05-01");
		a1 = new Admin("Chris", "C", infocentre, "chrisc@somewhere.com");
		a2 = new Admin("Peter", "N", infocentre, "petern@somewhere.com");
		a3 = new Admin("Felicia", "D", infocentre, "feliciad@somewhere.com");
		a4 = new Admin("Dan", "H", infocentre, "danh@somewhere.com" );
		a5 = new Admin("Will", "W", infocentre, "willw@somewhere.com");
		//number, departuredatetime, arrivaldatetime, ariline, origin, destination, price
		f1 = new Flight(23451, "2015-11-03 01:31", "2015-11-03 03:12", "csc", "Toronto","Rome",1234.56,10);
		f2 = new Flight(23451, "2015-11-03 03:23", "2015-11-03 04:12","csc","Rome","London",123.55,10);
		f3 = new Flight(23451, "2015-11-03 02:21", "2015-11-03 03:00","csc","Toronto","Rome",124.56,10);
		f4 = new Flight(23451, "2015-11-03 09:04", "2015-11-03 11:00","csc","Rome","London", 234.6,10);
		f5 = new Flight(23451, "2015-11-07 05:33", "2015-11-07 07:45","csc","Toronto","Rome", 134.56,10);
		f6 = new Flight(23451, "2015-11-07 09:31", "2015-11-08 01:12","csc","Rome","London", 23.5,10);
		f7 = new Flight(23451, "2015-11-11 01:31", "2015-11-11 03:12", "csc", "Toronto","Rome",1234.56,10);
		f8 = new Flight(23451, "2015-11-11 02:23", "2015-11-11 04:12","csc","Rome","London",123.55,10);
		f9 = new Flight(23451, "2015-11-11 03:21", "2015-11-11 06:12","csc","Rome","London",124.56,10);
		f10 = new Flight(23451, "2015-11-03 05:41", "2015-11-03 08:12","csc","London","Orlando", 234.6,10);
		f11 = new Flight(23451, "2015-11-03 08:31", "2015-11-07 10:45","csc","Orlando","Paris", 134.56,10);
		f12 = new Flight(23451, "2015-11-11 23:31", "2015-11-12 03:12","csc","Toronto","London", 23.5,10);
		
		
		
		infocentre.AddAdmin(a1);
		infocentre.AddAdmin(a2);
		infocentre.AddAdmin(a3);
		infocentre.AddAdmin(a4);
		infocentre.AddAdmin(a5);
		
		infocentre.AddClient(c1);
		infocentre.AddClient(c2);
		infocentre.AddClient(c3);
		infocentre.AddClient(c4);
		infocentre.AddClient(c5);
		infocentre.AddFlight(f1);
		infocentre.AddFlight(f2);
		infocentre.AddFlight(f3);
		infocentre.AddFlight(f4);
		infocentre.AddFlight(f5);
		infocentre.AddFlight(f6);
		infocentre.AddFlight(f7);
		infocentre.AddFlight(f8);
		infocentre.AddFlight(f9);
		infocentre.AddFlight(f10);
		infocentre.AddFlight(f11);
		infocentre.AddFlight(f12);

		gen = new ItineraryGenerator(infocentre.allFlights(infocentre.getFlights()));
	}


	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	

	/**
	 * Test method for {@link driver.ItineraryGenerator#listAllItineraries(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testListAllItineraries() {
		/*
		 * Test for more then 6 hour wait time and multiple paths 
		 * to same place
		 */
		ArrayList<Itinerary>temp = gen.listAllItineraries("Toronto", "London",
				"2015-11-03");
		for(Itinerary i :temp){
			assertEquals("Toronto",i.getOrigin());
			assertEquals("London",i.getDestination());
			assertEquals( "2015-11-03",i.getDepartureDateAsStr());
			
			//test fails if previous flight is after subsequent flight 
			//since get wait times would not work
			for(int j :i.getWaitTimes()){
				assertTrue(j<60*6);
			}
		assertEquals( 3,gen.listAllItineraries("Toronto", "London", 
				"2015-11-03").size());
		/*
		 * Test for that itinerarygenerator does not allow connecting flights
		 * that are before the previous flight and also 
		 * tests for over midnight flights.
		 */
			
		}
		temp = gen.listAllItineraries("Toronto", "London", "2015-11-11");
		for(Itinerary i :temp){
			assertEquals("Toronto",i.getOrigin());
			assertEquals("London",i.getDestination());
			assertEquals( "2015-11-11",i.getDepartureDateAsStr());
			
			//Test fails if previous flight is after subsequent flight 
			//since get wait times would not work
			for(int j :i.getWaitTimes()){
				assertTrue(j<60*6);
			}
		assertEquals(2,temp.size());
			
		}
		/*
		 * Test for beyond 2 connecting flights
		 */
		
		for(Itinerary i :gen.listAllItineraries("Toronto", "Paris", 
				"2015-11-03")){
			assertEquals("Toronto",i.getOrigin());
			assertEquals("Paris",i.getDestination());
			assertEquals( "2015-11-03",i.getDepartureDateAsStr());
			
			//test fails if previous flight is after subsequent flight 
			//since get wait times would not work
			for(int j :i.getWaitTimes()){
				assertTrue(j<60*6);
			}
		}
		assertEquals( 2,gen.listAllItineraries("Toronto", "Paris", "2015-11-03").size());
		
	}

}
