package com.deepmetis.sandwichordermanagement.services.impl;

import com.deepmetis.sandwichordermanagement.domain.entities.Order;
import com.deepmetis.sandwichordermanagement.domain.repositories.OrderRepository;
import com.deepmetis.sandwichordermanagement.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
