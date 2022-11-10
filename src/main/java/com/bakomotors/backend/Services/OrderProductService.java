package com.bakomotors.backend.Services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bakomotors.backend.Model.OrderProduct;
import com.bakomotors.backend.Repositories.OrderProductRepository;

import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<OrderProduct> findOrderProductsById(Long id){
        return orderProductRepository.findOrderProducts(id);
    }
}
