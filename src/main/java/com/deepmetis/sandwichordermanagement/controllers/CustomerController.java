package com.deepmetis.sandwichordermanagement.controllers;

import com.deepmetis.sandwichordermanagement.config.annotations.CurrentUser;
import com.deepmetis.sandwichordermanagement.config.annotations.HasRole;
import com.deepmetis.sandwichordermanagement.domain.entities.Order;
import com.deepmetis.sandwichordermanagement.domain.entities.User;
import com.deepmetis.sandwichordermanagement.dto.request.OrderItem;
import com.deepmetis.sandwichordermanagement.dto.response.ApiResponse;
import com.deepmetis.sandwichordermanagement.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final OrderService orderService;

    @PostMapping("/order/new")
    @HasRole("USER")
    public ResponseEntity<?> placeOrder(@CurrentUser User user, @RequestBody List<OrderItem> ingredients) {
        var order = Order.builder()
                .id(UUID.randomUUID().toString())
                .customerId(user.getId())
                .ingredients(
                        ingredients.stream().map(OrderItem::ingredient).toList().toArray(new String[0])
                )
                .price(
                        ingredients.stream().map(OrderItem::price).reduce(0f, Float::sum) * 1.3f
                )
                .createdAt(LocalDateTime.now().toString())
                .build();
        orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Order Placed", true));
    }

}
