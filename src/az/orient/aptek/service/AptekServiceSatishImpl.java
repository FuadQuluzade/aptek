package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoSatish;

import az.orient.aptek.pojo.Satish;

public class AptekServiceSatishImpl implements AptekServiceSatish {

    private AptekDaoSatish aptekDaoSatish;

    public AptekServiceSatishImpl(AptekDaoSatish aptekDaoSatish) {
        this.aptekDaoSatish = aptekDaoSatish;
    }

    @Override
    public List<Satish> getSatishList() throws Exception {
        return aptekDaoSatish.getSatishList();
    }

    @Override
    public boolean addSatish(Satish satish) throws Exception {
        return aptekDaoSatish.addSatish(satish);
    }

    @Override
    public Satish getSatishById(Long satishId) throws Exception {
        return aptekDaoSatish.getSatishById(satishId);
    }

    @Override
    public boolean updateSatish(Satish satish, Long satishId) throws Exception {
        return aptekDaoSatish.updateSatish(satish, satishId);
    }

    @Override
    public boolean deleteSatish(Long satishId) throws Exception {
        return aptekDaoSatish.deleteSatish(satishId);
    }

    @Override
    public Double getProductPriceById(Long id) throws Exception {
        return aptekDaoSatish.getProductPriceById(id);
    }

    @Override
    public Integer getAnbarById(Long anbarId) throws Exception {
        return aptekDaoSatish.getAnbarById(anbarId);
    }

    @Override
    public List<Satish> searchSatish(String keyword) throws Exception {
        return aptekDaoSatish.searchSatish(keyword);
    }

    @Override
    public Satish getQuantityById(Long satishId) throws Exception {
        return aptekDaoSatish.getQuantityById(satishId);
    }

    @Override
    public Integer getProductBarkodById(Long id) throws Exception {
        return aptekDaoSatish.getProductBarkodById(id);
    }

    public String getProductNameByBarkod(Integer barkod) throws Exception {
        return aptekDaoSatish.getProductNameByBarkod(barkod);
    }

    @Override
    public boolean updateSatishForEditBtn(Satish satish, Long satishId) throws Exception {
        return aptekDaoSatish.updateSatishForEditBtn(satish, satishId);
    }
}
