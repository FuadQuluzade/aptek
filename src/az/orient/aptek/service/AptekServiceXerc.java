package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.pojo.Xerc;

public interface AptekServiceXerc {
	List<Xerc> getXercList() throws Exception;
	boolean addXerc(Xerc xerc) throws Exception;

	Xerc getXercById(Long xercId) throws Exception;

	boolean updateXerc(Xerc xerc, Long xercId) throws Exception;

	boolean deleteXerc(Long xercId) throws Exception;
        List<Xerc> searchXerc(String keyword) throws Exception;
}
