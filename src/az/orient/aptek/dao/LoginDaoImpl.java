/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.dao;

import az.orient.aptek.metods.Methods;
import az.orient.aptek.pojo.Login;
import az.orient.aptek.pojo.Role;
import az.orient.aptek.pojo.Vezifeler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Fuad
 */
public class LoginDaoImpl implements LoginDao {
// char []

    @Override
    public Login login(String username, String password) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT L.ID,L.USERNAME,L.NAME,L.SURNAME,R.ID ROLE_ID,R.ROLE_NAME FROM LOGIN L \n"
                + " INNER JOIN ROLE R ON L.ROLE_ID=R.ID\n"
                + " WHERE L.ACTIVE=1 AND (UPPER(L.USERNAME) = UPPER(?) AND L.PASSWORD=? )";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setId(rs.getLong("ID"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));
                    login.setUsername(rs.getString("USERNAME"));
                    Role role = new Role();
                    role.setId(rs.getLong("ROLE_ID"));
                    role.setRoleName(rs.getString("ROLE_NAME"));
                    login.setRole(role);
                } else {
                    login = null;
                }
            } else {
                System.out.println("Connection is null !");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            Methods.closeConnection(c, ps, rs);
        }
        return login;
    }

}
