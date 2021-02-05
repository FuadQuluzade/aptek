package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoProduct;
import az.orient.aptek.pojo.Product;

public class AptekServiceProductImpl implements AptekServiceProduct {

    private AptekDaoProduct aptekDaoProduct;

    public AptekServiceProductImpl(AptekDaoProduct aptekDaoProduct) {
        this.aptekDaoProduct = aptekDaoProduct;
    }

    @Override
    public List<Product> getProductList() throws Exception {

        return aptekDaoProduct.getProductList();
    }

    @Override
    public boolean addProduct(Product product) throws Exception {

        return aptekDaoProduct.addProduct(product);
    }

    @Override
    public Product getProductById(Long productId) throws Exception {

        return aptekDaoProduct.getProductById(productId);
    }

    @Override
    public boolean updateProduct(Product product, Long productId) throws Exception {

        return aptekDaoProduct.updateProduct(product, productId);
    }

    @Override
    public boolean deleteProduct(Long productId) throws Exception {

        return aptekDaoProduct.deleteProduct(productId);
    }

//    @Override
//    public List<Product> getProductListCombo() throws Exception {
//        return aptekDaoProduct.getProductListCombo();
//    }
    @Override
    public List<Product> searchProduct(String keyword) throws Exception {
        return aptekDaoProduct.searchProduct(keyword);
    }

    @Override
    public boolean checkProduct(Product product,boolean result) throws Exception {
        if(result){
        List<Product> productList=aptekDaoProduct.getProductList();
        Product editedProduct=product;
        productList.remove(product);
            for (Product product1 : productList) {
                if((product1.getId().equals(editedProduct.getId())) && (product1.getBarkod().equals(editedProduct.getBarkod()))){
                continue;
                }
                if((product1.getName().equals(editedProduct.getName())) && (product1.getBarkod().equals(editedProduct.getBarkod()))){
                    result=true;
                }
            }
           result=false;
    }
         return aptekDaoProduct.checkProduct(product,result);
    }
}
