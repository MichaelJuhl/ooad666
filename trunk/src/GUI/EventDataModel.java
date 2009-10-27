
package GUI;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import dal.Event;
import dalinterface.DALException;
import dao.EventDAO;

public class EventDataModel extends AbstractTableModel {

    protected List<Event> eventList;
    
    EventDataModel() throws ParseException, DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
    	eventList = new EventDAO().getEventList();
    	
    	//Test
    	//eventList = new ArrayList<Event>();
        //test
        //eventList.add(new Event(1,"Rock","Gul","Bamse","2010-09-22 12:00:00","2010-09-22 13:30:00","Bamse spiller",154,200,0,10,25));
        //eventList.add(new Event(2,"Dance","Orange","TECHNO-Tiz","2010-09-25 18:20:04","2010-09-29 13:30:59","Techno Forever",154,1500,0,7,21));
        //eventList.add(new Event(3,"Leg","Gul","Michael","2010-01-05 12:00:00","2010-01-05 13:30:00","Michael Leger",154,200,0,18,4));
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
                return eventList.get(rowIndex).getConcerttype();
            case DATESTART:
                return eventList.get(rowIndex).getDateStart();
            case DATEFINISH:
                return eventList.get(rowIndex).getDateFinish();
            case TICKETS:
			try {
				return eventList.get(rowIndex).getVisitors() - new EventDAO().getTicketSold(eventList.get(rowIndex).getEventID());
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				//eventList.get(rowIndex).getTicketsSold();
            case PRICE:
                return eventList.get(rowIndex).getPrice();
            case SHOW:
                return eventList.get(rowIndex).getSHOW();
            case NORMAL:
                return eventList.get(rowIndex).getNORMAL();
            default:
                return "";
        }
    }   
}
