package com.portfolio.microservices.orderservice.dto;

public record OrderRequest(Long productId, Integer quantity) {
}