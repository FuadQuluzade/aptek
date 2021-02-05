/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoMaash;
import az.orient.aptek.dao.AptekDaoMaashImpl;
import az.orient.aptek.pojo.Ishciler;
import az.orient.aptek.pojo.Item;
import az.orient.aptek.pojo.Maash;
import az.orient.aptek.pojo.Vezifeler;
import az.orient.aptek.service.AptekServiceIshciler;
import az.orient.aptek.service.AptekServiceMaash;
import az.orient.aptek.service.AptekServiceMaashImpl;
import az.orient.aptek.service.AptekServiceVezifeler;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fuad
 */
public class EditSalaryFrame extends javax.swing.JFrame {

    AptekDaoMaash aptekDaoIshciMaash = new AptekDaoMaashImpl();
    AptekServiceMaash aptekServiceMaash = new AptekServiceMaashImpl(aptekDaoIshciMaash);
    private long id;
    private AptekServiceIshciler aptekServiceIshci;
    private AptekServiceVezifeler aptekServiceVezifeler;
    public EditSalaryFrame() {
        initComponents();
    }

    EditSalaryFrame(long id, AptekServiceIshciler aptekServiceIshci, AptekServiceVezifeler aptekServiceVezifeler) {
        initComponents();
       this.id=id;
       this.aptekServiceVezifeler=aptekServiceVezifeler;
       this.aptekServiceIshci=aptekServiceIshci;
        try {
            Maash m= aptekServiceMaash.getMaashById(id);
            salaryTxt.setText(m.getSalary().toString());
            positionlbl.setText(m.getVezifeler().getName());
            employeeLbl.setText(m.getIshciler().getName());
//            AutoCompleteDecorator.decorate(employeeCmb);
//            AutoCompleteDecorator.decorate(positionCmb);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clearBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        salaryTxt = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        positionlbl = new javax.swing.JLabel();
        employeeLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        clearBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/clear.png"))); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.setToolTipText("Click here to clear data");
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("AZN");

        closeBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/close.png"))); // NOI18N
        closeBtn.setText("Close");
        closeBtn.setToolTipText("Click here to close the program");
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Position");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Employee ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Salary");

        salaryTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salaryTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salaryTxtKeyPressed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/update.png"))); // NOI18N
        updateBtn.setText("Update");
        updateBtn.setToolTipText("Click here to update data");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        positionlbl.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        employeeLbl.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(positionlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(closeBtn)))
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salaryTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(24, 24, 24))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clearBtn, closeBtn});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(employeeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn))
                .addGap(36, 36, 36))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clearBtn, closeBtn});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
//        positionCmb.setSelectedIndex(0);
//        employeeCmb.setSelectedIndex(0);
        salaryTxt.setText("");
        employeeLbl.setText("");
        positionlbl.setText("");

    }//GEN-LAST:event_clearBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void salaryTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salaryTxtKeyPressed
   
        char c= evt.getKeyChar();
        if(Character.isAlphabetic(c) || (c >= 32 && c <= 46) || (c >= 58 && c <= 64)){
            salaryTxt.setEditable(false);
            jLabel5.setText("Please enter number only !");
        }else{
            jLabel5.setText("");
            salaryTxt.setEditable(true);
        }
    }//GEN-LAST:event_salaryTxtKeyPressed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
//            Item positionItem = (Item) positionCmb.getSelectedItem();
//            Item employeeItem = (Item) employeeCmb.getSelectedItem();
            Double salary = Double.parseDouble(salaryTxt.getText());
            Maash maash = new Maash();
//            Vezifeler vezifeler = new Vezifeler();
//            vezifeler.setId(positionItem.getId());
//            maash.setVezifeler(vezifeler);
//            Ishciler ishciler = new Ishciler();
//            ishciler.setId(employeeItem.getId());
//            maash.setIshciler(ishciler);
            maash.setSalary(salary);

           boolean update=  aptekServiceMaash.updateMaash(maash, id);
            if (update) {
                JOptionPane.showMessageDialog(null, "Salary has been successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Problem! Salary has not been successfully updated", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please Enter all data");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

//  private void editPositionCombo(Maash m) {
//        DefaultComboBoxModel positionCombo = (DefaultComboBoxModel) positionCmb.getModel();
//        
//        try { 
//           
//            List<Vezifeler> positionList = aptekServiceVezifeler.getVezifelerList();
//            for (Vezifeler position : positionList) {
//                positionCombo.addElement(new Item(position.getId(), position.getName()));
//            }
//            positionCombo.setSelectedItem(new Item(m.getVezifeler().getId(),m.getVezifeler().getName()));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    
//    private void editEmployeeCombo(Maash m) {
//        DefaultComboBoxModel employeeCombo = (DefaultComboBoxModel) employeeCmb.getModel();
//        try {
//            List<Ishciler> employeeList = aptekServiceIshci.getIshcilerList();
//            for (Ishciler ishciler : employeeList) {
//                employeeCombo.addElement(new Item(ishciler.getId(), ishciler.getName() + " " + ishciler.getSurname()));
//            }
//            employeeCombo.setSelectedItem(new Item(m.getIshciler().getId(), m.getIshciler().getName()+ " " +m.getIshciler().getSurname() ));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel employeeLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel positionlbl;
    private javax.swing.JTextField salaryTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
