package dalinterface;

import java.sql.SQLException;
import java.util.List;

import dal.Event;

public interface IEvent {

	Event getEvent(int EventID) throws DALException;
	List<Event> getEventList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void createEvent(Event EventID, Event Event) throws DALException;
	void updateEvent(int EventID, Event Event) throws DALException;
	void sletEvent(int EventID) throws DALException;
	public boolean checkEvent(Event Event) throws DALException;
	public boolean CheckTickets(Event Event) throws DALException;
}
	




