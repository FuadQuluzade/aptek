/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.aptek.service;

import az.orient.aptek.dao.AptekDaoReport;
import az.orient.aptek.pojo.Maash;
import az.orient.aptek.pojo.Satish;
import az.orient.aptek.pojo.Xerc;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fuad
 */
public class AptekServiceReportImpl implements AptekServiceReport {

    private AptekDaoReport aptekDaoReport;

    public AptekServiceReportImpl(AptekDaoReport aptekDaoReport) {
        this.aptekDaoReport = aptekDaoReport;
    }

    @Override
    public List<Satish> getSatishList() throws Exception {
        return aptekDaoReport.getSatishList();
    }

    @Override
    public List<Satish> getSatishListByName(String fromdate, String todate) throws Exception {
        return aptekDaoReport.getSatishListByName(fromdate, todate);
    }

    @Override
    public List<Satish> getSatishListByTotalAMount(String fromdate, String todate) throws Exception {
        return aptekDaoReport.getSatishListByTotalAMount(fromdate, todate);
    }

    @Override
    public List<Maash> getMaashListByEmployeeSalary(String fromdate, String todate) throws Exception {
        return aptekDaoReport.getMaashListByEmployeeSalary(fromdate, todate);
    }

    @Override
    public List<Xerc> getXercList(String fromdate, String todate) throws Exception {
        return aptekDaoReport.getXercList(fromdate, todate);
    }

    @Override
    public List<Xerc> getXercListByName(String fromdate, String todate) throws Exception {
        return aptekDaoReport.getXercListByName(fromdate, todate);
    }

}
