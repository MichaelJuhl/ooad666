package MainController;

import GUI.LoginDialog;
import GUI.LoginDialogDBChecker;
import GUI.PortalManagerMainFrame;

public class MainController {

	LoginDialog loginDialog;
	
	public MainController() {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	// Run Login Dialog
            	loginDialog = new LoginDialog(new java.awt.Frame(), true);
                loginDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                // ---------------
                
                loginDialog.setVisible(true);
            	
                //new PortalManagerMainFrame();
            }
        });
		(new LoginDialogDBChecker(this)).start();
	}
	
	public void setLoginDBStatus(long connectTime) {
		loginDialog.setDBOnline(connectTime);
	}
	
    public static void main(String[] args) {
    	new MainController();
    }

}
