package com.cryptal.ark.arkcreditmanager.goods.controller;

import cn.com.gome.page.excp.GmosException;
import com.cryptal.ark.interfaze.goods.domain.Product;
import com.cryptal.ark.interfaze.goods.domain.SellAttribute;
import com.cryptal.ark.interfaze.goods.domain.SellAttributeValue;
import com.cryptal.ark.interfaze.goods.dubbo.goods.GoodsSkuDubboService;
import com.cryptal.ark.interfaze.goods.dubbo.goods.ProductDubboService;
import com.cryptal.ark.interfaze.goods.dubbo.goods.SellAttributeDubboService;
import com.cryptal.ark.interfaze.goods.dubbo.goods.SellAttributeValueDubboService;
import com.cryptal.ark.interfaze.goods.request.GoodsSkuAddedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {


    private ProductDubboService productDubboService;

    private SellAttributeDubboService sellAttributeDubboService;

    private SellAttributeValueDubboService sellAttributeValueDubboService;

    private GoodsSkuDubboService goodsSkuDubboService;

    /**
     * 产品下创建SKU Form页面
     */
    @GetMapping("/createSku")
    public void createSkuGet(Model mode, Long productId){

        Product product = productDubboService.get(productId);
        if(product == null){
            throw new GmosException("产品ID不存在");
        }

        Map<SellAttribute, List<SellAttributeValue>> sellAttributeMap = new HashMap<>();
        List<SellAttribute> sellAttributes = sellAttributeDubboService.findByCategoryId(product.getCategoryId());
        for (SellAttribute sellAttribute : sellAttributes) {
            List<SellAttributeValue> sellAttributeValues = sellAttributeValueDubboService.findByAttributeId(sellAttribute.getId());
            sellAttributeMap.put(sellAttribute,sellAttributeValues);
        }

        mode.addAttribute("sellAttributeMap",sellAttributeMap);

    }


    @PostMapping("/createSku")
    public void createSkuPost(HttpServletRequest httpRequest , GoodsSkuAddedRequest goodsSkuAddedRequest){

        Product product = productDubboService.get(goodsSkuAddedRequest.getProductId());
        if(product==null){
            throw new GmosException("产品ID不存在");
        }

        List<SellAttribute> sellAttributes = sellAttributeDubboService.findByCategoryId(product.getCategoryId());
        for (SellAttribute sellAttribute : sellAttributes) {

            httpRequest.getParameter("sell_attribute_" + sellAttribute.getName() );

        }

        goodsSkuDubboService.createSku(goodsSkuAddedRequest);


    }

}
