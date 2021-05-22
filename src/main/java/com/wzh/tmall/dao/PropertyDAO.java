/**
* 模仿天猫整站 springboot 教程 为 wzh 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.wzh.tmall.dao;
 
import java.util.List;

import com.wzh.tmall.pojo.Category;
import com.wzh.tmall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyDAO extends JpaRepository<Property,Integer>{
	Page<Property> findByCategory(Category category, Pageable pageable);
	List<Property> findByCategory(Category category);

}

/**
* 模仿天猫整站 springboot 教程 为 wzh 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
