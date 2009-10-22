package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import dal.Event;
import dalinterface.DALException;
import dalinterface.IEvent;
import dbConnect.Connector;

public class EventDAO implements IEvent {

	public Event getEvent(int EventID) throws DALException, ParseException {
		ResultSet rs = Connector.doQuery("SELECT DISTINCT * from OOADEvent NATURAL left JOIN OOADTicket natural left join OOADDiscount WHERE EventID = " + EventID);
	    try {
	    	if (!rs.first()) throw new DALException("Event'et " + EventID + " findes ikke"); 
	    	return new Event (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
	    			,rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getInt(10), rs.getDouble(11), rs.getDouble(12) );
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}

	@Override
	public void createEvent(Event EventID, Event Event) throws DALException {
		String event=" INSERT INTO OOADEvent (Concerttype, Stage, DateSTART, DateFINISH, Artist, Titel, Price, Visitors) VALUES("
			+ "', '" + Event.getConcerttype()
			+ "', '" + Event.getStage()
			+ "', '" + Event.getDateStart()
			+ "', '" + Event.getDateFinish()
			+ "', '" + Event.getArtist()
			+ "', '" + Event.getTitel()
			+ ", " + Event.getPrice()
			+ ", " + Event.getVisitors() + ")";
		
		
		String discount=" INSERT INTO OOADDiscount (EventID, SHOW, NORMAL) VALUES("
			+ EventID
			+ ", " + Event.getSHOW()
			+ ", " + Event.getNORMAL()+ ")";
		
		Connector.doUpdate(event);
		Connector.doUpdate(discount);
	}

	@Override
	public List<Event> getEventList() throws DALException, InstantiationException, IllegalAccessException, 
	ClassNotFoundException, SQLException, ParseException {
		
		List<Event> list = new ArrayList<Event>();
		ResultSet rs = Connector.getConnector().doQuery("SELECT DISTINCT * from OOADEvent NATURAL LEFT JOIN OOADDiscount");
		try {
			while (rs.next()) {
				list.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
		    			,rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), 0, rs.getDouble(10), rs.getDouble(11)));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public void sletEvent(int EventID) throws DALException {
		Connector.doUpdate(
				"DELETE FROM OOADEvent WHERE EventID = "+ EventID
			);
	}
		

	@Override
	public void updateEvent(int EventID, Event Event) throws DALException {
		String event ="UPDATE OOADEvent SET Concerttype = '" + Event.getConcerttype() + "', Stage =  '" + Event.getStage() + 
				"', TimeSTART = '" + Event.getDateStart() + "', TimeFINISH = '" + Event.getDateFinish() + "', Artist =  '" + Event.getArtist() + 
				"', Titel = '" + Event.getTitel() + "', Price = " + Event.getPrice()+ ",Visitors = " + Event.getVisitors()+
				" WHERE EventID = " + EventID;
		
		
		String discount=" Update OOADDiscount SET SHOW = "+Event.getSHOW()+ ", NORMAL = " + Event.getNORMAL()+" WHERE EventID = "
		+ EventID;;
		
		Connector.doUpdate(event);
		Connector.doUpdate(discount);
			
	}

	public boolean checkEvent(Event Event) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * from OOADEvent WHERE Stage = '"+Event.getStage()+"' and DateSTART <= " +"'"
				+ Event.getDateStart()+"' AND DateFINISH >= '"+Event.getDateStart()+"' OR (Stage = '"+ Event.getStage()+"' AND DateSTART >= '"+Event.getDateStart()+
				"' AND DateSTART <= '"+Event.getDateFinish()+"' ");
	    try {
	    	if (!rs.first()){ 
	    	return false;
	    
	    	}else 
	    		return true;
	    }catch (SQLException e) {throw new DALException(e); }
		
	}

	@Override
	public boolean CheckTickets(Event Event) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT COUNT(TicketID) from OOADTicket WHERE COUNT(TicketID) > "+Event.getVisitors()
				);
		
	    try {
	    	if (!rs.first()){ 
	    	return true;
	    
	    	}else 
	    		return false;
	    }catch (SQLException e) {throw new DALException(e); }
	}
	
	

}
