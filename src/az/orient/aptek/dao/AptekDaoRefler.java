package az.orient.aptek.dao;

import java.util.List;

import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.Refler;

public interface AptekDaoRefler {

    List<Refler> getReflerList() throws Exception;

    boolean addRefler(Refler refler) throws Exception;

    Refler getReflerById(Long reflerId) throws Exception;

    boolean updateRefler(Refler refler, Long reflerId) throws Exception;

    boolean deleteRefler(Long reflerId) throws Exception;

    List<Refler> searchRefler(String keyword) throws Exception;

    boolean checkShelf(Refler refler,boolean result) throws Exception;

}
