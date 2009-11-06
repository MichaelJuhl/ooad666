package dalinterface;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import dal.Event;

public interface IEvent {

	Event getEvent(int EventID) throws DALException, ParseException;
	ArrayList<Event> getEventList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, ParseException;
	void createEvent(Event Event) throws DALException;
	void updateEvent(Event Event) throws DALException;
	void deleteEvent(int EventID) throws DALException;
	public boolean checkEvent(Event Event) throws DALException;
	public boolean checkTickets(Event Event) throws DALException;
}
	





