package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.MedicineQroup;

import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.Refler;

public class AptekDaoProductImpl implements AptekDaoProduct {
    
    @Override
    public List<Product> getProductList() throws Exception {
        List<Product> productList = new ArrayList<Product>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,P.ID,P.NAME,MQ.ID MEDICINE_GROUP_ID,MQ.QROUP_NAME,R.ID SHELF_ID ,R.NAME SHELF,P.BARKOD FROM PRODUCT P \r\n"
                + "INNER JOIN MEDICINE_QROUP MQ ON P.MQ_ID=MQ.ID \r\n"
                + "INNER JOIN REFLER R ON P.R_ID= R.ID \r\n"
                + "WHERE P.ACTIVE=1 ";
        
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setR(rs.getLong("r"));
                    product.setId(rs.getLong("ID"));
                    product.setName(rs.getString("NAME"));
                    MedicineQroup mq = new MedicineQroup();
                    mq.setId(rs.getLong("MEDICINE_GROUP_ID"));
                    mq.setQroupName(rs.getString("QROUP_NAME"));
                    Refler r = new Refler();
                    r.setId(rs.getLong("SHELF_ID"));
                    r.setName(rs.getString("SHELF"));
                    product.setMedicineQroup(mq);
                    product.setRefler(r);
                    product.setBarkod(rs.getInt("BARKOD"));
                    productList.add(product);
                }
                
            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return productList;
    }
    
    @Override
    public boolean addProduct(Product product) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO PRODUCT(ID,NAME,MQ_ID,R_ID,BARKOD) " + " VALUES(PRODUCT_SEQ.NEXTVAL,?,?,?,?)";
        
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, product.getName());
                ps.setLong(2, product.getMedicineQroup().getId());
                ps.setLong(3, product.getRefler().getId());
                ps.setInt(4, product.getBarkod());
                ps.execute();
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, null);
        }
        return result;
    }
    
    @Override
    public Product getProductById(Long productId) throws Exception {
        Product product = new Product();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT P.ID PRODUCT_ID,P.NAME PRODUT_NAME ,MQ.ID MEDICINE_GROUP_ID,MQ.QROUP_NAME QROUP_NAME,R.ID REF_ID,R.NAME REF_NAME ,P.BARKOD FROM PRODUCT P  "
                + "  INNER JOIN MEDICINE_QROUP MQ ON P.MQ_ID=MQ.ID " + " INNER JOIN REFLER R ON P.R_ID= R.ID  "
                + " WHERE P.ACTIVE=1 AND MQ.ACTIVE=1 AND R.ACTIVE=1 AND P.ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, productId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    product.setId(rs.getLong("PRODUCT_ID"));
                    product.setName(rs.getString("PRODUT_NAME"));
                    MedicineQroup medicineQroup = new MedicineQroup();
                    medicineQroup.setId(rs.getLong("MEDICINE_GROUP_ID"));
                    medicineQroup.setQroupName(rs.getString("QROUP_NAME"));
                    Refler ref = new Refler();
                    ref.setId(rs.getLong("REF_ID"));
                    ref.setName(rs.getString("REF_NAME"));
                    product.setBarkod(rs.getInt("BARKOD"));
                    product.setMedicineQroup(medicineQroup);
                    product.setRefler(ref);
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            Methods.closeConnection(c, ps, rs);
        }
        return product;
    }
    
    @Override
    public boolean updateProduct(Product product, Long productId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PRODUCT SET NAME=?,MQ_ID=?,R_ID=?,BARKOD=?" + "WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, product.getName());
                ps.setLong(2, product.getMedicineQroup().getId());
                ps.setLong(3, product.getRefler().getId());
                ps.setInt(4, product.getBarkod());
                ps.setLong(5, productId);
                ps.execute();
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, null);
        }
        return result;
    }
    
    @Override
    public boolean deleteProduct(Long productId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PRODUCT SET ACTIVE=0" + "WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, productId);
                ps.execute();
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, null);
        }
        return result;
    }
    
    @Override
    public List<Product> searchProduct(String keyword) throws Exception {
        List<Product> productList = new ArrayList<Product>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,P.ID,P.NAME,MQ.QROUP_NAME,R.NAME SHELF,P.BARKOD FROM PRODUCT P "
                + "INNER JOIN MEDICINE_QROUP MQ ON P.MQ_ID=MQ.ID  "
                + "INNER JOIN REFLER R ON P.R_ID= R.ID "
                + "WHERE P.ACTIVE=1 AND MQ.ACTIVE=1 AND R.ACTIVE=1 AND(P.ID LIKE(?) OR UPPER(P.NAME) LIKE UPPER(?)  OR UPPER(MQ.QROUP_NAME) LIKE UPPER(?)   OR UPPER(R.NAME) LIKE UPPER(?) OR P.BARKOD LIKE(?) )";
        
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setR(rs.getLong("r"));
                    product.setId(rs.getLong("ID"));
                    product.setName(rs.getString("NAME"));
                    MedicineQroup mq = new MedicineQroup();
                    mq.setQroupName(rs.getString("QROUP_NAME"));
                    Refler r = new Refler();
                    r.setName(rs.getString("SHELF"));
                    product.setBarkod(rs.getInt("BARKOD"));
                    product.setMedicineQroup(mq);
                    product.setRefler(r);
                    productList.add(product);
                }
                
            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return productList;
    }
    
    @Override
    public boolean checkProduct(Product product,boolean result) throws Exception {
        result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM PRODUCT "
                + " WHERE ACTIVE =1 AND BARKOD=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, product.getBarkod());
                rs = ps.executeQuery();
                if (rs.next()) {
                    result = true;
                }
            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return result;
    }
}
