package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoRefler;
import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.MedicineQroup;
import az.orient.aptek.pojo.Refler;
import java.util.ArrayList;

public class AptekServiceReflerImpl implements AptekServiceRefler {

    private AptekDaoRefler aptekDaoRefler;

    public AptekServiceReflerImpl(AptekDaoRefler aptekDaoRefler) {
        this.aptekDaoRefler = aptekDaoRefler;
    }

    @Override
    public List<Refler> getReflerList() throws Exception {
        return aptekDaoRefler.getReflerList();
    }

    @Override
    public boolean addRefler(Refler refler) throws Exception {
        return aptekDaoRefler.addRefler(refler);
    }

    @Override
    public Refler getReflerById(Long reflerId) throws Exception {
        return aptekDaoRefler.getReflerById(reflerId);
    }

    @Override
    public boolean updateRefler(Refler refler, Long reflerId) throws Exception {
        return aptekDaoRefler.updateRefler(refler, reflerId);
    }

    @Override
    public boolean deleteRefler(Long reflerId) throws Exception {
        return aptekDaoRefler.deleteRefler(reflerId);
    }

    @Override
    public List<Refler> searchRefler(String keyword) throws Exception {
        return aptekDaoRefler.searchRefler(keyword);
    }

    @Override
    public boolean checkShelf(Refler refler,boolean result) throws Exception {
         if (result) {
            List<Refler> reflerList = new ArrayList<>();
            reflerList = aptekDaoRefler.getReflerList();
            Refler editedref = refler;
            reflerList.remove(refler);

            for (Refler ref : reflerList) {
                if (ref.getId().equals(editedref.getId())) {
                    continue;
                }
                if ((ref.getName().equals(editedref.getName()))) {
                    return true;
                }
            }
            return false;
        } else {
            return aptekDaoRefler.checkShelf(refler, result);
        }}

}
