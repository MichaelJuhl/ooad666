
package GUI;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import dal.Event;
import dalinterface.DALException;
import dao.EventDAO;

public class EventDataModel extends AbstractTableModel {

    protected ArrayList<Event> eventList;
    
    EventDataModel() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
    	eventList = new EventDAO().getEventList();
    	
    	//Test
    	//eventList = new ArrayList<Event>();
        //test
        //eventList.add(new Event(1, "Rock", "Gul", "2010-09-22 12:00:00", "2010-09-22 13:30:00", "Bamse", "Bamse spiller", 154, 200, 0, 10, 25));
        //eventList.add(new Event(2,"Dance","Orange","2010-09-25 18:20:04","2010-09-29 13:30:59","TECHNO-Tiz","Techno Forever",154,1500,0,7,21));
        //eventList.add(new Event(3,"Leg","Gul","2010-01-05 12:00:00","2010-01-05 13:30:00","Michael","Michael Leger",154,200,0,18,4));
    }
    
    public TableModel getTableModel() {
    	return (TableModel)this;
    }

    public int getRowCount() {
        return eventList.size();
    }

    public int getColumnCount() {
        return 10;
    }
    
    public String getColumnName(int columnIndex) {
    	String[] columnNames = new String [] {
                "Titel", "Kunstner", "Scene", "Koncerttype", "Start", "Slut", "Billetter", "Pris", "Showportalis Tilbud", "Portalis Tilbud"
        };
    	return columnNames[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        final int TITEL = 0;
        final int ARTIST = 1;
        final int STAGE = 2;
        final int CONCERTTYPE = 3;
        final int DATESTART = 4;
        final int DATEFINISH = 5;
        final int TICKETS = 6;
        final int PRICE = 7;
        final int SHOW = 8;
        final int NORMAL = 9;

        switch(columnIndex) {
            case TITEL:
                return eventList.get(rowIndex).getTitel();
            case ARTIST:
                return eventList.get(rowIndex).getArtist();
            case STAGE:
                return eventList.get(rowIndex).getStage();
            case CONCERTTYPE:
                return eventList.get(rowIndex).getConcertType();
            case DATESTART:
                return eventList.get(rowIndex).getDateStartString();
            case DATEFINISH:
                return eventList.get(rowIndex).getDateFinishString();
            case TICKETS:
            	return eventList.get(rowIndex).getVisitors() - eventList.get(rowIndex).getTicketsSold() + "/" + eventList.get(rowIndex).getVisitors();
            case PRICE:
                return eventList.get(rowIndex).getPrice();
            case SHOW:
                return eventList.get(rowIndex).getShowDiscount();
            case NORMAL:
                return eventList.get(rowIndex).getPortalisDiscount();
            default:
                return "";
        }
    }
    
    public ArrayList<Event> getEventList() {
        return (ArrayList<Event>)eventList;
    }

	public void updateFromDatabase() {
		try {
			eventList = new EventDAO().getEventList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}