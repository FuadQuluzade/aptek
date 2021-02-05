package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.pojo.OdenishVasiteleri;

public interface AptekServiceOdenishVasiteleri {

    List<OdenishVasiteleri> getOdenishVasiteleriList() throws Exception;

    boolean addOdenishVasiteleri(OdenishVasiteleri odenishVasiteleri) throws Exception;

    OdenishVasiteleri getOdenishVasiteleriById(Long odenishVasiteleriId) throws Exception;

    boolean updateOdenishVasiteleri(OdenishVasiteleri odenishVasiteleri, Long odenishVasiteleriId) throws Exception;

    boolean deleteOdenishVasiteleri(Long odenishVasiteleriId) throws Exception;

    List<OdenishVasiteleri> searchOdenishVasiteleri(String keyword) throws Exception;

    boolean checkElement(OdenishVasiteleri odenishVasiteleri,boolean select) throws Exception;

}
