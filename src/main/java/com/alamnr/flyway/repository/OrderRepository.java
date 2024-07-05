package com.alamnr.flyway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alamnr.flyway.domain.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
    @Query(value="""
            SELECT * 
            FROM orders
            WHERE items @> '[{"name":"MacBook Pro"}]';
            """, nativeQuery=true)
    List<Order> findAllContainingMacBookPro();
}
