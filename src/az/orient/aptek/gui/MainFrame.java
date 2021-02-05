package az.orient.aptek.gui;

import az.orient.aptek.dao.AptekDaoAnbar;
import az.orient.aptek.dao.AptekDaoImplAnbar;
import az.orient.aptek.dao.AptekDaoIshciler;
import az.orient.aptek.dao.AptekDaoIshcilerImpl;
import az.orient.aptek.dao.AptekDaoMaash;
import az.orient.aptek.dao.AptekDaoMaashImpl;
import az.orient.aptek.dao.AptekDaoMedicineQroup;
import az.orient.aptek.dao.AptekDaoMedicineQroupImpl;
import az.orient.aptek.dao.AptekDaoOdenishVasiteleri;
import az.orient.aptek.dao.AptekDaoOdenishVasiteleriImpl;
import az.orient.aptek.dao.AptekDaoProduct;
import az.orient.aptek.dao.AptekDaoProductImpl;
import az.orient.aptek.dao.AptekDaoProductPrice;
import az.orient.aptek.dao.AptekDaoProductPriceImpl;
import az.orient.aptek.dao.AptekDaoRefler;
import az.orient.aptek.dao.AptekDaoReflerImpl;
import az.orient.aptek.dao.AptekDaoSatish;
import az.orient.aptek.dao.AptekDaoSatishImpl;
import az.orient.aptek.dao.AptekDaoVezifeler;
import az.orient.aptek.dao.AptekDaoVezifelerImpl;
import az.orient.aptek.dao.AptekDaoXerc;
import az.orient.aptek.dao.AptekDaoXercImpl;
import az.orient.aptek.enums.RoleEnum;

import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.Ishciler;
import az.orient.aptek.pojo.Login;
import az.orient.aptek.pojo.Maash;
import az.orient.aptek.pojo.MedicineQroup;
import az.orient.aptek.pojo.OdenishVasiteleri;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.ProductPrice;
import az.orient.aptek.pojo.Refler;
import az.orient.aptek.pojo.Role;
import az.orient.aptek.pojo.Satish;
import az.orient.aptek.pojo.Vezifeler;
import az.orient.aptek.pojo.Xerc;

import az.orient.aptek.service.AptekServiceAnbar;
import az.orient.aptek.service.AptekServiceAnbarImpl;
import az.orient.aptek.service.AptekServiceIshciler;
import az.orient.aptek.service.AptekServiceIshcilerImpl;
import az.orient.aptek.service.AptekServiceMaash;
import az.orient.aptek.service.AptekServiceMaashImpl;
import az.orient.aptek.service.AptekServiceMedicineQroup;
import az.orient.aptek.service.AptekServiceMedicineQroupImpl;
import az.orient.aptek.service.AptekServiceOdenishVasiteleri;
import az.orient.aptek.service.AptekServiceOdenishVasiteleriImpl;
import az.orient.aptek.service.AptekServiceProduct;
import az.orient.aptek.service.AptekServiceProductImpl;
import az.orient.aptek.service.AptekServiceProductPrice;
import az.orient.aptek.service.AptekServiceProductPriceImpl;
import az.orient.aptek.service.AptekServiceRefler;
import az.orient.aptek.service.AptekServiceReflerImpl;
import az.orient.aptek.service.AptekServiceSatish;
import az.orient.aptek.service.AptekServiceSatishImpl;
import az.orient.aptek.service.AptekServiceVezifeler;
import az.orient.aptek.service.AptekServiceVezifelerImpl;
import az.orient.aptek.service.AptekServiceXerc;
import az.orient.aptek.service.AptekServiceXercImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

    AptekDaoAnbar aptekDao = new AptekDaoImplAnbar();
    AptekServiceAnbar aptekService = new AptekServiceAnbarImpl(aptekDao);
    AptekDaoIshciler aptekDaoIshci = new AptekDaoIshcilerImpl();
    AptekServiceIshciler aptekServiceIshci = new AptekServiceIshcilerImpl(aptekDaoIshci);
    AptekDaoMaash aptekDaoIshciMaash = new AptekDaoMaashImpl();
    AptekServiceMaash aptekServiceMaash = new AptekServiceMaashImpl(aptekDaoIshciMaash);
    AptekDaoMedicineQroup aptekDaoMedicineQroup = new AptekDaoMedicineQroupImpl();
    AptekServiceMedicineQroup aptekServiceMedicineQroup = new AptekServiceMedicineQroupImpl(
            aptekDaoMedicineQroup);
    AptekDaoOdenishVasiteleri aptekDaoOdenishVasiteleri = new AptekDaoOdenishVasiteleriImpl();
    AptekServiceOdenishVasiteleri aptekServiceOdenishVasiteleri = new AptekServiceOdenishVasiteleriImpl(
            aptekDaoOdenishVasiteleri);
    AptekDaoProduct aptekDaoProduct = new AptekDaoProductImpl();
    AptekServiceProduct aptekServiceProduct = new AptekServiceProductImpl(aptekDaoProduct);
    AptekDaoProductPrice aptekDaoProductPrice = new AptekDaoProductPriceImpl();
    AptekServiceProductPrice aptekServiceProductPrice = new AptekServiceProductPriceImpl(aptekDaoProductPrice);
    AptekDaoRefler aptekDaoRefler = new AptekDaoReflerImpl();
    AptekServiceRefler aptekServiceRefler = new AptekServiceReflerImpl(aptekDaoRefler);
    AptekDaoSatish aptekDaoSatish = new AptekDaoSatishImpl();
    AptekServiceSatish aptekServiceSatish = new AptekServiceSatishImpl(aptekDaoSatish);
    AptekDaoVezifeler aptekDaoVezifeler = new AptekDaoVezifelerImpl();
    AptekServiceVezifeler aptekServiceVezifeler = new AptekServiceVezifelerImpl(aptekDaoVezifeler);
    AptekDaoXerc aptekDaoXerc = new AptekDaoXercImpl();
    AptekServiceXerc aptekServiceXerc = new AptekServiceXercImpl(aptekDaoXerc);

    String globBtnName = "";
    int lblTxtLength = 0;
    Timer tm;
    int counter = 0;
    private Login login;

    public MainFrame() {
    }

    public MainFrame(Login login) {
        initComponents();
        this.login = login;
        allowUser();
        String txt = jLabel1.getText();
        lblTxtLength = txt.length();
        tm = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                counter++;
                if (counter > lblTxtLength) {
                    jLabel1.setText("");
                    counter = 0;
                } else {
                    jLabel1.setText(txt.substring(0, counter));
                }
            }

        });
        tm.start();
        fullNameLbl.setText(login.getName() + " " + login.getSurname());
        enableButton(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        newBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fullNameLbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        StorehouseBtn = new javax.swing.JButton();
        employeesBtn = new javax.swing.JButton();
        salaryBtn = new javax.swing.JButton();
        medicineQroupBtn = new javax.swing.JButton();
        meansOfSalaryBtn = new javax.swing.JButton();
        productBtn = new javax.swing.JButton();
        productPriceBtn = new javax.swing.JButton();
        shelfsBtn = new javax.swing.JButton();
        salesBtn = new javax.swing.JButton();
        positionsBtn = new javax.swing.JButton();
        expenceBtn = new javax.swing.JButton();
        reportBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(60, 64));

        jPanel1.setPreferredSize(new java.awt.Dimension(1026, 741));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        newBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/new32pxl.png"))); // NOI18N
        newBtn.setText("New");
        newBtn.setToolTipText("");
        newBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/edit32pxl.png"))); // NOI18N
        editBtn.setText("Edit");
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/delete32pxl.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aptek ");
        jLabel1.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel1.setPreferredSize(new java.awt.Dimension(45, 22));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/iconfinder_medical-supplies-medicine-equipment-healthcare_5986166.png"))); // NOI18N

        searchBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/search20pxl.png"))); // NOI18N
        searchBtn.setText("Search");
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        searchTxt.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/log out.png"))); // NOI18N
        jButton1.setText("Log Out");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Welcome,");

        fullNameLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fullNameLbl.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editBtn)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fullNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editBtn, newBtn});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editBtn)
                            .addComponent(deleteBtn))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fullNameLbl)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteBtn, editBtn, newBtn});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fullNameLbl, jLabel4});

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setPreferredSize(new java.awt.Dimension(317, 741));

        StorehouseBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StorehouseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/storehouse.png"))); // NOI18N
        StorehouseBtn.setText("Storehouse");
        StorehouseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StorehouseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StorehouseBtnActionPerformed(evt);
            }
        });

        employeesBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/employee.png"))); // NOI18N
        employeesBtn.setText("Employees");
        employeesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesBtnActionPerformed(evt);
            }
        });

        salaryBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salaryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/salary.png"))); // NOI18N
        salaryBtn.setText("Salary");
        salaryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salaryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryBtnActionPerformed(evt);
            }
        });

        medicineQroupBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medicineQroupBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/medicineqrop.png"))); // NOI18N
        medicineQroupBtn.setText("Medicine qroup");
        medicineQroupBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        medicineQroupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicineQroupBtnActionPerformed(evt);
            }
        });

        meansOfSalaryBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        meansOfSalaryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/means of salary.png"))); // NOI18N
        meansOfSalaryBtn.setText("Means of salary");
        meansOfSalaryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meansOfSalaryBtnActionPerformed(evt);
            }
        });

        productBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        productBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/product.png"))); // NOI18N
        productBtn.setText("Product");
        productBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBtnActionPerformed(evt);
            }
        });

        productPriceBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        productPriceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/product_price.png"))); // NOI18N
        productPriceBtn.setText("Product price");
        productPriceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productPriceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPriceBtnActionPerformed(evt);
            }
        });

        shelfsBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shelfsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/shelfs.png"))); // NOI18N
        shelfsBtn.setText("Shelfs");
        shelfsBtn.setActionCommand("shelfs");
        shelfsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shelfsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shelfsBtnActionPerformed(evt);
            }
        });

        salesBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/sale.png"))); // NOI18N
        salesBtn.setText("Sales");
        salesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBtnActionPerformed(evt);
            }
        });

        positionsBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        positionsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/position.png"))); // NOI18N
        positionsBtn.setText("Positions");
        positionsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        positionsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionsBtnActionPerformed(evt);
            }
        });

        expenceBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expenceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/expence.png"))); // NOI18N
        expenceBtn.setText("Expence");
        expenceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        expenceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expenceBtnActionPerformed(evt);
            }
        });

        reportBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/az/orient/aptek/icons/report2.png"))); // NOI18N
        reportBtn.setText("Report");
        reportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportBtn)
                    .addComponent(expenceBtn)
                    .addComponent(employeesBtn)
                    .addComponent(positionsBtn)
                    .addComponent(salesBtn)
                    .addComponent(shelfsBtn)
                    .addComponent(productPriceBtn)
                    .addComponent(productBtn)
                    .addComponent(meansOfSalaryBtn)
                    .addComponent(medicineQroupBtn)
                    .addComponent(salaryBtn)
                    .addComponent(StorehouseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {StorehouseBtn, employeesBtn, expenceBtn, meansOfSalaryBtn, medicineQroupBtn, positionsBtn, productBtn, productPriceBtn, reportBtn, salaryBtn, salesBtn, shelfsBtn});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StorehouseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salaryBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicineQroupBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meansOfSalaryBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPriceBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shelfsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(positionsBtn)
                .addGap(12, 12, 12)
                .addComponent(expenceBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {StorehouseBtn, employeesBtn, expenceBtn, meansOfSalaryBtn, medicineQroupBtn, positionsBtn, productBtn, productPriceBtn, reportBtn, salaryBtn, salesBtn, shelfsBtn});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setRowHeight(18);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(0, 204, 0));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(240, 240, 240));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoscrolls(false);
        jTable1.setRowHeight(22);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(1044, 972));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            editBtnActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void expenceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expenceBtnActionPerformed
        try {
            globBtnName = "expence";
            List<Xerc> xercList = aptekServiceXerc.getXercList();
            showExpence(xercList);
            jLabel2.setText("Expence");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_expenceBtnActionPerformed

    private void positionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionsBtnActionPerformed
        try {
            globBtnName = "positions";
            jLabel2.setText("Positions");
            List<Vezifeler> vezifelerList = aptekServiceVezifeler.getVezifelerList();
            showPositions(vezifelerList);
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_positionsBtnActionPerformed

    private void salesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBtnActionPerformed
        try {
            List<Satish> satishList = aptekServiceSatish.getSatishList();
            showSales(satishList);
            globBtnName = "sales";
            jLabel2.setText("Sales");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_salesBtnActionPerformed

    private void shelfsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shelfsBtnActionPerformed
        try {
            globBtnName = "shelfs";

            List<Refler> reflerList = aptekServiceRefler.getReflerList();
            showShelfs(reflerList);
            jLabel2.setText("Shelfs");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_shelfsBtnActionPerformed

    private void productPriceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productPriceBtnActionPerformed
        try {
            List<ProductPrice> productPriceList = aptekServiceProductPrice.getProductPriceList();
            jLabel2.setText("Product Price");
            globBtnName = "productPrice";
            enableButton(true);
            showProductPrice(productPriceList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_productPriceBtnActionPerformed

    private void productBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productBtnActionPerformed
        try {
            globBtnName = "product";
            List<Product> productList = aptekServiceProduct.getProductList();
            showProduct(productList);
            jLabel2.setText("Product");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_productBtnActionPerformed

    private void meansOfSalaryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meansOfSalaryBtnActionPerformed
        try {
            globBtnName = "meansOfSalary";
            List<OdenishVasiteleri> odenishVasiteleriList = aptekServiceOdenishVasiteleri.getOdenishVasiteleriList();
            showMeansOfSalary(odenishVasiteleriList);
            jLabel2.setText("Means Of Salary");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_meansOfSalaryBtnActionPerformed

    private void medicineQroupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicineQroupBtnActionPerformed
        try {
            globBtnName = "medicineGroup";
            List<MedicineQroup> medicineQroupList = aptekServiceMedicineQroup.getMedicineQroupList();
            showMedicineQroup(medicineQroupList);
            jLabel2.setText("Medicine Group");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_medicineQroupBtnActionPerformed

    private void salaryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryBtnActionPerformed
        try {
            globBtnName = "salary";
            List<Maash> maashList = aptekServiceMaash.getMaashList();
            showSalary(maashList);
            jLabel2.setText("Salary");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_salaryBtnActionPerformed

    private void employeesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesBtnActionPerformed
        try {
            globBtnName = "employees";
            List<Ishciler> ishcilerList = aptekServiceIshci.getIshcilerList();
            showEmployee(ishcilerList);
            jLabel2.setText("Employees");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_employeesBtnActionPerformed

    private void StorehouseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StorehouseBtnActionPerformed
        try {
            globBtnName = "storehouse";
            List<Anbar> anbarList = aptekService.getAnbarList();
            showStorehouse(anbarList);
            jLabel2.setText("Storehouse");
            enableButton(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_StorehouseBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        searchBtnActionPerformed(null);
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            String keyword = searchTxt.getText();
            switch (globBtnName) {
                case "storehouse":
                    showStorehouse(aptekService.searchAnbarData(keyword));
                    break;
                case "employees":
                    List<Ishciler> ishcilerList = aptekServiceIshci.searchIshcilerData(keyword);
                    showEmployee(ishcilerList);
                    break;
                case "salary":
                    showSalary(aptekServiceMaash.searchMaashData(keyword));
                    break;
                case "meansOfSalary":
                    showMeansOfSalary(aptekServiceOdenishVasiteleri.searchOdenishVasiteleri(keyword));
                    break;
                case "medicineGroup":
                    showMedicineQroup(aptekServiceMedicineQroup.searchMedicineQroupData(keyword));
                    break;
                case "product":
                    showProduct(aptekServiceProduct.searchProduct(keyword));
                    break;
                case "productPrice":
                    showProductPrice(aptekServiceProductPrice.searchProductPrice(keyword));
                    break;
                case "shelfs":
                    showShelfs(aptekServiceRefler.searchRefler(keyword));
                    break;
                case "sales":
                    showSales(aptekServiceSatish.searchSatish(keyword));
                    break;
                case "positions":
                    showPositions(aptekServiceVezifeler.searchVezifeler(keyword));
                    break;
                case "expence":
                    showExpence(aptekServiceXerc.searchXerc(keyword));
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Please select menu ", "Warning", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        try {
            int selectedRow = jTable3.getSelectedRow();
            long id = (long) jTable3.getValueAt(selectedRow, 0);
            switch (globBtnName) {
                case "storehouse":

                    int confirmDeleteSh = JOptionPane.showConfirmDialog(null, "do you really want to delete this information ?", "Delete Store house", JOptionPane.YES_NO_OPTION);
                    if (confirmDeleteSh == JOptionPane.YES_OPTION) {
                        boolean delete = aptekService.deleteAnbarByPId(id);
                        if (delete) {
                            JOptionPane.showMessageDialog(null, "Storehouse has been successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                            List<Anbar> anbarList = aptekService.getAnbarList();
                            showStorehouse(anbarList);
                        } else {
                            JOptionPane.showMessageDialog(null, "Problem! Storehouse has not been successfully deleted", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    }
                    break;
                case "employees":
                    Ishciler ishciler = aptekServiceIshci.getIshciById(id);
                    int confirmDelete = JOptionPane.showConfirmDialog(null, "do you really want to delete " + ishciler.getName() + " " + ishciler.getSurname() + " ?", "Delete Employee", JOptionPane.YES_NO_OPTION);
                    if (confirmDelete == JOptionPane.YES_OPTION) {
                        boolean delete = aptekServiceIshci.deleteIshci(id);
                        if (delete) {
                            JOptionPane.showMessageDialog(null, "Employee has been successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                            List<Ishciler> ishcilerList = aptekServiceIshci.getIshcilerList();
                            showEmployee(ishcilerList);
                        } else {
                            JOptionPane.showMessageDialog(null, "Problem! Employee has not been successfully deleted", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    }
                    break;
                case "salary":
                    int confirmDeleteS = JOptionPane.showConfirmDialog(null, "do you really want to delete this information?", "Delete Salary", JOptionPane.YES_NO_OPTION);
                    if (confirmDeleteS == JOptionPane.YES_OPTION) {
                        boolean delete = aptekServiceMaash.deleteMaash(id);
                        if (delete) {
                            JOptionPane.showMessageDialog(null, "Salary has been successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                            List<Maash> maashList = aptekServiceMaash.getMaashList();
                            showSalary(maashList);
                        } else {
                            JOptionPane.showMessageDialog(null, "Problem! Salary has not been successfully deleted", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    }
                    break;
                case "meansOfSalary":
                    OdenishVasiteleri odenishVasiteleri = aptekServiceOdenishVasiteleri.getOdenishVasiteleriById(id);
                    int confirmDeleteMos = JOptionPane.showConfirmDialog(this, "do you really want to delete " + odenishVasiteleri.getName() + " ?", "Delete Means Of Salary", JOptionPane.YES_NO_OPTION);
                    if (confirmDeleteMos == JOptionPane.YES_OPTION) {
                        boolean delete = aptekServiceOdenishVasiteleri.deleteOdenishVasiteleri(id);
                        if (delete) {
                            JOptionPane.showMessageDialog(this, "Means of salary has been successfully deleted", "Succes", JOptionPane.INFORMATION_MESSAGE);
                            List<OdenishVasiteleri> odenishVasiteleriList = aptekServiceOdenishVasiteleri.getOdenishVasiteleriList();
                            showMeansOfSalary(odenishVasiteleriList);
                        } else {
                            JOptionPane.showMessageDialog(this, "Problem! Means of salary has not  been successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    jLabel2.setText("Means Of Salary");
                    break;
                case "medicineGroup":
                    MedicineQroup medicineQroup = aptekServiceMedicineQroup.getMedicineQroupById(id);
                    int confirmDeletemQ = JOptionPane.showConfirmDialog(null, "do you really want to delete " + medicineQroup.getQroupName() + " ?", "Delete medicine group", JOptionPane.YES_NO_OPTION);
                    if (confirmDeletemQ == JOptionPane.YES_OPTION) {
                        boolean delete = aptekServiceMedicineQroup.deleteMedicineQroup(id);
                        if (delete) {
                            JOptionPane.showMessageDialog(null, "Medicine qroup has been successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                            List<MedicineQroup> medicineQroupList = aptekServiceMedicineQroup.getMedicineQroupList();
                            showMedicineQroup(medicineQroupList);
                        } else {
                            JOptionPane.showMessageDialog(null, "Problem! Medicine qroup has not been successfully deleted", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    }
                    break;
                case "product":
                    Product product = aptekServiceProduct.getProductById(id);
                    boolean delete = false;
                    int confirmDeleteP;
                    Anbar anbar = new Anbar();
                    anbar.setActive(0);
                    anbar = aptekService.checkAnbarByProductId(id);
                    if (anbar.getActive() == null) {
                        confirmDeleteP = JOptionPane.showConfirmDialog(this, "do you really want to delete " + product.getName() + " ?", "Delete Product", JOptionPane.YES_NO_OPTION);
                        if (confirmDeleteP == JOptionPane.YES_OPTION) {
                            delete = aptekServiceProduct.deleteProduct(id);
                        }
                    } else {
                        confirmDeleteP = JOptionPane.showConfirmDialog(this, "There are " + anbar.getAmount() + " of this product in stock. If you hit yes, that product will be deleted from the storehouse", "Delete Product", JOptionPane.YES_NO_OPTION);
                        if (confirmDeleteP == JOptionPane.YES_OPTION) {
                            delete = aptekService.deleteAnbarByPId(id);
                            delete = aptekServiceProduct.deleteProduct(id);
                        }
                    }
                    if (delete) {
                        JOptionPane.showMessageDialog(this, "Product has been successfully deleted", "Succes", JOptionPane.INFORMATION_MESSAGE);
                        List<Product> productList = aptekServiceProduct.getProductList();
                        showProduct(productList);
                    } else {
                        JOptionPane.showMessageDialog(this, "Problem! Product has not  been successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }

                    break;

                case "productPrice":
                    int confirmDeletePPrice = JOptionPane.showConfirmDialog(this, "do you really want to delete this information?", "Delete Product Price", JOptionPane.YES_NO_OPTION);
                    if (confirmDeletePPrice == JOptionPane.YES_OPTION) {
                        boolean delete1 = aptekServiceProductPrice.deleteProductPrice(id);
                        if (delete1) {
                            JOptionPane.showMessageDialog(this, "Product Price has been successfully deleted", "Succes", JOptionPane.INFORMATION_MESSAGE);
                            List<ProductPrice> productPriceList = aptekServiceProductPrice.getProductPriceList();
                            showProductPrice(productPriceList);
                        } else {
                            JOptionPane.showMessageDialog(this, "Problem! Product Price has not  been successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    break;
                case "shelfs":
                    Refler refler = aptekServiceRefler.getReflerById(id);
                    int confirmDeleteShelfs = JOptionPane.showConfirmDialog(this, "do you really want to delete " + refler.getName() + " ?", "Delete Shelfs", JOptionPane.YES_NO_OPTION);
                    if (confirmDeleteShelfs == JOptionPane.YES_OPTION) {
                        boolean delete2 = aptekServiceRefler.deleteRefler(id);
                        if (delete2) {
                            JOptionPane.showMessageDialog(this, "Shelfs has been successfully deleted", "Succes", JOptionPane.INFORMATION_MESSAGE);
                            List<Refler> reflerList = aptekServiceRefler.getReflerList();
                            showShelfs(reflerList);
                        } else {
                            JOptionPane.showMessageDialog(this, "Problem! Shelfs has not  been successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    break;
                case "sales":
                    int confirmDeleteSale = JOptionPane.showConfirmDialog(null, "do you really want to delete this ?", "Delete Sales", JOptionPane.YES_NO_OPTION);
                    if (confirmDeleteSale == 0) {
                        boolean delete3 = aptekServiceSatish.deleteSatish(id);
                        if (delete3) {
                            JOptionPane.showMessageDialog(null, "Sales has been successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                            List<Satish> satishList = aptekServiceSatish.getSatishList();
                            showSales(satishList);
                        } else {
                            JOptionPane.showMessageDialog(null, "Problem! Sales has not been successfully deleted", "Error", JOptionPane.ERROR_MESSAGE);

                        }

                    }
                    break;
                case "positions":
                    Vezifeler vezifeler = aptekServiceVezifeler.getVezifelerById(id);
                    int confirmDeletePs = JOptionPane.showConfirmDialog(this, "do you really want to delete " + vezifeler.getName() + " ?", "Delete Position", JOptionPane.YES_NO_OPTION);
                    if (confirmDeletePs == JOptionPane.YES_OPTION) {
                        boolean delete4 = aptekServiceVezifeler.deleteVezifeler(id);
                        if (delete4) {

                            JOptionPane.showMessageDialog(this, "Positions has been successfully deleted", "Succes", JOptionPane.INFORMATION_MESSAGE);
                            List<Vezifeler> vezifelerList = aptekServiceVezifeler.getVezifelerList();
                            showPositions(vezifelerList);
                        } else {
                            JOptionPane.showMessageDialog(this, "Problem! Positions has not  been successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    break;
                case "expence":
                    Xerc xerc = aptekServiceXerc.getXercById(id);
                    int confirmDeleteEx = JOptionPane.showConfirmDialog(this, "do you really want to delete " + xerc.getOdenishVasiteleri().getName() + " ?", "Delete expence", JOptionPane.YES_NO_OPTION);
                    if (confirmDeleteEx == JOptionPane.YES_OPTION) {
                        boolean delete5 = aptekServiceXerc.deleteXerc(id);
                        if (delete5) {

                            JOptionPane.showMessageDialog(this, "Expence has been successfully deleted", "Succes", JOptionPane.INFORMATION_MESSAGE);
                            List<Xerc> xercList = aptekServiceXerc.getXercList();
                            showExpence(xercList);
                        } else {
                            JOptionPane.showMessageDialog(this, "Problem! Expence has not  been successfully deleted", "Error", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Please select menu ", "Warning", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Please select menu ", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        try {

            int selectedRow = jTable3.getSelectedRow();
            long id = (long) jTable3.getValueAt(selectedRow, 0);
            switch (globBtnName) {
                case "storehouse":
//                    EditStorehouseFrame editStorehouseFrame = new EditStorehouseFrame(id, aptekServiceProduct);
//                    editStorehouseFrame.setVisible(true);
                    EditStoreHouse2 editStorehouseFrame = new EditStoreHouse2(id);
                    editStorehouseFrame.setVisible(true);
                    break;
                case "employees":
                    EditEmployeesFrame editEmployeesFrame = new EditEmployeesFrame(id);
                    editEmployeesFrame.setVisible(true);
                                     
                    break;
                case "salary":
                    EditSalaryFrame editSalaryFrame = new EditSalaryFrame(id, aptekServiceIshci, aptekServiceVezifeler);
                    editSalaryFrame.setVisible(true);
                    break;
                case "meansOfSalary":
                    EditMeansOfSalaryFrame editMeansOfSalaryFrame = new EditMeansOfSalaryFrame(id);
                    editMeansOfSalaryFrame.setVisible(true);
                    break;
                case "medicineGroup":
                    EditMedicineQroupFrame editMedicineQroupFrame = new EditMedicineQroupFrame(id, aptekServiceRefler);
                    editMedicineQroupFrame.setVisible(true);
                    break;
                case "product":
                    EditProductFrame editProductFrame = new EditProductFrame(id, aptekServiceRefler, aptekServiceMedicineQroup);
                    editProductFrame.setVisible(true);
                    break;
                case "productPrice":
                    EditProductPriceFrame editProductPriceFrame = new EditProductPriceFrame(id, aptekServiceProduct);
                    editProductPriceFrame.setVisible(true);
                    break;
                case "shelfs":
                    EditShelfsFrame editShelfsFrame = new EditShelfsFrame(id);
                    editShelfsFrame.setVisible(true);
                    jLabel2.setText("Shelfs");
                    break;
                case "sales":
                    EditSalesFrame editSalesFrame = new EditSalesFrame(id, aptekServiceProduct);
                    editSalesFrame.setVisible(true);
                    break;
                case "positions":
                    EditPositionFrame editPositionFrame = new EditPositionFrame(id);
                    editPositionFrame.setVisible(true);
                    break;
                case "expence":
                    EditExpenceFrame editExpenceFrame = new EditExpenceFrame(id, aptekServiceOdenishVasiteleri);
                    editExpenceFrame.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Please select menu ", "Warning", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Please select menu ", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        switch (globBtnName) {
            case "storehouse":
                NewStoreHouseFrame newStoreHouseFrame = new NewStoreHouseFrame(aptekServiceProduct);
                newStoreHouseFrame.setVisible(true);
                break;
            case "employees":
                NewEmployeesFrame employeesFrame = new NewEmployeesFrame();
                employeesFrame.setVisible(true);
                break;
            case "salary":
                NewSalaryFrame newSalaryFrame = new NewSalaryFrame(aptekServiceIshci, aptekServiceVezifeler);
                newSalaryFrame.setVisible(true);
                break;
            case "meansOfSalary":
                NewMeansOfSalaryFrame meansOfSalaryFrame = new NewMeansOfSalaryFrame();
                meansOfSalaryFrame.setVisible(true);
                break;
            case "medicineGroup":
                NewMedicineQroupFrame newmMedicineQroupFrame = new NewMedicineQroupFrame(aptekServiceRefler);
                newmMedicineQroupFrame.setVisible(true);
                break;
            case "product":
                NewProductFrame newProductFrame = new NewProductFrame(aptekServiceRefler, aptekServiceMedicineQroup);
                newProductFrame.setVisible(true);
                break;
            case "productPrice":
                NewProductPriceFrame newProductPriceFrame = new NewProductPriceFrame(aptekServiceProduct);
                newProductPriceFrame.setVisible(true);
                break;
            case "shelfs":
                NewShelfsFrame newShelfsFrame = new NewShelfsFrame();
                newShelfsFrame.setVisible(true);
                break;
            case "sales":
                NewSalesFrame newSalesFrame = new NewSalesFrame(aptekServiceProduct);
                newSalesFrame.setVisible(true);
                jLabel2.setText("Sales");
                break;
            case "positions":
                NewPositionsFrame newPositionsFrame = new NewPositionsFrame();
                newPositionsFrame.setVisible(true);
                break;
            case "expence":
                NewExpenceFrame newExpenceFrame = new NewExpenceFrame(aptekServiceOdenishVasiteleri);
                newExpenceFrame.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Please select menu ", "Warning", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_newBtnActionPerformed

    private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBtnActionPerformed
        GeneralReportFrame grf=new GeneralReportFrame();
        
        grf.setVisible(true);
        
    }//GEN-LAST:event_reportBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StorehouseBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton employeesBtn;
    private javax.swing.JButton expenceBtn;
    private javax.swing.JLabel fullNameLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton meansOfSalaryBtn;
    private javax.swing.JButton medicineQroupBtn;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton positionsBtn;
    private javax.swing.JButton productBtn;
    private javax.swing.JButton productPriceBtn;
    private javax.swing.JButton reportBtn;
    private javax.swing.JButton salaryBtn;
    private javax.swing.JButton salesBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton shelfsBtn;
    // End of variables declaration//GEN-END:variables

    private void showStorehouse(List<Anbar> anbarList) {

        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
//            model.addColumn("#");
            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Amount");
            model.addColumn("Barcode");

            for (Anbar anbar : anbarList) {
                Object[] data = new Object[]{anbar.getProduct().getId(),
                    anbar.getProduct().getName(), anbar.getAmount(), anbar.getProduct().getBarkod()};
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
//            jTable3.getColumnModel().getColumn(1).setMinWidth(0);
//            jTable3.getColumnModel().getColumn(1).setWidth(0);
//            jTable3.getColumnModel().getColumn(1).setMaxWidth(0);

            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showEmployee(List<Ishciler> ishcilerList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }
            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Name");
            model.addColumn("Surname");
            model.addColumn("Date of Birth");
            model.addColumn("Adress");
            model.addColumn("Phone");
            model.addColumn("Education");
            model.addColumn("Language");

            for (Ishciler ishciler : ishcilerList) {
                Object[] data = new Object[]{
                    ishciler.getId(), ishciler.getR(), ishciler.getName(), ishciler.getSurname(), ishciler.getDob(), ishciler.getAdress(), ishciler.getPhone(), ishciler.getTehsil(), ishciler.getDilBiliyi()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);

            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showSalary(List<Maash> maashList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Position");
            model.addColumn("Employee Fullname");
            model.addColumn("Salary");
            model.addColumn("Payment Date ");

            for (Maash maash : maashList) {
                Object[] data = new Object[]{
                    maash.getId(), maash.getR(), maash.getVezifeler().getName(), maash.getIshciler().getName() + " " + maash.getIshciler().getSurname(), maash.getSalary(), maash.getDataDate()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMedicineQroup(List<MedicineQroup> medicineQroupList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Qroup Name");
            model.addColumn("Shelf Name");

            for (MedicineQroup medicineQroup : medicineQroupList) {
                Object[] data = new Object[]{
                    medicineQroup.getId(), medicineQroup.getR(), medicineQroup.getQroupName(), medicineQroup.getShelfs().getName()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMeansOfSalary(List<OdenishVasiteleri> odenishVasiteleriList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Name");

            for (OdenishVasiteleri odenishVasiteleri : odenishVasiteleriList) {
                Object[] data = new Object[]{
                    odenishVasiteleri.getId(), odenishVasiteleri.getR(), odenishVasiteleri.getName()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showProduct(List<Product> productList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Name");
            model.addColumn("Qroup name");
            model.addColumn("Shelf");
            model.addColumn("Barkod");

            for (Product product : productList) {
                Object[] data = new Object[]{
                    product.getId(), product.getR(), product.getName(), product.getMedicineQroup().getQroupName(), product.getRefler().getName(), product.getBarkod()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showProductPrice(List<ProductPrice> productPriceList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Name");
            model.addColumn("Price");
            model.addColumn("Currency");

            for (ProductPrice productPrice : productPriceList) {
                Object[] data = new Object[]{
                    productPrice.getId(), productPrice.getR(), productPrice.getProduct().getName(), productPrice.getPrice(), productPrice.getCurrency()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showShelfs(List<Refler> reflerList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Name");
            model.addColumn("Size");

            for (Refler ref : reflerList) {
                Object[] data = new Object[]{
                    ref.getId(), ref.getR(), ref.getName(), ref.getOlcu()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSales(List<Satish> satishList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Name");
            model.addColumn("Price");
            model.addColumn("Amount");
            model.addColumn("Total amount");
            model.addColumn("Sales Date");

            for (Satish satish : satishList) {
                Object[] data = new Object[]{
                    satish.getId(), satish.getR(), satish.getProduct().getName(), satish.getMebleq(), satish.getMiqdar(), satish.getTotalAmount(), satish.getDataDate()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showExpence(List<Xerc> xercList) {
        try {

            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Name");
            model.addColumn("Payment");
            model.addColumn("Data_date");

            for (Xerc xerc : xercList) {
                Object[] data = new Object[]{
               
                    xerc.getId(), xerc.getR(), xerc.getOdenishVasiteleri().getName(), xerc.getAmount(), xerc.getDataDate()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showPositions(List<Vezifeler> vezifelerList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;
                }

            };
            jTable3.setModel(model);
            model.addColumn("ID");
            model.addColumn("#");
            model.addColumn("Position");
            model.addColumn("The day it arrived");

            for (Vezifeler vezifeler : vezifelerList) {
                Object[] data = new Object[]{
                    vezifeler.getId(), vezifeler.getR(), vezifeler.getName(), vezifeler.getDataDate()
                };
                model.addRow(data);
            }
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void allowUser() {
        Role role = login.getRole();
        if (role.getRoleName().equals(RoleEnum.ROLE_SELLER.name())) {
            editBtn.setVisible(false);
            deleteBtn.setVisible(false);
            employeesBtn.setVisible(false);
            expenceBtn.setVisible(false);
            positionsBtn.setVisible(false);
            meansOfSalaryBtn.setVisible(false);

        } else if (role.getRoleName().equals(RoleEnum.ROLE_OPERATOR.name())) {
            editBtn.setVisible(false);
            deleteBtn.setVisible(false);
            employeesBtn.setVisible(false);
            salesBtn.setVisible(false);
            positionsBtn.setVisible(false);

        }
    }

    private void enableButton(boolean isEnabled) {
        newBtn.setEnabled(isEnabled);
        editBtn.setEnabled(isEnabled);
        deleteBtn.setEnabled(isEnabled);
        searchTxt.setEnabled(isEnabled);
        searchBtn.setEnabled(isEnabled);
        searchTxt.setText("");
    }

}
