
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ishaa
 */
public class latestTestResults extends javax.swing.JFrame {
    int PatientID;
    /**
     * Creates new form latestTestResults
     */
    public latestTestResults(int pid) {
        initComponents();
        PatientID = pid;
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_Management", "root", "!shuB0410");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT Name FROM Patients WHERE Patient_ID=" + PatientID);
            if(rs.next()){
                Pname.setText("Patient Name: " + rs.getString("Name"));
            }
            String query ="SELECT t.Test_ID, t.Doctor_ID, tr.Results "
                     + "FROM Tests t "
                     + "JOIN Test_Results tr ON t.Test_ID = tr.Test_ID "
                     + "WHERE t.Patient_ID ="+ PatientID + " "
                     + "ORDER BY tr.Result_ID desc LIMIT 1";
            System.out.println(query);
            rs = s.executeQuery(query);
            if(rs.next()){
                result.setText(rs.getString("Results"));
            }
            else{
                result.setText("No Test Results found.");
                return;
            }
            
            rs = s.executeQuery("SELECT Name FROM Staff WHERE Staff_ID=" + rs.getInt("Doctor_ID"));
            if(rs.next()){
                Dname.setText("Doctor Name: " + rs.getString("Name"));
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Pname = new javax.swing.JLabel();
        Dname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        return_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 200));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Test Results");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(202, 14, 102, 25);

        Pname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Pname.setText("Patient Name: ");
        getContentPane().add(Pname);
        Pname.setBounds(18, 57, 220, 20);

        Dname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Dname.setText("Doctor Name: ");
        getContentPane().add(Dname);
        Dname.setBounds(267, 57, 190, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Result:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 95, 50, 20);

        result.setText("jLabel5");
        getContentPane().add(result);
        result.setBounds(119, 98, 335, 16);

        return_btn.setText("Return to Menu");
        return_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_btnActionPerformed(evt);
            }
        });
        getContentPane().add(return_btn);
        return_btn.setBounds(189, 127, 113, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OIP (2).jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, -10, 780, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void return_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_btnActionPerformed
        // TODO add your handling code here:
        PatientMenu pm = new PatientMenu(PatientID);
        pm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_return_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(latestTestResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(latestTestResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(latestTestResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(latestTestResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new latestTestResults().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dname;
    private javax.swing.JLabel Pname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel result;
    private javax.swing.JButton return_btn;
    // End of variables declaration//GEN-END:variables
}
