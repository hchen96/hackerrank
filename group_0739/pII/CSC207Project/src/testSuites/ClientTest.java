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
import pII.InvalidInputException;
import pII.Itinerary;

public class ClientTest {
	
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
	private Client c1;
	private Client c2; 
	private Infocentre infocentre = new Infocentre();
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
	private ArrayList<Itinerary> i;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
	c1 = new Client("Smith", "John", infocentre, "jsmith@somewhere.com", "77 Huron St", 1234123412341234L, "2018-09-07");
	c2 = new Client("Jones", "James", infocentre, "jjones@somewhere.com", "123 Elm St", 9999999999999999L, "2019-11-23");
	f1 = new Flight(23451, "2015-11-03 01:31", "2015-11-03 03:12", "csc", "here1","there1",1234.56);
	f2 = new Flight(23451, "2015-11-04 01:23", "2015-11-04 04:12","csc","here2","there2",123.55);
	f3 = new Flight(23451, "2015-11-05 02:21", "2015-11-05 06:12","csc","here3","there3",124.56);
	f4 = new Flight(23451, "2015-11-06 02:41", "2015-11-06 08:12","csc","here4","there4", 234.6);
	f5 = new Flight(23451, "2015-11-07 01:31", "2015-11-07 07:45","csc","here5","there5", 134.56);
	f6 = new Flight(23451, "2015-11-10 23:31", "2015-11-11 03:12","csc","here6","there6", 23.5);
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
	public void testHashCode() {
		//not testable...
	}

	@Test
	public void testClient() {
		//checking if expirydate is valid
		try{
			if(c1.getExpiryDate().length() < 10) {
		        throw new InvalidInputException("Input is less than required length");
			} else if(c1.getExpiryDate().length() > 10){
		        throw new InvalidInputException("Input is more than required length");
		    } else if(c1.getExpiryDate().length() == 10){
		    	//more shit 
		    	 
		    }
		} catch(InvalidInputException e){
			//insert meaningful message
		}
		
	}

	@Test
	public void testGetEmail() {
		//c1.setEmail("jsmith@somewhere.com");
		assertEquals("jsmith@somewhere.com", c1.getEmail());
	}

	@Test
	public void testSetEmail() {
		c1.setEmail("jsmith@somewhere.com");
		assertEquals("jsmith@somewhere.com", c1.getEmail());
	}

	@Test
	public void testGetAddress() {
		//c1.setEmail("jsmith@somewhere.com");
		assertEquals("77 Huron St", c1.getAddress());
	}

	@Test
	public void testSetAddress() {
		c1.setAddress("77 Huron St");
		assertEquals("77 Huron St", c1.getAddress());
	}

	@Test
	public void testGetCreditCardNumber() {
		//c1.setEmail("");

		assertEquals((1234123412341234L), c1.getCreditCardNumber());
	}

	@Test
	public void testSetCreditCardNumber() {

		c1.setCreditCardNumber(1234123412341234L);
		assertEquals((1234123412341234L) , c1.getCreditCardNumber());

	}

	@Test
	public void testGetFilter() {
		assertEquals("jsmith@somewhere.com", c1.getEmail());
		
	}

	@Test
	public void testSetFilter() {
		//test if the filter is a String 
		boolean asserttest = false;
		if(c1.getFilter() instanceof String){
			asserttest = false;
		}
	}

	@Test
	public void testGetExpiryDate() {
		assertEquals("2018-09-07", c1.getExpiryDate());
	}

	@Test
	public void testSetExpiryDate() {
		boolean asserttest = false;
		try{
			if(c1.getExpiryDate().length() > 10) {
				throw new InvalidInputException("Input exceeds required length");
			}else if(c1.getExpiryDate().length() < 10){
			    throw new InvalidInputException("Input is less than required length");
			}else if(c1.getExpiryDate().length() == 10){
		        // input is of type String assertEquals()
				asserttest = true;
			}		
		} catch(InvalidInputException e){
			//insert meaningful message
		}
	}

	@Test
	public void testBookItinerary() {
		//want to test if the function actually adds an Itinerary
		//See if the itinerary added is actually valid
		//needs an itinerary to test
		assertNotNull(it1); //itinerary must be not null
		boolean asserttest = false;
		if(it1 instanceof Itinerary){  //object must 
		    asserttest = true;
		}
		
	}
// 
	@Test
	public void testGetBookedItineraries() {
		//test if all elements are itineraries
		boolean asserttest = false;
		for(int i = 0; i < c1.getBookedItineraries().size(); i++){
			 if(c1.getBookedItineraries().get(i) instanceof Itinerary){
				 asserttest = true;
			 }
		}
	}

	@Test
	public void testSearchForItinerary() {
		//implement later
	}

	@Test
	public void testDisplaySortedItineraries() {
		//test if the returned ArrayList<Itinerary> actually returns a sorted ArrayList<Itinerary>
		boolean asserttest = false;
		assertEquals(c1.getFilter(), "cost");
		assertEquals(c1.getFilter(), "travel time");
		i = new ArrayList<Itinerary>();
		i.add(it1);
		i.add(it2);
		i.add(it3);
		
		if(c1.getFilter().equals("cost")){
			for (int c = 0; c < ( i.size() - 1 ); c++) {
				for (int d = 0; d < i.size() - c - 1; d++) {
					if (i.get(d).getTotalCost() > i.get(d + 1).getTotalCost()){ 
						assertNotNull(it1);
						assertNotNull(it2);
						assertNotNull(it3);
						assertEquals(i.get(0), it1);
						assertEquals(i.get(1), it2);
						assertEquals(i.get(2), it3);
						Itinerary swap = i.get(d);
						assertEquals(i.get(d), it1);
						i.set(d, i.get(d + 1));
						assertNotNull(i.get(d));
						assertNotNull(i.get(d+1));
						i.set(d+1, swap);
					}
			     }
		     }
		} else {
			for (int j = 0; j < ( i.size() - 1 ); j++) {
				for (int g = 0; g < i.size() - j - 1; g++) {
					if (i.get(g).getTotalTraveTime() > i.get(g+ 1).getTotalTraveTime()){ 
						assertNotNull(it1);
						assertNotNull(it2);
						assertNotNull(it3);
						assertEquals(i.get(0), it1);
						assertEquals(i.get(1), it2);
						assertEquals(i.get(2), it3);
						Itinerary swap = i.get(g);
						assertEquals(i.get(g), it1);
						i.set(g, i.get(g + 1));
						assertNotNull(i.get(g));
						assertNotNull(i.get(g+1));
						i.set(g+1, swap);
					}
		     }
		}
		asserttest = true;	
		
		
	}
	}
}