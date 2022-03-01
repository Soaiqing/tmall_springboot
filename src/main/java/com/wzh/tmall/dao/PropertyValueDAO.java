

package com.wzh.tmall.dao;
 

import java.util.List;

import com.wzh.tmall.pojo.Product;
import com.wzh.tmall.pojo.Property;
import com.wzh.tmall.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer>{

	List<PropertyValue> findByProductOrderByIdDesc(Product product);
	PropertyValue getByPropertyAndProduct(Property property, Product product);

	
	
	
}


