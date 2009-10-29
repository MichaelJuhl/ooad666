package dal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Event  {


	protected int eventID;                     
	protected String concertType;                
	protected String Stage;  
	protected Calendar dateStart = new GregorianCalendar(new Locale("da","DK"));
	protected Calendar dateFinish = new GregorianCalendar(new Locale("da","DK"));
	protected String artist;                 
	protected String titel;
	protected double price;		
	protected int maxVisitors;
	protected int ticketsSold;
	protected double showDiscount;
	protected double portalisDiscount;
	protected DateFormat dateFormat;	

	//Constructor for building Event objects from information from the database
	public Event(int eventID, String concertType, String Stage, String dateStart, String dateFinish, String artist, String titel, 
			double price, int maxVisitors, int ticketsSold, double showDiscount, double portalisDiscount) throws ParseException
	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.eventID = eventID;
		this.concertType = concertType;
		this.Stage = Stage;
		this.dateStart.setTime(dateFormat.parse(dateStart));
		this.dateFinish.setTime(dateFormat.parse(dateFinish));
		this.artist = artist;
		this.titel = titel;
		this.price = price;
		this.maxVisitors = maxVisitors;
		this.ticketsSold = ticketsSold;
		this.showDiscount = showDiscount;
		this.portalisDiscount = portalisDiscount;
	}
	
	//Constructor for creating a new Event from the GUI to send to the database 
	public Event(String concertType, String Stage, Calendar dateStart, Calendar dateFinish, String artist, String titel, 
			double price, int maxVisitors, double showDiscount, double portalisDiscount) throws ParseException
	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.eventID = 12345;
		this.concertType = concertType;
		this.Stage = Stage;
		this.dateStart = dateStart;
		this.dateFinish = dateFinish;
		this.artist = artist;
		this.titel = titel;
		this.price = price;
		this.maxVisitors = maxVisitors;
		this.ticketsSold = 0;
		this.showDiscount = showDiscount;
		this.portalisDiscount = portalisDiscount;

	}
	
	public Event(){
		
	}
	
	public int getEventID() {
		return eventID;
	}
	
	public String getConcerttype() {
		return concertType;
	}

	public void setConcerttype(String concertType) {
		this.concertType = concertType;
	}

	public String getStage() {
		return Stage;
	}

	public void setStage(String stage) {
		Stage = stage;
	}

	public String getDateStartString() {
		return dateFormat.format(dateStart.getTime());
	}

	public void setDateStart(String dateStart) throws ParseException {
		this.dateStart.setTime(dateFormat.parse(dateStart));
	}

	public String getDateFinishString() {
		return dateFormat.format(dateFinish.getTime());
	}

	public void setDateFinish(String dateFinish) throws ParseException {
		this.dateFinish.setTime(dateFormat.parse(dateFinish));
	}

	public Calendar getDateStart() {
		return dateStart;
	}

	public Calendar getDateFinish() {
		return dateFinish;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVisitors() {
		return maxVisitors;
	}

	public void setVisitors(int visitors) {
		maxVisitors = visitors;
	}


	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getTicketsSold() {
		return ticketsSold;
	}

	public void setTicketsSold(int ticketsSold) {
		this.ticketsSold = ticketsSold;
	}

	public double getShowDiscount() {
		return showDiscount;
	}

	public void setShowDiscount(double showTilbud) {
		this.showDiscount = showTilbud;
	}

	public double getPortalisDiscount() {
		return portalisDiscount;
	}

	public void setPortalisDiscount(double portalisDiscount) {
		this.portalisDiscount = portalisDiscount;
	}
}
