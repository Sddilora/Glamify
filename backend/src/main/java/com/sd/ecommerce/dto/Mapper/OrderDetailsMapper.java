package com.sd.ecommerce.dto.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sd.ecommerce.dto.OrderDetailsDTO;
import com.sd.ecommerce.model.OrderDetails;

@Component
public class OrderDetailsMapper {

    public OrderDetails convertToEntity(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(orderDetailsDTO.getId()); // TODO - is this needed?
        orderDetails.setUser(orderDetailsDTO.getUser());
        orderDetails.setTotal(orderDetailsDTO.getTotal());
        orderDetails.setPaymentDetails(orderDetailsDTO.getPaymentDetails());
        return orderDetails;
    }

    public OrderDetailsDTO convertToDTO(OrderDetails orderDetails) {
        return new OrderDetailsDTO(orderDetails.getId(), orderDetails.getCreatedAt(), orderDetails.getUpdatedAt(),orderDetails.getUser(), orderDetails.getTotal(), orderDetails.getPaymentDetails());
    }

    public List<OrderDetailsDTO> convertToDTO(List<OrderDetails> orderDetails) {
        return orderDetails.stream().map(this::convertToDTO).collect(java.util.stream.Collectors.toList());
    }
}
