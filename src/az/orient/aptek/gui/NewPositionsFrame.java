/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoVezifeler;
import az.orient.aptek.dao.AptekDaoVezifelerImpl;
import az.orient.aptek.pojo.Vezifeler;
import az.orient.aptek.service.AptekServiceVezifeler;
import az.orient.aptek.service.AptekServiceVezifelerImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author Fuad
 */
public class NewPositionsFrame extends javax.swing.JFrame {

    AptekDaoVezifeler aptekDaoVezifeler = new AptekDaoVezifelerImpl();
    AptekServiceVezifeler aptekServiceVezifeler = new AptekServiceVezifelerImpl(aptekDaoVezifeler);

    public NewPositionsFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PositionNameTxt = new javax.swing.JTextField();
        SaveTxt = new javax.swing.JButton();
        clearTxt = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Position Name");

        PositionNameTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PositionNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PositionNameTxtKeyPressed(evt);
            }
        });

        SaveTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaveTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/save1.png"))); // NOI18N
        SaveTxt.setText("Save");
        SaveTxt.setToolTipText("Click here to save data");
        SaveTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveTxtActionPerformed(evt);
            }
        });

        clearTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/clear.png"))); // NOI18N
        clearTxt.setText("Clear");
        clearTxt.setToolTipText("Click here to clear data");
        clearTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTxtActionPerformed(evt);
            }
        });

        clearBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/close.png"))); // NOI18N
        clearBtn.setText("Close");
        clearBtn.setToolTipText("Click here to close the program");
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SaveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(clearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PositionNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {SaveTxt, clearBtn, clearTxt});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PositionNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {SaveTxt, clearBtn, clearTxt});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SaveTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveTxtActionPerformed

        try {
            String name = PositionNameTxt.getText();
            Vezifeler vezifeler = new Vezifeler();
            vezifeler.setName(name);

            if (aptekServiceVezifeler.checkPositionName(vezifeler)) {
                JOptionPane.showMessageDialog(this, "This name is aviable");
                clearBtnActionPerformed(evt);
            } else {
                if (PositionNameTxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter the all data", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    boolean add = aptekServiceVezifeler.addVezifeler(vezifeler);

                    if (add) {
                        JOptionPane.showMessageDialog(null, "Positions has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Problem! Positions has not been successfully added", "Error", JOptionPane.ERROR_MESSAGE);
                        this.dispose();
                    }
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_SaveTxtActionPerformed

    private void clearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTxtActionPerformed
        PositionNameTxt.setText("");
    }//GEN-LAST:event_clearTxtActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        dispose();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void PositionNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PositionNameTxtKeyPressed
        char c = evt.getKeyChar();
        if ((Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) && c!=32) {
            PositionNameTxt.setEditable(true);
            jLabel2.setText("");

        } else {
            PositionNameTxt.setEditable(false);
            jLabel2.setText("Please enter words only !");
        }
    }//GEN-LAST:event_PositionNameTxtKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PositionNameTxt;
    private javax.swing.JButton SaveTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
