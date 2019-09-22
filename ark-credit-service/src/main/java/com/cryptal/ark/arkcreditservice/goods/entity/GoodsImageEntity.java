package com.cryptal.ark.arkcreditservice.goods.entity;

import cn.com.gome.cloud.openplatform.open.OpenConvertible;
import com.cryptal.ark.interfaze.goods.domain.GoodsImage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GoodsImageEntity implements OpenConvertible<GoodsImage> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long skuId;

    private String imagePath;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public GoodsImage converter() {
        GoodsImage goodsImage = new GoodsImage();
        goodsImage.setId(id);
        goodsImage.setSkuId(skuId);
        goodsImage.setImagePath(imagePath);
        return goodsImage;
    }

    public static GoodsImageEntity constructFrom(GoodsImage goodsImage) {
        GoodsImageEntity goodsImageEntity = new GoodsImageEntity();
        goodsImageEntity.setId(goodsImage.getId());
        goodsImageEntity.setSkuId(goodsImage.getSkuId());
        goodsImageEntity.setImagePath(goodsImage.getImagePath());
        return goodsImageEntity;
    }
}
