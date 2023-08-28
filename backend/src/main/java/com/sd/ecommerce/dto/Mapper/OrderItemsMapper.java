package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.OrderItemsDTO;
import com.sd.ecommerce.model.OrderItems;

@Component
public class OrderItemsMapper {
    
    public OrderItems convertToEntity(OrderItemsDTO orderItemsDTO) {
        OrderItems orderItems = new OrderItems();
        orderItems.setId(orderItemsDTO.getId()); // TODO - is this needed?
        orderItems.setOrderDetails(orderItemsDTO.getOrderDetails());
        orderItems.setProduct(orderItemsDTO.getProduct());
        orderItems.setQuantity(orderItemsDTO.getQuantity());
        return orderItems;
    }

    public OrderItemsDTO convertToDTO(OrderItems orderItems) {
        return new OrderItemsDTO(orderItems.getId(), orderItems.getCreatedAt(), orderItems.getUpdatedAt(), orderItems.getOrderDetails(), orderItems.getProduct(), orderItems.getQuantity());
    }

    public List<OrderItemsDTO> convertToDTO(List<OrderItems> orderItems) {
        return orderItems.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
}
