/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author ishaa
 */
public class PatientAllergies extends javax.swing.JFrame {
    int PatientID;
    /**
     * Creates new form PatientAllergies
     */
    public PatientAllergies(int pid) {
        initComponents();
        PatientID = pid;
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_Management", "root", "!shuB0410");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT Name FROM Patients WHERE Patient_ID=" + PatientID);
            if(rs.next()){
                Pname.setText(rs.getString("Name"));
            }
            setAllergyDisplay(s);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    void setAllergyDisplay(Statement s){
        try{
            ResultSet rs = s.executeQuery("SELECT Allergy FROM patient_allergies WHERE Patient_ID=" + PatientID);
            AllergyDis.setText("");
            while(rs.next()){
                AllergyDis.setText(AllergyDis.getText() + "" + rs.getString("Allergy") + "\n");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        AllergyDis = new javax.swing.JTextArea();
        allergyText = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
        rem_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Pname = new javax.swing.JLabel();
        return_btn = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 415));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("View or Update Allergies");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(89, 6, 240, 25);

        AllergyDis.setEditable(false);
        AllergyDis.setColumns(20);
        AllergyDis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AllergyDis.setRows(7);
        AllergyDis.setText("Hello\nworld");
        jScrollPane1.setViewportView(AllergyDis);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(72, 72, 254, 146);

        allergyText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(allergyText);
        allergyText.setBounds(72, 242, 254, 26);

        add_btn.setText("Add Allergy");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });
        getContentPane().add(add_btn);
        add_btn.setBounds(72, 286, 110, 23);

        rem_btn.setText("Remove Allergy");
        rem_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rem_btnActionPerformed(evt);
            }
        });
        getContentPane().add(rem_btn);
        rem_btn.setBounds(206, 286, 120, 23);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Patient Name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(72, 40, 90, 20);

        Pname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Pname.setText("jLabel3");
        getContentPane().add(Pname);
        Pname.setBounds(178, 40, 148, 20);

        return_btn.setText("Return to Menu");
        return_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_btnActionPerformed(evt);
            }
        });
        getContentPane().add(return_btn);
        return_btn.setBounds(136, 327, 113, 23);

        error.setForeground(new java.awt.Color(255, 51, 51));
        error.setText("    ");
        getContentPane().add(error);
        error.setBounds(72, 356, 254, 16);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OIP (2).jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-40, -10, 860, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        // TODO add your handling code here:
        String allergy = allergyText.getText();
        if(allergy.isEmpty()){
            error.setText("Please enter allergy to Enter first");
            return;
        }
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_Management", "root", "!shuB0410");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Patient_allergies WHERE Patient_ID=" + PatientID + " AND Allergy= '" + allergy + "';");
            if(rs.next()){
                error.setText("Allergy already exists");
                return;
            }
            s.executeUpdate("INSERT INTO Patient_Allergies (Patient_ID, Allergy) VALUES (" + PatientID + ", '" + allergy + "');");
            setAllergyDisplay(s);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void rem_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rem_btnActionPerformed
        // TODO add your handling code here:
        String allergy = allergyText.getText();
        if(allergy.isEmpty()){
            error.setText("Please enter allergy to Enter first");
            return;
        }
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_Management", "root", "!shuB0410");
            Statement s = con.createStatement();
            int rowA = s.executeUpdate("DELETE FROM Patient_Allergies WHERE Patient_ID=" + PatientID + " AND Allergy= '" + allergy + "';");
            setAllergyDisplay(s);
            if(rowA == 0){
                error.setText("No Allergy found");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_rem_btnActionPerformed

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
            java.util.logging.Logger.getLogger(PatientAllergies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientAllergies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientAllergies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientAllergies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PatientAllergies().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AllergyDis;
    private javax.swing.JLabel Pname;
    private javax.swing.JButton add_btn;
    private javax.swing.JTextField allergyText;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rem_btn;
    private javax.swing.JButton return_btn;
    // End of variables declaration//GEN-END:variables
}
