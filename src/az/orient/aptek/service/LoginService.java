/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.service;

import az.orient.aptek.pojo.Login;

/**
 *
 * @author Fuad
 */
public interface LoginService {
//    char []
     Login login(String username, String password) throws Exception;
}
