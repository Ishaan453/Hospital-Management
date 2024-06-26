/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author ishaa
 */
public class PatientBill extends javax.swing.JFrame {
    int PatientID;
    /**
     * Creates new form PatientBill
     */
    public PatientBill(int paid) {
        initComponents();
        PatientID = paid;
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_Management", "root", "!shuB0410");
            Statement s = con.createStatement();
            pid.setText(""+PatientID);
            ResultSet rs = s.executeQuery("SELECT Name FROM Patients WHERE Patient_ID=" + PatientID);
            if(rs.next()){
                Pname.setText(rs.getString("Name"));
            }
            rs = s.executeQuery("SELECT Staff.Name as DoctorName, Bills.Amount as amount FROM Staff JOIN Bills ON Staff.Staff_ID=Bills.Doctor_ID WHERE Bills.Patient_ID="+PatientID+" ORDER BY Bill_id desc LIMIT 1;");
            if(rs.next()){
                Dname.setText(rs.getString("DoctorName"));
                bill.setText(""+rs.getFloat("amount"));
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
        jLabel2 = new javax.swing.JLabel();
        pid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Pname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Dname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bill = new javax.swing.JLabel();
        return_btn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(398, 300));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Online Bill Detail");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 20, 160, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Patient ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 60, 80, 20);

        pid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pid.setText("No Data Found");
        getContentPane().add(pid);
        pid.setBounds(180, 60, 160, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Patient Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 90, 100, 20);

        Pname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Pname.setText("No Data Found");
        getContentPane().add(Pname);
        Pname.setBounds(180, 90, 280, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Doctor Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 110, 100, 20);

        Dname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dname.setText("No Data Found");
        getContentPane().add(Dname);
        Dname.setBounds(180, 110, 160, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Total Bill Amount: ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 170, 130, 20);

        bill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bill.setText("No Data Found");
        getContentPane().add(bill);
        bill.setBounds(200, 170, 140, 20);

        return_btn.setText("Return to Menu");
        return_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_btnActionPerformed(evt);
            }
        });
        getContentPane().add(return_btn);
        return_btn.setBounds(130, 230, 150, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OIP (2).jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-330, -30, 960, 350);

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
            java.util.logging.Logger.getLogger(PatientBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PatientBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dname;
    private javax.swing.JLabel Pname;
    private javax.swing.JLabel bill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel pid;
    private javax.swing.JButton return_btn;
    // End of variables declaration//GEN-END:variables
}
