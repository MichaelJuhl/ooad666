package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import dal.Event;
import daoInterface.DALException;
import daoInterface.IEventDAO;
import dbConnect.Connector;

public class EventDAO implements IEventDAO {

	public Event getEvent(int EventID) throws DALException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connector.getConnector();
		ResultSet rs = Connector.doQuery("SELECT * , (SELECT COUNT( TicketID ) " +
				"FROM OOADTicket " +
				"WHERE OOADEvent.EventID = OOADTicket.EventID) AS TicketsSold " +
				"FROM `OOADEvent` NATURAL LEFT JOIN OOADDiscount WHERE EventID = " + EventID);
	    try {
	    	if (!rs.first()) throw new DALException("Event'et " + EventID + " findes ikke"); 
	    	return new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
	    			,rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getInt(12), rs.getDouble(10), rs.getDouble(11));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}

	public int getTicketSold(int EventID) throws DALException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connector.getConnector();
		ResultSet rs = Connector.doQuery("SELECT COUNT(TicketID) from OOADTicket WHERE EventID = " + EventID);
	    try {
	    	if (!rs.first()) throw new DALException("Event'et " + EventID + " findes ikke"); 
	    	return rs.getInt(1);
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}

	@Override
	public void createEvent(Event Event) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String event=" INSERT INTO OOADEvent (Concerttype, Stage, DateSTART, DateFINISH, Artist, Titel, Price, Visitors) VALUES("
			+ "'" + Event.getConcertType()
			+ "', '" + Event.getStage()
			+ "', '" + Event.getDateStartString()
			+ "', '" + Event.getDateFinishString()
			+ "', '" + Event.getArtist()
			+ "', '" + Event.getTitel()
			+ "', " + Event.getPrice()
			+ ", " + Event.getVisitors() + ")";
		
		
		String discount=" INSERT INTO OOADDiscount (EventID, ShowDiscount, PortalisDiscount) VALUES((SELECT MAX(EventID) FROM OOADEvent)"
			+ ", " + Event.getShowDiscount()
			+ ", " + Event.getPortalisDiscount()+ ")";
		
		Connector.getConnector();
		Connector.doUpdate(event);
		Connector.doUpdate(discount);
	}

	@Override
	public ArrayList<Event> getEventList() throws DALException, InstantiationException, IllegalAccessException, 
	ClassNotFoundException, SQLException, ParseException {
		
		ArrayList<Event> list = new ArrayList<Event>();
		Connector.getConnector();
		ResultSet rs = Connector.doQuery("SELECT * , (SELECT COUNT( TicketID ) " +
														"FROM OOADTicket " +
														"WHERE OOADEvent.EventID = OOADTicket.EventID) AS TicketsSold " +
														"FROM `OOADEvent` NATURAL LEFT JOIN OOADDiscount");
		
		// giver: EventID, Concerttype, Stage, DateSTART, DateFINISH, Artist, Titel, Price, Visitors, ShowDiscount, PortalisDiscount, TicketsSold
		
		try {
			while (rs.next()) {
				list.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
		    			,rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getInt(12), rs.getDouble(10), rs.getDouble(11)));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public void deleteEvent(int EventID) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connector.getConnector();
		Connector.doUpdate(
				"DELETE FROM OOADEvent WHERE EventID = "+ EventID
			);
	}
		

	@Override
	public void updateEvent(Event event) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String eventUpdate ="UPDATE OOADEvent SET Concerttype = " +
				"'" + event.getConcertType() + 
				"', Stage =  '" + event.getStage() + 
				"', DateSTART = '" + event.getDateStartString() + 
				"', DateFINISH = '" + event.getDateFinishString() + 
				"', Artist =  '" + event.getArtist() + 
				"', Titel = '" + event.getTitel() + 
				"', Price = " + event.getPrice()+ 
				", Visitors = " + event.getVisitors()+
				" WHERE EventID = " + event.getEventID();
		
		
		String discount=" Update OOADDiscount SET ShowDiscount = "+event.getShowDiscount()+ ", PortalisDiscount = " + event.getPortalisDiscount()+" WHERE EventID = "
		+ event.getEventID();
		
		Connector.getConnector();
		Connector.doUpdate(eventUpdate);
		Connector.doUpdate(discount);
			
	}

	public boolean otherEventInTimeslot(Event event) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connector.getConnector();
		ResultSet rs = Connector.doQuery("SELECT * FROM OOADEvent WHERE Stage = '" + event.getStage() + "' AND EventID <> " + event.getEventID() + " AND DateSTART <= '"
				+ event.getDateStartString() + "' AND DateFINISH >= '" + event.getDateStartString() + "' OR (Stage = '" + event.getStage() 
				+ "' AND EventID <> " + event.getEventID() + " AND DateSTART >= '" + event.getDateStartString()+ "' AND DateSTART <= '" + event.getDateFinishString() + "')");
	    try {
	    	if (!rs.first()){ 
	    	return false;
	    
	    	}else 
	    		return true;
	    }catch (SQLException e) {throw new DALException(e); }
		
	}

	@Override
	public boolean checkTickets(int eventID,int tickets) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException  {
		Connector.getConnector();
		ResultSet rs = Connector.doQuery("SELECT * FROM `OOADEvent` NATURAL LEFT JOIN OOADDiscount WHERE OOADEvent.EventID = "+eventID+" AND (OOADEvent.Visitors - (SELECT COUNT( TicketID ) FROM OOADTicket WHERE OOADEvent.EventID = OOADTicket.EventID) >= "+tickets+")"
				);
		
	    try {
	    	if (!rs.first()){ 
	    	return true;
	    
	    	}else 
	    		return false;
	    }catch (SQLException e) {throw new DALException(e); }
	}
	
	public void createTicket(int EventID,String TicketID) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql=" INSERT INTO OOADTicket (EventID, TicketID) VALUES("
			+ EventID
			+ ", '" + TicketID + "')";
		
		Connector.getConnector();
		Connector.doUpdate(sql);
	}

}
