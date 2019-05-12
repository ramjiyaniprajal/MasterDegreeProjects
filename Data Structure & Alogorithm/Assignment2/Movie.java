public class Movie {

	private String movieName; // Indicate the movie name
	private String leadActor; // Indicate lead actor
	private String leadActress; // Indicate lead actress
	private String theaterName; // Indicate theater Name
	private double ticketPrice; // Indicate ticket price

	
	//Default constructor
	public Movie() {

	}

	// Below are getter and setter method used to give and set variables of this method.
	
	public String getMovieName() {
		return movieName;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public String getLeadActress() {
		return leadActress;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	public void setLeadActress(String leadActress) {
		this.leadActress = leadActress;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	// to String method to view content inside the object.
	@Override
	public String toString() {
		return "Movie [leadActor=" + leadActor + ", leadActress=" + leadActress + ", movieName=" + movieName
				+ ", theaterName=" + theaterName + ", ticketPrice=" + ticketPrice + "]";
	}

}
