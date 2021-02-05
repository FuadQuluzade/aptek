package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoOdenishVasiteleri;
import az.orient.aptek.pojo.OdenishVasiteleri;
import java.util.ArrayList;

public class AptekServiceOdenishVasiteleriImpl implements AptekServiceOdenishVasiteleri{
 private AptekDaoOdenishVasiteleri  aptekDaoOdenishVasiteleri;
 
	public AptekServiceOdenishVasiteleriImpl(AptekDaoOdenishVasiteleri aptekDaoOdenishVasiteleri) {
	this.aptekDaoOdenishVasiteleri = aptekDaoOdenishVasiteleri;
}

	@Override
	public List<OdenishVasiteleri> getOdenishVasiteleriList() throws Exception {
	
		return aptekDaoOdenishVasiteleri.getOdenishVasiteleriList();
	}

	@Override
	public boolean addOdenishVasiteleri(OdenishVasiteleri odenishVasiteleri) throws Exception {
		
		return aptekDaoOdenishVasiteleri.addOdenishVasiteleri(odenishVasiteleri);
	}

	@Override
	public OdenishVasiteleri getOdenishVasiteleriById(Long odenishVasiteleriId) throws Exception {
		return aptekDaoOdenishVasiteleri.getOdenishVasiteleriById(odenishVasiteleriId);
	}

	@Override
	public boolean updateOdenishVasiteleri(OdenishVasiteleri odenishVasiteleri, Long odenishVasiteleriId)
			throws Exception {
	return aptekDaoOdenishVasiteleri.updateOdenishVasiteleri(odenishVasiteleri, odenishVasiteleriId);
	}

	@Override
	public boolean deleteOdenishVasiteleri(Long odenishVasiteleriId) throws Exception {
		return aptekDaoOdenishVasiteleri.deleteOdenishVasiteleri(odenishVasiteleriId);
	}

    @Override
    public List<OdenishVasiteleri> searchOdenishVasiteleri(String keyword) throws Exception {
       return aptekDaoOdenishVasiteleri.searchOdenishVasiteleri(keyword);
    }

    @Override
    public boolean checkElement(OdenishVasiteleri odenishVasiteleri,boolean select) throws Exception {
        if (select) {
            List<OdenishVasiteleri> ODList = new ArrayList<>();
            ODList = aptekDaoOdenishVasiteleri.getOdenishVasiteleriList();
            OdenishVasiteleri editedOD = odenishVasiteleri;
            ODList.remove(odenishVasiteleri);
            for (OdenishVasiteleri odenishVasiteleri1 : ODList) {
                if (odenishVasiteleri1.getId().equals(editedOD.getId())) {
                    continue;
                }
                if ((odenishVasiteleri1.getId().equals(editedOD.getName()))) {
                    return false;
                }
            }
            return true;
        } else {
            return aptekDaoOdenishVasiteleri.checkElement(odenishVasiteleri, select);
        }
    }

}
