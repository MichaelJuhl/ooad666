package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DeleteDialogYN2 {
	
	/*
	 * Klasse til at vise en sletnings dialog.
	 * 
	 * Brug: new DialogDelete().userAcceptsDelete("hvad-der-skal-slettet");
	 * 		 Dette returnerer 'true' hvis brugeren trykker "ja" og 'false' hvis brugeren trykker "nej".
	 */
	
	public static boolean userAcceptsDelete(String deleteItem) {
		JOptionPane pane = new JOptionPane("Er du sikker på at du vil slette\n\"" + deleteItem + "\"?");
		Object[] options = new String[] { "Ja", "Nej" };
		pane.setOptions(options);
		JDialog dialog = pane.createDialog(new JFrame(), "Slet");
		dialog.pack();
		dialog.setVisible(true);
		Object obj = pane.getValue(); 
		int result = -1;
		dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		for (int k = 0; k < options.length; k++)
			if (options[k].equals(obj))
				result = k;

		if (result == 0) {
			//System.out.println("Ja"); //debug
			dialog.dispose();
			return true;
		} else {
			//System.out.println("nej"); //debug
			dialog.dispose();
			return false;
		}
	}
}