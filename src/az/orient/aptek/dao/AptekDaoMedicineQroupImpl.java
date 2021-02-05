package az.orient.aptek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.MedicineQroup;
import az.orient.aptek.pojo.Refler;

public class AptekDaoMedicineQroupImpl implements AptekDaoMedicineQroup {

    @Override
    public List<MedicineQroup> getMedicineQroupList() throws Exception {
        List<MedicineQroup> medicineQroupList = new ArrayList<MedicineQroup>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM R,MQ.ID,MQ.QROUP_NAME ,R.ID SHELFS_ID,R.NAME SHELFS_NAME FROM MEDICINE_QROUP MQ\r\n"
                + "INNER JOIN REFLER R ON MQ.R_ID=R.ID\r\n" + "WHERE MQ.ACTIVE=1 AND R.ACTIVE=1 ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    MedicineQroup medicineQroup = new MedicineQroup();
                    medicineQroup.setR(rs.getLong("r"));
                    medicineQroup.setId(rs.getLong("ID"));
                    medicineQroup.setQroupName(rs.getString("QROUP_NAME"));
                    Refler r = new Refler();
                    r.setId(rs.getLong("SHELFS_ID"));
                    r.setName(rs.getString("SHELFS_NAME"));
                    medicineQroup.setShelfs(r);
                    medicineQroupList.add(medicineQroup);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return medicineQroupList;
    }

    @Override
    public boolean addMedicineQroup(MedicineQroup medicineQroup) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO MEDICINE_QROUP(ID,QROUP_NAME,R_ID) " + "VALUES(MEDICINE_QROUP_SEQ.NEXTVAL,?,?) ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, medicineQroup.getQroupName());
                ps.setLong(2, medicineQroup.getShelfs().getId());
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
    public MedicineQroup getMedicineQroupById(Long medicineQroupId) throws Exception {
        MedicineQroup medicineQroup = new MedicineQroup();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT ROWNUM r, MQ.ID, MQ.QROUP_NAME  QROUP_NAME,R.ID REF_ID,R.NAME REF_NAME FROM MEDICINE_QROUP MQ "
                + " INNER JOIN REFLER R ON MQ.R_ID=R.ID "
                + " WHERE MQ.ACTIVE=1 AND MQ.ID=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, medicineQroupId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    medicineQroup.setR(rs.getLong("r"));
                    medicineQroup.setId(rs.getLong("ID"));
                    medicineQroup.setQroupName(rs.getString("QROUP_NAME"));
                    Refler r = new Refler();
                    r.setId(rs.getLong("REF_ID"));
                    r.setName(rs.getString("REF_NAME"));
                    medicineQroup.setShelfs(r);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            Methods.closeConnection(c, ps, rs);
        }
        return medicineQroup;
    }

    @Override
    public boolean updateMedicineQroup(MedicineQroup medicineQroup, Long medicineQroupId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE MEDICINE_QROUP SET QROUP_NAME=?, R_ID=? " + "WHERE ID=?";

        try {
            c = DbHelper.getConnection();
            if (c != null) {

                ps = c.prepareStatement(sql);
                ps.setString(1, medicineQroup.getQroupName());
                ps.setLong(2, medicineQroup.getShelfs().getId());
                ps.setLong(3, medicineQroupId);
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
    public boolean deleteMedicineQroup(Long medicineQroupId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE MEDICINE_QROUP SET ACTIVE=0 " + "WHERE ID=?";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, medicineQroupId);
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

    public List<MedicineQroup> searchMedicineQroupData(String keyword) throws Exception {
        List<MedicineQroup> medicineQroupList = new ArrayList<MedicineQroup>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,MQ.ID,MQ.QROUP_NAME ,R.NAME  FROM MEDICINE_QROUP MQ "
                + "INNER JOIN REFLER R ON MQ.R_ID=R.ID "
                + "WHERE MQ.ACTIVE=1 AND R.ACTIVE=1 AND(MQ.ID LIKE(?) OR UPPER(MQ.QROUP_NAME) LIKE UPPER(?) OR UPPER(R.NAME) LIKE UPPER(?))";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");

                rs = ps.executeQuery();
                while (rs.next()) {
                    MedicineQroup medicineQroup = new MedicineQroup();
                    medicineQroup.setR(rs.getLong("r"));
                    medicineQroup.setId(rs.getLong("ID"));
                    medicineQroup.setQroupName(rs.getString("QROUP_NAME"));
                    Refler r = new Refler();
//                    r.setId(rs.getLong("ID"));
                    r.setName(rs.getString("NAME"));
                    medicineQroup.setShelfs(r);
                    medicineQroupList.add(medicineQroup);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return medicineQroupList;
    }

    @Override
   public boolean checkMedicineQroup(MedicineQroup medicineQroup,boolean result) throws Exception{
        result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM MEDICINE_QROUP "
                + " WHERE ACTIVE = 1 AND UPPER(QROUP_NAME)= UPPER(?) ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, medicineQroup.getQroupName());
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
