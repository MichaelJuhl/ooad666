package GUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * buyTicketDialog.java
 *
 * Created on 08-11-2009, 16:51:00
 */


import dal.Event;
import dal.Member;
import dalinterface.DALException;
import dao.MemberDAO;


/**
 *
 * @author Michael
 */
public class buyTicketDialog extends javax.swing.JDialog {
	double pris;
	double showdiscount;
	double portalisdiscount;
	private PortalManagerMainFrame mainFrame;
	Event event2;
	Member customer;

    /** Creates new form buyTicketDialog */
    public buyTicketDialog(java.awt.Frame parent, boolean modal, Event event,PortalManagerMainFrame mainFrame) {
        super(parent, modal);
        this.mainFrame = mainFrame;
        initComponents();
        pris = event.getPrice();
        showdiscount = event.getShowDiscount();
        portalisdiscount = event.getPortalisDiscount();
        event2 = event;
        MedlemIDTextfield.setText(null);

        
        TitelJLabel.setText(event.getTitel());
        DateSTARTJLabel.setText(event.getDateStartString());
        DateFINISHJLabel.setText(event.getDateFinishString());
        StageJLabel.setText(event.getStage());
        PrisOriInputJLabel1.setText(Double.toString(event.getPrice()));
        ArtistJLabel.setText(event.getArtist());
        RabatSHOWInputJLabel.setText(event.getShowDiscount()+"");
        RabatNORMInputJLabel.setText(event.getPortalisDiscount()+"");
        jLabel4.setText(
        		(((jComboBox1.getSelectedIndex()+1)*event.getPrice())-((((jComboBox1.getSelectedIndex()+1)*event.getPrice())/100)*event.getShowDiscount()))+"kr / "
        		+(((jComboBox1.getSelectedIndex()+1)*event.getPrice())-((((jComboBox1.getSelectedIndex()+1)*event.getPrice())/100)*event.getPortalisDiscount()))+"kr / "
        		+((jComboBox1.getSelectedIndex()+1)*event.getPrice())+"kr");
        
        



    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        MedlemIDTextfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TitelJLabel = new javax.swing.JLabel();
        ArtistJLabel = new javax.swing.JLabel();
        DateSTARTJLabel = new javax.swing.JLabel();
        TextJLabel1 = new javax.swing.JLabel();
        BindeJLabel = new javax.swing.JLabel();
        DateFINISHJLabel = new javax.swing.JLabel();
        TextJLabel2 = new javax.swing.JLabel();
        StageJLabel = new javax.swing.JLabel();
        RabetSHOWJLabel = new javax.swing.JLabel();
        RabatSHOWInputJLabel = new javax.swing.JLabel();
        PrisOriJLabel = new javax.swing.JLabel();
        PrisOriInputJLabel1 = new javax.swing.JLabel();
        TextJLabel3 = new javax.swing.JLabel();
        TextJLabel4 = new javax.swing.JLabel();
        RabetNORMJLabel = new javax.swing.JLabel();
        RabatNORMInputJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("MedlemID:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Antal Billetter:");

        jLabel3.setText("Samlet Pris:");

        jLabel4.setText("450kr");

        jButton1.setText("K�b");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButtonkoebActionPerformed(evt);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        TitelJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TitelJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TitelJLabel.setText("Airbourne");

        ArtistJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ArtistJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ArtistJLabel.setText("Airbourne");

        DateSTARTJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DateSTARTJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DateSTARTJLabel.setText("1000-01-01 00:00:00");

        TextJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextJLabel1.setText("Titel:");

        BindeJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        BindeJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BindeJLabel.setText("-");

        DateFINISHJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DateFINISHJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DateFINISHJLabel.setText("1000-01-01 00:00:00");

        TextJLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextJLabel2.setText("Kunstner:");

        StageJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        StageJLabel.setText("Store Scene");

        RabetSHOWJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabetSHOWJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RabetSHOWJLabel.setText("Showpotalis Rabat:");

        RabatSHOWInputJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RabatSHOWInputJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RabatSHOWInputJLabel.setText("25%");

        PrisOriJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        PrisOriJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PrisOriJLabel.setText("Pris:");

        PrisOriInputJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PrisOriInputJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PrisOriInputJLabel1.setText("200kr");

        TextJLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextJLabel3.setText("Dato:");

        TextJLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        TextJLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextJLabel4.setText("Sted:");

        RabetNORMJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabetNORMJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RabetNORMJLabel.setText("Potalis Rabat:");

        RabatNORMInputJLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        RabatNORMInputJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RabatNORMInputJLabel.setText("25%");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MedlemIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TextJLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RabetSHOWJLabel)
                            .addComponent(RabetNORMJLabel)
                            .addComponent(TextJLabel4)
                            .addComponent(TextJLabel3)
                            .addComponent(TextJLabel1)
                            .addComponent(PrisOriJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrisOriInputJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(RabatSHOWInputJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StageJLabel)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(DateSTARTJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(BindeJLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DateFINISHJLabel))
                                    .addComponent(TitelJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ArtistJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addComponent(RabatNORMInputJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(MedlemIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TitelJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel2)
                    .addComponent(ArtistJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DateSTARTJLabel)
                    .addComponent(TextJLabel3)
                    .addComponent(BindeJLabel)
                    .addComponent(DateFINISHJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextJLabel4)
                    .addComponent(StageJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RabetSHOWJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RabatSHOWInputJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RabetNORMJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RabatNORMInputJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrisOriJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrisOriInputJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    	jLabel4.setText(
        		(((jComboBox1.getSelectedIndex()+1)*pris)-((((jComboBox1.getSelectedIndex()+1)*pris)/100)*showdiscount))+"kr / "
        		+(((jComboBox1.getSelectedIndex()+1)*pris)-((((jComboBox1.getSelectedIndex()+1)*pris)/100)*portalisdiscount))+"kr / "
        		+((jComboBox1.getSelectedIndex()+1)*pris)+"kr");
    }

    private void jButtonkoebActionPerformed(java.awt.event.ActionEvent evt) throws NumberFormatException, DALException {
    	
    	if (MedlemIDTextfield.getText().equals("")|| MedlemIDTextfield.getText().equals("G�st")){
        	customer = new MemberDAO().getMember(1);
    	}else{
    		customer = new MemberDAO().getMember(Integer.parseInt(MedlemIDTextfield.getText()));
    	}

    	//this.dispose();
		ticketEventDialog dialog = new ticketEventDialog(this, rootPaneCheckingEnabled, event2,customer,jComboBox1.getSelectedIndex()+1, mainFrame);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
    }

    /**
    * @param args the command line arguments
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                buyTicketDialog dialog = new buyTicketDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel BindeJLabel;
    private javax.swing.JLabel DateFINISHJLabel;
    private javax.swing.JLabel DateSTARTJLabel;
    private javax.swing.JTextField MedlemIDTextfield;
    private javax.swing.JLabel PrisOriInputJLabel1;
    private javax.swing.JLabel PrisOriJLabel;
    private javax.swing.JLabel RabatNORMInputJLabel;
    private javax.swing.JLabel RabatSHOWInputJLabel;
    private javax.swing.JLabel RabetNORMJLabel;
    private javax.swing.JLabel RabetSHOWJLabel;
    private javax.swing.JLabel StageJLabel;
    private javax.swing.JLabel TextJLabel1;
    private javax.swing.JLabel TextJLabel2;
    private javax.swing.JLabel TextJLabel3;
    private javax.swing.JLabel TextJLabel4;
    private javax.swing.JLabel TitelJLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration

}
