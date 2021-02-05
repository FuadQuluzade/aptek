package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Ishciler;

public class AptekDaoIshcilerImpl implements AptekDaoIshciler {

    @Override
    public List<Ishciler> getIshcilerList() throws Exception {
        List<Ishciler> ishcilerList = new ArrayList<Ishciler>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,NAME,SURNAME,DOB,ADRESS,PHONE,TEHSIL,DIL_BILIYI FROM ISHCILER\r\n" + "WHERE ACTIVE =1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Ishciler isciler = new Ishciler();
                    isciler.setR(rs.getLong("r"));
                    isciler.setId(rs.getLong("ID"));
                    isciler.setName(rs.getString("NAME"));
                    isciler.setSurname(rs.getString("SURNAME"));
                    isciler.setDob(rs.getDate("DOB"));
                    isciler.setAdress(rs.getString("ADRESS"));
                    isciler.setPhone(rs.getString("PHONE"));
                    isciler.setTehsil(rs.getString("TEHSIL"));
                    isciler.setDilBiliyi(rs.getString("DIL_BILIYI"));
                    ishcilerList.add(isciler);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, rs);
        }
        return ishcilerList;
    }

    @Override
    public boolean addIshciler(Ishciler ishciler) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO ISHCILER(ID,NAME,SURNAME,DOB,ADRESS,PHONE,TEHSIL,DIL_BILIYI) "
                + "VALUES(ISHCILER_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, ishciler.getName());
            ps.setString(2, ishciler.getSurname());
            ps.setDate(3, new java.sql.Date(ishciler.getDob().getTime()));
            ps.setString(4, ishciler.getAdress());
            ps.setString(5, ishciler.getPhone());
            ps.setString(6, ishciler.getTehsil());
            ps.setString(7, ishciler.getDilBiliyi());
            ps.execute();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			c.commit();
            Methods.closeConnection(c, ps, null);
        }

        return result;
    }

    @Override
    public Ishciler getIshciById(Long ishciId) throws Exception {
        Ishciler ishciler = new Ishciler();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,NAME,SURNAME,DOB,ADRESS,PHONE,TEHSIL,DIL_BILIYI FROM ISHCILER "
                + " WHERE ACTIVE=1 AND ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, ishciId);
                rs = ps.executeQuery();
            }
            if (rs.next()) {
                ishciler.setId(rs.getLong("ID"));
                ishciler.setName(rs.getString("NAME"));
                ishciler.setSurname(rs.getString("SURNAME"));
                ishciler.setDob(rs.getDate("DOB"));
                ishciler.setAdress(rs.getString("ADRESS"));
                ishciler.setPhone(rs.getString("PHONE"));
                ishciler.setTehsil(rs.getString("TEHSIL"));
                ishciler.setDilBiliyi(rs.getString("DIL_BILIYI"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, rs);
        }
        return ishciler;
    }

    @Override
    public boolean updateIshci(Ishciler ishci, Long ishciId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE ISHCILER SET NAME=?,SURNAME=?,DOB=?,ADRESS=?,PHONE=?,TEHSIL=?,DIL_BILIYI=? " + "WHERE ACTIVE=1 AND ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, ishci.getName());
                ps.setString(2, ishci.getSurname());
                ps.setDate(3, new java.sql.Date(ishci.getDob().getTime()));
                ps.setString(4, ishci.getAdress());
                ps.setString(5, ishci.getPhone());
                ps.setString(6, ishci.getTehsil());
                ps.setString(7, ishci.getDilBiliyi());
                ps.setLong(8, ishciId);
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
    public boolean deleteIshci(Long ishciId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE ISHCILER SET ACTIVE=0" + "WHERE ACTIVE=1 AND ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);

                ps.setLong(1, ishciId);
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
    public List<Ishciler> searchIshcilerData(String keyword) throws Exception {
        List<Ishciler> ishcilerList = new ArrayList<Ishciler>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,NAME,SURNAME,DOB,ADRESS,PHONE,TEHSIL,DIL_BILIYI FROM ISHCILER "
                + "WHERE ACTIVE=1 AND (ID LIKE(?) OR UPPER(NAME) LIKE UPPER(?) OR UPPER(SURNAME) LIKE  UPPER(?) OR UPPER(DOB) LIKE  UPPER(?) OR UPPER(ADRESS) LIKE  UPPER(?) OR UPPER(PHONE) LIKE  UPPER(?) OR UPPER(TEHSIL) LIKE  UPPER(?)OR UPPER(DIL_BILIYI) LIKE  UPPER(?))";

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
                    Ishciler isciler = new Ishciler();
                    isciler.setR(rs.getLong("r"));
                    isciler.setId(rs.getLong("ID"));
                    isciler.setName(rs.getString("NAME"));
                    isciler.setSurname(rs.getString("SURNAME"));
                    isciler.setDob(rs.getDate("DOB"));
                    isciler.setAdress(rs.getString("ADRESS"));
                    isciler.setPhone(rs.getString("PHONE"));
                    isciler.setTehsil(rs.getString("TEHSIL"));
                    isciler.setDilBiliyi(rs.getString("DIL_BILIYI"));
                    ishcilerList.add(isciler);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            Methods.closeConnection(c, ps, rs);
        }
        return ishcilerList;
    }
}
