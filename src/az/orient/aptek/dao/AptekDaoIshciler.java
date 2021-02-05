package az.orient.aptek.dao;

import java.util.List;

import az.orient.aptek.pojo.Ishciler;

public interface AptekDaoIshciler {
	List<Ishciler> getIshcilerList() throws Exception;
	
	boolean addIshciler(Ishciler ishciler) throws Exception;
	
	Ishciler getIshciById(Long ishciId) throws Exception;
	
	boolean updateIshci(Ishciler ishci,Long ishciId) throws Exception;
	
	boolean deleteIshci(Long ishciId) throws Exception;
	
	List<Ishciler> searchIshcilerData(String keyword) throws Exception;
}
