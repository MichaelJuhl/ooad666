package GUI;

import java.util.Calendar;

import dal.Event;
/**
 *
 * @author User
 */
public class editEventDialog extends javax.swing.JDialog {
	
	Event event;
	
    /** Creates new form editEventDialog */
    public editEventDialog(java.awt.Frame parent, boolean modal, Event event) {
        super(parent, modal);
        this.event = event;
        initComponents();

        //set up input fields for edit
        eventTitelInputField.setText(event.getTitel());
        eventArtistInputField.setText(event.getArtist());
        eventConcerttypeInputField.setText(event.getConcerttype());
        eventPriceInputField.setText(new Double(event.getPrice()).toString());
        eventPortalisDiscountField.setText(new Double(event.getPortalisDiscount()).toString());
        eventShowDiscountField.setText(new Double(event.getShowDiscount()).toString());
        //
    }
             
    private void initComponents() {

        eventTitelLabel = new javax.swing.JLabel();
        eventTitelInputField = new javax.swing.JTextField();
        eventArtistLabel = new javax.swing.JLabel();
        eventArtistInputField = new javax.swing.JTextField();
        eventSceneLabel = new javax.swing.JLabel();
        eventSceneInputComboBox = new javax.swing.JComboBox();
        eventConcerttypeLabel = new javax.swing.JLabel();
        eventConcerttypeInputField = new javax.swing.JTextField();
        eventStartLabel = new javax.swing.JLabel();
        eventEndLabel = new javax.swing.JLabel();
        eventPriceLabel = new javax.swing.JLabel();
        eventShowDiscountLabel = new javax.swing.JLabel();
        eventPortalisDiscountLabel = new javax.swing.JLabel();
        eventStartYearComboBox = new javax.swing.JComboBox();
        eventStartMonthComboBox = new javax.swing.JComboBox();
        eventStartDateComboBox = new javax.swing.JComboBox();
        eventStartTimeField = new javax.swing.JTextField();
        eventEndMonthComboBox = new javax.swing.JComboBox();
        eventEndYearComboBox = new javax.swing.JComboBox();
        eventEndDateComboBox = new javax.swing.JComboBox();
        eventEndTimeField = new javax.swing.JTextField();
        eventPriceInputField = new javax.swing.JTextField();
        eventKrLabel = new javax.swing.JLabel();
        eventShowDiscountField = new javax.swing.JTextField();
        eventPortalisDiscountField = new javax.swing.JTextField();
        eventProcentLabel1 = new javax.swing.JLabel();
        eventProcentLabel2 = new javax.swing.JLabel();
        eventErrorLabel = new javax.swing.JLabel();
        eventDiscardButton = new javax.swing.JButton();
        eventSaveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        eventTitelLabel.setText("Titel");

        eventArtistLabel.setText("Kunstner");

        eventSceneLabel.setText("Scene");

        eventSceneInputComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Koncertsal", "Foyerscene", "Store scene", "Lille scene" , "Galleriscenen" , "Galleri 1", "Galleri 2", "Galleri 3" }));

        eventConcerttypeLabel.setText("Koncerttype");

        eventStartLabel.setText("Start");

        eventEndLabel.setText("Slut");

        eventPriceLabel.setText("Pris");

        eventShowDiscountLabel.setText("ShowPortalis tilbud");

        eventPortalisDiscountLabel.setText("Portalis tilbud");

        eventStartYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeYearArray()));
        //eventStartYearComboBox.setSelectedItem(String.valueOf(event.getDateStart().getYear()));

        eventStartMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeMonthArray()));
        //eventStartMonthComboBox.setSelectedItem(String.valueOf(event.getDateStart().getMonth()));

        eventStartDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeDayArray()));
        System.out.println(event.getDateStart().get(Calendar.DAY_OF_MONTH) + "");
        //eventStartDateComboBox.setSelectedIndex(event.getDateStart().get(Calendar.DAY_OF_MONTH));
        
        //eventStartTimeField.setText(event.getDateStart().getHours() + ":" + event.getDateStart().getMinutes());
        
        eventEndYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeYearArray()));
        //eventEndYearComboBox.setSelectedItem(String.valueOf(event.getDateFinish().getMonth()));
        
        eventEndMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeMonthArray()));
        //eventEndMonthComboBox.setSelectedItem(String.valueOf(event.getDateFinish().getYear()));
        
        eventEndDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeDayArray()));
        //eventEndDateComboBox.setSelectedItem(String.valueOf(event.getDateFinish().getDay()));

        //eventEndTimeField.setText(event.getDateFinish().getHours() + ":" + event.getDateFinish().getMinutes());

        eventKrLabel.setText("Kr");

        eventProcentLabel1.setText("%");

        eventProcentLabel2.setText("%");

        eventErrorLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        eventErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        eventErrorLabel.setText(" ");

        eventDiscardButton.setText("Annuller");
        eventDiscardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventDiscardButtonActionPerformed(evt);
            }
        });

        eventSaveButton.setText("Gem");
        eventSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eventArtistLabel)
                                        .addComponent(eventTitelLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eventArtistInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                        .addComponent(eventTitelInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eventSceneLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(eventSceneInputComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eventConcerttypeLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(eventConcerttypeInputField, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eventPriceLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventPriceInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventKrLabel))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eventShowDiscountLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventShowDiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventProcentLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eventEndLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(eventEndYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventEndMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventEndDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventEndTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(eventStartLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventStartYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventStartMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventStartDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(eventStartTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eventPortalisDiscountLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eventPortalisDiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eventProcentLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eventErrorLabel)
                            .addContainerGap(387, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(eventSaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eventDiscardButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventTitelLabel)
                    .addComponent(eventTitelInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventArtistLabel)
                    .addComponent(eventArtistInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventSceneLabel)
                    .addComponent(eventSceneInputComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventConcerttypeLabel)
                    .addComponent(eventConcerttypeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventStartYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventStartLabel)
                    .addComponent(eventStartMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventStartDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventStartTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventEndLabel)
                    .addComponent(eventEndMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventEndDateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventEndYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventEndTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventPriceLabel)
                    .addComponent(eventPriceInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventKrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventShowDiscountLabel)
                    .addComponent(eventShowDiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventProcentLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventPortalisDiscountLabel)
                    .addComponent(eventPortalisDiscountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventProcentLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventDiscardButton)
                    .addComponent(eventSaveButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }                    

    private String[] makeYearArray() {
    	int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    	
    	String[] years = new String[51];
    	int y = 0;
    	for(int i=currentYear; i<=currentYear+50; i++) {
    		years[y] = String.valueOf(i);
    		y++;
    	}
		return years;
	}
    
    private String[] makeMonthArray() {
    	String[] months = new String[12];
    	for(int i=1; i<=12; i++) {
    		months[i-1]=String.valueOf(i);
    	}
    	return months;
    }
    
    private String[] makeDayArray() {
    	String[] days = new String[31];
    	for(int i=1; i<=31; i++) {
    		days[i-1]=String.valueOf(i);
    	}
    	return days;
    }
    
    private void eventDiscardButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        this.setVisible(false);
    }                                                  

    private void eventSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
     //Validate input
            //check titel
        if (eventTitelInputField.getText().equals("")) {
            eventErrorLabel.setText("Fejl: Titel kan ikke vaere tom");
            return;
        }
            //check artist
        if (eventArtistInputField.getText().equals("")) {
            eventErrorLabel.setText("Fejl: Kunstner kan ikke vaere tom");
            return;
        }
            //check concerttype
        if (eventConcerttypeInputField.getText().equals("")) {
            eventErrorLabel.setText("Fejl: Koncerttype kan ikke vaere tom");
            return;
        }
            //check starttime
        if (!timeValidate(eventStartTimeField.getText())) {
            eventErrorLabel.setText("Fejl: Ugyldigt starttidspunkt");
            return;
        }
            //check endtime
        if (!timeValidate(eventEndTimeField.getText())) {
            eventErrorLabel.setText("Fejl: Ugyldigt sluttidspunkt");
            return;
        }
            //check that endtime is after starttime
        if (!endTimeAfterStartTime()) {
            eventErrorLabel.setText("Fejl: Starttidspunkt kan ikke vaere foer sluttidspunkt");
            return;
        }
            //check pris
        if (!isNumber(eventPriceInputField.getText())) {
            eventErrorLabel.setText("Fejl: Ugyldig pris");
            return;
        }
            //check ShowPortalis tilbud %
        if (!isProcent(eventShowDiscountField.getText())) {
            eventErrorLabel.setText("Fejl: Ugyldigt ShowPortalis tilbud");
            return;
        }
            //check ShowPortalis tilbud %
        if (!isProcent(eventPortalisDiscountField.getText())) {
            eventErrorLabel.setText("Fejl: Ugyldigt Portalis tilbud");
            return;
        }

        //Validation passed, make new event
        //TODO do it...
        this.dispose();
    }                                               

    private boolean timeValidate(String text) {
        return true;
    }

    private boolean endTimeAfterStartTime() {
        return true;
    }

    private boolean isNumber(String text) {
        return true;
    }

    private boolean isProcent(String text) {
        return true;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField eventArtistInputField;
    private javax.swing.JLabel eventArtistLabel;
    private javax.swing.JTextField eventConcerttypeInputField;
    private javax.swing.JLabel eventConcerttypeLabel;
    private javax.swing.JButton eventDiscardButton;
    private javax.swing.JComboBox eventEndDateComboBox;
    private javax.swing.JLabel eventEndLabel;
    private javax.swing.JComboBox eventEndMonthComboBox;
    private javax.swing.JTextField eventEndTimeField;
    private javax.swing.JComboBox eventEndYearComboBox;
    private javax.swing.JLabel eventErrorLabel;
    private javax.swing.JLabel eventKrLabel;
    private javax.swing.JTextField eventPortalisDiscountField;
    private javax.swing.JLabel eventPortalisDiscountLabel;
    private javax.swing.JTextField eventPriceInputField;
    private javax.swing.JLabel eventPriceLabel;
    private javax.swing.JLabel eventProcentLabel1;
    private javax.swing.JLabel eventProcentLabel2;
    private javax.swing.JButton eventSaveButton;
    private javax.swing.JComboBox eventSceneInputComboBox;
    private javax.swing.JLabel eventSceneLabel;
    private javax.swing.JTextField eventShowDiscountField;
    private javax.swing.JLabel eventShowDiscountLabel;
    private javax.swing.JComboBox eventStartDateComboBox;
    private javax.swing.JLabel eventStartLabel;
    private javax.swing.JComboBox eventStartMonthComboBox;
    private javax.swing.JTextField eventStartTimeField;
    private javax.swing.JComboBox eventStartYearComboBox;
    private javax.swing.JTextField eventTitelInputField;
    private javax.swing.JLabel eventTitelLabel;
    // End of variables declaration                   

}