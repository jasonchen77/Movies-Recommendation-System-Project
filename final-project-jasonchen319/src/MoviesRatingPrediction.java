import java.util.ArrayList;
import java.util.HashMap;

public class MoviesRatingPrediction {

	MoviesAndRatingsParsing parse = new MoviesAndRatingsParsing();
	HashMap<Integer, String> movies = parse.parseMovies();
	HashMap<Integer, HashMap<Integer, Integer>> ratings = parse.parseRatings();
	MoviesSimilarity ms = new MoviesSimilarity();
	double[][] moviesSimilarity = ms.similarity();
	
	
	//Calculate rating predictions
	public HashMap<Integer, HashMap<Integer, Double>> ratingPrediction() {
		
		HashMap<Integer, HashMap<Integer, Double>> ratingPred = new HashMap<Integer, HashMap<Integer, Double>>();
		
		//Loop through each user
		for(int user = 1; user <= ratings.size(); user++) {
			
			ratingPred.put(user, new HashMap<Integer, Double>());
			ArrayList<Integer> moviesRated = new ArrayList<Integer>();
			ArrayList<Integer> moviesNotRated = new ArrayList<Integer>();
			
			//Loop through each movie of the user and add movies not rated and movies rated
			//to ArrayLists 
			for(int movie = 1; movie <= movies.size(); movie++) {
				if(ratings.get(user).get(movie)==null) {
					moviesNotRated.add(movie);
				}
				else {
					moviesRated.add(movie);
				}
			}
			//Calculates the rating prediction
			for(int moviesNotRatedIndex = 0; moviesNotRatedIndex < moviesNotRated.size(); moviesNotRatedIndex++) {
				double numerator = 0;
				double denominator = 0;
				double result = 0;
				for(int moviesRatedIndex = 0; moviesRatedIndex < moviesRated.size(); moviesRatedIndex++) {
					numerator += (ratings.get(user).get(moviesRated.get(moviesRatedIndex)) * 
							moviesSimilarity[moviesNotRated.get(moviesNotRatedIndex)][moviesRated.get(moviesRatedIndex)]);
					denominator += moviesSimilarity[moviesNotRated.get(moviesNotRatedIndex)][moviesRated.get(moviesRatedIndex)];
				}
				result = numerator/denominator;
				ratingPred.get(user).put(moviesNotRated.get(moviesNotRatedIndex), result);
			}
		}
		return ratingPred;
	}
}
