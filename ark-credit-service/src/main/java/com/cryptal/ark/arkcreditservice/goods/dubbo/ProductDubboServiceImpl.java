package com.cryptal.ark.arkcreditservice.goods.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.goods.entity.ProductEntity;
import com.cryptal.ark.arkcreditservice.goods.service.ProductService;
import com.cryptal.ark.interfaze.goods.domain.Product;
import com.cryptal.ark.interfaze.goods.dubbo.goods.ProductDubboService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(group="ark-credit-service")
public class ProductDubboServiceImpl implements ProductDubboService {

    @Autowired
    private ProductService productService;

    @Override
    public PageObject<Product> paged(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(productService.paged(searchFilter));
    }

    @Override
    public Product get(Long id) {
        return OpenConverterUtils.convertObject(productService.get(id));
    }

    @Override
    public Product get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(productService.get(searchFilter));
    }

    @Override
    public void saveOrUpdate(Product goodsSku) {
        productService.insert(ProductEntity.constructFrom(goodsSku));
    }

    @Override
    public void delete(Long id) {
        productService.delete(id);
    }
}
