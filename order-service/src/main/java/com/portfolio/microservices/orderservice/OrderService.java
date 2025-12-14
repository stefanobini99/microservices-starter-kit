package com.portfolio.microservices.orderservice;

import com.portfolio.microservices.orderservice.client.ProductClient;
import com.portfolio.microservices.orderservice.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public void placeOrder(OrderRequest orderRequest) {
        var product = productClient.getProductById(orderRequest.productId());

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .skuCode(product.name())
                .price(product.price())
                .quantity(orderRequest.quantity())
                .orderDate(LocalDateTime.now())
                .build();

        orderRepository.save(order);
    }
}