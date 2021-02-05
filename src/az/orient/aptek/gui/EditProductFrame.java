/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoProduct;
import az.orient.aptek.dao.AptekDaoProductImpl;
import az.orient.aptek.pojo.Item;
import az.orient.aptek.pojo.MedicineQroup;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.Refler;
import az.orient.aptek.service.AptekServiceMedicineQroup;
import az.orient.aptek.service.AptekServiceProduct;
import az.orient.aptek.service.AptekServiceProductImpl;
import az.orient.aptek.service.AptekServiceRefler;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Fuad
 */
public class EditProductFrame extends javax.swing.JFrame {

    AptekDaoProduct aptekDaoProduct = new AptekDaoProductImpl();
    AptekServiceProduct aptekServiceProduct = new AptekServiceProductImpl(aptekDaoProduct);
    private long id;
    private AptekServiceRefler aptekServiceRefler;
    private AptekServiceMedicineQroup aptekServiceMedicineQroup;

    public EditProductFrame() {
        initComponents();
    }

    public EditProductFrame(long id, AptekServiceRefler aptekServiceRefler, AptekServiceMedicineQroup aptekServiceMedicineQroup) {
        initComponents();
        this.id = id;
        this.aptekServiceRefler = aptekServiceRefler;
        this.aptekServiceMedicineQroup = aptekServiceMedicineQroup;
        try {
            Product product = aptekServiceProduct.getProductById(id);
            nameTxt.setText(product.getName());
            editShelfCombo(product);
            editMediceQroupCombo(product);
            barkodTxt.setText(product.getBarkod().toString());
            AutoCompleteDecorator.decorate(shelfNameCmb);
            AutoCompleteDecorator.decorate(groupNameCmb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupNameCmb = new javax.swing.JComboBox<>();
        shelfNameCmb = new javax.swing.JComboBox<>();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        barkodTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        groupNameCmb.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        groupNameCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select group name", " " }));

        shelfNameCmb.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        shelfNameCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select shelf name" }));

        updateBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/update.png"))); // NOI18N
        updateBtn.setText("Update ");
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

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Product Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Group Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Shelf Name");

        nameTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTxtKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Barkod");

        barkodTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(groupNameCmb, 0, 188, Short.MAX_VALUE)
                            .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(shelfNameCmb, 0, 188, Short.MAX_VALUE)
                            .addComponent(barkodTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(closeBtn)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clearBtn, closeBtn, updateBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(groupNameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(shelfNameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barkodTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 86, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(closeBtn))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clearBtn, closeBtn, updateBtn});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            Item MediceQroupItem = (Item) groupNameCmb.getSelectedItem();
            Item shelfItem = (Item) shelfNameCmb.getSelectedItem();
            String name = nameTxt.getText();
            Integer barkod = Integer.valueOf(barkodTxt.getText());
            Product p = new Product();
            MedicineQroup medicineQroup = new MedicineQroup();
            medicineQroup.setId(MediceQroupItem.getId());
            Refler r = new Refler();
            r.setId(shelfItem.getId());
            p.setId(id);
            p.setMedicineQroup(medicineQroup);
            p.setRefler(r);
            p.setName(name);
            p.setBarkod(barkod);
         if(aptekServiceProduct.checkProduct(p, true)){
              JOptionPane.showMessageDialog(null, "this product or barkod is aviable");
         }else{
                boolean update = aptekDaoProduct.updateProduct(p, id);
                if (update) {
                    JOptionPane.showMessageDialog(null, "Product has been successfully added", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Problem! Product has not been successfully added", "Error", JOptionPane.ERROR_MESSAGE);
                    this.dispose();
                }
         }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please Enter all data!");
        }

    }//GEN-LAST:event_updateBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        groupNameCmb.setSelectedIndex(0);
        shelfNameCmb.setSelectedIndex(0);
        nameTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void nameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyPressed
        char c = evt.getKeyChar();
        if ((Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) && c!=32) {
            nameTxt.setEditable(true);
            jLabel4.setText("");

        } else {
            nameTxt.setEditable(false);
            jLabel4.setText("Please enter words only !");
        }
    }//GEN-LAST:event_nameTxtKeyPressed

    private void editShelfCombo(Product product) {
        DefaultComboBoxModel shelfCombo = (DefaultComboBoxModel) shelfNameCmb.getModel();

        try {
            List<Refler> reflerList = aptekServiceRefler.getReflerList();
            for (Refler refler : reflerList) {
                shelfCombo.addElement(new Item(refler.getId(), refler.getName()));
            }
            shelfCombo.setSelectedItem(new Item(product.getRefler().getId(), product.getRefler().getName()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editMediceQroupCombo(Product product) {
        DefaultComboBoxModel medicineQroupCombo = (DefaultComboBoxModel) groupNameCmb.getModel();
        try {
            List<MedicineQroup> medicineGroupList = aptekServiceMedicineQroup.getMedicineQroupList();
            for (MedicineQroup medicineQroup : medicineGroupList) {
                medicineQroupCombo.addElement(new Item(medicineQroup.getId(), medicineQroup.getQroupName()));
            }
            medicineQroupCombo.setSelectedItem(new Item(product.getMedicineQroup().getId(), product.getMedicineQroup().getQroupName()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barkodTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JComboBox<String> groupNameCmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JComboBox<String> shelfNameCmb;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
