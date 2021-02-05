package az.orient.aptek.service;

import java.util.List;


import az.orient.aptek.pojo.ProductPrice;

public interface AptekServiceProductPrice {
	public List<ProductPrice> getProductPriceList() throws Exception;
	boolean addProductPrice(ProductPrice productPrice) throws Exception;

	ProductPrice getProductPriceById(Long productPriceId) throws Exception;

	boolean updateProductPrice(ProductPrice productPrice, Long productPriceId) throws Exception;

	boolean deleteProductPrice(Long productPriceId) throws Exception;
        List<ProductPrice> searchProductPrice(String keyword) throws Exception;
}
