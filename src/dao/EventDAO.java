package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import dal.Event;
import dalinterface.DALException;
import dalinterface.IEvent;
import dbConnect.Connector;

public class EventDAO implements IEvent {

	public Event getEvent(int EventID) throws DALException, ParseException {
		ResultSet rs = Connector.doQuery("SELECT DISTINCT * from OOADEvent natural left join OOADDiscount WHERE EventID = " + EventID);
	    try {
	    	if (!rs.first()) throw new DALException("Event'et " + EventID + " findes ikke"); 
	    	return new Event (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
	    			,rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs.getInt(10), rs.getDouble(11), rs.getDouble(12) );
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}

	public int getTicketSold(int EventID) throws DALException, ParseException {
		ResultSet rs = Connector.doQuery("SELECT COUNT(TicketID) from OOADTicket WHERE EventID = " + EventID);
	    try {
	    	if (!rs.first()) throw new DALException("Event'et " + EventID + " findes ikke"); 
	    	return rs.getInt(1);
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}

	@Override
	public void createEvent(Event Event) throws DALException {
		String event=" INSERT INTO OOADEvent (Concerttype, Stage, DateSTART, DateFINISH, Artist, Titel, Price, Visitors) VALUES("
			+ "'" + Event.getConcerttype()
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
		
		Connector.doUpdate(event);
		Connector.doUpdate(discount);
	}

	@Override
	public ArrayList<Event> getEventList() throws DALException, InstantiationException, IllegalAccessException, 
	ClassNotFoundException, SQLException, ParseException {
		
		ArrayList<Event> list = new ArrayList<Event>();
		ResultSet rs = Connector.getConnector().doQuery("SELECT * , (SELECT COUNT( TicketID ) " +
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
	public void deleteEvent(int EventID) throws DALException {
		Connector.doUpdate(
				"DELETE FROM OOADEvent WHERE EventID = "+ EventID
			);
	}
		

	@Override
	public void updateEvent(Event event) throws DALException {
		String eventUpdate ="UPDATE OOADEvent SET Concerttype = " +
				"'" + event.getConcerttype() + 
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
		
		Connector.doUpdate(eventUpdate);
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
	public boolean checkTickets(Event Event) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT COUNT(TicketID) from OOADTicket WHERE COUNT(TicketID) > "+Event.getVisitors()
				);
		
	    try {
	    	if (!rs.first()){ 
	    	return true;
	    
	    	}else 
	    		return false;
	    }catch (SQLException e) {throw new DALException(e); }
	}
	
	public void createTicket(int EventID,String TicketID) throws DALException {
		String sql=" INSERT INTO OOADTicket (EventID, TicketID) VALUES("
			+ EventID
			+ ", '" + TicketID + "')";
		
		Connector.doUpdate(sql);
	}

}
