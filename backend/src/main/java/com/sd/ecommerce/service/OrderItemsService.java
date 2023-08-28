package com.sd.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.OrderItemsDTO;
import com.sd.ecommerce.dto.Mapper.OrderItemsMapper;
import com.sd.ecommerce.model.OrderItems;
import com.sd.ecommerce.repository.OrderItemsRepository;
import com.sd.ecommerce.util.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// import org.springframework.security.crypto.bcrypt.BCrypt;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class OrderItemsService {

    private final OrderItemsRepository orderItemsRepository;
    private final OrderItemsMapper orderItemsMapper;

    public OrderItemsDTO save(OrderItemsDTO orderItemsDTO) {
        log.info("Saving new OrderItems {} to the database", orderItemsDTO.getId());
        return orderItemsMapper.convertToDTO(orderItemsRepository.save(orderItemsMapper.convertToEntity(orderItemsDTO)));
    }

    public OrderItemsDTO get(Long id) {
        log.info("Fetching OrderItems {}", id);
        return orderItemsMapper.convertToDTO(orderItemsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItems with provided ID not found")));
    }

    public List<OrderItemsDTO> list() {
        log.info("Fetching all OrderItemss");
        return orderItemsMapper.convertToDTO((List<OrderItems>) orderItemsRepository.findAll());
    }

    public OrderItemsDTO update(OrderItemsDTO orderItemsDTO) {
        log.info("Updating OrderItems {}", orderItemsDTO.getId());
        OrderItems existingOrderItems = orderItemsRepository.findById(orderItemsDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("OrderItems with provided ID not found"));
        existingOrderItems.setOrderDetails(orderItemsDTO.getOrderDetails());
        existingOrderItems.setProduct(orderItemsDTO.getProduct());
        existingOrderItems.setQuantity(orderItemsDTO.getQuantity());
        return orderItemsMapper.convertToDTO(orderItemsRepository.save(existingOrderItems));

    }

    public OrderItemsDTO delete(Long id) {
        log.info("Deleting OrderItems {}", id);
        OrderItems existingOrderItems = orderItemsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrderItems with provided ID not found"));
        orderItemsRepository.deleteById(id);
        return orderItemsMapper.convertToDTO(existingOrderItems);
    }
    
}
