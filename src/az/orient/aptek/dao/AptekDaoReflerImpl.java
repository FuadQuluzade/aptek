package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Refler;

public class AptekDaoReflerImpl implements AptekDaoRefler {

    @Override
    public List<Refler> getReflerList() throws Exception {
        List<Refler> reflerList = new ArrayList<Refler>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,NAME,OLCU FROM REFLER \r\n" + "WHERE ACTIVE =1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Refler r = new Refler();
                    r.setR(rs.getLong("r"));
                    r.setId(rs.getLong("ID"));
                    r.setName(rs.getString("NAME"));
                    r.setOlcu(rs.getFloat("OLCU"));
                    reflerList.add(r);

                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return reflerList;
    }

    @Override
    public boolean addRefler(Refler refler) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO REFLER(ID,NAME,OLCU)" + "VALUES(REFLER_SEQ.NEXTVAL,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, refler.getName());
                ps.setFloat(2, refler.getOlcu());
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
    public Refler getReflerById(Long reflerId) throws Exception {
        Refler ref = new Refler();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT NAME,OLCU FROM REFLER" + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, reflerId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    ref.setName(rs.getString("NAME"));
                    ref.setOlcu(rs.getFloat("OLCU"));
                }
            } else {
                System.out.println("connection is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Methods.closeConnection(c, ps, rs);
        }
        return ref;
    }

    @Override
    public boolean updateRefler(Refler refler, Long reflerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE REFLER SET NAME=?,OLCU=?" + " WHERE ACTIVE =1 AND ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, refler.getName());
                ps.setFloat(2, refler.getOlcu());
                ps.setLong(3, reflerId);
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
    public boolean deleteRefler(Long reflerId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE REFLER SET ACTIVE=0" + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, reflerId);
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
    public List<Refler> searchRefler(String keyword) throws Exception {
        List<Refler> reflerList = new ArrayList<Refler>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,NAME,OLCU FROM REFLER  " + "WHERE ACTIVE =1 AND (ID LIKE (?) OR UPPER(NAME) LIKE UPPER(?) OR OLCU LIKE (?)) ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Refler r = new Refler();
                    r.setR(rs.getLong("r"));
                    r.setId(rs.getLong("ID"));
                    r.setName(rs.getString("NAME"));
                    r.setOlcu(rs.getFloat("OLCU"));
                    reflerList.add(r);

                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return reflerList;
    }

    @Override
    public boolean checkShelf(Refler refler,boolean result) throws Exception {
         result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM REFLER "
                + " WHERE ACTIVE=1 AND UPPER(NAME) = UPPER(?) ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, refler.getName());
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
