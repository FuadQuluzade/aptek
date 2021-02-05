package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.ProductPrice;
import az.orient.aptek.pojo.Satish;

public class AptekDaoSatishImpl implements AptekDaoSatish {

    @Override
    public List<Satish> getSatishList() throws Exception {
        List<Satish> satishList = new ArrayList<Satish>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,S.ID,P.ID PRODUCT_ID,P.NAME PRODUCT_NAME ,S.MEBLEG ,S.MIQDAR ,S.TOTAL_AMOUNT ,S.DATA_DATE FROM SATISH S\r\n"
                + "INNER JOIN PRODUCT P ON S.P_ID=P.ID\r\n" + "WHERE S.ACTIVE=1 AND P.ACTIVE=1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Satish s = new Satish();
                    s.setR(rs.getLong("r"));
                    s.setId(rs.getLong("ID"));
                    Product p = new Product();
                    p.setId(rs.getLong("PRODUCT_ID"));
                    p.setName(rs.getString("PRODUCT_NAME"));
                    s.setProduct(p);
                    s.setMebleq(rs.getDouble("MEBLEG"));
                    s.setMiqdar(rs.getInt("MIQDAR"));
                    s.setTotalAmount(rs.getDouble("TOTAL_AMOUNT"));
                    s.setDataDate(rs.getDate("DATA_DATE"));
                    satishList.add(s);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return satishList;
    }

    @Override
    public boolean addSatish(Satish satish) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO SATISH(ID,P_ID, MEBLEG, MIQDAR,TOTAL_AMOUNT) " + " VALUES(SATISH_SEQ.NEXTVAL,?,?,?,?) ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, satish.getProduct().getId());
                ps.setDouble(2, satish.getMebleq());
                ps.setDouble(3, satish.getMiqdar());
                ps.setDouble(4, satish.getTotalAmount());
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
    public Satish getSatishById(Long satishId) throws Exception {
        Satish s = new Satish();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT S.ID SATISH_ID,P.ID PRODUCT_ID, P.NAME,S.MEBLEG,S.MIQDAR,S.TOTAL_AMOUNT FROM SATISH S "
                + " INNER JOIN PRODUCT P ON S.P_ID=P.ID "
                + " WHERE S.ACTIVE=1 AND S.ID=? ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, satishId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    s.setId(rs.getLong("SATISH_ID"));
                    Product p = new Product();
                    p.setId(rs.getLong("PRODUCT_ID"));
                    p.setName(rs.getString("NAME"));
                    s.setProduct(p);
                    s.setMebleq(rs.getDouble("MEBLEG"));
                    s.setMiqdar(rs.getInt("MIQDAR"));
                    s.setTotalAmount(rs.getDouble("TOTAL_AMOUNT"));

                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return s;
    }

    @Override
    public boolean updateSatish(Satish satish, Long satishId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE SATISH SET P_ID=?,MEBLEG=?,MIQDAR=?,TOTAL_AMOUNT=? " + " WHERE ID=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, satish.getProduct().getId());
                ps.setDouble(2, satish.getMebleq());
                ps.setDouble(3, satish.getMiqdar());
                ps.setDouble(4, satish.getTotalAmount());
                ps.setLong(5, satishId);
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
    public boolean deleteSatish(Long satishId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE SATISH SET ACTIVE=0" + "WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, satishId);
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
    public Double getProductPriceById(Long id) throws Exception {
        ProductPrice pr = new ProductPrice();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT P.NAME,PP.QIYMET,PP.VALYUTA FROM PRODUCT_PRICE PP "
                + "INNER JOIN PRODUCT P ON PP.P_ID=P.ID "
                + " WHERE PP.ACTIVE=1 AND P.ID=? ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    pr.setPrice(rs.getDouble("QIYMET"));
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Methods.closeConnection(c, ps, rs);
        }
        return pr.getPrice();
    }

    @Override
    public Integer getAnbarById(Long anbarId) throws Exception {
        Anbar anbar = new Anbar();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String sql=" SELECT P.ID ,SUM(A.MIQDARI) SUM_AMOUNT, A.BARKOD  FROM ANBAR A "
//                + " INNER JOIN PRODUCT P ON A.P_ID=P.ID "
//                + " WHERE A.ACTIVE= 1 AND P.ACTIVE=1 AND P.ID=? "
//                + " GROUP BY P.ID,A.BARKOD ";
        String sql = "SELECT MP.ID,NVL(T.SUM,0) SUM FROM PRODUCT MP "
                + "LEFT JOIN ( "
                + " SELECT PRO.ID ID,SUM(AN.MIQDARI) SUM FROM PRODUCT  PRO\n"
                + " LEFT JOIN ANBAR AN ON PRO.ID=AN.P_ID "
                + " WHERE  AN.ACTIVE= 1 AND PRO.ACTIVE=1 "
                + " GROUP BY PRO.ID )"
                + " T ON T.ID=MP.ID "
                + " WHERE  MP.ID=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, anbarId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    anbar.setAmount(rs.getInt("sum"));
                }
            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return anbar.getAmount();
    }

    @Override
    public List<Satish> searchSatish(String keyword) throws Exception {
        List<Satish> satishList = new ArrayList<Satish>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,S.ID,P.NAME  ,S.MEBLEG ,S.MIQDAR ,S.TOTAL_AMOUNT ,S.DATA_DATE FROM SATISH S "
                + "INNER JOIN PRODUCT P ON S.P_ID=P.ID "
                + "WHERE S.ACTIVE=1 AND P.ACTIVE=1 AND(S.ID LIKE (?) OR UPPER(P.NAME)  LIKE UPPER(?) OR S.MEBLEG LIKE (?) OR S.MIQDAR LIKE(?) OR S.TOTAL_AMOUNT LIKE(?) OR TO_CHAR(S.DATA_DATE,'YYYY-MM-DD') LIKE (?)) ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Satish s = new Satish();
                    s.setR(rs.getLong("r"));
                    s.setId(rs.getLong("ID"));
                    Product p = new Product();
                    p.setName(rs.getString("NAME"));
                    s.setProduct(p);
                    s.setMebleq(rs.getDouble("MEBLEG"));
                    s.setMiqdar(rs.getInt("MIQDAR"));
                    s.setTotalAmount(rs.getDouble("TOTAL_AMOUNT"));
                    s.setDataDate(new java.sql.Date(rs.getDate("DATA_DATE").getTime()));
                    satishList.add(s);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return satishList;
    }

    @Override
    public Satish getQuantityById(Long satishId) throws Exception {
        Satish s = new Satish();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID , MIQDAR FROM SATISH  "
                + " WHERE ACTIVE=1 AND ID=? ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, satishId);
                rs = ps.executeQuery();
                while (rs.next()) {

                    s.setId(rs.getLong("ID"));
                    s.setMiqdar(rs.getInt("MIQDAR"));
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return s;
    }

    @Override
    public Integer getProductBarkodById(Long id) throws Exception {
        Product pr = new Product();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,BARKOD FROM PRODUCT P "
                + " WHERE ACTIVE=1 AND ID=? ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    pr.setBarkod(rs.getInt("BARKOD"));
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Methods.closeConnection(c, ps, rs);
        }
        return pr.getBarkod();
    }

    @Override
    public String getProductNameByBarkod(Integer barkod) throws Exception {
        Product pr = new Product();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,NAME FROM PRODUCT "
                + " WHERE ACTIVE=1 AND BARKOD=? ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, barkod);
                rs = ps.executeQuery();
                if (rs.next()) {
                    pr.setName(rs.getString("NAME"));
                } else {
                    pr.setName("NO_CONTENT");

                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Methods.closeConnection(c, ps, rs);
        }
        return pr.getName();
    }

    @Override
    public boolean updateSatishForEditBtn(Satish satish, Long satishId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE SATISH SET MIQDAR=? " + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);

                ps.setDouble(1, satish.getMiqdar());

                ps.setLong(2, satishId);
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

}
