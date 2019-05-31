import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MoviesSimilarity {
	
	MoviesAndRatingsParsing parse = new MoviesAndRatingsParsing();
	HashMap<Integer, String> movies = parse.parseMovies();
	HashMap<Integer, HashMap<Integer, Integer>> ratings = parse.parseRatings();
	
	public double[][] similarity() {

		double[][] moviesSimilarityArray = new double[movies.size()+1][movies.size()+1];
		double[][] comparisonArray = new double[movies.size()+1][2];
		for(int movie = 1; movie <= movies.size(); movie++) {
			//get comparison movie 1 ratings
			for(int user = 1; user <= ratings.size(); user++) {
				if(ratings.get(user).get(movie)==null) {
					comparisonArray[user][0] = 0;
				}
				else {
					comparisonArray[user][0] = ratings.get(user).get(movie);
				}
			}
			//get comparison movie 2 ratings
			for(int compareToMovie = 1; compareToMovie <= movie; compareToMovie++) {
				for(int user = 1; user <= ratings.size(); user++) {
					if(ratings.get(user).get(compareToMovie)==null) {
						comparisonArray[user][1] = 0;
					}
					else {
						comparisonArray[user][1] = ratings.get(user).get(compareToMovie);
					}
				}
				//calculate the similarity
				double numerator =  0;
				double denominator1 = 0;
				double denominator2 = 0;
				double denominator = 0;
				double result = 0;
				for(int i = 1; i <= movies.size(); i++) {
					numerator += (comparisonArray[i][0]*comparisonArray[i][1]);
					denominator1 += (comparisonArray[i][0]*comparisonArray[i][0]);
					denominator2 += (comparisonArray[i][1]*comparisonArray[i][1]);
				}
				denominator = Math.sqrt(denominator1) * Math.sqrt(denominator2);
				result = numerator/denominator;
				moviesSimilarityArray[movie][compareToMovie] = result;
			}
		}
		
		//Copy lower half of the Array to upper half
		for (int movie = 1; movie <= movies.size(); movie++) {
			for (int compareToMovie = movie; compareToMovie <= movies.size(); compareToMovie++) {
				moviesSimilarityArray[movie][compareToMovie] = moviesSimilarityArray[compareToMovie][movie];
			}
		}
			
		return moviesSimilarityArray;
	}

}
