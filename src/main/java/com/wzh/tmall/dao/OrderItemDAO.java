

package com.wzh.tmall.dao;

import java.util.List;

import com.wzh.tmall.pojo.Order;
import com.wzh.tmall.pojo.OrderItem;
import com.wzh.tmall.pojo.Product;
import com.wzh.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
	List<OrderItem> findByOrderOrderByIdDesc(Order order);
	List<OrderItem> findByProduct(Product product);
	List<OrderItem> findByUserAndOrderIsNull(User user);
}


