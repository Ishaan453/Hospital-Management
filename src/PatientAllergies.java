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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Pname = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("View or Update Allergies");

        AllergyDis.setEditable(false);
        AllergyDis.setColumns(20);
        AllergyDis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AllergyDis.setRows(7);
        AllergyDis.setText("Hello\nworld");
        jScrollPane1.setViewportView(AllergyDis);

        allergyText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setText("Add Allergy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remove Allergy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Patient Name:");

        Pname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Pname.setText("jLabel3");

        jButton3.setText("Return to Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        error.setForeground(new java.awt.Color(255, 51, 51));
        error.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(Pname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(allergyText)
                            .addComponent(jScrollPane1)
                            .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Pname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(allergyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        PatientMenu pm = new PatientMenu(PatientID);
        pm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JTextField allergyText;
    private javax.swing.JLabel error;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}