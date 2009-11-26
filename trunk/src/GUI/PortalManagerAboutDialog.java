/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PortalManagerAboutDialog.java
 *
 * Created on 22-10-2009, 09:53:55
 */

package GUI;

/**
 *
 * @author User
 */
public class PortalManagerAboutDialog extends javax.swing.JDialog {

    /** Creates new form PortalManagerAboutDialog */
    public PortalManagerAboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureLabel = new javax.swing.JLabel();
        Heading = new javax.swing.JLabel();
        textScrollPane = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Om ");

        pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("resources/mugShot.png"))); // NOI18N

        Heading.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Heading.setText("Portal Manager");

        textPane.setEditable(false);
        textPane.setText("Dette er en prototype af PortalManager. Et CMS-system til kulturhuset Portalen der holder styr paa deres arrangementer, medarbejdere og medlemmer af deres klubber.\n\nLavet af:\nAbdigani Diriye\nSvante J�rgensen\nCasper Skoubo\nMichael Juhl");
        textScrollPane.setViewportView(textPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pictureLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(textScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Heading)
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureLabel)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    /**
    * @param args the command line arguments
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PortalManagerAboutDialog dialog = new PortalManagerAboutDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
	*/
    
    // Variables declaration - do not modify
    private javax.swing.JLabel Heading;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JTextPane textPane;
    private javax.swing.JScrollPane textScrollPane;
    // End of variables declaration

}
