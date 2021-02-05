/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoProductPrice;
import az.orient.aptek.dao.AptekDaoProductPriceImpl;
import az.orient.aptek.pojo.Item;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.ProductPrice;
import az.orient.aptek.service.AptekServiceProduct;
import az.orient.aptek.service.AptekServiceProductPrice;
import az.orient.aptek.service.AptekServiceProductPriceImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fuad
 */
public class NewProductPriceFrame extends javax.swing.JFrame {

    AptekDaoProductPrice aptekDaoProductPrice = new AptekDaoProductPriceImpl();
    AptekServiceProductPrice aptekServiceProductPrice = new AptekServiceProductPriceImpl(aptekDaoProductPrice);

    private AptekServiceProduct aptekServiceProduct;

    public NewProductPriceFrame() {
        initComponents();
    }

    NewProductPriceFrame(AptekServiceProduct aptekServiceProduct) {
        initComponents();
        this.aptekServiceProduct = aptekServiceProduct;
        showProductCombo();
        AutoCompleteDecorator.decorate(productComboCmb);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productComboCmb = new javax.swing.JComboBox<>();
        priceTxt = new javax.swing.JTextField();
        currencyTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Price");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Currency");

        productComboCmb.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        productComboCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select product" }));

        priceTxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        priceTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceTxtKeyPressed(evt);
            }
        });

        currencyTxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

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

        jLabel4.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(productComboCmb, 0, 179, Short.MAX_VALUE)
                            .addComponent(priceTxt)
                            .addComponent(currencyTxt))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productComboCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(currencyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, productComboCmb});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {currencyTxt, priceTxt});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            Item productItem = (Item) productComboCmb.getSelectedItem();
            Double price = Double.parseDouble(priceTxt.getText());
            String currency = currencyTxt.getText();
            ProductPrice productPrice = new ProductPrice();
            productPrice.setPrice(price);
            productPrice.setCurrency(currency);
            Product p = new Product();
            p.setId(productItem.getId());
            productPrice.setProduct(p);
//            if(productComboCmb.getSelectedItem().equals("") || priceTxt.getText().equals("") || currencyTxt.getText().equals("")){
//                JOptionPane.showMessageDialog(this, "Please Enter all data");
//            } else  
//            {
//            
            boolean add = aptekServiceProductPrice.addProductPrice(productPrice);
            if (add) {
                JOptionPane.showMessageDialog(null, "Product price has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Problem! Product price has not been successfully added", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        productComboCmb.setSelectedIndex(0);
        priceTxt.setText("");
        currencyTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void priceTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTxtKeyPressed
         char c= evt.getKeyChar();
        if(Character.isAlphabetic(c) || (c >= 32 && c <= 46) || (c >= 58 && c <= 64)){
            priceTxt.setEditable(false);
            jLabel4.setText("Please enter number only !");
        }else{
            jLabel4.setText("");
            priceTxt.setEditable(true);
        }
    }//GEN-LAST:event_priceTxtKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextField currencyTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JComboBox<String> productComboCmb;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables

    private void showProductCombo() {
        DefaultComboBoxModel productCombo = (DefaultComboBoxModel) productComboCmb.getModel();
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
