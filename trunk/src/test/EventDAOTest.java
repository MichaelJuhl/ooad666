package test;

import java.sql.SQLException;
import java.text.ParseException;
import junit.framework.TestCase;
import org.junit.Test;
import dal.Event;
import dalinterface.DALException;
import dao.EventDAO;

public class EventDAOTest extends TestCase{
	
	@Test
	public void testCreateUpdateGetDeleteEvent() {
		Event testEventSent = null;
		Event testEventUpdated = null;
		Event testEventRecieved = null;
		EventDAO testEventDAO;
		
		testEventDAO = new EventDAO();
		
		//Delete event if it already exists
		try {
			testEventDAO.deleteEvent(9999);
		} catch (DALException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
		
		// Create test
		try {
			testEventSent = new Event(9999, "TestType", "Store scene", "2009-11-22 18:58:00", "2009-11-22 23:13:42", "TestArtist", "TestTitel", 120, 500, 391, 8.69, 75.13);
		} catch (ParseException e1) {
			assertFalse(true); //test fails because of exception
		}
		
		try {
			testEventDAO.createEvent(testEventSent);
		} catch (DALException e) {
			assertFalse(true); //test fails because of exception
		} catch (InstantiationException e) {
			assertFalse(true); //test fails because of exception
		} catch (IllegalAccessException e) {
			assertFalse(true); //test fails because of exception
		} catch (ClassNotFoundException e) {
			assertFalse(true); //test fails because of exception
		} catch (SQLException e) {
			assertFalse(true); //test fails because of exception
		}
		
		// Update Test
		try {
			testEventUpdated = testEventDAO.getEvent(testEventDAO.getEventList().get(testEventDAO.getEventList().size()-1).getEventID());
		} catch (DALException e1) {
			assertFalse(true); //test fails because of exception
		} catch (ParseException e1) {
			assertFalse(true); //test fails because of exception
		} catch (InstantiationException e1) {
			assertFalse(true); //test fails because of exception
		} catch (IllegalAccessException e1) {
			assertFalse(true); //test fails because of exception
		} catch (ClassNotFoundException e1) {
			assertFalse(true); //test fails because of exception
		} catch (SQLException e1) {
			assertFalse(true); //test fails because of exception
		}
		testEventUpdated.setTitel("TestTitel2");
		try {
			testEventDAO.updateEvent(testEventUpdated);
		} catch (DALException e) {
			assertFalse(true); //test fails because of exception
		} catch (InstantiationException e) {
			assertFalse(true); //test fails because of exception
		} catch (IllegalAccessException e) {
			assertFalse(true); //test fails because of exception
		} catch (ClassNotFoundException e) {
			assertFalse(true); //test fails because of exception
		} catch (SQLException e) {
			assertFalse(true); //test fails because of exception
		}
		
		// Get test
		
		try {
			testEventRecieved = testEventDAO.getEvent(testEventDAO.getEventList().get(testEventDAO.getEventList().size()-1).getEventID());
		} catch (DALException e) {
			e.printStackTrace();
			assertFalse(true); //test fails because of exception
		} catch (ParseException e) {
			assertFalse(true); //test fails because of exception
		} catch (InstantiationException e) {
			assertFalse(true); //test fails because of exception
		} catch (IllegalAccessException e) {
			assertFalse(true); //test fails because of exception
		} catch (ClassNotFoundException e) {
			assertFalse(true); //test fails because of exception
		} catch (SQLException e) {
			assertFalse(true); //test fails because of exception
		}
		
		assertFalse(testEventRecieved.equals(testEventSent));
		assertTrue(testEventRecieved.equals(testEventUpdated));
		
		//Delete test
		int lastAddedEvent = 0;
		try {
			lastAddedEvent = testEventDAO.getEventList().get(testEventDAO.getEventList().size()-1).getEventID();
		} catch (DALException e1) {
			assertFalse(true); //test fails because of exception
		} catch (InstantiationException e1) {
			assertFalse(true); //test fails because of exception
		} catch (IllegalAccessException e1) {
			assertFalse(true); //test fails because of exception
		} catch (ClassNotFoundException e1) {
			assertFalse(true); //test fails because of exception
		} catch (SQLException e1) {
			assertFalse(true); //test fails because of exception
		} catch (ParseException e1) {
			assertFalse(true); //test fails because of exception
		}
		try {
			testEventDAO.deleteEvent(lastAddedEvent);
		} catch (DALException e) {
			assertFalse(true); //test fails because of exception
		} catch (InstantiationException e) {
			assertFalse(true); //test fails because of exception
		} catch (IllegalAccessException e) {
			assertFalse(true); //test fails because of exception
		} catch (ClassNotFoundException e) {
			assertFalse(true); //test fails because of exception
		} catch (SQLException e) {
			assertFalse(true); //test fails because of exception
		}
		
		try {
			testEventRecieved = testEventDAO.getEvent(lastAddedEvent);
		} catch (DALException e) {
			assertTrue(true); //test succeeds because we deleted the requested event
		} catch (ParseException e) {
			assertFalse(true); //test fails because of exception
		} catch (InstantiationException e) {
			assertFalse(true); //test fails because of exception
		} catch (IllegalAccessException e) {
			assertFalse(true); //test fails because of exception
		} catch (ClassNotFoundException e) {
			assertFalse(true); //test fails because of exception
		} catch (SQLException e) {
			assertFalse(true); //test fails because of exception
		}
	}
}
