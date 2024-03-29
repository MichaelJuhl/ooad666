package GUI;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import dal.Event;
import dao.EventDAO;
import daoInterface.DALException;
/**
 *
 * @author User
 */
public class EventEditDialog extends javax.swing.JDialog {

	private Event event;
	private EventList eventList;

	/** Creates new form editEventDialog */
	public EventEditDialog(java.awt.Frame parent, boolean modal, Event event, EventList eventList) {
		super(parent, modal);
		this.eventList = eventList;
		this.event = event;
		initComponents();

		//set up input fields for edit
		eventTitelInputField.setText(event.getTitel());
		eventArtistInputField.setText(event.getArtist());
		eventConcerttypeInputField.setText(event.getConcertType());
		eventPriceInputField.setText(String.valueOf(event.getPrice()));
		eventPortalisDiscountField.setText(new Double(event.getPortalisDiscount()).toString());
		eventShowDiscountField.setText(new Double(event.getShowDiscount()).toString());
		//
	}

	private void initComponents() {

		eventTitelLabel = new javax.swing.JLabel();
		eventTitelInputField = new javax.swing.JTextField();
		eventArtistLabel = new javax.swing.JLabel();
		eventArtistInputField = new javax.swing.JTextField();
		eventStageLabel = new javax.swing.JLabel();
		eventStageInputComboBox = new javax.swing.JComboBox();
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
		setResizable(false);

		eventTitelLabel.setText("Titel");

		eventArtistLabel.setText("Kunstner");

		eventStageLabel.setText("Scene");

		eventStageInputComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Koncertsal", "Foyerscene", "Store scene", "Lille scene" , "Galleriscenen" , "Galleri 1", "Galleri 2", "Galleri 3" }));
		eventStageInputComboBox.setSelectedItem(event.getStage());

		eventConcerttypeLabel.setText("Koncerttype");

		eventStartLabel.setText("Start");

		eventEndLabel.setText("Slut");

		eventPriceLabel.setText("Pris");

		eventShowDiscountLabel.setText("ShowPortalis tilbud");

		eventPortalisDiscountLabel.setText("Portalis tilbud");

		eventStartYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(event.getStartYearArray()));
		eventStartYearComboBox.setSelectedItem(String.valueOf(event.getStartYear()));

		eventStartMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeMonthArray()));
		eventStartMonthComboBox.setSelectedItem(String.valueOf(event.getStartMonth()+1));

		eventStartDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeDayArray()));
		eventStartDateComboBox.setSelectedItem(String.valueOf(event.getStartDay()));
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		eventStartTimeField.setText(dateFormat.format(event.getDateStart().getTime()));

		eventEndYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(event.getStartYearArray()));
		eventEndYearComboBox.setSelectedItem(String.valueOf(event.getDateFinish().get(Calendar.YEAR)));

		eventEndMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeMonthArray()));
		eventEndMonthComboBox.setSelectedItem(String.valueOf(event.getDateFinish().get(Calendar.MONTH)+1));

		eventEndDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(makeDayArray()));
		eventEndDateComboBox.setSelectedItem(String.valueOf(event.getDateFinish().get(Calendar.DAY_OF_MONTH)));
		
		eventEndTimeField.setText(dateFormat.format(event.getDateFinish().getTime()));

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
																						.addComponent(eventStageLabel)
																						.addGap(18, 18, 18)
																						.addComponent(eventStageInputComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
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
												.addComponent(eventStageLabel)
												.addComponent(eventStageInputComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

	private void eventDiscardButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
		this.setVisible(false);
	}                                                  

	private void eventSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
		//Validate input
		eventErrorLabel.setText("");
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
		} else if(eventStartTimeField.getText().length()==4) {
			eventStartTimeField.setText("0" + eventStartTimeField.getText());
		}

		//check endtime
		if (!timeValidate(eventEndTimeField.getText())) {
			eventErrorLabel.setText("Fejl: Ugyldigt sluttidspunkt");
			return;
		} else if(eventEndTimeField.getText().length()==4) {
			eventEndTimeField.setText("0" + eventEndTimeField.getText());
		}
		//check that endtime is after starttime
		if (!endTimeAfterStartTime()) {
			eventErrorLabel.setText("Fejl: Starttidspunkt kan ikke vaere foer sluttidspunkt");
			return;
		}
		//check pris
		if (!isDouble(eventPriceInputField.getText())) {
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

		//Basic validation passed, create event object
		event.setConcerttype(eventConcerttypeInputField.getText());
		event.setStage((String)eventStageInputComboBox.getSelectedItem());
		event.setDateStart(getStartTime());
		event.setDateFinish(getEndTime());
		event.setArtist(eventArtistInputField.getText());
		event.setTitel(eventTitelInputField.getText());
		event.setPrice(Double.valueOf(eventPriceInputField.getText()));
		event.setShowDiscount(Double.valueOf(eventShowDiscountField.getText()));
		event.setPortalisDiscount(Double.valueOf(eventPortalisDiscountField.getText()));
		
		EventDAO eventDAO = new EventDAO();
		try {
			if (eventDAO.otherEventInTimeslot(event)) {
				JOptionPane.showMessageDialog(this, "Tidsperioden for dette arrangement overlapper et andet arrangement p� denne Scene", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (DALException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (InstantiationException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
			
		
		//All validation passed, commit to database
		try {
			eventDAO.updateEvent(event);
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return;
		} catch (DALException e) {
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return;
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Databasefejl: Kunne ikke redigere arrangement", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return;
		}
		eventList.updateTable();
		this.dispose();
	}                                               

	private boolean timeValidate(String text) {
		try{
			Pattern timePattern = Pattern.compile("^(20|21|22|23|[01]\\d|\\d)(([:][0-5]\\d){1,2})$");
			Matcher timeMatcher = timePattern.matcher(text);
			if (timeMatcher.matches()) {
				if (text.length()==4)
					text = "0"+text;
				return true;
			}
			else
				return false;

		} catch(java.util.regex.PatternSyntaxException e){
			System.out.println("Invalid regex pattern when matching time");
			e.printStackTrace();
			return false;
		}
	}

	private Calendar getStartTime() {
		int startTimeYear = Integer.valueOf((String)eventStartYearComboBox.getSelectedItem());
		int startTimeMonth = Integer.valueOf((String)eventStartMonthComboBox.getSelectedItem())-1;
		int startTimeDate = Integer.valueOf((String)eventStartDateComboBox.getSelectedItem());
		int startTimeHour = Integer.valueOf(eventStartTimeField.getText().substring(0, 2));
		int startTimeMinute = Integer.valueOf(eventStartTimeField.getText().substring(3, 5));

		Calendar startTime = GregorianCalendar.getInstance();
		startTime.clear();
		startTime.set(startTimeYear, startTimeMonth, startTimeDate, startTimeHour, startTimeMinute, 0);

		return startTime;
	}

	private Calendar getEndTime() {
		int endTimeYear = Integer.valueOf((String)eventEndYearComboBox.getSelectedItem());
		int endTimeMonth = Integer.valueOf((String)eventEndMonthComboBox.getSelectedItem())-1;
		int endTimeDate = Integer.valueOf((String)eventEndDateComboBox.getSelectedItem());
		int endTimeHour = Integer.valueOf(eventEndTimeField.getText().substring(0, 2));
		int endTimeMinute = Integer.valueOf(eventEndTimeField.getText().substring(3, 5));

		Calendar endTime = GregorianCalendar.getInstance();
		endTime.clear();
		endTime.set(endTimeYear, endTimeMonth, endTimeDate, endTimeHour, endTimeMinute, 0);

		return endTime;
	}

	private boolean endTimeAfterStartTime() {
		return getStartTime().compareTo(getEndTime()) < 0;
	}

	private boolean isDouble(String text) {
		try {
			Double.valueOf(text);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private boolean isProcent(String text) {
		try {
			Double d = Double.valueOf(text);
			if (d<0 || d>100)
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
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
	private javax.swing.JComboBox eventStageInputComboBox;
	private javax.swing.JLabel eventStageLabel;
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