/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ticketEventDialog.java
 *
 * Created on 29-10-2009, 12:58:11
 */

package GUI;
import java.awt.Component;
import java.text.ParseException;
import dal.Event;
import dal.Member;
import dalinterface.DALException;
import dao.EventDAO;
import GUI.PrintUtilities;

/**
 *
 * @author Michael
 */
public class TicketPrintingDialog extends javax.swing.JDialog {
	private EventList eventList;
    /** Creates new form ticketEventDialog */
    public TicketPrintingDialog(TicketBuyDialog buyTicketDialog, boolean modal, Event event, Member customer, int billetter, EventList eventList) {
        super(buyTicketDialog, modal);
        this.eventList = eventList;
        initComponents();
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        if (billetter >= 1){

            jPanel1.setVisible(true);
        	TitelJLabel.setText(event.getTitel());
        	DateSTARTJLabel.setText(event.getDateStartString());
        	DateFINISHJLabel.setText(event.getDateFinishString());
        	StageJLabel.setText(event.getStage());
        	PrisOriInputJLabel1.setText(Double.toString(event.getPrice()));
        	ArtistJLabel.setText(event.getArtist());
        	KundeInputJLabel.setText(customer.getName());

        	try {
        		BilletInputJLabel.setText(
        				event.getArtist().substring(0, 2)+
        				event.getEventID()+
        				(event.getTicketsSold()+1)+
        				(event.getDateStartString().substring(2,4))+
                		(event.getDateStartString().substring(5,7))+
                		(event.getDateStartString().substring(8,10))

        		);
            	new EventDAO().createTicket(event.getEventID(), BilletInputJLabel.getText());
        	} catch (DALException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	if (customer.getClub().equalsIgnoreCase("Show-Portalis") ) {
        		RabatInputJLabel.setText(event.getShowDiscount()+"%");
        		double pris = event.getPrice()-((event.getPrice()/100)*event.getShowDiscount());
        		PrisInputJLabel.setText(pris+"kr");
        	}else{
        		if (customer.getClub().equalsIgnoreCase("Portalis") ) {
        			RabatInputJLabel.setText(+event.getPortalisDiscount()+"%");
        			double pris = event.getPrice()-((event.getPrice()/100)*event.getPortalisDiscount());
        			PrisInputJLabel.setText(pris+"kr");
        		}else{
        			RabatInputJLabel.setText(0+"%");

        			PrisInputJLabel.setText(event.getPrice()+"kr");
        		}
        	}

        }
        
        if (billetter >= 2){
            jPanel2.setVisible(true);
        	TitelJLabel1.setText(event.getTitel());
        	DateSTARTJLabel1.setText(event.getDateStartString());
        	DateFINISHJLabel1.setText(event.getDateFinishString());
        	StageJLabel1.setText(event.getStage());
        	PrisOriInputJLabel2.setText(Double.toString(event.getPrice()));
        	ArtistJLabel1.setText(event.getArtist());
        	KundeInputJLabel1.setText(customer.getName());

        	try {
        		BilletInputJLabel1.setText(
        				event.getArtist().substring(0, 2)+
        				event.getEventID()+
        				(event.getTicketsSold()+2)+
        				(event.getDateStartString().substring(2,4))+
                		(event.getDateStartString().substring(5,7))+
                		(event.getDateStartString().substring(8,10))
        		);
            	new EventDAO().createTicket(event.getEventID(), BilletInputJLabel1.getText());
        	} catch (DALException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	if (customer.getClub().equalsIgnoreCase("Show-Portalis") ) {
        		RabatInputJLabel1.setText(event.getShowDiscount()+"%");
        		double pris = event.getPrice()-((event.getPrice()/100)*event.getShowDiscount());
        		PrisInputJLabel1.setText(pris+"kr");
        	}else{
        		if (customer.getClub().equalsIgnoreCase("Portalis") ) {
        			RabatInputJLabel1.setText(+event.getPortalisDiscount()+"%");
        			double pris = event.getPrice()-((event.getPrice()/100)*event.getPortalisDiscount());
        			PrisInputJLabel1.setText(pris+"kr");
        		}else{
        			RabatInputJLabel1.setText(0+"%");

        			PrisInputJLabel1.setText(event.getPrice()+"kr");
        		}
        	}
        }
        
        if (billetter >= 3){
            jPanel3.setVisible(true);
        	TitelJLabel2.setText(event.getTitel());
        	DateSTARTJLabel2.setText(event.getDateStartString());
        	DateFINISHJLabel2.setText(event.getDateFinishString());
        	StageJLabel2.setText(event.getStage());
        	PrisOriInputJLabel3.setText(Double.toString(event.getPrice()));
        	ArtistJLabel2.setText(event.getArtist());
        	KundeInputJLabel2.setText(customer.getName());

        	try {
        		BilletInputJLabel2.setText(
        				event.getArtist().substring(0, 2)+
        				event.getEventID()+
        				(event.getTicketsSold()+3)+
        				(event.getDateStartString().substring(2,4))+
                		(event.getDateStartString().substring(5,7))+
                		(event.getDateStartString().substring(8,10))
        		);
            	new EventDAO().createTicket(event.getEventID(), BilletInputJLabel2.getText());
        	} catch (DALException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	if (customer.getClub().equalsIgnoreCase("Show-Portalis") ) {
        		RabatInputJLabel2.setText(event.getShowDiscount()+"%");
        		double pris = event.getPrice()-((event.getPrice()/100)*event.getShowDiscount());
        		PrisInputJLabel2.setText(pris+"kr");
        	}else{
        		if (customer.getClub().equalsIgnoreCase("Portalis") ) {
        			RabatInputJLabel2.setText(+event.getPortalisDiscount()+"%");
        			double pris = event.getPrice()-((event.getPrice()/100)*event.getPortalisDiscount());
        			PrisInputJLabel2.setText(pris+"kr");
        		}else{
        			RabatInputJLabel2.setText(0+"%");

        			PrisInputJLabel2.setText(event.getPrice()+"kr");
        		}
        	}
        }
        
        if (billetter >= 4){
            jPanel4.setVisible(true);
        	TitelJLabel3.setText(event.getTitel());
        	DateSTARTJLabel3.setText(event.getDateStartString());
        	DateFINISHJLabel3.setText(event.getDateFinishString());
        	StageJLabel3.setText(event.getStage());
        	PrisOriInputJLabel4.setText(Double.toString(event.getPrice()));
        	ArtistJLabel3.setText(event.getArtist());
        	KundeInputJLabel3.setText(customer.getName());

        	try {
        		BilletInputJLabel3.setText(
        				event.getArtist().substring(0, 2)+
        				event.getEventID()+
        				(event.getTicketsSold()+4)+
        				(event.getDateStartString().substring(2,4))+
                		(event.getDateStartString().substring(5,7))+
                		(event.getDateStartString().substring(8,10))
        		);
            	new EventDAO().createTicket(event.getEventID(), BilletInputJLabel3.getText());
        	} catch (DALException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	if (customer.getClub().equalsIgnoreCase("Show-Portalis") ) {
        		RabatInputJLabel3.setText(event.getShowDiscount()+"%");
        		double pris = event.getPrice()-((event.getPrice()/100)*event.getShowDiscount());
        		PrisInputJLabel3.setText(pris+"kr");
        	}else{
        		if (customer.getClub().equalsIgnoreCase("Portalis") ) {
        			RabatInputJLabel3.setText(+event.getPortalisDiscount()+"%");
        			double pris = event.getPrice()-((event.getPrice()/100)*event.getPortalisDiscount());
        			PrisInputJLabel3.setText(pris+"kr");
        		}else{
        			RabatInputJLabel3.setText(0+"%");

        			PrisInputJLabel3.setText(event.getPrice()+"kr");
        		}
        	}
        }
        //System.out.println("test2");

        //PrintUtilities.printComponent(jPanel1);
       // System.out.println("test3");
        
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */



    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        PortalenTextJLabel3 = new javax.swing.JLabel();
        TitelJLabel3 = new javax.swing.JLabel();
        TextJLabel10 = new javax.swing.JLabel();
        DateSTARTJLabel3 = new javax.swing.JLabel();
        DateFINISHJLabel3 = new javax.swing.JLabel();
        BindeJLabel3 = new javax.swing.JLabel();
        TextJLabel11 = new javax.swing.JLabel();
        StageJLabel3 = new javax.swing.JLabel();
        KundeJLabel3 = new javax.swing.JLabel();
        KundeInputJLabel3 = new javax.swing.JLabel();
        RabetJLabel3 = new javax.swing.JLabel();
        PrisJLabel3 = new javax.swing.JLabel();
        RabatInputJLabel3 = new javax.swing.JLabel();
        PrisInputJLabel3 = new javax.swing.JLabel();
        BilletInputJLabel3 = new javax.swing.JLabel();
        BilletJLabel3 = new javax.swing.JLabel();
        ArtistJLabel3 = new javax.swing.JLabel();
        PrisOriJLabel3 = new javax.swing.JLabel();
        PrisOriInputJLabel4 = new javax.swing.JLabel();
        TextJLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PortalenTextJLabel2 = new javax.swing.JLabel();
        TitelJLabel2 = new javax.swing.JLabel();
        TextJLabel7 = new javax.swing.JLabel();
        DateSTARTJLabel2 = new javax.swing.JLabel();
        DateFINISHJLabel2 = new javax.swing.JLabel();
        BindeJLabel2 = new javax.swing.JLabel();
        TextJLabel8 = new javax.swing.JLabel();
        StageJLabel2 = new javax.swing.JLabel();
        KundeJLabel2 = new javax.swing.JLabel();
        KundeInputJLabel2 = new javax.swing.JLabel();
        RabetJLabel2 = new javax.swing.JLabel();
        PrisJLabel2 = new javax.swing.JLabel();
        RabatInputJLabel2 = new javax.swing.JLabel();
        PrisInputJLabel2 = new javax.swing.JLabel();
        BilletInputJLabel2 = new javax.swing.JLabel();
        BilletJLabel2 = new javax.swing.JLabel();
        ArtistJLabel2 = new javax.swing.JLabel();
        PrisOriJLabel2 = new javax.swing.JLabel();
        PrisOriInputJLabel3 = new javax.swing.JLabel();
        TextJLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        PortalenTextJLabel1 = new javax.swing.JLabel();
        TitelJLabel1 = new javax.swing.JLabel();
        TextJLabel4 = new javax.swing.JLabel();
        DateSTARTJLabel1 = new javax.swing.JLabel();
        DateFINISHJLabel1 = new javax.swing.JLabel();
        BindeJLabel1 = new javax.swing.JLabel();
        TextJLabel5 = new javax.swing.JLabel();
        StageJLabel1 = new javax.swing.JLabel();
        KundeJLabel1 = new javax.swing.JLabel();
        KundeInputJLabel1 = new javax.swing.JLabel();
        RabetJLabel1 = new javax.swing.JLabel();
        PrisJLabel1 = new javax.swing.JLabel();
        RabatInputJLabel1 = new javax.swing.JLabel();
        PrisInputJLabel1 = new javax.swing.JLabel();
        BilletInputJLabel1 = new javax.swing.JLabel();
        BilletJLabel1 = new javax.swing.JLabel();
        ArtistJLabel1 = new javax.swing.JLabel();
        PrisOriJLabel1 = new javax.swing.JLabel();
        PrisOriInputJLabel2 = new javax.swing.JLabel();
        TextJLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PortalenTextJLabel = new javax.swing.JLabel();
        TitelJLabel = new javax.swing.JLabel();
        TextJLabel1 = new javax.swing.JLabel();
        DateSTARTJLabel = new javax.swing.JLabel();
        DateFINISHJLabel = new javax.swing.JLabel();
        BindeJLabel = new javax.swing.JLabel();
        TextJLabel2 = new javax.swing.JLabel();
        StageJLabel = new javax.swing.JLabel();
        KundeJLabel = new javax.swing.JLabel();
        KundeInputJLabel = new javax.swing.JLabel();
        RabetJLabel = new javax.swing.JLabel();
        PrisJLabel = new javax.swing.JLabel();
        RabatInputJLabel = new javax.swing.JLabel();
        PrisInputJLabel = new javax.swing.JLabel();
        BilletInputJLabel = new javax.swing.JLabel();
        BilletJLabel = new javax.swing.JLabel();
        ArtistJLabel = new javax.swing.JLabel();
        PrisOriJLabel = new javax.swing.JLabel();
        PrisOriInputJLabel1 = new javax.swing.JLabel();
        TextJLabel3 = new javax.swing.JLabel();
        Print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PortalenTextJLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        PortalenTextJLabel3.setText("Portalen Præsenterer:");

        TitelJLabel3.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        TitelJLabel3.setText("Airbourne");

        TextJLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel10.setText("Den");

        DateSTARTJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        DateSTARTJLabel3.setText("1000-01-01 00:00:00");

        DateFINISHJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        DateFINISHJLabel3.setText("1000-01-01 00:00:00");

        BindeJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        BindeJLabel3.setText("-");

        TextJLabel11.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel11.setText("I");

        StageJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        StageJLabel3.setText("Store Scene");

        KundeJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        KundeJLabel3.setText("Kunde:");

        KundeInputJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        KundeInputJLabel3.setText("Michael Juhl");

        RabetJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabetJLabel3.setText("Rabat:");

        PrisJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisJLabel3.setText("Din Pris:");

        RabatInputJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabatInputJLabel3.setText("25%");

        PrisInputJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisInputJLabel3.setText("200kr");

        BilletInputJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        BilletInputJLabel3.setText("D291F8IR");

        BilletJLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        BilletJLabel3.setText("BilletID:");

        ArtistJLabel3.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        ArtistJLabel3.setText("Airbourne");

        PrisOriJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriJLabel3.setText("Pris:");

        PrisOriInputJLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriInputJLabel4.setText("200kr");

        TextJLabel12.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        TextJLabel12.setText("Med");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(KundeJLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(KundeInputJLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(RabetJLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(RabatInputJLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(PrisOriJLabel3)
                                        .addGap(33, 33, 33)
                                        .addComponent(PrisOriInputJLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(326, 326, 326))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(PrisJLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PrisInputJLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TextJLabel10)
                                            .addComponent(TextJLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(DateSTARTJLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BindeJLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DateFINISHJLabel3))
                                            .addComponent(StageJLabel3))))
                                .addGap(262, 262, 262))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(PortalenTextJLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                                .addComponent(BilletJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BilletInputJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(TextJLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(ArtistJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TitelJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PortalenTextJLabel3)
                    .addComponent(BilletInputJLabel3)
                    .addComponent(BilletJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TitelJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel12)
                    .addComponent(ArtistJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel10)
                    .addComponent(DateSTARTJLabel3)
                    .addComponent(BindeJLabel3)
                    .addComponent(DateFINISHJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel11)
                    .addComponent(StageJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KundeJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KundeInputJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RabetJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RabatInputJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisOriJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisOriInputJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisInputJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PortalenTextJLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        PortalenTextJLabel2.setText("Portalen Præsenterer:");

        TitelJLabel2.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        TitelJLabel2.setText("Airbourne");

        TextJLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel7.setText("Den");

        DateSTARTJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        DateSTARTJLabel2.setText("1000-01-01 00:00:00");

        DateFINISHJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        DateFINISHJLabel2.setText("1000-01-01 00:00:00");

        BindeJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        BindeJLabel2.setText("-");

        TextJLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel8.setText("I");

        StageJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        StageJLabel2.setText("Store Scene");

        KundeJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        KundeJLabel2.setText("Kunde:");

        KundeInputJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        KundeInputJLabel2.setText("Michael Juhl");

        RabetJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabetJLabel2.setText("Rabat:");

        PrisJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisJLabel2.setText("Din Pris:");

        RabatInputJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabatInputJLabel2.setText("25%");

        PrisInputJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisInputJLabel2.setText("200kr");

        BilletInputJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        BilletInputJLabel2.setText("D291F8IR");

        BilletJLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        BilletJLabel2.setText("BilletID:");

        ArtistJLabel2.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        ArtistJLabel2.setText("Airbourne");

        PrisOriJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriJLabel2.setText("Pris:");

        PrisOriInputJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriInputJLabel3.setText("200kr");

        TextJLabel9.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        TextJLabel9.setText("Med");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(KundeJLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(KundeInputJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(RabetJLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(RabatInputJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(PrisOriJLabel2)
                                        .addGap(33, 33, 33)
                                        .addComponent(PrisOriInputJLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(326, 326, 326))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(PrisJLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PrisInputJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TextJLabel7)
                                            .addComponent(TextJLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(DateSTARTJLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BindeJLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DateFINISHJLabel2))
                                            .addComponent(StageJLabel2))))
                                .addGap(262, 262, 262))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(PortalenTextJLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                                .addComponent(BilletJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BilletInputJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(TextJLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(ArtistJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TitelJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PortalenTextJLabel2)
                    .addComponent(BilletInputJLabel2)
                    .addComponent(BilletJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TitelJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel9)
                    .addComponent(ArtistJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel7)
                    .addComponent(DateSTARTJLabel2)
                    .addComponent(BindeJLabel2)
                    .addComponent(DateFINISHJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel8)
                    .addComponent(StageJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KundeJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KundeInputJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RabetJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RabatInputJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisOriJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisOriInputJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisInputJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PortalenTextJLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        PortalenTextJLabel1.setText("Portalen Præsenterer:");

        TitelJLabel1.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        TitelJLabel1.setText("Airbourne");

        TextJLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel4.setText("Den");

        DateSTARTJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        DateSTARTJLabel1.setText("1000-01-01 00:00:00");

        DateFINISHJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        DateFINISHJLabel1.setText("1000-01-01 00:00:00");

        BindeJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        BindeJLabel1.setText("-");

        TextJLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel5.setText("I");

        StageJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        StageJLabel1.setText("Store Scene");

        KundeJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        KundeJLabel1.setText("Kunde:");

        KundeInputJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        KundeInputJLabel1.setText("Michael Juhl");

        RabetJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabetJLabel1.setText("Rabat:");

        PrisJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisJLabel1.setText("Din Pris:");

        RabatInputJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabatInputJLabel1.setText("25%");

        PrisInputJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisInputJLabel1.setText("200kr");

        BilletInputJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        BilletInputJLabel1.setText("D291F8IR");

        BilletJLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        BilletJLabel1.setText("BilletID:");

        ArtistJLabel1.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        ArtistJLabel1.setText("Airbourne");

        PrisOriJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriJLabel1.setText("Pris:");

        PrisOriInputJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriInputJLabel2.setText("200kr");

        TextJLabel6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        TextJLabel6.setText("Med");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(KundeJLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(KundeInputJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(RabetJLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(RabatInputJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(PrisOriJLabel1)
                                        .addGap(33, 33, 33)
                                        .addComponent(PrisOriInputJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(326, 326, 326))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(PrisJLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PrisInputJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TextJLabel4)
                                            .addComponent(TextJLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(DateSTARTJLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BindeJLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DateFINISHJLabel1))
                                            .addComponent(StageJLabel1))))
                                .addGap(262, 262, 262))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(PortalenTextJLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                                .addComponent(BilletJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BilletInputJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TextJLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(ArtistJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TitelJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PortalenTextJLabel1)
                    .addComponent(BilletInputJLabel1)
                    .addComponent(BilletJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TitelJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel6)
                    .addComponent(ArtistJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel4)
                    .addComponent(DateSTARTJLabel1)
                    .addComponent(BindeJLabel1)
                    .addComponent(DateFINISHJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel5)
                    .addComponent(StageJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KundeJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KundeInputJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RabetJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RabatInputJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisOriJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisOriInputJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisInputJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PortalenTextJLabel.setFont(new java.awt.Font("Bodoni MT", 0, 18));
        PortalenTextJLabel.setText("Portalen Præsenterer:");

        TitelJLabel.setFont(new java.awt.Font("Bodoni MT Black", 1, 24));
        TitelJLabel.setText("Airbourne");

        TextJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel1.setText("Den");

        DateSTARTJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        DateSTARTJLabel.setText("1000-01-01 00:00:00");

        DateFINISHJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        DateFINISHJLabel.setText("1000-01-01 00:00:00");

        BindeJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        BindeJLabel.setText("-");

        TextJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel2.setText("I");

        StageJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        StageJLabel.setText("Store Scene");

        KundeJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        KundeJLabel.setText("Kunde:");

        KundeInputJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        KundeInputJLabel.setText("Michael Juhl");

        RabetJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabetJLabel.setText("Rabat:");

        PrisJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisJLabel.setText("Din Pris:");

        RabatInputJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabatInputJLabel.setText("25%");

        PrisInputJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisInputJLabel.setText("200kr");

        BilletInputJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        BilletInputJLabel.setText("D291F8IR");

        BilletJLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        BilletJLabel.setText("BilletID:");

        ArtistJLabel.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        ArtistJLabel.setText("Airbourne");

        PrisOriJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriJLabel.setText("Pris:");

        PrisOriInputJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriInputJLabel1.setText("200kr");

        TextJLabel3.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        TextJLabel3.setText("Med");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(KundeJLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(KundeInputJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(RabetJLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(RabatInputJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(PrisOriJLabel)
                                        .addGap(33, 33, 33)
                                        .addComponent(PrisOriInputJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(326, 326, 326))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(PrisJLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PrisInputJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TextJLabel1)
                                            .addComponent(TextJLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(DateSTARTJLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BindeJLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DateFINISHJLabel))
                                            .addComponent(StageJLabel))))
                                .addGap(262, 262, 262))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(PortalenTextJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                                .addComponent(BilletJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BilletInputJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TextJLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(ArtistJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TitelJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PortalenTextJLabel)
                    .addComponent(BilletInputJLabel)
                    .addComponent(BilletJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TitelJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel3)
                    .addComponent(ArtistJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel1)
                    .addComponent(DateSTARTJLabel)
                    .addComponent(BindeJLabel)
                    .addComponent(DateFINISHJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel2)
                    .addComponent(StageJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KundeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KundeInputJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RabetJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RabatInputJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisOriJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisOriInputJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisInputJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel5);

        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Print)
                .addContainerGap(472, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(Print))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	PrintUtilities.printComponent(jPanel5);
    	eventList.updateTable();
    	this.dispose();
    }                                     

    /**
    * @param args the command line arguments
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ticketEventDialog dialog = new ticketEventDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/
    
    
    // Variables declaration - do not modify
    private javax.swing.JLabel ArtistJLabel;
    private javax.swing.JLabel ArtistJLabel1;
    private javax.swing.JLabel ArtistJLabel2;
    private javax.swing.JLabel ArtistJLabel3;
    private javax.swing.JLabel BilletInputJLabel;
    private javax.swing.JLabel BilletInputJLabel1;
    private javax.swing.JLabel BilletInputJLabel2;
    private javax.swing.JLabel BilletInputJLabel3;
    private javax.swing.JLabel BilletJLabel;
    private javax.swing.JLabel BilletJLabel1;
    private javax.swing.JLabel BilletJLabel2;
    private javax.swing.JLabel BilletJLabel3;
    private javax.swing.JLabel BindeJLabel;
    private javax.swing.JLabel BindeJLabel1;
    private javax.swing.JLabel BindeJLabel2;
    private javax.swing.JLabel BindeJLabel3;
    private javax.swing.JLabel DateFINISHJLabel;
    private javax.swing.JLabel DateFINISHJLabel1;
    private javax.swing.JLabel DateFINISHJLabel2;
    private javax.swing.JLabel DateFINISHJLabel3;
    private javax.swing.JLabel DateSTARTJLabel;
    private javax.swing.JLabel DateSTARTJLabel1;
    private javax.swing.JLabel DateSTARTJLabel2;
    private javax.swing.JLabel DateSTARTJLabel3;
    private javax.swing.JLabel KundeInputJLabel;
    private javax.swing.JLabel KundeInputJLabel1;
    private javax.swing.JLabel KundeInputJLabel2;
    private javax.swing.JLabel KundeInputJLabel3;
    private javax.swing.JLabel KundeJLabel;
    private javax.swing.JLabel KundeJLabel1;
    private javax.swing.JLabel KundeJLabel2;
    private javax.swing.JLabel KundeJLabel3;
    private javax.swing.JLabel PortalenTextJLabel;
    private javax.swing.JLabel PortalenTextJLabel1;
    private javax.swing.JLabel PortalenTextJLabel2;
    private javax.swing.JLabel PortalenTextJLabel3;
    private javax.swing.JButton Print;
    private javax.swing.JLabel PrisInputJLabel;
    private javax.swing.JLabel PrisInputJLabel1;
    private javax.swing.JLabel PrisInputJLabel2;
    private javax.swing.JLabel PrisInputJLabel3;
    private javax.swing.JLabel PrisJLabel;
    private javax.swing.JLabel PrisJLabel1;
    private javax.swing.JLabel PrisJLabel2;
    private javax.swing.JLabel PrisJLabel3;
    private javax.swing.JLabel PrisOriInputJLabel1;
    private javax.swing.JLabel PrisOriInputJLabel2;
    private javax.swing.JLabel PrisOriInputJLabel3;
    private javax.swing.JLabel PrisOriInputJLabel4;
    private javax.swing.JLabel PrisOriJLabel;
    private javax.swing.JLabel PrisOriJLabel1;
    private javax.swing.JLabel PrisOriJLabel2;
    private javax.swing.JLabel PrisOriJLabel3;
    private javax.swing.JLabel RabatInputJLabel;
    private javax.swing.JLabel RabatInputJLabel1;
    private javax.swing.JLabel RabatInputJLabel2;
    private javax.swing.JLabel RabatInputJLabel3;
    private javax.swing.JLabel RabetJLabel;
    private javax.swing.JLabel RabetJLabel1;
    private javax.swing.JLabel RabetJLabel2;
    private javax.swing.JLabel RabetJLabel3;
    private javax.swing.JLabel StageJLabel;
    private javax.swing.JLabel StageJLabel1;
    private javax.swing.JLabel StageJLabel2;
    private javax.swing.JLabel StageJLabel3;
    private javax.swing.JLabel TextJLabel1;
    private javax.swing.JLabel TextJLabel10;
    private javax.swing.JLabel TextJLabel11;
    private javax.swing.JLabel TextJLabel12;
    private javax.swing.JLabel TextJLabel2;
    private javax.swing.JLabel TextJLabel3;
    private javax.swing.JLabel TextJLabel4;
    private javax.swing.JLabel TextJLabel5;
    private javax.swing.JLabel TextJLabel6;
    private javax.swing.JLabel TextJLabel7;
    private javax.swing.JLabel TextJLabel8;
    private javax.swing.JLabel TextJLabel9;
    private javax.swing.JLabel TitelJLabel;
    private javax.swing.JLabel TitelJLabel1;
    private javax.swing.JLabel TitelJLabel2;
    private javax.swing.JLabel TitelJLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration


}
