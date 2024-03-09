package com.deepmetis.sandwichordermanagement.domain.repositories;

import com.deepmetis.sandwichordermanagement.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
