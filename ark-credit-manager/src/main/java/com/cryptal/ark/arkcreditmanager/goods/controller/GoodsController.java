package com.cryptal.ark.arkcreditmanager.goods.controller;

import cn.com.gome.page.excp.GmosException;
import com.alibaba.dubbo.config.annotation.Reference;
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
@RequestMapping("/admin/goods_sku")
public class GoodsController {

    @Reference(group = "ark-credit-service")
    private ProductDubboService productDubboService;

    @Reference(group = "ark-credit-service")
    private SellAttributeDubboService sellAttributeDubboService;

    @Reference(group = "ark-credit-service")
    private SellAttributeValueDubboService sellAttributeValueDubboService;

    @Reference(group = "ark-credit-service")
    private GoodsSkuDubboService goodsSkuDubboService;

    /**
     * 产品下创建SKU Form页面
     */
    @GetMapping("/createSku")
    public String createSkuGet(Model model, Long productId){

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

        model.addAttribute("sellAttributeMap",sellAttributeMap);
        model.addAttribute("productId",productId);
        model.addAttribute("product",product);

        return "goods/createSku";
    }


    @PostMapping("/createSku")
    public void createSkuPost(HttpServletRequest httpRequest , GoodsSkuAddedRequest goodsSkuAddedRequest){

        Product product = productDubboService.get(goodsSkuAddedRequest.getProductId());
        if(product==null){
            throw new GmosException("产品ID不存在");
        }

        List<SellAttribute> sellAttributes = sellAttributeDubboService.findByCategoryId(product.getCategoryId());
        for (SellAttribute sellAttribute : sellAttributes) {
            String parameter = httpRequest.getParameter("sell_attribute_" + sellAttribute.getId());
            goodsSkuAddedRequest.addAttribute(sellAttribute.getId(),Long.parseLong(parameter));
        }

        goodsSkuDubboService.createSku(goodsSkuAddedRequest);

    }

}
