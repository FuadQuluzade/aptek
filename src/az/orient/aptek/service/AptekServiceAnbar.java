package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.pojo.*;

public interface AptekServiceAnbar {

    List<Anbar> getAnbarList() throws Exception;

    boolean addAnbar(Anbar anbar) throws Exception;

    Anbar getAnbarById(Long anbarId) throws Exception;

    Anbar getAnbarByP_Id(Long anbarId) throws Exception;

    boolean updateAnbar(Anbar anbar, Long anbarId) throws Exception;

    boolean updateAnbarByP_Id(Anbar anbar, Long productId) throws Exception;

    boolean deleteAnbar(Long anbarId) throws Exception;

//	Anbar getAnbarByName(String name) throws Exception;
    List<Anbar> searchAnbarData(String keyword) throws Exception;

    public List<Anbar> getAnbarListByPId(Long productId) throws Exception;

    boolean deleteAnbarByPId(Long productId) throws Exception;

    public Anbar checkAnbarByProductId(Long id) throws Exception;
}
