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

    /**
     * 主图1
     */
    private String mainImagePath1;

    /**
     * 主图2
     */
    private String mainImagePath2;

    /**
     * 主图3
     */
    private String mainImagePath3;

    /**
     * 主图4
     */
    private String mainImagePath4;

    /**
     * 主图5
     */
    private String mainImagePath5;

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

    public String getMainImagePath1() {
        return mainImagePath1;
    }

    public void setMainImagePath1(String mainImagePath1) {
        this.mainImagePath1 = mainImagePath1;
    }

    public String getMainImagePath2() {
        return mainImagePath2;
    }

    public void setMainImagePath2(String mainImagePath2) {
        this.mainImagePath2 = mainImagePath2;
    }

    public String getMainImagePath3() {
        return mainImagePath3;
    }

    public void setMainImagePath3(String mainImagePath3) {
        this.mainImagePath3 = mainImagePath3;
    }

    public String getMainImagePath4() {
        return mainImagePath4;
    }

    public void setMainImagePath4(String mainImagePath4) {
        this.mainImagePath4 = mainImagePath4;
    }

    public String getMainImagePath5() {
        return mainImagePath5;
    }

    public void setMainImagePath5(String mainImagePath5) {
        this.mainImagePath5 = mainImagePath5;
    }
}
