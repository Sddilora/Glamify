package com.sd.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.OrderDetailsDTO;
import com.sd.ecommerce.dto.Mapper.OrderDetailsMapper;
import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.OrderDetails;
import com.sd.ecommerce.repository.OrderDetailsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// import org.springframework.security.crypto.bcrypt.BCrypt;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;
    private final OrderDetailsMapper orderDetailsMapper;

    public OrderDetailsDTO save(OrderDetailsDTO orderDetailsDTO) {
        log.info("Saving new OrderDetails {} to the database", orderDetailsDTO.getId());
        return orderDetailsMapper.convertToDTO(orderDetailsRepository.save(orderDetailsMapper.convertToEntity(orderDetailsDTO)));
    }
 
    public OrderDetailsDTO get(Long id) {
        log.info("Fetching OrderDetails {}", id);
        return orderDetailsMapper.convertToDTO(orderDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderDetails with provided ID not found")));
    }

    public List<OrderDetailsDTO> list() {
        log.info("Fetching all OrderDetailss");
        return orderDetailsMapper.convertToDTO((List<OrderDetails>) orderDetailsRepository.findAll());
    }

    public OrderDetailsDTO update(Long id, OrderDetailsDTO orderDetailsDTO) {
        log.info("Updating OrderDetails {}", id);
        OrderDetails existingOrderDetails = orderDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderDetails with provided ID not found"));
        existingOrderDetails.setUser(orderDetailsDTO.getUser());
        existingOrderDetails.setTotal(orderDetailsDTO.getTotal());
        existingOrderDetails.setPaymentDetails(orderDetailsDTO.getPaymentDetails());
        return orderDetailsMapper.convertToDTO(orderDetailsRepository.save(existingOrderDetails));

    }

    public OrderDetailsDTO delete(Long id) {
        log.info("Deleting OrderDetails {}", id);
        OrderDetails existingOrderDetails = orderDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderDetails with provided ID not found"));
        orderDetailsRepository.deleteById(id);
        return orderDetailsMapper.convertToDTO(existingOrderDetails);
    }
}
