/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoXerc;
import az.orient.aptek.dao.AptekDaoXercImpl;
import az.orient.aptek.pojo.Item;
import az.orient.aptek.pojo.OdenishVasiteleri;
import az.orient.aptek.pojo.Xerc;
import az.orient.aptek.service.AptekServiceOdenishVasiteleri;
import az.orient.aptek.service.AptekServiceXerc;
import az.orient.aptek.service.AptekServiceXercImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fuad
 */
public class NewExpenceFrame extends javax.swing.JFrame {

    AptekDaoXerc aptekDaoXerc = new AptekDaoXercImpl();
    AptekServiceXerc aptekServiceXerc = new AptekServiceXercImpl(aptekDaoXerc);
    
    private AptekServiceOdenishVasiteleri aptekServiceOdenishVasiteleri;

    public NewExpenceFrame() {
        initComponents();
    }
    
    NewExpenceFrame(AptekServiceOdenishVasiteleri aptekServiceOdenishVasiteleri) {
        initComponents();
        this.aptekServiceOdenishVasiteleri = aptekServiceOdenishVasiteleri;
        showmeansOfSalaryCombo();
        AutoCompleteDecorator.decorate(nameCmb);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameCmb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        amounTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Means of salary");

        nameCmb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Means of salary" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Amount");

        amounTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amounTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amounTxtKeyPressed(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/save1.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.setToolTipText("Click here to save data");
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        ClearBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/clear.png"))); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.setToolTipText("Click here to  clear data");
        ClearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
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

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amounTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(nameCmb, 0, 164, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ClearBtn, closeBtn, saveBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amounTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ClearBtn, closeBtn, saveBtn});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            Item meansOfSalaryItem =(Item) nameCmb.getSelectedItem();
            Double amount = Double.parseDouble(amounTxt.getText());
            OdenishVasiteleri odenishVasiteleri = new OdenishVasiteleri();
            odenishVasiteleri.setId(meansOfSalaryItem.getId());
            Xerc xerc = new Xerc();
            xerc.setOdenishVasiteleri(odenishVasiteleri);
            xerc.setAmount(amount);
               boolean add = aptekServiceXerc.addXerc(xerc);
            if (add) {
                JOptionPane.showMessageDialog(null, "Sales  has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Problem! Sales has not been successfully added", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }

        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Please enter the all data", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        nameCmb.setSelectedIndex(0);
        amounTxt.setText("");
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();        
    }//GEN-LAST:event_closeBtnActionPerformed

    private void amounTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amounTxtKeyPressed
        char c= evt.getKeyChar();
        if(Character.isAlphabetic(c) || (c >= 32 && c <= 46) || (c >= 58 && c <= 64)){
            amounTxt.setEditable(false);
            jLabel3.setText("Please enter number only !");
        }else{
            jLabel3.setText("");
            amounTxt.setEditable(true);
        }
    }//GEN-LAST:event_amounTxtKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBtn;
    private javax.swing.JTextField amounTxt;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> nameCmb;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables

    private void showmeansOfSalaryCombo() {
        DefaultComboBoxModel meansOfSalaryCombo = (DefaultComboBoxModel) nameCmb.getModel();
        try {
            List<OdenishVasiteleri> odenishVasiteleriList = aptekServiceOdenishVasiteleri.getOdenishVasiteleriList();
            for (OdenishVasiteleri odenishVasiteleri : odenishVasiteleriList) {
                meansOfSalaryCombo.addElement(new Item(odenishVasiteleri.getId(), odenishVasiteleri.getName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
