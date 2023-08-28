package com.sd.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.ecommerce.dto.UserPaymentDTO;
import com.sd.ecommerce.dto.Mapper.UserPaymentMapper;
import com.sd.ecommerce.exception.ResourceNotFoundException;
import com.sd.ecommerce.model.UserPayment;
import com.sd.ecommerce.repository.UserPaymentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// import org.springframework.security.crypto.bcrypt.BCrypt;

@RequiredArgsConstructor
@Service // This annotation marks this class as a service class. Service classes are classes that contain the business logic of the application.
@Transactional // This means that every method inside this class will be wrapped in a transaction. Transaction is a set of operations that should be performed as one. If one of the operations fails, then the whole transaction fails.
@Slf4j
public class UserPaymentService {

    private final UserPaymentRepository userPaymentRepository;
    private final UserPaymentMapper userPaymentMapper;
    
    public UserPaymentDTO save(UserPaymentDTO userPaymentDTO) {
        log.info("Saving new UserPayment {} to the database", userPaymentDTO.getId());
        return userPaymentMapper.convertToDTO(userPaymentRepository.save(userPaymentMapper.convertToEntity(userPaymentDTO)));
    }

    public UserPaymentDTO get(Long id) {
        log.info("Fetching UserPayment {}", id);
        return userPaymentMapper.convertToDTO(userPaymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserPayment with provided ID not found")));
    }

    public List<UserPaymentDTO> list() {
        log.info("Fetching all UserPayments");
        return userPaymentMapper.convertToDTO((List<UserPayment>) userPaymentRepository.findAll());
    }

    public UserPaymentDTO update(Long id, UserPaymentDTO userPaymentDTO) {
        log.info("Updating UserPayment {}", id);
        UserPayment existingUserPayment = userPaymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserPayment with provided ID not found"));
        existingUserPayment.setUser(userPaymentDTO.getUser());
        existingUserPayment.setPaymentType(userPaymentDTO.getPaymentType());
        existingUserPayment.setProvider(userPaymentDTO.getProvider());
        existingUserPayment.setAccount_no(userPaymentDTO.getAccount_no());
        existingUserPayment.setExpiry_date(userPaymentDTO.getExpiry_date());
        return userPaymentMapper.convertToDTO(userPaymentRepository.save(existingUserPayment));
    }

    public UserPaymentDTO delete(Long id) {
        log.info("Deleting UserPayment {}", id);
        UserPayment existingUserPayment = userPaymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserPayment with provided ID not found"));
        userPaymentRepository.deleteById(id);
        return userPaymentMapper.convertToDTO(existingUserPayment);
    }
}
