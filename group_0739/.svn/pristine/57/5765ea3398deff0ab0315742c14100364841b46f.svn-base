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

import pII.Admin;
import pII.Client;
import pII.Flight;
import pII.Infocentre;
import pII.InvalidInputException;

/**
 * @author Darshan
 *
 */
public class AdminTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
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
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception{
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
		f1 = new Flight(23451, "2015-11-03 01:31", "2015-11-03 03:12", "csc", "here1","there1",1234.56);
		f2 = new Flight(23451, "2015-11-04 01:23", "2015-11-04 04:12","csc","here2","there2",123.55);
		f3 = new Flight(23451, "2015-11-05 02:21", "2015-11-05 06:12","csc","here3","there3",124.56);
		f4 = new Flight(23451, "2015-11-06 02:41", "2015-11-06 08:12","csc","here4","there4", 234.6);
		f5 = new Flight(23451, "2015-11-07 01:31", "2015-11-07 07:45","csc","here5","there5", 134.56);
		f6 = new Flight(23451, "2015-11-10 23:31", "2015-11-11 03:12","csc","here6","there6", 23.5);
		
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

	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}
    
	@Test
	public void testEditClientInfo(){
		//c1.setEmail("jsmith@somewhere.com");
		a1.editClientInfo(c1, "email", "dash@g.com");
		assertEquals("dash@g.com", c1.getEmail());
	}
	
	@Test
	public void testConstructor() throws NumberFormatException, InvalidInputException{
		Admin a20 = new Admin("D","B",a1.getInfoCentre(),"db@gmail.com");
		assertTrue(infocentre.getAdmins().contains(a20));
	}
	@Test
	public void testRemoveFlight(){
		a1.removeFlight(f1);
		assertFalse(infocentre.getFlights().containsValue(f1));
		
	}
	@Test
	public void addClient() throws NumberFormatException, InvalidInputException{
		Client c6 = new Client("Jon", "B", infocentre, "jonb@somewhere.com", " 187 Wilcock St", new Long("543253825325432"), "2021-05-01");
		a1.addClient(c6);
		assertTrue(infocentre.getClients().contains(c6));
	}
	@Test
	public void testingEditClientInfoInt(){
		a1.editClientInfo(c3, "creditcardno", 246455554);
		assertEquals(246455554, c3.getCreditCardNumber());
	}
	
	@Test
	public void testEditClientInfoException(){
		//c1.setEmail("jsmith@somewhere.com");
		Throwable t = null;
		try {
			a1.editClientInfo(new Client("Jasdes", "D", infocentre, "jonesd@asdewhere.com", "123 Elm St", new Long("5427633254325432"), "2019-11-23"), "email", "dash@g.com");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			t = e;
			assertNotNull(t);
			assertSame(InvalidInputException.class, t.getClass());
		}
		
	}

}
