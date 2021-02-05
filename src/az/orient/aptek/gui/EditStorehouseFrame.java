/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoAnbar;
import az.orient.aptek.dao.AptekDaoImplAnbar;
import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.Item;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.service.AptekServiceAnbar;
import az.orient.aptek.service.AptekServiceAnbarImpl;
import az.orient.aptek.service.AptekServiceProduct;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Fuad
 */
public class EditStorehouseFrame extends javax.swing.JFrame {

    AptekDaoAnbar aptekDao = new AptekDaoImplAnbar();
    AptekServiceAnbar aptekService = new AptekServiceAnbarImpl(aptekDao);

    private AptekServiceProduct aptekServiceProduct;
    private long id;

    public EditStorehouseFrame() {
        initComponents();
    }

    public EditStorehouseFrame(long id, AptekServiceProduct aptekServiceProduct) {
        try {
            initComponents();
            this.id = id;
            this.aptekServiceProduct = aptekServiceProduct;
            Anbar anbar = aptekService.getAnbarById(id);
            editProductCombo(anbar);
            amountTxt.setText(anbar.getAmount().toString());
            purchaseTxt.setText(anbar.getPurchasePrise().toString());
            notTxt.setText(anbar.getQeyd());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cleartxt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameCmb = new javax.swing.JComboBox<>();
        amountTxt = new javax.swing.JTextField();
        purchaseTxt = new javax.swing.JTextField();
        notTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        updateBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.setToolTipText("Click here to update data");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Product name");

        cleartxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cleartxt.setText("Clear");
        cleartxt.setToolTipText("Click here to clear data");
        cleartxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleartxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Amount");

        closeBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        closeBtn.setText("Close");
        closeBtn.setToolTipText("Click here to close the program");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Purchase price");

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Not");

        nameCmb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select product" }));

        amountTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        amountTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amountTxtKeyPressed(evt);
            }
        });

        purchaseTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        purchaseTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                purchaseTxtKeyPressed(evt);
            }
        });

        notTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchaseTxt)
                    .addComponent(amountTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(nameCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(notTxt)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(updateBtn)
                .addGap(30, 30, 30)
                .addComponent(cleartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeBtn)
                .addGap(30, 30, 30))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cleartxt, closeBtn, updateBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(amountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)))
                .addGap(4, 4, 4)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(notTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cleartxt, closeBtn, updateBtn});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            Item productItem = (Item) nameCmb.getSelectedItem();
            Integer amount = Integer.parseInt(amountTxt.getText());
            Double purchasePrise = Double.parseDouble(purchaseTxt.getText());
            String not = notTxt.getText();
            Product p = new Product();
            p.setId(productItem.getId());
            Anbar a = new Anbar();
            a.setProduct(p);
            a.setAmount(amount);
            a.setPurchasePrise(purchasePrise);
            a.setQeyd(not);
            boolean update = aptekService.updateAnbar(a, id);
            if (update) {
                JOptionPane.showMessageDialog(null, "Product has been successfully added to Store house", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Problem! Product  has not been successfully added to Store house", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter all data");
        }

    }//GEN-LAST:event_updateBtnActionPerformed

    private void cleartxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleartxtActionPerformed
        nameCmb.setSelectedIndex(0);
        amountTxt.setText("");
        purchaseTxt.setText("");
        
    }//GEN-LAST:event_cleartxtActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void amountTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountTxtKeyPressed
        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c)) {
            amountTxt.setEditable(false);
            jLabel6.setText("Please enter number only !");
        } else {
            jLabel6.setText("");
            amountTxt.setEditable(true);
        }
    }//GEN-LAST:event_amountTxtKeyPressed

    private void purchaseTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purchaseTxtKeyPressed

        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c)) {
            purchaseTxt.setEditable(false);
            jLabel7.setText("Please enter number only !");
        } else {
            jLabel7.setText("");
            purchaseTxt.setEditable(true);
        }
    }//GEN-LAST:event_purchaseTxtKeyPressed

    private void editProductCombo(Anbar anbar) {
        DefaultComboBoxModel productCombo = (DefaultComboBoxModel) nameCmb.getModel();
        try {
            List<Product> productList = aptekServiceProduct.getProductList();
            for (Product product : productList) {
                productCombo.addElement(new Item(product.getId(), product.getName()));
            }
            productCombo.setSelectedItem(new Item(anbar.getProduct().getId(), anbar.getProduct().getName()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTxt;
    private javax.swing.JButton cleartxt;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox<String> nameCmb;
    private javax.swing.JTextField notTxt;
    private javax.swing.JTextField purchaseTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
