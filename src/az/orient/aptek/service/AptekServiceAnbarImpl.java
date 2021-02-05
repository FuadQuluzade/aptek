package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.*;
import az.orient.aptek.pojo.Anbar;

public class AptekServiceAnbarImpl implements AptekServiceAnbar {

    private AptekDaoAnbar aptekDao;

    public AptekServiceAnbarImpl(AptekDaoAnbar aptekDa0) {
        this.aptekDao = aptekDa0;
    }

    @Override
    public List<Anbar> getAnbarList() throws Exception {
        return aptekDao.getAnbarList();
    }

    @Override
    public boolean addAnbar(Anbar anbar) throws Exception {
        return aptekDao.addAnbar(anbar);
    }

    @Override
    public Anbar getAnbarById(Long anbarId) throws Exception {
        return aptekDao.getAnbarById(anbarId);
    }

    @Override
    public boolean updateAnbar(Anbar anbar, Long anbarId) throws Exception {
        return aptekDao.updateAnbar(anbar, anbarId);
    }

    @Override
    public boolean deleteAnbar(Long anbarId) throws Exception {
        // TODO Auto-generated method stub
        return aptekDao.deleteAnbar(anbarId);
    }

    @Override
    public List<Anbar> searchAnbarData(String keyword) throws Exception {

        return aptekDao.searchAnbarData(keyword);
    }

//	@Override
//	public Anbar getAnbarByName(String name) throws Exception {
//		// TODO Auto-generated method stub
//		return aptekDao.getAnbarByName(name);
//	}
    @Override
    public Anbar getAnbarByP_Id(Long anbarId) throws Exception {
        return aptekDao.getAnbarByP_Id(anbarId);
    }

    public boolean updateAnbarByP_Id(Anbar anbar, Long productId) throws Exception {
        return aptekDao.updateAnbarByP_Id(anbar, productId);
    }

    @Override
    public List<Anbar> getAnbarListByPId(Long productId) throws Exception {
        return aptekDao.getAnbarListByPId(productId);
    }

    @Override
    public boolean deleteAnbarByPId(Long productId) throws Exception {
        return aptekDao.deleteAnbarByPId(productId);
    }

    @Override
    public Anbar checkAnbarByProductId(Long id) throws Exception {
       return aptekDao.checkAnbarByProductId(id);
    }

}
