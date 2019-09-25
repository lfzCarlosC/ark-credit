package com.cryptal.ark.arkcreditservice.goods.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.goods.domain.GoodsSku;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class GoodsSkuEntity implements OpenConvertible<GoodsSku> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品名称
     */
    private Long productId;

    private String goodsNo;

    private String barCode;

    /**
     * Sku名称
     */
    private String skuName;

    /**
     * 所需积分
     */
    private String price;

    /**
     * 库存数
     */
    private Long stock;

    /**
     * 是否在售
     */
    private boolean onSale;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date modifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    @Override
    public GoodsSku converter() {
        GoodsSku goodsSku = new GoodsSku();
        goodsSku.setId(id);
        goodsSku.setProductId(productId);
        goodsSku.setGoodsNo(goodsNo);
        goodsSku.setBarCode(barCode);
        goodsSku.setSkuName(skuName);
        goodsSku.setPrice(price);
        goodsSku.setStock(stock);
        goodsSku.setOnSale(onSale);
        goodsSku.setCreatedTime(createdTime);
        goodsSku.setModifyTime(modifyTime);
        return goodsSku;
    }


    public static GoodsSkuEntity constructFrom(GoodsSku goodsSku) {
        GoodsSkuEntity goodsSkuEntity = new GoodsSkuEntity();
        goodsSkuEntity.setId(goodsSku.getId());
        goodsSkuEntity.setGoodsNo(goodsSku.getGoodsNo());
        goodsSkuEntity.setBarCode(goodsSku.getBarCode());
        goodsSkuEntity.setProductId(goodsSku.getProductId());
        goodsSkuEntity.setSkuName(goodsSku.getSkuName());
        goodsSkuEntity.setStock(goodsSku.getStock());
        goodsSkuEntity.setOnSale(goodsSku.isOnSale());
        goodsSkuEntity.setPrice(goodsSku.getPrice());
        goodsSkuEntity.setCreatedTime(goodsSku.getCreatedTime());
        goodsSkuEntity.setModifyTime(goodsSku.getModifyTime());
        return goodsSkuEntity;
    }

}
