/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.dao;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Ishciler;
import az.orient.aptek.pojo.Maash;
import az.orient.aptek.pojo.OdenishVasiteleri;
import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.Satish;
import az.orient.aptek.pojo.Xerc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fuad
 */
public class AptekDaoReportImpl implements AptekDaoReport {

    @Override
    public List<Satish> getSatishList() throws Exception {
        List<Satish> satishList = new ArrayList<Satish>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String sql = "SELECT S.ID,P.ID PRODUCT_ID,P.NAME PRODUCT_NAME ,S.MEBLEG ,S.MIQDAR ,S.TOTAL_AMOUNT ,S.DATA_DATE FROM SATISH S\r\n"
//                + "INNER JOIN PRODUCT P ON S.P_ID=P.ID\r\n" + " WHERE S.ACTIVE=1 AND P.ACTIVE=1 AND S.DATA_DATE=TO_CHAR(TO_DATE(sysdate,'dd/MM/yyyy'))";
        String sql = "SELECT P.NAME PRODUCT_NAME,S.MEBLEG,S.MIQDAR,S.TOTAL_AMOUNT from satish s\n"
                + "INNER JOIN PRODUCT P ON P.ID=S.P_ID \n"
                + "WHERE P.ACTIVE=1 AND S.ACTIVE=1 AND TO_DATE(S.DATA_DATE, 'DD-MM-YYYY')=TO_DATE(SYSDATE, 'DD-MM-YYYY') ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);

                rs = ps.executeQuery();
                while (rs.next()) {
                    Satish s = new Satish();

//                    s.setId(rs.getLong("ID"));
                    Product p = new Product();
//                    p.setId(rs.getLong("PRODUCT_ID"));
                    p.setName(rs.getString("PRODUCT_NAME"));
                    s.setProduct(p);
                    s.setMebleq(rs.getDouble("MEBLEG"));
                    s.setMiqdar(rs.getInt("MIQDAR"));
                    s.setTotalAmount(rs.getDouble("TOTAL_AMOUNT"));

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
    public List<Satish> getSatishListByName(String fromdate, String todate) throws Exception {
        List<Satish> satishList = new ArrayList<Satish>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
//         String sql="SELECT PRODUCT_ID,PRODUCT_NAME,MEBLEG FROM  SATISH_HESABAT \n" +
//         "WHERE  DATA_DATE >= TO_DATE('?','YYYY-MM-DD') AND DATA_DATE <= TO_DATE('?','YYYY-MM-DD') ";
        String sql = "SELECT P.ID PRODUCT_ID,P.NAME PRODUCT_NAME,S.MIQDAR,S.MEBLEG,S.TOTAL_AMOUNT,S.DATA_DATE FROM  SATISH  S\n"
                + "INNER JOIN PRODUCT P ON S.P_ID=P.ID\n"
                + "WHERE P.ACTIVE=1 AND S.ACTIVE=1 AND S.DATA_DATE >= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) AND  S.DATA_DATE <= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, fromdate);
                ps.setString(2, todate);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Satish s = new Satish();
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
    public List<Satish> getSatishListByTotalAMount(String fromdate, String todate) throws Exception {
        List<Satish> satishList = new ArrayList<Satish>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT SH.PRODUCT_ID,SH.PRODUCT_NAME,SUM(SH.MIQDAR) Total_miqdar,SUM(SH.MEBLEG) total_mebleg, SUM(SH.TOTAL_AMOUNT) TOTAL_AMOUNT FROM  SATISH_HESABAT SH \n"
                + "WHERE  SH.DATA_DATE >=TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) AND SH.DATA_DATE <= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) \n"
                + "GROUP BY SH.PRODUCT_ID,SH.PRODUCT_NAME ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, fromdate);
                ps.setString(2, todate);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Satish s = new Satish();
                    Product p = new Product();
                    p.setId(rs.getLong("PRODUCT_ID"));
                    p.setName(rs.getString("PRODUCT_NAME"));
                    s.setProduct(p);
                    s.setMebleq(rs.getDouble("total_mebleg"));
                    s.setMiqdar(rs.getInt("Total_miqdar"));
                    s.setTotalAmount(rs.getDouble("TOTAL_AMOUNT"));
//                    s.setDataDate(rs.getDate("DATA_DATE"));

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
    public List<Maash> getMaashListByEmployeeSalary(String fromdate, String todate) throws Exception {
        List<Maash> maashList = new ArrayList<Maash>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MH.EMPLOYEE_ID, MH.EMPLOYEE_NAME, MH.EMPLOYEE_SURNAME,SUM(MH.SALARY) EMPLOYEE_SALARY FROM MAASH_HESABAT MH \n"
                + "WHERE  MH.PAY_DATE >= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) AND MH.PAY_DATE <= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) \n"
                + " GROUP BY MH.EMPLOYEE_ID , MH.EMPLOYEE_NAME,MH.EMPLOYEE_SURNAME";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, fromdate);
                ps.setString(2, todate);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Maash maash = new Maash();
                    Ishciler ishciler = new Ishciler();
                    ishciler.setId(rs.getLong("EMPLOYEE_ID"));
                    ishciler.setName(rs.getString("EMPLOYEE_NAME"));
                    ishciler.setSurname(rs.getString("EMPLOYEE_SURNAME"));
                    maash.setIshciler(ishciler);
                    maash.setSalary(rs.getDouble("EMPLOYEE_SALARY"));
                    maashList.add(maash);
                }
            } else {
                System.out.println("connection error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return maashList;
    }

    @Override
    public List<Xerc> getXercList(String fromdate, String todate) throws Exception {
        List<Xerc> xercList = new ArrayList<Xerc>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT OD.NAME ,X.MEBLEG, X.DATA_DATE FROM XERC X\n"
                + "INNER JOIN ODENISH_VASITELERI OD ON OD.ID=X.OD_ID\n"
                + "WHERE OD.ACTIVE=1 AND X.ACTIVE=1 AND X.DATA_DATE >= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) AND  X.DATA_DATE <= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) AND X.ACTIVE=1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, fromdate);
                ps.setString(2, todate);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Xerc xerc = new Xerc();
                    OdenishVasiteleri od = new OdenishVasiteleri();
                    od.setName(rs.getString("NAME"));
                    xerc.setOdenishVasiteleri(od);
                    xerc.setAmount(rs.getDouble("MEBLEG"));
                    xerc.setDataDate(rs.getDate("DATA_DATE"));
                    xercList.add(xerc);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return xercList;
    }

    @Override
    public List<Xerc> getXercListByName(String fromdate, String todate) throws Exception {
        List<Xerc> xercList = new ArrayList<Xerc>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
//        String sql = "SELECT XH.ODENISH_ID,XH.ODENISH_NAME,SUM(XH.MEBLEG) TOTAL_PAYMENT FROM XERC_HESABAT XH\n"
//                + "WHERE XH.DATA_DATE >= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) AND  XH.DATA_DATE <= TO_CHAR(TO_DATE(?,'MM/dd/yyyy'))\n"
//                + "GROUP BY XH.ODENISH_ID,XH.ODENISH_NAME";
        String sql = "SELECT OD.ID ODENISH_ID,OD.NAME ODENISH_NAME ,SUM(X.MEBLEG) TOTAL_PAYMENT FROM XERC X\n"
                + "INNER JOIN ODENISH_VASITELERI OD ON OD.ID=X.OD_ID\n"
                + "WHERE X.DATA_DATE >= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) AND  X.DATA_DATE <= TO_CHAR(TO_DATE(?,'MM/dd/yyyy')) AND X.ACTIVE=1\n"
                + "GROUP BY  OD.ID ,OD.NAME";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, fromdate);
                ps.setString(2, todate);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Xerc xerc = new Xerc();
                    OdenishVasiteleri od = new OdenishVasiteleri();
                    od.setId(rs.getLong("ODENISH_ID"));
                    od.setName(rs.getString("ODENISH_NAME"));
                    xerc.setOdenishVasiteleri(od);
                    xerc.setAmount(rs.getDouble("TOTAL_PAYMENT"));
//                    xerc.setDataDate(rs.getDate("DATA_DATE"));
                    xercList.add(xerc);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return xercList;
    }

}
