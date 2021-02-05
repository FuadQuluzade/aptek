/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoIshciler;
import az.orient.aptek.dao.AptekDaoIshcilerImpl;
import az.orient.aptek.pojo.Ishciler;
import az.orient.aptek.service.AptekServiceIshciler;
import az.orient.aptek.service.AptekServiceIshcilerImpl;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Fuad
 */
public class EditEmployeesFrame extends javax.swing.JFrame {

    AptekDaoIshciler aptekDaoIshci = new AptekDaoIshcilerImpl();
    AptekServiceIshciler aptekServiceIshci = new AptekServiceIshcilerImpl(aptekDaoIshci);
    long id;

    public EditEmployeesFrame() {
        initComponents();
    }

    public EditEmployeesFrame(long id) {
        initComponents();
        this.id = id;
        showOldEmployeesData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adressTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        dobTxt = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        educationTxt = new javax.swing.JTextField();
        languageTxt = new javax.swing.JTextField();
        closeBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        nameTxt = new javax.swing.JTextField();
        surnameTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));
        setUndecorated(true);

        adressTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));

        phoneTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Education");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Language");

        educationTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        educationTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                educationTxtKeyPressed(evt);
            }
        });

        languageTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        languageTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                languageTxtKeyPressed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name");
        jLabel1.setPreferredSize(new java.awt.Dimension(45, 16));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Surname");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Date of birth");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Adress");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Phone");

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

        nameTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTxtKeyPressed(evt);
            }
        });

        surnameTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        surnameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                surnameTxtKeyPressed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateBtn)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(languageTxt)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dobTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                            .addComponent(adressTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(educationTxt))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(clearBtn)
                        .addGap(38, 38, 38)
                        .addComponent(closeBtn)
                        .addContainerGap(45, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(surnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                    .addGap(60, 60, 60)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {adressTxt, educationTxt, languageTxt, nameTxt, phoneTxt, surnameTxt});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clearBtn, closeBtn, updateBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(educationTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(surnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(482, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {adressTxt, educationTxt, languageTxt, nameTxt, phoneTxt, surnameTxt});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {clearBtn, closeBtn, updateBtn});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void educationTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_educationTxtKeyPressed
        char c = evt.getKeyChar();
        if ((Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) && c!=32) {
            educationTxt.setEditable(true);
            jLabel11.setText("");

        } else {
            educationTxt.setEditable(false);
            jLabel11.setText("Please enter words only !");
        }
    }//GEN-LAST:event_educationTxtKeyPressed

    private void languageTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_languageTxtKeyPressed
        char c = evt.getKeyChar();
        if ((Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) && c!=32) {
            languageTxt.setEditable(true);
            jLabel12.setText("");

        } else {
            languageTxt.setEditable(false);
            jLabel12.setText("Please enter words only !");
        }
    }//GEN-LAST:event_languageTxtKeyPressed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        try {
            String name = nameTxt.getText();
            String surname = surnameTxt.getText();
            Date dob = dobTxt.getDate();
            String adress = adressTxt.getText();
            String phone = phoneTxt.getText();
            String tehsil = educationTxt.getText();
            String language = languageTxt.getText();
            Ishciler ishci = new Ishciler();
            ishci.setName(name);
            ishci.setSurname(surname);
            ishci.setDob(dob);
            ishci.setAdress(adress);
            ishci.setPhone(phone);
            ishci.setTehsil(tehsil);
            ishci.setDilBiliyi(language);
            if (nameTxt.getText().equals("") || surnameTxt.getText().equals("") || dobTxt.getDateFormatString().equals("")
                    || adressTxt.getText().equals("") || phoneTxt.getText().equals("") || educationTxt.getText().equals("") || languageTxt.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter the all data", "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else {
                boolean update = aptekServiceIshci.updateIshci(ishci, id);
                if (update) {
                    JOptionPane.showMessageDialog(null, "Employee has been successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                 

                } else {
                    JOptionPane.showMessageDialog(null, "Problem! Employee has not been successfully updated", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter the all data", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        nameTxt.setText("");
        surnameTxt.setText("");
        dobTxt.setDateFormatString("");
        adressTxt.setText("");
        phoneTxt.setText("");
        educationTxt.setText("");
        languageTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void nameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyPressed
        char c = evt.getKeyChar();
        if ((Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) && c!=32) {
            nameTxt.setEditable(true);
            jLabel8.setText("");

        } else {
            nameTxt.setEditable(false);
            jLabel8.setText("Please enter words only !");
        }
    }//GEN-LAST:event_nameTxtKeyPressed

    private void surnameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_surnameTxtKeyPressed
        char c = evt.getKeyChar();
        if ((Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) && c!=32) {
            surnameTxt.setEditable(true);
            jLabel9.setText("");

        } else {
            surnameTxt.setEditable(false);
            jLabel9.setText("Please enter words only !");
        }
    }//GEN-LAST:event_surnameTxtKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adressTxt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton closeBtn;
    private com.toedter.calendar.JDateChooser dobTxt;
    private javax.swing.JTextField educationTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField languageTxt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JTextField surnameTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void showOldEmployeesData() {
        try {
            Ishciler ishci = aptekServiceIshci.getIshciById(id);
            nameTxt.setText(ishci.getName());
            surnameTxt.setText(ishci.getSurname());
            dobTxt.setDate(ishci.getDob());
            adressTxt.setText(ishci.getAdress());
            phoneTxt.setText(ishci.getPhone());
            educationTxt.setText(ishci.getTehsil());
            languageTxt.setText(ishci.getDilBiliyi());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
