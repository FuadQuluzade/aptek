package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoVezifeler;
import az.orient.aptek.pojo.Vezifeler;

public class AptekServiceVezifelerImpl implements AptekServiceVezifeler {

    private AptekDaoVezifeler aptekDaoVezifeler;

    public AptekServiceVezifelerImpl(AptekDaoVezifeler aptekDaoVezifeler) {
        this.aptekDaoVezifeler = aptekDaoVezifeler;
    }

    @Override
    public List<Vezifeler> getVezifelerList() throws Exception {
        return aptekDaoVezifeler.getVezifelerList();
    }

    @Override
    public boolean addVezifeler(Vezifeler vezifeler) throws Exception {

        return aptekDaoVezifeler.addVezifeler(vezifeler);
    }

    @Override
    public Vezifeler getVezifelerById(Long vezifelerId) throws Exception {

        return aptekDaoVezifeler.getVezifelerById(vezifelerId);
    }

    @Override
    public boolean updateVezifeler(Vezifeler vezifeler, Long vezifelerId) throws Exception {

        return aptekDaoVezifeler.updateVezifeler(vezifeler, vezifelerId);
    }

    @Override
    public boolean deleteVezifeler(Long vezifelerId) throws Exception {

        return aptekDaoVezifeler.deleteVezifeler(vezifelerId);
    }

    @Override
    public List<Vezifeler> searchVezifeler(String keyword) throws Exception {
        return aptekDaoVezifeler.searchVezifeler(keyword);
    }

    @Override
    public boolean checkPositionName(Vezifeler vezifeler) throws Exception {
        return aptekDaoVezifeler.checkPositionName(vezifeler);
    }

    
}
