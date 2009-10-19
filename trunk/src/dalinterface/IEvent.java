package dalinterface;

import java.sql.SQLException;
import java.util.List;

import dao.EventDAO;

public interface IEvent {

	EventDAO getEventID() throws DALException;
	
}




