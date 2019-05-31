import java.util.ArrayList;
import java.util.HashMap;

public class TopFiveRecommendations {
	
	MoviesRatingPrediction mrp = new MoviesRatingPrediction();
	HashMap<Integer, HashMap<Integer, Double>> ratingPredictions = mrp.ratingPrediction();
	
	//Get the top five recommendations
	public HashMap<Integer, int[]> topFiveRecom() {
		HashMap<Integer, int[]> topFive = new HashMap<Integer, int[]>();
		
		//Loop through each user
		for(Integer user:ratingPredictions.keySet()) {
			double max1 = 0;
			double max2 = 0;
			double max3 = 0;
			double max4 = 0;
			double max5 = 0;
			int ratingPredUserSize = ratingPredictions.get(user).size();
			topFive.put(user, new int[ratingPredUserSize]);
			
			//Find the top movie
			if(ratingPredUserSize > 0) {
				for (Integer movie:ratingPredictions.get(user).keySet()) {
					if(ratingPredictions.get(user).get(movie) > max1) {
						max1 = ratingPredictions.get(user).get(movie);
						topFive.get(user)[0] = movie;
					}		
				}
			}
			
			//Find the top 2nd
			if(ratingPredUserSize > 1) {
				for (Integer movie:ratingPredictions.get(user).keySet()) {
					if(ratingPredictions.get(user).get(movie) > max2 && 
							ratingPredictions.get(user).get(movie) <= max1 &&
							movie != topFive.get(user)[0]) {
						max2 = ratingPredictions.get(user).get(movie);
						topFive.get(user)[1] = movie;
					}		
				}
			}
			
			//Find the top 3rd
			if(ratingPredUserSize > 2) {
				for (Integer movie:ratingPredictions.get(user).keySet()) {
					if(ratingPredictions.get(user).get(movie) > max3 && 
							ratingPredictions.get(user).get(movie) <= max2 &&
							movie != topFive.get(user)[0] &&
							movie != topFive.get(user)[1]) {
						max3 = ratingPredictions.get(user).get(movie);
						topFive.get(user)[2] = movie;
					}		
				}
			}
			
			//Find the top 4th
			if(ratingPredUserSize > 3) {
				for (Integer movie:ratingPredictions.get(user).keySet()) {
					if(ratingPredictions.get(user).get(movie) > max4 && 
							ratingPredictions.get(user).get(movie) <= max3 &&
							movie != topFive.get(user)[0] &&
							movie != topFive.get(user)[1] &&
							movie != topFive.get(user)[2]) {
						max4 = ratingPredictions.get(user).get(movie);
						topFive.get(user)[3] = movie;
					}		
				}
			}
			
			//Find the top 5th
			if(ratingPredUserSize > 4) {
				for (Integer movie:ratingPredictions.get(user).keySet()) {
					if(ratingPredictions.get(user).get(movie) > max5 && 
							ratingPredictions.get(user).get(movie) <= max4 &&
							movie != topFive.get(user)[0] &&
							movie != topFive.get(user)[1] &&
							movie != topFive.get(user)[2] &&
							movie != topFive.get(user)[3]) {
						max5 = ratingPredictions.get(user).get(movie);
						topFive.get(user)[4] = movie;
					}		
				}
			}
		}
		return topFive;
	}
	
}
