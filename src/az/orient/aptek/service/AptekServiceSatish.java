package az.orient.aptek.service;

import az.orient.aptek.pojo.Product;
import az.orient.aptek.pojo.ProductPrice;
import java.util.List;

import az.orient.aptek.pojo.Satish;

public interface AptekServiceSatish {

    List<Satish> getSatishList() throws Exception;

    boolean addSatish(Satish satish) throws Exception;

    Satish getSatishById(Long satishId) throws Exception;

    boolean updateSatish(Satish satish, Long satishId) throws Exception;

    boolean deleteSatish(Long satishId) throws Exception;

    public Double getProductPriceById(Long id) throws Exception;

    Integer getAnbarById(Long anbarId) throws Exception;

    public List<Satish> searchSatish(String keyword) throws Exception;

     public Satish getQuantityById(Long satishId) throws Exception;

    public Integer getProductBarkodById(Long id) throws Exception;
    
    public String getProductNameByBarkod(Integer barkod) throws Exception;
    
    public boolean updateSatishForEditBtn(Satish satish, Long satishId) throws Exception;

}
