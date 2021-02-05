package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Vezifeler;

/**
 *
 * @author Fuad
 */
public class AptekDaoVezifelerImpl implements AptekDaoVezifeler {

    @Override
    public List<Vezifeler> getVezifelerList() throws Exception {
        List<Vezifeler> vezifelerList = new ArrayList<Vezifeler>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID, VEZIFE,DATA_DATE FROM VEZIFELER\r\n" + " WHERE ACTIVE=1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Vezifeler v = new Vezifeler();
                    v.setR(rs.getLong("r"));
                    v.setId(rs.getLong("ID"));
                    v.setName(rs.getString("VEZIFE"));
                    v.setDataDate(rs.getDate("DATA_DATE"));
                    vezifelerList.add(v);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return vezifelerList;
    }

    @Override
    public boolean addVezifeler(Vezifeler vezifeler) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO VEZIFELER(ID,VEZIFE) " + " VALUES(VEZIFELER_SEQ.NEXTVAL,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, vezifeler.getName());
                ps.execute();
                result = true;
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

    @Override
    public Vezifeler getVezifelerById(Long vezifelerId) throws Exception {
        Vezifeler vezifeler = new Vezifeler();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT VEZIFE FROM VEZIFELER " + "  WHERE ACTIVE=1 AND ID=?";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, vezifelerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    vezifeler.setName(rs.getString("VEZIFE"));

                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return vezifeler;
    }

    @Override
    public boolean updateVezifeler(Vezifeler vezifeler, Long vezifelerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE VEZIFELER SET VEZIFE=? " + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, vezifeler.getName());
                ps.setLong(2, vezifelerId);
                ps.execute();
                result = true;
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

    @Override
    public boolean deleteVezifeler(Long vezifelerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE VEZIFELER SET ACTIVE=0 " + " WHERE ACTIVE=1 AND ID=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, vezifelerId);
                ps.execute();
                result = true;
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

    @Override
    public List<Vezifeler> searchVezifeler(String keyword) throws Exception {
        List<Vezifeler> vezifelerList = new ArrayList<Vezifeler>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r, ID, VEZIFE,DATA_DATE FROM VEZIFELER "
                + "WHERE ACTIVE=1 AND (ID LIKE (?) OR UPPER(VEZIFE) LIKE UPPER(?) OR DATA_DATE LIKE (?)) ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Vezifeler v = new Vezifeler();
                    v.setR(rs.getLong("r"));
                    v.setId(rs.getLong("ID"));
                    v.setName(rs.getString("VEZIFE"));
                    v.setDataDate(rs.getDate("DATA_DATE"));
                    vezifelerList.add(v);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return vezifelerList;
    }

    @Override
    public boolean checkPositionName(Vezifeler vezifeler) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM VEZIFELER "
                + " WHERE ACTIVE=1 AND UPPER(VEZIFE) = UPPER(?) ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, vezifeler.getName());
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
