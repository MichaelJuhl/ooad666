package daoInterface;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import dal.Event;

public interface IEventDAO {

	Event getEvent(int EventID) throws DALException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	ArrayList<Event> getEventList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ParseException;
	void createEvent(Event Event) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void updateEvent(Event Event) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void deleteEvent(int EventID) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean otherEventInTimeslot(Event Event) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean checkTickets(int eventID,int tickets) throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}
	





