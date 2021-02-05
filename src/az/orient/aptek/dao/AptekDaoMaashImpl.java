package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Ishciler;
import az.orient.aptek.pojo.Maash;
import az.orient.aptek.pojo.Vezifeler;

public class AptekDaoMaashImpl implements AptekDaoMaash {

    @Override
    public List<Maash> getMaashList() throws Exception {
        List<Maash> maashList = new ArrayList<Maash>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,M.ID,V.ID POSITION_ID,V.VEZIFE POSITION_NAME,I.ID EMPLOYEE_ID,I.NAME EMPLOYEE_NAME, I.SURNAME  EMPLOYEE_SURNAME, M.SALARY,M.DATA_DATE PAY_DATE FROM MAASH M\r\n"
                + "INNER JOIN VEZIFELER V ON M.V_ID=V.ID\r\n" + "INNER JOIN ISHCILER I ON M.I_ID=I.ID\r\n"
                + "WHERE M.ACTIVE=1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Maash m = new Maash();
                    m.setR(rs.getLong("r"));
                    m.setId(rs.getLong("ID"));
                    Vezifeler v = new Vezifeler();
                    v.setId(rs.getLong("POSITION_ID"));
                    v.setName(rs.getString("POSITION_NAME"));
                    Ishciler i = new Ishciler();
                    i.setId(rs.getLong("EMPLOYEE_ID"));
                    i.setName(rs.getString("EMPLOYEE_NAME"));
                    i.setSurname(rs.getString("EMPLOYEE_SURNAME"));
                    m.setVezifeler(v);
                    m.setIshciler(i);
                    m.setSalary(rs.getDouble("Salary"));
                    m.setDataDate(rs.getDate("PAY_DATE"));

                    maashList.add(m);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Methods.closeConnection(c, ps, rs);
        }
        return maashList;
    }

    @Override
    public boolean addMaash(Maash maash) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO MAASH(ID,V_ID,I_ID,SALARY) " + "VALUES(MAASH_SEQ.NEXTVAL,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, maash.getVezifeler().getId());
                ps.setLong(2, maash.getIshciler().getId());
                ps.setDouble(3, maash.getSalary());
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
    public Maash getMaashById(Long maashId) throws Exception {
        Maash maash = new Maash();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT M.ID,V.ID,V.VEZIFE,I.ID,I.NAME ,I.SURNAME, M.SALARY FROM MAASH M "
                + "INNER JOIN VEZIFELER V ON M.V_ID=V.ID "
                + "INNER JOIN ISHCILER I ON M.I_ID=I.ID "
                + "WHERE M.ACTIVE=1  AND M.ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, maashId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Vezifeler vezife = new Vezifeler();
                    Ishciler ishci = new Ishciler();
                    ishci.setId(rs.getLong("ID"));
                    ishci.setName(rs.getString("NAME"));
                    ishci.setSurname(rs.getString("SURNAME"));
                    vezife.setId(rs.getLong("ID"));
                    vezife.setName(rs.getString("VEZIFE"));
                    maash.setId(rs.getLong("ID"));
                    maash.setVezifeler(vezife);
                    maash.setIshciler(ishci);
                    maash.setSalary(rs.getDouble("SALARY"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, rs);
        }
        return maash;
    }

    @Override
    public boolean updateMaash(Maash maash, Long maashId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;

        String sql = "UPDATE MAASH SET SALARY=? \r\n" + "WHERE  ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setDouble(1, maash.getSalary());
                ps.setLong(2, maashId);
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
    public boolean deleteMaash(Long maashId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE MAASH SET ACTIVE =0 " + "WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, maashId);
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

    public List<Maash> searchMaashData(String keyword) throws Exception {
        List<Maash> maashList = new ArrayList<Maash>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,M.ID,V.ID ,V.VEZIFE ,I.ID ,I.NAME , I.SURNAME , M.SALARY,M.DATA_DATE FROM MAASH M "
                + " INNER JOIN VEZIFELER V ON M.V_ID=V.ID "
                + " INNER JOIN ISHCILER I ON M.I_ID=I.ID "
                + "WHERE M.ACTIVE=1 AND V.ACTIVE=1 AND I.ACTIVE=1 AND(M.ID LIKE(?) OR V.ID LIKE(?)  OR UPPER(V.VEZIFE) LIKE UPPER(?) "
                + "OR I.ID LIKE (?) OR UPPER(I.NAME) LIKE UPPER(?) OR UPPER(I.SURNAME) LIKE UPPER(?) OR  M.SALARY LIKE(?)OR TO_CHAR(M.DATA_DATE,'YYYY-MM-DD') LIKE (?))";

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
                ps.setString(7, "%" + keyword + "%");
                ps.setString(8, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Maash m = new Maash();
                    m.setR(rs.getLong("r"));
                    m.setId(rs.getLong("ID"));
                    Vezifeler v = new Vezifeler();
                    v.setId(rs.getLong("ID"));
                    v.setName(rs.getString("VEZIFE"));
                    Ishciler i = new Ishciler();
                    i.setId(rs.getLong("ID"));
                    i.setName(rs.getString("NAME"));
                    i.setSurname(rs.getString("SURNAME"));
                    m.setVezifeler(v);
                    m.setIshciler(i);
                    m.setSalary(rs.getDouble("Salary"));
                    m.setDataDate(new java.sql.Date(rs.getDate("DATA_DATE").getTime()));

                    maashList.add(m);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            Methods.closeConnection(c, ps, rs);
        }
        return maashList;
    }
}
