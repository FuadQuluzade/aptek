
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoSatish;
import az.orient.aptek.dao.AptekDaoSatishImpl;
import az.orient.aptek.pojo.Item;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.Satish;
import az.orient.aptek.service.AptekServiceProduct;
import az.orient.aptek.service.AptekServiceSatish;
import az.orient.aptek.service.AptekServiceSatishImpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fuad
 */
public class EditSalesFrame extends javax.swing.JFrame {

    AptekDaoSatish aptekDaoSatish = new AptekDaoSatishImpl();
    AptekServiceSatish aptekServiceSatish = new AptekServiceSatishImpl(aptekDaoSatish);
    private AptekServiceProduct aptekServiceProduct;
    private long id;

    public EditSalesFrame() {
        initComponents();
    }

   public EditSalesFrame(long id, AptekServiceProduct aptekServiceProduct) {
        initComponents();
        this.id = id;
        this.aptekServiceProduct = aptekServiceProduct;
        try {
            Satish s = aptekServiceSatish.getSatishById(id);
            OldProductCombo(s);
            priceTxt.setText(s.getMebleq().toString());
            quantityTxt.setText(s.getMiqdar().toString());
            totalAmountTxt.setText(s.getTotalAmount().toString());
            AutoCompleteDecorator.decorate(nameCmb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalAmountTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ClearBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameCmb = new javax.swing.JComboBox<>();
        priceTxt = new javax.swing.JTextField();
        quantityTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        totalAmountTxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel6.setForeground(new java.awt.Color(0, 153, 51));

        ClearBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ClearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/clear.png"))); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.setToolTipText("Click here to clear data");
        ClearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Price");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quantity");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total amount");

        jLabel5.setForeground(new java.awt.Color(255, 51, 51));

        nameCmb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Product name" }));
        nameCmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nameCmbItemStateChanged(evt);
            }
        });

        priceTxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        priceTxt.setToolTipText("");

        quantityTxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        quantityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityTxtKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/close.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(299, 299, 299))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(updateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(45, 45, 45))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(179, 179, 179)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ClearBtn, jButton1, updateBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(totalAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(38, 38, 38))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(167, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ClearBtn, jButton1, updateBtn});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        nameCmb.setSelectedIndex(0);
        priceTxt.setText("");
        quantityTxt.setText("");
        totalAmountTxt.setText("");
        jLabel6.setText("");
        jLabel5.setText("");
    }//GEN-LAST:event_ClearBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        try {

            Item productItem = (Item) nameCmb.getSelectedItem();
            Double price = Double.parseDouble(priceTxt.getText());
            Integer amount = Integer.parseInt(quantityTxt.getText());
            Double totalAmount = Double.parseDouble(totalAmountTxt.getText());
            Satish s = new Satish();
            Product p = new Product();
            p.setId(productItem.getId());
            s.setProduct(p);
            s.setMebleq(price);
            s.setMiqdar(amount);
            s.setTotalAmount(totalAmount);

            boolean update = aptekServiceSatish.updateSatish(s, id);
            if (update) {
                JOptionPane.showMessageDialog(null, "Sales  has been successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Problem! Sales has not been successfully updated", "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void nameCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nameCmbItemStateChanged

        try {
            Item nameCombo = (Item) nameCmb.getSelectedItem();
            Double price = aptekServiceSatish.getProductPriceById(nameCombo.getId());
            Integer quantity = aptekServiceSatish.getAnbarById(nameCombo.getId());
            priceTxt.setText(price.toString());
            if (quantity.toString().equals("0")) {
                updateBtn.setEnabled(false);
            } else {
                updateBtn.setEnabled(true);
            }
            jLabel6.setText("There are " + quantity.toString() + " pieces in stock");

        } catch (NullPointerException ee) {
            JOptionPane.showMessageDialog(this, "This product has not been evaluate", "Warning", JOptionPane.INFORMATION_MESSAGE);

            nameCmb.setSelectedIndex(0);
            priceTxt.setText("");
            quantityTxt.setText("");
            totalAmountTxt.setText("");
            jLabel6.setText("");
            jLabel5.setText("");

        } catch (ClassCastException e) {
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_nameCmbItemStateChanged

    private void quantityTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTxtKeyPressed
        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c) || (c >= 32 && c <= 46) || (c >= 58 && c <= 64)) {
            quantityTxt.setEditable(false);
            jLabel5.setText("Please enter number only !");
        } else {
            jLabel5.setText("");
            quantityTxt.setEditable(true);
        }
    }//GEN-LAST:event_quantityTxtKeyPressed

    private void quantityTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTxtKeyReleased
        if (priceTxt.getText().equals("") || quantityTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please enter all data");
        } else {
            try {

                Item nameCombo = (Item) nameCmb.getSelectedItem();
                Integer quantity1 = aptekServiceSatish.getAnbarById(nameCombo.getId());
                Integer num = Integer.valueOf(quantityTxt.getText());
                if (num > quantity1) {
                    JOptionPane.showMessageDialog(this, "There are not so many products");
                } else {
                    Double price = Double.parseDouble(priceTxt.getText());
                    Double quantity = Double.parseDouble(quantityTxt.getText());
                    Double totalAmount = price * quantity;
                    totalAmountTxt.setText(totalAmount.toString());
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_quantityTxtKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OldProductCombo(Satish s) {
        DefaultComboBoxModel productCombo = (DefaultComboBoxModel) nameCmb.getModel();
        try {
            List<Product> productList = aptekServiceProduct.getProductList();
            for (Product product : productList) {
                productCombo.addElement(new Item(product.getId(), product.getName()));
            }
            productCombo.setSelectedItem(new Item(s.getProduct().getId(), s.getProduct().getName()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> nameCmb;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JTextField totalAmountTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
