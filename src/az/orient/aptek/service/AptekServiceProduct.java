package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.pojo.Product;

public interface AptekServiceProduct {

    List<Product> getProductList() throws Exception;

    boolean addProduct(Product product) throws Exception;

    Product getProductById(Long productId) throws Exception;

    boolean updateProduct(Product product, Long productId) throws Exception;

    boolean deleteProduct(Long productId) throws Exception;
//            public List<Product> getProductListCombo() throws Exception;

    List<Product> searchProduct(String keyword) throws Exception;

    public boolean checkProduct(Product product,boolean result) throws Exception;

}
