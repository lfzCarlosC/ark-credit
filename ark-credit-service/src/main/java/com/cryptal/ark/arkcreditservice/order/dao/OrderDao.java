package com.cryptal.ark.arkcreditservice.order.dao;

import com.cryptal.ark.arkcreditservice.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {

}
