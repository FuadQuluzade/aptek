/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoMedicineQroup;
import az.orient.aptek.dao.AptekDaoMedicineQroupImpl;
import az.orient.aptek.pojo.Item;
import az.orient.aptek.pojo.MedicineQroup;
import az.orient.aptek.pojo.Refler;
import az.orient.aptek.service.AptekServiceMedicineQroup;
import az.orient.aptek.service.AptekServiceMedicineQroupImpl;
import az.orient.aptek.service.AptekServiceRefler;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fuad
 */
public class EditMedicineQroupFrame extends javax.swing.JFrame {

    AptekDaoMedicineQroup aptekDaoMedicineQroup = new AptekDaoMedicineQroupImpl();
    AptekServiceMedicineQroup aptekServiceMedicineQroup = new AptekServiceMedicineQroupImpl(
            aptekDaoMedicineQroup);
    private AptekServiceRefler aptekServiceRefler;
    private long id;

    public EditMedicineQroupFrame() {
        initComponents();
    }

    public EditMedicineQroupFrame(long id, AptekServiceRefler aptekServiceRefler) {
        try {
            initComponents();
            this.id = id;
            this.aptekServiceRefler = aptekServiceRefler;
            MedicineQroup medicineQroup = aptekServiceMedicineQroup.getMedicineQroupById(id);
            editShelfCombo(medicineQroup);
            nameTxt.setText(medicineQroup.getQroupName());
            AutoCompleteDecorator.decorate(namecbm);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        namecbm = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Qroup Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ref");

        nameTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        namecbm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        namecbm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ref Name" }));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameTxt)
                            .addComponent(namecbm, 0, 188, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(closeBtn)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clearBtn, closeBtn, updateBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namecbm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clearBtn, closeBtn, updateBtn});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            Item shelfsItem = (Item) namecbm.getSelectedItem();
            String name = nameTxt.getText();
            MedicineQroup mq = new MedicineQroup();
            Refler r = new Refler();
            mq.setId(id);
            r.setId(shelfsItem.getId());
            mq.setShelfs(r);
            mq.setQroupName(name);
           if(aptekServiceMedicineQroup.checkMedicineQroup(mq, true)){
               JOptionPane.showMessageDialog(null, "this name is aviable");
//               namecbm.setSelectedIndex(0);
//               nameTxt.setText("");
           }else{
               
                boolean update = aptekServiceMedicineQroup.updateMedicineQroup(mq, id);
                if (update) {
                    JOptionPane.showMessageDialog(null, "MedicineQ roup has been successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Problem! Medicine Qroup has not been successfully updated", "Error", JOptionPane.ERROR_MESSAGE);
                    this.dispose();
                }
           }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter all data");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        nameTxt.setText("");
        namecbm.setSelectedIndex(0);

    }//GEN-LAST:event_clearBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void editShelfCombo(MedicineQroup medicineQroup) {
        DefaultComboBoxModel shelfCombo = (DefaultComboBoxModel) namecbm.getModel();

        try {

            List<Refler> reflerList = aptekServiceRefler.getReflerList();
            for (Refler refler : reflerList) {
                shelfCombo.addElement(new Item(refler.getId(), refler.getName()));
            }
            shelfCombo.setSelectedItem(new Item(medicineQroup.getShelfs().getId(), medicineQroup.getShelfs().getName()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JComboBox<String> namecbm;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
