package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoXerc;
import az.orient.aptek.pojo.Xerc;

public class AptekServiceXercImpl implements AptekServiceXerc {

    private AptekDaoXerc aptekDaoXerc;

    public AptekServiceXercImpl(AptekDaoXerc aptekDaoXerc) {
        this.aptekDaoXerc = aptekDaoXerc;
    }

    @Override
    public List<Xerc> getXercList() throws Exception {
        return aptekDaoXerc.getXercList();
    }

    @Override
    public boolean addXerc(Xerc xerc) throws Exception {
        return aptekDaoXerc.addXerc(xerc);
    }

    @Override
    public Xerc getXercById(Long xercId) throws Exception {
        return aptekDaoXerc.getXercById(xercId);
    }

    @Override
    public boolean updateXerc(Xerc xerc, Long xercId) throws Exception {

        return aptekDaoXerc.updateXerc(xerc, xercId);
    }

    @Override
    public boolean deleteXerc(Long xercId) throws Exception {

        return aptekDaoXerc.deleteXerc(xercId);
    }

    @Override
    public List<Xerc> searchXerc(String keyword) throws Exception {
        return aptekDaoXerc.searchXerc(keyword);
    }

}
