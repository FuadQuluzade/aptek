package az.orient.aptek.dao;

import java.util.List;

import az.orient.aptek.pojo.Product;

public interface AptekDaoProduct {

    List<Product> getProductList() throws Exception;

    boolean addProduct(Product product) throws Exception;

    Product getProductById(Long productId) throws Exception;

    boolean updateProduct(Product product, Long productId) throws Exception;

    boolean deleteProduct(Long productId) throws Exception;

    List<Product> searchProduct(String keyword) throws Exception;
    
   boolean checkProduct(Product product,boolean result) throws Exception;

}
