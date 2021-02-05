package az.orient.aptek.dao;

import java.util.List;

import az.orient.aptek.pojo.Vezifeler;

public interface AptekDaoVezifeler {

    List<Vezifeler> getVezifelerList() throws Exception;

    boolean addVezifeler(Vezifeler vezifeler) throws Exception;

    Vezifeler getVezifelerById(Long vezifelerId) throws Exception;

    boolean updateVezifeler(Vezifeler vezifeler, Long vezifelerId) throws Exception;

    boolean deleteVezifeler(Long vezifelerId) throws Exception;

    List<Vezifeler> searchVezifeler(String keyword) throws Exception;
    
    boolean checkPositionName(Vezifeler vezifeler) throws Exception ;
    
    

}
