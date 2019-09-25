package com.cryptal.ark.interfaze.goods.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsSkuAddedRequest implements Serializable {

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 库存数
     */
    private Long stock;

    /**
     * 价格
     */
    private String price;

    /**
     * 主图信息
     */
    private List<String> mainImagePaths;

    /**
     * 销售属性
     */
    private Map<Long,Long> sellAttributeMap = new HashMap<>();

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getMainImagePaths() {
        return mainImagePaths;
    }

    public void setMainImagePaths(List<String> mainImagePaths) {
        this.mainImagePaths = mainImagePaths;
    }

    public void addAttribute(Long attributeId, Long valueId) {
        sellAttributeMap.put(attributeId,valueId);
    }
}
