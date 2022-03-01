

package com.wzh.tmall.dao;
 
import java.util.List;

import com.wzh.tmall.pojo.Product;
import com.wzh.tmall.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<Review,Integer>{

	List<Review> findByProductOrderByIdDesc(Product product);
	int countByProduct(Product product);

}


