/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.service;

import az.orient.aptek.dao.LoginDao;
import az.orient.aptek.pojo.Login;

/**
 *
 * @author Fuad
 */
public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
//char []
    @Override
    public Login login(String username,  String password) throws Exception {
        return loginDao.login(username,  password);
    }

}
