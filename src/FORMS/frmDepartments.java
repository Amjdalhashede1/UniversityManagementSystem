/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FORMS;

import Entry.Departments;
import Entry.TABLE;
import static Entry.TABLE.DEPARTMENT.*;
import Entry.TABLE.MANAGER;
import static Entry.TABLE.MANAGER.MANAGER_NAME;
import static Entry.TABLE.MANAGERS;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import universitymanagementsystem.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;
import static db.go.*;
public class frmDepartments extends javax.swing.JFrame {

    Departments dept = new Departments();

    public frmDepartments() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtYearCount = new myControlls.JTextBox();
        jLabel12 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartments = new javax.swing.JTable();
        selectEducationLevel = new myControlls.JCombo();
        txtSearch = new myControlls.JTextBox();
        btnAdd = new myControlls.JmyButton();
        jLabel5 = new javax.swing.JLabel();
        txtDeptNo = new myControlls.JTextBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        selectManagerName = new myControlls.JCombo();
        btnEdit = new myControlls.JmyButton();
        btnDelete = new myControlls.JmyButton();
        btnClear = new myControlls.JmyButton();
        jmyButton14 = new myControlls.JmyButton();
        btnAll = new myControlls.JmyButton();
        jLabel14 = new javax.swing.JLabel();
        txtAmountFees = new myControlls.JTextBox();
        txtDeptName = new myControlls.JTextBox();
        btnClear1 = new myControlls.JmyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("عدد السنوات :");

        btnSearch.setBackground(new java.awt.Color(0, 0, 100));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("البحث عن :");
        btnSearch.setOpaque(true);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("رئيس القسم :");

        tblDepartments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblDepartments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "رقم التخصص", "اسم التخصص", "نظام الدراسة", "عدد السنوات", "رئيس القسم"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDepartments.getTableHeader().setReorderingAllowed(false);
        tblDepartments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartmentsMouseClicked(evt);
            }
        });
        tblDepartments.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDepartmentsKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblDepartments);

        selectEducationLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "دبلوم متوسط", "دبلوم عالي", "بكلاريوس", "ماجستير", "دكتورة", "غير ذالك" }));

        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        btnAdd.setText("حفظ");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("التخصصات");

        txtDeptNo.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("رقم التخصص:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("اسم التخصص :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("نظام الدراسة :");

        btnEdit.setText("تعديل");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("ازالة");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("تنظيف");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jmyButton14.setText("رجوع");
        jmyButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmyButton14ActionPerformed(evt);
            }
        });

        btnAll.setText("الكل");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("رسوم العام : ");

        btnClear1.setText("+");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDeptNo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectEducationLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectManagerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtYearCount, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtAmountFees, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(5, 5, 5))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(10, 10, 10))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtDeptName, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(95, 95, 95)))
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1006, 1006, 1006)
                .addComponent(jmyButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(488, 488, 488))
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeptNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDeptName, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(selectEducationLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtYearCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(selectManagerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtAmountFees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jmyButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDepartmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartmentsMouseClicked
     mouseClick();
    }//GEN-LAST:event_tblDepartmentsMouseClicked

    private void tblDepartmentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDepartmentsKeyReleased
        if( evt.getKeyCode()== 40 || evt.getKeyCode()== 38 ||  evt.getKeyChar()==KeyEvent.VK_ENTER  ){
             mouseClick();
       }
    }//GEN-LAST:event_tblDepartmentsKeyReleased

    private void jmyButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmyButton14ActionPerformed
        this.dispose();
        Tools.openForm(new frmMain());
    }//GEN-LAST:event_jmyButton14ActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
            clearData();
            Tools.setTableStyle(tblDepartments);
            Tools.setColumnSize(tblDepartments, 0, 40, 40);
            Tools.setColumnSize(tblDepartments, 1, 200, 200);
            Tools.setColumnSize(tblDepartments, 3, 40, 40);
            Tools.setColumnSize(tblDepartments, 2, 40, 40);
        
    }//GEN-LAST:event_formWindowOpened

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     dept.Add(setValues());
        Tools.MsgBox("تمت عملية الأضافة بنجاح");
        clearData();
    }//GEN-LAST:event_btnAddActionPerformed
    public void clearData() {
        Tools.ClearText(this);
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        txtDeptName.setEditable(true);
        txtDeptNo.setText(dept.getAutoNumber(DEPT_ID)+"");
        dept.getAllRows(tblDepartments);
        db.go.fillIntoJComboBox(selectManagerName, db.go.getData(TABLE.VIEW.MANAGER_NOT_IN_DEPARTMENT+"", new ArrayList<>(),new HashMap<>()),MANAGER_NAME+"");
    }
    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        String s = JOptionPane.showInputDialog("ادخل اسم رئيس القسم :");
        if (s.trim().equals("")) {
            Map<String, Object> manager = new HashMap<>();
            manager.put(MANAGER_ID + "",db.go.getAutoNumber(TABLE.MANAGERS+"",MANAGER_ID+""));
            manager.put(MANAGER.MANAGER_NAME + "", selectManagerName.getSelectedItem());
           db.go.insertData(TABLE.MANAGERS + "", manager);
        }
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
      clearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Map<String,Object>whereC=new HashMap<>();
        whereC.put(DEPT_ID+"",txtDeptNo.getText());
        dept.update(setValues(),whereC);
        Tools.MsgBox("تم عملية التعديل بنجاح");
        clearData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Map<String,Object>whereC=new HashMap<>();
        whereC.put(DEPT_NAME+"", txtDeptName.getText());
        ResultSet res=db.go.getData(TABLE.VIEW.DEPARTMENT_NOT_HAVE_CHILD+"", new ArrayList<>(), whereC);
        try {
            String del="هل أنت متأكد أنك تريد الحذف ";
            if(!res.next()){
                del+="""
                      \u0633\u064a\u062a\u0645 \u062d\u0630\u0641 \u062c\u0645\u064a\u0639 \u0627\u0644\u0637\u0644\u0627\u0628 \u0627\u0644\u0645\u0633\u062c\u0644\u064a\u0646 \u0641\u064a \u0647\u0630\u0627 \u0627\u0644\u0642\u0633\u0645""";
            }
             if(Tools.confirmMsg(del)){
                    dept.delete(whereC);
                    clearData(); 
                }
        } catch (SQLException ex) {
           Tools.MsgBox(ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        clearData();
       // db.go.fillIntoTable(tblDepartments, db.go.getData(TABLE.VIEWS.Department_DATA_TABLE+"", new ArrayList<>(), new HashMap<>()));
    }//GEN-LAST:event_btnAllActionPerformed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        String like=Tools.getLike(txtSearch.getText());
        String option="select * from "+TABLE.VIEW.Department_DATA_TABLE+" where ";
        option +=DEPT_ID+" "+like+" or ";
        option +=DEPT_NAME+" "+like+" ";
        dept.getCustomeRow(option, tblDepartments);
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if(Tools.ButtonEnter(evt)){
           tblDepartments.setRowSelectionInterval(0,0);
           tblDepartments.requestFocus();
       }
    }//GEN-LAST:event_txtSearchKeyPressed

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
            java.util.logging.Logger.getLogger(frmDepartments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDepartments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDepartments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDepartments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDepartments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private myControlls.JmyButton btnAdd;
    private myControlls.JmyButton btnAll;
    private myControlls.JmyButton btnClear;
    private myControlls.JmyButton btnClear1;
    private myControlls.JmyButton btnDelete;
    private myControlls.JmyButton btnEdit;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private myControlls.JmyButton jmyButton14;
    private myControlls.JCombo selectEducationLevel;
    private myControlls.JCombo selectManagerName;
    private javax.swing.JTable tblDepartments;
    private myControlls.JTextBox txtAmountFees;
    private myControlls.JTextBox txtDeptName;
    private myControlls.JTextBox txtDeptNo;
    private myControlls.JTextBox txtSearch;
    private myControlls.JTextBox txtYearCount;
    // End of variables declaration//GEN-END:variables

    private Map<String, Object> setValues() {
        dept.setTable(TABLE.MANAGERS);
        dept.setBy(MANAGER_NAME);
        dept.setGet(MANAGER_ID);
        Map<String, Object> values = new HashMap<>();
        values.put(DEPT_ID + "", txtDeptNo.getText());
        values.put(DEPT_NAME + "", txtDeptName.getText());
        values.put(MANAGER_ID+"",dept.getValueBy(selectManagerName.getSelectedItem()) );
        values.put(AMOUNTFEES + "", txtAmountFees.getText());
        values.put(EDUCATIONLEVEL + "", selectEducationLevel.getSelectedItem().toString());
        values.put(YEARCOUNT + "", Integer.valueOf(txtYearCount.getText()));
        return values;
    }
     public void mouseClick(){
        try{
            int raw=tblDepartments.getSelectedRow();
            Object deptId=tblDepartments.getValueAt(raw,0).toString();
            ResultSet res= db.go.getData(TABLE.VIEW.DEPARTMENT_DATA+"", new ArrayList<>(), new HashMap<>());
            res.next();
            Object managerName=getValue(res, MANAGER_NAME+"");
            txtDeptNo.setText(deptId+"");
            txtDeptName.setText(getValue(res,DEPT_NAME+"")+"");
            txtAmountFees.setText(getValue(res,AMOUNTFEES+"")+"");
            txtYearCount.setText(getValue(res,YEARCOUNT+"")+"");
            selectEducationLevel.setSelectedItem(getValue(res, EDUCATIONLEVEL+""));
            db.go.addItemIntoJComboBox(selectManagerName, managerName);
            selectManagerName.setSelectedItem(managerName);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            btnAdd.setEnabled(false);
            txtDeptName.setEditable(false);
        }catch(SQLException ex){
            Tools.MsgBox(ex.getMessage());
        }
   }
}
