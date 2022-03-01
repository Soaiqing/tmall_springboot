

package com.wzh.tmall.dao;
 
import java.util.List;

import com.wzh.tmall.pojo.Order;
import com.wzh.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order,Integer>{
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}


