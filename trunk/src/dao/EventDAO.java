package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.Event;
import dalinterface.DALException;
import dalinterface.IEvent;
import dbConnect.Connector;

public class EventDAO implements IEvent {

	public Event getEvent(int EventID) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM OOADEvent WHERE EventID = " + EventID);
	    try {
	    	if (!rs.first()) throw new DALException("Event'et " + EventID + " findes ikke"); 
	    	return new Event (	rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
	    			,rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs. getDouble(10), rs.getDouble(11));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}

	@Override
	public void createEvent(Event EventID) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Event> getEventList() throws DALException, InstantiationException, IllegalAccessException, 
	ClassNotFoundException, SQLException {
		
		List<Event> list = new ArrayList<Event>();
		ResultSet rs = Connector.getConnector().doQuery("SELECT * FROM OOADEvent");
		try {
			while (rs.next()) {
				list.add(new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
		    			,rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getInt(9), rs. getDouble(10), rs.getDouble(11)));
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
		Connector.doUpdate(
				"UPDATE OOADEvent SET Concerttype = '" + Event.getConcerttype() + "', Stage =  '" + Event.getStage() + 
				"', TimeSTART = '" + Event.getDateStart() + "', TimeFINISH = '" + Event.getDateFinish() + "', Artist =  '" + Event.getArtist() + 
				"', Titel = '" + Event.getTitel() + "', Price = '" + Event.getPrice()+ "',Visitors = '" + Event.getVisitors()+
				"', DiscountSHOW = '" + Event.getDiscountSHOW()+ "',DiscoutNORM = '" + Event.getDiscoutNORM() + 
				"' WHERE EventID = " + EventID
				);
	}

	public boolean checkEvent(String datestart, String stage) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * from OOADEvent WHERE Stage = '"+stage+"' and DateSTART <= '"+datestart+"' AND DateFinish >= '"+datestart+"'");
	    try {
	    	if (!rs.first()){ 
	    	return false;
	    
	    	}else 
	    		return true;
	    }catch (SQLException e) {throw new DALException(e); }
		
	}
	
	

}
