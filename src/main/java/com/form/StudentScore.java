/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.form;
import com.entity.ClassWithSubjectEntity;
import com.entity.StudentEntity;
import static com.form.Login.student_id;
import com.pakage.dao.ClassWithSubjectDAO;
import com.pakage.dao.StudentDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nhi
 */
public class StudentScore extends javax.swing.JFrame {
    
  private String[] columnNames2 = {
        "LOP", "MSSV", "Ho Ten", "Diem GK", "Diem CK", "Diem Khac", "Diem Tong"
    };
    private String[] columnNames1 = {
        "STT", "MSSV", "Ho Ten", "Diem GK", "Diem CK", "Diem Khac", "Diem Tong"
    };
    /**
     * Creates new form StudentScore
     */
    public StudentScore() {
        initComponents();
     //   initTable();
        initCbxClass();
         this.setLocationRelativeTo(null);
    }
    private void initTable()
    {
        
        ClassWithSubjectDAO classDAO = new ClassWithSubjectDAO();
        StudentDAO studentDAO = new StudentDAO();
        List<ClassWithSubjectEntity> list = classDAO.getListByStudent(student_id);
         if (list!=null)
        {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames1);
        StudentEntity s = studentDAO.get(student_id);
        for (ClassWithSubjectEntity c : list) {
            String[] rows = new String[7];
            Double midterm = c.getMidTermScore();
            Double endterm = c.getEndTermScore();
            Double otherscore = c.getOtherScore();
            Double finalscore =c.getFinalScore();
            
            rows[0] = String.valueOf(c.getClassId());
            rows[1] = s.getStudentId();
            rows[2] =s.getFullName();
            rows[3] = midterm.toString();
            rows[4] = endterm.toString();
            rows[5] = otherscore.toString();
            rows[6] = finalscore.toString();
            tableModel.addRow(rows);
           

        }
        jTable1.setModel(tableModel);
        }
         else
         {
             DefaultTableModel tableModel = new DefaultTableModel();
                       tableModel.addRow(new String[]{});
                        jTable1.setModel(tableModel);
         }
    }
    private void initCbxClass()
    {
           ClassWithSubjectDAO classDAO = new ClassWithSubjectDAO();
       
        List<ClassWithSubjectEntity> list = classDAO.getListByStudent(student_id);
       
        if (list.size() > 0) {
            DefaultComboBoxModel comboboxModel = new DefaultComboBoxModel();
            for (ClassWithSubjectEntity c : list) {

                comboboxModel.addElement(c.getClassId());
            }
            cbxClassWithSubject.setModel(comboboxModel);
        } else {
            cbxClassWithSubject.setModel(new javax.swing.DefaultComboBoxModel(new String[]{}));
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

        lbClass = new javax.swing.JLabel();
        cbxClassWithSubject = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bt_quayve = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();
        lbStudentScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbClass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbClass.setText("Lop Mon");

        cbxClassWithSubject.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxClassWithSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClassWithSubjectActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        bt_quayve.setText("Quay Ve");
        bt_quayve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_quayveActionPerformed(evt);
            }
        });

        btnRequest.setText("Xin phuc khao");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        lbStudentScore.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        lbStudentScore.setText("Diem mon hoc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_quayve, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbStudentScore)
                        .addGap(230, 230, 230))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbClass)
                            .addGap(18, 18, 18)
                            .addComponent(cbxClassWithSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbStudentScore)
                .addGap(2, 2, 2)
                .addComponent(bt_quayve)
                .addGap(18, 18, 18)
                .addComponent(btnRequest)
                .addContainerGap(232, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbClass)
                        .addComponent(cbxClassWithSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

     

    }//GEN-LAST:event_jTable1MouseClicked

    private void bt_quayveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_quayveActionPerformed
        // TODO add your handling code here:
        StudentDashboard sd = new StudentDashboard();
        sd.setVisible(true);
        this.setVisible(false);          // TODO add your handling code here:
    }//GEN-LAST:event_bt_quayveActionPerformed

    private void cbxClassWithSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClassWithSubjectActionPerformed
        // TODO add your handling code here:
        String class_id = (String) cbxClassWithSubject.getSelectedItem();
        if (!class_id.equals("null")) {
            listStudentInClass(class_id,student_id);
        } else {
            JOptionPane.showMessageDialog(null, "Khong co lop.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_cbxClassWithSubjectActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRequestActionPerformed

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
            java.util.logging.Logger.getLogger(StudentScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentScore().setVisible(true);
            }
        });
    }
    
     private void listStudentInClass(String class_id,String student_id) {
        int stt = 1;
       
        ClassWithSubjectDAO classDAO = new ClassWithSubjectDAO();
        StudentDAO studentDAO = new StudentDAO();
        ClassWithSubjectEntity c = classDAO.get(class_id,student_id);
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames2);
            String[] rows = new String[7];
            Double midterm = c.getMidTermScore();
            Double endterm = c.getEndTermScore();
            Double otherscore = c.getOtherScore();
            Double finalscore =c.getFinalScore();
            StudentEntity s = studentDAO.get(student_id);
            rows[0] = String.valueOf(stt);
            rows[1] = s.getStudentId();
            rows[2] =s.getFullName();
            rows[3] = midterm.toString();
            rows[4] = endterm.toString();
            rows[5] = otherscore.toString();
            rows[6] = finalscore.toString();
            tableModel.addRow(rows);
            stt++;
  
        jTable1.setModel(tableModel);
    
        
    }
     private void listScore(String student_id) {
        int stt = 1;
    
        ClassWithSubjectDAO classDAO = new ClassWithSubjectDAO();
        StudentDAO studentDAO = new StudentDAO();
        List<ClassWithSubjectEntity> list = classDAO.getListByStudent(student_id);
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames2);
        StudentEntity s = studentDAO.get(student_id);
        for (ClassWithSubjectEntity c : list) {
            String[] rows = new String[7];
            Double midterm = c.getMidTermScore();
            Double endterm = c.getEndTermScore();
            Double otherscore = c.getOtherScore();
            Double finalscore =c.getFinalScore();
            
            rows[0] = String.valueOf(stt);
            rows[1] = s.getStudentId();
            rows[2] =s.getFullName();
            rows[3] = midterm.toString();
            rows[4] = endterm.toString();
            rows[5] = otherscore.toString();
            rows[6] = finalscore.toString();
            tableModel.addRow(rows);
            stt++;

        }
        jTable1.setModel(tableModel);
       
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_quayve;
    private javax.swing.JButton btnRequest;
    private javax.swing.JComboBox cbxClassWithSubject;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbClass;
    private javax.swing.JLabel lbStudentScore;
    // End of variables declaration//GEN-END:variables
}
