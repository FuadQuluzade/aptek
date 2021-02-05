/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoAnbar;
import az.orient.aptek.dao.AptekDaoImplAnbar;
import az.orient.aptek.dao.AptekDaoProduct;
import az.orient.aptek.dao.AptekDaoProductImpl;
import az.orient.aptek.dao.AptekDaoSatish;
import az.orient.aptek.dao.AptekDaoSatishImpl;

import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.Item;
import az.orient.aptek.pojo.Product;

import az.orient.aptek.pojo.Satish;
import az.orient.aptek.service.AptekServiceAnbar;
import az.orient.aptek.service.AptekServiceAnbarImpl;
import az.orient.aptek.service.AptekServiceProduct;
import az.orient.aptek.service.AptekServiceProductImpl;
import az.orient.aptek.service.AptekServiceSatish;
import az.orient.aptek.service.AptekServiceSatishImpl;

import java.util.ArrayList;
import java.util.EventObject;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fuad
 */
public class NewSalesFrame extends javax.swing.JFrame {

    AptekDaoSatish aptekDaoSatish = new AptekDaoSatishImpl();
    AptekServiceSatish aptekServiceSatish = new AptekServiceSatishImpl(aptekDaoSatish);
    AptekDaoAnbar aptekDaoAnbar = new AptekDaoImplAnbar();
    AptekServiceAnbar aptekServiceAnbar = new AptekServiceAnbarImpl(aptekDaoAnbar);
    AptekDaoProduct aptekDaoProduct = new AptekDaoProductImpl();
    AptekServiceProduct aptekServiceProduct = new AptekServiceProductImpl(aptekDaoProduct);
    DefaultTableModel dtm = new DefaultTableModel();

    long id;

    public NewSalesFrame() {
        initComponents();
    }

    NewSalesFrame(AptekServiceProduct aptekServiceProduct) {
        initComponents();
        this.aptekServiceProduct = aptekServiceProduct;
        showProductCombo();
        AutoCompleteDecorator.decorate(nameCmb);
        jTable1.setModel(dtm);
        dtm.setColumnIdentifiers(new String[]{"Kod", "Product name", "Price", "Quantity", "Total Amount"});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameCmb = new javax.swing.JComboBox<>();
        priceTxt = new javax.swing.JTextField();
        quantityTxt = new javax.swing.JTextField();
        totalAmountTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        removeBtn = new javax.swing.JButton();
        removeAllBtn = new javax.swing.JButton();
        sumTxt = new javax.swing.JTextField();
        sumBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        barkodTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        printBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Price");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quantity");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total amount");

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

        totalAmountTxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

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
        ClearBtn.setToolTipText("Click here to clear data");
        ClearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kod", "Product name", "Price", "Quantity", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        addBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/add+.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.setToolTipText("Click here to add data");
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/close.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.setToolTipText("Click here to close the program");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 51, 51));

        removeBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/remove24pxl.png"))); // NOI18N
        removeBtn.setText("Remove");
        removeBtn.setToolTipText("Click here to remove table data");
        removeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        removeAllBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removeAllBtn.setText("Remove all");
        removeAllBtn.setToolTipText("Click here to remove all table data");
        removeAllBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllBtnActionPerformed(evt);
            }
        });

        sumTxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sumBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/calculator.png"))); // NOI18N
        sumBtn.setText("Get Sum");
        sumBtn.setToolTipText("Click here to get sum total amount");
        sumBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sumBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumBtnActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 153, 51));

        editBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/update.png"))); // NOI18N
        editBtn.setText("edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Barkod");

        barkodTxt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        barkodTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barkodTxtKeyReleased(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(204, 0, 0));

        printBtn.setText("print");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(barkodTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantityTxt)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalAmountTxt)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(sumBtn)
                                .addGap(18, 18, 18)
                                .addComponent(sumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(printBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeAllBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {priceTxt, quantityTxt, totalAmountTxt});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ClearBtn, removeAllBtn, removeBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barkodTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sumBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(printBtn))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeAllBtn)
                            .addComponent(removeBtn)
                            .addComponent(editBtn)
                            .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {priceTxt, quantityTxt, totalAmountTxt});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ClearBtn, editBtn, removeAllBtn, removeBtn, saveBtn});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "the table is empty");
        } else {
            try {
//                int i;
//                 quantity = null;
//                 productId = null;
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    Satish satish = new Satish();
                    Product product = new Product();
                    Long  productId = Long.valueOf(jTable1.getValueAt(i, 0).toString());
                    product.setId(productId);
                    satish.setProduct(product);
                    satish.setMebleq(Double.valueOf(jTable1.getValueAt(i, 2).toString()));
                    satish.setMiqdar(Integer.valueOf(jTable1.getValueAt(i, 3).toString()));
                    satish.setTotalAmount(Double.valueOf(jTable1.getValueAt(i, 4).toString()));
                    Integer  quantity = aptekServiceSatish.getAnbarById(productId);

//                    if (Integer.valueOf(jTable1.getValueAt(i, 3).toString()) > quantity) {
//                        JOptionPane.showMessageDialog(null, "o qeder mal yoxdur");
//                    } else {
                        aptekServiceSatish.addSatish(satish);
//satish zamani productun miqdarini anbarda olan productun miqdarinnan cixiriq   

                        Anbar anbar = aptekServiceAnbar.getAnbarByP_Id(productId);

                        anbar.setAmount(quantity - Integer.valueOf(jTable1.getValueAt(i, 3).toString()));
//qayidan deyeri anbardaki producta menimsedirik
                        aptekServiceAnbar.updateAnbarByP_Id(anbar, productId);
// eger miqdar sifirlansa anbardanda silinecek  

                        if (anbar.getAmount() == 0) {
                            aptekServiceAnbar.deleteAnbarByPId(productId);
                        }
                        JOptionPane.showMessageDialog(null, "Sales has been successfully added");

                        dtm.getDataVector().removeAllElements();
                        dtm.fireTableDataChanged();
                        sumTxt.setText("");

//                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "o qeder mal yoxdur");
//                removeAllBtnActionPerformed(evt);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void nameCmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nameCmbItemStateChanged

        try {
            Item nameCombo = (Item) nameCmb.getSelectedItem();
            Double price = aptekServiceSatish.getProductPriceById(nameCombo.getId());
            Integer barkod = aptekServiceSatish.getProductBarkodById(nameCombo.getId());
            barkodTxt.setText(barkod.toString());
            priceTxt.setText(price.toString());
//            id e gore quantity qaytatrir
            Integer quantity = aptekServiceSatish.getAnbarById(nameCombo.getId());

            if (quantity <= 0) {
                addBtn.setEnabled(false);
            } else {
                addBtn.setEnabled(true);
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
        } catch (NumberFormatException en) {
            JOptionPane.showMessageDialog(this, "Invalid quantity", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_nameCmbItemStateChanged


    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        nameCmb.setSelectedIndex(0);
        priceTxt.setText("");
        quantityTxt.setText("");
        totalAmountTxt.setText("");
        jLabel6.setText("");
        jLabel5.setText("");
        barkodTxt.setText("");
        addBtn.setEnabled(true);

    }//GEN-LAST:event_ClearBtnActionPerformed

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
                    addBtn.setEnabled(false);
                } else {
                    addBtn.setEnabled(true);
                    Double price = Double.parseDouble(priceTxt.getText());
                    Double quantity = Double.parseDouble(quantityTxt.getText());
                    Double totalAmount = price * quantity;
                    totalAmountTxt.setText(totalAmount.toString());
                }

            } catch (NumberFormatException en) {
                JOptionPane.showMessageDialog(this, "Invalid quantity", "Warning", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_quantityTxtKeyReleased

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try {

            if (quantityTxt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Quantity is null!");
            } else {

                Item productItem = (Item) nameCmb.getSelectedItem();

                dtm.addRow(new String[]{productItem.getId().toString(), productItem.getValue(), priceTxt.getText(), quantityTxt.getText(), totalAmountTxt.getText()});
                nameCmb.setSelectedIndex(0);
                priceTxt.setText("");
                quantityTxt.setText("");
                totalAmountTxt.setText("");
                jLabel6.setText("");
                barkodTxt.setText("");
                sumBtnActionPerformed(null);
            }

        } catch (ClassCastException c) {
            JOptionPane.showMessageDialog(this, "Please enter all data", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        if (jTable1.getSelectedRow() == 0) {
            dtm.removeRow(jTable1.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Please select the row first", "Warning", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void removeAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllBtnActionPerformed
        while (dtm.getRowCount() > 0) {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                dtm.removeRow(i);
            }
        }
        sumTxt.setText("");

    }//GEN-LAST:event_removeAllBtnActionPerformed

    private void sumBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumBtnActionPerformed
        double s = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            s += Double.parseDouble(jTable1.getValueAt(i, 4).toString());
        }
        sumTxt.setText(s + "");
    }//GEN-LAST:event_sumBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();
            long id = Long.parseLong(jTable1.getValueAt(selectedRow, 0).toString());
            int quantity = Integer.parseInt(jTable1.getValueAt(selectedRow, 3).toString());

            EditBtnFrameInSAle btnFrameInSAle = new EditBtnFrameInSAle(id, quantity);
            btnFrameInSAle.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_editBtnActionPerformed

    private void barkodTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barkodTxtKeyReleased
        try {
            if (barkodTxt.getText().length() == 5) {
                String name = aptekServiceSatish.getProductNameByBarkod(Integer.valueOf(barkodTxt.getText()));
                if (!name.equals("NO_CONTENT")) {
                    nameCmb.setSelectedItem(name);
                } else {
                    jLabel8.setText("there is no product in this barcode!");
                }

            } else {
                nameCmb.setSelectedIndex(0);
                priceTxt.setText("");
                jLabel6.setText("");
                jLabel8.setText("");
            }

//        } catch (NullPointerException ex) {
//        } catch (NumberFormatException ex) {
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_barkodTxtKeyReleased

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        long kod = 0;
        String name = null;
        Double mebleq = null;
        Integer quantity = null;
        double total = 0;
          
          
              List<Satish> satishList=new ArrayList<Satish>();
            for (int i = 0; i < jTable1.getRowCount(); i++) {
           Satish satish= new Satish();
           Product product=new Product();
            kod = Long.parseLong(jTable1.getValueAt(i, 0).toString());
            name = (String) jTable1.getValueAt(i, 1);
            mebleq = Double.parseDouble(jTable1.getValueAt(i, 2).toString());
            quantity = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            total = Double.valueOf(jTable1.getValueAt(i, 4).toString());
            product.setId(kod);
            product.setName(name);
            satish.setProduct(product);
            satish.setMebleq(mebleq);
            satish.setMiqdar(quantity);
            satish.setTotalAmount(total);
            satishList.add(satish);
              
//               satishList.add(String.valueOf(kod));
//               satishList.add(name);
//               satishList.add(String.valueOf(mebleq));
//               satishList.add(String.valueOf(quantity));
//               satishList.add(String.valueOf(total));
                
            }
            
            
             PrintjFrame printjFrame = new PrintjFrame(satishList);
             printjFrame.setVisible(true);
             
    }//GEN-LAST:event_printBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField barkodTxt;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> nameCmb;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JButton printBtn;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JButton removeAllBtn;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton sumBtn;
    private javax.swing.JTextField sumTxt;
    private javax.swing.JTextField totalAmountTxt;
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

    public static void editRowJtable(int kod, int quantity) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int i = jTable1.getSelectedRow();
        model.setValueAt(kod, i, 0);
        model.setValueAt(quantity, i, 3);

    }
    
//    public static void showrow(List<Satish> satishList){
//     long kod = 0;
//        String name = null;
//        Double mebleq = null;
//        Integer quantity = null;
//        double total = 0;
//          
//           Satish satish= new Satish();
//           Product product=new Product();
//              
//            for (int i = 0; i < jTable1.getRowCount(); i++) {
//              
//            kod = Long.parseLong(jTable1.getValueAt(i, 0).toString());
//            name = (String) jTable1.getValueAt(i, 1);
//            mebleq = Double.parseDouble(jTable1.getValueAt(i, 2).toString());
//            quantity = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
//            total = Double.valueOf(jTable1.getValueAt(i, 4).toString());
//            product.setId(kod);
//            product.setName(name);
//            satish.setProduct(product);
//            satish.setMebleq(mebleq);
//            satish.setMiqdar(quantity);
//            satish.setTotalAmount(total);
//            satishList.add(satish);
//    }

}


