
public class MovieObject {

	private int movieID;
	private String movieTitle;
	
	public MovieObject(int movieID, String movieTitle) {
		this.movieID = movieID;
		this.movieTitle = movieTitle;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	
}
