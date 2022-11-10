package com.bakomotors.backend.Controller;



import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.bakomotors.backend.Model.OrderProduct;
import com.bakomotors.backend.Services.OrderProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orderProduct")
@RequiredArgsConstructor
public class OrderProductController {

    private final OrderProductService orderProductService;

    @GetMapping("/{id}")
    public List<OrderProduct> findAllByOrderId(@PathVariable Long id){
        return orderProductService.findOrderProductsById(id);
    }
}
