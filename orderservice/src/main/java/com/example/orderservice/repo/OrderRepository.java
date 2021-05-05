package com.example.orderservice.repo;

import com.example.orderservice.model.orderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<orderModel,Integer> {
        @Query
        public orderModel findByOrderId(Integer id);
        @Query
        public orderModel deleteByOrderId(Integer id);

}
