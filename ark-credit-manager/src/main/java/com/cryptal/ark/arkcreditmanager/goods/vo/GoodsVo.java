package com.cryptal.ark.arkcreditmanager.goods.vo;

import java.io.Serializable;

public class GoodsVo implements Serializable {

    private String id;

    private String goodsNo;

    private String barCode;

    private Long productId;

    /**
     * 价格
     */
    private String price;

    /**
     * 库存数
     */
    private Long stock;


    private String[] mainImagePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String[] getMainImagePath() {
        return mainImagePath;
    }

    public void setMainImagePath(String[] mainImagePath) {
        this.mainImagePath = mainImagePath;
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
}
