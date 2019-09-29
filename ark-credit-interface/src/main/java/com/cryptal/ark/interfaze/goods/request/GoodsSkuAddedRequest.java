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
     * 商品编码
     */
    private String goodsNo;

    /**
     * 条形码
     */
    private String barCode;

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
    private String[] imagePath;

    /**
     * 销售属性信息
     */
    private Map<Long,Long> attributeValues = new HashMap<>();

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
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

    public String[] getImagePath() {
        return imagePath;
    }

    public void setImagePath(String[] imagePath) {
        this.imagePath = imagePath;
    }

    public void addAttribute(Long attributeId, long attributeValueId) {
        attributeValues.put(attributeId,attributeValueId);
    }

    public Map<Long, Long> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Map<Long, Long> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
