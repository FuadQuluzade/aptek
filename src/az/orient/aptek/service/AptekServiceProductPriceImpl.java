package az.orient.aptek.service;

import java.util.List;

import az.orient.aptek.dao.AptekDaoProductPrice;
import az.orient.aptek.pojo.ProductPrice;

public class AptekServiceProductPriceImpl implements AptekServiceProductPrice {

    private AptekDaoProductPrice aptekDaoProductPrice;

    public AptekServiceProductPriceImpl(AptekDaoProductPrice aptekDaoProductPrice) {
        this.aptekDaoProductPrice = aptekDaoProductPrice;
    }

    @Override
    public List<ProductPrice> getProductPriceList() throws Exception {
        return aptekDaoProductPrice.getProductPriceList();
    }

    @Override
    public boolean addProductPrice(ProductPrice productPrice) throws Exception {

        return aptekDaoProductPrice.addProductPrice(productPrice);
    }

    @Override
    public ProductPrice getProductPriceById(Long productPriceId) throws Exception {

        return aptekDaoProductPrice.getProductPriceById(productPriceId);
    }

    @Override
    public boolean updateProductPrice(ProductPrice productPrice, Long productPriceId) throws Exception {
        return aptekDaoProductPrice.updateProductPrice(productPrice, productPriceId);
    }

    @Override
    public boolean deleteProductPrice(Long productPriceId) throws Exception {
        return aptekDaoProductPrice.deleteProductPrice(productPriceId);
    }

    @Override
    public List<ProductPrice> searchProductPrice(String keyword) throws Exception {
        return aptekDaoProductPrice.searchProductPrice(keyword);
    }

}
