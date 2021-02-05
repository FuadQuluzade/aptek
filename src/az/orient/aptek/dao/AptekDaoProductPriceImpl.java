package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.ProductPrice;

public class AptekDaoProductPriceImpl implements AptekDaoProductPrice {

    @Override
    public List<ProductPrice> getProductPriceList() throws Exception {
        List<ProductPrice> productPriceList = new ArrayList<ProductPrice>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, PR.ID,P.ID PRODUCT_ID,P.NAME PRODUCT_NAME,PR.QIYMET,PR.VALYUTA FROM PRODUCT_PRICE PR\r\n"
                + "INNER JOIN PRODUCT P ON PR.P_ID=P.ID\r\n" + "WHERE PR.ACTIVE=1 AND P.ACTIVE=1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ProductPrice pr = new ProductPrice();
                    pr.setR(rs.getLong("r"));
                    pr.setId(rs.getLong("ID"));
                    Product p = new Product();
                    p.setId(rs.getLong("PRODUCT_ID"));
                    p.setName(rs.getString("PRODUCT_NAME"));
                    pr.setProduct(p);
                    pr.setPrice(rs.getDouble("QIYMET"));
                    pr.setCurrency(rs.getString("VALYUTA"));

                    productPriceList.add(pr);

                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return productPriceList;
    }

    @Override
    public boolean addProductPrice(ProductPrice productPrice) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO PRODUCT_PRICE(ID,P_ID,QIYMET,VALYUTA) "
                + " VALUES(PRODUCT_PRICE_SEQ.NEXTVAL,?,?,?)";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, productPrice.getProduct().getId());
                ps.setDouble(2, productPrice.getPrice());
                ps.setString(3, productPrice.getCurrency());

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
    public ProductPrice getProductPriceById(Long productPriceId) throws Exception {
        ProductPrice pr = new ProductPrice();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT PP.ID PRICE_ID,P.ID PRODCUT_ID,P.NAME,PP.QIYMET,PP.VALYUTA  FROM PRODUCT_PRICE PP "
                + "INNER JOIN PRODUCT P ON PP.P_ID=P.ID "
                + " WHERE PP.ACTIVE=1 AND P.ACTIVE=1 AND PP.ID=? ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, productPriceId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    pr.setId(rs.getLong("PRICE_ID"));
                    Product product = new Product();
                    product.setId(rs.getLong("PRODCUT_ID"));
                    product.setName(rs.getString("NAME"));
                    pr.setPrice(rs.getDouble("QIYMET"));
                    pr.setCurrency(rs.getString("VALYUTA"));
                    pr.setProduct(product);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Methods.closeConnection(c, ps, rs);
        }
        return pr;

    }

    @Override
    public boolean updateProductPrice(ProductPrice productPrice, Long productPriceId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
//        P_ID=?,
        String sql = "UPDATE PRODUCT_PRICE SET QIYMET=?,VALYUTA=? " + "WHERE ID=?";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
//                ps.setLong(1, productPrice.getProduct().getId());
                ps.setDouble(1, productPrice.getPrice());
                ps.setString(2, productPrice.getCurrency());

                ps.setLong(3, productPriceId);
                ps.execute();
                result = true;
            } else {
                System.out.println("connection is null");
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
    public boolean deleteProductPrice(Long productPriceId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PRODUCT_PRICE SET ACTIVE=0" + "WHERE ID=?";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, productPriceId);
                ps.execute();
                result = true;
            } else {
                System.out.println("connection is null");
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
    public List<ProductPrice> searchProductPrice(String keyword) throws Exception {
        List<ProductPrice> productPriceList = new ArrayList<ProductPrice>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,PR.ID,P.NAME ,PR.QIYMET,PR.VALYUTA FROM PRODUCT_PRICE PR\r\n"
                + "INNER JOIN PRODUCT P ON PR.P_ID=P.ID\r\n"
                + "WHERE PR.ACTIVE=1 AND P.ACTIVE=1 AND(PR.ID LIKE(?) OR UPPER(P.NAME) LIKE UPPER(?) OR PR.QIYMET LIKE(?) OR PR.VALYUTA LIKE(?)) ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    ProductPrice pr = new ProductPrice();
                    pr.setR(rs.getLong("r"));
                    pr.setId(rs.getLong("ID"));
                    Product p = new Product();
                    p.setName(rs.getString("NAME"));
                    pr.setProduct(p);
                    pr.setPrice(rs.getDouble("QIYMET"));
                    pr.setCurrency(rs.getString("VALYUTA"));
                    productPriceList.add(pr);

                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return productPriceList;
    }
}
