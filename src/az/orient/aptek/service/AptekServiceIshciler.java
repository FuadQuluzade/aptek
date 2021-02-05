package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.pojo.Ishciler;

public interface AptekServiceIshciler {
	List<Ishciler> getIshcilerList() throws Exception;
	public boolean addIshciler(Ishciler ishciler) throws Exception;
	public Ishciler getIshciById(Long ishciId) throws Exception;
	boolean updateIshci(Ishciler ishci,Long ishciId) throws Exception;
	boolean deleteIshci(Long ishciId) throws Exception;
	List<Ishciler> searchIshcilerData(String keyword) throws Exception;
}
