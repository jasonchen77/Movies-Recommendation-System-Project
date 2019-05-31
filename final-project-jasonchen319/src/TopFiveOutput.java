import java.io.PrintWriter;
import java.util.HashMap;

public class TopFiveOutput {
	
	TopFiveRecommendations tfr = new TopFiveRecommendations();
	HashMap<Integer, int[]> tfrArray = tfr.topFiveRecom();
	MoviesAndRatingsParsing parse = new MoviesAndRatingsParsing();
	HashMap<Integer, String> movies = parse.parseMovies();
	MoviesRatingPrediction mrp = new MoviesRatingPrediction();
	HashMap<Integer, HashMap<Integer, Double>> ratingPredictions = mrp.ratingPrediction();
	
	//create a file and output the results
	public void topFiveOutput() {
		try {
			PrintWriter writer = new PrintWriter("TopFiveMoviesRecommendation.txt", "UTF-8");
	
			for(Integer user:tfrArray.keySet()) {
				
				writer.println("user ID: " + user + " top 5 recommendations: " + 
						((tfrArray.get(user).length > 0) ? ((movies.get(tfrArray.get(user)[0])) 
							+ "::" + ratingPredictions.get(user).get(tfrArray.get(user)[0])) : " ") + " " +
						((tfrArray.get(user).length > 1)? ((movies.get(tfrArray.get(user)[1])) 
							+ "::" + ratingPredictions.get(user).get(tfrArray.get(user)[1])) : " ") + " " +	
						((tfrArray.get(user).length > 2)? ((movies.get(tfrArray.get(user)[2])) 
							+ "::" + ratingPredictions.get(user).get(tfrArray.get(user)[2])) : " ") + " " +
						((tfrArray.get(user).length > 3)? ((movies.get(tfrArray.get(user)[3])) 
							+ "::" + ratingPredictions.get(user).get(tfrArray.get(user)[3])) : " ") + " " +
						((tfrArray.get(user).length > 4)? ((movies.get(tfrArray.get(user)[4])) 
							+ "::" + ratingPredictions.get(user).get(tfrArray.get(user)[4])) : " ") 
						);
			}
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
