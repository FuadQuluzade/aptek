package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoIshciler;
import az.orient.aptek.pojo.Ishciler;

public class AptekServiceIshcilerImpl implements AptekServiceIshciler{
 private AptekDaoIshciler aptekDaoIshciler;
 
 
	public AptekServiceIshcilerImpl(AptekDaoIshciler aptekDaoIshciler) {

	this.aptekDaoIshciler = aptekDaoIshciler;
}


	@Override
	public List<Ishciler> getIshcilerList() throws Exception {
		
		return aptekDaoIshciler.getIshcilerList();
	}


	@Override
	public boolean addIshciler(Ishciler ishciler) throws Exception {
		return aptekDaoIshciler.addIshciler(ishciler);
	}


	@Override
	public Ishciler getIshciById(Long ishciId) throws Exception {
		
		return aptekDaoIshciler.getIshciById(ishciId);
	}


	@Override
	public boolean updateIshci(Ishciler ishci, Long ishciId) throws Exception {
		return aptekDaoIshciler.updateIshci(ishci, ishciId);
	}


	@Override
	public boolean deleteIshci(Long ishciId) throws Exception {
		return aptekDaoIshciler.deleteIshci(ishciId);
	}


	@Override
	public List<Ishciler> searchIshcilerData(String keyword) throws Exception {
		return aptekDaoIshciler.searchIshcilerData(keyword);
	}

}
