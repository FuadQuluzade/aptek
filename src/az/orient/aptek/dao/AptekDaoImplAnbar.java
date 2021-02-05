package az.orient.aptek.dao;

import java.sql.*;
import java.util.*;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.*;

public class AptekDaoImplAnbar implements AptekDaoAnbar {
//view

    @Override
    public List<Anbar> getAnbarList() throws Exception {
        List<Anbar> anbarList = new ArrayList<Anbar>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = " SELECT A.P_ID,P.NAME , SUM(A.MIQDARI) SUM_AMOUNT,P.BARKOD  FROM ANBAR A "
                + " INNER JOIN PRODUCT P ON A.P_ID=P.ID "
                + " WHERE A.ACTIVE= 1 AND P.ACTIVE=1  "
                + " GROUP BY  A.P_ID,P.NAME, P.BARKOD ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Anbar anbar = new Anbar();
//                    anbar.setId(rs.getLong("ID"));

                    Product p = new Product();
                    p.setId(rs.getLong("P_ID"));
                    p.setName(rs.getString("NAME"));
                    p.setBarkod(rs.getInt("BARKOD"));
                    anbar.setProduct(p);
                    anbar.setAmount(rs.getInt("SUM_AMOUNT"));
                    anbarList.add(anbar);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            c.rollback();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, rs);
        }
        return anbarList;
    }

//add
    @Override
    public boolean addAnbar(Anbar anbar) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DbHelper.getConnection();
            String sql = "INSERT INTO ANBAR(ID,P_ID,MIQDARI,ALISH_QIYMETI,QEYD) " + "VALUES(ANBAR_SEQ.NEXTVAL,?,?,?,?)";
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, anbar.getProduct().getId());
                ps.setInt(2, anbar.getAmount());
                ps.setDouble(3, anbar.getPurchasePrise());
                ps.setString(4, anbar.getQeyd());
                ps.execute();
                result = true;
            } else {
                System.out.println("connetion is null");
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
    public Anbar getAnbarById(Long anbarId) throws Exception {
        Anbar anbar = new Anbar();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT A.ID,P.ID PPRODUCT_ID ,P.NAME PRODUCT_NAME, A.MIQDARI ,A.ALISH_QIYMETI,A.QEYD FROM ANBAR A"
                + " INNER JOIN PRODUCT P ON A.P_ID=P.ID "
                + "WHERE A.ACTIVE= 1 AND A.ID=? ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, anbarId);
                rs = ps.executeQuery();
                if (rs.next()) {

                    anbar.setId(rs.getLong("ID"));
                    Product p = new Product();
                    p.setId(rs.getLong("PPRODUCT_ID"));
                    p.setName(rs.getString("PRODUCT_NAME"));
                    anbar.setProduct(p);
                    anbar.setAmount(rs.getInt("MIQDARI"));
                    anbar.setPurchasePrise(rs.getDouble("ALISH_QIYMETI"));
                    anbar.setQeyd(rs.getString("QEYD"));

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
        return anbar;
    }

    @Override
    public Anbar getAnbarByP_Id(Long anbarId) throws Exception {
        Anbar anbar = new Anbar();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
//A.ID,
        String sql = "SELECT P.NAME, A.MIQDARI ,A.ALISH_QIYMETI,A.QEYD FROM ANBAR A "
                + " INNER JOIN PRODUCT P ON A.P_ID=P.ID "
                + " WHERE A.ACTIVE= 1 AND A.P_ID=? ";

        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, anbarId);
                rs = ps.executeQuery();
                if (rs.next()) {

//                    anbar.setId(rs.getLong("ID"));
                    Product p = new Product();
//                    p.setId(rs.getLong("PPRODUCT_ID"));
                    p.setName(rs.getString("NAME"));
                    anbar.setProduct(p);
                    anbar.setAmount(rs.getInt("MIQDARI"));
                    anbar.setPurchasePrise(rs.getDouble("ALISH_QIYMETI"));
                    anbar.setQeyd(rs.getString("QEYD"));

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
        return anbar;
    }

    @Override
    public boolean updateAnbar(Anbar anbar, Long anbarId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
//        P_ID=? ,
        String sql = "UPDATE ANBAR SET  MIQDARI=? " + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
//                ps.setLong(1, anbar.getProduct().getId());
                ps.setInt(1, anbar.getAmount());
                ps.setLong(2, anbarId);
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
    public boolean updateAnbarByP_Id(Anbar anbar, Long productId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = " UPDATE ANBAR SET MIQDARI=? WHERE P_ID=? ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, anbar.getAmount());
                ps.setLong(2, productId);
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
    public boolean deleteAnbar(Long anbarId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE ANBAR SET ACTIVE=0 " + " WHERE ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, anbarId);
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
    public List<Anbar> searchAnbarData(String keyword) throws Exception {
        List<Anbar> anbarList = new ArrayList<Anbar>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT P.NAME, SUM(A.MIQDARI) MIQDARI, P.BARKOD FROM ANBAR A  \n"
                + "INNER JOIN PRODUCT P ON A.P_ID=P.ID \n"
                + "WHERE A.ACTIVE=1  AND (UPPER(P.NAME) LIKE UPPER(?) OR A.MIQDARI LIKE(?) OR P.BARKOD LIKE(?))\n"
                + "GROUP BY P.NAME, P.BARKOD";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Anbar anbar = new Anbar();
//                    anbar.setId(rs.getLong("ID"));
                    Product p = new Product();
                    p.setName(rs.getString("NAME"));
                    p.setBarkod(rs.getInt("BARKOD"));
                    anbar.setProduct(p);
                    anbar.setAmount(rs.getInt("MIQDARI"));
                    anbarList.add(anbar);
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
        return anbarList;
    }

//	@Override
//	public Anbar getAnbarByName(String name) throws Exception {
//		Anbar anbar= new Anbar();
//		Connection c= null;
//		PreparedStatement ps= null;
//		ResultSet rs=null;
//		String sql="SELECT A.ID,P.NAME,A.MIQDARI FROM ANBAR A " + 
//				"INNER JOIN PRODUCT P ON A.P_ID=P.ID " + 
//				 "WHERE A.ACTIVE=1 AND NAME  = ?";
//		try {
//			c=DbHelper.getConnection();
//			if(c!=null) {
//			ps=c.prepareStatement(sql);
//			ps.setString(1,name);
//			rs=ps.executeQuery();
//			if(rs.next()) {
//				anbar.setId(rs.getLong("ID"));
//				anbar.setName(rs.getString("NAME"));
//				anbar.setMiqdari(rs.getInt("MIQDARI"));
//			}
//			}
//		} catch ( Exception e) {
//			// TODO: handle exception
//		}finally {
//			Methods.getConnection(c, ps, rs);
//		
//		}
//		return anbar;
//	}
    @Override
    public List<Anbar> getAnbarListByPId(Long productId) throws Exception {
        List<Anbar> anbarList = new ArrayList<Anbar>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select A.ID,P.name,A.MIQDARI,A.DATA_DATE from anbar A \n"
                + "INNER JOIN PRODUCT P ON A.P_ID=P.ID"
                + " where A.p_id = ? and A.active = 1";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, productId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product p = new Product();
                    p.setId(productId);
                    p.setName(rs.getString("name"));
                    Anbar anbar = new Anbar();
                    anbar.setId(rs.getLong("ID"));
                    anbar.setProduct(p);
                    anbar.setAmount(rs.getInt("MIQDARI"));
                    anbar.setDataDate(rs.getDate("DATA_DATE"));
                    anbarList.add(anbar);
                }

            } else {
                System.out.println("connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            c.rollback();
        } finally {
            c.commit();
            Methods.closeConnection(c, ps, rs);
        }
        return anbarList;
    }

    @Override
    public boolean deleteAnbarByPId(Long productId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE ANBAR SET ACTIVE=0 " + "WHERE P_ID=?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, productId);
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
//
    @Override
    public Anbar checkAnbarByProductId(Long id) throws Exception {
        Anbar anbar = new Anbar();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT P_ID,SUM(MIQDARI) AMOUNT,ACTIVE FROM ANBAR WHERE P_ID = ? AND ACTIVE = 1 \n"
                + "GROUP BY P_ID,ACTIVE";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                rs= ps.executeQuery();
                while (rs.next()) {
                    Product p = new Product();
                    p.setId(rs.getLong("P_ID"));
                    anbar.setProduct(p);
                    anbar.setAmount(rs.getInt("AMOUNT"));
                    anbar.setActive(rs.getInt("ACTIVE"));
                    
                }

            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
            Methods.closeConnection(c, ps, rs);
        }

        return anbar;
    }

}
