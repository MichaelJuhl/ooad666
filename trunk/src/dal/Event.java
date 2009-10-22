package dal;

public class Event  {


	protected int EventID;                     
	protected String Concerttype;                
	protected String Stage;  
	protected String DateStart;
	protected String DateFinish;
	protected String Artist;                 
	protected String Titel;
	protected double Price;		
	protected int Visitors;

	

	public Event(int EventID, String Concerttype, String Stage, String Artist, String DateStart, String DateFinish, String Titel, 
			double Price, int Visitors)
	{
		this.EventID = EventID;
		this.Concerttype = Concerttype;
		this.Stage = Stage;
		this.DateStart = DateStart;
		this.DateFinish = DateFinish;
		this.Artist = Artist;
		this.Titel = Titel;
		this.Price = Price;
		this.Visitors = Visitors;

	}
	
	public Event(){
		
	}
	
	public int getEventID() {
		return EventID;
	}
	
	public String getConcerttype() {
		return Concerttype;
	}

	public void setConcerttype(String concerttype) {
		Concerttype = concerttype;
	}

	public String getStage() {
		return Stage;
	}

	public void setStage(String stage) {
		Stage = stage;
	}

	public String getDateStart() {
		return DateStart;
	}

	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}

	public String getDateFinish() {
		return DateFinish;
	}

	public void setDateFinish(String dateFinish) {
		DateFinish = dateFinish;
	}

	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}

	public String getTitel() {
		return Titel;
	}

	public void setTitel(String titel) {
		Titel = titel;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getVisitors() {
		return Visitors;
	}

	public void setVisitors(int visitors) {
		Visitors = visitors;
	}


	public void setEventID(int eventID) {
		EventID = eventID;
	}

}
