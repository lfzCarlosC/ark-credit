package com.cryptal.ark.arkcreditservice.goods.dao;

import com.cryptal.ark.arkcreditservice.goods.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsDao extends JpaRepository<Goods,Long> {
}
