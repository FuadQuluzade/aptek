package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoMaash;
import az.orient.aptek.pojo.Maash;

public class AptekServiceMaashImpl implements AptekServiceMaash{
    private AptekDaoMaash aptekDaoMaash;  
	
	

	public AptekServiceMaashImpl(AptekDaoMaash aptekDaoMaash) {
	
		this.aptekDaoMaash = aptekDaoMaash;
	}



	@Override
	public List<Maash> getMaashList() throws Exception {
		
		return aptekDaoMaash.getMaashList();
	}



	@Override
	public boolean addMaash(Maash maash) throws Exception {
		
		return aptekDaoMaash.addMaash(maash);
	}



	@Override
	public Maash getMaashById(Long maashId) throws Exception {
		return aptekDaoMaash.getMaashById(maashId);
	}



	@Override
	public boolean updateMaash(Maash maash, Long maashId) throws Exception {
		return aptekDaoMaash.updateMaash(maash, maashId);
	}



	@Override
	public boolean deleteMaash(Long maashId) throws Exception {
		
		return aptekDaoMaash.deleteMaash(maashId);
	}

    @Override
    public List<Maash> searchMaashData(String keyword) throws Exception {
        return aptekDaoMaash.searchMaashData(keyword);
    }

  
}
