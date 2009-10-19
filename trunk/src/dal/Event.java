package dal;

public class Event {

	int EventID;                     
	protected String Concerttype;                
	protected String Stage;                 
	protected String Artist;                 
	protected String Titel;
	protected String Price;		
	protected String Visitors;
	protected String DiscountSHOW;
	protected String DiscoutNORM;
	

	public Event(int EventID, String Concerttype, String Stage, String Artist, String Titel, String Price, String Visitors
			,String DiscountSHOW, String DiscountNORM)
	{
		this.EventID = EventID;
		this.Concerttype = Concerttype;
		this.Stage = Stage;
		this.Artist = Artist;
		this.Titel = Titel;
		this.Price = Price;
		this.Visitors = Visitors;
		this.DiscountSHOW = DiscountSHOW;
		this.DiscoutNORM = DiscountNORM;
	}
	
	public Event(){
		
	}
	
	public int getEventID() {
		return EventID;
	}
	public void setEventID(int eventID) {
		EventID = eventID;
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
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getVisitors() {
		return Visitors;
	}
	public void setVisitors(String visitors) {
		Visitors = visitors;
	}
	public String getDiscountSHOW() {
		return DiscountSHOW;
	}
	public void setDiscountSHOW(String discountSHOW) {
		DiscountSHOW = discountSHOW;
	}
	public String getDiscoutNORM() {
		return DiscoutNORM;
	}
	public void setDiscoutNORM(String discoutNORM) {
		DiscoutNORM = discoutNORM;
	}

	
}
