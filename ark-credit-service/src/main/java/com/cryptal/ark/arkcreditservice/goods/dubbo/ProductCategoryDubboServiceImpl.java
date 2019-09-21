package com.cryptal.ark.arkcreditservice.goods.dubbo;

import cn.com.gome.cloud.openplatform.common.PageObject;
import cn.com.gome.cloud.openplatform.common.SearchFilter;
import cn.com.gome.cloud.openplatform.open.OpenConverterUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.cryptal.ark.arkcreditservice.goods.entity.ProductCategoryEntity;
import com.cryptal.ark.arkcreditservice.goods.service.ProductCategoryService;
import com.cryptal.ark.interfaze.goods.domain.ProductCategory;
import com.cryptal.ark.interfaze.goods.dubbo.goods.ProductCategoryDubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(group="ark-credit-service")
public class ProductCategoryDubboServiceImpl implements ProductCategoryDubboService {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public PageObject<ProductCategory> paged(SearchFilter searchFilter) {
        return OpenConverterUtils.convertPageObject(productCategoryService.paged(searchFilter));
    }

    @Override
    public ProductCategory get(Long id) {
        return OpenConverterUtils.convertObject(productCategoryService.get(id));
    }

    @Override
    public ProductCategory get(SearchFilter searchFilter) {
        return OpenConverterUtils.convertObject(productCategoryService.get(searchFilter));
    }

    @Override
    public List<ProductCategory> findAllEnable() {
        return OpenConverterUtils.convertList(productCategoryService.findAllEnable());
    }

    @Override
    public void saveOrUpdate(ProductCategory productCategory) {
        productCategoryService.insert(ProductCategoryEntity.constructFrom(productCategory));
    }

    @Override
    public void delete(Long id) {
        productCategoryService.delete(id);
    }
}
