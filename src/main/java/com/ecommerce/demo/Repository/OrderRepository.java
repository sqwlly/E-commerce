package com.ecommerce.demo.Repository;

import com.ecommerce.demo.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, String> {
    @Override
    void  delete(Order order);

    List<Order> findByUserName(String userName);

    Order findByOrderId(long orderId);
}
