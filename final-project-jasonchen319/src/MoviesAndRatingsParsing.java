import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class MoviesAndRatingsParsing {

	//Parse the movies.dat file and store the data in a HashMap
	public HashMap<Integer, String> parseMovies(){
		HashMap<Integer, String> moviesHM = new HashMap<Integer, String>();
		
		try {
			File file = new File("movies.dat");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				String[] line = sc.nextLine().split("\\|");
				moviesHM.put(Integer.parseInt(line[0]), line[1]);
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return moviesHM;
		
	}
	
	//Parse the ratings.dat file and store the data in a nested HashMap
	public HashMap<Integer, HashMap<Integer, Integer>> parseRatings() {
		RatingObject ro;
		HashMap<Integer, HashMap<Integer, Integer>> ratingHM = new HashMap<Integer, HashMap<Integer, Integer>>();
		
		try {
			File file = new File("ratings.dat");
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				String[] line = sc.nextLine().split("\\s");
				ro = new RatingObject(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
				//Check if ro.getUserID already been created
				if(ratingHM.containsKey(ro.getUserID())) {
					ratingHM.get(ro.getUserID()).put(ro.getMovieID(), ro.getRating());
				}
				else {
					ratingHM.put(ro.getUserID(), new HashMap<Integer, Integer>());
					ratingHM.get(ro.getUserID()).put(ro.getMovieID(), ro.getRating());
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return ratingHM;
	}
	
}
