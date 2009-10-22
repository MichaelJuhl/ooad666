package dal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event  {


	protected int EventID;                     
	protected String Concerttype;                
	protected String Stage;  
	protected Date DateStart;
	protected Date DateFinish;
	protected String Artist;                 
	protected String Titel;
	protected double Price;		
	protected int Visitors;
	protected int TicketsSold;
	protected double SHOW;
	protected double NORMAL;
	protected DateFormat dateFormat;	

	public Event(int EventID, String Concerttype, String Stage, String DateStart, String DateFinish, String Artist, String Titel, 
			double Price, int Visitors, int TicketsSold, double SHOW, double NORMAL) throws ParseException
	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.EventID = EventID;
		this.Concerttype = Concerttype;
		this.Stage = Stage;
		this.DateStart = dateFormat.parse(DateStart);
		this.DateFinish = dateFormat.parse(DateFinish);
		this.Artist = Artist;
		this.Titel = Titel;
		this.Price = Price;
		this.Visitors = Visitors;
		this.TicketsSold = TicketsSold;
		this.SHOW = SHOW;
		this.NORMAL = NORMAL;

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
		return dateFormat.format(DateStart);
	}

	public void setDateStart(String dateStart) throws ParseException {
		DateStart = dateFormat.parse(dateStart);
	}

	public String getDateFinish() {
		return dateFormat.format(DateFinish);
	}

	public void setDateFinish(String dateFinish) throws ParseException {
		DateFinish = dateFormat.parse(dateFinish);
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

	public int getTicketsSold() {
		return TicketsSold;
	}

	public void setTicketsSold(int ticketsSold) {
		TicketsSold = ticketsSold;
	}

	public double getSHOW() {
		return SHOW;
	}

	public void setSHOW(double sHOW) {
		SHOW = sHOW;
	}

	public double getNORMAL() {
		return NORMAL;
	}

	public void setNORMAL(double nORMAL) {
		NORMAL = nORMAL;
	}

	
}
