package com.alamnr.flyway.repository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.alamnr.flyway.domain.Order;

@DataJpaTest(properties={"spring.test.database.replace=NONE",
"spring.datasource.url=jdbc:tc:postgresql:12:///springboot"})
public class OrderRepositoryShortTest {
    
    @Autowired
    private OrderRepository orderRepository;

    @Disabled
    @Test 
    @Sql("/script/INIT_THREE_ORDERS.sql")
    void shouldReturnOrdersThatContainMacBookPro(){
        List<Order> orders = orderRepository.findAllContainingMacBookPro();
        assertEquals(2, orders.size());
    }
}
