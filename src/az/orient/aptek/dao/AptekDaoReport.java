/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.dao;

import az.orient.aptek.pojo.Maash;
import az.orient.aptek.pojo.Satish;
import az.orient.aptek.pojo.Xerc;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fuad
 */
public interface AptekDaoReport {

    public List<Satish> getSatishList() throws Exception;

    public List<Satish> getSatishListByName(String fromdate, String todate) throws Exception;

    public List<Satish> getSatishListByTotalAMount(String fromdate, String todate) throws Exception;

    public List<Maash> getMaashListByEmployeeSalary(String fromdate, String todate) throws Exception;
    
     public List<Xerc> getXercList(String fromdate, String todate) throws Exception;
      public List<Xerc> getXercListByName(String fromdate, String todate) throws Exception;
    
}
