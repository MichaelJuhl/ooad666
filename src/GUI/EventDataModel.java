/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author User
 */
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import dal.Event;

public class EventDataModel extends AbstractTableModel {

    protected ArrayList<Event> eventList;
    
    EventDataModel() throws ParseException {
        eventList = new ArrayList<Event>();
        //test
        eventList.add(new Event(1,"Rock","Gul","Bamse","2010-09-22 12:00:00","2010-09-22 13:30:00","Bamse spiller",154,200));
        eventList.add(new Event(2,"Dance","Orange","TECHNO-Tiz","2010-09-25 18:20:04","2010-09-29 13:30:59","Techno Forever",154,1500));
        eventList.add(new Event(3,"Leg","Gul","Michael","2010-01-05 12:00:00","2010-01-05 13:30:00","Michael Leger",154,200));
    }

    public int getRowCount() {
        return eventList.size();
    }

    public int getColumnCount() {
        return 10;
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
                return eventList.get(columnIndex);
            case ARTIST:
                return eventList.get(columnIndex);
            case STAGE:
                return eventList.get(columnIndex);
            case CONCERTTYPE:
                return eventList.get(columnIndex);
            case DATESTART:
                return eventList.get(columnIndex);
            case DATEFINISH:
                return eventList.get(columnIndex);
            case TICKETS:
                return eventList.get(columnIndex);
            case PRICE:
                return eventList.get(columnIndex);
            case SHOW:
                return eventList.get(columnIndex);
            case NORMAL:
                return eventList.get(columnIndex);
            default:
                return "";
        }
    }   
}
