package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.OdenishVasiteleri;

public class AptekDaoOdenishVasiteleriImpl implements AptekDaoOdenishVasiteleri {

    @Override
    public List<OdenishVasiteleri> getOdenishVasiteleriList() throws Exception {
        List<OdenishVasiteleri> OdenishVasiteleriList = new ArrayList<OdenishVasiteleri>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID, NAME FROM ODENISH_VASITELERI\r\n" + "WHERE ACTIVE=1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    OdenishVasiteleri od = new OdenishVasiteleri();
                    od.setR(rs.getLong("r"));
                    od.setId(rs.getLong("ID"));
                    od.setName(rs.getString("NAME"));
                    OdenishVasiteleriList.add(od);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return OdenishVasiteleriList;
    }

    @Override
    public boolean addOdenishVasiteleri(OdenishVasiteleri odenishVasiteleri) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO ODENISH_VASITELERI (ID,NAME) " + " VALUES(ODENISH_VASITELERI_SEQ.NEXTVAL,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, odenishVasiteleri.getName());
                result = true;
                ps.execute();
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
    public OdenishVasiteleri getOdenishVasiteleriById(Long odenishVasiteleriId) throws Exception {
        OdenishVasiteleri odenishVasiteleri = new OdenishVasiteleri();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT NAME FROM ODENISH_VASITELERI " + " WHERE ACTIVE= 1 AND ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, odenishVasiteleriId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    odenishVasiteleri.setName(rs.getString("NAME"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Methods.closeConnection(c, ps, rs);
        }
        return odenishVasiteleri;
    }

    @Override
    public boolean updateOdenishVasiteleri(OdenishVasiteleri odenishVasiteleri, Long odenishVasiteleriId)
            throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE  ODENISH_VASITELERI SET NAME=?" + "WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, odenishVasiteleri.getName());
                ps.setLong(2, odenishVasiteleriId);
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
    public boolean deleteOdenishVasiteleri(Long odenishVasiteleriId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE ODENISH_VASITELERI SET ACTIVE=0" + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, odenishVasiteleriId);
                ps.execute();
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, rs);
        }
        return result;
    }

    public List<OdenishVasiteleri> searchOdenishVasiteleri(String keyword) throws Exception {
        List<OdenishVasiteleri> OdenishVasiteleriList = new ArrayList<OdenishVasiteleri>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID, NAME FROM ODENISH_VASITELERI " + "WHERE ACTIVE=1 AND (ID LIKE (?) OR UPPER(NAME) LIKE UPPER(?))";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    OdenishVasiteleri od = new OdenishVasiteleri();
                    od.setR(rs.getLong("r"));
                    od.setId(rs.getLong("ID"));
                    od.setName(rs.getString("NAME"));
                    OdenishVasiteleriList.add(od);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return OdenishVasiteleriList;
    }

    @Override
    public boolean checkElement(OdenishVasiteleri odenishVasiteleri,boolean result) throws Exception {
         result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ODENISH_VASITELERI "
                + " WHERE ACTIVE=1 AND UPPER(NAME) = UPPER(?) ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, odenishVasiteleri.getName());
                rs = ps.executeQuery();

                if (rs.next()) {
                    result = true;
                }

            } else {
                System.out.println("connection null");
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
