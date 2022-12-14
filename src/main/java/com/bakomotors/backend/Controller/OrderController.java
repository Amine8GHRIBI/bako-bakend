package com.bakomotors.backend.Controller;


import com.bakomotors.backend.Model.Order;
import com.bakomotors.backend.Services.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> createUserRequest(@RequestParam("order") String data) throws IOException {
        Order order = new ObjectMapper().readValue(data, Order.class);
        return orderService.createOrder(order);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @GetMapping(value = "/{id}")
    public Iterable<Order> getOrders(@PathVariable Long id){
        return orderService.findAllByUserId(id);
    }

    @GetMapping(value = "")
    public List<Order> getOrders(){
        return orderService.findAll();
    }
}
