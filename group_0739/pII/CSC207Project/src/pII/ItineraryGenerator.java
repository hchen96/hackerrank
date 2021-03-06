package pIII;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author group_0739
 * This class is responsible for generating all the possible flight paths from
 * origin to destination given a departure date.  After finding all the paths
 * this class is also responsible for making each path into an itinerary.
 *
 */
public class ItineraryGenerator {
	


	
	/**
	 * All the paths from origin to destination.
	 */
	private List<String> flightPaths = new ArrayList<String>(); 
	
	/**
	 * A list of flights based on flightPaths.
	 */
	private ArrayList<ArrayList<Flight>> flights 
	= new ArrayList<ArrayList<Flight>>(); 
	
	/**
	 *A directed graph of all the flights.
	 */
	private DirectedGraph<String> searchGraph = new DirectedGraph<String>(); 
	
	
	/**
	 * All the flights in the system.
	 */
	private ArrayList<Flight> allFlights = new ArrayList<Flight>(); 
	

	/**
	 * a temporary list that keeps track of the flight paths.
	 */
	private ArrayList<Flight> itineraryflight = new ArrayList<Flight>(); 

	/**
	 * ItineraryGenerator constructor creates a new itinerary generator.
	 * @param flights 	Flights to be searched when creating itineraries.
	 */
	public ItineraryGenerator(ArrayList<Flight> flights){
		this.allFlights = flights;
		//Populate Directed graph with all the data from infocentre.
		for(Flight f: this.allFlights){
	
			this.searchGraph.add(f.getOrigin());
			this.searchGraph.add(f.getDestination());
			this.searchGraph.addEdge(f.getOrigin(), f.getDestination());	
		}
	
	}
	/**
	 * Helper function
	 * Searches Arraylist of itinerary and removes all invalid itineraries.
	 * Can be edited to remove more cases. 
	 *
	 * @param toBeCleaned The list of itinerary to be cleaned
	 */
	private void FilterOutItinerary(ArrayList<Itinerary> toBeCleaned, 
			String date) {
		ArrayList<Itinerary> temp = new ArrayList<Itinerary>();
		for(Itinerary i :toBeCleaned){
			for(Flight f :i.getFlights()){
				if (f.getNumSeats()==0){
					temp.add(i);
				}
			}
			for(int j=0; j < i.getFlights().size()-1 ; j++){
				long time 
				= i.getFlights().get(j+1).getDepartureDateTime().getTimeInMillis() 
						- i.getFlights().get(j).getArrivalDateTime().getTimeInMillis() ;
				
				//Remove all itineraries with invalid waiting times.
				if( time > 6*1000*60*60 || time<0){
					temp.add(i);
				}
			}
			//Remove all itineraries that is not of the dates we want
			if(!i.getDepartureDateAsStr().equals(date)){
				temp.add(i);
			}
		}
		for(Itinerary i : temp){
			toBeCleaned.remove(i);
		}
		
	}
	
	/**
	 * Helper Function
	 * Adds all possible iterations of Flights based on given flight path 
	 * which is a list of cities the the flights have to go through.
	 * MUST take in valid flight path, flight path has to have at least 
	 * 1 possible iteration from the given list of flights.
	 * Function listAllItineraries where this helper is used handles 
	 * the valid flight path input.
	 * @param flightpath 	Valid flight path - a list of cities 
	 * 						an itinerary has to pass through in order.
	 */
	private void FlightBasedOnPath(List<String> flightpath) {
	//recurse through all flights and create different combinations of flights
		if (flightpath.size()>1){
			//continue recursion as long as there are still flights not added 
			//based on flight paths  
			for(Flight f :allFlights){
				
				if(f.getOrigin().equals(flightpath.get(0)) 
						&& f.getDestination().equals(flightpath.get(1))){
					
					itineraryflight.add(f);
					//Add Flight to temporary list.
					FlightBasedOnPath((List<String>) flightpath.subList(1, 
							flightpath.size()));
					//Clean up temporary list for subsequent recursion.
					itineraryflight.remove(itineraryflight.size()-1);
				}	
			}
			
			}else{
				
				@SuppressWarnings("unchecked")
				ArrayList<Flight> c 
				= (ArrayList<Flight>) itineraryflight.clone();
				if (!flights.contains(c)){
					flights.add(c);
				}
			}			
	}
	/**
	 * Helper Function
	 * Recurses through the graph and creates a list of 
	 * all possible itineraries.
	 * Given origin and destination with no regard for any other factors.
	 * @param origin 	A string representing the city of origin for 
	 * 					itineraries to be listed.
	 * @param destination 	A string representing the destination 
	 * 						city for itineraries to be listed.
	 * 
	 */
	private void recurseItineraries(String origin, String destination){
		
		//Add flight path to flightpaths
		flightPaths.add(origin);
		if(origin.equals(destination)){
			//Escape   recursion only ends when origin = destination.
			//List of Flights are created based on the flight path.
			FlightBasedOnPath(flightPaths);
							
		}
		//Add and travel one more city down and continue recursion
		else{for(String o: searchGraph.getNeighbours(origin)){
				if(!flightPaths.contains(o)){
					recurseItineraries(o, destination);
				}
			}
		}
		//Clean up flightpaths for subsequent recursions
		flightPaths.remove(flightPaths.size() - 1);
		
		
		
	}
	
	/**
	 * Searches through all the flights and provides all possible flight 
	 * combinations from origin to destination
	 * regardless of departure date time or any factor.
	 * @param origin 	City of origin of itinerary.
	 * @param destination 	Destination city of itinerary.
	 * @return 	An ArrayList of all possible itineraries.
	 */
	public ArrayList<Itinerary> listAllItineraries(String origin, 
			String destination, String date){
		ArrayList<Itinerary> allItineraries = new ArrayList<Itinerary>();
		//Make sure working flights instance is clean before next run.
		flights.clear();
		
		//Recurse through all flights and create all possible itineraries
		recurseItineraries(origin,destination);
		
		//Add to new list.
		for(ArrayList<Flight> aF : flights){
			Itinerary i = new Itinerary(aF);
			allItineraries.add(i);
			
		}
		//Clean and filter all unwanted and invalid itineraries.
		FilterOutItinerary(allItineraries,date);
	
		return allItineraries;
		
	}
	
	





}
