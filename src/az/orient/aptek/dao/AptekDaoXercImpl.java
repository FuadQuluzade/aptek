package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.OdenishVasiteleri;
import az.orient.aptek.pojo.Xerc;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class AptekDaoXercImpl implements AptekDaoXerc {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = formatter.format(date);

    @Override
    public List<Xerc> getXercList() throws Exception {
        List<Xerc> xercList = new ArrayList<Xerc>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT ROWNUM r,X.ID,OD.ID ODENISH_ID,OD.NAME, X.MEBLEG,X.DATA_DATE FROM XERC X \r\n"
                + " INNER JOIN ODENISH_VASITELERI OD ON X.OD_ID=OD.ID \r\n" + " WHERE X.ACTIVE=1 AND OD.ACTIVE=1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Xerc x = new Xerc();
                    x.setR(rs.getLong("r"));
                    OdenishVasiteleri od = new OdenishVasiteleri();
                    od.setId(rs.getLong("ODENISH_ID"));
                    od.setName(rs.getString("Name"));
                    x.setId(rs.getLong("ID"));
                    x.setAmount(rs.getDouble("MEBLEG"));
                    x.setDataDate(rs.getDate("DATA_DATE"));
                    x.setOdenishVasiteleri(od);
                    xercList.add(x);
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
    public boolean addXerc(Xerc xerc) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = " INSERT INTO XERC(ID,OD_ID,MEBLEG) " + " VALUES(XERC_SEQ.NEXTVAL,?,?) ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, xerc.getOdenishVasiteleri().getId());
                ps.setDouble(2, xerc.getAmount());
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
    public Xerc getXercById(Long xercId) throws Exception {
        Xerc xerc = new Xerc();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT X.ID XERC_ID,OD.ID ODENISH_ID, OD.NAME, X.MEBLEG FROM XERC X\r\n"
                + "INNER JOIN ODENISH_VASITELERI OD ON X.OD_ID=OD.ID\r\n" + "WHERE X.ACTIVE=1 AND X.ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, xercId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    xerc.setId(rs.getLong("XERC_ID"));
                    OdenishVasiteleri od = new OdenishVasiteleri();
                    od.setId(rs.getLong("ODENISH_ID"));
                    od.setName(rs.getString("NAME"));
                    xerc.setAmount(rs.getDouble("MEBLEG"));
                    xerc.setOdenishVasiteleri(od);
                }
            } else {
                System.out.println("connection is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return xerc;
    }

    @Override
    public boolean updateXerc(Xerc xerc, Long xercId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE XERC SET OD_ID=?,MEBLEG=?" + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, xerc.getOdenishVasiteleri().getId());
                ps.setDouble(2, xerc.getAmount());
                ps.setLong(3, xercId);
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
    public boolean deleteXerc(Long xercId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE XERC SET ACTIVE=0 " + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, xercId);
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
    public List<Xerc> searchXerc(String keyword) throws Exception {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        DateTimeFormatter f= DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        List<Xerc> xercList = new ArrayList<Xerc>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        String strDate = formatter.format(date);
        String sql = "SELECT  ROWNUM r,X.ID,OD.NAME, X.MEBLEG,X.DATA_DATE FROM XERC X "
                + " INNER JOIN ODENISH_VASITELERI OD ON X.OD_ID=OD.ID  "
                + "  WHERE X.ACTIVE=1 AND OD.ACTIVE=1 AND ( X.ID LIKE (?) OR UPPER(OD.NAME) LIKE UPPER(?) OR X.MEBLEG LIKE (?) OR TO_CHAR(X.DATA_DATE,'YYYY-MM-DD') LIKE (?))";

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
                    Xerc x = new Xerc();
                    x.setR(rs.getLong("r"));
                    x.setId(rs.getLong("ID"));

                    OdenishVasiteleri od = new OdenishVasiteleri();
                    od.setName(rs.getString("Name"));
                    x.setAmount(rs.getDouble("MEBLEG"));
                    x.setDataDate(new java.sql.Date(rs.getDate("DATA_DATE").getTime()));
                    x.setOdenishVasiteleri(od);
                    xercList.add(x);

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
