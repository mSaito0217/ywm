package com.yamamotokogyo.ywm.controller.service.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamamotokogyo.ywm.controller.repository.orders.OrderRepository;
import com.yamamotokogyo.ywm.model.orders.Order;

/**
 * Orderエンティティに関するサービスクラス
 */
@Service
public class OrderService {
	@Autowired 
	private OrderRepository orderRepository;
	
	//全件検索
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
}
