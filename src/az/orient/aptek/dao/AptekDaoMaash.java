package az.orient.aptek.dao;

import java.util.List;

import az.orient.aptek.pojo.Maash;

public interface AptekDaoMaash {
	List<Maash> getMaashList() throws Exception;
	
	boolean addMaash(Maash maash) throws Exception;
	
	Maash getMaashById(Long maashId) throws Exception;
	
	boolean updateMaash(Maash maash,Long maashId) throws Exception;
	boolean deleteMaash(Long maashId)throws Exception;
        List<Maash> searchMaashData(String keyword) throws Exception;
}
