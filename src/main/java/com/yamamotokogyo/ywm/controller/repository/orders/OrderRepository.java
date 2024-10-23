package com.yamamotokogyo.ywm.controller.repository.orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yamamotokogyo.ywm.model.orders.Order;

/**
 * Orderエンティティに関するリポジトリインターフェース
 */
public interface OrderRepository extends JpaRepository<Order, String> {
	// 全件取得するメソッド
	List<Order> findAll();
}
