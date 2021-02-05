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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fuad
 */
public class NewStoreHouseFrame extends javax.swing.JFrame {

    AptekDaoAnbar aptekDao = new AptekDaoImplAnbar();
    AptekServiceAnbar aptekService = new AptekServiceAnbarImpl(aptekDao);

    private AptekServiceProduct aptekServiceProduct;
    
    public NewStoreHouseFrame() {
        initComponents();

    }

    NewStoreHouseFrame(AptekServiceProduct aptekServiceProduct) {
        initComponents();
        this.aptekServiceProduct = aptekServiceProduct;
        showProductCombo();
        AutoCompleteDecorator.decorate(nameCmb);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameCmb = new javax.swing.JComboBox<>();
        amountTxt = new javax.swing.JTextField();
        purchaseTxt = new javax.swing.JTextField();
        notTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        cleartxt = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Product name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Quantity");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Purchase price");

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
        notTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notTxtActionPerformed(evt);
            }
        });
        notTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                notTxtKeyPressed(evt);
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

        cleartxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cleartxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/clear.png"))); // NOI18N
        cleartxt.setText("Clear");
        cleartxt.setToolTipText("Click here to clear data");
        cleartxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleartxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleartxtActionPerformed(evt);
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

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(cleartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(closeBtn))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(purchaseTxt)
                                        .addComponent(amountTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                        .addComponent(nameCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(notTxt))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(39, 39, 39))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {amountTxt, notTxt, purchaseTxt});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cleartxt, closeBtn, saveBtn});

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cleartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {amountTxt, notTxt, purchaseTxt});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cleartxt, closeBtn, saveBtn});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, jLabel7});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            Item productItem = (Item) nameCmb.getSelectedItem();
            Integer amount = Integer.parseInt(amountTxt.getText());
            Double purchasePrise = Double.valueOf(purchaseTxt.getText());
            String not = notTxt.getText();
            Product p = new Product();
            p.setId(productItem.getId());
            Anbar a = new Anbar();
            a.setProduct(p);
            a.setAmount(amount);
            a.setPurchasePrise(purchasePrise);
            a.setQeyd(not);

            boolean add = aptekService.addAnbar(a);
            if (add) {
                JOptionPane.showMessageDialog(null, "Product  has been successfully added to Store house", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
              
             
            } else {
                JOptionPane.showMessageDialog(null, "Problem! Product  has not been successfully added to Store house", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }

        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(null, "Please enter all data");
           
        }  catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_saveBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void cleartxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleartxtActionPerformed
        nameCmb.setSelectedIndex(0);
        amountTxt.setText("");
        purchaseTxt.setText("");

    }//GEN-LAST:event_cleartxtActionPerformed

    private void amountTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountTxtKeyPressed
        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || (c >= 32 && c <= 46) || (c >= 58 && c <= 64)) {
            amountTxt.setEditable(false);
            jLabel6.setText("Please enter number only !");
        } else {
            jLabel6.setText("");
            amountTxt.setEditable(true);
        }
    }//GEN-LAST:event_amountTxtKeyPressed

    private void purchaseTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purchaseTxtKeyPressed

        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c) || (c >= 32 && c <= 43) || (c >= 58 && c <= 64)) {
            purchaseTxt.setEditable(false);
            jLabel7.setText("Please enter number only !");
        } else {
            jLabel7.setText("");
            purchaseTxt.setEditable(true);
        }
    }//GEN-LAST:event_purchaseTxtKeyPressed

    private void notTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notTxtKeyPressed
        char c = evt.getKeyChar();
        if ((Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c))) {
            notTxt.setEditable(true);
            jLabel8.setText("");

        } else {
            notTxt.setEditable(false);
            jLabel8.setText("Please enter words only !");
        }
    }//GEN-LAST:event_notTxtKeyPressed

    private void notTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notTxtActionPerformed


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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> nameCmb;
    private javax.swing.JTextField notTxt;
    private javax.swing.JTextField purchaseTxt;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables

    private void showProductCombo() {
        DefaultComboBoxModel productCombo = (DefaultComboBoxModel) nameCmb.getModel();
        try {
            List<Product> productList = aptekServiceProduct.getProductList();
            for (Product product : productList) {
                productCombo.addElement(new Item(product.getId(), product.getName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
