package com.cryptal.ark.arkcreditservice.goods.dao;

import com.cryptal.ark.arkcreditservice.goods.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductEntity,Long> {
}
