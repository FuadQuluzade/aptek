/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoAnbar;
import az.orient.aptek.dao.AptekDaoImplAnbar;
import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.service.AptekServiceAnbar;
import az.orient.aptek.service.AptekServiceAnbarImpl;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fuad
 */
public class EditStoreHouse2 extends javax.swing.JFrame {

    AptekDaoAnbar aptekDao = new AptekDaoImplAnbar();
    AptekServiceAnbar aptekService = new AptekServiceAnbarImpl(aptekDao);
    private Long id;

    public EditStoreHouse2(Long id) {
        try {
            this.id = id;
            initComponents();

            List<Anbar> anbarList = aptekService.getAnbarListByPId(id);
            showStorehouse2(anbarList);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jTable1.setBackground(new java.awt.Color(0, 204, 51));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        editBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/edit32pxl.png"))); // NOI18N
        editBtn.setText("Edit");
        editBtn.setToolTipText("Click here to edit the program");
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/delete32pxl.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.setToolTipText("Click here to delete the information");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/close.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.setToolTipText("Click here to close the program");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(deleteBtn)
                .addGap(45, 45, 45)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteBtn, editBtn, jButton3});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();
            long id = (long) jTable1.getValueAt(selectedRow, 0);

            Anbar anbar = new Anbar();
//            Product product = new Product();
            Long anbarId = id;
//            anbar.setProduct(product);
            anbar.setAmount(Integer.valueOf(jTable1.getValueAt(selectedRow, 2).toString()));
            boolean update = aptekService.updateAnbar(anbar, anbarId);
            if (update) {
                JOptionPane.showMessageDialog(null, "Product has been successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);

                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Problem! Product  has not been successfully update", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Amount!");
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Amount!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Table is empty!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_editBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();
            long id = (long) jTable1.getValueAt(selectedRow, 0);
            int confirmDeleteSh = JOptionPane.showConfirmDialog(null, "do you really want to delete this information?", "Delete Store house", JOptionPane.YES_NO_OPTION);
            if (confirmDeleteSh == JOptionPane.YES_OPTION) {

                boolean delete = aptekService.deleteAnbar(id);
                if (delete) {
                    JOptionPane.showMessageDialog(null, "Storehouse has been successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Problem! Storehouse has not been successfully deleted", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Please select row!");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                List<Anbar> anbarList = aptekService.getAnbarListByPId(id);
                showStorehouse2(anbarList);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void showStorehouse2(List<Anbar> anbarList) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return true;
            }
        };
        jTable1.setModel(model);
        model.addColumn("#");
        model.addColumn("Product name");
        model.addColumn("Miqdar");
        model.addColumn("Data Date");
        for (Anbar anbar : anbarList) {
            Object[] data = new Object[]{
                anbar.getId(), anbar.getProduct().getName(), anbar.getAmount(), anbar.getDataDate()};
            model.addRow(data);
        }

        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        model.fireTableDataChanged();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
