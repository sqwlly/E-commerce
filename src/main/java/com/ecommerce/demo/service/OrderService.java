package com.ecommerce.demo.service;

import com.ecommerce.demo.Repository.OrderRepository;
import com.ecommerce.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findAll() {
        var it = orderRepository.findAll();
        var orders = new ArrayList<Order>();
        it.forEach(e -> orders.add(e));
        return orders;
    }

    public Order findByOrderId(long orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    public Long count() {
        return orderRepository.count();
    }

    public List<Order> findByUserName(String userName) {
        return orderRepository.findByUserName(userName);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
